package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;

import java.util.ArrayList;
import java.util.Collections;

public class AnonymousSection implements Section {
    protected final ArrayList<Section> children = new ArrayList<>();

    public AnonymousSection addSection(Section section) {
        children.add(section);
        return this;
    }

    @Override
    public Section addFeature(Feature feature) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String render(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes) {
        Collections.sort(children);
        for (Section child : children) {
            docBuilder.append(child.render(docBuilder.createPeerBuilder(), i18n, documentAttributes));
        }

        return docBuilder.toString();
    }

    @Override
    public int getOrder() {
        return Integer.MAX_VALUE;
    }
}