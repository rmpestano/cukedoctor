package com.github.cukedoctor.api;

import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Step;

import java.util.List;

/**
 * Created by pestano on 02/06/15.
 */
public interface CukedoctorReporter {


	DocumentAttributes getDocumentAttributes();

	List<Feature> getFeatures();

	StringBuilder getDocumentation();

	String getDocumentTitle();

	/**
	 * creates a string representation of the current document in Asciidoctor format
	 */
	String renderDocumentation();

	CukedoctorReporter renderFeature(Feature feature);

	CukedoctorReporter renderFeatureScenarios(Feature feature);

	CukedoctorReporter renderScenarioTags(Feature feature, Scenario scenario);

	CukedoctorReporter renderScenarioSteps(List<Step> steps);


	CukedoctorReporter renderAttributes();

	/**
	 * Document overall summary which gathers information about all features like
	 * number of steps, execution time, total passed scenarios and so on
	 */
	CukedoctorReporter renderSummary();


	/**
	 * Row gathering all features and steps sum
	 * @return
	 */
	CukedoctorReporter renderTotalsRow();

	/**
	 * set output file name without extension (should always be .adoc or other asciidoc compatible extensions)
	 * If no filename is set then Documentation title (first H1 section) will be used as filename (underline will be used to remove spaces)
	 * The filename is used mainly for asciidoc docinfo creation.
	 * @param filename
	 */
	CukedoctorReporter setFilename(String filename);


	String getFilename();


	CukedoctorReporter generateDocInfo();

	CukedoctorReporter generatePdfTheme();

	/**
	 * saves the documentation into disk using {@link CukedoctorReporter#getFilename()}  as name (also path). Note that
	 * {@link CukedoctorReporter#renderDocumentation()} will be called and used as content to save the file.
	 */
	CukedoctorReporter saveDocumentation();

	CukedoctorReporter renderScenarioExamples(Scenario scenario);

	String renderFeatureSectionId(Feature feature);
}
