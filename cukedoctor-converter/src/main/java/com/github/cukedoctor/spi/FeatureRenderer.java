package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.renderer.BaseRenderer;
import java.util.List;

/** Created by pestano on 24/02/16. */
public interface FeatureRenderer extends BaseRenderer {

  /**
   * @param feature the feature to render
   * @return the rendered {@link String}
   * @deprecated Use renderFeature(Feature, CukedoctorDocumentBuilder) instead
   */
  @Deprecated(forRemoval = true)
  String renderFeature(Feature feature);

  default String renderFeature(Feature feature, CukedoctorDocumentBuilder documentBuilder) {
    setDocumentBuilder(documentBuilder);
    return renderFeature(feature);
  }

  /**
   * @param features the features to render
   * @return the rendered {@link String}
   * @deprecated Use renderFeatures(List&lt;Feature&gt;, CukedoctorDocumentBuilder) instead
   */
  @Deprecated(forRemoval = true)
  String renderFeatures(List<Feature> features);

  default String renderFeatures(List<Feature> features, CukedoctorDocumentBuilder documentBuilder) {
    setDocumentBuilder(documentBuilder);
    return renderFeatures(features);
  }
}
