package com.github.cukedoctor.bdd.cukedoctor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.renderer.CukedoctorFeatureRenderer;
import com.github.cukedoctor.util.StringUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.net.URL;
import java.util.List;

public class AttachmentSteps {
  private String renderedDocument;

  private String disableExtensions;
  private String hideStepTime;
  private URL featureFile;

  public AttachmentSteps() {}

  @Before
  public void before() {
    disableExtensions = System.getProperty("cukedoctor.disable-extensions");
    hideStepTime = System.getProperty("HIDE_STEP_TIME");
    renderedDocument = null;
    featureFile = null;
  }

  @After
  public void after() {
    // Assumed defaults across the test suite
    // There is no "after all" hook in Cucumber-JVM, so somewhat wastefully they go here
    resetProperty("cukedoctor.disable-extensions", disableExtensions);
    resetProperty("HIDE_STEP_TIME", hideStepTime);
  }

  private void resetProperty(String name, String value) {
    if (value == null) {
      System.clearProperty(name);
    } else {
      System.setProperty(name, value);
    }
  }

  @Given("a Step has logged a string in Cucumber-JVM {double}.{int}")
  public void a_Step_has_logged_a_string_in_Cucumber_JVM(Double double1, Integer int1) {
    featureFile =
        getFeatureUrl("/com/github/cukedoctor/json-output/cucumber-jvm-6-7-0-log-string.json");
  }

  @Given("a Step has attached plain text as a string with a title in Cucumber-JVM {double}.{int}")
  public void a_Step_has_attached_plain_text_as_a_string_with_a_title_in_Cucumber_JVM(
      Double double1, Integer int1) {
    featureFile =
        getFeatureUrl(
            "/com/github/cukedoctor/json-output/cucumber-jvm-6-7-0-attach-string-string-string.json");
  }

  @Given(
      "a Step has attached plain text as a byte array with a title in Cucumber-JVM {double}.{int}")
  public void a_Step_has_attached_plain_text_as_a_byte_array_with_a_title_in_Cucumber_JVM(
      Double double1, Integer int1) {
    featureFile =
        getFeatureUrl(
            "/com/github/cukedoctor/json-output/cucumber-jvm-6-7-0-attach-bytearray-string-string.json");
  }

  @Given("a Step has attached a string in CucumberJS {double}.{int}")
  public void a_Step_has_attached_a_string_in_CucumberJS(Double double1, Integer int1) {
    featureFile =
        getFeatureUrl("/com/github/cukedoctor/json-output/cucumber-js-6-0-5-attach-string.json");
  }

  @Given("a Step has attached plain text as a string in CucumberJS {double}.{int}")
  public void a_Step_has_attached_plain_text_as_a_string_in_CucumberJS(
      Double double1, Integer int1) {
    featureFile =
        getFeatureUrl(
            "/com/github/cukedoctor/json-output/cucumber-js-6-0-5-attach-string-string.json");
  }

  @Given("a Step has attached plain text as a buffer in CucumberJS {double}.{int}")
  public void a_Step_has_attached_plain_text_as_a_buffer_in_CucumberJS(
      Double double1, Integer int1) {
    featureFile =
        getFeatureUrl(
            "/com/github/cukedoctor/json-output/cucumber-js-6-0-5_attach-buffer-string.json");
  }

  @Given("a Step has logged a string and attached a plain text string with a title")
  public void a_Step_has_logged_a_string_and_attached_a_plain_text_string_with_a_title() {
    featureFile = getFeatureUrl("/com/github/cukedoctor/json-output/log-and-attach.json");
  }

  @Given("a Step has three plain text attachments, two without a title")
  public void a_Step_has_three_plain_text_attachments_two_without_a_title() {
    featureFile = getFeatureUrl("/com/github/cukedoctor/json-output/multiple-attachments.json");
  }

  @Given("a Step has logged an image\\/png attachment")
  public void a_Step_has_logged_an_image_png_attachment() {
    featureFile = getFeatureUrl("/com/github/cukedoctor/json-output/not-plain-text.json");
  }

  @Given("I am hiding step timings")
  public void i_am_hiding_step_timings() {
    System.setProperty("HIDE_STEP_TIME", "true");
  }

  @Given("all Cukedoctor extensions are disabled")
  public void all_cukedoctor_extensions_are_disabled() {
    System.setProperty("cukedoctor.disable-extensions", "true");
  }

  @When("I convert the Feature")
  public void i_convert_the_feature() {
    List<Feature> features = FeatureParser.parse(featureFile.getPath());
    assertThat(features).isNotNull().hasSize(1);
    renderedDocument = new CukedoctorFeatureRenderer().renderFeatures(features);
  }

  @Then("it will be rendered as")
  public void it_will_be_rendered_as(String expectedDocument) {
    assetDocumentEquals(expectedDocument);
  }

  public void assetDocumentEquals(String expectedDocument) {
    assertEquals(
        StringUtil.normaliseLineEndings(expectedDocument),
        StringUtil.normaliseLineEndings(renderedDocument));
  }

  private URL getFeatureUrl(String path) {
    URL featureFile = getClass().getResource(path);
    assertThat(featureFile).isNotNull();
    return featureFile;
  }
}
