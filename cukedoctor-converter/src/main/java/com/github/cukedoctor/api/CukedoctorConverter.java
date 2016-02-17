package com.github.cukedoctor.api;

import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Step;

import java.util.List;

/**
 * Created by pestano on 02/06/15.
 */
public interface CukedoctorConverter {


	DocumentAttributes getDocumentAttributes();

	List<Feature> getFeatures();

	String getDocumentation();

	/**
	 * creates a string representation of the current document in Asciidoctor format
	 */
	String renderDocumentation();

	String getDocumentationTitle();

	CukedoctorConverter renderFeatures(List<Feature> features);

	CukedoctorConverter renderFeature(Feature feature);

	CukedoctorConverter renderFeatureScenarios(Feature feature);

	CukedoctorConverter renderScenarioTags(Feature feature, Scenario scenario);

	CukedoctorConverter renderScenarioSteps(List<Step> steps);

	CukedoctorConverter renderStepTable(Step step);

	CukedoctorConverter renderAttributes();

	/**
	 * Document overall summary which gathers information about all features like
	 * number of steps, execution time, total passed scenarios and so on
	 */
	CukedoctorConverter renderSummary();


	/**
	 * Row gathering all features and steps sum
	 * @return
	 */
	CukedoctorConverter renderTotalsRow();

	/**
	 * set output file name without extension (should always be .adoc or other asciidoc compatible extensions)
	 * If no filename is set then Documentation title (first H1 section) will be used as filename (underline will be used to remove spaces)
	 * The filename is used mainly for asciidoc docinfo creation.
	 * @param filename
	 */
	CukedoctorConverter setFilename(String filename);


	String getFilename();


	CukedoctorConverter generateDocInfo();

	CukedoctorConverter generatePdfTheme();

	/**
	 * saves the documentation into disk using {@link CukedoctorConverter#getFilename()}  as name (also path). Note that
	 * {@link CukedoctorConverter#renderDocumentation()} will be called and used as content to save the file.
	 */
	CukedoctorConverter saveDocumentation();

	CukedoctorConverter renderScenarioExamples(Scenario scenario);

	String renderFeatureSectionId(Feature feature);
}
