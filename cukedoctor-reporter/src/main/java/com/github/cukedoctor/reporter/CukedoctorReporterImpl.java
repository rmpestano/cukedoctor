package com.github.cukedoctor.reporter;

import com.github.cukedoctor.api.*;
import com.github.cukedoctor.api.model.*;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.Formatter;

import java.io.File;
import java.util.List;

import static com.github.cukedoctor.util.Constants.Markup;
import static com.github.cukedoctor.util.Constants.bold;
import static com.github.cukedoctor.util.Constants.newLine;


/**
 * Created by pestano on 02/06/15.
 */
public class CukedoctorReporterImpl implements CukedoctorReporter {


	private List<Feature> features;
	private DocumentAttributes documentAttributes;
	private String documentTitle;
	private DocWriter<StringBuilder> writer;
	private String filename;

	public CukedoctorReporterImpl(List<Feature> features, DocumentAttributes attrs, String documentTitle, DocWriter<StringBuilder> writer) {
		this.features = features;
		this.documentAttributes = attrs;
		this.documentTitle = documentTitle;
		this.writer = writer;
	}


	public DocumentAttributes getDocumentAttributes() {
		return documentAttributes;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public StringBuilder getDocumentation() {
		return writer.getCurrentDoc();
	}

	public String getDocumentTitle() {
		return documentTitle;
	}


	/**
	 * @return a String representation of generated documentation
	 */
	public String renderDocumentation() {
		writer.clear();
		renderAttributes();
		writer.write(newLine());
		writer.write(Markup.H1, bold(documentTitle), newLine(), newLine());
		renderSummary();
		writer.write(newLine(), newLine());
		writer.write(Markup.H1, bold("Features"), newLine(), newLine());
		for (Feature feature : features) {
			renderFeature(feature);
		}
		generateDocInfo();
		return writer.getCurrentDoc().toString();
	}

	public CukedoctorReporter renderAttributes() {
		writer.write(Markup.TOC, documentAttributes.getToc(), newLine()).
				write(Markup.BACKEND, documentAttributes.getBackend(), newLine()).
				write(Markup.DOC_TITLE, documentAttributes.getDocTitle(), newLine()).
				write(Markup.DOC_TYPE, documentAttributes.getDocType(), newLine()).
				write(Markup.ICONS, documentAttributes.getIcons(), newLine()).
				write(documentAttributes.isNumbered() ? Markup.NUMBERED : Markup.NOT_NUMBERED, newLine()).
				write(documentAttributes.isLinkCss() ? Markup.LINKCSS : Markup.NOT_LINKCSS, newLine()).
				write(documentAttributes.isSectAnchors() ? Markup.SECT_ANCHORS : Markup.NOT_SECT_ANCHORS, newLine()).
				write(documentAttributes.isSectLink() ? Markup.SECT_LINK : Markup.NOT_SECT_LINK, newLine()).
				write(documentAttributes.isDocInfo() ? Markup.DOCINFO : Markup.NOT_DOCINFO, newLine());
		return this;
	}

	public CukedoctorReporter generateDocInfo() {
		if (documentAttributes.isDocInfo()) {
			//name must be filename-docinfo.html
			String docInfoName = filename.substring(0, filename.lastIndexOf(".")) + "-docinfo.html";
			File savedFile = FileUtil.copyFile("docinfo.html", docInfoName);
			//docinfo depends on cukedoctor.js and cukedoctor.css
			//save js and css file in same dir as docinfo
			String basePath = "";
			if(filename.contains("/")){
				basePath = filename.substring(0,filename.lastIndexOf("/"));
			}
			FileUtil.copyFile("cukedoctor.js", basePath+"/cukedoctor.js");
			FileUtil.copyFile("cukedoctor.css", basePath+"/cukedoctor.css");

		}

		return this;
	}

	public CukedoctorReporterImpl renderSummary() {
		writer.write(Markup.H1,bold("Summary")).write(newLine());
		writer.write("[cols=\"12*^m\", options=\"header,footer\"]" + newLine() +
				"|===" + newLine() +
				"3+|Scenarios 7+|Steps 2+|Features: " + features.size() +
				"" + newLine() + newLine() +
				"|[green]#*Passed*#" + newLine() +
				"|[red]#*Failed*#" + newLine() +
				"|Total" + newLine() +
				"|[green]#*Passed*#" + newLine() +
				"|[red]#*Failed*#" + newLine() +
				"|[purple]#*Skipped*#" + newLine() +
				"|[orange]#*Pending*#" + newLine() +
				"|[yellow]#*Undefined*#" + newLine() +
				"|[blue]#*Missing*#" + newLine() +
				"|Total" + newLine() +
				"|Duration" + newLine() +
				"|Status" + newLine());

		for (Feature feature : features) {
			writer.write(newLine());
			writer.write("12+^" + Markup.TABLE_COL, "*<<", feature.getName(), ">>*", newLine());
			StepResults stepResults = feature.getStepResults();
			ScenarioResults scenarioResults = feature.getScenarioResults();

			writer.write(Markup.TABLE_COL, scenarioResults.getNumberOfScenariosPassed(), newLine());
			writer.write(Markup.TABLE_COL, scenarioResults.getNumberOfScenariosFailed(), newLine());
			writer.write(Markup.TABLE_COL, scenarioResults.getNumberOfScenarios(), newLine());
			writer.write(Markup.TABLE_COL, stepResults.getNumberOfPasses(), newLine());
			writer.write(Markup.TABLE_COL, stepResults.getNumberOfFailures(), newLine());
			writer.write(Markup.TABLE_COL, stepResults.getNumberOfSkipped(), newLine());
			writer.write(Markup.TABLE_COL, stepResults.getNumberOfPending(), newLine());
			writer.write(Markup.TABLE_COL, stepResults.getNumberOfUndefined(), newLine());
			writer.write(Markup.TABLE_COL, stepResults.getNumberOfMissing(), newLine());
			writer.write(Markup.TABLE_COL, stepResults.getNumberOfSteps(), newLine());
			writer.write(Markup.TABLE_COL, stepResults.getTotalDurationAsString(), newLine());
			writer.write(Markup.TABLE_COL, Status.getStatusColor(feature.getStatus()), newLine());
		}
		renderTotalsRow();
		writer.write(Markup.TABLE);
		return this;
	}

	//should be only called inside renderSummary()
	public CukedoctorReporterImpl renderTotalsRow() {
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
		writer.write("12+^|*Totals*", newLine()).
				write(Markup.TABLE_COL, totalPassedScenarios, Markup.TABLE_COL, totalFailedScenarios).
				write(Markup.TABLE_COL, totalScenarios).
				write(Markup.TABLE_COL, totalPassedSteps, Markup.TABLE_COL, totalFailedSteps).
				write(Markup.TABLE_COL, totalSkippedSteps, Markup.TABLE_COL, totalPendingSteps).
				write(Markup.TABLE_COL, totalUndefinedSteps, Markup.TABLE_COL, totalMissingSteps).
				write(Markup.TABLE_COL, totalSteps, " 2+", Markup.TABLE_COL, Formatter.formatTime(totalDuration));
		writer.write(newLine());

		return this;
	}

	public CukedoctorReporterImpl renderFeature(Feature feature) {
		writer.write(Markup.H2, feature.getName(), newLine(), newLine());
		if (feature.getDescription() != null && !"".equals(feature.getDescription().trim())) {
			writer.write("****", newLine()).
					//feature description has \n to delimit new lines
					write(feature.getDescription().trim().replaceAll("\\n", " +" + newLine())).
					write(newLine(), "****", newLine(), newLine());
		}


		renderFeatureScenarios(feature);
		return this;
	}

	public CukedoctorReporterImpl renderFeatureScenarios(Feature feature) {
		for (Element scenario : feature.getScenarios()) {
			writer.write(Markup.H3, scenario.getKeyword(), ": ", scenario.getName(), newLine());
			if (feature.hasTags() || scenario.hasTags()) {
				renderScenarioTags(feature, scenario);
				writer.write(newLine(), newLine());
			}

			writer.write(scenario.getDescription());

			if (scenario.hasSteps()) {
				renderScenarioSteps(scenario.getSteps());
			}

			writer.write(newLine());
		}
		return this;
	}

	public CukedoctorReporter renderScenarioTags(Feature feature, Element scenario) {
		writer.write("[small]#tags: ");
		StringBuilder tags = new StringBuilder();
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
		writer.write(tags.toString());
		writer.write("#");

		return this;
	}

	public CukedoctorReporterImpl renderScenarioSteps(List<Step> steps) {
		writer.write("****", newLine());
		for (Step step : steps) {
			writer.write(step.getKeyword(), "::", newLine());
			writer.write(step.getName()+" ", Status.getStatusIcon(step.getStatus()));
			writer.write(renderStepTime(step.getResult())).write(newLine());
			if (step.getResult() != null && !Status.passed.equals(step.getStatus())) {
				writer.write(newLine(),"IMPORTANT:",step.getResult().getErrorMessage(),newLine());
			}
		}
		writer.write("****", newLine());
		return this;
	}

	public String renderStepTime(Result result) {
		if(result == null || result.getDuration() == null){
			return "";
		}
		return " [small right]#("+Formatter.formatTime(result.getDuration())+")#";
	}


	@Override
	public CukedoctorReporter setFilename(String filename) {
		if (filename == null) {
			filename = documentTitle;
		}
		if(!filename.contains(".")){
			filename = filename + ".adoc";
		}
		filename = filename.replaceAll(" ","_");//remove blank spaces with underline

		if(!FileUtil.ADOC_FILE_EXTENSION.matcher(filename).matches()){
 			throw new RuntimeException("Invalid filename extension for file: "+filename+". Valid formats are: ad, adoc, asciidoc and asc");
		}


		this.filename = filename;
		return this;
	}

	@Override
	public String getFilename() {
		return filename;
	}

	public CukedoctorReporter saveDocumentation(){
		FileUtil.saveFile(filename,renderDocumentation());
		return this;
	}

}
