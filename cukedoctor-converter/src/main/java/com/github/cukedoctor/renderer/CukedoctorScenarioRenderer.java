package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Row;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.spi.ExamplesRenderer;
import com.github.cukedoctor.spi.ScenarioRenderer;
import com.github.cukedoctor.spi.StepsRenderer;
import com.github.cukedoctor.spi.TagsRenderer;

import java.util.ServiceLoader;

import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Assert.notEmpty;
import static com.github.cukedoctor.util.Constants.Markup.table;
import static com.github.cukedoctor.util.Constants.Markup.tableCol;

/**
 * Created by pestano on 27/02/16.
 */
public class CukedoctorScenarioRenderer extends AbstractBaseRenderer implements ScenarioRenderer {


    TagsRenderer tagsRenderer;

    ExamplesRenderer examplesRenderer;

    StepsRenderer stepsRenderer;

    public CukedoctorScenarioRenderer() {
        ServiceLoader<TagsRenderer> tagsRenderers = ServiceLoader.load(TagsRenderer.class);
        ServiceLoader<ExamplesRenderer> examplesRenderers = ServiceLoader.load(ExamplesRenderer.class);
        ServiceLoader<StepsRenderer> stepsRenderers = ServiceLoader.load(StepsRenderer.class);

        if (tagsRenderers.iterator().hasNext()) {
            tagsRenderer = tagsRenderers.iterator().next();
        } else {
            tagsRenderer = new CukedoctorTagsRenderer();
            tagsRenderer.setDocumentBuilder(docBuilder);
            tagsRenderer.setI18n(i18n);
        }

        if (examplesRenderers.iterator().hasNext()) {
            examplesRenderer = examplesRenderers.iterator().next();
        } else {
            examplesRenderer = new CukedoctorExamplesRenderer();
            examplesRenderer.setDocumentBuilder(docBuilder);
            examplesRenderer.setI18n(i18n);
        }

        if (stepsRenderers.iterator().hasNext()) {
            stepsRenderer = stepsRenderers.iterator().next();
        } else {
            stepsRenderer = new CukedoctorStepsRenderer();
            stepsRenderer.setDocumentBuilder(docBuilder);
            stepsRenderer.setI18n(i18n);
        }
    }

    @Override
    public String renderScenario(Scenario scenario, Feature feature) {
        if (scenario.hasIgnoreDocsTag()) {
            return "";
        }

        if (hasText(scenario.getName())) {
            docBuilder.sectionTitleLevel3(new StringBuilder(scenario.getKeyword()).
                    append(": ").append(scenario.getName()).toString());
        }
        if (feature.hasTags() || scenario.hasTags()) {
            tagsRenderer.renderScenarioTags(feature, scenario);
        }

        docBuilder.textLine(scenario.getDescription()).newLine();

        if (scenario.hasExamples()) {
            examplesRenderer.renderScenarioExamples(scenario);
            return docBuilder.toString();//or a scenario has examples or it has steps
        }

        if (scenario.hasSteps()) {
            stepsRenderer.renderScenarioSteps(scenario.getSteps());
        }
        return docBuilder.toString();
    }


}
