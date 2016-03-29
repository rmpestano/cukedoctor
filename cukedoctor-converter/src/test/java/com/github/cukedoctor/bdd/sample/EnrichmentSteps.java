package com.github.cukedoctor.bdd.sample;

import cucumber.api.java.en.Given;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by pestano on 06/03/16.
 */
public class EnrichmentSteps {

    @Given("^I have listing in feature comments.$")
    public void I_have_listing_in_feature_comments() throws Throwable {
       assertTrue(true);
    }

    @Given("^I have admonition with a listing in feature comments.$")
    public void I_have_admonition_with_a_listing_in_feature_comments() throws Throwable {
        assertThat(Boolean.TRUE).isEqualTo(true);
    }

}
