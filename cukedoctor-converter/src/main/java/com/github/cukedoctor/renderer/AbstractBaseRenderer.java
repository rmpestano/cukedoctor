package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.config.GlobalConfig;
import com.github.cukedoctor.i18n.I18nLoader;

/** Created by pestano on 26/02/16. */
public abstract class AbstractBaseRenderer {

  protected I18nLoader i18n;
  protected CukedoctorDocumentBuilder docBuilder;
  protected DocumentAttributes documentAttributes;
  protected CukedoctorConfig cukedoctorConfig;

  protected AbstractBaseRenderer() {
    i18n = I18nLoader.instance(null);
    docBuilder = CukedoctorDocumentBuilder.Factory.newInstance();
    documentAttributes = GlobalConfig.getInstance().getDocumentAttributes();
    cukedoctorConfig = new CukedoctorConfig();
  }

  public void setI18n(I18nLoader i18n) {
    this.i18n = i18n;
  }

  /**
   * @param documentBuilder document builder
   * @deprecated Use renderX calls that pass the documentBuilder as a parameter instead
   */
  @Deprecated(forRemoval = true)
  public void setDocumentBuilder(CukedoctorDocumentBuilder documentBuilder) {
    this.docBuilder = documentBuilder;
  }

  public void setDocumentAttributes(DocumentAttributes documentAttributes) {
    this.documentAttributes = documentAttributes;
  }

  public void setCukedoctorConfig(CukedoctorConfig cukedoctorConfig) {
    this.cukedoctorConfig = cukedoctorConfig;
  }
}
