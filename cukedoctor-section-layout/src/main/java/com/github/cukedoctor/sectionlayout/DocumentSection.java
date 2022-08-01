package com.github.cukedoctor.sectionlayout;

import static com.github.cukedoctor.sectionlayout.Constants.AppendixTagPattern;
import static com.github.cukedoctor.sectionlayout.Constants.BibliographyTagPattern;
import static com.github.cukedoctor.sectionlayout.Constants.GlossaryTagPattern;
import static com.github.cukedoctor.sectionlayout.Constants.IndexTagPattern;
import static com.github.cukedoctor.sectionlayout.Constants.SectionTagPattern;
import static com.github.cukedoctor.sectionlayout.Constants.SubsectionTagPattern;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class DocumentSection implements Section {

  private final BuiltInFeaturesSection featuresSection =
      new BuiltInFeaturesSection() {
        @Override
        public int getOrder() {
          return 2;
        }
      };
  private final Map<String, Collection<Feature>> featuresBySectionId = new HashMap<>();
  private final Section glossary = new BasicSection("Glossary", "glossary", null);
  private final Section bibliography = new BasicSection("Bibliography", "bibliography", null);
  private final Section index = new BasicSection("Index", "index", null);
  private final Set<String> appendixIds = new HashSet<>();

  public DocumentSection() {}

  public DocumentSection(Iterable<Feature> features) {
    for (Feature feature : features) {
      addFeature(feature);
    }
  }

  @Override
  public Section addFeature(Feature feature) {
    if (feature.hasIgnoreDocsTag()) return this;

    if (isGlossary(feature)) {
      glossary.addFeature(feature);
      return this;
    }

    if (isBibliography(feature)) {
      bibliography.addFeature(feature);
      return this;
    }

    if (isIndex(feature)) {
      index.addFeature(feature);
      return this;
    }

    Optional<String> sectionId = feature.extractTag(SectionTagPattern);
    if (sectionId.isEmpty()) {
      featuresSection.addFeature(feature);
      return this;
    }

    addFeatureForSection(feature, sectionId.get());
    if (feature.hasTag(AppendixTagPattern)) {
      appendixIds.add(sectionId.get());
    }

    return this;
  }

  private boolean isGlossary(Feature feature) {
    return feature.hasTag(GlossaryTagPattern);
  }

  private boolean isBibliography(Feature feature) {
    return feature.hasTag(BibliographyTagPattern);
  }

  private boolean isIndex(Feature feature) {
    return feature.hasTag(IndexTagPattern);
  }

  private void addFeatureForSection(Feature feature, String sectionId) {
    if (featuresBySectionId.containsKey(sectionId)) {
      featuresBySectionId.get(sectionId).add(feature);
      return;
    }

    List<Feature> features = new LinkedList<>();
    features.add(feature);
    featuresBySectionId.put(sectionId, features);
  }

  @Override
  public String render(
      CukedoctorDocumentBuilder docBuilder,
      I18nLoader i18n,
      DocumentAttributes documentAttributes,
      CukedoctorConfig config) {
    buildDocument()
        .forEach(
            section ->
                docBuilder.append(
                    section.render(
                        docBuilder.createPeerBuilder(), i18n, documentAttributes, config)));
    return docBuilder.toString();
  }

  private Stream<Section> buildDocument() {
    List<Section> foreSections = new LinkedList<>();
    List<Section> appendices = new LinkedList<>();

    featuresBySectionId.forEach(
        (String sectionId, Collection<Feature> features) -> {
          if (appendixIds.contains(sectionId)) {
            appendices.add(
                new BasicSection(sectionId, "appendix", SubsectionTagPattern)
                    .addFeatures(features));
            return;
          }

          foreSections.add(
              new BasicSection(sectionId, null, SubsectionTagPattern).addFeatures(features));
        });

    return Stream.concat(
        foreSections.stream().sorted(),
        Stream.concat(
            Stream.of(featuresSection),
            Stream.concat(
                appendices.stream().sorted(),
                Stream.concat(
                    Stream.of(glossary),
                    Stream.concat(Stream.of(bibliography), Stream.of(index))))));
  }

  @Override
  public int getOrder() {
    return Integer.MAX_VALUE;
  }

  @Override
  public Stream<Feature> getFeatures() {
    return buildDocument().flatMap(Section::getFeatures);
  }
}
