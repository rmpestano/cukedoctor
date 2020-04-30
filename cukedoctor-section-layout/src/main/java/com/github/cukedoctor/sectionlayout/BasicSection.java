package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.util.builder.FeatureBuilder;

import java.util.ArrayList;
import java.util.Collections;

public abstract class BasicSection implements Section {
    private final ArrayList<Section> children = new ArrayList<>();
    private int order = Integer.MAX_VALUE;

    @Override
    public void addFeature(Feature feature) {
        final Section childSection = createChildSection(feature);
        children.add(childSection);
        order = Math.min(order, childSection.getOrder());
    }

    protected abstract Section createChildSection(Feature feature);

    @Override
    public String render(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        if (children.isEmpty()) return "";

        if (shouldRenderSectionName()) {
            renderSectionName(docBuilder, i18n, documentAttributes);
        }

        renderChildren(docBuilder, i18n, documentAttributes);

        return docBuilder.toString();
    }

    protected abstract boolean shouldRenderSectionName();

    private void renderSectionName(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        final String sectionName = getSectionName(i18n);
        final FeatureSection titleSection = new FeatureSection(FeatureBuilder.instance().name(sectionName).build());
        docBuilder.append(titleSection.render(docBuilder.createPeerBuilder(), i18n, documentAttributes)).nestTitle();
    }

    protected abstract String getSectionName(I18nLoader i18n);

    private void renderChildren(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        Collections.sort(children);
        for (Section child : children) {
            docBuilder.append(child.render(docBuilder.createPeerBuilder(), i18n, documentAttributes));
        }
    }

    @Override
    public int getOrder() {
        return order;
    }
}
