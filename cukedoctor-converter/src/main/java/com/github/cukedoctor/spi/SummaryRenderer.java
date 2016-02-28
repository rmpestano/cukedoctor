package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.ScenarioTotalizations;
import com.github.cukedoctor.renderer.BaseRenderer;

import java.util.List;

/**
 * Created by pestano on 24/02/16.
 */
public interface SummaryRenderer extends BaseRenderer{

    String renderSummary(List<Feature> features);
}
