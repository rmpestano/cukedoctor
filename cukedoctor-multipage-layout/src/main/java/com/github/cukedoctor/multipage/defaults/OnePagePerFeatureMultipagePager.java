package com.github.cukedoctor.multipage.defaults;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.config.GlobalConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.multipage.model.Page;
import com.github.cukedoctor.multipage.spi.MultipagePager;
import com.github.cukedoctor.parser.FeatureParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Default implementation for the {@link MultipagePager} that does a "one page per feature" grouping
 *
 * To create a new implementation of this class - use the com.github.cukedoctor.multipage.spi.MultipagePager SPI
 */
public class OnePagePerFeatureMultipagePager implements MultipagePager {
    @Override
    public List<Page> pages(List<String> jsonPaths, DocumentAttributes attrs) {
        List<Feature> features = FeatureParser.parse(jsonPaths);
        List<Page> resultPages = new ArrayList<>();

        for(Feature feature: features) {
            attrs.docTitle(feature.getName());
            resultPages.add(new Page(feature.getName(), Collections.singletonList(feature), attrs));
        }

        return resultPages;
    }

    @Override
    public void setI18n(I18nLoader i18nProvider) {

    }

    @Override
    public void setDocumentBuilder(CukedoctorDocumentBuilder documentBuilder) {

    }

    @Override
    public void setDocumentAttributes(DocumentAttributes documentAttributes) {

    }

    @Override
    public void setCukedoctorConfig(CukedoctorConfig cukedoctorConfig) {

    }
}
