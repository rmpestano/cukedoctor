package com.github.cukedoctor.parser;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.util.FeatureBuilder;
import com.github.cukedoctor.util.FileUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by rafael-pestano on 03/06/2015.
 */
@RunWith(JUnit4.class)
public class FeatureParserTest {

    final String onePassingOneFailing = "one_passing_one_failing.json";

    @Test
    public void shouldLoadFeature() throws IOException {
        String path = FileUtil.findJsonFile("json-output/" + onePassingOneFailing);
        List<Feature> features = FeatureParser.parse(path);
        assertThat(features).
                isNotNull().
                hasSize(1).
                contains(FeatureBuilder.instance().
                        name("One passing scenario, one failing scenario").
                        id("one-passing-scenario,-one-failing-scenario").build());
    }

    @Test
    public void shouldLoadFeaturesInDir() throws IOException {
        List<String> paths = FileUtil.findJsonFiles("json-output");
        assertThat(paths).hasSize(5);
        List<Feature> features = FeatureParser.parse(paths);
        assertThat(features)
                .hasSize(4)
                .contains(FeatureBuilder.instance().
                        name("An embed data directly feature").
                        id("an-embed-data-directly-feature").build());
    }
}
