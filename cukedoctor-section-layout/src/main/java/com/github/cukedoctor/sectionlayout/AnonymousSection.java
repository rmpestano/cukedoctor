package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;

public class AnonymousSection extends BasicSection {
    public AnonymousSection addSection(Section section) {
        children.add(section);
        return this;
    }

    @Override
    protected Section createChildSection(Feature feature) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected String getDefaultSectionName(I18nLoader i18n) {
        throw new UnsupportedOperationException();
    }
}