package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.renderer.CukedoctorFeatureRenderer;
import com.github.cukedoctor.spi.FeatureRenderer;
import com.github.cukedoctor.util.ServiceLoaderUtil;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class FeatureSection implements Section {
    private static Supplier<FeatureRenderer> featureRenderer;

    static {
        featureRenderer = () -> {
            FeatureRenderer val = new ServiceLoaderUtil<FeatureRenderer>().load(FeatureRenderer.class, CukedoctorFeatureRenderer.class, SectionFeatureRenderer.class);
            featureRenderer = () -> val;
            return val;
        };
    }

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
        final FeatureRenderer renderer = FeatureSection.featureRenderer.get();
        renderer.setI18n(i18n);
        renderer.setDocumentAttributes(documentAttributes);
        return renderer.renderFeature(feature, docBuilder);
    }

    @Override
    public int getOrder() {
        return feature.getOrder();
    }

    @Override
    public Stream<Feature> getFeatures() {
        return Stream.of(feature);
    }
}
