package com.github.cukedoctor.jenkins.model;

/**
 * Created by pestano on 20/03/16.
 */
public enum FormatType {

    HTML("html"),pdf("pdf"), ALL("all");

    public final String format;

    FormatType(String value) {
        this.format = value;
    }

    public String getFormat() {
        return format;
    }
}
