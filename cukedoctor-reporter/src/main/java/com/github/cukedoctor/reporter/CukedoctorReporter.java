package com.github.cukedoctor.reporter;

import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.ScenarioResults;
import com.github.cukedoctor.api.StepResults;
import com.github.cukedoctor.api.model.Element;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.util.Constants;
import com.github.cukedoctor.util.DocWriter;
import com.github.cukedoctor.util.Formatter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

import static com.github.cukedoctor.util.Constants.Markup;
import static com.github.cukedoctor.util.Constants.newLine;

/**
 * Created by pestano on 02/06/15.
 */
public class CukedoctorReporter {


	private static CukedoctorReporter instance;
	private List<Feature> features;
	private StringBuilder documentation;
	private DocumentAttributes documentAttributes;
	private String documentTitle;
	private DocWriter writer;

	private CukedoctorReporter() {

	}


	/**
	 * @param features      used to generate the documentation
	 * @param documentTitle first section (H1) documentTitle
	 * @param attrs         document attributes
	 * @return a Cukedoctor reporter instance
	 */
	public synchronized static CukedoctorReporter instance(List<Feature> features, String documentTitle, DocumentAttributes attrs) {

		if (features == null || features.isEmpty()) {
			throw new RuntimeException("No features found");
		}

		if (documentTitle == null || "".equals(documentTitle.trim())) {
			throw new RuntimeException("Provide document title");
		}

		if (instance == null) {
			instance = new CukedoctorReporter();
		}
		if (attrs == null) {
			attrs = new DocumentAttributes();
		}
		if (attrs.getDocTitle() == null) {
			attrs.docTitle(documentTitle); //use documentTitle as docTitle attr if no title is provided
		}
		instance.documentAttributes = attrs;
		instance.features = features;
		instance.documentTitle = documentTitle;
		instance.documentation = new StringBuilder();
		instance.writer = DocWriter.getInstance(instance.documentation);
		return instance;
	}

	/**
	 * @param features used to generate the documentation
	 * @param title    first section (H1) documentTitle
	 * @return a Cukedoctor reporter instance
	 */
	public synchronized static CukedoctorReporter instance(List<Feature> features, String title) {

		return instance(features, title, new DocumentAttributes());
	}

	public static synchronized CukedoctorReporter getCurrentInstance() {
		if (instance == null) {
			throw new RuntimeException("There is no Cukedoctor report instance, call instance() method to createDocumentation one");
		}
		return instance;
	}


	protected DocumentAttributes getDocumentAttributes() {
		return documentAttributes;
	}

	protected List<Feature> getFeatures() {
		return features;
	}

	protected StringBuilder getDocumentation() {
		return documentation;
	}

	protected String getDocumentTitle() {
		return documentTitle;
	}

	/**
	 * creates a string representation of the current document in Asciidoctor format
	 */
	protected String createDocumentation() {
		renderAttributes();
		writer.write(newLine());
		renderSummary();
		for (Feature feature : features) {
			//renderFeature(feature);
		}

		return documentation.toString();
	}

	protected CukedoctorReporter renderFeature(Feature feature) {
		renderFeatureOverview(feature).
				renderFeatureTags(feature.getTags());
		renderFeatureScenarios(feature.getElements());
		return instance;
	}

	protected CukedoctorReporter renderFeatureScenarios(List<Element> elements) {
		throw new NotImplementedException();
	}

	protected CukedoctorReporter renderScenarioSteps(List<Step> steps) {
		throw new NotImplementedException();
	}

	protected CukedoctorReporter renderFeatureTags(List<Tag> tags) {
		throw new NotImplementedException();
	}

	protected CukedoctorReporter renderFeatureOverview(Feature feature) {
		throw new NotImplementedException();
	}

	protected CukedoctorReporter renderAttributes() {
		writer.write(Markup.TOC, documentAttributes.getToc(), newLine()).
				write(Markup.BACKEND, documentAttributes.getBackend(), newLine()).
				write(Markup.DOC_TITLE, documentAttributes.getDocTitle(), newLine()).
				write(Markup.DOC_TYPE, documentAttributes.getDocType(), newLine()).
				write(Markup.ICONS, documentAttributes.getIcons(), newLine()).
				write(documentAttributes.isNumbered() ? Markup.NUMBERED : Markup.NOT_NUMBERED, true).
				write(documentAttributes.isSectAnchors() ? Markup.SECT_ANCHORS : Markup.NOT_SECT_ANCHORS, true).
				write(documentAttributes.isSectLink() ? Markup.SECT_LINK : Markup.NOT_SECT_LINK, true);
		return instance;
	}

