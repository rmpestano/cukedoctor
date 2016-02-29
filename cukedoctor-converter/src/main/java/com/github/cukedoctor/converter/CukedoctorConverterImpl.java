package com.github.cukedoctor.converter;

import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.*;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.renderer.CukedoctorFeatureRenderer;
import com.github.cukedoctor.renderer.CukedoctorScenarioRenderer;
import com.github.cukedoctor.renderer.CukedoctorSummaryRenderer;
import com.github.cukedoctor.spi.FeatureRenderer;
import com.github.cukedoctor.spi.ScenarioRenderer;
import com.github.cukedoctor.spi.SummaryRenderer;
import com.github.cukedoctor.util.Constants;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.Formatter;

import java.io.File;
import java.util.List;
import java.util.ServiceLoader;

import static com.github.cukedoctor.util.Assert.*;
import static com.github.cukedoctor.util.Constants.Markup.*;
import static com.github.cukedoctor.util.Constants.newLine;


/**
 * Created by pestano on 02/06/15.
 */
public class CukedoctorConverterImpl implements CukedoctorConverter {


	private List<Feature> features;
	private DocumentAttributes documentAttributes;
	private String filename;
	private CukedoctorDocumentBuilder docBuilder;
	private I18nLoader i18n;
	private SummaryRenderer summaryRenderer;
	private FeatureRenderer featureRenderer;


	public CukedoctorConverterImpl(List<Feature> features, DocumentAttributes attrs) {
		this.features = features;
		this.documentAttributes = attrs;
		docBuilder = CukedoctorDocumentBuilder.Factory.newInstance();
		i18n = I18nLoader.newInstance(features);
		loadRenderers();
	}

	private void loadRenderers() {
		ServiceLoader<SummaryRenderer> summaryRenderers = ServiceLoader.load(SummaryRenderer.class);
		ServiceLoader<FeatureRenderer> featureRenderers = ServiceLoader.load(FeatureRenderer.class);
		ServiceLoader<ScenarioRenderer> scenarioRenderers = ServiceLoader.load(ScenarioRenderer.class);

		if(summaryRenderers.iterator().hasNext()){
			summaryRenderer = summaryRenderers.iterator().next();
		}else{
			summaryRenderer = new CukedoctorSummaryRenderer();
		}
		summaryRenderer.setDocumentBuilder(CukedoctorDocumentBuilder.Factory.newInstance());
		summaryRenderer.setI18n(i18n);

		if(featureRenderers.iterator().hasNext()){
			featureRenderer = featureRenderers.iterator().next();
		}else{
			featureRenderer = new CukedoctorFeatureRenderer();
		}

		featureRenderer.setDocumentBuilder(CukedoctorDocumentBuilder.Factory.newInstance());
		featureRenderer.setI18n(i18n);
		featureRenderer.setDocumentAttributes(documentAttributes);

	}


	public DocumentAttributes getDocumentAttributes() {
		return documentAttributes;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public String getDocumentation() {
		return docBuilder.toString();
	}

	/**
	 * @return a String representation of generated documentation
	 */
	public synchronized String renderDocumentation() {
		docBuilder = CukedoctorDocumentBuilder.Factory.newInstance();
		renderAttributes();
		docBuilder.newLine();
		docBuilder.documentTitle(bold(getDocumentationTitle()));
		renderIntro();
		renderSummary();
		docBuilder.sectionTitleLevel1(bold(i18n.getMessage("title.features"))).newLine();
		renderFeatures(features);
		//generateDocInfo();
		//generatePdfTheme();

		return docBuilder.toString();
	}

	public void renderIntro() {
		List<String> files = FileUtil.findFiles(Constants.baseDir, new String[]{"**/*cukedoctor-intro.adoc"});
		if(files != null && !files.isEmpty()){
			String introPath = files.get(0);
			 introPath = introPath.replaceAll("\\\\","/");
			docBuilder.append("include::", introPath, "[leveloffset=+1]", newLine(), newLine());
		}
	}


	public String getDocumentationTitle() {
		if(documentAttributes != null && hasText(documentAttributes.getDocTitle())){
			return documentAttributes.getDocTitle();
		} else {
			return CukedoctorConfig.DOCUMENT_TITLE;
		}

	}

	public CukedoctorConverter renderAttributes() {
		if(documentAttributes != null){
			docBuilder.attributes().toc(documentAttributes.getToc())
					.backend(documentAttributes.getBackend())
					.docTitle(documentAttributes.getDocTitle())
					.docType(documentAttributes.getDocType())
					.icons(documentAttributes.getIcons())
					.numbered(documentAttributes.isNumbered())
					.linkcss(documentAttributes.isLinkCss())
					.sectAnchors(documentAttributes.isSectAnchors())
					.sectLink(documentAttributes.isSectLink())
					.docInfo(documentAttributes.isDocInfo())
					.tocLevels(documentAttributes.getTocLevels());
		}
		return this;
	}

	public CukedoctorConverter generateDocInfo() {
		if (notNull(documentAttributes) && documentAttributes.isDocInfo()) {
			//name must be filename-docinfo.html
			String docInfoName = filename.substring(0, filename.lastIndexOf(".")) + "-docinfo.html";
			File savedFile = FileUtil.copyFile("docinfo.html", docInfoName);
			//docinfo depends on cukedoctor.js and cukedoctor.css
			//save js and css file in same dir as docinfo
			String basePath = "";
			if (contains(filename, "/")) {
				basePath = filename.substring(0, filename.lastIndexOf("/"));
			}
			FileUtil.copyFile("cukedoctor.js", basePath + "/cukedoctor.js");
			FileUtil.copyFile("cukedoctor.css", basePath + "/cukedoctor.css");

		}

		return this;
	}

	public CukedoctorConverter generatePdfTheme() {
		if (notNull(documentAttributes) && documentAttributes.isPdfTheme()) {
			//name must be filename-theme.yml
			String pdfThemeName = filename.substring(0, filename.lastIndexOf(".")) + "-theme.yml";
			FileUtil.copyFile("theme.yml", pdfThemeName);
		}
		return this;
	}

	public CukedoctorConverter renderSummary() {
		if(summaryRenderer != null){
			//renderer provided through spi
			docBuilder.textLine(summaryRenderer.renderSummary(features));
		} else{
			summaryRenderer = new CukedoctorSummaryRenderer();
			docBuilder.textLine(summaryRenderer.renderSummary(features));
		}

		return this;
	}



	public CukedoctorConverter renderFeatures(List<Feature> features) {
		for (Feature feature : features) {
			docBuilder.append(featureRenderer.renderFeature(feature));
		}
		return this;
	}


	@Override
	public CukedoctorConverter setFilename(String filename) {
		if (filename == null) {
			filename = getDocumentationTitle();
		}
		if (!filename.contains(".")) {
			filename = filename + ".adoc";
		}
		filename = filename.replaceAll(" ", "_");//remove blank spaces with underline

		if (!FileUtil.ADOC_FILE_EXTENSION.matcher(filename).matches()) {
			throw new RuntimeException("Invalid filename extension for file: " + filename + ". Valid formats are: ad, adoc, asciidoc and asc");
		}


		this.filename = filename;
		return this;
	}

	@Override
	public String getFilename() {
		return filename;
	}

	public CukedoctorConverter saveDocumentation() {
		FileUtil.saveFile(filename, renderDocumentation());
		return this;
	}


}
