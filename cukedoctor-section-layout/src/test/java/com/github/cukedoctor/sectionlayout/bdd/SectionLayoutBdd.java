package com.github.cukedoctor.sectionlayout.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/section-layout.json"} )
public class SectionLayoutBdd {
}