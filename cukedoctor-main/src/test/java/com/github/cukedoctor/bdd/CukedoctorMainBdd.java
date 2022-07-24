package com.github.cukedoctor.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/** Created by pestano on 09/06/15. */
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/cukedoctor_main.feature",
    plugin = {"json:target/cucumber.json"})
public class CukedoctorMainBdd {}
