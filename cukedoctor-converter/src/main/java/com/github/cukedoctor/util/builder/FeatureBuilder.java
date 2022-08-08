package com.github.cukedoctor.util.builder;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Tag;
import java.util.ArrayList;
import java.util.List;

/** Created by pestano on 04/06/15. */
public class FeatureBuilder {

  private final Feature feature;
  private static FeatureBuilder instance;

  private FeatureBuilder(Feature feature) {
    this.feature = feature;
  }

  private Feature getFeature() {
    return feature;
  }

  public static synchronized FeatureBuilder instance() {
    instance = new FeatureBuilder(new Feature());
    return instance;
  }

  public static synchronized FeatureBuilder instance(Feature feature) {
    instance = new FeatureBuilder(feature);
    return instance;
  }

  public FeatureBuilder id(String id) {
    feature.setId(id);
    return instance;
  }

  public FeatureBuilder name(String name) {
    feature.setName(name);
    return instance;
  }

  public FeatureBuilder uri(String uri) {
    feature.setUri(uri);
    return instance;
  }

  public FeatureBuilder description(String desc) {
    feature.setDescription(desc);
    return instance;
  }

  public FeatureBuilder scenario(Scenario scenario) {
    if (feature.getElements() == null) {
      feature.setElements(new ArrayList<>());
    }
    feature.getElements().add(scenario);
    return instance;
  }

  public FeatureBuilder keyword(String keyword) {
    feature.setKeyword(keyword);
    return instance;
  }

  public FeatureBuilder tag(String tag) {
    if (feature.hasTags()) {
      feature.getTags().add(new Tag(tag));
      return this;
    }

    List<Tag> tags = new ArrayList<>(1);
    tags.add(new Tag(tag));
    feature.setTags(tags);
    return this;
  }

  public Feature build() {
    feature.initScenarios();
    feature.processSteps();
    return instance.getFeature();
  }
}
