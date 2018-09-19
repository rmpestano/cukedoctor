package com.github.cukedoctor.api;


/**
 * Created by pestano on 04/06/15.
 * Document overall configuration
 */
public class DocumentAttributes {

	private String docTitle = "Living Documentation";
	private String backend = "html5";
	private String docType = "book";
	private String toc = "right";
	private String icons = "font";
	private String tocLevels = "3";
	private boolean linkCss = false;
	private boolean sectAnchors = true;
	private boolean sectLink = true;
	private boolean numbered = false;
	private boolean docInfo = true;
	private String sourceHighlighter = "highlightjs";
	private String revNumber;
	private boolean hardBreaks = true;
	private String pdfStyle;
	private String chapterLabel = "Chapter";
	private String versionLabel = "Version";


	public DocumentAttributes() {
	}

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


	public DocumentAttributes sectAnchors(boolean sectAnchors) {
		this.sectAnchors = sectAnchors;
		return this;
	}

	public DocumentAttributes sectLink(boolean sectLink) {
		this.sectLink = sectLink;
		return this;
	}

	public DocumentAttributes numbered(boolean numbered) {
		this.numbered = numbered;
		return this;
	}

	public DocumentAttributes linkCss(boolean linkCss) {
		this.linkCss = linkCss;
		return this;
	}

	public DocumentAttributes docInfo(boolean docInfo) {
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

	public DocumentAttributes hardBreaks(boolean hardBreaks) {
		this.hardBreaks = hardBreaks;
		return this;
	}

	public DocumentAttributes pdfStyle(String pdfStyle) {
		this.pdfStyle = pdfStyle;
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

	public boolean isSectAnchors() {
		return sectAnchors;
	}

	public boolean isSectLink() {
		return sectLink;
	}

	public boolean isNumbered() {
		return numbered;
	}

	public boolean isLinkCss() {
		return linkCss;
	}

	public boolean isDocInfo() {
		return docInfo;
	}

	public boolean isHardBreaks() {
		return hardBreaks;
	}


	//setters needed by snakeyml


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

	public void setLinkCss(boolean linkCss) {
		this.linkCss = linkCss;
	}

	public void setSectAnchors(boolean sectAnchors) {
		this.sectAnchors = sectAnchors;
	}

	public void setSectLink(boolean sectLink) {
		this.sectLink = sectLink;
	}

	public void setNumbered(boolean numbered) {
		this.numbered = numbered;
	}

	public void setDocInfo(boolean docInfo) {
		this.docInfo = docInfo;
	}

	public void setSourceHighlighter(String sourceHighlighter) {
		this.sourceHighlighter = sourceHighlighter;
	}

	public void setRevNumber(String revNumber) {
		this.revNumber = revNumber;
	}

	public void setHardBreaks(boolean hardBreaks) {
		this.hardBreaks = hardBreaks;
	}


}
