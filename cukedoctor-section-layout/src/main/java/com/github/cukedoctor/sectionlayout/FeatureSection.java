package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.renderer.CukedoctorFeatureRenderer;

public class FeatureSection implements Section {
    private final CukedoctorFeatureRenderer featureRenderer = new CukedoctorFeatureRenderer();
    private final Feature feature;

    public FeatureSection(Feature feature) {
        this.feature = feature;
    }

    @Override
    public Section addFeature(Feature feature) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String render(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        featureRenderer.setDocumentAttributes(documentAttributes);
        featureRenderer.setDocumentBuilder(docBuilder);
        featureRenderer.setI18n(i18n);
        return featureRenderer.renderFeature(feature);
    }

    @Override
    public int getOrder() {
        return feature.getOrder();
    }
}
