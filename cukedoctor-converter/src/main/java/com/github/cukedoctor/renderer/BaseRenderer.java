package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.i18n.I18nLoader;

/**
 * Created by pestano on 27/02/16.
 */
public interface BaseRenderer {

    void setI18n(I18nLoader i18nProvider);
    void setDocumentBuilder(CukedoctorDocumentBuilder documentBuilder);
    void setDocumentAttributes(DocumentAttributes documentAttributes);
}
