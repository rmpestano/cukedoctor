package com.github.cukedoctor.multipage.bdd.inception;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InceptionMultipageSteps {
  @Given("I have {int} and {int}")
  public void iHaveAnd(int arg0, int arg1) {}

  @When("I subtract the two numbers")
  public void iSubtractTheTwoNumbers() {}

  @Then("I get {int}")
  public void iGet(int arg0) {}

  @When("I sum the two numbers")
  public void iSumTheTwoNumbers() {}
}
