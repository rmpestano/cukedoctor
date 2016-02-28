package com.github.cukedoctor.converter;

import com.github.cukedoctor.api.*;
import com.github.cukedoctor.api.model.*;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.renderer.CukedoctorFeatureRenderer;
import com.github.cukedoctor.renderer.CukedoctorScenarioRenderer;
import com.github.cukedoctor.renderer.CukedoctorSummaryRenderer;
import com.github.cukedoctor.spi.FeatureRenderer;
import com.github.cukedoctor.spi.ScenarioRenderer;
import com.github.cukedoctor.spi.StepsRenderer;
import com.github.cukedoctor.spi.SummaryRenderer;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.Formatter;

import java.io.File;
import java.util.List;
import java.util.ServiceLoader;

import static com.github.cukedoctor.util.Assert.*;
import com.github.cukedoctor.util.Constants;
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
	private ScenarioRenderer scenarioRenderer;
	private StepsRenderer stepsRenderer;


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

		if(scenarioRenderers.iterator().hasNext()){
			scenarioRenderer = scenarioRenderers.iterator().next();
		}else{
			scenarioRenderer = new CukedoctorScenarioRenderer();
		}
		scenarioRenderer.setDocumentBuilder(CukedoctorDocumentBuilder.Factory.newInstance());
		scenarioRenderer.setI18n(i18n);
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
		docBuilder.newLine();
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
			renderFeature(feature);
		}
		return this;
	}


	public CukedoctorConverter renderFeature(Feature feature) {
		if(feature.hasIgnoreDocsTag()){
			return this;
		}
		docBuilder.textLine(renderFeatureSectionId(feature));
		docBuilder.sectionTitleLevel2((bold(feature.getName()))).newLine();
		if(notNull(documentAttributes) && hasText(documentAttributes.getBackend()) && documentAttributes.getBackend().toLowerCase().contains("html")) {
			//used by minimax extension @see com.github.cukedoctor.extension.CukedoctorMinMaxExtension
			docBuilder.append("minmax::",feature.getName().replaceAll(",", "").replaceAll(" ", "-")).append("[]").newLine();
		}
		if (hasText(feature.getDescription())) {
			docBuilder.sideBarBlock(feature.getDescription().trim().replaceAll("\\n", " +" + newLine()));
		}

		renderFeatureScenarios(feature);
		return this;
	}


	public String renderFeatureSectionId(Feature feature) {
		if (isNull(feature) || not(hasText(feature.getName()))) {
			return "";
		}
		//Anchor must not have blanks neither commas to work
		return "[[" + feature.getName().replaceAll(",", "").replaceAll(" ", "-") +
				", " + feature.getName() + "]]";
	}

    public CukedoctorConverter renderFeatureScenarios(Feature feature) {
        for (Scenario scenario : feature.getScenarios()) {
          scenarioRenderer.renderScenario(scenario,feature);
        }
        return this;
    }

	public CukedoctorConverter renderScenarioTags(Feature feature, Scenario scenario) {
		StringBuilder tags = new StringBuilder("[small]#tags: ");
		if (feature.hasTags()) {
			for (Tag featureTag : feature.getTags()) {
				tags.append(featureTag.getName()).append(",");
			}
		}
		if (scenario.hasTags()) {
			for (Tag scenarioTag : scenario.getTags()) {
				tags.append(scenarioTag.getName()).append(",");
			}
		}
		if (tags.indexOf(",") != -1) {//delete last comma
			tags.deleteCharAt(tags.lastIndexOf(","));
		}
		tags.append("#");
		docBuilder.textLine(tags.toString());
		return this;
	}

	public CukedoctorConverter renderScenarioSteps(List<Step> steps) {
        docBuilder.textLine("****");
		for (Step step : steps) {
            docBuilder.append(step.getKeyword(), "::", newLine());
            docBuilder.append(step.getName() + " ", Status.getStatusIcon(step.getStatus()));
            docBuilder.append(renderStepTime(step.getResult()));

			renderStepTable(step);

			if(notNull(step.getDocString()) && hasText(step.getDocString().getValue())){
                docBuilder.append(listing(), newLine(), newLine());
                docBuilder.append(step.getDocString().getValue().replaceAll("\\n", newLine()));
                docBuilder.append(newLine(), newLine(), listing(), newLine());
			}

			if (step.getResult() != null && !Status.passed.equals(step.getStatus())) {
				if (step.getResult().getErrorMessage() != null) {
                    docBuilder.append(newLine(), "IMPORTANT: ", step.getResult().getErrorMessage(), newLine());
				}
			}
		}
        docBuilder.textLine("****").newLine();
		return this;
	}

	public CukedoctorConverter renderStepTable(Step step) {
        //TODO convert to AsciidocBuilder
        docBuilder.newLine();
        if (notEmpty(step.getRows())) {
            docBuilder.newLine();
            docBuilder.append("[cols=\"" + step.getRows()[0].getCells().length + "*\", options=\"header\"]").newLine();
            docBuilder.textLine(table());
			Row header = step.getRows()[0];
			for (String col : header.getCells()) {
                docBuilder.append(tableCol(), col).newLine();
			}

			for (int i = 1; i < step.getRows().length; i++) {
				for (String cell : step.getRows()[i].getCells()) {
                    docBuilder.append(tableCol(), cell).newLine();
				}
            }
            docBuilder.textLine(table());
            docBuilder.newLine();
		}

		return this;
	}

	public String renderStepTime(Result result) {
		if (result == null || result.getDuration() == null) {
			return "";
		}
		return " [small right]#(" + Formatter.formatTime(result.getDuration()) + ")#";
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

	@Override
	public CukedoctorConverter renderScenarioExamples(Scenario scenario) {
		//TODO convert to AsciidocBuilder
		if (scenario.hasExamples()) {
			docBuilder.newLine();
			for (Example example : scenario.getExamples()) {
				docBuilder.append("." + (example.getName() == null || "".equals(example.getName()) ? "Example" : example.getName()), newLine());
				docBuilder.append("[cols=\"" + example.getRows()[0].getCells().length + "*\", options=\"header\"]", newLine());
				docBuilder.append(table(), newLine());
				Row header = example.getRows()[0];
				for (String col : header.getCells()) {
					docBuilder.append(tableCol(), col, newLine());
				}

				for (int i = 1; i < example.getRows().length; i++) {
					for (String cell : example.getRows()[i].getCells()) {
						docBuilder.append(tableCol(), cell, newLine());
					}
				}
				docBuilder.append(table(), newLine(),newLine());
			}
		}
		return this;
	}


}
