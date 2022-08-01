package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.renderer.BaseRenderer;
import java.util.List;

/** Created by pestano on 24/02/16. */
public interface SummaryRenderer extends BaseRenderer {

  /**
   * @param features the features to render
   * @return the rendered {@link String}
   * @deprecated Use renderSummary(List&lt;Feature&gt;, CukedoctorDocumentBuilder) instead
   */
  @Deprecated(forRemoval = true)
  String renderSummary(List<Feature> features);

  default String renderSummary(List<Feature> features, CukedoctorDocumentBuilder documentBuilder) {
    setDocumentBuilder(documentBuilder);
    return renderSummary(features);
  }
}
