package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;

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
        String resultDoc = new CukedoctorFeatureRenderer(
                CukedoctorDocumentBuilder.Factory.newInstance().nestTitle().createNestedBuilder(),
                new DocumentAttributes()
        ).renderFeatures(features);

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
        String output = new CukedoctorFeatureRenderer(CukedoctorDocumentBuilder.Factory.newInstance().nestTitle().createNestedBuilder()).renderFeatures(features);
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
        String output = new CukedoctorFeatureRenderer(CukedoctorDocumentBuilder.Factory.newInstance().nestTitle().createNestedBuilder()).renderFeatures(features);
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
        String output = new CukedoctorFeatureRenderer(CukedoctorDocumentBuilder.Factory.newInstance().nestTitle().createNestedBuilder()).renderFeatures(features);
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
        String output = new CukedoctorFeatureRenderer(CukedoctorDocumentBuilder.Factory.newInstance().nestTitle().createNestedBuilder()).renderFeatures(features);
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
}
