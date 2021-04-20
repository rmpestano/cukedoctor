package com.github.cukedoctor.multipage.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/json-output/multipage-layout.json"}, features = {"classpath:com/github/cukedoctor/multipage/bdd"})
public class MultipageConverterTest {

}
