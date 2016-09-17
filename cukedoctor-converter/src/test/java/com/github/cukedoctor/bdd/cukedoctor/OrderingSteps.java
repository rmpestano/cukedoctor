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

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pestano on 05/03/16.
 */
public class OrderingSteps {

    String documentation;


    @Given("^The following two features:$")
    public void the_following_two_features(String features) throws Throwable {
        assertThat(features).isNotNull();
    }

    @When("^I convert them using default order$")
    public void I_convert_the_using_default_order() throws Throwable {
        URL featureFile = getClass().getResource("/com/github/cukedoctor/json-output/non-ordered.json");
        assertThat(featureFile).isNotNull();
        List<Feature> features = FeatureParser.parse(featureFile.getPath());
        assertThat(features).isNotNull().hasSize(2);
        documentation = Cukedoctor.instance(features).renderFeatures().getDocumentation();
    }

    @Then("^Features should be ordered by name in resulting documentation$")
    public void Features_should_be_ordered_by_name_in_resulting_documentation(String expected) throws Throwable {
        assertThat(documentation.replaceAll("\r","")).isNotNull().contains(expected.replaceAll("\r",""));
        }

    @When("^I convert them using comment order$")
    public void I_convert_them__using_comment_order() throws Throwable {
        URL featureFile = getClass().getResource("/com/github/cukedoctor/json-output/ordered.json");
        assertThat(featureFile).isNotNull();
        List<Feature> features = FeatureParser.parse(featureFile.getPath());
        assertThat(features).isNotNull().hasSize(2);
        documentation = Cukedoctor.instance(features).renderFeatures().getDocumentation();
    }

    @Then("^Features should be ordered respecting order comment$")
    public void Features_should_be_ordered_respecting_order_comment(String expected) throws Throwable {
        assertThat(documentation.replaceAll("\r","")).isNotNull().contains(expected.replaceAll("\r",""));
    }

}
