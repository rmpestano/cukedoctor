package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.*;
import com.github.cukedoctor.spi.StepsRenderer;
import com.github.cukedoctor.util.Assert;
import com.github.cukedoctor.util.Constants;
import com.github.cukedoctor.util.Formatter;

import java.util.List;
import java.util.regex.Pattern;

import static com.github.cukedoctor.api.CukedoctorDocumentBuilder.Factory.newInstance;
import static com.github.cukedoctor.util.Assert.*;
import static com.github.cukedoctor.util.Constants.Markup.*;
import static com.github.cukedoctor.util.Constants.newLine;

/**
 * Created by pestano on 28/02/16.
 */
public class CukedoctorStepsRenderer extends AbstractBaseRenderer implements StepsRenderer {

    @Override
    public String renderSteps(List<Step> steps) {
        docBuilder.clear();

        docBuilder.textLine("****");
        for (Step step : steps) {
            docBuilder.append(step.getKeyword(), "::", newLine());
            docBuilder.append(step.getName() + " ", Status.getStatusIcon(step.getStatus()));
            docBuilder.append(renderStepTime(step.getResult()));

            docBuilder.append(renderStepTable(step));

            if (notNull(step.getDocString()) && hasText(step.getDocString().getValue())) {
                if(step.hasDiscreteComment()){
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
            enrichStep(step);
        }
        docBuilder.textLine("****").newLine();

        return docBuilder.toString();
    }


    private void renderListingBlock(DocString docString) {
        docBuilder.append(listing(), newLine(), newLine());
        docBuilder.append(docString.getValue().replaceAll("\\n", newLine()));
        docBuilder.append(newLine(), newLine(), listing(), newLine());
    }

    private void renderDiscreteSidebarBlock(DocString docString) {
        docBuilder.append("******", newLine(), newLine());

        String[] lines = docString.getValue().replaceAll("\\*\\*\\*\\*","*****").split("\\n");

        //every line that starts with \n and not contains pipe(|) will have discrete class
        // pipe is skipped because it denotes table cells in asciidoc and putting
        // a discrete class will break tables
        //also includes are skiped
        //regex try:("^(?=.*^\\n)(?!^\\n\\|).*")

        for (String line : lines) {
            if(line.isEmpty() || line.contains("include::")){
                continue;
            }
            if(line.contains("|")){
               docBuilder.textLine(line);
            }else{
                //does not contains pipe then use [discrete] class
                docBuilder.textLine(Constants.DISCRETE).textLine(line);
            }
        }
        docBuilder.append(newLine(), newLine(), "******", newLine());
    }

    private void enrichStep(Step step) {
       if(step != null && step.hasComments()){
           int numComments = step.getComments().size();
           for (Comment comment : step.getComments()) {
               if(hasText(comment.getValue()) && (comment.getValue().contains("{") && comment.getValue().contains("}"))){
                   docBuilder.textLine(comment.getValue().replaceAll("\\n", newLine()).replaceAll("#", "").
                       replaceAll("\\{", newLine()).
                       replaceAll("}", ""));
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
