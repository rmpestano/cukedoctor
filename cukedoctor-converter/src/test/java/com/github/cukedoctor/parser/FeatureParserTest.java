package com.github.cukedoctor.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.github.cukedoctor.api.model.Embedding;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Created by rafael-pestano on 03/03/2015. */
@RunWith(JUnit4.class)
public class FeatureParserTest {

  final String onePassingOneFailing = "one_passing_one_failing.json";

  @Test
  public void shouldParseFeature() {
    String path = FileUtil.findJsonFile("target/test-classes/json-output/" + onePassingOneFailing);
    List<Feature> features = FeatureParser.parse(path);
    assertThat(features)
        .isNotNull()
        .hasSize(1)
        .contains(
            FeatureBuilder.instance()
                .name("One passing scenario, one failing scenario")
                .id("one-passing-scenario,-one-failing-scenario")
                .build());
  }

  @Test
  public void shouldParseFeatureUsingResourcePath() {
    URL featureFile = getClass().getResource("/json-output/" + onePassingOneFailing);
    String path = FileUtil.findJsonFile(featureFile.getPath());
    List<Feature> features = FeatureParser.parse(path);
    assertThat(features)
        .isNotNull()
        .hasSize(1)
        .contains(
            FeatureBuilder.instance()
                .name("One passing scenario, one failing scenario")
                .id("one-passing-scenario,-one-failing-scenario")
                .build());
  }

  @Test
  public void shouldParseFeatureUsingLeadingSlash() {
    String path = FileUtil.findJsonFile("/target/test-classes/json-output/" + onePassingOneFailing);
    List<Feature> features = FeatureParser.parse(path);
    assertThat(features)
        .isNotNull()
        .hasSize(1)
        .contains(
            FeatureBuilder.instance()
                .name("One passing scenario, one failing scenario")
                .id("one-passing-scenario,-one-failing-scenario")
                .build());
  }

  @Test
  public void shouldParseFeaturesInDir() {
    List<String> paths = FileUtil.findJsonFiles("target/test-classes/json-output/parser");
    assertThat(paths).hasSize(6);
    List<Feature> features = FeatureParser.parse(paths);
    assertThat(features)
        .hasSize(4)
        .contains(
            FeatureBuilder.instance()
                .name("An embed data directly feature")
                .id("an-embed-data-directly-feature")
                .build());
  }

  @Test
  public void shouldParseAndFindFeaturesInDir() {
    List<Feature> features = FeatureParser.findAndParse("target/test-classes/json-output/parser");
    assertThat(features)
        .hasSize(4)
        .contains(
            FeatureBuilder.instance()
                .name("An embed data directly feature")
                .id("an-embed-data-directly-feature")
                .build());
  }

  @Test
  public void shouldParseFeatureWithDocstring() {
    List<Feature> features =
        FeatureParser.parse("target/test-classes/json-output/parser/feature_with_docstring.json");
    assertThat(features)
        .hasSize(1)
        .contains(
            FeatureBuilder.instance()
                .name("An embed data directly feature")
                .id("an-embed-data-directly-feature")
                .build());
    List<Scenario> scenarios = features.get(0).getScenarios();
    assertNotNull(scenarios);
    for (Scenario scenario : scenarios) {
      if (scenario.getName().equals("scenario 1")) {
        Step step = scenario.getStepByName("I embed data directly");
        assertThat(step).isNotNull();
        assertThat(step.getDocString()).isNotNull();
        assertThat(step.getDocString().getValue()).isEqualTo("A paragraph in an open block.");
        assertThat(step.getDocString().getContentType()).isEmpty();

        step = scenario.getStepByName("I embed code directly");
        assertThat(step).isNotNull();
        assertThat(step.getDocString()).isNotNull();
        assertThat(step.getDocString().getValue()).isEqualTo("puts('Hello world')");
        assertThat(step.getDocString().getContentType()).isEqualTo("ruby");
      }
    }
  }

  @Test
  public void shouldParseFeatureWithOutput() {
    List<Feature> features =
        FeatureParser.parse("target/test-classes/json-output/parser/feature_with_output.json");
    assertThat(features).hasSize(1);
    List<Scenario> scenarios = features.get(0).getScenarios();
    assertNotNull(scenarios);
    Scenario scenario = features.get(0).getScenarioByName("Show the current version of sdkman");
    assertThat(scenario).isNotNull();
    Step step = scenario.getStepByName("I see \"SDKMAN x.y.z\"");
    assertThat(step).isNotNull();
    assertThat(step.getOutput()).isNotNull().hasSize(1);
    assertThat(step.getOutput().get(0).getValue().replaceAll("\n", ""))
        .isEqualTo("Output: broadcast messageSDKMAN x.y.z");
  }

