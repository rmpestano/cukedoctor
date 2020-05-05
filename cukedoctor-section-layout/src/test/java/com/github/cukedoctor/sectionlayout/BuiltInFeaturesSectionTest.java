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
public class BuiltInFeaturesSectionTest {
    @BeforeClass
    public static void beforeClass() {
        System.setProperty("HIDE_STEP_TIME", "true");
        System.setProperty("cukedoctor.disable-extensions", "true");
    }

    @Test
    public void shouldRenderWithoutSectionTitleIfHidingFeaturesSection() {
        System.setProperty("HIDE_FEATURES_SECTION", "true");

        final BuiltInFeaturesSection section = new BuiltInFeaturesSection();
        section.addFeature(FeatureBuilder.instance().aFeatureWithNoScenarios());
        section.addFeature(FeatureBuilder.instance().aFeatureWithNoScenarios());

        final String oneScenario = "[[Feature-name, Feature name]]" + newLine() +
                "= *Feature name*" + newLine() +
                newLine() +
                newLine() +
                "****" + newLine() +
                "Feature description" + newLine() +
                "****" + newLine() +
                newLine();
        final String expectedDocument = oneScenario + oneScenario;

        final String result = section.render(CukedoctorDocumentBuilder.Factory.newInstance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals(expectedDocument, result);
    }

    @Test
    public void shouldRenderWithSectionTitleIfShowingFeaturesSection() {
        System.setProperty("HIDE_FEATURES_SECTION", "false");

        final BuiltInFeaturesSection section = new BuiltInFeaturesSection();
        section.addFeature(FeatureBuilder.instance().aFeatureWithNoScenarios());
        section.addFeature(FeatureBuilder.instance().aFeatureWithNoScenarios());

        final String oneScenario = "[[Feature-name, Feature name]]" + newLine() +
                "== *Feature name*" + newLine() +
                newLine() +
                "****" + newLine() +
                "Feature description" + newLine() +
                "****" + newLine() +
                newLine();
        final String expectedDocument = "[[Features, Features]]" + newLine() +
                "= *Features*" + newLine() + newLine() + newLine()
                + oneScenario
                + oneScenario;

        final String result = section.render(CukedoctorDocumentBuilder.Factory.newInstance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals(expectedDocument, result);
    }
}
