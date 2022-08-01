package com.github.cukedoctor.builder;

import static com.github.cukedoctor.util.Assert.hasText;

import com.github.cukedoctor.api.builder.AttributesBuilder;
import com.github.cukedoctor.util.Constants;
import io.github.robwin.markup.builder.asciidoc.AsciiDocBuilder;

/** Created by pestano on 17/02/16. */
public class AttributesBuilderImpl implements AttributesBuilder {

  private final AsciiDocBuilder docBuilder;

  public AttributesBuilderImpl(AsciiDocBuilder docBuilder) {
    this.docBuilder = docBuilder;
  }

  @Override
  public AttributesBuilder toc(String value) {
    docBuilder.textLine(Constants.Attributes.toc(value));
    return this;
  }

  @Override
  public AttributesBuilder backend(String value) {
    docBuilder.textLine(Constants.Attributes.backend(value));
    return this;
  }

  @Override
  public AttributesBuilder docTitle(String value) {
    docBuilder.textLine(Constants.Attributes.docTitle(value));
    return this;
  }

  @Override
  public AttributesBuilder docType(String value) {
    docBuilder.textLine(Constants.Attributes.docType(value));
    return this;
  }

  @Override
  public AttributesBuilder icons(String value) {
    docBuilder.textLine(Constants.Attributes.icons(value));
    return this;
  }

  @Override
  public AttributesBuilder numbered(Boolean value) {
    if (value != null) {
      docBuilder.textLine(Constants.Attributes.numbered(value));
    }

    return this;
  }

  @Override
  public AttributesBuilder linkcss(Boolean value) {
    if (value != null) {
      docBuilder.textLine(Constants.Attributes.linkcss(value));
    }

    return this;
  }

  @Override
  public AttributesBuilder sectAnchors(Boolean value) {
    if (value != null) {
      docBuilder.textLine(Constants.Attributes.sectAnchors(value));
    }

    return this;
  }

  @Override
  public AttributesBuilder sectLink(Boolean value) {
    if (value != null) {
      docBuilder.textLine(Constants.Attributes.sectLink(value));
    }

    return this;
  }

  @Override
  public AttributesBuilder docInfo(Boolean value) {
    if (value != null) {
      docBuilder.textLine(Constants.Attributes.docInfo(value));
    }

    return this;
  }

  @Override
  public AttributesBuilder hardBreaks(Boolean value) {
    if (value != null) {
      docBuilder.textLine(Constants.Attributes.hardBreaks(value));
    }

    return this;
  }

  @Override
  public AttributesBuilder sourceHighlighter(String value) {
    docBuilder.textLine(Constants.Attributes.sourceHighlighter(value));
    return this;
  }

  @Override
  public AttributesBuilder tocLevels(String value) {
    docBuilder.textLine(Constants.Attributes.tocLevels(value));
    return this;
  }

  @Override
  public AttributesBuilder chapterLabel(String value) {
    docBuilder.textLine(Constants.Attributes.chapterLabel(value));
    return this;
  }

  @Override
  public AttributesBuilder versionLabel(String value) {
    docBuilder.textLine(Constants.Attributes.versionLabel(value));
    return this;
  }

  @Override
  public AttributesBuilder pdfStyle(String value) {
    if (!hasText(value)) {
      return this;
    }
    docBuilder.textLine(Constants.Attributes.pdfStyle(value));
    return this;
  }

  @Override
  public AttributesBuilder stem(String value) {
    if (!hasText(value)) {
      return this;
    }
    docBuilder.textLine(Constants.Attributes.stem(value));
    return this;
  }

  @Override
  public AttributesBuilder allowUriRead(Boolean value) {
    if (value != null) {
      docBuilder.textLine(Constants.Attributes.allowUriRead(value));
    }

    return this;
  }

  @Override
  public AttributesBuilder dataUri(Boolean value) {
    if (value != null) {
      docBuilder.textLine(Constants.Attributes.dataUri(value));
    }

    return this;
  }

  @Override
  public AsciiDocBuilder asciiDocBuilder() {
    return docBuilder;
  }

  @Override
  public AttributesBuilder revNumber(String value) {
    if (hasText(value)) {
      docBuilder.textLine(Constants.Attributes.revNumber(value));
    } else {
      // verify system property
      String revNumberSysProp = System.getProperty("docVersion");
      if (revNumberSysProp != null) {
        docBuilder.textLine(Constants.Attributes.revNumber(revNumberSysProp));
      }
    }
    return this;
  }
}
