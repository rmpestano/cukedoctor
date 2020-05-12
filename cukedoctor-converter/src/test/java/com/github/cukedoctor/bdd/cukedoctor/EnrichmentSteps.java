package com.github.cukedoctor.bdd.cukedoctor;

import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.builder.CukedoctorDocumentBuilderImpl;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.renderer.CukedoctorFeatureRenderer;
import com.github.cukedoctor.util.MetaCuke;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pestano on 11/03/16.
 */
public class EnrichmentSteps {
    private final MetaCuke metaCuke = new MetaCuke();
    String documentation;

    public EnrichmentSteps() throws IOException {
    }

    @Before
    public void before() throws IOException {
        metaCuke.setUp();
    }

    @After
    public void after() throws IOException {
        metaCuke.tearDown();
    }

    @Given("^the feature:$")
    public void the_feature(String featureText) throws Throwable {
        assertThat(featureText).isNotNull();
        metaCuke.addFeature(featureText);
    }

    @When("^I convert docstring enriched json output activated with a step comment using cukedoctor converter$")
    public void I_convert_docstring_enriched_json_output_activated_with_a_step_comment_using_cukedoctor_converter() throws Throwable {
        getFeatureFixture("/json-output/enrichment/table-and-source-step-comment.json");
    }

    @When("^I convert enriched docstring with asciidoc content type using cukedoctor converter$")
    public void I_convert_enriched_docstring_with_content_type_using_cukedoctor_converter() throws Throwable {
        getFeatureFixture("/json-output/enrichment/table-and-source-content-type.json");
    }

    @When("^I convert enriched docstring with asciidoc feature tag using cukedoctor converter$")
    public void I_convert_docstring_enriched_json_output_activiated_with_a_feature_tag_using_cukedoctor_converter() throws Throwable {
        getFeatureFixture("/json-output/enrichment/table-and-source-feature-tag.json");
    }

    @When("^I convert enriched docstring with asciidoc scenario tag using cukedoctor converter$")
    public void I_convert_docstring_enriched_json_output_activiated_with_a_scenario_tag_using_cukedoctor_converter() throws Throwable {
        getFeatureFixture("/json-output/enrichment/table-and-source-scenario-tag.json");
    }

    @When("^I convert enriched feature json output using cukedoctor$")
    public void I_convert_enriched_feature_json_output_using_cukedoctor() throws Throwable {
        getFeatureFixture("/json-output/enrichment/calc.json");
    }

    @When("^I convert it$")
    public void I_convert_it() {
        metaCuke.runCucumber("com.care.dont");
        List<Feature> features = FeatureParser.parse(metaCuke.getReport().getAbsolutePath());
        documentation = new CukedoctorFeatureRenderer((DocumentAttributes) null).renderFeatures(features, new CukedoctorDocumentBuilderImpl().createNestedBuilder());
    }

    @Then("^DocString asciidoc output must be rendered in my documentation$")
    @Then("^it should be rendered in AsciiDoc as$")
    public void DocString_asciidoc_output_must_be_rendered_in_my_documentation(String expected) throws Throwable {
    	assertThat(documentation.replaceAll("\r","")).contains((expected.replaceAll("\r","")));
    }

    private void getFeatureFixture(String fixturePath) {
        URL featureFile = getClass().getResource(fixturePath);
        assertThat(featureFile).isNotNull();
        List<Feature> features = FeatureParser.parse(featureFile.getPath());
        assertThat(features).isNotNull().hasSize(1);
        documentation = new CukedoctorFeatureRenderer((DocumentAttributes) null).renderFeatures(features, new CukedoctorDocumentBuilderImpl().createNestedBuilder());
    }
}