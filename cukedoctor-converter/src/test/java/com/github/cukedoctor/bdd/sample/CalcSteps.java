package com.github.cukedoctor.bdd.sample;

import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by pestano on 06/03/16.
 */
public class CalcSteps {

    long result;
    int x;
    int y;

    @Given("^I have numbers (\\d+) and (\\d+)$")
    public void I_have_numbers_and(int x, int y, String asciidocString) {
        this.x = x;
        this.y = y;
    }


    @When("^I sum the numbers using the following java code:$")
    public void I_sum_the_numbers_using_the_following_java_code(String asciidocString) {
        result = x + y;
    }

    @When("^I sum the numbers$")
    public void I_sum_the_numbers() {

    }

    @Then("^I should have (\\d+) as result$")
    public void I_should_have_as_result(int arg1, String asciidoc) {
        assertEquals(arg1,result);
    }
}
