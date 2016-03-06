package com.github.cukedoctor.bdd.sample;

import cucumber.api.java.en.Given;

import static org.junit.Assert.assertTrue;

/**
 * Created by pestano on 06/03/16.
 */
public class SimpleSteps {

    @Given("^scenario step$")
    public void scenario_step() throws Throwable {
        // Express the Regexp above with the code you wish you had
        assertTrue(true);
    }
}
