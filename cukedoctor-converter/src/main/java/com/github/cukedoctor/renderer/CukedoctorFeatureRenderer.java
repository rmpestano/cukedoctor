package com.github.cukedoctor.renderer;

import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Assert.isNull;
import static com.github.cukedoctor.util.Assert.not;
import static com.github.cukedoctor.util.Assert.notNull;
import static com.github.cukedoctor.util.Constants.Markup.bold;
import static com.github.cukedoctor.util.Constants.newLine;
import static com.github.cukedoctor.util.StringUtil.trimAllLines;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.spi.FeatureRenderer;
import com.github.cukedoctor.spi.ScenarioRenderer;
import com.github.cukedoctor.util.ServiceLoaderUtil;
import java.util.List;

/** Created by pestano on 27/02/16. */
public class CukedoctorFeatureRenderer extends AbstractBaseRenderer implements FeatureRenderer {

  ScenarioRenderer scenarioRenderer;

  public CukedoctorFeatureRenderer() {}

  public CukedoctorFeatureRenderer(DocumentAttributes documentAttributes) {
    setDocumentAttributes(documentAttributes);
  }

  public CukedoctorFeatureRenderer(CukedoctorConfig cukedoctorConfig) {
    this.cukedoctorConfig = cukedoctorConfig;
  }

  @Override
  public String renderFeature(Feature feature) {
    loadDependentRenderers();
    CukedoctorDocumentBuilder builder = docBuilder.createPeerBuilder();
    if (feature.hasIgnoreDocsTag()) {
      return "";
    }
    builder.textLine(renderFeatureSectionId(feature));
    builder.title(bold(feature.getName())).newLine();

    if (notNull(documentAttributes) && hasText(documentAttributes.getBackend())) {
      String backend = documentAttributes.getBackend();
      if ((backend.toLowerCase().contains("html") || backend.toLowerCase().contains("all"))
          && !cukedoctorConfig.isDisableMinMaxExtension()) {
        // used by minimax extension @see com.github.cukedoctor.extension.CukedoctorMinMaxExtension
        builder.append("ifndef::backend-pdf[]").append(newLine());
        builder.append("minmax::", renderFeatureId(feature)).append("[]").newLine();
        builder.append("endif::[]").append(newLine());
      }
    }
    if (hasText(feature.getDescription())) {
      final String description = trimAllLines(feature.getDescription()).replace("\\", "");
      renderDescription(builder, description);
    }

    if (feature.hasScenarios()) {
      builder.append(renderFeatureScenarios(feature, builder));
    }

    return builder.toString();
  }

  protected void renderDescription(CukedoctorDocumentBuilder builder, String description) {
    builder.sideBarBlock(description);
  }

  @Override
  public String renderFeatures(List<Feature> features) {
    loadDependentRenderers();
    docBuilder.clear();
    if (!cukedoctorConfig.isHideFeaturesSection()) {
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
    return "[[" + renderFeatureId(feature) + ", " + feature.getName() + "]]";
  }

  protected String renderFeatureId(Feature feature) {
    // Anchor must not have blanks neither commas to work
    return feature.getName().replace(",", "").replace("'", "-").replace(" ", "-");
  }

  protected String renderFeatureScenario(
      Scenario scenario, Feature feature, CukedoctorDocumentBuilder builder) {
    if (scenarioRenderer == null) {
      loadDependentRenderers();
    }
    return scenarioRenderer.renderScenario(scenario, feature, builder.createNestedBuilder());
  }

  private void loadDependentRenderers() {
    scenarioRenderer =
        new ServiceLoaderUtil<ScenarioRenderer>()
            .initialise(
                ScenarioRenderer.class,
                CukedoctorScenarioRenderer.class,
                i18n,
                documentAttributes,
                cukedoctorConfig);
  }
}
