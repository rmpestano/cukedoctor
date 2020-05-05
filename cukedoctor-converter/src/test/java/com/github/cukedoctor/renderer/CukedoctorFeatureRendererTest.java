package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.*;
import com.github.cukedoctor.builder.CukedoctorDocumentBuilderImpl;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.Expectations;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import com.github.cukedoctor.util.builder.ScenarioBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static com.github.cukedoctor.renderer.Fixtures.featureWithSourceDocStringInStep;
import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@RunWith(JUnit4.class)
public class CukedoctorFeatureRendererTest {

    @Test
    public void shouldNotRenderFeatureWithSkipDocsTag() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
        final Feature featureToSkip = FeatureBuilder.instance().aFeatureWithTwoScenarios();
        featureToSkip.getTags().add(new Tag("@skipDocs"));
        featureToSkip.setName("feature to skip");
        featureToSkip.setId("skippedFeature");
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        features.add(featureToSkip);
        String resultDoc = new CukedoctorFeatureRenderer(new DocumentAttributes())
                .renderFeatures(features, CukedoctorDocumentBuilder.Factory.newInstance().createNestedBuilder());

        assertThat(resultDoc).
                doesNotContain("feature to skip").
                contains("[[Feature-name, Feature name]]" + newLine() +
                        "=== *Feature name*" + newLine() +
                        "" + newLine() +
                        "ifndef::backend-pdf[]" + newLine() +
                        "minmax::Feature-name[]" + newLine() +
                        "endif::[]" + newLine() +
                        "****" + newLine() +
                        "Feature description" + newLine() +
                        "****" + newLine() +
                        "" + newLine() +
                        "==== Scenario: scenario 1" + newLine() +
                        "description" + newLine() +
                        "" + newLine() +
                        "==== Scenario: scenario 2" + newLine() +
                        "description 2" + newLine() +
                        "" + newLine());
    }

    @Test
    public void shouldEnrichFeature() {
        List<Feature> features = FeatureParser.parse(getClass().getResource("/json-output/enrichment/calc.json").getPath());
        assertThat(features).isNotNull().hasSize(1);
        String output = new CukedoctorFeatureRenderer((DocumentAttributes) null).renderFeatures(features, CukedoctorDocumentBuilder.Factory.newInstance().createNestedBuilder());
        assertThat(output.replaceAll("\r\n|\r|\n", newLine())).contains(("[[Calculator, Calculator]]" + newLine() +
                "=== *Calculator*" + newLine() +
                "" + newLine() +
                "==== Scenario: Adding numbers" + newLine() +
                "You can use *asciidoc markup* in _feature_ #description#." + newLine() +
                "" + newLine() +
                "NOTE: This is a very important feature!" + newLine() +
                "" + newLine() +
                "==========" + newLine() +
                "Given ::" + newLine() +
                "I have numbers 1 and 2 icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(114ms)#" + newLine() +
                "" + newLine() +
                "IMPORTANT: Asciidoc markup inside *steps* must be surrounded by *curly brackets*." + newLine() +
                "" + newLine() +
                "When ::" + newLine() +
                "I sum the numbers icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +
                "" + newLine() +
                "NOTE: Steps comments are placed *before* each steps so this comment is for the *WHEN* step." + newLine() +
                "" + newLine() +
                "Then ::" + newLine() +
                "I should have 3 as result icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#" + newLine() +
                "" + newLine() +
                "* this is a list of itens inside a feature step" + newLine() +
                "" + newLine() +
                "* there is no multiline comment in gherkin" + newLine() +
                "" + newLine() +
                "** second level list item" + newLine() +
                "" + newLine() +
                "==========" + newLine() +
                "" + newLine() +
                ""));
    }

    @Test
    public void shouldEnrichFeatureWithListing() {
        List<Feature> features = FeatureParser.parse(getClass().getResource("/com/github/cukedoctor/json-output/comment-with-listing.json").getPath());
        assertThat(features).isNotNull().hasSize(1);
        String output = new CukedoctorFeatureRenderer((DocumentAttributes) null).renderFeatures(features, CukedoctorDocumentBuilder.Factory.newInstance().createNestedBuilder());
        assertThat(output.replaceAll("\r", "")).contains(("[[Enriched-feature, Enriched feature]]" + newLine() +
                "=== *Enriched feature*" + newLine() +
                "" + newLine() +
                "==== Scenario: Scenario with listing" + newLine() +
                "You can use *asciidoc markup* using feature comments." + newLine() +
                "" + newLine() +
                "==========" + newLine() +
                "Given ::" + newLine() +
                "I have listing in feature comments. icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +
                "[source,java]" + newLine() +
                "----" + newLine() +
                "" + newLine() +
                "System.setProperty(\"INTRO_CHAPTER_DIR\",\"/home/some/external/folder\");" + newLine() +
                "----" + newLine() +
                "" + newLine() +
                "==========" + newLine() + newLine()).replaceAll("\r", ""));
    }

    @Test
    public void shouldEnrichFeatureWithListingWithinAdmonitionBlock() {
        List<Feature> features = FeatureParser.parse(getClass().getResource("/com/github/cukedoctor/json-output/comment-with-admonition-and-listing.json").getPath());
        assertThat(features).isNotNull().hasSize(1);
        String output = new CukedoctorFeatureRenderer((DocumentAttributes) null).renderFeatures(features, CukedoctorDocumentBuilder.Factory.newInstance().createNestedBuilder());
        assertThat(output.replaceAll("\r", "")).contains(("[[Enriched-feature, Enriched feature]]" + newLine() +
                "=== *Enriched feature*" + newLine() +
                "" + newLine() +
                "==== Scenario: Scenario with admonition and  listing" + newLine() +
                "You can use *asciidoc markup* using feature comments." + newLine() +
                "" + newLine() +
                "==========" + newLine() +
                "Given ::" + newLine() +
                "I have admonition with a listing in feature comments. icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(032ms)#" + newLine() +
                "" + newLine() +
                "[TIP]" + newLine() +
                "====" + newLine() +
                "" + newLine() +
                "This is a tip with source code inside" + newLine() +
                "[source,java]" + newLine() +
                "----" + newLine() +
                "" + newLine() +
                "System.setProperty(\"INTRO_CHAPTER_DIR\",\"/home/some/external/folder\");" + newLine() +
                "----" + newLine() +
                "====" + newLine() +
                "" + newLine() +
                "==========" + newLine() +
                "").replaceAll("\r", ""));
    }

    @Test
    public void shouldEnrichFeatureWithCommentAndDocstring() {
        List<Feature> features = FeatureParser.parse(getClass().getResource("/com/github/cukedoctor/json-output/calc-enriched.json").getPath());
        assertThat(features).isNotNull().hasSize(1);
        String output = new CukedoctorFeatureRenderer((DocumentAttributes) null).renderFeatures(features, CukedoctorDocumentBuilder.Factory.newInstance().createNestedBuilder());
        assertThat(output.replaceAll("\r", "")).contains(("[[Calculator, Calculator]]" + newLine() +
                "=== *Calculator*" + newLine() +
                "" + newLine() +
                "==== Scenario: Adding numbers" + newLine() +
                "You can *asciidoc markup* in _feature_ #description#." + newLine() +
                "" + newLine() +
                "NOTE: This is a very important feature!" + newLine() +
                "" + newLine() +
                "==========" + newLine() +
                "Given ::" + newLine() +
                "I have numbers 1 and 2 icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(212ms)#" + newLine() +
                "" + newLine() +
                "IMPORTANT: Asciidoc markup inside *steps* must be surrounded by *curly brackets*." + newLine() +
                "" + newLine() +
                "When ::" + newLine() +
                "I sum the numbers using the following java code: icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#" + newLine() +
                "******" + newLine() +
                "" + newLine() +
                "[discrete]" + newLine() +
                "[source,java]" + newLine() +
                "----" + newLine() +
                "    public class Calc {" + newLine() +
                "      public long sum(int x, int y){" + newLine() +
                "          return  x + y; //<1>" + newLine() +
                "      }" + newLine() +
                "  }" + newLine() +
                "----" + newLine() +
                "[discrete]" + newLine() +
                "<1> This is an asciidoc call inside a feature." + newLine() +
                "" + newLine() +
                "" + newLine() +
                "******" + newLine() +
                "" + newLine() +
                "NOTE: You can use asciidoc in doc strings as well" + newLine() +
                "" + newLine() +
                "TIP: Steps comments are placed *before* each steps" + newLine() +
                "" + newLine() +
                "Then ::" + newLine() +
                "I should have 3 as result icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(003ms)#" + newLine() +
                "" + newLine() +
                "* this is a list of itens inside a feature step" + newLine() +
                "" + newLine() +
                "* there is no multiline comment in gherkin" + newLine() +
                "" + newLine() +
                "** second level list item" + newLine() +
                "" + newLine() +
                "==========" + newLine() +
                "" + newLine() +
                "").replaceAll("\r", ""));
    }

    @Test
    public void shouldRenderFeatureScenarios() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();

        CukedoctorScenarioRenderer scenarioRenderer = new CukedoctorScenarioRenderer();
        scenarioRenderer = spy(scenarioRenderer);
        doReturn("").when(scenarioRenderer).renderScenarioSteps(anyListOf(Step.class), any(Scenario.class), any(Feature.class));
        doReturn("").when(scenarioRenderer).renderScenarioExamples(any(Scenario.class));
        doReturn("").when(scenarioRenderer).renderScenarioTags(any(Scenario.class), eq(feature));

        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        featureRenderer = spy(featureRenderer);
        featureRenderer.scenarioRenderer = scenarioRenderer;

        String resultDoc = featureRenderer.renderFeatureScenarios(feature, new CukedoctorDocumentBuilderImpl().createNestedBuilder().createNestedBuilder());
        assertThat(resultDoc).isEqualTo("==== Scenario: scenario 1" + newLine() +
                "description" + newLine() + newLine() +
                "==== Scenario: scenario 2" + newLine() +
                "description 2" + newLine() + newLine());
    }

    @Test
    public void shouldRenderFeatureScenariosWithTagsInScenarios() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
        for (Scenario scenario : feature.getScenarios()) {
            ScenarioBuilder.instance(scenario).tag(new Tag("@Tag1")).tag(new Tag("@tag2"));
        }
        CukedoctorScenarioRenderer scenarioRenderer = new CukedoctorScenarioRenderer();
        scenarioRenderer = spy(scenarioRenderer);
        doReturn("").when(scenarioRenderer).renderScenarioSteps(anyListOf(Step.class), any(Scenario.class), any(Feature.class));
        doReturn("").when(scenarioRenderer).renderScenarioExamples(any(Scenario.class));

        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        featureRenderer = spy(featureRenderer);
        featureRenderer.scenarioRenderer = scenarioRenderer;

        String resultDoc = featureRenderer.renderFeatureScenarios(feature, new CukedoctorDocumentBuilderImpl().createNestedBuilder().createNestedBuilder());
        assertThat(resultDoc).isEqualTo("==== Scenario: scenario 1" + newLine() +
                "[small]#tags: @tag2,@Tag1#" + newLine() +
                "" + newLine() +
                "description" + newLine() + newLine() +
                "==== Scenario: scenario 2" + newLine() +
                "[small]#tags: @tag2,@Tag1#" + newLine() +
                "" + newLine() +
                "description 2" + newLine() + newLine());
    }

    @Test
    public void shouldRenderFeatureScenariosWithTagsInFeaturesAndScenarios() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
        feature.getTags().add(new Tag("@FeatureTag"));
        for (Scenario scenario : feature.getScenarios()) {
            ScenarioBuilder.instance(scenario).tag(new Tag("@Tag1")).tag(new Tag("@tag2"));
        }

        CukedoctorScenarioRenderer scenarioRenderer = new CukedoctorScenarioRenderer();
        scenarioRenderer = spy(scenarioRenderer);
        doReturn("").when(scenarioRenderer).renderScenarioSteps(anyListOf(Step.class), any(Scenario.class), any(Feature.class));
        doReturn("").when(scenarioRenderer).renderScenarioExamples(any(Scenario.class));

        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        featureRenderer = spy(featureRenderer);
        featureRenderer.scenarioRenderer = scenarioRenderer;

        String resultDoc = featureRenderer.renderFeatureScenarios(feature, new CukedoctorDocumentBuilderImpl().createNestedBuilder().createNestedBuilder());
        assertThat(resultDoc).isEqualTo("==== Scenario: scenario 1" + newLine() +
                "[small]#tags: @tag2,@FeatureTag,@Tag1#" + newLine() +
                "" + newLine() +
                "description" + newLine() + newLine() +
                "==== Scenario: scenario 2" + newLine() +
                "[small]#tags: @tag2,@FeatureTag,@Tag1#" + newLine() +
                "" + newLine() +
                "description 2" + newLine() + newLine());
    }

    @Test
    public void shouldRenderFeatureScenariosOmittingTagsIfOrderFeatureTagIsTheOnlyTag() {
        // cucumber-jvm-5.6.0 cascades feature tags down to scenarios. See "ordering.feature" and "order-tags.json" for an example.
        final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
        final String orderTagName = "@order-42";
        feature.getTags().add(new Tag(orderTagName));
        for (Scenario scenario : feature.getScenarios()) {
            ScenarioBuilder.instance(scenario).tag(new Tag(orderTagName));
        }

        CukedoctorScenarioRenderer scenarioRenderer = new CukedoctorScenarioRenderer();
        scenarioRenderer = spy(scenarioRenderer);
        doReturn("").when(scenarioRenderer).renderScenarioSteps(anyListOf(Step.class), any(Scenario.class), any(Feature.class));
        doReturn("").when(scenarioRenderer).renderScenarioExamples(any(Scenario.class));

        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        featureRenderer = spy(featureRenderer);
        featureRenderer.scenarioRenderer = scenarioRenderer;

        String resultDoc = featureRenderer.renderFeatureScenarios(feature, new CukedoctorDocumentBuilderImpl().createNestedBuilder().createNestedBuilder());
        assertThat(resultDoc).isEqualTo("==== Scenario: scenario 1" + newLine() +
                "description" + newLine() + newLine() +
                "==== Scenario: scenario 2" + newLine() +
                "description 2" + newLine() + newLine());
    }

    @Test
    public void shouldNotRenderScenarioWithSkipDocsTag() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
        Scenario scenarioToSkip = ScenarioBuilder.instance().name("scenario to skip").tag(new Tag("@skipDocs")).
                type(Type.scenario).build();
        ;
        feature.getScenarios().add(scenarioToSkip);
        List<Feature> features = new ArrayList<>();
        features.add(feature);

        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        String resultDoc = featureRenderer.renderFeatureScenarios(feature, new CukedoctorDocumentBuilderImpl().createNestedBuilder().createNestedBuilder());

        assertThat(resultDoc).
                doesNotContain("scenario to skip").
                isEqualTo("==== Scenario: scenario" + newLine() +
                        "description" + newLine() + newLine() +
                        "==========" + newLine() +
                        "Given::" + newLine() +
                        "passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +
                        "==========" + newLine() +
                        "" + newLine());
    }

    @Test
    public void shouldRenderFeatureScenariosWithMultipleSteps() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithMultipleScenariosAndSteps();
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        String resultDoc = featureRenderer.renderFeatureScenarios(feature, new CukedoctorDocumentBuilderImpl().createNestedBuilder().createNestedBuilder());
        assertThat(resultDoc.replaceAll("\r", "")).isEqualTo(("==== Scenario: scenario icon:thumbs-down[role=\"red\",title=\"Failed\"]" + newLine() +
                "description" + newLine() +
                "" + newLine() +
                "==========" + newLine() +
                "Given::" + newLine() +

                "passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +

                "When::" + newLine() +

                "failing step icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(000ms)#" + newLine() +

                "==========" + newLine() +
                "" + newLine() +
                "==== Scenario: scenario icon:thumbs-down[role=\"red\",title=\"Failed\"]" + newLine() +
                "description" + newLine() +
                "" + newLine() +
                "==========" + newLine() +
                "Then::" + newLine() +

                "skipped step icon:thumbs-down[role=\"purple\",title=\"Skipped\"] [small right]#(000ms)#" + newLine() +

                "==========" + newLine() +
                "" + newLine() +
                "==== Scenario: scenario icon:thumbs-down[role=\"red\",title=\"Failed\"]" + newLine() +
                "description" + newLine() +
                "" + newLine() +
                "==========" + newLine() +
                "Given::" + newLine() +

                "undefined step icon:thumbs-down[role=\"yellow\",title=\"Undefined\"] [small right]#(000ms)#" + newLine() +

                "==========" + newLine() +
                "" + newLine()).replaceAll("\r", ""));
    }

    @Test
    public void shouldRenderSourceDocStringInStep() {
        List<Feature> features = FeatureParser.parse(featureWithSourceDocStringInStep);
        final Feature feature = features.get(0);
        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer(new DocumentAttributes());
        String resultDoc = featureRenderer.renderFeature(feature, new CukedoctorDocumentBuilderImpl().createNestedBuilder().createNestedBuilder());
        assertThat(resultDoc).isEqualTo(Expectations.FEATURE_WITH_SOURCE_DOC_STRING);
    }

    @Test
    public void shouldNotGenerateSectionIdForFeatureBlankName() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
        feature.setName("    ");
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        assertThat(featureRenderer.renderFeatureSectionId(feature)).isEqualTo("");
    }

    @Test
    public void shouldNotRenderSectionIdForFeatureWithNullName() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
        feature.setName(null);
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        assertThat(featureRenderer.renderFeatureSectionId(feature)).isEqualTo("");
    }

    @Test
    public void shouldRenderSectionIdForFeatureWithNameWithSpaces() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
        feature.setName("Feature name");
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        assertThat(featureRenderer.renderFeatureSectionId(feature)).isEqualTo("[[Feature-name, Feature name]]");
    }

    @Test
    public void shouldRenderSectionIdForFeatureWithNameWithSpacesAndComma() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
        feature.setName("Feature name, subname");
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        assertThat(featureRenderer.renderFeatureSectionId(feature)).isEqualTo("[[Feature-name-subname, Feature name, subname]]");
    }

    @Test
    public void shouldRenderFeatureSectionId() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
        feature.setName("Name");
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
        assertThat(featureRenderer.renderFeatureSectionId(feature)).isEqualTo("[[Name, Name]]");
    }

    @Test
    public void shouldRenderFeatureDescription() {
        final Feature feature = FeatureBuilder.instance().description("Feature description").name("Feature name").build();

        CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer(new DocumentAttributes());
        featureRenderer = spy(featureRenderer);
        doReturn("").when(featureRenderer).renderFeatureScenario(any(Scenario.class), eq(feature), any(CukedoctorDocumentBuilder.class));
        String resultDoc = featureRenderer.renderFeature(feature, new CukedoctorDocumentBuilderImpl().createNestedBuilder().createNestedBuilder());
        assertThat(resultDoc).isEqualTo("[[Feature-name, Feature name]]" + newLine() +
                "=== *Feature name*" + newLine() +
                "" + newLine() +
                "ifndef::backend-pdf[]" + newLine() +
                "minmax::Feature-name[]" + newLine() +
                "endif::[]" + newLine() +
                "****" + newLine() +
                "Feature description" + newLine() +
                "****" + newLine() +
                "" + newLine());
    }

    @Test
    public void shouldNotTrimFeatureWithCodeListingInDescription() {
        final String descriptionWithListing = "[source, xml]"+newLine() +
                "----" + newLine() +
                "<plugin>" + newLine() +
                "  <groupId>com.github.cukedoctor</groupId>" + newLine() +
                "  <artifactId>cukedoctor-maven-plugin</artifactId>" + newLine() +
                "  <version>2.0</version>" + newLine() +
                "  <executions>" + newLine() +
                "    <execution>" + newLine() +
                "      <goals>" + newLine() +
                "        <goal>execute</goal>" + newLine() +
                "      </goals>" + newLine() +
                "      <phase>install</phase>" + newLine() +
                "    </execution>" + newLine() +
                "  </executions>" + newLine() +
                "  <dependencies>" + newLine() +
                "    <dependency>" + newLine() +
                "      <groupId>com.github.cukedoctor</groupId>" + newLine() +
                "      <artifactId>cukedoctor-section-layout</artifactId>" + newLine() +
                "      <version>2.0</version>" + newLine() +
                "    </dependency>" + newLine() +
                "  </dependencies>" + newLine() +
                "</plugin>" + newLine() +
                "----";
        final Feature featureWithCodeInDescription = FeatureBuilder.instance().description(descriptionWithListing)
                .name("A feature with listing")
                .build();
        final String resultDoc = new CukedoctorFeatureRenderer(new DocumentAttributes())
                .renderFeature(featureWithCodeInDescription, CukedoctorDocumentBuilder.Factory.newInstance().createNestedBuilder());
        assertThat(resultDoc).contains(descriptionWithListing);
    }

    @Test
    public void shouldNotTrimScenarioWithCodeListingInDescription() {
        final String descriptionWithListing = "[source, xml]"+newLine() +
                "----" + newLine() +
                "<plugin>" + newLine() +
                "  <groupId>com.github.cukedoctor</groupId>" + newLine() +
                "  <artifactId>cukedoctor-maven-plugin</artifactId>" + newLine() +
                "  <version>2.0</version>" + newLine() +
                "  <executions>" + newLine() +
                "    <execution>" + newLine() +
                "      <goals>" + newLine() +
                "        <goal>execute</goal>" + newLine() +
                "      </goals>" + newLine() +
                "      <phase>install</phase>" + newLine() +
                "    </execution>" + newLine() +
                "  </executions>" + newLine() +
                "  <dependencies>" + newLine() +
                "    <dependency>" + newLine() +
                "      <groupId>com.github.cukedoctor</groupId>" + newLine() +
                "      <artifactId>cukedoctor-section-layout</artifactId>" + newLine() +
                "      <version>2.0</version>" + newLine() +
                "    </dependency>" + newLine() +
                "  </dependencies>" + newLine() +
                "</plugin>" + newLine() +
                "----";
        final Feature feature = FeatureBuilder.instance().description("Feature description")
                .name("A feature")
                .scenario(ScenarioBuilder.instance().name("Scenario with listing in description")
                .description(descriptionWithListing).build())
                .build();
        final String resultDoc = new CukedoctorFeatureRenderer(new DocumentAttributes())
                .renderFeature(feature, CukedoctorDocumentBuilder.Factory.newInstance().createNestedBuilder());
        assertThat(resultDoc).contains(descriptionWithListing);
    }
}