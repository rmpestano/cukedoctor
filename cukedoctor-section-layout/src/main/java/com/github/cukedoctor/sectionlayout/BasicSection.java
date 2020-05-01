package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.util.builder.FeatureBuilder;

import java.util.ArrayList;
import java.util.Collections;

public abstract class BasicSection implements Section {
    private final ArrayList<Section> children = new ArrayList<>();
    private Section root;
    private int order = Integer.MAX_VALUE;

    @Override
    public void addFeature(Feature feature) {
        if (hadRootScenario(feature)) {
            root = new FeatureSection(feature);
            return;
        }

        final Section childSection = createChildSection(feature);
        children.add(childSection);
        order = Math.min(order, childSection.getOrder());
    }

    private boolean hadRootScenario(Feature feature) {
        if (!feature.hasScenarios()) return false;

        for (Scenario scenario : feature.getScenarios()) {
            if (scenario.getName().equals("Root")) {
                feature.getScenarios().remove(scenario);
                return true;
            }
        }

        return false;
    }

    protected abstract Section createChildSection(Feature feature);

    @Override
    public String render(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        if (!hasRoot() && children.isEmpty()) return "";

        if (shouldRenderSectionName()) {
            renderSectionName(docBuilder, i18n, documentAttributes);
        }

        renderChildren(docBuilder, i18n, documentAttributes);

        return docBuilder.toString();
    }

    protected boolean shouldRenderSectionName() {
        return hasRoot();
    }

    private boolean hasRoot() {
        return root != null;
    }

    private void renderSectionName(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        Section titleSection = getTitleSection(i18n);
        docBuilder.append(titleSection.render(docBuilder.createPeerBuilder(), i18n, documentAttributes)).nestTitle();
    }

    private Section getTitleSection(I18nLoader i18n) {
        if (!hasRoot()) {
            final String sectionName = getDefaultSectionName(i18n);
            return new FeatureSection(FeatureBuilder.instance().name(sectionName).build());
        }

        return root;
    }

    protected abstract String getDefaultSectionName(I18nLoader i18n);

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
