package com.github.cukedoctor;

import com.github.cukedoctor.api.DocWriter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.CukedoctorReporter;
import com.github.cukedoctor.reporter.CukedoctorReporterImpl;
import com.github.cukedoctor.util.DocWriterImpl;

import java.util.List;

/**
 * Created by pestano on 10/06/15.
 *
 * Factory of Cukedoctor reporter
 *
 */
public class Cukedoctor {

	/**
	 * @param features      used to generate the documentation
	 * @param documentTitle first section (H1) documentTitle
	 * @param attrs         document attributes
	 * @return a Cukedoctor reporter instance
	 */
	public static CukedoctorReporter instance(List<Feature> features, String documentTitle, DocumentAttributes attrs) {

		if (features == null || features.isEmpty()) {
			throw new RuntimeException("No features found");
		}

		if (documentTitle == null || "".equals(documentTitle.trim())) {
			throw new RuntimeException("Provide document title");
		}

		if (attrs == null) {
			attrs = new DocumentAttributes();
		}
		if (attrs.getDocTitle() == null) {
			attrs.docTitle(documentTitle); //use documentTitle as docTitle attr if no title is provided
		}
		StringBuilder documentation = new StringBuilder();
		DocWriter<StringBuilder> writer = DocWriterImpl.getInstance(documentation);

		CukedoctorReporter instance = new CukedoctorReporterImpl(features,attrs,documentTitle,writer);

		return instance;
	}

	/**
	 * @param features used to generate the documentation
	 * @param title    first section (H1) documentTitle
	 * @return a Cukedoctor reporter instance
	 */
	public static CukedoctorReporter instance(List<Feature> features, String title) {

		return instance(features, title, new DocumentAttributes());
	}

}
