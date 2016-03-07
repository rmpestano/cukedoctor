package com.github.cukedoctor.bdd.sample;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by pestano on 05/03/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = "json:target/sample.json" )
public class SampleBdd {
}
