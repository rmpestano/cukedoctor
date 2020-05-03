package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static com.github.cukedoctor.sectionlayout.Constants.*;

public class DocumentSection implements Section {

    private final BuiltInFeaturesSection featuresSection = new BuiltInFeaturesSection() {
        @Override
        public int getOrder() {
            return 2;
        }
    };
    private final Multimap<String, Feature> featuresBySectionId = LinkedListMultimap.create();
    private final Set<String> appendixIds = new HashSet<>();

    public DocumentSection() {
    }

    public DocumentSection(Iterable<Feature> features) {
        for (Feature feature : features) {
            addFeature(feature);
        }
    }

    @Override
    public Section addFeature(Feature feature) {
        if (feature.hasIgnoreDocsTag()) return this;

        Optional<String> sectionId = feature.extractTag(SectionTagPattern);

        if (!sectionId.isPresent()) {
            featuresSection.addFeature(feature);
            return this;
        }

        featuresBySectionId.put(sectionId.get(), feature);

        if (feature.hasTag(AppendixTagPattern)) {
            appendixIds.add(sectionId.get());
        }

        return this;
    }

    @Override
    public String render(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        AnonymousSection document = buildDocument();
        docBuilder.append(document.render(docBuilder.createPeerBuilder(), i18n, documentAttributes));
        return docBuilder.toString();
    }

    protected AnonymousSection buildDocument() {
        AnonymousSection foreSections = new AnonymousSection() {
            @Override
            public int getOrder() {
                return 1;
            }
        };
        AnonymousSection appendices = new AnonymousSection() {
            @Override
            public int getOrder() {
                return 3;
            }
        };

        featuresBySectionId.asMap().forEach((String sectionId, Collection<Feature> features) -> {
            if (appendixIds.contains(sectionId)) {
                appendices.addSection(new BasicSection(sectionId, "appendix", SubsectionTagPattern).addFeatures(features));
                return;
            }

            foreSections.addSection(new BasicSection(sectionId, null, SubsectionTagPattern).addFeatures(features));
        });

        return new AnonymousSection().addSection(foreSections).addSection(featuresSection).addSection(appendices);
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }

}