  @Test
  public void shouldParseFeatureWithAttachments() {
    List<Feature> features =
        FeatureParser.parse("target/test-classes/json-output/attachments.json");
    assertThat(features).hasSize(1);
    List<Scenario> scenarios = features.get(0).getScenarios();
    assertNotNull(scenarios);
    Scenario scenario = features.get(0).getScenarioByName("Multiple attachments");
    assertThat(scenario).isNotNull();
    Step step = scenario.getStepByName("a Step that has multiple attachments");
    assertThat(step).isNotNull();

    List<Embedding> embeddings = step.getEmbeddings();
    assertThat(embeddings).isNotNull().hasSize(3);

    assertThat(embeddings.get(0))
        .isNotNull()
        .hasFieldOrPropertyWithValue("data", "First attachment")
        .hasFieldOrPropertyWithValue("mimeType", "text/plain")
        .hasFieldOrPropertyWithValue("name", null);

    assertThat(embeddings.get(1))
        .isNotNull()
        .hasFieldOrPropertyWithValue("data", "U2Vjb25kIEF0dGFjaG1lbnQ\u003d")
        .hasFieldOrPropertyWithValue("mimeType", "text/plain")
        .hasFieldOrPropertyWithValue("name", "Second");

    assertThat(embeddings.get(2))
        .isNotNull()
        .hasFieldOrPropertyWithValue("data", "Third attachment")
        .hasFieldOrPropertyWithValue("mimeType", "text/plain")
        .hasFieldOrPropertyWithValue("name", null);
  }

  @Test
  public void shouldParseAndFindFeaturesInDirUsingLeadingSlash() {
    List<Feature> features = FeatureParser.findAndParse("/target/test-classes/json-output/parser");
    assertThat(features)
        .hasSize(4)
        .contains(
            FeatureBuilder.instance()
                .name("An embed data directly feature")
                .id("an-embed-data-directly-feature")
                .build());
  }

  @Test
  public void shouldParseAndFindFeaturesInDirUsingAbsoluteath() {
    List<Feature> features =
        FeatureParser.findAndParse(
            Paths.get("").toAbsolutePath() + "/target/test-classes/json-output/parser");
    assertThat(features)
        .hasSize(4)
        .contains(
            FeatureBuilder.instance()
                .name("An embed data directly feature")
                .id("an-embed-data-directly-feature")
                .build());
  }

  @Test
  public void shouldParseFeatureInAbsolutePath() {
    String absolutePath =
        Paths.get("").toAbsolutePath() + "/target/test-classes/json-output/" + onePassingOneFailing;
    String path = FileUtil.findJsonFile(absolutePath);
    assertThat(path).isNotNull();
    List<Feature> features = FeatureParser.parse(path);
    assertThat(features)
        .isNotNull()
        .hasSize(1)
        .contains(
            FeatureBuilder.instance()
                .name("One passing scenario, one failing scenario")
                .id("one-passing-scenario,-one-failing-scenario")
                .build());
  }

  @Test
  public void shouldNotLoadNonExistingFeature() {
    List<Feature> features = FeatureParser.parse("/dev");
    assertNull(features);
  }

  @Test
  public void shouldNotFindFeatures() {
    List<Feature> features = FeatureParser.parse(FileUtil.findJsonFile("/target/invalid/"));
    assertNull(features);
  }

  @Test
  public void shouldNotParseInvalidJsonFile() {
    List<Feature> features =
        FeatureParser.parse(FileUtil.findJsonFile("json-output/invalid_json.json"));
    assertNull(features);
  }

  @Test
  public void shouldNotReadInvalidJsonFile() {
    String filePath = FileUtil.findJsonFile("features/outline.feature");
    List<Feature> features = FeatureParser.parse(filePath);
    assertNull(features);
  }

  @Test
  public void shouldParseFeatureWithCommentsInScenariosExamples() {
    List<Feature> features =
        FeatureParser.parse(
            getClass()
                .getResource("/json-output/feature_with_comments_in_examples.json")
                .getPath());
    assertThat(features).isNotNull().hasSize(1);
  }
}
