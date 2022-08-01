package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.renderer.BaseRenderer;

/** Created by pestano on 28/02/16. */
public interface TagsRenderer extends BaseRenderer {

  /**
   * @param feature the feature containing the tags
   * @param scenario the scenario containing the tags
   * @return the rendered {@link String}
   * @deprecated Use renderScenarioTags(Scenario, CukedoctorDocumentBuilder) instead
   */
  @Deprecated(forRemoval = true)
  String renderScenarioTags(Feature feature, Scenario scenario);

  default String renderScenarioTags(
      Feature feature, Scenario scenario, CukedoctorDocumentBuilder documentBuilder) {
    setDocumentBuilder(documentBuilder);
    return renderScenarioTags(feature, scenario);
  }
}
