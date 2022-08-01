package com.github.cukedoctor.multipage.defaults;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.multipage.model.Page;
import com.github.cukedoctor.multipage.spi.MultipagePager;
import com.github.cukedoctor.parser.FeatureParser;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Default implementation for the {@link MultipagePager} that does a "one page per feature" grouping
 *
 * <p>To create a new implementation of this class - use the
 * com.github.cukedoctor.multipage.spi.MultipagePager SPI
 */
public class OnePagePerFeatureMultipagePager implements MultipagePager {
  private DocumentAttributes documentAttributes;
  private CukedoctorConfig cukedoctorConfig;

  @Override
  public List<Page> pages(List<String> jsonPaths) {
    List<Feature> features = FeatureParser.parse(jsonPaths);

    return features.stream()
        .sorted(Comparator.comparing(Feature::getOrder))
        .map(
            feature -> {
              documentAttributes.docTitle(feature.getName());
              return new Page(
                  feature.getName(), Collections.singletonList(feature), documentAttributes);
            })
        .collect(Collectors.toList());
  }

  @Override
  public void setI18n(I18nLoader i18nProvider) {
    // noop
  }

  @Override
  public void setDocumentBuilder(CukedoctorDocumentBuilder documentBuilder) {
    // noop
  }

  @Override
  public void setDocumentAttributes(DocumentAttributes documentAttributes) {
    this.documentAttributes = documentAttributes;
  }

  @Override
  public void setCukedoctorConfig(CukedoctorConfig cukedoctorConfig) {
    this.cukedoctorConfig = cukedoctorConfig;
  }
}
