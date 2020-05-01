package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;

import java.util.Optional;

import static com.github.cukedoctor.sectionlayout.Constants.AppendixTagPattern;
import static com.github.cukedoctor.sectionlayout.Constants.SectionTagPattern;

public class DocumentSection implements Section {
    private final MapSection foreSections = new MapSection() {
        @Override
        protected String getSectionId(Feature feature) {
            return feature.extractTag(SectionTagPattern).get();
        }

        @Override
        protected Section createChildSection(String sectionId) {
            return new NamedSection(sectionId);
        }
    };
    private final BuiltInFeaturesSection featuresSection = new BuiltInFeaturesSection();
    private final MapSection appendices = new MapSection() {
        @Override
        protected String getSectionId(Feature feature) {
            return feature.extractTag(SectionTagPattern).get();
        }

        @Override
        protected Section createChildSection(String sectionId) {
            return new StyledSection(sectionId, "appendix");
        }
    };

    public DocumentSection() {
    }

    public DocumentSection(Iterable<Feature> features) {
        for (Feature feature : features) {
            addFeature(feature);
        }
    }

    @Override
    public void addFeature(Feature feature) {
        if (feature.hasIgnoreDocsTag()) return;

        Optional<String> sectionId = feature.extractTag(SectionTagPattern);

        if (!sectionId.isPresent()) {
            featuresSection.addFeature(feature);
            return;
        }

        if (feature.hasTag(AppendixTagPattern)) {
            appendices.addFeature(feature);
            return;
        }

        foreSections.addFeature(feature);
    }

    @Override
    public String render(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        docBuilder.append(foreSections.render(docBuilder.createPeerBuilder(), i18n, documentAttributes));
        docBuilder.append(featuresSection.render(docBuilder.createPeerBuilder(), i18n, documentAttributes));
        docBuilder.append(appendices.render(docBuilder.createPeerBuilder(), i18n, documentAttributes));
        return docBuilder.toString();
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }

}
