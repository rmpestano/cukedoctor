package com.github.cukedoctor.jenkins.model;

/**
 * Created by pestano on 20/03/16.
 */
public enum TocType {

    RIGHT("right"),LEFT("left"), CENTER("center");

    public final String toc;

    TocType(String value) {
        this.toc = value;
    }

    public String getToc() {
        return toc;
    }
}
