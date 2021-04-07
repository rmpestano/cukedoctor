package cukedoctor.multipage.defaults;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.config.GlobalConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.parser.FeatureParser;
import cukedoctor.multipage.model.Page;
import cukedoctor.multipage.spi.MultipagePager;

import java.util.ArrayList;
import java.util.List;

public class OnePagePerFeatureMultipagePager implements MultipagePager {
    @Override
    public List<Page> pages(List<String> jsonPaths) {
        List<Feature> features = FeatureParser.parse(jsonPaths);
        DocumentAttributes attrs = GlobalConfig.getInstance().getDocumentAttributes();
        attrs.toc("left").backend("html5")
                .docType("book")
                .icons("font").numbered(false)
                .sourceHighlighter("coderay")
                .sectAnchors(true).sectLink(true);

        List<Page> resultPages = new ArrayList<>();

        for(Feature feature: features) {
            attrs.docTitle(feature.getName());
            resultPages.add(new Page(feature.getName(), features, attrs));
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
