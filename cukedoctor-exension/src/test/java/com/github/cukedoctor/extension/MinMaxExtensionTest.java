package com.github.cukedoctor.extension;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

import static com.github.cukedoctor.extension.FileUtil.loadTestFile;
import static com.github.cukedoctor.extension.FileUtil.readFileContent;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * Created by pestano on 16/08/15.
 */
@RunWith(JUnit4.class)
public class MinMaxExtensionTest {

    private static Asciidoctor asciidoctor;

    @BeforeClass
    public static void init(){
        asciidoctor = Asciidoctor.Factory.create();
        asciidoctor.javaExtensionRegistry().blockMacro("minmax", CukedoctorMinMaxExtension.class);
    }

    @AfterClass
    public static void shutdown(){
        if(asciidoctor != null){
            asciidoctor.shutdown();
        }
        File file = loadTestFile("sample.html");
        if(file.exists()){
            file.delete();
        }

    }
    @Test
    public void shouldAddSearchInputToRenderedHtml(){
        File sampleAdoc = loadTestFile("sample.adoc");
        assertThat(sampleAdoc).exists();
        asciidoctor.convertFile(sampleAdoc, OptionsBuilder.options().safe(SafeMode.UNSAFE).asMap());

        String sampleHtml = readFileContent(loadTestFile("sample.html"));
        assertNotNull(sampleHtml);
        assertThat(sampleHtml.replaceAll("\n","").replaceAll("\t","")).
                containsOnlyOnce("<span class=\"fa fa-minus-square fa-fw\" style=\"cursor:pointer;float:right;margin-top:-30px\"  title=\"Minimize\" onclick=\"hideFeatureScenarios('Sample-test');document.getElementById('hidden-Sample-test').style.display = 'inline';this.style.display = 'none'\">  </span>" +
                        "<span id=\"hidden-Sample-test\" class=\"fa fa-plus-square fa-fw\" style=\"cursor:pointer;float:right;display:none;margin-top:-30px\" title=\"Maximize feature\" onclick=\"showFeatureScenarios('Sample-test');this.style.display = 'none'\">  </span>");

    }

}
