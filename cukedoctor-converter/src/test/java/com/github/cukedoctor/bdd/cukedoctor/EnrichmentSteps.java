package com.github.cukedoctor.bdd.cukedoctor;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.net.URL;
import java.util.List;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pestano on 11/03/16.
 */
public class EnrichmentSteps {

    String documentation;


    @When("^I convert docstring enriched json output using cukedoctor converter$")
    public void I_convert_docstring_enriched_json_output_using_cukedoctor_converter() throws Throwable {
        URL featureFile = getClass().getResource("/json-output/discrete/table-and-source.json");
        assertThat(featureFile).isNotNull();
        List<Feature> features = FeatureParser.parse(featureFile.getPath());
        assertThat(features).isNotNull().hasSize(1);
        documentation = Cukedoctor.instance(features).renderFeatures().getDocumentation();
    }

    @Then("^DocString asciidoc output must be rendered in my documentation$")
    public void DocString_asciidoc_output_must_be_rendered_in_my_documentation(String expected) throws Throwable {
        assertThat(expected.replaceAll("\r","")).isEqualTo(("[[Discrete-class-feature, Discrete class feature]]"+newLine() +
                "=== *Discrete class feature*"+newLine() +
                ""+newLine() +
                "==== Scenario: Render source code"+newLine() +
                ""+newLine() +
                "****"+newLine() +
                "Given ::"+newLine() +
                "the following source code icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(267ms)#"+newLine() +
                "******"+newLine() +
                ""+newLine() +
                "[discrete]"+newLine() +
                "[source, java]"+newLine() +
                "-----"+newLine() +
                "public int sum(int x, int y){"+newLine() +
                "    int result = x + y;"+newLine() +
                "    return result; <1>"+newLine() +
                "}"+newLine() +
                "-----"+newLine() +
                "<1> We can have callouts in living documentation>"+newLine() +
                ""+newLine() +
                ""+newLine() +
                "******"+newLine() +
                ""+newLine() +
                "****"+newLine() +
                ""+newLine() +
                "==== Scenario: Render table"+newLine() +
                ""+newLine() +
                "****"+newLine() +
                "Given ::"+newLine() +
                "the following table icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"+newLine() +
                "******"+newLine() +
                ""+newLine() +
                "[discrete]"+newLine() +
                "|==="+newLine() +
                "| Cell in column 1, row 1 | Cell in column 2, row 1"+newLine() +
                "| Cell in column 1, row 2 | Cell in column 2, row 2"+newLine() +
                "| Cell in column 1, row 3 | Cell in column 2, row 3"+newLine() +
                "|==="+newLine() +
                ""+newLine() +
                ""+newLine() +
                "******"+newLine() +
                ""+newLine() +
                "****"+newLine() +
                ""+newLine()).replaceAll("\r",""));
    }
}
