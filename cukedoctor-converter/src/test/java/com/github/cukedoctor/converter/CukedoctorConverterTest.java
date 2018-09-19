package com.github.cukedoctor.converter;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.config.GlobalConfig;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.renderer.CukedoctorSummaryRenderer;
import com.github.cukedoctor.spi.SummaryRenderer;
import com.github.cukedoctor.util.Expectations;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.DISABLE_ALL_EXT_KEY;
import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.MINMAX_DISABLE_EXT_KEY;
import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by pestano on 02/06/15.
 */
@RunWith(JUnit4.class)
public class CukedoctorConverterTest {

    private static String onePassingOneFailing;
    private static String embedDataDirectly;
    private static String outline;
    private static String invalidFeatureResult;

    @BeforeClass
    public static void loadFeatures() {
        onePassingOneFailing = FileUtil.findJsonFile("target/test-classes/json-output/one_passing_one_failing.json");
        embedDataDirectly = FileUtil.findJsonFile("target/test-classes/json-output/embed_data_directly.json");
        outline = FileUtil.findJsonFile("target/test-classes/json-output/outline.json");
        invalidFeatureResult = FileUtil.findJsonFile("target/test-classes/json-output/invalid_feature_result.json");
    }

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


    // renderAttributes() tests

    @Test
    public void shouldRenderAttributes() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());

        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("right").backend("html5")
                .docType("article").docTitle("Title")
                .icons("font").numbered(false)
                .sectAnchors(true).sectLink(true)
                .chapterLabel("Chapter")
                .versionLabel("Version");

        String expected =
                ":toc: right" + newLine() +
                        ":backend: html5" + newLine() +
                        ":doctitle: Title" + newLine() +
                        ":doctype: article" + newLine() +
                        ":icons: font" + newLine() +
                        ":!numbered:" + newLine() +
                        ":!linkcss:" + newLine() +
                        ":sectanchors:" + newLine() +
                        ":sectlink:" + newLine() +
                        ":docinfo:" + newLine() +
                        ":source-highlighter: highlightjs\n:toclevels: 3\n:hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine();


        attrs.docTitle("Title");
        String document = Cukedoctor.instance(features, attrs).renderAttributes().
                getDocumentation().toString();
        assertEquals(expected, document);
    }


    @Test
    public void shouldRenderAttributesUsingDefaultConfig() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());


        String expected = ":toc: right" + newLine() +
                ":backend: html5" + newLine() +
                ":doctitle: Living Documentation" + newLine() +
                ":doctype: book" + newLine() +
                ":icons: font" + newLine() +
                ":!numbered:" + newLine() +
                ":!linkcss:" + newLine() +
                ":sectanchors:" + newLine() +
                ":sectlink:" + newLine() +
                ":docinfo:" + newLine() +
                ":source-highlighter: highlightjs" + newLine() + ":toclevels: 3" + newLine() + ":hardbreaks:" + newLine() +
                ":chapter-label: Chapter"+ newLine() +
                ":version-label: Version"+ newLine();


        String document = Cukedoctor.instance(features, new DocumentAttributes()).renderAttributes().
                getDocumentation().toString();
        assertEquals(expected, document);
    }

    @Test
    public void shouldRenderAttributesUsingGlobalConfig() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());


        String expected = ":toc: right" + newLine() +
                ":backend: html5" + newLine() +
                ":doctitle: Living Documentation" + newLine() +
                ":doctype: book" + newLine() +
                ":icons: font" + newLine() +
                ":!numbered:" + newLine() +
                ":!linkcss:" + newLine() +
                ":sectanchors:" + newLine() +
                ":sectlink:" + newLine() +
                ":docinfo:" + newLine() +
                ":source-highlighter: highlightjs" + newLine() + ":toclevels: 3" + newLine() + ":hardbreaks:" + newLine() +
                ":chapter-label: Chapter"+newLine() +
                ":version-label: Version"+newLine();


        String document = Cukedoctor.instance(features, GlobalConfig.newInstance().getDocumentAttributes()).renderAttributes().
                getDocumentation().toString();
        assertEquals(expected, document);
    }

    @Test
    public void shouldNotRenderAttributesWhenNoDocAttrIsProvided() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());


        String document = Cukedoctor.instance(features).renderAttributes().
                getDocumentation().toString();
        assertEquals("", document);
    }

    @Test
    public void shouldNotRenderAttributesPassingNullDocAttrs() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());

        String document = Cukedoctor.instance(features, null).renderAttributes().
                getDocumentation().toString();
        assertEquals("", document);
    }

    @Test
    public void shouldRenderAttributesWithoutToc() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());

        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("").backend("html5")
                .docType("article").docTitle("Title")
                .icons("font").numbered(false)
                .sectAnchors(true).sectLink(true)
                .chapterLabel("Chapter")
                .versionLabel("Version");

        String expected =
                ":backend: html5" + newLine() +
                        ":doctitle: Title" + newLine() +
                        ":doctype: article" + newLine() +
                        ":icons: font" + newLine() +
                        ":!numbered:" + newLine() +
                        ":!linkcss:" + newLine() +
                        ":sectanchors:" + newLine() +
                        ":sectlink:" + newLine() +
                        ":docinfo:" + newLine() +
                        ":source-highlighter: highlightjs\n:toclevels: 3\n:hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine();

        attrs.docTitle("Title");
        String document = Cukedoctor.instance(features, attrs).renderAttributes().
                getDocumentation().toString();
        assertEquals(expected, document);
    }

    @Test
    public void shouldRenderAttributesWithoutHardbreaks() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());

        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("").backend("html5")
                .docType("article").docTitle("Title")
                .icons("font").numbered(false)
                .hardBreaks(false)
                .sectAnchors(true).sectLink(true)
                .chapterLabel("Chapter");

        String expected =
                ":backend: html5" + newLine() +
                        ":doctitle: Title" + newLine() +
                        ":doctype: article" + newLine() +
                        ":icons: font" + newLine() +
                        ":!numbered:" + newLine() +
                        ":!linkcss:" + newLine() +
                        ":sectanchors:" + newLine() +
                        ":sectlink:" + newLine() +
                        ":docinfo:" + newLine() +
                        ":source-highlighter: highlightjs\n:toclevels: 3\n:!hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine();

        attrs.docTitle("Title");
        String document = Cukedoctor.instance(features, attrs).renderAttributes().
                getDocumentation().toString();
        assertEquals(expected, document);
    }

    @Test
    public void shouldRenderAttributesWithTocLevels2() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());

        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("").backend("html5")
                .docType("article").docTitle("Title")
                .icons("font").numbered(false)
                .sectAnchors(true).sectLink(true)
                .tocLevels("2")
                .chapterLabel("Chapter")
                .versionLabel("Version")
        ;

        String expected =
                ":backend: html5" + newLine() +
                        ":doctitle: Title" + newLine() +
                        ":doctype: article" + newLine() +
                        ":icons: font" + newLine() +
                        ":!numbered:" + newLine() +
                        ":!linkcss:" + newLine() +
                        ":sectanchors:" + newLine() +
                        ":sectlink:" + newLine() +
                        ":docinfo:" + newLine() +
                        ":source-highlighter: highlightjs" + newLine() +
                        ":toclevels: 2" + newLine() +
                        ":hardbreaks:" + newLine() +
                        ":chapter-label: Chapter"+ newLine() +
                        ":version-label: Version"+ newLine();


        attrs.docTitle("Title");
        String document = Cukedoctor.instance(features, attrs).renderAttributes().
                getDocumentation().toString();
        assertEquals(expected, document);
    }

    @Test
    public void shouldUseDocumentationTitleAsDocTitleAttribute() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());

        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("right").backend("html5")
                .docType("book")
                .linkCss(true)
                .icons("font").numbered(false)
                .sectAnchors(true).sectLink(true)
        	.chapterLabel("Chapter")
        	.versionLabel("Version");

        String expected =
                ":toc: right" + newLine() +
                        ":backend: html5" + newLine() +
                        ":doctitle: Documentation Title" + newLine() +
                        ":doctype: book" + newLine() +
                        ":icons: font" + newLine() +
                        ":!numbered:" + newLine() +
                        ":linkcss:" + newLine() +
                        ":sectanchors:" + newLine() +
                        ":sectlink:" + newLine() +
                        ":docinfo:" + newLine() +
                        ":source-highlighter: highlightjs\n:toclevels: 3\n:hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine();


        attrs.docTitle("Documentation Title");
        String document = Cukedoctor.instance(features, attrs).renderAttributes().
                getDocumentation().toString();
        assertEquals(document, expected);
    }


    // renderSummary() tests

    @Test
    public void shouldRenderSummaryForOneFeature() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        String resultDoc = Cukedoctor.instance(features, new DocumentAttributes().docTitle("Title")).renderSummary().getDocumentation().toString();
        assertThat(resultDoc).isNotNull().
                containsOnlyOnce("<<One-passing-scenario-one-failing-scenario>>").
                containsOnlyOnce("|[red]#*failed*#").
                contains("2+|010ms");

        assertThat(resultDoc).isEqualTo(Expectations.SUMMARY_FOR_ONE_FEATURE);
    }


    @Test
    public void shouldRenderSummaryForMultipleFeatures() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing, embedDataDirectly, outline, invalidFeatureResult);
        String resultDoc = Cukedoctor.instance(features, new DocumentAttributes().docTitle("Title")).renderSummary().getDocumentation().toString();
        assertThat(resultDoc).isNotNull().
                containsOnlyOnce("<<One-passing-scenario-one-failing-scenario>>").
                containsOnlyOnce("<<An-embed-data-directly-feature>>").
                containsOnlyOnce("<<An-outline-feature>>").
                doesNotContain("<<invalid feature result>>").
                contains("|[green]#*passed*#").
                contains("|[red]#*failed*#").
                containsOnlyOnce("2+|010ms");
        assertThat(resultDoc).isEqualTo(Expectations.SUMMARY_FOR_MULTIPLE_FEATURES);
    }


    @Test
    public void shouldRenderSummaryForFeatureWithBackground() {
        List<Feature> features = FeatureParser.parse(getClass().getResource("/json-output/feature_with_background.json").getPath());
        String resultDoc = Cukedoctor.instance(features, new DocumentAttributes().docTitle("Title")).renderSummary().getDocumentation().toString();
        assertThat(resultDoc).isNotNull().
                containsOnlyOnce("<<A-feature-with-background>>").
                contains("*Totals*" + newLine() +
                        "|2|0|2|4|0|0|0|0|0|4");
    }

    // renderTotalsRow() tests

    @Test
    public void shouldRenderTotalRowForOneFeature() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        SummaryRenderer summaryRenderer = new CukedoctorSummaryRenderer();
        assertThat(summaryRenderer.renderSummary(features)).isNotNull().
                containsOnlyOnce("12+^|*Totals*").
                contains("|1|1|2|1|1|0|0|0|0|2 2+|010ms");
    }

    @Test
    public void shouldRenderTotalRowForMultipleFeature() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing, embedDataDirectly, outline, invalidFeatureResult);
        SummaryRenderer summaryRenderer = new CukedoctorSummaryRenderer();
        assertThat(summaryRenderer.renderSummary(features)).isNotNull().
                containsOnlyOnce("12+^|*Totals*").
                contains("|4|1|5|4|1|0|0|0|0|5 2+|010ms");
    }

    @Test
    public void shouldGeneratePdfTheme() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes().backend("pdf"));
        converter.setFilename("target/pdf/living documentation.adoc");
        String pdfStylePath = Paths.get("").toAbsolutePath() + "/target/pdf/cukedoctor-pdf.yml";
        FileUtil.copyFileFromClassPath("/cukedoctor-pdf-test.yml", pdfStylePath);
        converter.addCustomPdfTheme();
        String expected = ":toc: right" + newLine() +
                ":backend: pdf" + newLine() +
                ":doctitle: Living Documentation" + newLine() +
                ":doctype: book" + newLine() +
                ":icons: font" + newLine() +
                ":!numbered:" + newLine() +
                ":!linkcss:" + newLine() +
                ":sectanchors:" + newLine() +
                ":sectlink:" + newLine() +
                ":docinfo:" + newLine() +
                ":source-highlighter: highlightjs" + newLine() +
                ":toclevels: 3" + newLine() +
                ":hardbreaks:" + newLine() +
                ":chapter-label: Chapter" + newLine() +
                ":version-label: Version" + newLine() +
                ":pdf-style: " + pdfStylePath + newLine();

        String doc = converter.renderAttributes().getDocumentation();
        assertThat(expected).isEqualTo(doc);
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
    public void shouldNotRenderFeatureWithSkipDocsTag() {
        final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
        final Feature featureToSkip = FeatureBuilder.instance().aFeatureWithTwoScenarios();
        featureToSkip.getTags().add(new Tag("@skipDocs"));
        featureToSkip.setName("feature to skip");
        featureToSkip.setId("skippedFeature");
        List<Feature> features = new ArrayList<>();
        features.add(feature);
        features.add(featureToSkip);
        String resultDoc = Cukedoctor.instance(features, new DocumentAttributes()).
                renderFeatures(features).getDocumentation().toString();

        assertThat(resultDoc).
                doesNotContain("feature to skip").
                contains("[[Feature-name, Feature name]]" + newLine() +
                        "=== *Feature name*" + newLine() +
                        "" + newLine() +
                        "ifndef::backend-pdf[]" + newLine() +
                        "minmax::Feature-name[]" + newLine() +
                        "endif::[]"+ newLine() +
                        "****" + newLine() +
                        "Feature description" + newLine() +
                        "****" + newLine() +
                        "" + newLine() +
                        "==== Scenario: scenario 1" + newLine() +
                        "description" + newLine() +
                        "" + newLine() +
                        "==== Scenario: scenario 2" + newLine() +
                        "description 2" + newLine() +
                        "" + newLine());
    }


    @Test
    public void shouldRenderDocumentationForOneFeature() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("left").backend("html5")
                .docType("book").docTitle("Living Documentation")
                .icons("font").numbered(false)
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
                .icons("font").numbered(false)
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
                .icons("font").numbered(false)
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
                .icons("font").numbered(false)
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
                .icons("font").numbered(false)
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
                .icons("font").numbered(false)
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
                .icons("font").numbered(false)
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
        String resultDoc = converter.renderDocumentation();
        assertThat(resultDoc).contains("****" + newLine() +
                "As a user " + newLine() +
                "I want to do something " + newLine() +
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
    public void shouldEnrichFeature() {
        List<Feature> features = FeatureParser.parse(getClass().getResource("/json-output/enrichment/calc.json").getPath());
        assertThat(features).isNotNull().hasSize(1);
        String output = Cukedoctor.instance(features).renderFeatures(features).getDocumentation();
        assertThat(output.replaceAll("\r", "")).contains(("[[Calculator, Calculator]]"+newLine()+ 
        		"=== *Calculator*"+newLine()+ 
        		""+newLine()+ 
        		"==== Scenario: Adding numbers"+newLine()+ 
        		"You can use *asciidoc markup* in _feature_ #description#."+newLine()+ 
        		""+newLine()+ 
        		"NOTE: This is a very important feature!"+newLine()+ 
        		""+newLine()+ 
        		"===="+newLine()+ 
        		"Given ::"+newLine()+ 
        		"I have numbers 1 and 2 icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(114ms)#"+newLine()+ 
        		""+newLine()+ 
        		"IMPORTANT: Asciidoc markup inside *steps* must be surrounded by *curly brackets*."+newLine()+ 
        		""+newLine()+ 
        		"When ::"+newLine()+ 
        		"I sum the numbers icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"+newLine()+ 
        		""+newLine()+ 
        		"NOTE: Steps comments are placed *before* each steps so this comment is for the *WHEN* step."+newLine()+ 
        		""+newLine()+ 
        		"Then ::"+newLine()+ 
        		"I should have 3 as result icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#"+newLine()+ 
        		""+newLine()+ 
        		"* this is a list of itens inside a feature step"+newLine()+ 
        		""+newLine()+ 
        		"* there is no multiline comment in gherkin"+newLine()+ 
        		""+newLine()+ 
        		"** second level list item"+newLine()+ 
        		""+newLine()+ 
        		"===="+newLine()+ 
        		""+newLine()+ 
        		""));
    }

    @Test
    public void shouldEnrichFeatureWithListing() {
        List<Feature> features = FeatureParser.parse(getClass().getResource("/com/github/cukedoctor/json-output/comment-with-listing.json").getPath());
        assertThat(features).isNotNull().hasSize(1);
        String output = Cukedoctor.instance(features).renderFeatures(features).getDocumentation();
        assertThat(output.replaceAll("\r", "")).contains(("[[Enriched-feature, Enriched feature]]" + newLine() +
                "=== *Enriched feature*" + newLine() +
                "" + newLine() +
                "==== Scenario: Scenario with listing" + newLine() +
                "You can use *asciidoc markup* using feature comments." + newLine() +
                "" + newLine() +
                "====" + newLine() +
                "Given ::" + newLine() +
                "I have listing in feature comments. icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +
                "[source,java]" + newLine() +
                "----" + newLine() +
                "" + newLine() +
                "System.setProperty(\"INTRO_CHAPTER_DIR\",\"/home/some/external/folder\");" + newLine() +
                "----" + newLine() +
                "" + newLine() +
                "====" + newLine() + newLine()).replaceAll("\r", ""));
    }

    @Test
    public void shouldEnrichFeatureWithListingWithinAdmonitionBlock() {
        List<Feature> features = FeatureParser.parse(getClass().getResource("/com/github/cukedoctor/json-output/comment-with-admonition-and-listing.json").getPath());
        assertThat(features).isNotNull().hasSize(1);
        String output = Cukedoctor.instance(features).renderFeatures(features).getDocumentation();
        assertThat(output.replaceAll("\r", "")).contains(("[[Enriched-feature, Enriched feature]]"+newLine()+ 
        		"=== *Enriched feature*"+newLine()+ 
        		""+newLine()+ 
        		"==== Scenario: Scenario with admonition and  listing"+newLine()+ 
        		"You can use *asciidoc markup* using feature comments."+newLine()+ 
        		""+newLine()+ 
        		"===="+newLine()+ 
        		"Given ::"+newLine()+ 
        		"I have admonition with a listing in feature comments. icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(032ms)#"+newLine()+ 
        		""+newLine()+ 
        		"[TIP]"+newLine()+ 
        		"===="+newLine()+ 
        		""+newLine()+ 
        		"This is a tip with source code inside"+newLine()+ 
        		"[source,java]"+newLine()+ 
        		"----"+newLine()+ 
        		""+newLine()+ 
        		"System.setProperty(\"INTRO_CHAPTER_DIR\",\"/home/some/external/folder\");"+newLine()+ 
        		"----"+newLine()+ 
        		"===="+newLine()+ 
        		""+newLine()+ 
        		"===="+newLine()+ 
        		"").replaceAll("\r", ""));
    }

    @Test
    public void shouldEnrichFeatureWithCommentAndDocstring() {
        List<Feature> features = FeatureParser.parse(getClass().getResource("/com/github/cukedoctor/json-output/calc-enriched.json").getPath());
        assertThat(features).isNotNull().hasSize(1);
        String output = Cukedoctor.instance(features).renderFeatures(features).getDocumentation();
        assertThat(output.replaceAll("\r", "")).contains(("[[Calculator, Calculator]]"+newLine()+ 
        		"=== *Calculator*"+newLine()+ 
        		""+newLine()+ 
        		"==== Scenario: Adding numbers"+newLine()+ 
        		"You can *asciidoc markup* in _feature_ #description#."+newLine()+ 
        		""+newLine()+ 
        		"NOTE: This is a very important feature!"+newLine()+ 
        		""+newLine()+ 
        		"===="+newLine()+ 
        		"Given ::"+newLine()+ 
        		"I have numbers 1 and 2 icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(212ms)#"+newLine()+ 
        		""+newLine()+ 
        		"IMPORTANT: Asciidoc markup inside *steps* must be surrounded by *curly brackets*."+newLine()+ 
        		""+newLine()+ 
        		"When ::"+newLine()+ 
        		"I sum the numbers using the following java code: icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#"+newLine()+ 
        		"******"+newLine()+ 
        		""+newLine()+ 
        		"[discrete]"+newLine()+ 
        		"[source,java]"+newLine()+ 
        		"----"+newLine()+ 
        		"    public class Calc {"+newLine()+ 
        		"      public long sum(int x, int y){"+newLine()+ 
        		"          return  x + y; //<1>"+newLine()+ 
        		"      }"+newLine()+ 
        		"  }"+newLine()+ 
        		"----"+newLine()+ 
        		"[discrete]"+newLine()+ 
        		"<1> This is an asciidoc call inside a feature."+newLine()+ 
        		""+newLine()+ 
        		""+newLine()+ 
        		"******"+newLine()+ 
        		""+newLine()+ 
        		"NOTE: You can use asciidoc in doc strings as well"+newLine()+ 
        		""+newLine()+ 
        		"TIP: Steps comments are placed *before* each steps"+newLine()+ 
        		""+newLine()+ 
        		"Then ::"+newLine()+ 
        		"I should have 3 as result icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(003ms)#"+newLine()+ 
        		""+newLine()+ 
        		"* this is a list of itens inside a feature step"+newLine()+ 
        		""+newLine()+ 
        		"* there is no multiline comment in gherkin"+newLine()+ 
        		""+newLine()+ 
        		"** second level list item"+newLine()+ 
        		""+newLine()+ 
        		"===="+newLine()+ 
        		""+newLine()+ 
        		"").replaceAll("\r", ""));
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


}
