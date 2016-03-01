package com.github.cukedoctor.example.spi;

import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Constants.Markup.bold;
import static com.github.cukedoctor.util.Constants.newLine;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.renderer.CukedoctorFeatureRenderer;
import com.github.cukedoctor.spi.ScenarioRenderer;

/**
 * Created by pestano on 29/02/16.
 *
 * renders features as labeled list: http://asciidoctor.org/docs/user-manual/#labeled-list
 *
 * Template
 *
 * Feature1::
 * +
 * ****
 * feature description
 * ****
 *   Scenario1:::
 *     +
 *     ****
 *      * Step1
 *      * Step2
 *      * StepN
 *     ****
 *   Scenario2:::
 *     +
 *     ****
 *      * Step1
 *      * Step2
 *     ****
 *
 *  Feature2:::
 *    //same as above
 *
 */
public class CustomFeatureRenderer extends CukedoctorFeatureRenderer {


    @Override
    public String renderFeature(Feature feature) {
        docBuilder.textLine((bold(feature.getName()))+"::").newLine();
        if (hasText(feature.getDescription())) {
            docBuilder.append("+").sideBarBlock(feature.getDescription().trim().replaceAll("\\n", " +" + newLine()));
        }

        if(feature.hasScenarios()){

            ScenarioRenderer scenarioRenderer = new CustomScenarioRenderer();
            for (Scenario scenario : feature.getScenarios()) {
                docBuilder.append(scenarioRenderer.renderScenario(scenario,feature));
            }
        }

        return docBuilder.toString();
    }
}
