package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.renderer.BaseRenderer;

import java.util.List;

/**
 * Created by pestano on 24/02/16.
 */
public interface SummaryRenderer extends BaseRenderer{

    /**
     * @deprecated Use renderSummary(List&lt;Feature&gt;, CukedoctorDocumentBuilder) instead
     */
    @Deprecated
    String renderSummary(List<Feature> features);

    default String renderSummary(List<Feature> features, CukedoctorDocumentBuilder documentBuilder) {
        setDocumentBuilder(documentBuilder);
        return renderSummary(features);
    }
}
