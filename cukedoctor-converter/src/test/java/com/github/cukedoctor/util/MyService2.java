package com.github.cukedoctor.util;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.renderer.AbstractBaseRenderer;
import com.github.cukedoctor.renderer.BaseRenderer;

public class MyService2 extends AbstractBaseRenderer implements BaseRenderer {
  @Override
  public void setI18n(I18nLoader i18nProvider) {}

  @Override
  public void setDocumentBuilder(CukedoctorDocumentBuilder documentBuilder) {}

  @Override
  public void setDocumentAttributes(DocumentAttributes documentAttributes) {}
}
