package com.github.cukedoctor.api;


/**
 * Created by pestano on 04/06/15.
 * Document overall configuration
 */
public class DocumentAttributes {

	private String docTitle;
	private String backend = "html5";
	private String docType = "article";
	private String toc = "right";
	private String icons = "font";
	private boolean linkCss = false;
	private boolean sectAnchors = true;
	private boolean sectLink = true;
	private boolean numbered = false;
	private boolean docInfo = true;


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

/*	public Attributes toAsciidoctorJAttributes() {
		return attributes().backend(getBackend()).docType(getDocType()).icons(icons).
				sectionNumbers(isNumbered()).linkCss(isLinkCss()).setAnchors(isSectAnchors()).
				setAnchors(isSectAnchors()).title(docTitle).attribute("docinfo",":docinfo:").
				tableOfContents(toc.equalsIgnoreCase("left") ? Placement.LEFT : toc.equalsIgnoreCase("right") ? Placement.RIGHT :
				toc.equalsIgnoreCase("top") ? Placement.TOP : null).get();

	}*/
}
