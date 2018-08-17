package com.github.cukedoctor.example;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.CukedoctorMain;
import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.GlobalConfig;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.Constants;
import com.github.cukedoctor.util.FileUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.util.List;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pestano on 27/02/16.
 */
@RunWith(JUnit4.class)
public class CustomRendererTest {

    private static String calcFeature;


    @BeforeClass
    public static void loadFeatures() {
        calcFeature = FileUtil.findJsonFile("target/test-classes/json-output/calc.json");
    }

    @Test
    public void shouldRenderCustomSummaryRenderer(){
        List<Feature> features = FeatureParser.parse(calcFeature);

        DocumentAttributes attrs = GlobalConfig.getInstance().getDocumentAttributes();
                attrs.docTitle("Living Documentation")
                .icons("font").numbered(false)
                .sectAnchors(true).sectLink(true);

        CukedoctorConverter converter = Cukedoctor.instance(features, attrs);

        String resultDoc = converter.renderSummary().getDocumentation();
        assertThat(resultDoc).isEqualTo("== *Summary*" + newLine() +
                "This is a custom summary renderer" + newLine() +
                "" + newLine() +
                "Number of features: 1" + newLine() +
                "" + newLine() +
                "Passed steps: 5" + newLine() +
                "" + newLine() +
                "Failed steps: 1" + newLine() + newLine());
    }

    @Test
    public void shouldRenderDocumentationUsingCustomRenderers(){
        List<Feature> features = FeatureParser.parse(calcFeature);

        DocumentAttributes attrs = GlobalConfig.getInstance().getDocumentAttributes();
        attrs.docTitle("Living Documentation")
                .icons("font").numbered(false)
                .sectAnchors(true).sectLink(true);

        CukedoctorConverter converter = Cukedoctor.instance(features, attrs);
        String resultDoc = converter.renderDocumentation();
        assertThat(resultDoc).isEqualTo(":toc: right" + newLine() +
                ":backend: html5" + newLine() +
                ":doctitle: Living Documentation" + newLine() +
                ":doctype: book" + newLine() +
                ":icons: font" + newLine() +
                ":!numbered:" + newLine() +
                ":!linkcss:" + newLine() +
                ":sectanchors:" + newLine() +
                ":sectlink:" + newLine() +
                ":docinfo:" + newLine() +
                ":source-highlighter: highlightjs\n:toclevels: 3\n:hardbreaks:" + newLine() +
                ":chapter-label: Chapter"+newLine() +
                ":version-label: Version"+newLine() +
                "" + newLine() +
                "= *Living Documentation*" + newLine() +
                "" + newLine() +
                "== *Summary*" + newLine() +
                "This is a custom summary renderer" + newLine() +
                "" + newLine() +
                "Number of features: 1" + newLine() +
                "" + newLine() +
                "Passed steps: 5" + newLine() +
                "" + newLine() +
                "Failed steps: 1" + newLine() +
                "" + newLine() +
                "== *Features*" + newLine() +
                "" + newLine() +
                "*Calculator*::" + newLine() +
                "" + newLine() +
                "  Adding numbers:::" + newLine() +
                "+" + newLine() +
                "****" + newLine() +
                "Given ::" + newLine() +
                 Constants.Markup.exampleBlock() + newLine() +
                "I have numbers 1 and 2 icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(155ms)#" + newLine() +
                 Constants.Markup.exampleBlock() + newLine() +
                "When ::" + newLine() +
                 Constants.Markup.exampleBlock() + newLine() +
                "I sum the numbers icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +
                Constants.Markup.exampleBlock() + newLine() +
                "Then ::" + newLine() +
                Constants.Markup.exampleBlock() + newLine() +
                "I should have 3 as result icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#" + newLine() +
                Constants.Markup.exampleBlock() + newLine() +
                "****" + newLine() +
                "" + newLine() +
                "  Subtracting numbers:::" + newLine() +
                "A feature with a failing step"+newLine()+
                "+" + newLine() +
                "****" + newLine() +
                "Given ::" + newLine() +
                Constants.Markup.exampleBlock() + newLine() +
                "I have numbers 2 and 1 icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +
                Constants.Markup.exampleBlock() + newLine() +
                "When ::" + newLine() +
                Constants.Markup.exampleBlock() + newLine() +
                "I subtract the numbers icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +
                Constants.Markup.exampleBlock() + newLine() +
                "Then ::" + newLine() +
                Constants.Markup.exampleBlock() + newLine() +
                "I should have 0 as result icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(000ms)#" + newLine() +
                "" + newLine() +
                "IMPORTANT: java.lang.AssertionError: expected:<0> but was:<1>" + newLine() +
                "\tat org.junit.Assert.fail(Assert.java:88)" + newLine() +
                "\tat org.junit.Assert.failNotEquals(Assert.java:743)" + newLine() +
                "\tat org.junit.Assert.assertEquals(Assert.java:118)" + newLine() +
                "\tat org.junit.Assert.assertEquals(Assert.java:555)" + newLine() +
                "\tat org.junit.Assert.assertEquals(Assert.java:542)" + newLine() +
                "\tat com.github.cukedoctor.example.bdd.CalcStepDef.I_should_have_result(CalcStepDef.java:37)" + newLine() +
                "\tat ✽.Then I should have 0 as result(src/test/resources/features/calc.feature:14)" + newLine() +
                "" + newLine() +
                Constants.Markup.exampleBlock() + newLine() +
                "****" + newLine() +
                "" + newLine());
        //FileUtil.saveFile("target/test-docs/calc.adoc", resultDoc);
    }

    @Test
    public void shouldRenderHtmlForOneFeature(){
        CukedoctorMain main = new CukedoctorMain();
        main.execute(new String[] {
                "-o", "\"target/calc\"",
                "-p", "\"target/test-classes/json-output/calc.json\"",
                "-t", "Living Documentation",
                "-f", "html"

        });

        File generatedFile = FileUtil.loadFile("target/calc.html");
        assertThat(generatedFile).exists();
    }


}
