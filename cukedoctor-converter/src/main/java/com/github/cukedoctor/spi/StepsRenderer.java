package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.renderer.BaseRenderer;

import java.util.List;

/**
 * Created by pestano on 28/02/16.
 */
public interface StepsRenderer extends BaseRenderer{

    String renderSteps(List<Step> steps);
}
