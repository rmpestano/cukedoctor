package com.github.cukedoctor.converter;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.GlobalConfig;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.Expectations;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.DISABLE_ALL_EXT_KEY;
import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.MINMAX_DISABLE_EXT_KEY;
import static com.github.cukedoctor.renderer.Fixtures.*;
import static com.github.cukedoctor.util.Constants.newLine;
import static com.github.cukedoctor.util.StringUtil.trimAllLines;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by pestano on 02/06/15.
 */
@RunWith(JUnit4.class)
public class CukedoctorConverterTest {

    @Before
    public void initProperties() {
        System.setProperty("HIDE_STEP_TIME", GlobalConfig.getInstance().getLayoutConfig().isHideStepTime() + "");
        System.setProperty("HIDE_FEATURES_SECTION", GlobalConfig.getInstance().getLayoutConfig().isHideFeaturesSection() + "");
        System.setProperty("HIDE_SUMMARY_SECTION", GlobalConfig.getInstance().getLayoutConfig().isHideSummarySection() + "");
        System.setProperty("HIDE_SCENARIO_KEYWORD", GlobalConfig.getInstance().getLayoutConfig().isHideScenarioKeyword() + "");
        System.setProperty("HIDE_TAGS", GlobalConfig.getInstance().getLayoutConfig().isHideTags() + "");
    }


    @Test//(expected = RuntimeException.class)
    public void shouldFailToCreateDocumentationWithoutFeatures() {
        String msg = null;
        try {
            Cukedoctor.instance(new ArrayList<Feature>());
        } catch (RuntimeException re) {
            msg = re.getMessage();
        }

        assertEquals("No features found", msg);
    }


