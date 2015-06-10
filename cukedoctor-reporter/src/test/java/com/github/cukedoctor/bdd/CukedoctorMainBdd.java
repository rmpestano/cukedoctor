package com.github.cukedoctor.bdd;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by pestano on 09/06/15.
 */
public class CukedoctorMainBdd {
	@Given("^Cucumeber json output file located at \"([^\"]*)\"$")
	public void Cucumeber_json_output_file_located_at(String arg1) throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@And("^cukedoctor.jar file$")
	public void cukedoctor_jar_file() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@When("^I run java -jar cukedoctor.jar -n\"([^\"]*)\" -p\"([^\"]*)\"$")
	public void I_run_java_jar_cukedoctor_jar_n_p(String arg1, String arg2) throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Then("^A file named outputFile.adoc should be generated with the following content:$")
	public void A_file_named_outputFile_adoc_should_be_generated_with_the_following_content(final String fileContent) throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}
}
