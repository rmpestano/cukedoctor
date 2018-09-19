package com.github.cukedoctor.bdd.cukedoctor;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;
import java.util.List;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.Constants;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by pestano on 06/03/16.
 */
public class ConverterSteps {

    String documentation;

    @When("^I convert their json test output using cukedoctor converter$")
    public void I_convert_their_json_output_report_using_cukedoctor_converter(String docstring) throws Throwable {
        URL featureFile = getClass().getResource("/com/github/cukedoctor/json-output/simple.json");
        assertThat(featureFile).isNotNull();
        List<Feature> features = FeatureParser.parse(featureFile.getPath());
        assertThat(features).isNotNull().hasSize(2);
        documentation = Cukedoctor.instance(features).renderDocumentation();

    }

    @Then("^I should have awesome living documentation$")
    public void I_should_have_awesome_living_documentation(String expected) throws Throwable {
       //remove include cause its resolved by asciidoctor converter
       assertThat(documentation.replaceAll("\r","").replace("include::" +
               "" +Constants.home() + "cukedoctor-intro.adoc[leveloffset=+1]","")).
               isEqualTo(expected.replaceAll("\r", ""));
    }


}
