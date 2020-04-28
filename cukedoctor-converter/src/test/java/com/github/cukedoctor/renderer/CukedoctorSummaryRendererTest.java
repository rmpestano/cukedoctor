package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.spi.SummaryRenderer;
import com.github.cukedoctor.util.Expectations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static com.github.cukedoctor.renderer.Fixtures.*;
import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class CukedoctorSummaryRendererTest {
    @Test
    public void shouldRenderSummaryForOneFeature() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        String resultDoc = new CukedoctorSummaryRenderer().renderSummary(features);
        assertThat(resultDoc).isNotNull().
                containsOnlyOnce("<<One-passing-scenario-one-failing-scenario>>").
                containsOnlyOnce("|[red]#*failed*#").
                contains("2+|010ms");

        assertThat(resultDoc).isEqualTo(Expectations.SUMMARY_FOR_ONE_FEATURE);
    }

    @Test
    public void shouldRenderSummaryForMultipleFeatures() {
        List<Feature> features = FeatureParser.parse(embedDataDirectly, outline, onePassingOneFailing, invalidFeatureResult);
        String resultDoc = new CukedoctorSummaryRenderer().renderSummary(features);
        assertThat(resultDoc).isNotNull().
                containsOnlyOnce("<<One-passing-scenario-one-failing-scenario>>").
                containsOnlyOnce("<<An-embed-data-directly-feature>>").
                containsOnlyOnce("<<An-outline-feature>>").
                doesNotContain("<<invalid feature result>>").
                contains("|[green]#*passed*#").
                contains("|[red]#*failed*#").
                containsOnlyOnce("2+|010ms");
        assertThat(resultDoc).isEqualTo(Expectations.SUMMARY_FOR_MULTIPLE_FEATURES);
    }

    @Test
    public void shouldRenderSummaryForFeatureWithBackground() {
        List<Feature> features = FeatureParser.parse(getClass().getResource("/json-output/feature_with_background.json").getPath());
        String resultDoc = new CukedoctorSummaryRenderer().renderSummary(features);
        assertThat(resultDoc).isNotNull().
                containsOnlyOnce("<<A-feature-with-background>>").
                contains("*Totals*" + newLine() +
                        "|2|0|2|4|0|0|0|0|0|4");
    }


    @Test
    public void shouldRenderTotalRowForOneFeature() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing);
        SummaryRenderer summaryRenderer = new CukedoctorSummaryRenderer();
        assertThat(summaryRenderer.renderSummary(features)).isNotNull().
                containsOnlyOnce("12+^|*Totals*").
                contains("|1|1|2|1|1|0|0|0|0|2 2+|010ms");
    }

    @Test
    public void shouldRenderTotalRowForMultipleFeature() {
        List<Feature> features = FeatureParser.parse(onePassingOneFailing, embedDataDirectly, outline, invalidFeatureResult);
        SummaryRenderer summaryRenderer = new CukedoctorSummaryRenderer();
        assertThat(summaryRenderer.renderSummary(features)).isNotNull().
                containsOnlyOnce("12+^|*Totals*").
                contains("|4|1|5|4|1|0|0|0|0|5 2+|010ms");
    }
}