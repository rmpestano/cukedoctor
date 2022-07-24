package com.github.cukedoctor.example.bdd;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.*;

/** Created by pestano on 28/02/16. */
public class CalcStepDef {

  int x;
  int y;
  int result;

  @Given("^I have numbers (\\d+) and (\\d+)$")
  public void I_have_number_x_and_y(int x, int y, String docstring) throws Throwable {
    this.x = x;
    this.y = y;
  }

  @When("^I sum the numbers$")
  public void I_sum_the_number(String docstring) throws Throwable {
    result = x + y;
  }

  @When("^I subtract the numbers$")
  public void I_subtract_the_number() throws Throwable {
    result = x - y;
  }

  @Then("^I should have (\\d+) as result$")
  public void I_should_have_result(int result) throws Throwable {
    assertEquals(result, this.result);
  }
}
