package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.i18n.I18nLoader;

public class StyledSection extends NamedSection {
    private final String style;

    public StyledSection(String id, String style) {
        super(id);
        this.style = style;
    }

    @Override
    protected void renderSectionName(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        docBuilder.textLine("[" + style + "]");
        super.renderSectionName(docBuilder, i18n, documentAttributes);
    }
}
