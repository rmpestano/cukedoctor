package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import com.github.cukedoctor.util.builder.ScenarioBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class BasicSectionTest {
    @BeforeClass
    public static void beforeClass() {
        System.setProperty("HIDE_STEP_TIME", "true");
        System.setProperty("cukedoctor.disable-extensions", "true");
    }

    @Test
    public void shouldRender() {
        final BasicSection section = createSection();

        section.addFeature(FeatureBuilder.instance().name("My First Child").build());
        section.addFeature(FeatureBuilder.instance().name("My Second Child").build());

        final String expectedDocument = "[[My-Section, My Section]]" + newLine() +
                "= *My Section*" + newLine() + newLine() + newLine() +
                "[[My-First-Child, My First Child]]" + newLine() +
                "== *My First Child*" + newLine() +
                newLine() +
                "[[My-Second-Child, My Second Child]]" + newLine() +
                "== *My Second Child*" + newLine() +
                newLine();

        final String result = section.render(CukedoctorDocumentBuilder.Factory.instance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals(expectedDocument, result);
    }

    @Test
    public void shouldRenderChildrenInOrder() {
        final BasicSection section = createSection();

        section.addFeature(FeatureBuilder.instance().name("My Second Child").tag("@order-2").build());
        section.addFeature(FeatureBuilder.instance().name("My First Child").tag("@order-1").build());

        final String expectedDocument = "[[My-Section, My Section]]" + newLine() +
                "= *My Section*" + newLine() + newLine() + newLine() +
                "[[My-First-Child, My First Child]]" + newLine() +
                "== *My First Child*" + newLine() +
                newLine() +
                "[[My-Second-Child, My Second Child]]" + newLine() +
                "== *My Second Child*" + newLine() +
                newLine();

        final String result = section.render(CukedoctorDocumentBuilder.Factory.instance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals(expectedDocument, result);
    }

    @Test
    public void shouldRenderRootFeatureInsteadOfTitle() {
        final BasicSection section = createSection();

        section.addFeature(FeatureBuilder.instance().name("My First Child").build());
        section.addFeature(FeatureBuilder.instance().name("My Cool Section").description("This tells you all about my really cool section.").scenario(ScenarioBuilder.instance().name("Root").build()).build());

        final String expectedDocument = "[[My-Cool-Section, My Cool Section]]" + newLine() +
                "= *My Cool Section*" + newLine() + newLine() + newLine() +
                "****" + newLine() +
                "This tells you all about my really cool section." + newLine() +
                "****" + newLine() + newLine() +
                "[[My-First-Child, My First Child]]" + newLine() +
                "== *My First Child*" + newLine() + newLine();

        final String result = section.render(CukedoctorDocumentBuilder.Factory.instance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals(expectedDocument, result);
    }


    @Test
    public void shouldRenderRootFeatureEvenIfThereAreNoChildFeatures() {
        final BasicSection section = createSection();

        section.addFeature(FeatureBuilder.instance().name("My Cool Section").description("This tells you all about my really cool section.").scenario(ScenarioBuilder.instance().name("Root").build()).build());

        final String expectedDocument = "[[My-Cool-Section, My Cool Section]]" + newLine() +
                "= *My Cool Section*" + newLine() + newLine() + newLine() +
                "****" + newLine() +
                "This tells you all about my really cool section." + newLine() +
                "****" + newLine() + newLine();

        final String result = section.render(CukedoctorDocumentBuilder.Factory.instance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals(expectedDocument, result);
    }

    @Test
    public void shouldNotRenderIfSectionHasNoChildren() {
        final BasicSection section = createSection();

        final String result = section.render(CukedoctorDocumentBuilder.Factory.instance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals("", result);
    }

    @Test
    public void orderShouldBeIntMaxIfThereAreNoChildren() {
        final BasicSection section = createSection();

        assertEquals(Integer.MAX_VALUE, section.getOrder());
    }

    @Test
    public void orderShouldBeMinimumOfChildSections() {
        final BasicSection section = createSection();

        section.addFeature(FeatureBuilder.instance().tag("@order-42").build());
        section.addFeature(FeatureBuilder.instance().tag("@order--13").build());

        assertEquals(-13, section.getOrder());
    }

    private BasicSection createSection() {
        return new BasicSection() {
            @Override
            protected Section createChildSection(Feature feature) {
                return new FeatureSection(feature);
            }

            @Override
            protected boolean shouldRenderSectionName() {
                return true;
            }

            @Override
            protected String getDefaultSectionName(I18nLoader i18n) {
                return "My Section";
            }
        };
    }
}
