package com.github.cukedoctor.renderer;

import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.spi.HeaderRenderer;

/**
 * Created by rmpestano on 27/04/20.
 *
 * @since 2.2
 */
public class CukedoctorHeaderRenderer extends AbstractBaseRenderer implements HeaderRenderer {

  @Override
  public String renderDocumentHeader(DocumentAttributes documentAttributes) {
    docBuilder.clear();

    if (documentAttributes == null) {
      return "";
    }

    return docBuilder
        .attributes()
        .toc(documentAttributes.getToc())
        .backend(documentAttributes.getBackend())
        .docTitle(documentAttributes.getDocTitle())
        .docType(documentAttributes.getDocType())
        .icons(documentAttributes.getIcons())
        .numbered(documentAttributes.isNumbered())
        .linkcss(documentAttributes.isLinkCss())
        .sectAnchors(documentAttributes.isSectAnchors())
        .sectLink(documentAttributes.isSectLink())
        .docInfo(documentAttributes.isDocInfo())
        .sourceHighlighter(documentAttributes.getSourceHighlighter())
        .tocLevels(documentAttributes.getTocLevels())
        .revNumber(documentAttributes.getRevNumber())
        .hardBreaks(documentAttributes.isHardBreaks())
        .chapterLabel(documentAttributes.getChapterLabel())
        .versionLabel(documentAttributes.getVersionLabel())
        .stem(documentAttributes.getStem())
        .allowUriRead(documentAttributes.isAllowUriRead())
        .pdfStyle(documentAttributes.getPdfStyle())
        .dataUri(documentAttributes.isDataUri())
        .asciiDocBuilder()
        .toString();
  }
}
