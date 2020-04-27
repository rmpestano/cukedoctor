package com.github.cukedoctor.converter;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.GlobalConfig;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class AttributesTest {

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
        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
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
                ":chapter-label: Chapter" + newLine() +
                ":version-label: Version" + newLine();


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
                ":chapter-label: Chapter" + newLine() +
                ":version-label: Version" + newLine();


        String document = Cukedoctor.instance(features, GlobalConfig.newInstance().getDocumentAttributes()).renderAttributes().
                getDocumentation().toString();
        assertEquals(expected, document);
    }

    @Test
    public void shouldNotRenderAttributesWhenNoDocAttrIsProvided() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());


        String document = Cukedoctor.instance(features).renderAttributes().
                getDocumentation();
        assertEquals("", document);
    }

    @Test
    public void shouldNotRenderAttributesPassingNullDocAttrs() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());

        String document = Cukedoctor.instance(features, null).renderAttributes().
                getDocumentation();
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
        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
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
        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
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
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine();


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
                        ":source-highlighter: highlightjs" + newLine() +
                        ":toclevels: 3" + newLine() +
                        ":hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine();


        attrs.docTitle("Documentation Title");
        String document = Cukedoctor.instance(features, attrs).renderAttributes().
                getDocumentation().toString();
        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }

    @Test
    public void shouldRenderStemAttribute() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());

        DocumentAttributes attrs = new DocumentAttributes()
                .stem("latexmath")
                .toc("right")
                .backend("html5")
                .docType("article")
                .docTitle("Title")
                .icons("font")
                .numbered(false)
                .sectAnchors(true)
                .sectLink(true)
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
                        ":source-highlighter: highlightjs" + newLine() +
                        ":toclevels: 3" + newLine() +
                        ":hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine() +
                        ":stem: latexmath" + newLine();

        String document = Cukedoctor.instance(features, attrs).renderAttributes().getDocumentation();

        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }

    @Test
    public void shouldRenderAllowUriAttribute() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());

        DocumentAttributes attrs = new DocumentAttributes()
                .stem("latexmath")
                .toc("right")
                .backend("html5")
                .docType("article")
                .docTitle("Title")
                .icons("font")
                .numbered(false)
                .sectAnchors(true)
                .sectLink(true)
                .allowUriRead(true)
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
                        ":source-highlighter: highlightjs" + newLine() +
                        ":toclevels: 3" + newLine() +
                        ":hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine() +
                        ":stem: latexmath" + newLine() +
                        ":allow-uri-read:" + newLine();

        String document = Cukedoctor.instance(features, attrs).renderAttributes().getDocumentation();

        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }

    @Test
    public void shouldDisableAllowUriAttribute() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());

        DocumentAttributes attrs = new DocumentAttributes()
                .stem("latexmath")
                .toc("right")
                .backend("html5")
                .docType("article")
                .docTitle("Title")
                .icons("font")
                .numbered(false)
                .sectAnchors(true)
                .sectLink(true)
                .allowUriRead(false)
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
                        ":source-highlighter: highlightjs" + newLine() +
                        ":toclevels: 3" + newLine() +
                        ":hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine() +
                        ":stem: latexmath" + newLine() +
                        ":!allow-uri-read:" + newLine();

        String document = Cukedoctor.instance(features, attrs).renderAttributes().getDocumentation();

        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }

    @Test
    public void shouldNotRenderAllowUriAttribute() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());

        DocumentAttributes attrs = new DocumentAttributes()
                .stem("latexmath")
                .toc("right")
                .backend("html5")
                .docType("article")
                .docTitle("Title")
                .icons("font")
                .numbered(false)
                .sectAnchors(true)
                .sectLink(true)
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
                        ":source-highlighter: highlightjs" + newLine() +
                        ":toclevels: 3" + newLine() +
                        ":hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine() +
                        ":stem: latexmath" + newLine();

        String document = Cukedoctor.instance(features, attrs).renderAttributes().getDocumentation();

        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }
}
