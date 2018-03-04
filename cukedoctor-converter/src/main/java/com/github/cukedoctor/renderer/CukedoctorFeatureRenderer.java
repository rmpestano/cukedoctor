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

/**
 * Created by pestano on 27/02/16.
 */
public class CukedoctorFeatureRenderer extends AbstractBaseRenderer implements FeatureRenderer {

    ScenarioRenderer scenarioRenderer;

    public CukedoctorFeatureRenderer() {
        loadDependentRenderers();
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
        docBuilder.clear();
        if (feature.hasIgnoreDocsTag()) {
            return "";
        }
        docBuilder.textLine(renderFeatureSectionId(feature));
        if(!cukedoctorConfig.isHideFeaturesSection()) {//when feature section is not rendered we have to 'downgrade' other sections
            docBuilder.sectionTitleLevel2((bold(feature.getName()))).newLine();
        }else{
            docBuilder.sectionTitleLevel1((bold(feature.getName()))).newLine();
        }
        if (notNull(documentAttributes) && hasText(documentAttributes.getBackend())) {
            String backend = documentAttributes.getBackend();
            if((backend.toLowerCase().contains("html") ||  backend.toLowerCase().contains("all")) && !cukedoctorConfig.isDisableMinMaxExtension()) {
                //used by minimax extension @see com.github.cukedoctor.extension.CukedoctorMinMaxExtension
                docBuilder.append("ifndef::backend-pdf[]").append(newLine());
                docBuilder.append("minmax::", feature.getName().replaceAll(",", "").replaceAll(" ", "-")).append("[]").newLine();
                docBuilder.append("endif::[]").append(newLine());
            }

        }
        if (hasText(feature.getDescription())) {
            docBuilder.sideBarBlock(feature.getDescription().trim().replaceAll("\\\\", "").replaceAll("\\n", newLine()));
        }

        if(feature.hasScenarios()){
            docBuilder.append(renderFeatureScenarios(feature));
        }

        return docBuilder.toString();
    }

    @Override
    public String renderFeatures(List<Feature> features) {
        CukedoctorDocumentBuilder parentBuilder = CukedoctorDocumentBuilder.Factory.newInstance();
        if(!cukedoctorConfig.isHideFeaturesSection()) {
            parentBuilder.sectionTitleLevel1(bold(i18n.getMessage("title.features"))).newLine();
        }
        for (Feature feature : features) {
            parentBuilder.append(renderFeature(feature));
        }
        return parentBuilder.toString();
    }

    protected String renderFeatureScenarios(Feature feature) {
        StringBuilder sb = new StringBuilder();
        for (Scenario scenario : feature.getScenarios()) {
            sb.append(renderFeatureScenario(scenario, feature));
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

    protected String renderFeatureScenario(Scenario scenario, Feature feature){
        return scenarioRenderer.renderScenario(scenario,feature);
    }
}
