package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.renderer.BaseRenderer;

/**
 * Created by pestano on 28/02/16.
 */
public interface ExamplesRenderer extends BaseRenderer {

    /**
     * @deprecated Use renderScenarioExamples(Scenario, CukedoctorDocumentBuilder) instead
     */
    @Deprecated
    String renderScenarioExamples(Scenario scenario);

    default String renderScenarioExamples(Scenario scenario, CukedoctorDocumentBuilder documentBuilder) {
        setDocumentBuilder(documentBuilder);
        return renderScenarioExamples(scenario);
    }
}
