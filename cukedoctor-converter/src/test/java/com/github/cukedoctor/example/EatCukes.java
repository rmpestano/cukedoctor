package com.github.cukedoctor.example;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by pestano on 09/06/15.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/eat-cukes.feature", plugin = {"json:target/cucumber.json","pretty"} )
public class EatCukes {




}
