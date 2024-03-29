package com.github.cukedoctor.renderer;

import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Assert.notNull;
import static com.github.cukedoctor.util.StringUtil.trimAllLines;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Status;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.spi.ExamplesRenderer;
import com.github.cukedoctor.spi.ScenarioRenderer;
import com.github.cukedoctor.spi.StepsRenderer;
import com.github.cukedoctor.spi.TagsRenderer;
import com.github.cukedoctor.util.ServiceLoaderUtil;
import java.util.List;

/** Created by pestano on 27/02/16. */
public class CukedoctorScenarioRenderer extends AbstractBaseRenderer implements ScenarioRenderer {

  TagsRenderer tagsRenderer;

  ExamplesRenderer examplesRenderer;

  StepsRenderer stepsRenderer;

  public CukedoctorScenarioRenderer() {}

  public CukedoctorScenarioRenderer(CukedoctorConfig cukedoctorConfig) {
    this.cukedoctorConfig = cukedoctorConfig;
  }

  private void loadDependentRenderers() {
    tagsRenderer =
        new ServiceLoaderUtil<TagsRenderer>()
            .initialise(
                TagsRenderer.class,
                CukedoctorTagsRenderer.class,
                i18n,
                documentAttributes,
                cukedoctorConfig);
    examplesRenderer =
        new ServiceLoaderUtil<ExamplesRenderer>()
            .initialise(
                ExamplesRenderer.class,
                CukedoctorExamplesRenderer.class,
                i18n,
                documentAttributes,
                cukedoctorConfig);
    stepsRenderer =
        new ServiceLoaderUtil<StepsRenderer>()
            .initialise(
                StepsRenderer.class,
                CukedoctorStepsRenderer.class,
                i18n,
                documentAttributes,
                cukedoctorConfig);
  }

  @Override
  public String renderScenario(Scenario scenario, Feature feature) {
    loadDependentRenderers();
    docBuilder.clear();
    if (scenario.hasIgnoreDocsTag()) {
      return "";
    }

    if (scenario.isBackground() && feature.isBackgroundRendered()) {
      return "";
    }

    if (!feature.isBackgroundRendered() && scenario.isBackground()) {
      feature.setBackgroundRendered(true);
      StringBuilder backgroundTitle = new StringBuilder(scenario.getKeyword());
      if (!Status.passed.equals(scenario.getStatus())) {
        backgroundTitle.append(" ").append(Status.getStatusIcon(Status.failed));
      }
      docBuilder.title(backgroundTitle.toString().replace("\\", ""));
    }

    if (hasText(scenario.getName())) {
      StringBuilder scenarioTitle = new StringBuilder();
      if (cukedoctorConfig.isHideScenarioKeyword()) {
        scenarioTitle.append(scenario.getName());
      } else {
        scenarioTitle.append(scenario.getKeyword()).append(": ").append(scenario.getName());
      }

      if (notNull(scenario.getStatus()) && !Status.passed.equals(scenario.getStatus())) {
        scenarioTitle.append(" ").append(Status.getStatusIcon(Status.failed));
      }

      docBuilder.title(scenarioTitle.toString());
    }

    if (!cukedoctorConfig.isHideTags()) {
      docBuilder.append(renderScenarioTags(scenario, feature));
    }

    if (hasText(scenario.getDescription())) {
      docBuilder.textLine(trimAllLines(scenario.getDescription()).replace("\\", "")).newLine();
    } else {
      docBuilder.textLine("").newLine();
    }

    if (scenario.hasExamples()) {
      docBuilder.append(renderScenarioExamples(scenario));
      return docBuilder.toString(); // or a scenario has examples or it has steps
    }

    if (scenario.hasSteps()) {
      docBuilder.append(renderScenarioSteps(scenario.getSteps(), scenario, feature));
    }
    return docBuilder.toString();
  }

  private String renderScenarioSteps(List<Step> scenarioSteps, Scenario scenario, Feature feature) {
    return stepsRenderer.renderSteps(
        scenarioSteps, scenario, feature, docBuilder.createNestedBuilder());
  }

  private String renderScenarioExamples(Scenario scenario) {
    return examplesRenderer.renderScenarioExamples(scenario, docBuilder.createNestedBuilder());
  }

  private String renderScenarioTags(Scenario scenario, Feature feature) {
    return tagsRenderer.renderScenarioTags(feature, scenario, docBuilder.createPeerBuilder());
  }
}
