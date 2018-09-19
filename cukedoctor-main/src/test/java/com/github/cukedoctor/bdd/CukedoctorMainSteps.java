package com.github.cukedoctor.bdd;

import com.github.cukedoctor.CukedoctorMain;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Created by pestano on 09/06/15.
 */
public class CukedoctorMainSteps {


	String generatedDoc;


	@Given("^A Cucumber json execution file is are already generated$")
	public void A_Cucumber_json_execution_file_is_are_already_generated() throws Throwable {
	}

	@Given("^Cucumber multiple json execution files are already generate$")
	public void Cucumber_multiple_json_execution_files_are_already_generate() throws Throwable {
	}


	@When("^I execute CukedoctorMain with args \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
	public void I_execute_CukedoctorMain_with_args_and(String arg1, String arg2, String arg3) throws Throwable {
		String[] args = new String[6];

		args[0] = arg1.split(" ")[0];
		args[1] = arg1.split(" ")[1];
		args[2] = arg2.split(" ")[0];
		args[3] = arg2.split(" ")[1];
		args[4] = arg3.split(" ")[0];
		args[5] = arg3.split(" ")[1];
		generatedDoc = new CukedoctorMain().execute(args);

	}

	@Then("^A file named outputFile.adoc should be generated with the following content:$")
	public void A_file_named_outputFile_adoc_should_be_generated_with_the_following_content(final String fileContent) throws Throwable {
	    assertEquals(fileContent.replaceAll(" ", "").replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", ""), generatedDoc.replaceAll("\r", "").replaceAll("\n", "").replaceAll("\t", "").replaceAll(" ",""));
	}



}
