package com.github.cukedoctor.util;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by rafael-pestano on 08/06/2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "cukedoctor/file.feature", plugin = "json:target/cukedoctor-report.json")
public class FileUtilBdd {
}
