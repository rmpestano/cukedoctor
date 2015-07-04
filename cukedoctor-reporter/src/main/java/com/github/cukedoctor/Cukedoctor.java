package com.github.cukedoctor;

import com.github.cukedoctor.api.DocWriter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.CukedoctorReporter;
import com.github.cukedoctor.reporter.CukedoctorReporterImpl;
import com.github.cukedoctor.util.DocWriterImpl;

import java.util.List;

import static com.github.cukedoctor.util.Assert.*;

/**
 * Created by pestano on 10/06/15.
 *
 * Factory of Cukedoctor reporter
 *
 */
public class Cukedoctor {

	/**
	 * @param features      used to generate the documentation
	 * @param attrs         document attributes
	 * @return a Cukedoctor reporter instance
	 */
	public static CukedoctorReporter instance(List<Feature> features, DocumentAttributes attrs) {

		if (!hasElements(features)) {
			throw new RuntimeException("No features found");
		}

		if (attrs == null) {
			attrs = new DocumentAttributes();
		}

		if (!hasText(attrs.getDocTitle())) {
			 attrs.docTitle("Living Documentation");
		}


		StringBuilder documentation = new StringBuilder();
		DocWriter<StringBuilder> writer = DocWriterImpl.getInstance(documentation);

		CukedoctorReporter instance = new CukedoctorReporterImpl(features,attrs,writer);
		instance.setFilename(attrs.getDocTitle().replaceAll(" ", "_") + ".adoc");//by default use documentTitle as filename

		return instance;
	}

	/**
	 * @param features used to generate the documentation
	 * @return a Cukedoctor reporter instance
	 */
	public static CukedoctorReporter instance(List<Feature> features) {

		return instance(features, new DocumentAttributes());
	}

}
