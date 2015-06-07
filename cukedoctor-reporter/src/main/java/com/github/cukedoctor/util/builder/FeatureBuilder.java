package com.github.cukedoctor.util.builder;

import com.github.cukedoctor.api.model.Element;
import com.github.cukedoctor.api.model.Feature;

import java.util.ArrayList;

/**
 * Created by pestano on 04/06/15.
 */
public class FeatureBuilder {

	private Feature feature;
	private static FeatureBuilder instance;


	private FeatureBuilder(Feature feature) {
		this.feature = feature;
	}

	private Feature getFeature() {
		return feature;
	}

	public static synchronized FeatureBuilder instance() {
		instance = new FeatureBuilder(new Feature());
		return instance;
	}


	public FeatureBuilder id(String id) {
		feature.setId(id);
		return instance;
	}

	public FeatureBuilder name(String name) {
		feature.setName(name);
		return instance;
	}

	public FeatureBuilder uri(String uri) {
		feature.setUri(uri);
		return instance;
	}

	public FeatureBuilder description(String desc) {
		feature.setDescription(desc);
		return instance;
	}

	public FeatureBuilder scenario(Element scenario){
		if(feature.getElements() == null){
			feature.setElements(new ArrayList<Element>());
		}
		feature.getElements().add(scenario);
		return instance;
	}

	public FeatureBuilder keyword(String keyword) {
		feature.setKeyword(keyword);
		return instance;
	}

	public Feature build() {
		feature.initScenarios();
		return instance.getFeature();
	}

}
