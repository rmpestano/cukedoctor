package com.github.cukedoctor.api;

import com.github.cukedoctor.api.model.Element;
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
	String createDocumentation();

	CukedoctorReporter renderFeature(Feature feature);

	CukedoctorReporter renderFeatureScenarios(Feature feature);

	CukedoctorReporter renderScenarioTags(Feature feature, Element scenario);

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


}
