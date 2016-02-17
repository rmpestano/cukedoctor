package com.github.cukedoctor.markup;

import io.github.robwin.markup.builder.Markup;

/**
 * Created by pestano on 17/02/16.
 */
public enum Asciidoc implements Markup {

    SIDEBAR_BLOCK("****");

    private final String markup;

    private Asciidoc(String markup) {
        this.markup = markup;
    }

    @Override
    public String toString() {
        return markup;
    }
}
