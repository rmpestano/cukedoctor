package com.github.cukedoctor.example.spi;

import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Constants.newLine;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.renderer.CukedoctorScenarioRenderer;
import com.github.cukedoctor.renderer.CukedoctorStepsRenderer;
import com.github.cukedoctor.spi.StepsRenderer;

/**
 * Created by pestano on 29/02/16.
 */
public class CustomScenarioRenderer extends CukedoctorScenarioRenderer{

    @Override
    public String renderScenario(Scenario scenario, Feature feature) {
        //need to clear because we will execute this method in a for loop
        //and contents will be appended
        docBuilder.clear();
        docBuilder.append("  "+scenario.getName()+":::",newLine());
        if(hasText(scenario.getDescription())){
            docBuilder.textLine(scenario.getDescription());
        }
        if(scenario.hasSteps()) {
            //here we will reuse builtin step renderer
            docBuilder.textLine("+");
            StepsRenderer stepsRenderer = new CukedoctorStepsRenderer();
            docBuilder.append(stepsRenderer.renderSteps(scenario.getSteps()));
        }
        return docBuilder.toString();
    }
}
