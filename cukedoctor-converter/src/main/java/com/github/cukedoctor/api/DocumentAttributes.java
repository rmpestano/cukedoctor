package com.github.cukedoctor.api;

import static com.github.cukedoctor.util.ObjectUtil.getFieldValue;

import com.github.cukedoctor.util.Constants;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/** Created by pestano on 04/06/15. Document overall configuration */
public class DocumentAttributes {
    private String docTitle = "Living Documentation";
    private String backend = "html5";
    private String docType = "book";
    private String toc = "right";
    private String icons = "font";
    private String tocLevels = "3";
    private Boolean linkCss = null;
    private Boolean sectAnchors = true;
    private Boolean sectLink = true;
    private Boolean numbered = null;
    private Boolean docInfo = true;
    private String sourceHighlighter = "highlightjs";
    private String revNumber;
    private Boolean hardBreaks = true;
    private String pdfStyle;
    private String chapterLabel = "Chapter";
    private String versionLabel = "Version";
    private String stem = null;
    private Boolean allowUriRead = null;
    private Boolean dataUri = null;

  public DocumentAttributes() {}

  public DocumentAttributes docTitle(String docTitle) {
    this.docTitle = docTitle;
    return this;
  }

  public DocumentAttributes backend(String backend) {
    this.backend = backend;
    return this;
  }

  public DocumentAttributes docType(String docType) {
    this.docType = docType;
    return this;
  }

  public DocumentAttributes toc(String toc) {
    this.toc = toc;
    return this;
  }

  public DocumentAttributes tocLevels(String tocLevels) {
    this.tocLevels = tocLevels;
    return this;
  }

  public DocumentAttributes icons(String icons) {
    this.icons = icons;
    return this;
  }

  public DocumentAttributes chapterLabel(String chapterLabel) {
    this.chapterLabel = chapterLabel;
    return this;
  }

  public DocumentAttributes versionLabel(String versionLabel) {
    this.versionLabel = versionLabel;
    return this;
  }

  public DocumentAttributes sectAnchors(Boolean sectAnchors) {
    this.sectAnchors = sectAnchors;
    return this;
  }

  public DocumentAttributes sectLink(Boolean sectLink) {
    this.sectLink = sectLink;
    return this;
  }

  public DocumentAttributes numbered(Boolean numbered) {
    this.numbered = numbered;
    return this;
  }

  public DocumentAttributes linkCss(Boolean linkCss) {
    this.linkCss = linkCss;
    return this;
  }

  public DocumentAttributes docInfo(Boolean docInfo) {
    this.docInfo = docInfo;
    return this;
  }

  public DocumentAttributes sourceHighlighter(String sourceHighlighter) {
    this.sourceHighlighter = sourceHighlighter;
    return this;
  }

  public DocumentAttributes revNumber(String docVersion) {
    this.revNumber = docVersion;
    return this;
  }

  public DocumentAttributes hardBreaks(Boolean hardBreaks) {
    this.hardBreaks = hardBreaks;
    return this;
  }

  public DocumentAttributes pdfStyle(String pdfStyle) {
    this.pdfStyle = pdfStyle;
    return this;
  }

  public DocumentAttributes stem(String stem) {
    this.stem = stem;
    return this;
  }

  public DocumentAttributes allowUriRead(Boolean allowUriRead) {
    this.allowUriRead = allowUriRead;
    return this;
  }

  public DocumentAttributes dataUri(Boolean dataUri) {
    this.dataUri = dataUri;
    return this;
  }

  public String getBackend() {
    return backend;
  }

  public String getDocTitle() {
    return docTitle;
  }

  public String getDocType() {
    return docType;
  }

  public String getToc() {
    return toc;
  }

  public String getIcons() {
    return icons;
  }

  public String getTocLevels() {
    return tocLevels;
  }

  public String getChapterLabel() {
    return chapterLabel;
  }

  public String getVersionLabel() {
    return versionLabel;
  }

  public String getSourceHighlighter() {
    return sourceHighlighter;
  }

  public String getRevNumber() {
    return revNumber;
  }

  public String getPdfStyle() {
    return pdfStyle;
  }

  public Boolean isSectAnchors() {
    return sectAnchors;
  }

  public Boolean isSectLink() {
    return sectLink;
  }

  public Boolean isNumbered() {
    return numbered;
  }

  public Boolean isLinkCss() {
    return linkCss;
  }

  public Boolean isDocInfo() {
    return docInfo;
  }

  public Boolean isHardBreaks() {
    return hardBreaks;
  }

  public String getStem() {
    return stem;
  }

  public Boolean isAllowUriRead() {
    return allowUriRead;
  }

  public Boolean isDataUri() {
    return dataUri;
  }

  // setters needed by snakeyml

  public void setPdfStyle(String pdfStyle) {
    this.pdfStyle = pdfStyle;
  }

  public void setDocTitle(String docTitle) {
    this.docTitle = docTitle;
  }

  public void setBackend(String backend) {
    this.backend = backend;
  }

  public void setDocType(String docType) {
    this.docType = docType;
  }

  public void setToc(String toc) {
    this.toc = toc;
  }

  public void setIcons(String icons) {
    this.icons = icons;
  }

  public void setTocLevels(String tocLevels) {
    this.tocLevels = tocLevels;
  }

  public void setChapterLabel(String chapterLabel) {
    this.chapterLabel = chapterLabel;
  }

  public void setVersionLabel(String versionLabel) {
    this.versionLabel = versionLabel;
  }

  public void setLinkCss(Boolean linkCss) {
    this.linkCss = linkCss;
  }

  public void setSectAnchors(Boolean sectAnchors) {
    this.sectAnchors = sectAnchors;
  }

  public void setSectLink(Boolean sectLink) {
    this.sectLink = sectLink;
  }

  public void setNumbered(Boolean numbered) {
    this.numbered = numbered;
  }

  public void setDocInfo(Boolean docInfo) {
    this.docInfo = docInfo;
  }

  public void setSourceHighlighter(String sourceHighlighter) {
    this.sourceHighlighter = sourceHighlighter;
  }

  public void setRevNumber(String revNumber) {
    this.revNumber = revNumber;
  }

  public void setHardBreaks(Boolean hardBreaks) {
    this.hardBreaks = hardBreaks;
  }

  public void setStem(String stem) {
    this.stem = stem;
  }

  public void setAllowUriRead(Boolean allowUriRead) {
    this.allowUriRead = allowUriRead;
  }

  public void setDataUri(Boolean dataUri) {
    this.dataUri = dataUri;
  }

  public Map<String, Object> toMap() {
    return createAttributesMap();
  }

    private Map<String, Object> createAttributesMap() {
        Map<String, Object> attributesMap = new HashMap<>();
        for (Field field : getClass().getDeclaredFields()) {
            try {
                String fieldName = field.getName();
                Object fieldValue = getFieldValue(this, fieldName);
                if (fieldValue != null) {
                    Constants.Attributes.Name asciidocAttrName = Constants.Attributes.Name.valueOf(fieldName.toUpperCase());
                    attributesMap.put(asciidocAttrName.getName(), fieldValue.toString());
                }
            } catch (Exception e) {
                LoggerFactory.getLogger(DocumentAttributes.class)
                             .warn("Could not get field value of attribute {}", field.getName(), e);
            }
        }
        return attributesMap;
    }
}
