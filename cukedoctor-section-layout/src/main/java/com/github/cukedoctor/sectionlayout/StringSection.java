package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;

public class StringSection implements Section {
    private final String message;

    public StringSection(String message) {
        this.message = message;
    }

    @Override
    public void addFeature(Feature feature) {
    }

    @Override
    public String render(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        return message;
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}
