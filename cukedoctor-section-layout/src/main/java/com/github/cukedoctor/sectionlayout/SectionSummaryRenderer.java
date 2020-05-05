package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.renderer.AbstractBaseRenderer;
import com.github.cukedoctor.renderer.CukedoctorSummaryRenderer;
import com.github.cukedoctor.spi.SummaryRenderer;
import com.github.cukedoctor.util.ServiceLoaderUtil;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Supplier;

public class SectionSummaryRenderer extends AbstractBaseRenderer implements SummaryRenderer {

    private final ServiceLoaderUtil<SummaryRenderer> loader;
    private Supplier<SummaryRenderer> renderer;

    public SectionSummaryRenderer() {
        this(new ServiceLoaderUtil<>());
    }

    public SectionSummaryRenderer(ServiceLoaderUtil<SummaryRenderer> loader) {
        this.loader = loader;

        renderer = () -> {
            SummaryRenderer val = loader.initialise(SummaryRenderer.class, CukedoctorSummaryRenderer.class, i18n, documentAttributes, SectionSummaryRenderer.class);
            renderer = () -> val;
            return val;
        };
    }

    @Override
    public String renderSummary(List<Feature> features) {
        docBuilder.append(renderer.get().renderSummary(Lists.newArrayList(new DocumentSection(features).getFeatures()), docBuilder));
        return docBuilder.toString();
    }

    @Override
    public void setI18n(I18nLoader i18n) {
        super.setI18n(i18n);
        renderer.get().setI18n(i18n);
    }

    @Override
    public void setDocumentBuilder(CukedoctorDocumentBuilder documentBuilder) {
        super.setDocumentBuilder(documentBuilder);
        renderer.get().setDocumentBuilder(documentBuilder);
    }

    @Override
    public void setDocumentAttributes(DocumentAttributes documentAttributes) {
        super.setDocumentAttributes(documentAttributes);
        renderer.get().setDocumentAttributes(documentAttributes);
    }
}