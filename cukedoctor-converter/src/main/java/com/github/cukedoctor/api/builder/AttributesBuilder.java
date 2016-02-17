package com.github.cukedoctor.api.builder;

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

    AttributesBuilder tocLevels(String value);


}