	/**
	 * Document overall summary which gathers information about all features like
	 * number of steps, execution time, total passed scenarios and so on
	 */
	protected CukedoctorReporter renderSummary() {
		writer.write(Markup.H1, documentTitle, newLine(),newLine());

		writer.write("== Summary").write(newLine());
		writer.write("[cols=\"12*^1\", options=\"header,footer\"]"+newLine() +
				"|==="+newLine() +
				"3+|Scenarios 7+|Steps 2+|Features: "+features.size() +
				""+newLine() + newLine() +
				"|Passed"+newLine() +
				"|Failed"+newLine() +
				"|Total"+newLine() +
				"|Passed"+newLine() +
				"|Failed"+newLine() +
				"|Skipped"+newLine() +
				"|Pending"+newLine() +
				"|Undefined"+newLine() +
				"|Missing"+newLine() +
				"|Total"+newLine() +
				"|Duration"+newLine() +
				"|Status"+newLine());

		for (Feature feature : features) {
			writer.write(newLine());
			writer.write("12+^"+Constants.Markup.TABLE_COL,"<<",feature.getName(),">>",newLine());
			StepResults stepResults = feature.getStepResults();
			ScenarioResults scenarioResults = feature.getScenarioResults();

			writer.write(Markup.TABLE_COL,scenarioResults.getNumberOfScenariosPassed(),newLine());
			writer.write(Markup.TABLE_COL,scenarioResults.getNumberOfScenariosFailed(),newLine());
			writer.write(Markup.TABLE_COL,scenarioResults.getNumberOfScenarios(),newLine());
			writer.write(Markup.TABLE_COL,stepResults.getNumberOfPasses(),newLine());
			writer.write(Markup.TABLE_COL,stepResults.getNumberOfFailures(),newLine());
			writer.write(Markup.TABLE_COL,stepResults.getNumberOfSkipped(),newLine());
			writer.write(Markup.TABLE_COL,stepResults.getNumberOfPending(),newLine());
			writer.write(Markup.TABLE_COL,stepResults.getNumberOfUndefined(),newLine());
			writer.write(Markup.TABLE_COL,stepResults.getNumberOfMissing(),newLine());
			writer.write(Markup.TABLE_COL,stepResults.getNumberOfSteps(),newLine());
			writer.write(Markup.TABLE_COL,stepResults.getTotalDurationAsString(),newLine());
			writer.write(Markup.TABLE_COL,feature.getStatus(),newLine());
		}
		renderTotalsRow();
		writer.write(Markup.TABLE,newLine());
		return instance;
	}

	//should be only called inside renderSummary()
	protected CukedoctorReporter renderTotalsRow() {
		int totalPassedScenarios = 0;
		int totalFailedScenarios = 0;
		int totalScenarios = 0;
		int totalPassedSteps = 0;
		int totalFailedSteps = 0;
		int totalSkippedSteps = 0;
		int totalPendingSteps = 0;
		int totalMissingSteps = 0;
		int totalUndefinedSteps	 = 0;
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
		writer.write("12+^|*Totals*",newLine()).
		  		write(Markup.TABLE_COL,totalPassedScenarios,Markup.TABLE_COL,totalFailedScenarios).
				write(Markup.TABLE_COL,totalScenarios).
				write(Markup.TABLE_COL, totalPassedSteps, Markup.TABLE_COL, totalFailedSteps).
				write(Markup.TABLE_COL,totalSkippedSteps,Markup.TABLE_COL, totalPendingSteps).
				write(Markup.TABLE_COL,totalUndefinedSteps,Markup.TABLE_COL,totalMissingSteps).
				write(Markup.TABLE_COL,totalSteps,Markup.TABLE_COL, Formatter.formatTime(totalDuration));
		writer.write(newLine());

		return instance;
	}


}
