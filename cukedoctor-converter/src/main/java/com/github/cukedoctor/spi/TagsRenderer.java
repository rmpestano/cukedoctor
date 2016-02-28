package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.renderer.BaseRenderer;

/**
 * Created by pestano on 28/02/16.
 */
public interface TagsRenderer extends BaseRenderer {

    String renderScenarioTags(Feature feature, Scenario scenario);
}
