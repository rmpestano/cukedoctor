package com.github.cukedoctor.sectionlayout;

import static com.github.cukedoctor.util.Constants.newLine;
import static com.github.cukedoctor.util.Features.aFeatureWithNoScenarios;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FeatureSectionTest {
  @BeforeClass
  public static void beforeClass() {
    System.setProperty("HIDE_FEATURES_SECTION", "true");
    System.setProperty("HIDE_STEP_TIME", "true");
    System.setProperty("cukedoctor.disable-extensions", "true");
  }

  @Test
  public void shouldRender() {
    final Feature feature = aFeatureWithNoScenarios();
    final FeatureSection section = new FeatureSection(feature);

    final String expected =
        "[[Feature-name, Feature name]]"
            + newLine()
            + "= *Feature name*"
            + newLine()
            + newLine()
            + newLine()
            + "Feature description"
            + newLine()
            + newLine();

    final String result =
        section.render(
            CukedoctorDocumentBuilder.Factory.newInstance(),
            I18nLoader.instance(null),
            new DocumentAttributes(),
            new CukedoctorConfig());

    assertEquals(expected, result);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void addFeatureShouldThrow() {
    new FeatureSection(new Feature()).addFeature(new Feature());
  }

  @Test
  public void orderShouldBeIntMaxIfFeatureDoesNotHaveOrderTag() {
    final FeatureSection section = new FeatureSection(FeatureBuilder.instance().build());
    assertEquals(Integer.MAX_VALUE, section.getOrder());
  }

  @Test
  public void orderShouldBeMinimumOfOrderTags() {
    final FeatureSection section =
        new FeatureSection(FeatureBuilder.instance().tag("@order-42").build());
    assertEquals(42, section.getOrder());
  }

  @Test
  public void shouldGetFeature() {
    final Feature feature = new Feature();
    final FeatureSection section = new FeatureSection(feature);

    assertThat(section.getFeatures()).containsExactly(feature);
  }
}
