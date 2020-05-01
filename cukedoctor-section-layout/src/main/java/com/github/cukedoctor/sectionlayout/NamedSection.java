package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;

public class NamedSection extends BasicSection {
    private final String id;

    public NamedSection(String id) {
        super();
        this.id = id;
    }

    @Override
    protected Section createChildSection(Feature feature) {
        return new FeatureSection(feature);
    }

    @Override
    protected boolean shouldRenderSectionName() {
        return true;
    }

    @Override
    protected String getDefaultSectionName(I18nLoader i18n) {
        return id;
    }
}
