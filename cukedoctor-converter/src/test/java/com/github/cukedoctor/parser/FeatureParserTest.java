package com.github.cukedoctor.parser;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import com.github.cukedoctor.util.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

/**
 * Created by rafael-pestano on 03/09/2015.
 */
@RunWith(JUnit4.class)
public class FeatureParserTest {

	final String onePassingOneFailing = "one_passing_one_failing.json";

	@Test
	public void shouldParseFeature() throws IOException {
		String path = FileUtil.findJsonFile("target/test-classes/json-output/" + onePassingOneFailing);
		List<Feature> features = FeatureParser.parse(path);
		assertThat(features).isNotNull().hasSize(1).contains(FeatureBuilder.instance().name("One passing scenario, one failing scenario").id("one-passing-scenario,-one-failing-scenario").build());
	}

	@Test
	public void shouldParseFeatureUsingLeadingSlash() throws IOException {
		String path = FileUtil.findJsonFile("/target/test-classes/json-output/" + onePassingOneFailing);
		List<Feature> features = FeatureParser.parse(path);
		assertThat(features).isNotNull().hasSize(1).contains(FeatureBuilder.instance().name("One passing scenario, one failing scenario").id("one-passing-scenario,-one-failing-scenario").build());
	}

	@Test
	public void shouldParseFeaturesInDir() throws IOException {
		List<String> paths = FileUtil.findJsonFiles("target/test-classes/json-output");
		assertThat(paths).hasSize(11);
		List<Feature> features = FeatureParser.parse(paths);
		assertThat(features).hasSize(9).contains(FeatureBuilder.instance().name("An embed data directly feature").id("an-embed-data-directly-feature").build());
	}

	@Test
	public void shouldParseAndFindFeaturesInDir() throws IOException {
		List<Feature> features = FeatureParser.findAndParse("target/test-classes/json-output");
		assertThat(features).hasSize(9).contains(FeatureBuilder.instance().name("An embed data directly feature").id("an-embed-data-directly-feature").build());
	}

	@Test
	public void shouldParseAndFindFeaturesInDirUsingLeadingSlash() throws IOException {
		List<Feature> features = FeatureParser.findAndParse("/target/test-classes/json-output");
		assertThat(features).hasSize(9).contains(FeatureBuilder.instance().name("An embed data directly feature").id("an-embed-data-directly-feature").build());
	}

	@Test
	public void shouldParseAndFindFeaturesInDirUsingAbsoluteath() throws IOException {
		List<Feature> features = FeatureParser.findAndParse(Paths.get("").toAbsolutePath().toString() +"/target/test-classes/json-output");
		assertThat(features).hasSize(9).contains(FeatureBuilder.instance().name("An embed data directly feature").id("an-embed-data-directly-feature").build());
	}

	@Test
	public void shouldParseFeatureInAbsolutePath() throws IOException {
		String absolutePath = Paths.get("").toAbsolutePath() + "/target/test-classes/json-output/" + onePassingOneFailing;
		String path = FileUtil.findJsonFile(absolutePath);
		assertThat(path).isNotNull();
		List<Feature> features = FeatureParser.parse(path);
		assertThat(features).isNotNull().hasSize(1).contains(FeatureBuilder.instance().name("One passing scenario, one failing scenario").id("one-passing-scenario,-one-failing-scenario").build());

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
		List<Feature> features = FeatureParser.parse(FileUtil.findJsonFile("json-output/invalid_json.json"));
		assertNull(features);
	}

	@Test
	public void shouldNotReadInvalidJsonFile() {
		String filePath = FileUtil.findJsonFile("features/outline.feature");
		List<Feature> features = FeatureParser.parse(filePath);
		assertNull(features);
	}


}
