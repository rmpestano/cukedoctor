package com.github.cukedoctor.bdd.sample;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/** Created by pestano on 05/03/16. */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = "json:target/sample.json")
public class SampleBdd {}
