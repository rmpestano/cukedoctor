package com.github.cukedoctor.renderer;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.*;
import com.github.cukedoctor.config.GlobalConfig;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.spi.FeatureRenderer;
import com.github.cukedoctor.spi.StepsRenderer;
import com.github.cukedoctor.util.Constants;
import com.github.cukedoctor.util.Expectations;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import com.github.cukedoctor.util.builder.ScenarioBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * Created by pestano on 28/02/16.
 */
@RunWith(JUnit4.class)
public class RendererTest {

    private static String invalidFeatureResult;
    private static String featureWithTableInStep;
    private static String onePassingOneFailing;
    private static String embedDataDirectly;
    private static String outline;

    @BeforeClass
    public static void loadFeatures() {
        onePassingOneFailing = FileUtil.findJsonFile("target/test-classes/json-output/one_passing_one_failing.json");
        embedDataDirectly = FileUtil.findJsonFile("target/test-classes/json-output/embed_data_directly.json");
        outline = FileUtil.findJsonFile("target/test-classes/json-output/outline.json");
        invalidFeatureResult = FileUtil.findJsonFile("target/test-classes/json-output/invalid_feature_result.json");
        featureWithTableInStep = FileUtil.findJsonFile("target/test-classes/json-output/step-with-table.json");
    }


    @Test
    public void shouldRenderFeatureScenarios(){
        final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();

        CukedoctorScenarioRenderer scenarioRenderer = new CukedoctorScenarioRenderer();
        scenarioRenderer = spy(scenarioRenderer);
        doReturn("").when(scenarioRenderer).renderScenarioSteps(anyListOf(Step.class));
        doReturn("").when(scenarioRenderer).renderScenarioExamples(any(Scenario.class));
        doReturn("").when(scenarioRenderer).renderScenarioTags(any(Scenario.class),eq(feature));

        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        featureRenderer = spy(featureRenderer);
        featureRenderer.scenarioRenderer = scenarioRenderer;

        String resultDoc = featureRenderer.renderFeatureScenarios(feature);
        assertThat(resultDoc).isEqualTo("==== Scenario: scenario 1" + newLine() +
                "description" + newLine() + newLine() +
                "==== Scenario: scenario 2" + newLine() +
                "description 2" + newLine() + newLine());
    }

    @Test
    public void shouldRenderFeatureScenariosWithTagsInScenarios(){
        final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
        for (Scenario scenario : feature.getScenarios()) {
            ScenarioBuilder.instance(scenario).tag(new Tag("@Tag1")).tag(new Tag("@tag2"));
        }
        CukedoctorScenarioRenderer scenarioRenderer = new CukedoctorScenarioRenderer();
        scenarioRenderer = spy(scenarioRenderer);
        doReturn("").when(scenarioRenderer).renderScenarioSteps(anyListOf(Step.class));
        doReturn("").when(scenarioRenderer).renderScenarioExamples(any(Scenario.class));

        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        featureRenderer = spy(featureRenderer);
        featureRenderer.scenarioRenderer = scenarioRenderer;

        String resultDoc = featureRenderer.renderFeatureScenarios(feature);
        assertThat(resultDoc).isEqualTo("==== Scenario: scenario 1"+newLine() +
                "[small]#tags: @Tag1,@tag2#"+newLine() +
                ""+newLine() +
                "description"+newLine() + newLine() +
                "==== Scenario: scenario 2"+newLine() +
                "[small]#tags: @Tag1,@tag2#"+newLine() +
                ""+newLine() +
                "description 2"+newLine() + newLine());
    }

    @Test
    public void shouldRenderFeatureScenariosWithTagsInFeaturesAndScenarios(){
        final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
        feature.getTags().add(new Tag("@FeatureTag"));
        for (Scenario scenario : feature.getScenarios()) {
            ScenarioBuilder.instance(scenario).tag(new Tag("@Tag1")).tag(new Tag("@tag2"));
        }

        CukedoctorScenarioRenderer scenarioRenderer = new CukedoctorScenarioRenderer();
        scenarioRenderer = spy(scenarioRenderer);
        doReturn("").when(scenarioRenderer).renderScenarioSteps(anyListOf(Step.class));
        doReturn("").when(scenarioRenderer).renderScenarioExamples(any(Scenario.class));

        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        featureRenderer = spy(featureRenderer);
        featureRenderer.scenarioRenderer = scenarioRenderer;

        String resultDoc = featureRenderer.renderFeatureScenarios(feature);
        assertThat(resultDoc).isEqualTo("==== Scenario: scenario 1" + newLine() +
                "[small]#tags: @FeatureTag,@Tag1,@tag2#" + newLine() +
                "" + newLine() +
                "description" + newLine() + newLine() +
                "==== Scenario: scenario 2" + newLine() +
                "[small]#tags: @FeatureTag,@Tag1,@tag2#" + newLine() +
                "" + newLine() +
                "description 2" + newLine() + newLine());
    }

