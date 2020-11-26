package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.i18n.I18nLoader;

import static com.github.cukedoctor.sectionlayout.Constants.SubsectionTagPattern;

public class BuiltInFeaturesSection extends BasicSection {
    public BuiltInFeaturesSection() {
        super("Features", null, SubsectionTagPattern);
    }

    @Override
    protected boolean shouldRenderSectionName(CukedoctorConfig config) {
        return !config.isHideFeaturesSection();
    }

    @Override
    protected String getName(I18nLoader i18n) {
        return i18n.getMessage("title.features");
    }
}