package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.renderer.BaseRenderer;
import java.util.List;

/** Created by pestano on 28/02/16. */
public interface StepsRenderer extends BaseRenderer {

  /**
   * @param steps the steps to render
   * @param scenario scenario containing the steps
   * @param feature the feature containing the scenario
   * @return the renderer {@link String}
   * @deprecated Use renderSteps(List&lt;Step&gt;, Scenario, Feature, CukedoctorDocumentBuilder)
   *     instead
   */
  @Deprecated
  String renderSteps(List<Step> steps, Scenario scenario, Feature feature);

  default String renderSteps(
      List<Step> steps,
      Scenario scenario,
      Feature feature,
      CukedoctorDocumentBuilder documentBuilder) {
    setDocumentBuilder(documentBuilder);
    return renderSteps(steps, scenario, feature);
  }
}
