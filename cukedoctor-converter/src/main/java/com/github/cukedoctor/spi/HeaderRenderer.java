package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.renderer.BaseRenderer;

/**
 * Created by rmpestano on 27/04/20.
 *
 * <p>This renderer is responsible for generating the documentation header such as attributes
 */
public interface HeaderRenderer extends BaseRenderer {

  /**
   * @deprecated Use renderDocumentHeader(DocumentAttributes, CukedoctorDocumentBuilder) instead
   * @param cukedoctorAttributes cukedoctor attributes
   * @return the rendered {@link String}
   */
  @Deprecated(forRemoval = true)
  String renderDocumentHeader(DocumentAttributes cukedoctorAttributes);

  default String renderDocumentHeader(
      DocumentAttributes cukedoctorAttributes, CukedoctorDocumentBuilder documentBuilder) {
    setDocumentBuilder(documentBuilder);
    return renderDocumentHeader(cukedoctorAttributes);
  }
}
