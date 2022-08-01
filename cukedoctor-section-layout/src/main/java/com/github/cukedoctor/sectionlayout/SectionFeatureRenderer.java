package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.renderer.AbstractBaseRenderer;
import com.github.cukedoctor.spi.FeatureRenderer;
import java.util.List;

/** Custom renderer for cukedoctor feature */
public class SectionFeatureRenderer extends AbstractBaseRenderer implements FeatureRenderer {

  @Override
  public String renderFeature(Feature feature) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String renderFeatures(List<Feature> features) {
    CukedoctorDocumentBuilder builder = docBuilder.createPeerBuilder();
    new DocumentSection(features).render(builder, i18n, documentAttributes, cukedoctorConfig);
    return builder.toString();
  }
}
