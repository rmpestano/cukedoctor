package com.github.cukedoctor.converter;

import com.github.cukedoctor.api.*;
import com.github.cukedoctor.api.model.*;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.i18n.I18nLoader;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.Formatter;

import java.io.File;
import java.util.List;

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

	private ScenarioTotalizations scenarioTotalizations;

	public CukedoctorConverterImpl(List<Feature> features, DocumentAttributes attrs) {
		this.features = features;
		this.documentAttributes = attrs;
		docBuilder = CukedoctorDocumentBuilder.Factory.newInstance();
		i18n = I18nLoader.newInstance(features);
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
	public String renderDocumentation() {
		docBuilder = CukedoctorDocumentBuilder.Factory.newInstance();
		renderAttributes();
		docBuilder.newLine();
		docBuilder.documentTitle(bold(getDocumentationTitle()));
		renderSummary();
		docBuilder.newLine();
		docBuilder.sectionTitleLevel1(bold(i18n.getMessage("title.features"))).newLine();
		renderFeatures(features);
		//generateDocInfo();
		//generatePdfTheme();

		return docBuilder.toString();
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

	public CukedoctorConverterImpl renderSummary() {
		docBuilder.textLine(H2(bold(i18n.getMessage("title.summary"))));

		//TODO convert to AsciidocMarkupBuilder
		docBuilder.append("[cols=\"12*^m\", options=\"header,footer\"]",newLine(),
				"|===", newLine() +
				"3+|Scenarios 7+|Steps 2+|", i18n.getMessage("title.features"),": ", features.size() +
				"", newLine() , newLine() +
				"|[green]#*",i18n.getMessage("result.passed"),"*#" , newLine() ,
				"|[red]#*",i18n.getMessage("result.failed"),"*#" , newLine() ,
				"|Total" , newLine() ,
				"|[green]#*", i18n.getMessage("result.passed"),"*#" , newLine() ,
				"|[red]#*",i18n.getMessage("result.failed"),"*#" , newLine() ,
				"|[purple]#*",i18n.getMessage("result.skipped"),"*#" , newLine() ,
				"|[maroon]#*",i18n.getMessage("result.pending"),"*#" , newLine() ,
				"|[yellow]#*",i18n.getMessage("result.undefined"),"*#" , newLine() ,
				"|[blue]#*",i18n.getMessage("result.missing"),"*#" , newLine() ,
				"|Total" , newLine() ,
				"|Duration" , newLine(),
				"|Status" ).newLine();


		scenarioTotalizations = new ScenarioTotalizations();
		for (Feature feature : features) {
			scenarioTotalizations.addFeatureTotals(feature);
			//TODO convert to AsciidocMarkupBuilder
			docBuilder.append(newLine(), "12+^", tableCol(), "*<<", feature.getName().replaceAll(",", "").replaceAll(" ", "-"), ">>*", newLine());
			StepResults stepResults = feature.getStepResults();
			ScenarioResults scenarioResults = feature.getScenarioResults();

			docBuilder.append(tableCol(), scenarioResults.getNumberOfScenariosPassed(), newLine());
			docBuilder.append(tableCol(), scenarioResults.getNumberOfScenariosFailed(), newLine());
			docBuilder.append(tableCol(), scenarioResults.getNumberOfScenarios(), newLine());
			docBuilder.append(tableCol(), stepResults.getNumberOfPasses(), newLine());
			docBuilder.append(tableCol(), stepResults.getNumberOfFailures(), newLine());
			docBuilder.append(tableCol(), stepResults.getNumberOfSkipped(), newLine());
			docBuilder.append(tableCol(), stepResults.getNumberOfPending(), newLine());
			docBuilder.append(tableCol(), stepResults.getNumberOfUndefined(), newLine());
			docBuilder.append(tableCol(), stepResults.getNumberOfMissing(), newLine());
			docBuilder.append(tableCol(), stepResults.getNumberOfSteps(), newLine());
			docBuilder.append(tableCol(), stepResults.getTotalDurationAsString(), newLine());
			docBuilder.append(tableCol(), Status.getStatusColor(feature.getStatus()), newLine());
		}
		//TODO render totals inside above for loop to avoid additional iteration over all features
		renderTotalsRow();
		docBuilder.textLine(table());
		return this;
	}


	//should be only called inside renderSummary()
	public CukedoctorConverterImpl renderTotalsRow() {
		if(scenarioTotalizations == null){//when calling this method directly it will be zero but when redering documentation it will be already calculated
			scenarioTotalizations = new ScenarioTotalizations(features);

		}
		docBuilder.append("12+^|*Totals*", newLine()).
				append(tableCol(), scenarioTotalizations.getTotalPassedScenarios(), tableCol(), scenarioTotalizations.getTotalFailedScenarios()).
				append(tableCol(), scenarioTotalizations.getTotalScenarios()).
				append(tableCol(), scenarioTotalizations.getTotalPassedSteps(), tableCol(), scenarioTotalizations.getTotalFailedSteps()).
				append(tableCol(), scenarioTotalizations.getTotalSkippedSteps(), tableCol(), scenarioTotalizations.getTotalPendingSteps()).
				append(tableCol(), scenarioTotalizations.getTotalUndefinedSteps(), tableCol(), scenarioTotalizations.getTotalMissingSteps()).
				append(tableCol(), scenarioTotalizations.getTotalSteps(), " 2+", tableCol(), Formatter.formatTime(scenarioTotalizations.getTotalDuration()));
		docBuilder.newLine();
		return this;
	}

	public CukedoctorConverter renderFeatures(List<Feature> features) {
		for (Feature feature : features) {
			renderFeature(feature);
		}
		return this;
	}


	public CukedoctorConverterImpl renderFeature(Feature feature) {
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

    public CukedoctorConverterImpl renderFeatureScenarios(Feature feature) {
        for (Scenario scenario : feature.getScenarios()) {
            if (scenario.hasIgnoreDocsTag()) {
                continue;
            }

            if (hasText(scenario.getName())) {
                docBuilder.sectionTitleLevel3(new StringBuilder(scenario.getKeyword()).
                        append(": ").append(scenario.getName()).toString());
            }
            if (feature.hasTags() || scenario.hasTags()) {
                renderScenarioTags(feature, scenario);
                docBuilder.newLine();
            }

            docBuilder.textLine(scenario.getDescription()).newLine();

            if (scenario.hasExamples()) {
                renderScenarioExamples(scenario);
                //it has examples OR steps
                continue;
            }

            if (scenario.hasSteps()) {
                renderScenarioSteps(scenario.getSteps());
			}

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

	public CukedoctorConverterImpl renderScenarioSteps(List<Step> steps) {
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
