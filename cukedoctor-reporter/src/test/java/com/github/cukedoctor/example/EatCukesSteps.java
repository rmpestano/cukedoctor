package com.github.cukedoctor.example;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Created by pestano on 09/06/15.
 */
public class EatCukesSteps {


	private Belly belly = new Belly();

	@Given("^I have (\\d+) cukes$")
	public void haveCukes(int cukes) {
		belly.setCukes(cukes);
	}

	@When("^I eat (\\d+) cukes$")
	public void eatCukes(int cukes) {
		belly.setCukes((belly.getCukes() - cukes));
	}

	@Then("^Am I hungry\\? \"([^\"]*)\"$")
	public void amIHungry(String hungry){
		assertEquals(belly.isHungry(), Boolean.parseBoolean(hungry));
	}



}
