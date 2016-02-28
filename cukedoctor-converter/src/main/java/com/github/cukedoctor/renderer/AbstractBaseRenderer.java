package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;

import java.util.List;

/**
 * Created by pestano on 26/02/16.
 */
public abstract class AbstractBaseRenderer {

    protected I18nLoader i18n;
    protected CukedoctorDocumentBuilder docBuilder;


    public AbstractBaseRenderer() {
        i18n = I18nLoader.instance(null);
        docBuilder = CukedoctorDocumentBuilder.Factory.newInstance();
    }

    public void setI18n(I18nLoader i18n) {
        this.i18n = i18n;
    }

    public void setDocumentBuilder(CukedoctorDocumentBuilder documentBuilder) {
        this.docBuilder = documentBuilder;
    }
}
