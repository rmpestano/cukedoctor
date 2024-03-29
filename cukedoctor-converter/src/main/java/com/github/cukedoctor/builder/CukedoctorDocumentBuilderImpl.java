package com.github.cukedoctor.builder;

import static com.github.cukedoctor.util.Assert.hasElements;
import static com.github.cukedoctor.util.Assert.hasText;

import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.builder.AttributesBuilder;
import com.github.cukedoctor.markup.Asciidoc;
import com.github.cukedoctor.util.Constants;
import io.github.robwin.markup.builder.asciidoc.AsciiDocBuilder;

/** Created by pestano on 17/02/16. */
public class CukedoctorDocumentBuilderImpl extends AsciiDocBuilder
    implements CukedoctorDocumentBuilder {

  private final int initialTitleNestingLevel;
  private AttributesBuilder attrsBuilder;
  private int currentTitleNestingLevel;

  public CukedoctorDocumentBuilderImpl() {
    this(0);
  }

  private CukedoctorDocumentBuilderImpl(int initialTitleNestingLevel) {
    this.initialTitleNestingLevel = initialTitleNestingLevel;
    initialiseTitleNesting();
  }

  @Override
  public AttributesBuilder attributes() {
    if (attrsBuilder == null) {
      attrsBuilder = new AttributesBuilderImpl(this);
    }
    return attrsBuilder;
  }

  @Override
  public CukedoctorDocumentBuilder sideBarBlock(String text) {
    delimitedTextLine(Asciidoc.SIDEBAR_BLOCK, text);
    return this;
  }

  @Override
  public CukedoctorDocumentBuilder append(Object... text) {
    if (hasElements(text)) {
      for (Object o : text) {
        if (o.equals(Constants.newLine()) || hasText(o.toString())) {
          documentBuilder.append(o);
        }
      }
    }
    return this;
  }

  @Override
  public CukedoctorDocumentBuilder textLine(String text) {
    if (Constants.newLine().equals(text) || hasText(text)) {
      super.textLine(text);
    }
    return this;
  }

  @Override
  public CukedoctorDocumentBuilder sectionTitleLevel5(String title) {
    // Implementation derived from AsciiDocBuilder.sectionTitleLevel4(String title)
    this.documentBuilder.append("====== ").append(title).append(this.newLine);
    return this;
  }

  @Override
  public CukedoctorDocumentBuilder title(String title) {
    switch (currentTitleNestingLevel) {
      case 0:
        documentTitle(title);
        break;
      case 1:
        sectionTitleLevel1(title);
        break;
      case 2:
        sectionTitleLevel2(title);
        break;
      case 3:
        sectionTitleLevel3(title);
        break;
      case 4:
        sectionTitleLevel4(title);
        break;
      case 5:
        sectionTitleLevel5(title);
        break;
    }

    return this;
  }

  @Override
  public CukedoctorDocumentBuilder nestTitle() {
    checkNestingOverflow();

    currentTitleNestingLevel += 1;
    return this;
  }

  public CukedoctorDocumentBuilder unNestTitle() {
    if (currentTitleNestingLevel == initialTitleNestingLevel)
      throw new NestingUnderflowException(initialTitleNestingLevel);

    currentTitleNestingLevel -= 1;
    return this;
  }

  @Override
  public CukedoctorDocumentBuilder titleThenNest(String title) {
    return title(title).nestTitle();
  }

  public void clear() {
    documentBuilder = new StringBuilder();
    initialiseTitleNesting();
  }

  @Override
  public CukedoctorDocumentBuilder createNestedBuilder() {
    checkNestingOverflow();

    return new CukedoctorDocumentBuilderImpl(currentTitleNestingLevel + 1);
  }

  @Override
  public CukedoctorDocumentBuilder createPeerBuilder() {
    return new CukedoctorDocumentBuilderImpl(currentTitleNestingLevel);
  }

  private void checkNestingOverflow() {
    if (currentTitleNestingLevel == 5) throw new NestingOverflowException();
  }

  private void initialiseTitleNesting() {
    currentTitleNestingLevel = initialTitleNestingLevel;
  }

  public static class NestingOverflowException extends RuntimeException {
    public NestingOverflowException() {
      super(
          "Nesting is currently at Section Title Level 5 (the deepest AsciiDoc allows). You cannot"
              + " nest further titles below this level.");
    }
  }

  public static class NestingUnderflowException extends RuntimeException {
    public NestingUnderflowException(int currentLevel) {
      super(
          String.format(
              "Nesting is current at Level %s, the top-most allowed for this instance. You cannot"
                  + " un-nest above this level.",
              currentLevel));
    }
  }
}
