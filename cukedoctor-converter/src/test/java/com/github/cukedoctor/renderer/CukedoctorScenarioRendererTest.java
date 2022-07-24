package com.github.cukedoctor.renderer;

import static com.github.cukedoctor.renderer.Fixtures.outline;
import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CukedoctorScenarioRendererTest {

  @Test
  public void shouldRenderFeatureStepsWithOneScenarioWithMultipleStep() {
    final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithMultipleSteps();
    List<Feature> features = new ArrayList<>();
    features.add(feature);
    List<Step> steps = feature.getScenarios().get(0).getSteps();
    CukedoctorStepsRenderer stepsRenderer = new CukedoctorStepsRenderer();
    String resultDoc = stepsRenderer.renderSteps(steps, feature.getScenarios().get(0), feature);
    assertThat(resultDoc)
        .isEqualTo(
            "=========="
                + newLine()
                + "Given::"
                + newLine()
                + "passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"
                + newLine()
                + "When::"
                + newLine()
                + "failing step icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(000ms)#"
                + newLine()
                + "When::"
                + newLine()
                + "pending step icon:thumbs-down[role=\"maroon\",title=\"Pending\"] [small right]#(000ms)#"
                + newLine()
                + "When::"
                + newLine()
                + "missing step icon:thumbs-down[role=\"blue\",title=\"Missing\"] [small right]#(000ms)#"
                + newLine()
                + "When::"
                + newLine()
                + "undefined step icon:thumbs-down[role=\"yellow\",title=\"Undefined\"] [small right]#(000ms)#"
                + newLine()
                + "Then::"
                + newLine()
                + "skipped step icon:thumbs-down[role=\"purple\",title=\"Skipped\"] [small right]#(000ms)#"
                + newLine()
                + "=========="
                + newLine()
                + newLine());
  }

  @Test
  public void shouldRenderScenarioExamples() {
    List<Feature> features = FeatureParser.parse(outline);
    assertThat(features).hasSize(1);
    CukedoctorExamplesRenderer examplesRenderer = new CukedoctorExamplesRenderer();
    String resultDoc =
        examplesRenderer.renderScenarioExamples(features.get(0).getElements().get(0));
    assertThat(resultDoc)
        .isEqualTo(
            ""
                + newLine()
                + ".examples1"
                + newLine()
                + "[cols=\"1*\", options=\"header\"]"
                + newLine()
                + "|==="
                + newLine()
                + "|status"
                + newLine()
                + "|passes"
                + newLine()
                + "|fails"
                + newLine()
                + "|==="
                + newLine()
                + ""
                + newLine()
                + ".examples2"
                + newLine()
                + "[cols=\"1*\", options=\"header\"]"
                + newLine()
                + "|==="
                + newLine()
                + "|status"
                + newLine()
                + "|passes"
                + newLine()
                + "|==="
                + newLine()
                + ""
                + newLine());
  }
}