    @Test
    public void shouldGeneratePdfTheme() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes().backend("pdf"));
        converter.setFilename("target/pdf/living documentation.adoc");
        String pdfStylePath = Paths.get("").toAbsolutePath().toString().replace("\\", "/") /* Windows path hack */ + "/target/pdf/cukedoctor-pdf.yml";
        FileUtil.copyFileFromClassPath("/cukedoctor-pdf-test.yml", pdfStylePath);
        converter.addCustomPdfTheme();
        String expected = ":toc: right" + newLine() +
                ":backend: pdf" + newLine() +
                ":doctitle: Living Documentation" + newLine() +
                ":doctype: book" + newLine() +
                ":icons: font" + newLine() +
                ":sectanchors:" + newLine() +
                ":sectlink:" + newLine() +
                ":docinfo:" + newLine() +
                ":source-highlighter: highlightjs" + newLine() +
                ":toclevels: 3" + newLine() +
                ":hardbreaks:" + newLine() +
                ":chapter-label: Chapter" + newLine() +
                ":version-label: Version" + newLine() +
                ":pdf-style: " + pdfStylePath + newLine();

        String doc = converter.renderDocumentation();
        assertThat(doc).contains(expected);
        File file = FileUtil.loadFile("target/pdf/cukedoctor-pdf.yml");
        assertThat(file).exists();
        assertTrue(file.delete());
    }


    @Test
    public void shouldNotGeneratePdfThemeWithoutPdfStyleFile() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes().backend("pdf"));
        converter.setFilename("/target/pdf//living documentation.adoc");
        converter.addCustomPdfTheme();
        assertThat(FileUtil.loadFile("target/pdf/cukedoctor-pdf.yml")).doesNotExist();
    }

    @Test
    public void shouldNotGeneratePdfThemeForHtmlBackend() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes().backend("html"));
        converter.setFilename("/target/pdf//living documentation.adoc");
        converter.addCustomPdfTheme();
        assertThat(FileUtil.loadFile("target/pdf/cukedoctor-pdf.yml")).doesNotExist();
    }

    @Test
    public void shouldNotSetInvalidFilename() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes().docTitle("Doc Title"));

        converter.setFilename("test");
        assertThat(converter.getFilename()).isEqualTo("test.adoc");
        try {
            converter.setFilename("test.txt");
        } catch (RuntimeException re) {
            assertThat(re.getMessage()).isEqualTo("Invalid filename extension for file: test.txt. Valid formats are: ad, adoc, asciidoc and asc");
        }

        try {
            converter.setFilename("test.doc");
        } catch (RuntimeException re) {
            assertThat(re.getMessage()).isEqualTo("Invalid filename extension for file: test.doc. Valid formats are: ad, adoc, asciidoc and asc");
        }

        converter.setFilename("test.ad");
        assertThat(converter.getFilename()).isEqualTo("test.ad");
    }


    @Test
    public void shouldRenderDocumentationForOneFeature() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("left").backend("html5")
                .docType("book").docTitle("Living Documentation")
                .icons("font")
                .sectAnchors(true).sectLink(true)
                .chapterLabel("Chapter")
                .versionLabel("Version");

        CukedoctorConverter converter = Cukedoctor.instance(features, attrs);
        converter.setFilename("/target/living_documentation.adoc");
        String resultDoc = converter.renderDocumentation();

        assertThat(resultDoc).isNotNull().
                containsOnlyOnce(":doctype: book" + newLine()).
                containsOnlyOnce(":toc: left" + newLine()).
                containsOnlyOnce("= *Living Documentation*" + newLine()).
                containsOnlyOnce("<<One-passing-scenario-one-failing-scenario>>").
                containsOnlyOnce("|[red]#*failed*#").
                contains("|010ms").
                containsOnlyOnce("|1|1|2|1|1|0|0|0|0|2 2+|010ms");

        FileUtil.saveFile("target/test-docs/doc_one_feature.adoc", resultDoc); //save to target/test-docs folder
        assertThat(resultDoc.replaceAll("\r", "")).isEqualTo(Expectations.DOCUMENTATION_FOR_ONE_FEATURE.replaceAll("\r", ""));
    }

    @Test
    public void shouldRenderDocumentationForMultipleFeatures() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing, embedDataDirectly, outline, invalidFeatureResult);

        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("left").backend("html5")
                .docType("book").docTitle("Living Documentation")
                .icons("font")
                .sectAnchors(true).sectLink(true)
                .chapterLabel("Chapter")
                .versionLabel("Version");

        CukedoctorConverter converter = Cukedoctor.instance(features, attrs);
        converter.setFilename("target/living_documentation.adoc");
        String resultDoc = converter.renderDocumentation();
        assertThat(resultDoc).isNotNull().
                containsOnlyOnce(":doctype: book" + newLine()).
                containsOnlyOnce(":toc: left" + newLine()).
                contains("= *Living Documentation*" + newLine()).
                containsOnlyOnce("<<One-passing-scenario-one-failing-scenario>>").
                containsOnlyOnce("<<An-embed-data-directly-feature>>").
                containsOnlyOnce("<<An-outline-feature>>").
                doesNotContain("<<invalid-feature-result*>>").
                contains("|[green]#*passed*#").
                containsOnlyOnce("|[red]#*failed*#").
                contains("|010ms").
                containsOnlyOnce("|4|1|5|4|1|0|0|0|0|5 2+|010ms");

        FileUtil.saveFile("target/test-docs/doc_multiple_feature.adoc", resultDoc); //save to target/test-docs folder
        assertThat(resultDoc.replaceAll("\r", "")).isEqualTo(Expectations.DOCUMENTATION_FOR_MULTIPLE_FEATURES.replaceAll("\r", ""));
    }

    @Test
    public void shouldRenderDocumentationWithoutFeaturesSection() {
        System.setProperty("HIDE_FEATURES_SECTION", "true");
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("left").backend("html5")
                .docType("book").docTitle("Living Documentation")
                .icons("font")
                .sectAnchors(true).sectLink(true)
                .chapterLabel("Chapter")
                .versionLabel("Version");

        CukedoctorConverter converter = Cukedoctor.instance(features, attrs);
        converter.setFilename("/target/living_documentation.adoc");
        String resultDoc = converter.renderDocumentation();

        assertThat(resultDoc).isNotNull().
                containsOnlyOnce(":doctype: book" + newLine()).
                containsOnlyOnce(":toc: left" + newLine()).
                containsOnlyOnce("= *Living Documentation*" + newLine()).
                containsOnlyOnce("<<One-passing-scenario-one-failing-scenario>>").
                containsOnlyOnce("|[red]#*failed*#").
                contains("|010ms").
                containsOnlyOnce("|1|1|2|1|1|0|0|0|0|2 2+|010ms");

        FileUtil.saveFile("target/test-docs/doc_without_features_sect.adoc", resultDoc); //save to target/test-docs folder
        assertThat(resultDoc.replaceAll("\r", "")).isEqualTo(Expectations.DOCUMENTATION_WITHOUT_FEATURES_SECTION.replaceAll("\r", ""));
    }

    @Test
    public void shouldRenderDocumentationWithoutFeaturesAndSummarySection() {
        System.setProperty("HIDE_FEATURES_SECTION", "true");
        System.setProperty("HIDE_SUMMARY_SECTION", "true");
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("left").backend("html5")
                .docType("book").docTitle("Living Documentation")
                .icons("font")
                .sectAnchors(true).sectLink(true)
                .chapterLabel("Chapter");

        CukedoctorConverter converter = Cukedoctor.instance(features, attrs);
        converter.setFilename("/target/living_documentation.adoc");
        String resultDoc = converter.renderDocumentation();

        assertThat(resultDoc).isNotNull().
                containsOnlyOnce(":doctype: book" + newLine()).
                containsOnlyOnce(":toc: left" + newLine()).
                containsOnlyOnce("= *Living Documentation*" + newLine()).
                doesNotContain("<<One-passing-scenario-one-failing-scenario>>");

        FileUtil.saveFile("target/test-docs/doc_without_features_sect.adoc", resultDoc); //save to target/test-docs folder
        assertThat(resultDoc.replaceAll("\r", "")).isEqualTo(Expectations.DOCUMENTATION_WITHOUT_FEATURES_AND_SUMMARY_SECTIONS.replaceAll("\r", ""));
    }

    @Test
    public void shouldRenderDocumentationWithoutScenarioKeyword() {
        System.setProperty("HIDE_SCENARIO_KEYWORD", "true");
        System.setProperty("HIDE_FEATURES_SECTION", "true");
        System.setProperty("HIDE_SUMMARY_SECTION", "true");
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("left").backend("html5")
                .docType("book").docTitle("Living Documentation")
                .icons("font")
                .sectAnchors(true).sectLink(true)
                .chapterLabel("Chapter")
                .versionLabel("Version");

        CukedoctorConverter converter = Cukedoctor.instance(features, attrs);
        converter.setFilename("target/living_documentation.adoc");
        String resultDoc = converter.renderDocumentation();
        assertThat(resultDoc.replaceAll("\r", "")).isEqualTo(Expectations.DOCUMENTATION_WITHOUT_SCENARIO_KEYWORD.replaceAll("\r", ""));
    }

    @Test
    public void shouldRenderDocumentationWithoutStepTime() {
        System.setProperty("HIDE_STEP_TIME", "true");
        System.setProperty("HIDE_FEATURES_SECTION", "true");
        System.setProperty("HIDE_SUMMARY_SECTION", "true");
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("left").backend("html5")
                .docType("book").docTitle("Living Documentation")
                .icons("font")
                .sectAnchors(true).sectLink(true)
                .chapterLabel("Chapter")
                .versionLabel("Version");

        CukedoctorConverter converter = Cukedoctor.instance(features, attrs);
        converter.setFilename("target/living_documentation.adoc");
        String resultDoc = converter.renderDocumentation();
        assertThat(resultDoc.replaceAll("\r", "")).isEqualTo(Expectations.DOCUMENTATION_WITHOUT_STEP_TIME.replaceAll("\r", ""));
    }

    @Test
    public void shouldRenderDocumentationWithoutTags() {
        System.setProperty("HIDE_STEP_TIME", "true");
        System.setProperty("HIDE_FEATURES_SECTION", "true");
        System.setProperty("HIDE_SUMMARY_SECTION", "true");
        System.setProperty("HIDE_TAGS", "true");
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("left").backend("html5")
                .docType("book").docTitle("Living Documentation")
                .icons("font")
                .sectAnchors(true).sectLink(true)
                .chapterLabel("Chapter")
                .versionLabel("Version");

        CukedoctorConverter converter = Cukedoctor.instance(features, attrs);
        converter.setFilename("target/living_documentation.adoc");
        String resultDoc = converter.renderDocumentation();
        assertThat(resultDoc.replaceAll("\r", "")).isEqualTo(Expectations.DOCUMENTATION_WITHOUT_TAGS.replaceAll("\r", ""));
    }


    @Test
    public void shouldRenderFeatureDescriptionWithNewLines() {
        List<Feature> features = FeatureParser.parse(FileUtil.findJsonFile("target/test-classes/json-output/sample.json"));
        assertThat(features).hasSize(1);
        CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());
        converter.setFilename("target/living_documentation.adoc");
        String resultDoc = converter.renderDocumentation().replaceAll("\r\n", newLine());
        assertThat(trimAllLines(resultDoc)).contains("****" + newLine() +
                "As a user" + newLine() +
                "I want to do something" + newLine() +
                "In order to achieve an important goal" + newLine() +
                "****");
        FileUtil.saveFile("target/sample.adoc", resultDoc);
    }


    @Test
    public void shouldSaveDocumentationIntoDisk() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);

        CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());
        converter.setFilename("target/generated-test-sources/living documentation.adoc");

        converter.saveDocumentation();
        assertThat(FileUtil.loadFile("target/generated-test-sources/living_documentation.adoc")).exists();
    }

    @Test
    public void shouldRenderDocumentationForScenariosWithoutDescription() {
        List<Feature> features = FeatureParser.parse(getClass().getResource("/json-output/scenario_without_description.json").getPath());


        CukedoctorConverter converter = Cukedoctor.instance(features);
        converter.setFilename("target/living_documentation.adoc");
        String resultDoc = converter.renderDocumentation();
        assertThat(resultDoc).isNotNull().
                containsOnlyOnce("= *Documentation*" + newLine()).
                containsOnlyOnce("=== *Do something*" + newLine()).
                containsOnlyOnce("==== Scenario: User browses to the site successfully" + newLine()).
                containsOnlyOnce("User opens a browser").
                containsOnlyOnce("|1|0|1|1|0|0|0|0|0|1 2+|000ms");

        assertThat(resultDoc.replaceAll("\r", "")).isEqualTo(Expectations.DOCUMENTATION_WITH_SCENARIO_WITHOUT_DESCRIPTION.replaceAll("\r", ""));
    }

    @Test
    public void shouldNotWriteMinmaxMacroWhenExtensionIsDisabled() {
        System.setProperty(MINMAX_DISABLE_EXT_KEY,"true");
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        String resultDoc = Cukedoctor.instance(features, new DocumentAttributes().docTitle("Title")).renderDocumentation();
        assertThat(resultDoc).isNotNull().
                doesNotContain("minmax");
        System.clearProperty(MINMAX_DISABLE_EXT_KEY);
    }

    @Test
    public void shouldNotWriteMinmaxMacroWhenAllExtensionsAreDisabled() {
        System.setProperty(DISABLE_ALL_EXT_KEY,"true");
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        String resultDoc = Cukedoctor.instance(features, new DocumentAttributes().docTitle("Title")).renderDocumentation();
        assertThat(resultDoc).isNotNull().
                doesNotContain("minmax");
        System.clearProperty(DISABLE_ALL_EXT_KEY);
    }

    @Test
    public void shouldWriteMinmaxMacroWhenExtensionIsEnabled() {
        System.clearProperty(MINMAX_DISABLE_EXT_KEY);
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        String resultDoc = Cukedoctor.instance(features, new DocumentAttributes().docTitle("Title")).renderDocumentation();
        assertThat(resultDoc).isNotNull().
                contains("minmax");
    }

    @Test
    public void shouldRenderIntroChapterUsingAbsolutePath() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        String resultDoc = Cukedoctor.instance(features, new DocumentAttributes()).renderDocumentation();
        assertThat(resultDoc).containsOnlyOnce("/cukedoctor-converter/target/test-classes/cukedoctor-intro.adoc[leveloffset=+1]");
    }

    @Test
    public void shouldRenderIntroChapterUsingRelativePath() {
        try {
            System.setProperty("INTRO_CHAPTER_RELATIVE_PATH", Paths.get("").toAbsolutePath().toString());
            List<Feature> features = FeatureParser.parse(onePassingOneFailing);
            String resultDoc = Cukedoctor.instance(features, new DocumentAttributes()).renderDocumentation();
            assertThat(resultDoc).doesNotContain("/cukedoctor-converter/target/test-classes/cukedoctor-intro.adoc[leveloffset=+1]");
            assertThat(resultDoc).containsOnlyOnce("target/test-classes/cukedoctor-intro.adoc[leveloffset=+1]");

        }finally {
            System.clearProperty("INTRO_CHAPTER_RELATIVE_PATH");
        }
    }

    @Test
    public void shouldRenderFeatureWithTableInSteps() {
        List<Feature> features = FeatureParser.parse(featureWithTableInStep);
        CukedoctorConverter converter = Cukedoctor.instance(features, GlobalConfig.getInstance().getDocumentAttributes().docTitle("Doc Title"));
        String resultDoc = converter.renderDocumentation();
        assertThat(resultDoc.replaceAll("\r", "")).isEqualTo(Expectations.FEATURE_WITH_STEP_TABLE_IN_PT_BR.replaceAll("\r", ""));
    }
}