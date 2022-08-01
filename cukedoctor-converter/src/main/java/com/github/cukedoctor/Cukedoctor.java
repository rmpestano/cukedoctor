package com.github.cukedoctor;

import static com.github.cukedoctor.util.Assert.hasElements;

import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.converter.CukedoctorConverterImpl;
import java.util.List;

/**
 * Created by pestano on 10/06/15.
 *
 * <p>Factory of Cukedoctor converter
 */
public class Cukedoctor {

  private Cukedoctor() {}

  /**
   * @param features used to generate the documentation
   * @param attrs document attributes
   * @param cukedoctorConfig Cukedoctor configuration
   * @param docBuilder helper for building AsciiDoc documents with Cukedoctor conventions
   * @return a Cukedoctor converter instance
   */
  public static CukedoctorConverter instance(
      List<Feature> features,
      DocumentAttributes attrs,
      CukedoctorConfig cukedoctorConfig,
      CukedoctorDocumentBuilder docBuilder) {

    if (!hasElements(features)) {
      throw new RuntimeException("No features found");
    }

    CukedoctorConverter instance =
        new CukedoctorConverterImpl(features, attrs, cukedoctorConfig, docBuilder);

    // by default use documentTitle as filename
    instance.setFilename(instance.getDocumentationTitle().replace(" ", "_") + ".adoc");

    return instance;
  }

  /**
   * @param features used to generate the documentation
   * @param attrs document attributes
   * @param cukedoctorConfig Cukedoctor configuration
   * @return a Cukedoctor converter instance
   */
  public static CukedoctorConverter instance(
      List<Feature> features, DocumentAttributes attrs, CukedoctorConfig cukedoctorConfig) {
    return instance(
        features, attrs, cukedoctorConfig, CukedoctorDocumentBuilder.Factory.newInstance());
  }

  /**
   * @param features used to generate the documentation
   * @param attrs document attributes
   * @return a Cukedoctor converter instance
   */
  public static CukedoctorConverter instance(List<Feature> features, DocumentAttributes attrs) {
    return instance(features, attrs, getDefaultConfig());
  }

  /**
   * @param features used to generate the documentation
   * @param docBuilder helper for building AsciiDoc documents with Cukedoctor conventions
   * @return a Cukedoctor converter instance
   */
  public static CukedoctorConverter instance(
      List<Feature> features, CukedoctorDocumentBuilder docBuilder) {
    return instance(features, getDefaultDocumentAttributes(), getDefaultConfig(), docBuilder);
  }

  /**
   * @param features used to generate the documentation
   * @return a Cukedoctor converter instance
   */
  public static CukedoctorConverter instance(List<Feature> features) {

    return instance(features, getDefaultDocumentAttributes());
  }

  public static DocumentAttributes getDefaultDocumentAttributes() {
    return null;
  }

  public static CukedoctorConfig getDefaultConfig() {
    return new CukedoctorConfig();
  }
}
