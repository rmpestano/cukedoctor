package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.renderer.BaseRenderer;

import java.util.List;

/**
 * Created by pestano on 24/02/16.
 */
public interface FeatureRenderer extends BaseRenderer {

    /**
     * @deprecated Use renderFeature(Feature, CukedoctorDocumentBuilder) instead
     */
    @Deprecated
    String renderFeature(Feature feature);

    default String renderFeature(Feature feature, CukedoctorDocumentBuilder documentBuilder) {
        setDocumentBuilder(documentBuilder);
        return renderFeature(feature);
    }


    /**
     * @deprecated Use renderFeatures(List&lt;Feature&gt;, CukedoctorDocumentBuilder) instead
     */
    @Deprecated
    String renderFeatures(List<Feature> features);

    default String renderFeatures(List<Feature> features, CukedoctorDocumentBuilder documentBuilder) {
        setDocumentBuilder(documentBuilder);
        return renderFeatures(features);
    }
}
