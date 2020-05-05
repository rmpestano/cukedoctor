package com.github.cukedoctor.sectionlayout;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.i18n.I18nLoader;

import java.util.stream.Stream;

public interface Section extends Comparable<Section> {
    Section addFeature(Feature feature);

    default Section addFeatures(Iterable<Feature> features) {
        for (Feature feature : features) {
            addFeature(feature);
        }

        return this;
    }

    String render(CukedoctorDocumentBuilder docBuilder, I18nLoader i18n, DocumentAttributes documentAttributes);

    int getOrder();

    default int compareTo(Section other) {
        if (other == null) return 1;

        return Integer.compare(getOrder(), other.getOrder());
    }

    Stream<Feature> getFeatures();
}
