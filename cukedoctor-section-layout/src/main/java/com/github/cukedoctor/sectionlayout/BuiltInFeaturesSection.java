package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.i18n.I18nLoader;

public class BuiltInFeaturesSection extends BasicSection {
    private final CukedoctorConfig config = new CukedoctorConfig();

    @Override
    protected Section createChildSection(Feature feature) {
        return new FeatureSection(feature);
    }

    @Override
    protected boolean shouldRenderSectionName() {
        return !config.isHideFeaturesSection();
    }

    @Override
    protected String getDefaultSectionName(I18nLoader i18n) {
        return i18n.getMessage("title.features");
    }
}