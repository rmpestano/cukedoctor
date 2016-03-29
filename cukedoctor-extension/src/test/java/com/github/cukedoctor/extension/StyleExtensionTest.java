package com.github.cukedoctor.extension;

import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.*;
import static com.github.cukedoctor.extension.FileUtil.loadTestFile;
import static com.github.cukedoctor.extension.FileUtil.readFileContent;
import static org.assertj.core.api.Assertions.assertThat;
import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.*;
import java.io.File;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.asciidoctor.SafeMode;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by pestano on 16/08/15.
 */
@RunWith(JUnit4.class)
public class StyleExtensionTest {

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
        System.clearProperty(STYLE_DISABLE_EXT_KEY);
    }

    @Test
    public void shouldAddStyleToRenderedHtml(){
        File sampleAdoc = loadTestFile("sample.adoc");
        assertThat(sampleAdoc).exists();
        asciidoctor.convertFile(sampleAdoc, OptionsBuilder.options().safe(SafeMode.UNSAFE).asMap());

        String sampleHtml = readFileContent(loadTestFile("sample.html"));
        assertThat(sampleHtml).isNotEmpty().
                containsOnlyOnce(".sidebarblock, .sectionbody, .content{overflow:auto!important;}");

    }


    @Test
    public void shouldDisableStyleExtension(){
        System.setProperty(STYLE_DISABLE_EXT_KEY,"anyValue");
        File sampleAdoc = loadTestFile("sample.adoc");
        assertThat(sampleAdoc).exists();
        asciidoctor.convertFile(sampleAdoc, OptionsBuilder.options().safe(SafeMode.UNSAFE).asMap());

        String sampleHtml = readFileContent(loadTestFile("sample.html"));
        assertThat(sampleHtml).isNotEmpty().
                doesNotContain(".sidebarblock, .sectionbody, .content{overflow:auto!important;}");
    }



}
