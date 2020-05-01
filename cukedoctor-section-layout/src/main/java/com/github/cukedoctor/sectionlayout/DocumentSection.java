package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.i18n.I18nLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.github.cukedoctor.sectionlayout.Constants.SectionTagPattern;

public class DocumentSection implements Section {
    private final Map<String, Section> foreSectionsById = new HashMap<>();
    private final BuiltInFeaturesSection featuresSection = new BuiltInFeaturesSection();

    public DocumentSection() {}

    public DocumentSection(Iterable<Feature> features) {
        for (Feature feature : features) {
            addFeature(feature);
        }
    }

    @Override
    public void addFeature(Feature feature) {
        if (feature.hasIgnoreDocsTag()) return;

        String sectionId = getSectionId(feature);

        if (sectionId == null || sectionId.isEmpty()) {
            featuresSection.addFeature(feature);
            return;
        }

        if (foreSectionsById.containsKey(sectionId)) {
            foreSectionsById.get(sectionId).addFeature(feature);
            return;
        }

        final NamedSection section = new NamedSection(sectionId);
        section.addFeature(feature);
        foreSectionsById.put(sectionId, section);
    }

    private String getSectionId(Feature feature) {
        String id = null;
        if (feature.hasTags()) {
            for (Tag tag : feature.getTags()) {
                String candidateName = tag.extractPattern(SectionTagPattern);
                if (candidateName != null) {
                    id = candidateName;
                    break;
                }
            }
        }
        return id;
    }

    @Override
    public String render(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        renderForeSections(docBuilder, i18n, documentAttributes);
        docBuilder.append(featuresSection.render(docBuilder.createPeerBuilder(), i18n, documentAttributes));
        return docBuilder.toString();
    }

    private void renderForeSections(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        ArrayList<Section> foreSections = new ArrayList<>(foreSectionsById.values());
        Collections.sort(foreSections);

        for (Section section : foreSections) {
            docBuilder.append(section.render(docBuilder.createPeerBuilder(), i18n, documentAttributes));
        }
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
