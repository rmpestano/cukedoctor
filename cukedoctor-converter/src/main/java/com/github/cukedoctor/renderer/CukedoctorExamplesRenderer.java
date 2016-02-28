package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.model.Example;
import com.github.cukedoctor.api.model.Row;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.spi.ExamplesRenderer;

import static com.github.cukedoctor.util.Constants.Markup.table;
import static com.github.cukedoctor.util.Constants.Markup.tableCol;
import static com.github.cukedoctor.util.Constants.newLine;

/**
 * Created by pestano on 28/02/16.
 */
public class CukedoctorExamplesRenderer extends AbstractBaseRenderer implements ExamplesRenderer {


    @Override
    public String renderScenarioExamples(Scenario scenario) {
        docBuilder.clear();
        if (scenario.hasExamples()) {
            docBuilder.newLine();
            for (Example example : scenario.getExamples()) {
                docBuilder.append("." + (example.getName() == null || "".equals(example.getName()) ? "Example" : example.getName()), newLine());
                docBuilder.append("[cols=\"" + example.getRows()[0].getCells().length + "*\", options=\"header\"]", newLine());
                docBuilder.append(table(), newLine());
                Row header = example.getRows()[0];
                for (String col : header.getCells()) {
                    docBuilder.append(tableCol(), col, newLine());
                }

                for (int i = 1; i < example.getRows().length; i++) {
                    for (String cell : example.getRows()[i].getCells()) {
                        docBuilder.append(tableCol(), cell, newLine());
                    }
                }
                docBuilder.append(table(), newLine(),newLine());
            }
        }
        return docBuilder.toString();
    }
}
