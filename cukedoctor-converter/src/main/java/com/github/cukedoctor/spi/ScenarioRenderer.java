package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.renderer.BaseRenderer;

/** Created by pestano on 24/02/16. */
public interface ScenarioRenderer extends BaseRenderer {

  /**
   * @param scenario scenario to render
   * @param feature the feature containing the scenario
   * @return the renderer scenario
   * @deprecated Use renderScenario(Scenario, Feature, CukedoctorDocumentBuilder) instead
   */
  @Deprecated
  String renderScenario(Scenario scenario, Feature feature);

  default String renderScenario(
      Scenario scenario, Feature feature, CukedoctorDocumentBuilder documentBuilder) {
    setDocumentBuilder(documentBuilder);
    return renderScenario(scenario, feature);
  }
}
