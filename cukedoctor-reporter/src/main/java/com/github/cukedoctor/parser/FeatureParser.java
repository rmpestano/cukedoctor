package com.github.cukedoctor.parser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.cukedoctor.api.model.Feature;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pestano on 04/06/15.
 */
public class FeatureParser {
	static final Logger log = Logger.getLogger(FeatureParser.class.getName());

	public static List<Feature> parse(String json) {
		InputStreamReader is = null;
		List<Feature> features = null;
		try {
			is = new InputStreamReader(new FileInputStream(json),"UTF-8");
			features = new ObjectMapper().readValue(is, new TypeReference<List<Feature>>() {
			});
			Iterator<Feature> it = features.iterator();
			while (it.hasNext()) {
				Feature feature = it.next();
				if (!feature.isCucumberFeature()) {
					log.warning("json:" + json + " is NOT a Cucumber feature result file and will be ignored");
					it.remove();
				}else{
					feature.initScenarios();
					feature.processSteps();
				}
			}

		} catch (FileNotFoundException e) {
			log.log(Level.SEVERE, "Could not find json file:" + json, e);
		} catch (JsonMappingException e) {
			log.log(Level.SEVERE, "Could map json file:" + json, e);
		} catch (JsonParseException e) {
			log.log(Level.SEVERE, "Could not parse json file:" + json, e);
		} catch (IOException e) {
			log.log(Level.SEVERE, "Could not read json file:" + json, e);
		}
		if(features != null){
			sortFeatures(features);
		}

		return features;
	}

	private static void sortFeatures(List<Feature> features) {
		if(features != null) {
			Collections.sort(features, new Comparator<Feature>() {
				@Override
				public int compare(Feature f1, Feature f2) {
					return f1.getName().toLowerCase().compareTo(f2.getName().toLowerCase());
				}
			});
		}
	}

	public static List<Feature> parse(List<String> paths) {
		List<Feature> features = new ArrayList<>();

		for (String path : paths) {
			List<Feature> result = parse(path);
			if (result != null) {
				features.addAll(result);
			}
		}
		sortFeatures(features);
		return features;
	}

	public static List<Feature> parse(String... paths) {
		List<Feature> features = new ArrayList<>();

		for (String path : paths) {
			List<Feature> result = parse(path);
			if (result != null) {
				features.addAll(result);
			}
		}
		sortFeatures(features);

		return features;
	}
}
