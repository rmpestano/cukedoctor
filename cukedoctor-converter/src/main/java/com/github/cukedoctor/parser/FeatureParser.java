package com.github.cukedoctor.parser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.util.FileUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Created by pestano on 04/06/15. */
public class FeatureParser {
  private static final Logger log = LoggerFactory.getLogger(FeatureParser.class);

  private FeatureParser() {}

  /**
   * @param json absolute path to cucumber json output file
   * @return list of cucumber features found in json output files
   */
  public static List<Feature> parse(String json) {
    List<Feature> features = null;
    try (InputStreamReader is =
        new InputStreamReader(new FileInputStream(json), StandardCharsets.UTF_8)) {
      features = new ObjectMapper().readValue(is, new TypeReference<>() {});
      Iterator<Feature> it = features.iterator();
      while (it.hasNext()) {
        Feature feature = it.next();
        if (!feature.isCucumberFeature()) {
          log.warn("json: {} is NOT a Cucumber feature result file and will be ignored", json);
          it.remove();
        } else {
          feature.initScenarios();
          feature.processSteps();
        }
      }

    } catch (FileNotFoundException e) {
      log.warn("Could not find json file: {}", json);
    } catch (JsonMappingException e) {
      log.warn("Could not map json file: {}", json);
    } catch (JsonParseException e) {
      log.warn("Could not parse json file: {}", json);
    } catch (IOException e) {
      log.warn("Could not read json file: {}", json);
    }

    return features;
  }

  /**
   * @param paths absolute paths to cucumber json output files
   * @return list of cucumber features found in json output files
   */
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

  /**
   * @param paths absolute paths to cucumber json output files
   * @return list of cucumber features found in json output files
   */
  public static List<Feature> parse(String... paths) {
    List<Feature> features = new ArrayList<>();

    for (String path : paths) {
      List<Feature> result = parse(path);
      if (result != null) {
        features.addAll(result);
      }
    }

    return features;
  }

  /**
   * @param basePath relative or absolute path to a directory containing cucumber json output files
   * @return list of cucumber features found in json output files
   */
  public static List<Feature> findAndParse(String basePath) {
    List<String> paths = FileUtil.findJsonFiles(basePath);
    return parse(paths);
  }
}
