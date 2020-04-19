package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.*;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.spi.StepsRenderer;
import com.github.cukedoctor.util.Constants;
import com.github.cukedoctor.util.Formatter;

import java.util.List;

import static com.github.cukedoctor.api.CukedoctorDocumentBuilder.Factory.newInstance;
import static com.github.cukedoctor.util.Assert.*;
import static com.github.cukedoctor.util.Constants.Markup.*;
import static com.github.cukedoctor.util.Constants.newLine;

/**
 * Created by pestano on 28/02/16.
 */
public class CukedoctorStepsRenderer extends AbstractBaseRenderer implements StepsRenderer {


    public CukedoctorStepsRenderer() {
    }

    public CukedoctorStepsRenderer(CukedoctorConfig cukedoctorConfig) {
        this.cukedoctorConfig = cukedoctorConfig;
    }

    @Override
    public String renderSteps(List<Step> steps, Scenario scenario, Feature feature) {
        docBuilder.clear();

        docBuilder.textLine("==========");
        for (Step step : steps) {
            docBuilder.append(step.getKeyword(), "::", newLine());
            docBuilder.append(step.getName() + " ", Status.getStatusIcon(step.getStatus()));
            if(!cukedoctorConfig.isHideStepTime()){
                docBuilder.append(renderStepTime(step.getResult()));
            }

            docBuilder.append(renderStepTable(step));

            if (notNull(step.getDocString()) && hasText(step.getDocString().getValue())) {
                if(step.getDocString().isDiscrete() || step.hasDiscreteComment() || isDiscrete(scenario) || isDiscrete(feature)) {
                    //discrete step renders inside a sidebar block and has [discrete] class on every line
                    renderDiscreteSidebarBlock(step.getDocString());

                } else{
                    renderListingBlock(step.getDocString());
                }

            }

            if (step.getResult() != null && !Status.passed.equals(step.getStatus())) {
                if (step.getResult().getErrorMessage() != null) {
                    docBuilder.append(newLine(), "IMPORTANT: ", step.getResult().getErrorMessage(), newLine());
                }
            }
            renderOutput(step);
            enrichStep(step);
        }
        docBuilder.textLine("==========").newLine();

        return docBuilder.toString();
    }

    private boolean isDiscrete(Scenario scenario) {
        if (!scenario.hasTags()) return false;
        return isDiscrete(scenario.getTags());
    }

    private boolean isDiscrete(Feature feature) {
        if (!feature.hasTags()) return false;
        return isDiscrete(feature.getTags());
    }

    private boolean isDiscrete(Iterable<Tag> tags) {
        for (Tag tag : tags) {
            if (tag.isDiscrete()) return true;
        }

        return false;
    }

    void renderOutput(Step step) {
        if(step.hasOutput()){
            docBuilder.textLine(listing());
            for (Output output : step.getOutput()) {
                docBuilder.textLine(output.getValue());
            }
            docBuilder.textLine(listing());
        }
    }

    private void renderListingBlock(DocString docString) {
        if(docString.getContentType() != null && !docString.getContentType().equals("")) {
            docBuilder.append("[source,", docString.getContentType(), "]", newLine());
        }
        docBuilder.append(listing(), newLine(), newLine());
        docBuilder.append(docString.getValue().replaceAll("\\n", newLine()));
        docBuilder.append(newLine(), newLine(), listing(), newLine());
    }

    private void renderDiscreteSidebarBlock(DocString docString) {
        docBuilder.append("******", newLine(), newLine());

        String[] lines = docString.getValue().replaceAll("\\*\\*\\*\\*","*****").replaceAll(Constants.Markup.exampleBlock(),Constants.Markup.exampleBlock()+"=").split("\\n");

        //every line that starts with \n and not contains pipe(|) will have discrete class
        // pipe is skipped because it denotes table cells in asciidoc and putting
        // a discrete class will break tables
        //also includes are skipped
        //regex try:("^(?=.*^\\n)(?!\\n\\|).*$")
        boolean isListing = false; //control if line is inside a listing
        boolean isTable = false;//control if line is inside a table

        for (String line : lines) {

            if(!isListing){
                line = line.replaceAll("\r", "");
            }
            if(isListing){
                if(line.contains("----")){
                    //end listing
                    isListing = false;
                }
                docBuilder.textLine(line);
                continue;
            }

            if(!isListing && line.contains("----")){
                isListing = true;
                docBuilder.textLine(line);
                continue;
            }

            //do not add discrete to callouts
            if(line.startsWith("<") && line.endsWith(">")){
                docBuilder.textLine(line);
                continue;
            }
            //do not add discrete to complex blocks otherwise it will produce invalid markup like below:
            /**
             * [discrete]
               [IMPORTANT]
               [discrete]
                ======
             */
            if(line.startsWith("======")){
                docBuilder.textLine(line);
                continue;
            }

            if(isTable){
                //skip discrete class when within a table
                docBuilder.textLine(line);
                if(line.contains(table())){
                    isTable = false;//end table
                }
                continue;
            }

            //skips discrete class for table col (it must add discrete to table itself)
            if(line.contains(table())) {
                isTable = true;
            }
            //not inside a table neither listing then add discrete class to line
            docBuilder.textLine(Constants.DISCRETE).textLine(line);
        }
        docBuilder.append(newLine(), newLine(), "******", newLine());
    }

    private void enrichStep(Step step) {
       if(step != null && step.hasComments()){
           int numComments = step.getComments().size();
           for (Comment comment : step.getComments()) {
               if(hasText(comment.getValue()) && (comment.getValue().contains("{") && comment.getValue().contains("}"))){
                   String line = comment.getValue();
                   //do not add new line for listing, complex blocks, callouts
                   if(comment.getValue().contains("[source") ||
                       line.contains("====") || line.contains(Constants.Markup.listing())
                       || (line.startsWith("<") && line.endsWith(">"))
                       ){
                       docBuilder.textLine(line.replaceAll("\\n", newLine()).
                           replaceAll("#\\{", "").replaceAll("# \\{", "").
                           replaceAll("}", ""));
                   } else{
                       docBuilder.textLine(line.replaceAll("\\n", newLine()).
                           replaceAll("#\\{", newLine()).replaceAll("# \\{", newLine()).
                           replaceAll("}", ""));
                   }

               }
               //add new line to last comment
               if(step.getComments().indexOf(comment) == numComments-1){
                     docBuilder.newLine();
               }
        }
       }

    }

    String renderStepTime(Result result) {
        if (result == null || result.getDuration() == null) {
            return "";
        }
        return " [small right]#(" + Formatter.formatTime(result.getDuration()) + ")#";
    }

    String renderStepTable(Step step) {
        //TODO convert to AsciidocBuilder
        CukedoctorDocumentBuilder builder = newInstance();
        builder.newLine();
        if (notEmpty(step.getRows())) {
            builder.newLine();
            builder.append("[cols=\"" + step.getRows()[0].getCells().length + "*\", options=\"header\"]").newLine();
            builder.textLine(table());
            Row header = step.getRows()[0];
            for (String col : header.getCells()) {
                builder.append(tableCol(), col).newLine();
            }

            for (int i = 1; i < step.getRows().length; i++) {
                for (String cell : step.getRows()[i].getCells()) {
                    builder.append(tableCol(), cell).newLine();
                }
            }
            builder.textLine(table());
            builder.newLine();
        }

        return builder.toString();
    }
}
