package com.github.cukedoctor.example.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Created by pestano on 28/02/16.
 */
public class CalcStepDef {

    int x;
    int y;
    int result;

    @Given("^I have numbers (\\d+) and (\\d+)$")
    public void I_have_number_x_and_y(int x, int y) throws Throwable {
        this.x = x;
        this.y = y;
    }

    @When("^I sum the numbers$")
    public void I_sum_the_number() throws Throwable {
        result = x + y;
    }

    @When("^I subtract the numbers$")
    public void I_subtract_the_number() throws Throwable {
        result = x - y;
    }

    @Then("^I should have (\\d+) as result$")
    public void I_should_have_result(int result) throws Throwable {
        assertEquals(result,this.result);
    }

}
