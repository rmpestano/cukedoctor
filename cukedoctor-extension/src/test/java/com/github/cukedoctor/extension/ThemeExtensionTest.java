package com.github.cukedoctor.extension;
import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.*;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

import static com.github.cukedoctor.extension.util.FileUtil.loadTestFile;
import static com.github.cukedoctor.extension.util.FileUtil.readFileContent;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pestano on 16/08/15.
 */
@RunWith(JUnit4.class)
public class ThemeExtensionTest {

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
    public void enableExtension(){
        System.clearProperty(THEME_DISABLE_EXT_KEY);
    }

    @Test
    public void shouldAddThemesToRenderedHtml(){
        System.clearProperty(THEME_DISABLE_EXT_KEY);
        File sampleAdoc = loadTestFile("sample.adoc");
        assertThat(sampleAdoc).exists();
        asciidoctor.convertFile(sampleAdoc, OptionsBuilder.options().safe(SafeMode.UNSAFE).asMap());

        String sampleHtml = readFileContent(loadTestFile("sample.html"));
        assertThat(sampleHtml).isNotEmpty().
                containsOnlyOnce("<div name=\"themes\" id=\"themes\"");

    }

    @Test
    public void shouldNotAddThemeToRenderedHtmlWhenExtensionDisabled(){
        System.setProperty(THEME_DISABLE_EXT_KEY,"anyValue");
        File sampleAdoc = loadTestFile("sample.adoc");
        assertThat(sampleAdoc).exists();
        asciidoctor.convertFile(sampleAdoc, OptionsBuilder.options().safe(SafeMode.UNSAFE).asMap());

        String sampleHtml = readFileContent(loadTestFile("sample.html"));
        assertThat(sampleHtml).isNotEmpty().
            doesNotContain("<div name=\"themes\" id=\"themes\"");
    }

}
