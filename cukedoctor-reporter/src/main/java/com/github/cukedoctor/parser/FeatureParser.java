package com.github.cukedoctor.parser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.cukedoctor.api.model.Feature;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by pestano on 04/06/15.
 */
public class FeatureParser {
	static final Logger log = Logger.getLogger(FeatureParser.class.getName());

	public static List<Feature> parse(String json) {
		FileReader fr = null;
		List<Feature> features = null;
		try {
			fr = new FileReader(json);
			features = new ObjectMapper().readValue(fr, new TypeReference<List<Feature>>() {
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
		return features;
	}

	public static List<Feature> parse(List<String> paths) {
		List<Feature> features = new ArrayList<>();

		for (String path : paths) {
			List<Feature> result = parse(path);
			if (result != null) {
				features.addAll(result);
			}
		}
		return features;
	}
}
