package com.github.cukedoctor;

import static com.github.cukedoctor.util.Assert.hasElements;

import java.util.List;

import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.config.CukedoctorConfig;
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
	 * @param cukedoctorConfig Cukedoctor configuration
	 * @return a Cukedoctor converter instance
	 */
	public static CukedoctorConverter instance(List<Feature> features, DocumentAttributes attrs, CukedoctorConfig cukedoctorConfig) {

		if (!hasElements(features)) {
			throw new RuntimeException("No features found");
		}

		CukedoctorConverter instance = new CukedoctorConverterImpl(features,attrs,cukedoctorConfig);

		instance.setFilename(instance.getDocumentationTitle().replaceAll(" ", "_") + ".adoc");//by default use documentTitle as filename

		return instance;
	}

	/**
	 * @param features      used to generate the documentation
	 * @param attrs         document attributes
	 * @return a Cukedoctor converter instance
	 */
	public static CukedoctorConverter instance(List<Feature> features, DocumentAttributes attrs) {
		return instance(features,attrs,new CukedoctorConfig());
	}


	/**
	 * @param features used to generate the documentation
	 * @return a Cukedoctor converter instance
	 */
	public static CukedoctorConverter instance(List<Feature> features) {

		return instance(features, null);
	}


}
