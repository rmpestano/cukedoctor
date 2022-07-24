package com.github.cukedoctor.extension;

import static com.github.cukedoctor.extension.util.FileUtil.loadTestFile;
import static com.github.cukedoctor.extension.util.FileUtil.readFileContent;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.*;
import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by pestano on 16/08/15.
 */
@RunWith(JUnit4.class)
public class FooterExtensionTest {

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
        System.clearProperty(FOOTER_DISABLE_EXT_KEY);
    }

    @Test
    public void shouldAddFooterToRenderedHtml(){
        File sampleAdoc = loadTestFile("sample.adoc");
        assertThat(sampleAdoc).exists();
        System.setProperty("cukedoctor.stopwatch",String.valueOf(System.currentTimeMillis()));
        asciidoctor.convertFile(sampleAdoc, Options.builder().safe(SafeMode.UNSAFE).build());

        String sampleHtml = readFileContent(loadTestFile("sample.html"));
        assertThat(sampleHtml.replaceAll("\n","").replace("\t","")).isNotEmpty().
                containsOnlyOnce("Generated by    <a href=\"https://github.com/rmpestano/cukedoctor\" target=\"_blank\"> Cukedoctor").
            containsOnlyOnce("Execution time: ");

    }

    @Test
    public void shouldNotAddFooterToRenderedHtmlWhenExtensionDisabled(){
        System.setProperty(FOOTER_DISABLE_EXT_KEY,"anyValue");
        File sampleAdoc = loadTestFile("sample.adoc");
        assertThat(sampleAdoc).exists();
        System.setProperty("cukedoctor.stopwatch",String.valueOf(System.currentTimeMillis()));
        asciidoctor.convertFile(sampleAdoc, Options.builder().safe(SafeMode.UNSAFE).build());

        String sampleHtml = readFileContent(loadTestFile("sample.html"));
        assertThat(sampleHtml.replaceAll("\n","").replace("\t","")).isNotEmpty().
            doesNotContain("Generated by    <a href=\"https://github.com/rmpestano/cukedoctor\" target=\"_blank\"> Cukedoctor").
            doesNotContain("Execution time: ");
    }

}
