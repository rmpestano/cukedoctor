package com.github.cukedoctor.example.spi;

import static com.github.cukedoctor.util.Constants.Markup.H2;
import static com.github.cukedoctor.util.Constants.Markup.bold;
import static com.github.cukedoctor.util.Constants.newLine;

import java.util.List;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.ScenarioTotalizations;
import com.github.cukedoctor.renderer.AbstractBaseRenderer;
import com.github.cukedoctor.spi.SummaryRenderer;

/**
 * Created by pestano on 27/02/16.
 */
public class CustomSummaryRenderer extends AbstractBaseRenderer implements SummaryRenderer {

    @Override
    public String renderSummary(List<Feature> features) {
        docBuilder.textLine(H2(bold(i18n.getMessage("title.summary"))));
        docBuilder.textLine("This is a custom summary renderer").newLine();
        docBuilder.textLine("Number of features: "+features.size());
        docBuilder.newLine();
        ScenarioTotalizations totalization = new ScenarioTotalizations(features);
        docBuilder.append("Passed steps: ",totalization.getTotalPassedSteps(),newLine())
                .append(newLine()).append("Failed steps: ", totalization.getTotalFailedSteps(),newLine());
        return docBuilder.toString();
    }
}
