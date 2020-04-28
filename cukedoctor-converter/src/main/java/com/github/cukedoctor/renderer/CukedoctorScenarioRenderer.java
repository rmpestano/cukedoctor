package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Status;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.spi.ExamplesRenderer;
import com.github.cukedoctor.spi.ScenarioRenderer;
import com.github.cukedoctor.spi.StepsRenderer;
import com.github.cukedoctor.spi.TagsRenderer;

import java.util.List;
import java.util.ServiceLoader;

import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Assert.notNull;
import static com.github.cukedoctor.util.StringUtil.trimAllLines;

/**
 * Created by pestano on 27/02/16.
 */
public class CukedoctorScenarioRenderer extends AbstractBaseRenderer implements ScenarioRenderer {


    TagsRenderer tagsRenderer;

    ExamplesRenderer examplesRenderer;

    StepsRenderer stepsRenderer;


    public CukedoctorScenarioRenderer() {
        loadDependentRenderers();
    }

    public CukedoctorScenarioRenderer(CukedoctorConfig cukedoctorConfig) {
        this.cukedoctorConfig = cukedoctorConfig;
        loadDependentRenderers();
    }

    private void loadDependentRenderers() {
        ServiceLoader<TagsRenderer> tagsRenderers = ServiceLoader.load(TagsRenderer.class);
        ServiceLoader<ExamplesRenderer> examplesRenderers = ServiceLoader.load(ExamplesRenderer.class);
        ServiceLoader<StepsRenderer> stepsRenderers = ServiceLoader.load(StepsRenderer.class);

        if (tagsRenderers.iterator().hasNext()) {
            tagsRenderer = tagsRenderers.iterator().next();
        } else {
            tagsRenderer = new CukedoctorTagsRenderer();
            tagsRenderer.setI18n(i18n);
        }

        if (examplesRenderers.iterator().hasNext()) {
            examplesRenderer = examplesRenderers.iterator().next();
        } else {
            examplesRenderer = new CukedoctorExamplesRenderer();
            examplesRenderer.setI18n(i18n);
        }

        if (stepsRenderers.iterator().hasNext()) {
            stepsRenderer = stepsRenderers.iterator().next();
        } else {
            stepsRenderer = new CukedoctorStepsRenderer();
            stepsRenderer.setI18n(i18n);
        }
    }

    @Override
    public String renderScenario(Scenario scenario, Feature feature) {
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
                backgroundTitle.append(" " + Status.getStatusIcon(Status.failed));
            }
            docBuilder.title(backgroundTitle.toString().replaceAll("\\\\", ""));
        }

        if (hasText(scenario.getName())) {
            StringBuilder scenarioTitle = new StringBuilder();
            if (cukedoctorConfig.isHideScenarioKeyword()) {
                scenarioTitle.append(scenario.getName());
            } else {
                scenarioTitle.append(scenario.getKeyword()).append(": ").append(scenario.getName());
            }

            if (notNull(scenario.getStatus()) && !Status.passed.equals(scenario.getStatus())) {
                scenarioTitle.append(" " + Status.getStatusIcon(Status.failed));
            }

            docBuilder.title(scenarioTitle.toString());
        }

        if (!cukedoctorConfig.isHideTags()) {
            docBuilder.append(renderScenarioTags(scenario, feature));
        }

        if (hasText(scenario.getDescription())) {
            docBuilder.textLine(trimAllLines(scenario.getDescription()).replaceAll("\\\\", "")).newLine();
        } else {
            docBuilder.textLine("").newLine();
        }

        if (scenario.hasExamples()) {
            docBuilder.append(renderScenarioExamples(scenario));
            return docBuilder.toString();//or a scenario has examples or it has steps
        }

        if (scenario.hasSteps()) {
            docBuilder.append(renderScenarioSteps(scenario.getSteps(), scenario, feature));
        }
        return docBuilder.toString();
    }

    String renderScenarioSteps(List<Step> scenarioSteps, Scenario scenario, Feature feature) {
        stepsRenderer.setDocumentBuilder(docBuilder.createNestedBuilder());
        return stepsRenderer.renderSteps(scenarioSteps, scenario, feature);
    }

    String renderScenarioExamples(Scenario scenario) {
        examplesRenderer.setDocumentBuilder(docBuilder.createNestedBuilder());
        return examplesRenderer.renderScenarioExamples(scenario);
    }

    String renderScenarioTags(Scenario scenario, Feature feature) {
        tagsRenderer.setDocumentBuilder(docBuilder.createPeerBuilder());
        return tagsRenderer.renderScenarioTags(feature, scenario);
    }


}
