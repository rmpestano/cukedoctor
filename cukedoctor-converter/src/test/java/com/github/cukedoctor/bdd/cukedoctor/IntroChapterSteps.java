package com.github.cukedoctor.bdd.cukedoctor;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;
import java.util.List;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.Constants;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by pestano on 06/03/16.
 */
public class IntroChapterSteps {

    String documentation;

    String introChapterContent;
    
    @And("^The following asciidoc document is on your application classpath$")
    public void I_convert_their_json_output_report_using_cukedoctor_converter(String docstring) throws Throwable {
        introChapterContent = docstring;
        URL featureFile = getClass().getResource("/com/github/cukedoctor/json-output/simple.json");
        assertThat(featureFile).isNotNull();
        List<Feature> features = FeatureParser.parse(featureFile.getPath());
        assertThat(features).isNotNull().hasSize(2);
        documentation = Cukedoctor.instance(features).renderDocumentation();

    }
    
    @When("^Bdd tests results are converted into documentation by Cukedoctor$")
    public void Bdd_tests_results_are_converted_into_documentation_by_Cukedoctor(){
        
    }

    @Then("^Resulting documentation should have the provided introduction chapter$")
    public void I_should_have_awesome_living_documentation(String expected) throws Throwable {

       assertThat(documentation.replace("include::"+Constants.home()+"cukedoctor-intro.adoc[leveloffset=+1]",
           //need to add a '=' because of leveloffset intro chapter have
           introChapterContent.replace("= *Introduction*", "== *Introduction*")).replaceAll("\r","")).isEqualTo(expected.replaceAll("\r",""));
    }

}
