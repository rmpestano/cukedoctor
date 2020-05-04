package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.renderer.CukedoctorFeatureRenderer;
import com.github.cukedoctor.spi.FeatureRenderer;
import com.github.cukedoctor.util.ServiceLoaderUtil;

public class FeatureSection implements Section {
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
        final FeatureRenderer featureRenderer = new ServiceLoaderUtil<FeatureRenderer>().initialise(FeatureRenderer.class, CukedoctorFeatureRenderer.class, i18n, documentAttributes, SectionFeatureRenderer.class);
        return featureRenderer.renderFeature(feature, docBuilder);
    }

    @Override
    public int getOrder() {
        return feature.getOrder();
    }
}
