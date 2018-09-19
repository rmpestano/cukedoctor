package com.github.cukedoctor.api.builder;

import io.github.robwin.markup.builder.asciidoc.AsciiDocBuilder;

/**
 * Created by pestano on 17/02/16.
 */
public interface AttributesBuilder {

    AttributesBuilder toc(String value);

    AttributesBuilder backend(String value);

    AttributesBuilder docTitle(String value);

    AttributesBuilder docType(String value);

    AttributesBuilder icons(String value);

    AttributesBuilder numbered(boolean value);

    AttributesBuilder linkcss(boolean value);

    AttributesBuilder sectAnchors(boolean value);

    AttributesBuilder sectLink(boolean value);

    AttributesBuilder docInfo(boolean value);

    AttributesBuilder hardBreaks(boolean value);

    AttributesBuilder sourceHighlighter(String value);

    AttributesBuilder revNumber(String value);

    AttributesBuilder tocLevels(String value);

    AttributesBuilder pdfStyle(String value);
    
    AttributesBuilder chapterLabel(String value);
    
    AttributesBuilder versionLabel(String value);

    AsciiDocBuilder asciiDocBuilder();

}
