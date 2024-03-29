package com.github.cukedoctor.sectionlayout;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import com.github.cukedoctor.util.builder.ScenarioBuilder;
import java.util.Arrays;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DocumentSectionTest {
  @BeforeClass
  public static void beforeClass() {
    System.setProperty("HIDE_STEP_TIME", "true");
    System.setProperty("cukedoctor.disable-extensions", "true");
  }

  @Test
  public void shouldRenderFeaturesNotTaggedWithASectionInTheFeaturesSection() {
    System.setProperty("HIDE_FEATURES_SECTION", "false");

    DocumentSection root = new DocumentSection();
    root.addFeature(FeatureBuilder.instance().id("My Feature").name("My Feature").build());
    root.addFeature(
        FeatureBuilder.instance().id("My Other Feature").name("My Other Feature").build());

    final String expectedDocument =
        "[[Features, Features]]"
            + newLine()
            + "= *Features*"
            + newLine()
            + newLine()
            + newLine()
            + "[[My-Feature, My Feature]]"
            + newLine()
            + "== *My Feature*"
            + newLine()
            + newLine()
            + "[[My-Other-Feature, My Other Feature]]"
            + newLine()
            + "== *My Other Feature*"
            + newLine()
            + newLine();

    assertEquals(expectedDocument, renderDocument(root));
  }

  @Test
  public void shouldRenderFeaturesTaggedWithASectionInTheirAssignedSections() {
    DocumentSection root = new DocumentSection();
    root.addFeature(
        FeatureBuilder.instance()
            .id("Yet Another Feature")
            .name("Yet Another Feature")
            .tag("@section-SectionTwo")
            .build());
    root.addFeature(
        FeatureBuilder.instance()
            .id("My Feature")
            .name("My Feature")
            .tag("@section-SectionOne")
            .build());
    root.addFeature(
        FeatureBuilder.instance()
            .id("My Other Feature")
            .name("My Other Feature")
            .tag("@section-SectionOne")
            .build());

    final String expectedDocument =
        "[[SectionOne, SectionOne]]"
            + newLine()
            + "= *SectionOne*"
            + newLine()
            + newLine()
            + newLine()
            + "[[My-Feature, My Feature]]"
            + newLine()
            + "== *My Feature*"
            + newLine()
            + newLine()
            + "[[My-Other-Feature, My Other Feature]]"
            + newLine()
            + "== *My Other Feature*"
            + newLine()
            + newLine()
            + "[[SectionTwo, SectionTwo]]"
            + newLine()
            + "= *SectionTwo*"
            + newLine()
            + newLine()
            + newLine()
            + "[[Yet-Another-Feature, Yet Another Feature]]"
            + newLine()
            + "== *Yet Another Feature*"
            + newLine()
            + newLine();

    assertEquals(expectedDocument, renderDocument(root));
  }

  @Test
  public void shouldRenderFeaturesSectionAfterForeSections() {
    DocumentSection root = new DocumentSection();
    root.addFeature(
        FeatureBuilder.instance()
            .id("My Feature")
            .name("My Feature")
            .tag("@section-SectionOne")
            .build());
    root.addFeature(
        FeatureBuilder.instance().id("My Other Feature").name("My Other Feature").build());

    final String expectedDocument =
        "[[SectionOne, SectionOne]]"
            + newLine()
            + "= *SectionOne*"
            + newLine()
            + newLine()
            + newLine()
            + "[[My-Feature, My Feature]]"
            + newLine()
            + "== *My Feature*"
            + newLine()
            + newLine()
            + "[[Features, Features]]"
            + newLine()
            + "= *Features*"
            + newLine()
            + newLine()
            + newLine()
            + "[[My-Other-Feature, My Other Feature]]"
            + newLine()
            + "== *My Other Feature*"
            + newLine()
            + newLine();

    assertEquals(expectedDocument, renderDocument(root));
  }

  @Test
  public void shouldRenderForeSectionsInOrder() {
    DocumentSection root = new DocumentSection();
    root.addFeature(
        FeatureBuilder.instance()
            .id("My Feature")
            .name("My Feature")
            .tag("@section-SectionOne")
            .tag("@order-1")
            .build());
    root.addFeature(
        FeatureBuilder.instance()
            .id("Yet Another Feature")
            .name("Yet Another Feature")
            .tag("@section-SectionTwo")
            .tag("@order-2")
            .build());

    final String expectedDocument =
        "[[SectionOne, SectionOne]]"
            + newLine()
            + "= *SectionOne*"
            + newLine()
            + newLine()
            + newLine()
            + "[[My-Feature, My Feature]]"
            + newLine()
            + "== *My Feature*"
            + newLine()
            + newLine()
            + "[[SectionTwo, SectionTwo]]"
            + newLine()
            + "= *SectionTwo*"
            + newLine()
            + newLine()
            + newLine()
            + "[[Yet-Another-Feature, Yet Another Feature]]"
            + newLine()
            + "== *Yet Another Feature*"
            + newLine()
            + newLine();

    assertEquals(expectedDocument, renderDocument(root));
  }

  @Test
  public void shouldRenderAppendicesInOrderAfterFeaturesSection() {
    DocumentSection root = new DocumentSection();
    root.addFeature(
        FeatureBuilder.instance()
            .id("Amazing Feature")
            .name("Amazing Feature")
            .tag("@section-Beta")
            .tag("@order-4")
            .build());
    root.addFeature(
        FeatureBuilder.instance()
            .id("My Feature")
            .name("My Feature")
            .tag("@section-Beta")
            .tag("@order-3")
            .tag("@appendix")
            .build());
    root.addFeature(
        FeatureBuilder.instance()
            .id("Yet Another Feature")
            .name("Yet Another Feature")
            .tag("@section-Alpha")
            .tag("@order-1")
            .tag("@appendix")
            .build());
    root.addFeature(
        FeatureBuilder.instance()
            .id("Alpha: The Beginning")
            .name("Alpha: The Beginning")
            .tag("@section-Alpha")
            .tag("@order-2")
            .tag("@appendix")
            .scenario(ScenarioBuilder.instance().name("Root").build())
            .build());
    root.addFeature(
        FeatureBuilder.instance().id("Exciting Feature").name("Exciting Feature").build());

    final String expectedDocument =
        "[[Features, Features]]"
            + newLine()
            + "= *Features*"
            + newLine()
            + newLine()
            + newLine()
            + "[[Exciting-Feature, Exciting Feature]]"
            + newLine()
            + "== *Exciting Feature*"
            + newLine()
            + newLine()
            + "[appendix]"
            + newLine()
            + "[[Alpha:-The-Beginning, Alpha: The Beginning]]"
            + newLine()
            + "= *Alpha: The Beginning*"
            + newLine()
            + newLine()
            + newLine()
            + "[[Yet-Another-Feature, Yet Another Feature]]"
            + newLine()
            + "== *Yet Another Feature*"
            + newLine()
            + newLine()
            + "[appendix]"
            + newLine()
            + "[[Beta, Beta]]"
            + newLine()
            + "= *Beta*"
            + newLine()
            + newLine()
            + newLine()
            + "[[My-Feature, My Feature]]"
            + newLine()
            + "== *My Feature*"
            + newLine()
            + newLine()
            + "[[Amazing-Feature, Amazing Feature]]"
            + newLine()
            + "== *Amazing Feature*"
            + newLine()
            + newLine();

    assertEquals(expectedDocument, renderDocument(root));
  }

  @Test
  public void shouldNotRenderFeaturesMarkedWithSkipDocs() {
    DocumentSection root = new DocumentSection();
    root.addFeature(
        FeatureBuilder.instance()
            .id("My Feature")
            .name("My Feature")
            .tag("@section-SectionOne")
            .tag("@skipDocs")
            .build());
    root.addFeature(
        FeatureBuilder.instance()
            .id("My Other Feature")
            .name("My Other Feature")
            .tag("@skipDocs")
            .build());

    assertEquals("", renderDocument(root));
  }

  @Test
  public void shouldRenderGlossaryAfterAppendices() {
    DocumentSection root = new DocumentSection();
    root.addFeature(
        FeatureBuilder.instance()
            .id("Appendix Subtitle")
            .name("Appendix Subtitle")
            .tag("@section-MyAppendix")
            .tag("@appendix")
            .build());
    root.addFeature(
        FeatureBuilder.instance()
            .id("My Glossary")
            .name("My Glossary")
            .tag("@glossary")
            .description("This is my glossary.")
            .scenario(ScenarioBuilder.instance().name("Root").build())
            .build());

    String expectedDocument =
        "[appendix]"
            + newLine()
            + "[[MyAppendix, MyAppendix]]"
            + newLine()
            + "= *MyAppendix*"
            + newLine()
            + newLine()
            + newLine()
            + "[[Appendix-Subtitle, Appendix Subtitle]]"
            + newLine()
            + "== *Appendix Subtitle*"
            + newLine()
            + newLine()
            + "[glossary]"
            + newLine()
            + "[[My-Glossary, My Glossary]]"
            + newLine()
            + "= *My Glossary*"
            + newLine()
            + newLine()
            + newLine()
            + "This is my glossary."
            + newLine()
            + newLine();

    assertEquals(expectedDocument, renderDocument(root));
  }

  @Test
  public void shouldRenderBibliographyAfterGlossary() {
    DocumentSection root = new DocumentSection();
    root.addFeature(
        FeatureBuilder.instance()
            .id("My Glossary")
            .name("My Glossary")
            .tag("@glossary")
            .description("This is my glossary.")
            .scenario(ScenarioBuilder.instance().name("Root").build())
            .build());
    root.addFeature(
        FeatureBuilder.instance()
            .id("My Bibliography")
            .name("My Bibliography")
            .tag("@bibliography")
            .description("This is my bibliography.")
            .scenario(ScenarioBuilder.instance().name("Root").build())
            .build());

    String expectedDocument =
        "[glossary]"
            + newLine()
            + "[[My-Glossary, My Glossary]]"
            + newLine()
            + "= *My Glossary*"
            + newLine()
            + newLine()
            + newLine()
            + "This is my glossary."
            + newLine()
            + newLine()
            + "[bibliography]"
            + newLine()
            + "[[My-Bibliography, My Bibliography]]"
            + newLine()
            + "= *My Bibliography*"
            + newLine()
            + newLine()
            + newLine()
            + "This is my bibliography."
            + newLine()
            + newLine();

    assertEquals(expectedDocument, renderDocument(root));
  }

  @Test
  public void shouldRenderIndexAfterBibliography() {
    DocumentSection root = new DocumentSection();
    root.addFeature(
        FeatureBuilder.instance()
            .id("My Bibliography")
            .name("My Bibliography")
            .tag("@bibliography")
            .description("This is my bibliography.")
            .scenario(ScenarioBuilder.instance().name("Root").build())
            .build());
    root.addFeature(
        FeatureBuilder.instance()
            .id("My Index")
            .name("My Index")
            .tag("@index")
            .scenario(ScenarioBuilder.instance().name("Root").build())
            .build());

    String expectedDocument =
        "[bibliography]"
            + newLine()
            + "[[My-Bibliography, My Bibliography]]"
            + newLine()
            + "= *My Bibliography*"
            + newLine()
            + newLine()
            + newLine()
            + "This is my bibliography."
            + newLine()
            + newLine()
            + "[index]"
            + newLine()
            + "[[My-Index, My Index]]"
            + newLine()
            + "= *My Index*"
            + newLine()
            + newLine()
            + newLine();

    assertEquals(expectedDocument, renderDocument(root));
  }

  @Test
  public void orderShouldBeIntMax() {
    assertEquals(Integer.MAX_VALUE, new DocumentSection().getOrder());
  }

  @Test
  public void shouldGetNoFeaturesIfEmpty() {
    final DocumentSection root = new DocumentSection();

    assertThat(root.getFeatures()).isEmpty();
  }

  @Test
  public void shouldGetFeaturesInOrder() {
    final Feature one =
        FeatureBuilder.instance()
            .tag("@order-1")
            .tag("@section-one")
            .scenario(ScenarioBuilder.instance().name("Root").build())
            .build();
    final Feature two =
        FeatureBuilder.instance()
            .tag("order-2")
            .tag("@section-two")
            .tag("@subsection-one")
            .scenario(ScenarioBuilder.instance().name("Root").build())
            .build();
    final Feature three =
        FeatureBuilder.instance().tag("order-3").tag("@section-two").tag("@subsection-one").build();
    final Feature four = FeatureBuilder.instance().tag("order-4").tag("@section-three").build();
    final Feature five = FeatureBuilder.instance().tag("order-5").build();
    final Feature six = FeatureBuilder.instance().tag("order-6").tag("@subsection-one").build();
    final Feature seven =
        FeatureBuilder.instance()
            .tag("order-7")
            .tag("@appendix")
            .tag("@section-four")
            .tag("@subsection-one")
            .scenario(ScenarioBuilder.instance().name("Root").build())
            .build();
    final Feature eight =
        FeatureBuilder.instance().tag("order-8").tag("@appendix").tag("@section-five").build();

    final DocumentSection root = new DocumentSection();
    root.addFeatures(Arrays.asList(six, five, three, four, one, two, seven, eight));

    assertThat(root.getFeatures()).containsExactly(one, two, three, four, five, six, seven, eight);
  }

  private String renderDocument(DocumentSection root) {
    return root.render(
        CukedoctorDocumentBuilder.Factory.newInstance(),
        I18nLoader.instance(null),
        new DocumentAttributes(),
        new CukedoctorConfig());
  }
}
