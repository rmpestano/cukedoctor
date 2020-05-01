package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class MapSection implements Section {
    private final Map<String, Section> map = new HashMap<>();
    private Section voidSection = new BasicSection() {
        @Override
        protected Section createChildSection(Feature feature) {
            return new FeatureSection(feature);
        }

        @Override
        protected String getDefaultSectionName(I18nLoader i18n) {
            return null;
        }

        @Override
        protected boolean shouldRenderSectionName() {
            return false;
        }
    };

    @Override
    public void addFeature(Feature feature) {
        String sectionId = getSectionId(feature);

        if (sectionId == null || sectionId.isEmpty()) {
            voidSection.addFeature(feature);
            return;
        }


        if (map.containsKey(sectionId)) {
            map.get(sectionId).addFeature(feature);
            return;
        }

        final Section section = createChildSection(sectionId);
        section.addFeature(feature);
        map.put(sectionId, section);
    }

    protected abstract String getSectionId(Feature feature);

    protected abstract Section createChildSection(String sectionId);

    @Override
    public String render(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        renderChildren(docBuilder, i18n, documentAttributes);
        docBuilder.append(voidSection.render(docBuilder.createPeerBuilder(), i18n, documentAttributes));
        return docBuilder.toString();
    }

    protected void renderChildren(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        ArrayList<Section> children = new ArrayList<>(map.values());
        Collections.sort(children);

        for (Section child : children) {
            docBuilder.append(child.render(docBuilder.createPeerBuilder(), i18n, documentAttributes));
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
