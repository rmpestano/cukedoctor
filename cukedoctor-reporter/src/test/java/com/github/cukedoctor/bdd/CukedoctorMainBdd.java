package com.github.cukedoctor.bdd;

import com.github.cukedoctor.reporter.CukedoctorMain;
import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by pestano on 09/06/15.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/cukedoctor/cukedoctor_main.feature", format = {"json:target/cucumber.json"} )
public class CukedoctorMainBdd {




}
