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

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
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

        final String result = section.render(CukedoctorDocumentBuilder.Factory.newInstance(), I18nLoader.instance(null), new DocumentAttributes());

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

        final String result = section.render(CukedoctorDocumentBuilder.Factory.newInstance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals(expectedDocument, result);
    }

    @Test
    public void shouldRenderRootFeatureInsteadOfTitle() {
        final BasicSection section = createSection();

        section.addFeature(FeatureBuilder.instance().name("My First Child").build());
        section.addFeature(FeatureBuilder.instance().name("My Cool Section").description("This tells you all about my really cool section.").scenario(ScenarioBuilder.instance().name("Root").build()).build());

        final String expectedDocument = "[[My-Cool-Section, My Cool Section]]" + newLine() +
                "= *My Cool Section*" + newLine() + newLine() + newLine() +
                "This tells you all about my really cool section." + newLine() + newLine() +
                "[[My-First-Child, My First Child]]" + newLine() +
                "== *My First Child*" + newLine() + newLine();

        final String result = section.render(CukedoctorDocumentBuilder.Factory.newInstance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals(expectedDocument, result);
    }

    @Test
    public void shouldRenderFeaturesWithGroup() {
        final BasicSection section = new BasicSection("My Section", "SomeStyle", "@grouptag-");
        section.addFeature(FeatureBuilder.instance().name("My First Child").tag("@grouptag-Group1").build());
        final String expectedDocument = "[SomeStyle]" + newLine() +
                "[[My-Section, My Section]]" + newLine() +
                "= *My Section*" + newLine() + newLine() + newLine() +
                "[[Group1, Group1]]" + newLine() +
                "== *Group1*" + newLine() + newLine() +
                "[[My-First-Child, My First Child]]" + newLine() +
                "=== *My First Child*" + newLine() +
                newLine();

        final String result = section.render(CukedoctorDocumentBuilder.Factory.newInstance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals(expectedDocument, result);
    }

    @Test
    public void shouldRenderFeaturesInOrder() {
        final BasicSection section = new BasicSection("My Section", "SomeStyle", "@grouptag-");
        section.addFeature(FeatureBuilder.instance().name("My First Child").tag("@grouptag-Group1").build());
        section.addFeature(FeatureBuilder.instance().name("My Second Child").tag("@grouptag-Group1").tag("@order-1").build());
        section.addFeature(FeatureBuilder.instance().name("My Third Child").tag("@order-2").build());
        section.addFeature(FeatureBuilder.instance().name("My Fourth Child").tag("@grouptag-Group2").tag("@order-3").scenario(ScenarioBuilder.instance().name("Root").build()).build());
        section.addFeature(FeatureBuilder.instance().name("My Fifth Child").build());

        final String expectedDocument = "[SomeStyle]" + newLine() +
                "[[My-Section, My Section]]" + newLine() +
                "= *My Section*" + newLine() + newLine() + newLine() +
                "[[Group1, Group1]]" + newLine() +
                "== *Group1*" + newLine() + newLine() +
                "[[My-Second-Child, My Second Child]]" + newLine() +
                "=== *My Second Child*" + newLine() +
                newLine() +
                "[[My-First-Child, My First Child]]" + newLine() +
                "=== *My First Child*" + newLine() +
                newLine() +
                "[[My-Third-Child, My Third Child]]" + newLine() +
                "== *My Third Child*" + newLine() +
                newLine() +
                "[[My-Fourth-Child, My Fourth Child]]" + newLine() +
                "== *My Fourth Child*" + newLine() +
                newLine() +
                "[[My-Fifth-Child, My Fifth Child]]" + newLine() +
                "== *My Fifth Child*" + newLine() + newLine();

        final String result = section.render(CukedoctorDocumentBuilder.Factory.newInstance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals(expectedDocument, result);
    }

    @Test
    public void shouldStyle() {
        final BasicSection section = new BasicSection("My Section", "SomeStyle");
        section.addFeature(FeatureBuilder.instance().name("My First Child").build());
        section.addFeature(FeatureBuilder.instance().name("My Second Child").build());

        final String expectedDocument = "[SomeStyle]" + newLine() +
                "[[My-Section, My Section]]" + newLine() +
                "= *My Section*" + newLine() + newLine() + newLine() +
                "[[My-First-Child, My First Child]]" + newLine() +
                "== *My First Child*" + newLine() +
                newLine() +
                "[[My-Second-Child, My Second Child]]" + newLine() +
                "== *My Second Child*" + newLine() +
                newLine();

        final String result = section.render(CukedoctorDocumentBuilder.Factory.newInstance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals(expectedDocument, result);
    }

    @Test
    public void styleShouldBeOptional() {
        final BasicSection section = new BasicSection("My Section");
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

        final String result = section.render(CukedoctorDocumentBuilder.Factory.newInstance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals(expectedDocument, result);
    }

    @Test
    public void shouldRenderRootFeatureEvenIfThereAreNoChildFeatures() {
        final BasicSection section = createSection();

        section.addFeature(FeatureBuilder.instance().name("My Cool Section").description("This tells you all about my really cool section.").scenario(ScenarioBuilder.instance().name("Root").build()).build());

        final String expectedDocument = "[[My-Cool-Section, My Cool Section]]" + newLine() +
                "= *My Cool Section*" + newLine() + newLine() + newLine() +
                "This tells you all about my really cool section." + newLine() + newLine();

        final String result = section.render(CukedoctorDocumentBuilder.Factory.newInstance(), I18nLoader.instance(null), new DocumentAttributes());

        assertEquals(expectedDocument, result);
    }

    @Test
    public void shouldNotRenderIfSectionHasNoChildren() {
        final BasicSection section = createSection();

        final String result = section.render(CukedoctorDocumentBuilder.Factory.newInstance(), I18nLoader.instance(null), new DocumentAttributes());

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
        section.addFeature(FeatureBuilder.instance().tag("@order--13").tag("@grouptag-Group1").build());

        assertEquals(-13, section.getOrder());
    }

    @Test
    public void orderShouldRespectRoot() {
        final BasicSection section = createSection();

        section.addFeature(FeatureBuilder.instance().tag("@order-42").build());
        section.addFeature(FeatureBuilder.instance().tag("@order--13").scenario(ScenarioBuilder.instance().name("Root").build()).build());

        assertEquals(-13, section.getOrder());
    }


    @Test
    public void shouldGetNoFeaturesIfEmpty() {
        final BasicSection section = createSection();

        assertThat(section.getFeatures().collect(Collectors.toList()), empty());
    }

    @Test
    public void shouldGetFeaturesInOrder() {
        final Feature one = FeatureBuilder.instance().tag("@order-1").scenario(ScenarioBuilder.instance().name("Root").build()).build();
        final Feature two = FeatureBuilder.instance().tag("order-2").build();
        final Feature three = FeatureBuilder.instance().tag("order-3").tag("@group-one").scenario(ScenarioBuilder.instance().name("Root").build()).build();
        final Feature four = FeatureBuilder.instance().tag("order-4").tag("@group-one").build();
        final Feature five = FeatureBuilder.instance().tag("order-5").build();

        final BasicSection section = new BasicSection("My Section", null, "@group-");
        section.addFeatures(Arrays.asList(five, three, four, one, two));

        assertThat(section.getFeatures().collect(Collectors.toList()), contains(one, two, three, four, five));
    }


    private BasicSection createSection() {
        return new BasicSection("My Section");
    }
}
