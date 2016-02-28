package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.renderer.BaseRenderer;

/**
 * Created by pestano on 24/02/16.
 */
public interface ScenarioRenderer extends BaseRenderer {

    String renderScenario(Scenario scenario, Feature feature);
}
