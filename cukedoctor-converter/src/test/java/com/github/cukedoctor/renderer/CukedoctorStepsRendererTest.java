package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.spi.StepsRenderer;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class CukedoctorStepsRendererTest {

    @Test
    public void shouldRenderFeatureStepsWithOnePassingStep() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
        List<Feature> features = new ArrayList<>();
        features.add(feature);

        StepsRenderer stepsRenderer = new CukedoctorStepsRenderer();

        List<Step> steps = feature.getScenarios().get(0).getSteps();
        String resultDoc = stepsRenderer.renderSteps(steps, feature.getScenarios().get(0), feature, CukedoctorDocumentBuilder.Factory.newInstance());
        assertThat(resultDoc).isEqualTo("==========" + newLine() +
                "Given::" + newLine() +

                "passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +

                "==========" + newLine() + newLine());
    }

    @Test
    public void shouldRenderFeatureStepsWithOnePassingAndOneFailingStep() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingAndOneFailingStep();
        List<Feature> features = new ArrayList<>();
        features.add(feature);

        List<Step> steps = feature.getScenarios().get(0).getSteps();
        StepsRenderer stepsRenderer = new CukedoctorStepsRenderer();

        String resultDoc = stepsRenderer.renderSteps(steps, feature.getScenarios().get(0), feature, CukedoctorDocumentBuilder.Factory.newInstance());
        assertThat(resultDoc).isEqualTo("==========" + newLine() +
                "Given::" + newLine() +

                "passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +

                "When::" + newLine() +

                "failing step icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(000ms)#" + newLine() +

                "==========" + newLine() + newLine());
    }
}