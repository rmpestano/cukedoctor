package com.github.cukedoctor.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by pestano on 09/06/15.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/cukedoctor_main.feature", format = {"json:target/cucumber.json"} )
public class CukedoctorMainBdd {

}
