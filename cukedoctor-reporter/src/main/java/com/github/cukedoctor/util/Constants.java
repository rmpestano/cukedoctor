package com.github.cukedoctor.util;

/**
 * Created by pestano on 04/06/15.
 */
public interface Constants {

    final String NEW_LINE = System.getProperty("line.separator");

    interface Markup {
        final String H1 = "=";
        final String H2 = "==";

        final String TABLE = "|===";

        String TOC = ":toc:";
        String ICONS = ":icons:";
        String NUMBERED = ":numbered:";
        String NOT_NUMBERED = ":!numbered:";
        String SECT_ANCHORS = ":sectanchors:";
        String NOT_SECT_ANCHORS = ":!sectanchors:";
        String SECT_LINK = ":sectlink:";
        String NOT_SECT_LINK = ":!sectlink:";
        String BACKEND = ":backend:";
        String DOC_TITLE = ":doctitle:";
        String DOC_FILE = ":docfile:";
        String DOC_TYPE = ":doctype:";
    }
}

