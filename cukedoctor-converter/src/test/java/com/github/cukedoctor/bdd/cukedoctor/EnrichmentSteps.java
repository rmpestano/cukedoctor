package com.github.cukedoctor.bdd.cukedoctor;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.net.URL;
import java.util.List;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pestano on 11/03/16.
 */
public class EnrichmentSteps {

    String documentation;


    @When("^I convert docstring enriched json output using cukedoctor converter$")
    public void I_convert_docstring_enriched_json_output_using_cukedoctor_converter() throws Throwable {
        URL featureFile = getClass().getResource("/json-output/enrichment/table-and-source.json");
        assertThat(featureFile).isNotNull();
        List<Feature> features = FeatureParser.parse(featureFile.getPath());
        assertThat(features).isNotNull().hasSize(1);
        documentation = Cukedoctor.instance(features).renderFeatures().getDocumentation();
    }

    @Then("^DocString asciidoc output must be rendered in my documentation$")
    public void DocString_asciidoc_output_must_be_rendered_in_my_documentation(String expected) throws Throwable {
        assertThat(documentation.replaceAll("\r","")).contains((expected.replaceAll("\r","")));
    }

    @When("^I convert enriched feature json output using cukedoctor$")
    public void I_convert_enriched_feature_json_output_using_cukedoctor() throws Throwable {
        URL featureFile = getClass().getResource("/json-output/enrichment/calc.json");
        assertThat(featureFile).isNotNull();
        List<Feature> features = FeatureParser.parse(featureFile.getPath());
        assertThat(features).isNotNull().hasSize(1);
        documentation = Cukedoctor.instance(features).renderFeatures().getDocumentation();
    }

    @Then("^Asciidoc markup on comments must be rendered in my documentation$")
    public void Asciidoc_output_must_be_rendered_in_my_documentation(String expected) throws Throwable {
        assertThat(documentation.replaceAll("\r","").replaceAll(" ","")).contains(expected.replaceAll("\r","").replaceAll(" ",""));
    }

    @Given("^The following feature with asciidoc markup in comments:$")
    public void The_following_feature_with_asciidoc_markup_in_comments(String features) throws Throwable {
        assertThat(features).isNotNull();
    }

}