    @Test
    public void shouldRenderFeatureStepsWithOnePassingStep(){
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
        List<Feature> features = new ArrayList<>();
        features.add(feature);

        StepsRenderer stepsRenderer = new CukedoctorStepsRenderer();

        List<Step> steps = feature.getScenarios().get(0).getSteps();
        String resultDoc = stepsRenderer.renderSteps(steps);
        assertThat(resultDoc).isEqualTo("====" + newLine() +
                "Given::" + newLine() +
                
                "passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +
                
                "====" + newLine() + newLine());
    }

    @Test
    public void shouldRenderFeatureStepsWithOnePassingAndOneFailingStep(){
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingAndOneFailingStep();
        List<Feature> features = new ArrayList<>();
        features.add(feature);
       ;
        List<Step> steps = feature.getScenarios().get(0).getSteps();
        StepsRenderer stepsRenderer = new CukedoctorStepsRenderer();

        String resultDoc = stepsRenderer.renderSteps(steps);
        assertThat(resultDoc).isEqualTo("====" + newLine() +
                "Given::" + newLine() +
                
                "passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +
                
                "When::" + newLine() +
                
                "failing step icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(000ms)#" + newLine() +
                
                "====" + newLine()+newLine());
    }

    @Test
    public void shouldNotRenderScenarioWithSkipDocsTag(){
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
        Scenario scenarioToSkip = ScenarioBuilder.instance().name("scenario to skip").tag(new Tag("@skipDocs")).
                type(Type.scenario).build();;
        feature.getScenarios().add(scenarioToSkip);
        List<Feature> features = new ArrayList<>();
        features.add(feature);

        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        String resultDoc  = featureRenderer.renderFeatureScenarios(feature);

        assertThat(resultDoc).
                doesNotContain("scenario to skip").
                isEqualTo("==== Scenario: scenario"+newLine() +
                        "description"+newLine() +newLine()+
                        "===="+newLine() +
                        "Given::"+newLine() +
                        "passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"+newLine() +
                        "====" + newLine() +
                        ""+newLine());
    }

    @Test
    public void shouldRenderFeatureStepsWithOneScenarioWithMultipleStep(){
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithMultipleSteps();
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        List<Step> steps = feature.getScenarios().get(0).getSteps();
        CukedoctorScenarioRenderer scenarioRenderer = new CukedoctorScenarioRenderer();
        String resultDoc = scenarioRenderer.renderScenarioSteps(steps);
        assertThat(resultDoc).isEqualTo("====" + newLine() +
                "Given::" + newLine() + 
                "passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +
                
                "When::" + newLine() + 
               "failing step icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(000ms)#" + newLine() +
                
                "When::" + newLine() + 
                "pending step icon:thumbs-down[role=\"maroon\",title=\"Pending\"] [small right]#(000ms)#" + newLine() +
                
                "When::" + newLine() +
                
                "missing step icon:thumbs-down[role=\"blue\",title=\"Missing\"] [small right]#(000ms)#" + newLine() +
                
                "When::" + newLine() +
                
                "undefined step icon:thumbs-down[role=\"yellow\",title=\"Undefined\"] [small right]#(000ms)#" + newLine() +
                
                "Then::" + newLine() +
                
                "skipped step icon:thumbs-down[role=\"purple\",title=\"Skipped\"] [small right]#(000ms)#" + newLine() +
                
                "====" + newLine()+newLine());
    }

