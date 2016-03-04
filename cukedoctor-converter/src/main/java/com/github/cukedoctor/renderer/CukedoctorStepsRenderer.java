package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Comment;
import com.github.cukedoctor.api.model.Result;
import com.github.cukedoctor.api.model.Row;
import com.github.cukedoctor.api.model.Status;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.spi.StepsRenderer;
import com.github.cukedoctor.util.Assert;
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
                docBuilder.append(listing(), newLine(), newLine());
                docBuilder.append(step.getDocString().getValue().replaceAll("\\n", newLine()));
                docBuilder.append(newLine(), newLine(), listing(), newLine());
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
