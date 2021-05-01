package com.github.cukedoctor.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Created by pestano on 09/06/15.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/eat-cukes.feature", plugin = {"json:target/cucumber.json","pretty"} )
public class EatCukes {




}
