package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class RootSectionTest {
    @BeforeClass
    public static void beforeClass() {
        System.setProperty("HIDE_STEP_TIME", "true");
        System.setProperty("cukedoctor.disable-extensions", "true");
    }

    @Test
    public void shouldRenderFeaturesNotTaggedWithASectionInTheFeaturesSection() {
        System.setProperty("HIDE_FEATURES_SECTION", "false");

        RootSection root = new RootSection();
        root.addFeature(FeatureBuilder.instance().id("My Feature").name("My Feature").build());
        root.addFeature(FeatureBuilder.instance().id("My Other Feature").name("My Other Feature").build());

        final String expectedDocument = "[[Features, Features]]" + newLine() +
                "= *Features*" + newLine() + newLine() + newLine() +
                "[[My-Feature, My Feature]]" + newLine() +
                "== *My Feature*" + newLine() +
                newLine() +
                "[[My-Other-Feature, My Other Feature]]" + newLine() +
                "== *My Other Feature*" + newLine() +
                newLine();

        assertEquals(expectedDocument, root.render(CukedoctorDocumentBuilder.Factory.instance(), I18nLoader.instance(null), new DocumentAttributes()));
    }

    @Test
    public void shouldRenderFeaturesTaggedWithASectionInTheirAssignedSections() {
        RootSection root = new RootSection();
        root.addFeature(FeatureBuilder.instance().id("Yet Another Feature").name("Yet Another Feature").tag("@section-SectionTwo").build());
        root.addFeature(FeatureBuilder.instance().id("My Feature").name("My Feature").tag("@section-SectionOne").build());
        root.addFeature(FeatureBuilder.instance().id("My Other Feature").name("My Other Feature").tag("@section-SectionOne").build());

        final String expectedDocument = "[[SectionOne, SectionOne]]" + newLine() +
                "= *SectionOne*" + newLine() + newLine() + newLine() +
                "[[My-Feature, My Feature]]" + newLine() +
                "== *My Feature*" + newLine() +
                newLine() +
                "[[My-Other-Feature, My Other Feature]]" + newLine() +
                "== *My Other Feature*" + newLine() +
                newLine() +
                "[[SectionTwo, SectionTwo]]" + newLine() +
                "= *SectionTwo*" + newLine() + newLine() + newLine() +
                "[[Yet-Another-Feature, Yet Another Feature]]" + newLine() +
                "== *Yet Another Feature*" + newLine() +
                newLine();

        assertEquals(expectedDocument, root.render(CukedoctorDocumentBuilder.Factory.instance(), I18nLoader.instance(null), new DocumentAttributes()));
    }

    @Test
    public void shouldRenderFeaturesSectionAfterForeSections() {
        RootSection root = new RootSection();
        root.addFeature(FeatureBuilder.instance().id("My Feature").name("My Feature").tag("@section-SectionOne").build());
        root.addFeature(FeatureBuilder.instance().id("My Other Feature").name("My Other Feature").build());

        final String expectedDocument = "[[SectionOne, SectionOne]]" + newLine() +
                "= *SectionOne*" + newLine() + newLine() + newLine() +
                "[[My-Feature, My Feature]]" + newLine() +
                "== *My Feature*" + newLine() +
                newLine() +
                "[[Features, Features]]" + newLine() +
                "= *Features*" + newLine() + newLine() + newLine() +
                "[[My-Other-Feature, My Other Feature]]" + newLine() +
                "== *My Other Feature*" + newLine() +
                newLine();

        assertEquals(expectedDocument, root.render(CukedoctorDocumentBuilder.Factory.instance(), I18nLoader.instance(null), new DocumentAttributes()));
    }

    @Test
    public void shouldRenderForeSectionsInOrder() {
        RootSection root = new RootSection();
        root.addFeature(FeatureBuilder.instance().id("My Feature").name("My Feature").tag("@section-SectionOne").tag("@order-1").build());
        root.addFeature(FeatureBuilder.instance().id("Yet Another Feature").name("Yet Another Feature").tag("@section-SectionTwo").tag("@order-2").build());

        final String expectedDocument = "[[SectionOne, SectionOne]]" + newLine() +
                "= *SectionOne*" + newLine() + newLine() + newLine() +
                "[[My-Feature, My Feature]]" + newLine() +
                "== *My Feature*" + newLine() +
                newLine() +
                "[[SectionTwo, SectionTwo]]" + newLine() +
                "= *SectionTwo*" + newLine() + newLine() + newLine() +
                "[[Yet-Another-Feature, Yet Another Feature]]" + newLine() +
                "== *Yet Another Feature*" + newLine() +
                newLine();

        assertEquals(expectedDocument, root.render(CukedoctorDocumentBuilder.Factory.instance(), I18nLoader.instance(null), new DocumentAttributes()));
    }

    @Test
    public void shouldNotRenderFeaturesMarkedWithSkipDocs() {
        RootSection root = new RootSection();
        root.addFeature(FeatureBuilder.instance().id("My Feature").name("My Feature").tag("@section-SectionOne").tag("@skipDocs").build());
        root.addFeature(FeatureBuilder.instance().id("My Other Feature").name("My Other Feature").tag("@skipDocs").build());

        assertEquals("", root.render(CukedoctorDocumentBuilder.Factory.instance(), I18nLoader.instance(null), new DocumentAttributes()));
    }

    @Test
    public void orderShouldBeIntMax() {
        assertEquals(Integer.MAX_VALUE, new RootSection().getOrder());
    }
}
