package com.github.cukedoctor.example.spi;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.renderer.CukedoctorFeatureRenderer;
import com.github.cukedoctor.spi.ScenarioRenderer;

import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Constants.Markup.bold;
import static com.github.cukedoctor.util.Constants.newLine;

/**
 * Created by pestano on 29/02/16.
 * <p>
 * renders features as <a href="http://asciidoctor.org/docs/user-manual/#labeled-list">labeled list</a>
 * <p>
 * Template
 * <p>
 * Feature1::
 * +
 * ****
 * feature description
 * ****
 * Scenario1:::
 * +
 * ****
 * * Step1
 * * Step2
 * * StepN
 * ****
 * Scenario2:::
 * +
 * ****
 * * Step1
 * * Step2
 * ****
 * <p>
 * Feature2:::
 * //same as above
 */
public class CustomFeatureRenderer extends CukedoctorFeatureRenderer {

    @Override
    public String renderFeature(Feature feature) {
        CukedoctorDocumentBuilder builder = docBuilder.createPeerBuilder();
        builder.textLine((bold(feature.getName())) + "::").newLine();
        if (hasText(feature.getDescription())) {
            builder.append("+").sideBarBlock(feature.getDescription().trim().replaceAll("\\n", " +" + newLine()));
        }

        if (feature.hasScenarios()) {

            ScenarioRenderer scenarioRenderer = new CustomScenarioRenderer();
            for (Scenario scenario : feature.getScenarios()) {
                builder.append(scenarioRenderer.renderScenario(scenario, feature, docBuilder.createPeerBuilder()));
            }
        }

        return builder.toString();
    }
}
