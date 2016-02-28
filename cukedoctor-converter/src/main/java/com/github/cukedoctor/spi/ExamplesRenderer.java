package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.renderer.BaseRenderer;

/**
 * Created by pestano on 28/02/16.
 */
public interface ExamplesRenderer extends BaseRenderer {

    String renderScenarioExamples(Scenario scenario);
}
