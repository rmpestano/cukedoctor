package com.github.cukedoctor.extension;

import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.*;
import static com.github.cukedoctor.extension.util.FileUtil.loadTestFile;
import static com.github.cukedoctor.extension.util.FileUtil.readFileContent;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.File;
import java.nio.file.Paths;

import com.github.cukedoctor.extension.util.FileUtil;
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
public class AdminThemeExtensionTest {

    private static Asciidoctor asciidoctor;

    @BeforeClass
    public static void init(){
        System.clearProperty(CUKEDOCTOR_LEGACY_THEME);
        asciidoctor = Asciidoctor.Factory.create();
    }

    @AfterClass
    public static void shutdown(){
        if(asciidoctor != null){
            asciidoctor.shutdown();
        }
    }

    @Before
    @After
    public void enableAllExtensions(){
        System.clearProperty(STYLE_DISABLE_EXT_KEY);
    }



    @Test
    public void shouldRenderCukedoctorAdminThemeHtml(){
        File sampleAdoc = loadTestFile("sample.adoc");
        assertThat(sampleAdoc).exists();
        String customCssPath = Paths.get("").toAbsolutePath() + "/target/cukedoctor.css";
        FileUtil.copyFileFromClassPath("/cukedoctor-test.css", customCssPath);
        asciidoctor.convertFile(sampleAdoc, OptionsBuilder.options().safe(SafeMode.UNSAFE).asMap());

        String sampleHtml = readFileContent(loadTestFile("sample.html"));
        assertThat(sampleHtml).isNotEmpty()
                .contains("theme/js/bootstrap.min.js")
                .contains("theme/js/adminlte.min.js")
                .contains("theme/css/bootstrap.min.css")
                .contains("theme/css/adminlte.min.css")
                .contains("<body class=\"skin-blue sidebar-mini fixed\">")
                .contains("<aside class=\"main-sidebar\">")
                .contains("<li class=\"header\">Features</li>")
                .contains("<li class=\"header\">Scenarios</li>");
                

    }

}
