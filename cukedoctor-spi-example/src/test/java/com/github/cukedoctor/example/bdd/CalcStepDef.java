package com.github.cukedoctor.example.bdd;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/** Created by pestano on 28/02/16. */
public class CalcStepDef {

  int x;
  int y;
  int result;

  @Given("^I have numbers (\\d+) and (\\d+)$")
  public void I_have_number_x_and_y(int x, int y, String docstring) {
    this.x = x;
    this.y = y;
  }

  @When("^I sum the numbers$")
  public void I_sum_the_number(String docstring) {
    result = x + y;
  }

  @When("^I subtract the numbers$")
  public void I_subtract_the_number() {
    result = x - y;
  }

  @Then("^I should have (\\d+) as result$")
  public void I_should_have_result(int result) {
    assertEquals(result, this.result);
  }
}