    @Test
    public void shouldRenderFeatureScenariosWithMultipleSteps(){
        final Feature feature = FeatureBuilder.instance().aFeatureWithMultipleScenariosAndSteps();
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        String resultDoc = featureRenderer.renderFeatureScenarios(feature);
        assertThat(resultDoc.replaceAll("\r","")).isEqualTo(("==== Scenario: scenario icon:thumbs-down[role=\"red\",title=\"Failed\"]"+newLine() +
                "description"+newLine() +
                ""+newLine() +
                "===="+newLine() +
                "Given::"+newLine() +
                
                "passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"+newLine() +
                 
                "When::"+newLine() +
                
                "failing step icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(000ms)#"+newLine() +
                
                "===="+newLine() +
                ""+newLine() +
                "==== Scenario: scenario icon:thumbs-down[role=\"red\",title=\"Failed\"]"+newLine() +
                "description"+newLine() +
                ""+newLine() +
                "===="+newLine() +
                "Then::"+newLine() +
                
                "skipped step icon:thumbs-down[role=\"purple\",title=\"Skipped\"] [small right]#(000ms)#"+newLine() +
                
                "===="+newLine() +
                ""+newLine() +
                "==== Scenario: scenario icon:thumbs-down[role=\"red\",title=\"Failed\"]"+newLine() +
                "description"+newLine() +
                ""+newLine() +
                "===="+newLine() +
                "Given::"+newLine() +
                 
                "undefined step icon:thumbs-down[role=\"yellow\",title=\"Undefined\"] [small right]#(000ms)#"+newLine() +
                
                "===="+newLine() +
                ""+newLine()).replaceAll("\r",""));
    }

    @Test
    public void shouldRenderFeatureWithTableInSteps(){
        List<Feature> features = FeatureParser.parse(featureWithTableInStep);
        CukedoctorConverter converter = Cukedoctor.instance(features, GlobalConfig.getInstance().getDocumentAttributes().docTitle("Doc Title"));
        String resultDoc = converter.renderDocumentation();
        assertThat(resultDoc.replaceAll("\r","")).isEqualTo(Expectations.FEATURE_WITH_STEP_TABLE_IN_PT_BR.replaceAll("\r",""));
    }

    @Test
    public void shouldNotGenerateSectionIdForFeatureBlankName(){
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
        feature.setName("    ");
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        assertThat(featureRenderer.renderFeatureSectionId(feature)).isEqualTo("");

    }

    @Test
    public void shouldNotRenderSectionIdForFeatureWithNullName(){
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
        feature.setName(null);
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        assertThat(featureRenderer.renderFeatureSectionId(feature)).isEqualTo("");

    }

    @Test
    public void shouldRenderSectionIdForFeatureWithNameWithSpaces(){
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
        feature.setName("Feature name");
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        assertThat(featureRenderer.renderFeatureSectionId(feature)).isEqualTo("[[Feature-name, Feature name]]");

    }

    @Test
    public void shouldRenderSectionIdForFeatureWithNameWithSpacesAndComma(){
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
        feature.setName("Feature name, subname");
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        assertThat(featureRenderer.renderFeatureSectionId(feature)).isEqualTo("[[Feature-name-subname, Feature name, subname]]");

    }

    @Test
    public void shouldRenderFeatureSectionId(){
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
        feature.setName("Name");
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        assertThat(featureRenderer.renderFeatureSectionId(feature)).isEqualTo("[[Name, Name]]");

    }

    @Test
    public void shouldRenderFeatureDescription(){
        final Feature feature = FeatureBuilder.instance().description("Feature description").name("Feature name").build();

        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        featureRenderer = spy(featureRenderer);
        doReturn("").when(featureRenderer).renderFeatureScenario(any(Scenario.class),eq(feature));
        String resultDoc = featureRenderer.renderFeature(feature);
        assertThat(resultDoc).isEqualTo("[[Feature-name, Feature name]]"+newLine() +
                "=== *Feature name*"+newLine() +
                ""+newLine() +
                "ifndef::backend-pdf[]"+newLine() +
			    "minmax::Feature-name[]"+newLine() +
			    "endif::[]"+newLine() +
                "****"+newLine() +
                "Feature description"+newLine() +
                "****"+newLine() +
                ""+newLine());
    }

    // Integration tests

    @Test
    public void shouldRenderScenarioExamples(){
        List<Feature> features = FeatureParser.parse(outline);
        assertThat(features).hasSize(1);
        CukedoctorScenarioRenderer scenarioRenderer = new CukedoctorScenarioRenderer();
        String resultDoc = scenarioRenderer.renderScenarioExamples(features.get(0).getElements().get(0));
        assertThat(resultDoc).isEqualTo(""+newLine() +
                ".examples1"+newLine() +
                "[cols=\"1*\", options=\"header\"]"+newLine() +
                "|==="+newLine() +
                "|status"+newLine() +
                "|passes"+newLine() +
                "|fails"+newLine() +
                "|==="+newLine() +
                ""+newLine() +
                ".examples2"+newLine() +
                "[cols=\"1*\", options=\"header\"]"+newLine() +
                "|==="+newLine() +
                "|status"+newLine() +
                "|passes"+newLine() +
                "|==="+newLine() +
                ""+newLine());
    }


}
