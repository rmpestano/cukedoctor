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
	private boolean pdfTheme = true;
	private String sourceHighlighter = "highlightjs";
	private String revNumber;
	private boolean hardBreaks = true;

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

	public DocumentAttributes pdfTheme(boolean pdfTheme) {
		this.pdfTheme = pdfTheme;
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

	public String getSourceHighlighter() {
		return sourceHighlighter;
	}

	public String getRevNumber() {
		return revNumber;
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

	public boolean isPdfTheme() {
		return pdfTheme;
	}

	public boolean isHardBreaks() {
		return hardBreaks;
	}
}
