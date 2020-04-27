package com.github.cukedoctor.bdd.cukedoctor;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.builder.CukedoctorDocumentBuilderImpl;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.renderer.CukedoctorFeatureRenderer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.URL;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pestano on 11/03/16.
 */
public class EnrichmentSteps {

    String documentation;


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

    @Then("^DocString asciidoc output must be rendered in my documentation$")
    public void DocString_asciidoc_output_must_be_rendered_in_my_documentation(String expected) throws Throwable {
    	assertThat(documentation.replaceAll("\r","")).contains((expected.replaceAll("\r","")));
    }

    @When("^I convert enriched feature json output using cukedoctor$")
    public void I_convert_enriched_feature_json_output_using_cukedoctor() throws Throwable {
        getFeatureFixture("/json-output/enrichment/calc.json");
    }


    private void getFeatureFixture(String fixturePath) {
        URL featureFile = getClass().getResource(fixturePath);
        assertThat(featureFile).isNotNull();
        List<Feature> features = FeatureParser.parse(featureFile.getPath());
        assertThat(features).isNotNull().hasSize(1);
        documentation = new CukedoctorFeatureRenderer(new CukedoctorDocumentBuilderImpl().nestTitle().createNestedBuilder()).renderFeatures(features);
    }
}
