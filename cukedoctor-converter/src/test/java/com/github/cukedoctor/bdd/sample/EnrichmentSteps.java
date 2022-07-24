package com.github.cukedoctor.bdd.sample;

import io.cucumber.java.en.Given;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by pestano on 06/03/16.
 */
public class EnrichmentSteps {

    @Given("^I have listing in step docstring.$")
    public void I_have_listing_in_feature_comments(String asciidoc) {
       assertTrue(true);
    }

    @Given("^I have admonition with a listing in step docstring.$")
    public void I_have_admonition_with_a_listing_in_feature_comments(String asciidoc) {
        assertThat(Boolean.TRUE).isEqualTo(true);
    }

}
