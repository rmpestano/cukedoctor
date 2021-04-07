package cukedoctor.multipage.model;

import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;

import java.util.List;

public class Page {

    private String pageTitle;
    private List<Feature> features;
    private DocumentAttributes documentAttributes;
    private String render;

    public Page(String pageTitle, List<Feature> features, DocumentAttributes documentAttributes) {
        this.pageTitle = pageTitle;
        this.features = features;
        this.documentAttributes = documentAttributes;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public DocumentAttributes getDocumentAttributes() {
        return documentAttributes;
    }

    public void setDocumentAttributes(DocumentAttributes documentAttributes) {
        this.documentAttributes = documentAttributes;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getRender() {
        return render;
    }

    public void setRender(String render) {
        this.render = render;
    }
}
