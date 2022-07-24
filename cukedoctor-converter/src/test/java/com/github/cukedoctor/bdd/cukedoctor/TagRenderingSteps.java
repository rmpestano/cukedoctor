package com.github.cukedoctor.bdd.cukedoctor;

import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.builder.CukedoctorDocumentBuilderImpl;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.renderer.CukedoctorFeatureRenderer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.URL;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TagRenderingSteps {

    String documentation;

    @When("^I render the feature$")
    public void I_render_the_feature() {
        URL featureFile = getClass().getResource("/com/github/cukedoctor/json-output/tag-rendering.json");
        assertThat(featureFile).isNotNull();
        List<Feature> features = FeatureParser.parse(featureFile.getPath());
        documentation = new CukedoctorFeatureRenderer((DocumentAttributes) null).renderFeatures(features, new CukedoctorDocumentBuilderImpl().createNestedBuilder());
    }

    @Then("^the tags displayed under each scenario should not have duplicates$")
    public void the_tags_displayed_under_each_scenario_should_not_have_duplicates(String expected) {
        assertThat(documentation.replaceAll("\r", "")).isNotNull().contains(expected.replaceAll("\r", ""));
    }


    @Then("Cukedoctor tags should not be rendered in documentation")
    public void Cukedoctor_tags_should_not_be_rendered_in_documentation(String expected) {
        assertThat(documentation.replaceAll("\r", "")).isNotNull().contains(expected.replaceAll("\r", ""));
    }
}
