package com.github.cukedoctor.reporter;

import com.github.cukedoctor.api.DocWriter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.ScenarioResults;
import com.github.cukedoctor.api.StepResults;
import com.github.cukedoctor.api.model.Element;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.util.DocWriterImpl;
import com.github.cukedoctor.util.Formatter;

import java.util.List;

import static com.github.cukedoctor.util.Constants.Markup;
import static com.github.cukedoctor.util.Constants.newLine;

/**
 * Created by pestano on 02/06/15.
 */
public class CukedoctorReporterImpl implements CukedoctorReporter{


	private List<Feature> features;
	private DocumentAttributes documentAttributes;
	private String documentTitle;
	private DocWriter<StringBuilder> writer;

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


	public String createDocumentation() {
		renderAttributes();
		writer.write(newLine());
		renderSummary();
		writer.write(newLine());
		for (Feature feature : features) {
			renderFeature(feature);
		}

		return writer.getCurrentDoc().toString();
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
			if (scenario.hasTags()) {
				writer.write("[small]#tags: ");
				StringBuilder tags = new StringBuilder();
				for (Tag featureTag : feature.getTags()) {
					tags.append(featureTag.getName()).append(",");
				}
				for (Tag scenarioTag : scenario.getTags()) {
					tags.append(scenarioTag.getName()).append(",");
				}
				if (tags.indexOf(",") != -1) {//delete last comma
					tags.deleteCharAt(tags.lastIndexOf(","));
				}
				writer.write(tags.toString());
				writer.write("#", newLine(), newLine());
			}

			writer.write(scenario.getDescription());

			if (scenario.hasSteps()) {
				renderScenarioSteps(scenario.getSteps());
			}

			writer.write(newLine());
		}
		return this;
	}

	public CukedoctorReporterImpl renderScenarioSteps(List<Step> steps) {
		return this;
	}


	public CukedoctorReporterImpl renderAttributes() {
		writer.write(Markup.TOC, documentAttributes.getToc(), newLine()).
				write(Markup.BACKEND, documentAttributes.getBackend(), newLine()).
				write(Markup.DOC_TITLE, documentAttributes.getDocTitle(), newLine()).
				write(Markup.DOC_TYPE, documentAttributes.getDocType(), newLine()).
				write(Markup.ICONS, documentAttributes.getIcons(), newLine()).
				write(documentAttributes.isNumbered() ? Markup.NUMBERED : Markup.NOT_NUMBERED, true).
				write(documentAttributes.isSectAnchors() ? Markup.SECT_ANCHORS : Markup.NOT_SECT_ANCHORS, true).
				write(documentAttributes.isSectLink() ? Markup.SECT_LINK : Markup.NOT_SECT_LINK, true);
		return this;
	}


	public CukedoctorReporterImpl renderSummary() {
		writer.write(Markup.H1, documentTitle, newLine(), newLine());

		writer.write("== Summary").write(newLine());
		writer.write("[cols=\"12*^m\", options=\"header,footer\"]" + newLine() +
				"|===" + newLine() +
				"3+|Scenarios 7+|Steps 2+|Features: " + features.size() +
				"" + newLine() + newLine() +
				"|Passed" + newLine() +
				"|Failed" + newLine() +
				"|Total" + newLine() +
				"|Passed" + newLine() +
				"|Failed" + newLine() +
				"|Skipped" + newLine() +
				"|Pending" + newLine() +
				"|Undefined" + newLine() +
				"|Missing" + newLine() +
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
			writer.write(Markup.TABLE_COL, feature.getStatus(), newLine());
		}
		renderTotalsRow();
		writer.write(Markup.TABLE, newLine());
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

}
