package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.spi.FeatureRenderer;

import java.util.List;

public class SectionFeatureRenderer implements FeatureRenderer {
    private CukedoctorDocumentBuilder documentBuilder = CukedoctorDocumentBuilder.Factory.newInstance();
    private I18nLoader i18nProvider = I18nLoader.instance(null);
    private DocumentAttributes documentAttributes;

    @Override
    public String renderFeature(Feature feature) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String renderFeatures(List<Feature> features) {
        documentBuilder.clear();
        new DocumentSection(features).render(documentBuilder, i18nProvider, documentAttributes);
        return documentBuilder.toString();
    }

    @Override
    public void setI18n(I18nLoader i18nProvider) {
        this.i18nProvider = i18nProvider;
    }

    @Override
    public void setDocumentBuilder(CukedoctorDocumentBuilder documentBuilder) {
        this.documentBuilder = documentBuilder;
    }

    @Override
    public void setDocumentAttributes(DocumentAttributes documentAttributes) {
        this.documentAttributes = documentAttributes;
    }
}