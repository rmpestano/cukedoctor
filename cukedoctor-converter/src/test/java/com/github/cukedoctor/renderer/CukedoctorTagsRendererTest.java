package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.spi.TagsRenderer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class CukedoctorTagsRendererTest {
    private TagsRenderer tagsRenderer = new CukedoctorTagsRenderer();

    @Test
    public void shouldNotRenderIfNeitherFeatureNorScenarioHasTags() {
        Assert.assertFalse("", tagsRenderer.shouldRenderScenarioTags(createEmptyFeature(), createEmptyScenario()));
    }


    @Test
    public void shouldRenderIfScenarioHasTags() {
        Assert.assertTrue(tagsRenderer.shouldRenderScenarioTags(createEmptyFeature(), createScenario("@someTag")));
    }

    @Test
    public void shouldRenderIfScenarioHasOrderAndNotOrderTags() {
        Assert.assertTrue(tagsRenderer.shouldRenderScenarioTags(createEmptyFeature(), createScenario("@someTag", "@order-42")));
    }

    @Test
    public void shouldNotRenderIfScenarioOnlyHasSingleOrderTagAndFeatureHasNoTags() {
        Assert.assertFalse(tagsRenderer.shouldRenderScenarioTags(createEmptyFeature(), createScenario("@order-42")));
    }

    @Test
    public void shouldNotRenderIfScenarioOnlyHasOrderTagsAndFeatureHasNoTags() {
        Assert.assertFalse(tagsRenderer.shouldRenderScenarioTags(createEmptyFeature(), createScenario("@order-42", "@order-1")));
    }


    @Test
    public void shouldRenderIfFeatureHasTagsButNotOrderTags() {
        Assert.assertTrue(tagsRenderer.shouldRenderScenarioTags(createFeature("@someTag"), createEmptyScenario()));
    }

    @Test
    public void shouldRenderIfFeatureHasOrderAndNotOrderTags() {
        Assert.assertTrue(tagsRenderer.shouldRenderScenarioTags(createFeature("@someTag", "@order-42"), createEmptyScenario()));
    }

    @Test
    public void shouldNotRenderIfFeatureOnlyHasSingleOrderTagAndScenarioHasNoTags() {
        Assert.assertFalse(tagsRenderer.shouldRenderScenarioTags(createFeature("@order-42"), createEmptyScenario()));
    }

    @Test
    public void shouldNotRenderIfFeatureOnlyHasOrderTagsAndScenarioHasNoTags() {
        Assert.assertFalse(tagsRenderer.shouldRenderScenarioTags(createFeature("@order-42", "@order-1"), createEmptyScenario()));
    }


    private Feature createFeature(String... names) {
        final Feature feature = new Feature();
        feature.setTags(createTags(names));
        return feature;
    }

    private Feature createEmptyFeature() {
        final Feature feature = new Feature();
        Assert.assertFalse("Feature unexpectedly has tags", feature.hasTags());
        return feature;
    }

    private Scenario createScenario(String... names) {
        final Scenario scenario = new Scenario();
        scenario.setTags(createTags(names));
        return scenario;
    }

    private Scenario createEmptyScenario() {
        final Scenario scenario = createScenario();
        Assert.assertFalse("Scenario unexpectedly has tags", scenario.hasTags());
        return scenario;
    }

    private List<Tag> createTags(String... names) {
        if (names != null && names.length != 0) {
            ArrayList<Tag> tags = new ArrayList<>(names.length);
            for (String name : names) {
                tags.add(new Tag(name));
            }

            return tags;
        }

        return new ArrayList<>(0);
    }
}
