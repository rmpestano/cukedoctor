package com.github.cukedoctor.renderer;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.junit.Assert.assertEquals;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.spi.TagsRenderer;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CukedoctorTagsRendererTest {
  private final TagsRenderer tagsRenderer = new CukedoctorTagsRenderer();
  private final String someTag = "@someTag";
  private final String order42 = "@order-42";
  private final String order1 = "@order-1";
  private final String otherTag = "@otherTag";
  private final String discrete = "@asciidoc";

  @Test
  public void shouldNotRenderIfNeitherFeatureNorScenarioHasTags() {
    assertEquals(
        "",
        tagsRenderer.renderScenarioTags(
            createEmptyFeature(),
            createEmptyScenario(),
            CukedoctorDocumentBuilder.Factory.newInstance()));
  }

  @Test
  public void shouldRenderIfScenarioHasTags() {
    assertEquals(
        "[small]#tags: " + someTag + "#" + newLine() + newLine(),
        tagsRenderer.renderScenarioTags(
            createEmptyFeature(),
            createScenario(someTag),
            CukedoctorDocumentBuilder.Factory.newInstance()));
  }

  @Test
  public void shouldRenderIfScenarioHasOrderAndNotOrderTags() {
    assertEquals(
        "[small]#tags: " + someTag + "#" + newLine() + newLine(),
        tagsRenderer.renderScenarioTags(
            createEmptyFeature(),
            createScenario(someTag, order42),
            CukedoctorDocumentBuilder.Factory.newInstance()));
  }

  @Test
  public void shouldNotRenderIfScenarioOnlyHasSingleOrderTagAndFeatureHasNoTags() {
    assertEquals(
        "",
        tagsRenderer.renderScenarioTags(
            createEmptyFeature(),
            createScenario(order42),
            CukedoctorDocumentBuilder.Factory.newInstance()));
  }

  @Test
  public void shouldNotRenderIfScenarioOnlyHasOrderTagsAndFeatureHasNoTags() {
    assertEquals(
        "",
        tagsRenderer.renderScenarioTags(
            createEmptyFeature(),
            createScenario(order42, order1),
            CukedoctorDocumentBuilder.Factory.newInstance()));
  }

  @Test
  public void shouldNotRenderIfScenarioOnlyHasDiscreteTagAndFeatureHasNoTags() {
    assertEquals(
        "",
        tagsRenderer.renderScenarioTags(
            createEmptyFeature(),
            createScenario(discrete),
            CukedoctorDocumentBuilder.Factory.newInstance()));
  }

  @Test
  public void shouldRenderIfFeatureHasTagsButNotOrderTags() {
    assertEquals(
        "[small]#tags: " + someTag + "#" + newLine() + newLine(),
        tagsRenderer.renderScenarioTags(
            createFeature(someTag),
            createEmptyScenario(),
            CukedoctorDocumentBuilder.Factory.newInstance()));
  }

  @Test
  public void shouldRenderIfFeatureHasOrderAndNotOrderTags() {
    assertEquals(
        "[small]#tags: " + someTag + "#" + newLine() + newLine(),
        tagsRenderer.renderScenarioTags(
            createFeature(someTag, order42),
            createEmptyScenario(),
            CukedoctorDocumentBuilder.Factory.newInstance()));
  }

  @Test
  public void shouldNotRenderIfFeatureOnlyHasSingleOrderTagAndScenarioHasNoTags() {
    assertEquals(
        "",
        tagsRenderer.renderScenarioTags(
            createFeature(order42),
            createEmptyScenario(),
            CukedoctorDocumentBuilder.Factory.newInstance()));
  }

  @Test
  public void shouldNotRenderIfFeatureOnlyHasOrderTagsAndScenarioHasNoTags() {
    assertEquals(
        "",
        tagsRenderer.renderScenarioTags(
            createFeature(order42, order1),
            createEmptyScenario(),
            CukedoctorDocumentBuilder.Factory.newInstance()));
  }

  @Test
  public void shouldNotRenderIfFeatureOnlyHasDiscreteTagAndScenarioHasNoTags() {
    assertEquals(
        "",
        tagsRenderer.renderScenarioTags(
            createFeature(discrete),
            createEmptyScenario(),
            CukedoctorDocumentBuilder.Factory.newInstance()));
  }

  @Test
  public void shouldRenderIfFeatureAndScenarioHaveTags() {
    assertEquals(
        "[small]#tags: " + someTag + "," + otherTag + "#" + newLine() + newLine(),
        tagsRenderer.renderScenarioTags(
            createFeature(someTag),
            createScenario(otherTag),
            CukedoctorDocumentBuilder.Factory.newInstance()));
  }

  @Test
  public void shouldRenderTagOnceIfPresentOnBothFeatureAndScenario() {
    assertEquals(
        "[small]#tags: " + someTag + "," + otherTag + "#" + newLine() + newLine(),
        tagsRenderer.renderScenarioTags(
            createFeature(someTag),
            createScenario(otherTag, someTag),
            CukedoctorDocumentBuilder.Factory.newInstance()));
  }

  @Test
  public void shouldNotRenderIfFeatureAndScenarioOnlyHaveOrderTags() {
    assertEquals(
        "",
        tagsRenderer.renderScenarioTags(
            createFeature(order42),
            createScenario(order42),
            CukedoctorDocumentBuilder.Factory.newInstance()));
  }

  private Feature createFeature(String... names) {
    final Feature feature = new Feature();
    feature.setTags(createTags(names));
    return feature;
  }

  private Feature createEmptyFeature() {
    final Feature feature = new Feature();
    Assert.assertFalse("Feature unexpectedly has tags", feature.hasTags());
    return feature;
  }

  private Scenario createScenario(String... names) {
    final Scenario scenario = new Scenario();
    scenario.setTags(createTags(names));
    return scenario;
  }

  private Scenario createEmptyScenario() {
    final Scenario scenario = createScenario();
    Assert.assertFalse("Scenario unexpectedly has tags", scenario.hasTags());
    return scenario;
  }

  private List<Tag> createTags(String... names) {
    if (names != null && names.length != 0) {
      ArrayList<Tag> tags = new ArrayList<>(names.length);
      for (String name : names) {
        tags.add(new Tag(name));
      }

      return tags;
    }

    return new ArrayList<>(0);
  }
}
