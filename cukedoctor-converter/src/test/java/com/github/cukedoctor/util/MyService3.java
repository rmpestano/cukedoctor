package com.github.cukedoctor.util;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.renderer.AbstractBaseRenderer;
import com.github.cukedoctor.renderer.BaseRenderer;

public class MyService3 extends AbstractBaseRenderer implements BaseRenderer {
    private I18nLoader i18nProvider;
    private DocumentAttributes documentAttributes;

    public MyService3(int v) {
    }

    public I18nLoader getI18nProvider() {
        return i18nProvider;
    }

    public DocumentAttributes getDocumentAttributes() {
        return documentAttributes;
    }

    @Override
    public void setDocumentAttributes(DocumentAttributes documentAttributes) {

        this.documentAttributes = documentAttributes;
    }

    @Override
    public void setI18n(I18nLoader i18nProvider) {

        this.i18nProvider = i18nProvider;
    }

    @Override
    public void setDocumentBuilder(CukedoctorDocumentBuilder documentBuilder) {

    }
}
