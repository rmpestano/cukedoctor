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

    AttributesBuilder numbered(Boolean value);

    AttributesBuilder linkcss(Boolean value);

    AttributesBuilder sectAnchors(Boolean value);

    AttributesBuilder sectLink(Boolean value);

    AttributesBuilder docInfo(Boolean value);

    AttributesBuilder hardBreaks(Boolean value);

    AttributesBuilder sourceHighlighter(String value);

    AttributesBuilder revNumber(String value);

    AttributesBuilder tocLevels(String value);

    AttributesBuilder pdfStyle(String value);
    
    AttributesBuilder chapterLabel(String value);
    
    AttributesBuilder versionLabel(String value);

    AttributesBuilder stem(String value);

    AttributesBuilder allowUriRead(Boolean value);

    AsciiDocBuilder asciiDocBuilder();

}
