package com.github.cukedoctor.converter;

import static com.github.cukedoctor.util.Assert.hasElements;
import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Assert.notNull;
import static com.github.cukedoctor.util.Constants.newLine;
import static com.github.cukedoctor.util.Constants.Markup.bold;

import java.util.*;

import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.renderer.CukedoctorFeatureRenderer;
import com.github.cukedoctor.renderer.CukedoctorSummaryRenderer;
import com.github.cukedoctor.spi.FeatureRenderer;
import com.github.cukedoctor.spi.SummaryRenderer;
import com.github.cukedoctor.util.Constants;
import com.github.cukedoctor.util.FileUtil;


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
	private CukedoctorConfig cukedoctorConfig;


	public CukedoctorConverterImpl(List<Feature> features, DocumentAttributes attrs) {
		this(features,attrs,new CukedoctorConfig());
	}

	public CukedoctorConverterImpl(List<Feature> features, DocumentAttributes attrs, CukedoctorConfig cukedoctorConfig) {
		this.cukedoctorConfig = cukedoctorConfig;
		this.features = features;
		Collections.sort(this.features);
		this.documentAttributes = attrs;
		docBuilder = CukedoctorDocumentBuilder.Factory.newInstance();
		i18n = I18nLoader.newInstance(features);
		loadRenderers();

	}

	private void loadRenderers() {
		ServiceLoader<SummaryRenderer> summaryRenderers = ServiceLoader.load(SummaryRenderer.class);
		ServiceLoader<FeatureRenderer> featureRenderers = ServiceLoader.load(FeatureRenderer.class);

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
		System.setProperty(Constants.STOP_WATCH,String.valueOf(System.currentTimeMillis()));
		docBuilder = CukedoctorDocumentBuilder.Factory.newInstance();
		addCustomPdfTheme();//needs to be added before renderAttributes because it adds pdf-style doc attr
		renderAttributes();
		docBuilder.newLine();
		docBuilder.documentTitle(bold(getDocumentationTitle()));
		renderIntro();
		if(!cukedoctorConfig.isHideSummarySection()){
			renderSummary();
		}else{
			docBuilder.newLine();
		}
		renderFeatures(features);

		return docBuilder.toString();
	}

	private void renderIntro() {
		List<String> files = FileUtil.findFiles(cukedoctorConfig.getIntroChapterDir(), "cukedoctor-intro.adoc",true, cukedoctorConfig.getIntroChapterRelativePath());
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
			return Constants.DOCUMENT_TITLE;
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
					.sourceHighlighter(documentAttributes.getSourceHighlighter())
					.tocLevels(documentAttributes.getTocLevels())
					.revNumber(documentAttributes.getRevNumber())
					.hardBreaks(documentAttributes.isHardBreaks())
					.chapterLabel(documentAttributes.getChapterLabel())
					.versionLabel(documentAttributes.getVersionLabel());
			if(hasText(documentAttributes.getPdfStyle())) {
				docBuilder.attributes().pdfStyle(documentAttributes.getPdfStyle());
			}
		}
		return this;
	}


	public CukedoctorConverter addCustomPdfTheme() {
		if (notNull(documentAttributes) && documentAttributes.getBackend() != null && documentAttributes.getBackend().equalsIgnoreCase("pdf")) {
			//name must be filename-theme.yml
			String pdfThemeName = "cukedoctor-pdf.yml";
			//search theme.yml
			List<String> files = FileUtil.findFiles(cukedoctorConfig.getCustomizationDir(), pdfThemeName, true);
			if(hasElements(files)){
				String themePath = files.get(0);
				themePath = themePath.replaceAll("\\\\","/");
				documentAttributes.pdfStyle(themePath);
			}
		}
		return this;
	}

	@Override
	public CukedoctorConverter addCustomCss() {
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
		docBuilder.append(featureRenderer.renderFeatures(features));
		return this;
	}

	@Override
	public CukedoctorConverter renderFeatures() {
		return this.renderFeatures(features);
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
