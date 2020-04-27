package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.spi.FeatureRenderer;
import com.github.cukedoctor.spi.ScenarioRenderer;

import java.util.List;
import java.util.ServiceLoader;

import static com.github.cukedoctor.util.Assert.*;
import static com.github.cukedoctor.util.Constants.Markup.bold;
import static com.github.cukedoctor.util.Constants.newLine;
import static com.github.cukedoctor.util.StringUtil.trimAllLines;

/**
 * Created by pestano on 27/02/16.
 */
public class CukedoctorFeatureRenderer extends AbstractBaseRenderer implements FeatureRenderer {

    ScenarioRenderer scenarioRenderer;

    public CukedoctorFeatureRenderer() {
        loadDependentRenderers();
    }

    public CukedoctorFeatureRenderer(CukedoctorDocumentBuilder builder) {
        loadDependentRenderers();
        setDocumentBuilder(builder);
    }

    private void loadDependentRenderers() {
        ServiceLoader<ScenarioRenderer> scenarioRenderers = ServiceLoader.load(ScenarioRenderer.class);

        if (scenarioRenderers.iterator().hasNext()) {
            scenarioRenderer = scenarioRenderers.iterator().next();
        } else {
            scenarioRenderer = new CukedoctorScenarioRenderer();
            scenarioRenderer.setI18n(i18n);
        }
    }

    public CukedoctorFeatureRenderer(CukedoctorConfig cukedoctorConfig) {
        this.cukedoctorConfig = cukedoctorConfig;
        loadDependentRenderers();
    }

    @Override
    public String renderFeature(Feature feature) {
        CukedoctorDocumentBuilder builder = docBuilder.createNestedBuilder();
        if (feature.hasIgnoreDocsTag()) {
            return "";
        }
        builder.textLine(renderFeatureSectionId(feature));
        builder.titleThenNest(bold(feature.getName())).newLine();

        if (notNull(documentAttributes) && hasText(documentAttributes.getBackend())) {
            String backend = documentAttributes.getBackend();
            if((backend.toLowerCase().contains("html") ||  backend.toLowerCase().contains("all")) && !cukedoctorConfig.isDisableMinMaxExtension()) {
                //used by minimax extension @see com.github.cukedoctor.extension.CukedoctorMinMaxExtension
                builder.append("ifndef::backend-pdf[]").append(newLine());
                builder.append("minmax::", feature.getName().replaceAll(",", "").replaceAll(" ", "-")).append("[]").newLine();
                builder.append("endif::[]").append(newLine());
            }

        }
        if (hasText(feature.getDescription())) {
            builder.sideBarBlock(trimAllLines(feature.getDescription()).replaceAll("\\\\", "").replaceAll("\\n", newLine()));
        }

        if(feature.hasScenarios()){
            builder.append(renderFeatureScenarios(feature, builder));
        }

        return builder.toString();
    }

    @Override
    public String renderFeatures(List<Feature> features) {
        docBuilder.clear();
        if(!cukedoctorConfig.isHideFeaturesSection()) {
            docBuilder.titleThenNest(bold(i18n.getMessage("title.features"))).newLine();
        }
        for (Feature feature : features) {
            docBuilder.append(renderFeature(feature));
        }
        return docBuilder.toString();
    }

    protected String renderFeatureScenarios(Feature feature, CukedoctorDocumentBuilder builder) {
        StringBuilder sb = new StringBuilder();
        for (Scenario scenario : feature.getScenarios()) {
            sb.append(renderFeatureScenario(scenario, feature, builder));
        }
        feature.setBackgroundRendered(false);
        return sb.toString();
    }

    protected String renderFeatureSectionId(Feature feature) {
        if (isNull(feature) || not(hasText(feature.getName()))) {
            return "";
        }
        //Anchor must not have blanks neither commas to work
        return "[[" + feature.getName().replaceAll(",", "").replaceAll(" ", "-") +
                ", " + feature.getName() + "]]";
    }

    protected String renderFeatureScenario(Scenario scenario, Feature feature, CukedoctorDocumentBuilder builder){
        scenarioRenderer.setDocumentBuilder(builder.createNestedBuilder());
        return scenarioRenderer.renderScenario(scenario,feature);
    }
}
