package cukedoctor.multipage.model;

import java.util.ArrayList;
import java.util.List;

public class MultipageDocumentation {
    private List<Page> pages = new ArrayList<>();

    public MultipageDocumentation(List<Page> pages) {
        this.pages = pages;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
}
