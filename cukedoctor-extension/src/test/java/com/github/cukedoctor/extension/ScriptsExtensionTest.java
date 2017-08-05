package com.github.cukedoctor.extension;
import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.*;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.*;

import static com.github.cukedoctor.extension.util.FileUtil.loadTestFile;
import static com.github.cukedoctor.extension.util.FileUtil.readFileContent;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pestano on 16/08/15.
 */
@RunWith(JUnit4.class)
public class ScriptsExtensionTest {

    private static Asciidoctor asciidoctor;

    @BeforeClass
    public static void init(){
        asciidoctor = Asciidoctor.Factory.create();
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

    @Before
    @After
    public void enableAllExtensions(){
        System.clearProperty(THEME_DISABLE_EXT_KEY);
        System.clearProperty(FILTER_DISABLE_EXT_KEY);
        System.clearProperty(MINMAX_DISABLE_EXT_KEY);
    }

    @Test
    public void shouldAddScriptsToRenderedHtml(){
        File sampleAdoc = loadTestFile("sample.adoc");
        assertThat(sampleAdoc).exists();
        asciidoctor.convertFile(sampleAdoc, OptionsBuilder.options().safe(SafeMode.UNSAFE).asMap());

        String sampleHtml = readFileContent(loadTestFile("sample.html"));
        assertThat(sampleHtml).isNotEmpty().
                containsOnlyOnce("searchFeature(criteria)").
                containsOnlyOnce("function showFeatureScenarios(featureId)").
                containsOnlyOnce("function themefy()");

    }


    @Test
    public void shouldDisableThemeExtension(){
        System.setProperty(THEME_DISABLE_EXT_KEY,"anyValue");
        File sampleAdoc = loadTestFile("sample.adoc");
        assertThat(sampleAdoc).exists();
        asciidoctor.convertFile(sampleAdoc, OptionsBuilder.options().safe(SafeMode.UNSAFE).asMap());

        String sampleHtml = readFileContent(loadTestFile("sample.html"));
        assertThat(sampleHtml).isNotEmpty().
                containsOnlyOnce("searchFeature(criteria)").
                containsOnlyOnce("function showFeatureScenarios(featureId)").
                doesNotContain("function themefy()");
    }

    @Test
    public void shouldDisableFilterExtension(){
        System.setProperty(FILTER_DISABLE_EXT_KEY,"anything");
        File sampleAdoc = loadTestFile("sample.adoc");
        assertThat(sampleAdoc).exists();
        asciidoctor.convertFile(sampleAdoc, OptionsBuilder.options().safe(SafeMode.UNSAFE).asMap());

        String sampleHtml = readFileContent(loadTestFile("sample.html"));
        assertThat(sampleHtml).isNotEmpty().
                doesNotContain("searchFeature(criteria)").
                containsOnlyOnce("function showFeatureScenarios(featureId)").
                containsOnlyOnce("function themefy()");
    }

    @Test
    public void shouldDisableMinMaxExtension(){
        System.setProperty(MINMAX_DISABLE_EXT_KEY,"any");
        File sampleAdoc = loadTestFile("sample.adoc");
        assertThat(sampleAdoc).exists();
        asciidoctor.convertFile(sampleAdoc, OptionsBuilder.options().safe(SafeMode.UNSAFE).asMap());

        String sampleHtml = readFileContent(loadTestFile("sample.html"));
        assertThat(sampleHtml).isNotEmpty().
                containsOnlyOnce("searchFeature(criteria)").
                doesNotContain("function showFeatureScenarios(featureId)").
                containsOnlyOnce("function themefy()");
    }



}
