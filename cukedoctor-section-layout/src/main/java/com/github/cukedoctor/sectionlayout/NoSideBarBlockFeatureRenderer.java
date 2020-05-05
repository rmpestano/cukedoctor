package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.renderer.CukedoctorFeatureRenderer;

public class NoSideBarBlockFeatureRenderer extends CukedoctorFeatureRenderer {
    @Override
    protected void renderDescription(CukedoctorDocumentBuilder builder, String description) {
        builder.textLine(description).newLine();
    }
}
