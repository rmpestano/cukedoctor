package com.github.cukedoctor.reporter;

import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.Constants;
import com.github.cukedoctor.util.FeatureBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by pestano on 06/06/15.
 */
@RunWith(JUnit4.class)
public class DocAttributesTest {

    @Test
    public void shouldRenderAttributes() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());

        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("right").backend("html5")
                .docType("article").docTitle("Title")
                .icons("font").numbered(false)
                .sectAnchors(true).sectLink(true);

        String expected =
                ":toc:right" + Constants.NEW_LINE +
                ":backend:html5" + Constants.NEW_LINE +
                ":doctitle:Title" + Constants.NEW_LINE +
                ":doctype:article" + Constants.NEW_LINE +
                ":icons:font" + Constants.NEW_LINE +
                ":!numbered:" + Constants.NEW_LINE +
                ":sectanchors:" + Constants.NEW_LINE +
                ":sectlink:" + Constants.NEW_LINE;


        String document = CukedoctorReporter.instance(features, "Documentation Title", attrs).renderAttributes().
                getDocumentation().toString();
        assertEquals(document, expected);
    }

    @Test
    public void shouldRenderAttributesWithoutToc() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());

        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("").backend("html5")
                .docType("article").docTitle("Title")
                .icons("font").numbered(false)
                .sectAnchors(true).sectLink(true);

        String expected =
                ":backend:html5" + Constants.NEW_LINE +
                ":doctitle:Title" + Constants.NEW_LINE +
                ":doctype:article" + Constants.NEW_LINE +
                ":icons:font" + Constants.NEW_LINE +
                ":!numbered:" + Constants.NEW_LINE +
                ":sectanchors:" + Constants.NEW_LINE +
                ":sectlink:" + Constants.NEW_LINE;


        String document = CukedoctorReporter.instance(features, "Documentation Title", attrs).renderAttributes().
                getDocumentation().toString();
        assertEquals(document, expected);
    }

    @Test
    public void shouldUseDocumentationTitleAsDocTitleAttribute() {
        List<Feature> features = new ArrayList<>();
        features.add(FeatureBuilder.instance().id("id").name("name").build());

        DocumentAttributes attrs = new DocumentAttributes();
        attrs.toc("left").backend("html5")
                .docType("book")
                .icons("font").numbered(false)
                .sectAnchors(true).sectLink(true);

        String expected =
                ":toc:left" + Constants.NEW_LINE +
                ":backend:html5" + Constants.NEW_LINE +
                ":doctitle:Documentation Title" + Constants.NEW_LINE +
                ":doctype:book" + Constants.NEW_LINE +
                ":icons:font" + Constants.NEW_LINE +
                ":!numbered:" + Constants.NEW_LINE +
                ":sectanchors:" + Constants.NEW_LINE +
                ":sectlink:" + Constants.NEW_LINE;


        String document = CukedoctorReporter.instance(features, "Documentation Title", attrs).renderAttributes().
                getDocumentation().toString();
        assertEquals(document, expected);
    }


}
