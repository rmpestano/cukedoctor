package com.github.cukedoctor.renderer;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.config.GlobalConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class CukedoctorHeaderRendererTest {

    @Test
    public void shouldRenderAttributes() {
        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("right").backend("html5")
                .docType("article").docTitle("Title")
                .icons("font")
                .sectAnchors(true).sectLink(true)
                .chapterLabel("Chapter")
                .versionLabel("Version");

        String expected =
                ":toc: right" + newLine() +
                        ":backend: html5" + newLine() +
                        ":doctitle: Title" + newLine() +
                        ":doctype: article" + newLine() +
                        ":icons: font" + newLine() +
                        ":sectanchors:" + newLine() +
                        ":sectlink:" + newLine() +
                        ":docinfo:" + newLine() +
                        ":source-highlighter: highlightjs\n:toclevels: 3\n:hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine();

        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(attrs, CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }


    @Test
    public void shouldRenderAttributesUsingDefaultConfig() {
        String expected = ":toc: right" + newLine() +
                ":backend: html5" + newLine() +
                ":doctitle: Living Documentation" + newLine() +
                ":doctype: book" + newLine() +
                ":icons: font" + newLine() +
                ":sectanchors:" + newLine() +
                ":sectlink:" + newLine() +
                ":docinfo:" + newLine() +
                ":source-highlighter: highlightjs" + newLine() + ":toclevels: 3" + newLine() + ":hardbreaks:" + newLine() +
                ":chapter-label: Chapter" + newLine() +
                ":version-label: Version" + newLine();

        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(new DocumentAttributes(), CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals(expected, document);
    }

    @Test
    public void shouldRenderAttributesUsingGlobalConfig() {
        String expected = ":toc: right" + newLine() +
                ":backend: html5" + newLine() +
                ":doctitle: Living Documentation" + newLine() +
                ":doctype: book" + newLine() +
                ":icons: font" + newLine() +
                ":sectanchors:" + newLine() +
                ":sectlink:" + newLine() +
                ":docinfo:" + newLine() +
                ":source-highlighter: highlightjs" + newLine() + ":toclevels: 3" + newLine() + ":hardbreaks:" + newLine() +
                ":chapter-label: Chapter" + newLine() +
                ":version-label: Version" + newLine();

        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(GlobalConfig.newInstance().getDocumentAttributes(), CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals(expected, document);
    }

    @Test
    public void shouldNotRenderAttributesWhenNoDocAttrIsProvided() {
        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(Cukedoctor.getDefaultDocumentAttributes(), CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals("", document);
    }

    @Test
    public void shouldNotRenderAttributesPassingNullDocAttrs() {
        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(null, CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals("", document);
    }

    @Test
    public void shouldRenderAttributesWithoutToc() {
        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("").backend("html5")
                .docType("article").docTitle("Title")
                .icons("font")
                .sectAnchors(true).sectLink(true)
                .chapterLabel("Chapter")
                .versionLabel("Version");

        String expected =
                ":backend: html5" + newLine() +
                        ":doctitle: Title" + newLine() +
                        ":doctype: article" + newLine() +
                        ":icons: font" + newLine() +
                        ":sectanchors:" + newLine() +
                        ":sectlink:" + newLine() +
                        ":docinfo:" + newLine() +
                        ":source-highlighter: highlightjs\n:toclevels: 3\n:hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine();

        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(attrs, CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }

    @Test
    public void shouldRenderAttributesWithoutHardbreaks() {
        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("").backend("html5")
                .docType("article").docTitle("Title")
                .icons("font")
                .hardBreaks(false)
                .sectAnchors(true).sectLink(true)
                .chapterLabel("Chapter");

        String expected =
                ":backend: html5" + newLine() +
                        ":doctitle: Title" + newLine() +
                        ":doctype: article" + newLine() +
                        ":icons: font" + newLine() +
                        ":sectanchors:" + newLine() +
                        ":sectlink:" + newLine() +
                        ":docinfo:" + newLine() +
                        ":source-highlighter: highlightjs\n:toclevels: 3\n:!hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine();

        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(attrs, CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }

    @Test
    public void shouldRenderAttributesWithTocLevels2() {
        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("").backend("html5")
                .docType("article").docTitle("Title")
                .icons("font")
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
                        ":sectanchors:" + newLine() +
                        ":sectlink:" + newLine() +
                        ":docinfo:" + newLine() +
                        ":source-highlighter: highlightjs" + newLine() +
                        ":toclevels: 2" + newLine() +
                        ":hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine();

        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(attrs, CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals(expected, document);
    }

    @Test
    public void shouldUseDocumentationTitleAsDocTitleAttribute() {
        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("right").backend("html5")
                .docType("book").docTitle("Documentation Title")
                .linkCss(true)
                .icons("font")
                .sectAnchors(true).sectLink(true)
                .chapterLabel("Chapter")
                .versionLabel("Version");

        String expected =
                ":toc: right" + newLine() +
                        ":backend: html5" + newLine() +
                        ":doctitle: Documentation Title" + newLine() +
                        ":doctype: book" + newLine() +
                        ":icons: font" + newLine() +
                        ":linkcss:" + newLine() +
                        ":sectanchors:" + newLine() +
                        ":sectlink:" + newLine() +
                        ":docinfo:" + newLine() +
                        ":source-highlighter: highlightjs" + newLine() +
                        ":toclevels: 3" + newLine() +
                        ":hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine();

        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(attrs, CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }

    @Test
    public void shouldRenderStemAttribute() {
        DocumentAttributes attrs = new DocumentAttributes()
                .stem("latexmath")
                .toc("right")
                .backend("html5")
                .docType("article")
                .docTitle("Title")
                .icons("font")
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
                        ":sectanchors:" + newLine() +
                        ":sectlink:" + newLine() +
                        ":docinfo:" + newLine() +
                        ":source-highlighter: highlightjs" + newLine() +
                        ":toclevels: 3" + newLine() +
                        ":hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine() +
                        ":stem: latexmath" + newLine();

        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(attrs, CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }

    @Test
    public void shouldRenderAllowUriAttribute() {
        DocumentAttributes attrs = new DocumentAttributes()
                .stem("latexmath")
                .toc("right")
                .backend("html5")
                .docType("article")
                .docTitle("Title")
                .icons("font")
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

        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(attrs, CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }

    @Test
    public void shouldDisableAllowUriAttribute() {
        DocumentAttributes attrs = new DocumentAttributes()
                .stem("latexmath")
                .toc("right")
                .backend("html5")
                .docType("article")
                .docTitle("Title")
                .icons("font")
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

        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(attrs, CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }

    @Test
    public void shouldNotRenderAllowUriAttribute() {
        DocumentAttributes attrs = new DocumentAttributes()
                .stem("latexmath")
                .toc("right")
                .backend("html5")
                .docType("article")
                .docTitle("Title")
                .icons("font")
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
                        ":sectanchors:" + newLine() +
                        ":sectlink:" + newLine() +
                        ":docinfo:" + newLine() +
                        ":source-highlighter: highlightjs" + newLine() +
                        ":toclevels: 3" + newLine() +
                        ":hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine() +
                        ":stem: latexmath" + newLine();

        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(attrs, CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }

    @Test
    public void shouldRenderDocumentationHeader() {
        String generatedHeader = new CukedoctorHeaderRenderer().renderDocumentHeader(GlobalConfig.newInstance().getDocumentAttributes(), CukedoctorDocumentBuilder.Factory.newInstance());
        assertThat(generatedHeader).isEqualToIgnoringWhitespace(":toc: right" + newLine() +
                ":backend: html5" + newLine() +
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
                ":version-label: Version" + newLine());
    }

    @Test
    public void shouldRenderDataUriAttributeIfDataUriSet() {
        DocumentAttributes attrs = new DocumentAttributes()
                .dataUri(true)
                .toc("right")
                .backend("html5")
                .docType("article")
                .docTitle("Title")
                .icons("font")
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
                        ":sectanchors:" + newLine() +
                        ":sectlink:" + newLine() +
                        ":docinfo:" + newLine() +
                        ":source-highlighter: highlightjs" + newLine() +
                        ":toclevels: 3" + newLine() +
                        ":hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine() +
                        ":data-uri:" + newLine();

        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(attrs, CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }


    @Test
    public void shouldNotRenderDataUriAttributeIfDataUriNotSet() {
        DocumentAttributes attrs = new DocumentAttributes()
                .toc("right")
                .backend("html5")
                .docType("article")
                .docTitle("Title")
                .icons("font")
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
                        ":sectanchors:" + newLine() +
                        ":sectlink:" + newLine() +
                        ":docinfo:" + newLine() +
                        ":source-highlighter: highlightjs" + newLine() +
                        ":toclevels: 3" + newLine() +
                        ":hardbreaks:" + newLine() +
                        ":chapter-label: Chapter" + newLine() +
                        ":version-label: Version" + newLine();

        String document = new CukedoctorHeaderRenderer().renderDocumentHeader(attrs, CukedoctorDocumentBuilder.Factory.newInstance());
        assertEquals(expected.replace("\r", ""), document.replace("\r", ""));
    }
}