package com.github.cukedoctor.converter;

import com.github.cukedoctor.api.*;
import com.github.cukedoctor.api.model.*;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.util.DocWriterImpl;
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

	public CukedoctorConverterImpl(List<Feature> features, DocumentAttributes attrs) {
		this.features = features;
		this.documentAttributes = attrs;
		docBuilder = CukedoctorDocumentBuilder.Factory.newInstance();
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
		docBuilder.newLine().newLine();
		docBuilder.sectionTitleLevel1(bold("Features")).newLine();
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
		docBuilder.textLine(H2(bold("Summary")));

		//TODO convert to AsciidocMarkupBuilder
		String summary = DocWriterImpl.getInstance(new StringBuilder()).write("[cols=\"12*^m\", options=\"header,footer\"]" + newLine() +
				"|===" + newLine() +
				"3+|Scenarios 7+|Steps 2+|Features: " + features.size() +
				"" + newLine() + newLine() +
				"|[green]#*Passed*#" + newLine() +
				"|[red]#*Failed*#" + newLine() +
				"|Total" + newLine() +
				"|[green]#*Passed*#" + newLine() +
				"|[red]#*Failed*#" + newLine() +
				"|[purple]#*Skipped*#" + newLine() +
				"|[maroon]#*Pending*#" + newLine() +
				"|[yellow]#*Undefined*#" + newLine() +
				"|[blue]#*Missing*#" + newLine() +
				"|Total" + newLine() +
				"|Duration" + newLine() +
				"|Status" ).getCurrentDoc().toString();

		docBuilder.textLine(summary);

		DocWriter featureResultsTableWriter = DocWriterImpl.getInstance(new StringBuilder());

		for (Feature feature : features) {
			//TODO convert to AsciidocMarkupBuilder
			featureResultsTableWriter.write(newLine(),"12+^" + tableCol(), "*<<", feature.getName().replaceAll(",", "").replaceAll(" ", "-"), ">>*", newLine());
			StepResults stepResults = feature.getStepResults();
			ScenarioResults scenarioResults = feature.getScenarioResults();

			featureResultsTableWriter.write(tableCol(), scenarioResults.getNumberOfScenariosPassed(), newLine());
			featureResultsTableWriter.write(tableCol(), scenarioResults.getNumberOfScenariosFailed(), newLine());
			featureResultsTableWriter.write(tableCol(), scenarioResults.getNumberOfScenarios(), newLine());
			featureResultsTableWriter.write(tableCol(), stepResults.getNumberOfPasses(), newLine());
			featureResultsTableWriter.write(tableCol(), stepResults.getNumberOfFailures(), newLine());
			featureResultsTableWriter.write(tableCol(), stepResults.getNumberOfSkipped(), newLine());
			featureResultsTableWriter.write(tableCol(), stepResults.getNumberOfPending(), newLine());
			featureResultsTableWriter.write(tableCol(), stepResults.getNumberOfUndefined(), newLine());
			featureResultsTableWriter.write(tableCol(), stepResults.getNumberOfMissing(), newLine());
			featureResultsTableWriter.write(tableCol(), stepResults.getNumberOfSteps(), newLine());
			featureResultsTableWriter.write(tableCol(), stepResults.getTotalDurationAsString(), newLine());
			featureResultsTableWriter.write(tableCol(), Status.getStatusColor(feature.getStatus()), newLine());
		}
		//TODO render totals inside above for loop to avoid additional iteration over all features
		docBuilder.append(featureResultsTableWriter.getCurrentDoc().toString());
		renderTotalsRow();
		docBuilder.append(table());
		return this;
	}

	//should be only called inside renderSummary()
	public CukedoctorConverterImpl renderTotalsRow() {
		int totalPassedScenarios = 0;
		int totalFailedScenarios = 0;
		int totalScenarios = 0;
		int totalPassedSteps = 0;
		int totalFailedSteps = 0;
		int totalSkippedSteps = 0;
		int totalPendingSteps = 0;
		int totalMissingSteps = 0;
		int totalUndefinedSteps = 0;
		int totalSteps = 0;
		long totalDuration = 0;
		for (Feature feature : features) {
			totalPassedScenarios += feature.getScenarioResults().getNumberOfScenariosPassed();
			totalFailedScenarios += feature.getScenarioResults().getNumberOfScenariosFailed();
			totalScenarios += feature.getNumberOfScenarios();
			totalPassedSteps += feature.getStepResults().getNumberOfPasses();
			totalFailedSteps += feature.getStepResults().getNumberOfFailures();
			totalSkippedSteps += feature.getStepResults().getNumberOfSkipped();
			totalPendingSteps += feature.getStepResults().getNumberOfPending();
			totalMissingSteps += feature.getStepResults().getNumberOfMissing();
			totalUndefinedSteps += feature.getStepResults().getNumberOfUndefined();
			totalSteps += feature.getNumberOfSteps();
			totalDuration += feature.getStepResults().getTotalDuration();
		}

		DocWriter totalsTableWriter = DocWriterImpl.getInstance(new StringBuilder());

		totalsTableWriter.write("12+^|*Totals*", newLine()).
				write(tableCol(), totalPassedScenarios, tableCol(), totalFailedScenarios).
				write(tableCol(), totalScenarios).
				write(tableCol(), totalPassedSteps, tableCol(), totalFailedSteps).
				write(tableCol(), totalSkippedSteps, tableCol(), totalPendingSteps).
				write(tableCol(), totalUndefinedSteps, tableCol(), totalMissingSteps).
				write(tableCol(), totalSteps, " 2+", tableCol(), Formatter.formatTime(totalDuration));
		totalsTableWriter.write(newLine());

		docBuilder.append(totalsTableWriter.getCurrentDoc().toString());
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
			docBuilder.append(new StringBuilder("minmax::").append(feature.getName().replaceAll(",", "").replaceAll(" ", "-")).append("[]").toString()).newLine();
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

            docBuilder.textLine(scenario.getDescription());

            if (scenario.hasExamples()) {
                renderScenarioExamples(scenario);
                //it has examples OR steps
                continue;
            }

            if (scenario.hasSteps()) {
                renderScenarioSteps(scenario.getSteps());
            }

            docBuilder.newLine();
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
        docBuilder.textLine("****");
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
			DocWriter<StringBuilder> writer = DocWriterImpl.getInstance(new StringBuilder());
			writer.write(newLine());
			for (Example example : scenario.getExamples()) {
				writer.write("." + (example.getName() == null || "".equals(example.getName()) ? "Example" : example.getName()), newLine());
				writer.write("[cols=\"" + example.getRows()[0].getCells().length + "*\", options=\"header\"]", newLine());
				writer.write(table(), newLine());
				Row header = example.getRows()[0];
				for (String col : header.getCells()) {
					writer.write(tableCol(), col, newLine());
				}

				for (int i = 1; i < example.getRows().length; i++) {
					for (String cell : example.getRows()[i].getCells()) {
						writer.write(tableCol(), cell, newLine());
					}
				}
				writer.write(table(), newLine());
				docBuilder.textLine(writer.getCurrentDoc().toString());
                writer.clear();
			}
		}
		return this;
	}


}
