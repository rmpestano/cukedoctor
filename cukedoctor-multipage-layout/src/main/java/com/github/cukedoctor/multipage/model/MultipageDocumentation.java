package com.github.cukedoctor.multipage.model;

import java.util.ArrayList;
import java.util.List;

public class MultipageDocumentation {
    private List<Page> pages;

    public MultipageDocumentation(List<Page> pages) {
        this.pages = pages;

        if(this.pages == null) {
            this.pages = new ArrayList<>();
        }
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
}
