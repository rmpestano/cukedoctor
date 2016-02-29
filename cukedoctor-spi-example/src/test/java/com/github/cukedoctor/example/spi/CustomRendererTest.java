package com.github.cukedoctor.example.spi;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pestano on 27/02/16.
 */
@RunWith(JUnit4.class)
public class CustomRendererTest {

    private static String onePassingOneFailing;


    @BeforeClass
    public static void loadFeatures() {
        onePassingOneFailing = FileUtil.findJsonFile("target/test-classes/json-output/one_passing_one_failing.json");
    }

    @Test
    public void shouldUseCustomSummaryRenderer(){
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);

        DocumentAttributes attrs = new DocumentAttributes();
                attrs.docTitle("Living Documentation")
                .icons("font").numbered(false)
                .sectAnchors(true).sectLink(true);

        CukedoctorConverter converter = Cukedoctor.instance(features, attrs);

        String resultDoc = converter.renderSummary().getDocumentation();
        assertThat(resultDoc).isEqualTo("== *Summary*"+newLine() +
                "This is a custom summary renderer"+newLine() +
                "Number of features: "+newLine() +
                "1"+newLine() +
                "Passed steps: 1"+newLine() +
                "Failed steps: 1"+newLine());
    }
}
