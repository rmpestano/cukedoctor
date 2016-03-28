package com.github.cukedoctor.spi;

import java.util.List;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.renderer.BaseRenderer;

/**
 * Created by pestano on 24/02/16.
 */
public interface SummaryRenderer extends BaseRenderer{

    String renderSummary(List<Feature> features);
}
