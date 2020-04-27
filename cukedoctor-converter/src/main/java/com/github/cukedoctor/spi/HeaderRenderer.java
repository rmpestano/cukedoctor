package com.github.cukedoctor.spi;

import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.renderer.BaseRenderer;

/**
 * Created by rmpestano on 27/04/20.
 *
 * This renderer is responsible for generating the documentation header
 * such as attributes
 */
public interface HeaderRenderer extends BaseRenderer {

    /**
     *
     * @param cukedoctorAttributes cukedoctor attributes
     * @return
     */
    String renderDocumentHeader(DocumentAttributes cukedoctorAttributes);

}
