package com.github.cukedoctor;

import static com.github.cukedoctor.util.Assert.hasElements;

import java.util.List;

import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.converter.CukedoctorConverterImpl;

/**
 * Created by pestano on 10/06/15.
 *
 * Factory of Cukedoctor converter
 *
 */
public class Cukedoctor {

	/**
	 * @param features      used to generate the documentation
	 * @param attrs         document attributes
	 * @return a Cukedoctor converter instance
	 */
	public static CukedoctorConverter instance(List<Feature> features, DocumentAttributes attrs) {

		if (!hasElements(features)) {
			throw new RuntimeException("No features found");
		}


		CukedoctorConverter instance = new CukedoctorConverterImpl(features,attrs);

		instance.setFilename(instance.getDocumentationTitle().replaceAll(" ", "_") + ".adoc");//by default use documentTitle as filename

		return instance;
	}


	/**
	 * @param features used to generate the documentation
	 * @return a Cukedoctor converter instance
	 */
	public static CukedoctorConverter instance(List<Feature> features) {

		return instance(features, null);
	}


}
