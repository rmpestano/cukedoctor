package com.github.cukedoctor.i18n;

import static com.github.cukedoctor.util.Assert.hasText;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.util.Constants;
import com.github.cukedoctor.util.FileUtil;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is responsible for internationalization.
 *
 * <p>It uses features language to determine in which language the documentation will be generated.
 * Created by pestano on 19/02/16.
 */
public class I18nLoader extends ResourceBundle.Control {

  private static I18nLoader instance;
  private static final Logger log = LoggerFactory.getLogger(I18nLoader.class);

  private ResourceBundle bundle;

  private I18nLoader() {}

  public static synchronized I18nLoader instance(List<Feature> features) {
    if (instance == null) {
      instance = new I18nLoader();
      instance.init(features);
    }
    return instance;
  }

  public static synchronized I18nLoader newInstance(List<Feature> features) {
    instance = null;
    return instance(features);
  }

  public String getMessage(String key) {
    try {
      return bundle.getString(key);
    } catch (MissingResourceException e) {
      return "??" + key + "??";
    }
  }

  public String getMessage(String key, Object... params) {
    return MessageFormat.format(getMessage(key), params);
  }

  private void init(List<Feature> features) {
    String lang = resolveFeatureLanguage(features);
    if (!hasText(lang)) {
      lang = "en";
    }
    if (lang != null && bundle == null) {
      InputStream stream = findCukedoctorProperties(Constants.BASE_DIR);
      if (stream == null) {
        String bundleName = toBundleName("/i18n/cukedoctor", Locale.forLanguageTag(lang));
        String resourceName = toResourceName(bundleName, "properties");
        stream = I18nLoader.class.getResourceAsStream(resourceName);
      }
      try {
        bundle = new PropertyResourceBundle(new InputStreamReader(stream, StandardCharsets.UTF_8));
      } catch (Exception e) {
        log.warn(
            "No resource bundle found for language {}. Using 'cukedoctor_en.properties' as default"
                + " bundle.",
            lang);
        try {
          bundle =
              new PropertyResourceBundle(
                  new InputStreamReader(
                      I18nLoader.class.getResourceAsStream("/i18n/cukedoctor_en.properties"),
                      StandardCharsets.UTF_8));
        } catch (Exception e1) {
          throw new RuntimeException("Could not find cukedoctor resource bundle", e1);
        }
      }
    }
  }

  private String resolveFeatureLanguage(List<Feature> features) {
    if (features != null) {
      for (Feature feature : features) {
        if (hasText(feature.getLanguage())) {
          return feature.getLanguage();
        }
      }
    }
    return null;
  }

  /** looks for a file named cukedoctor.properties using @baseDir as starting point */
  private InputStream findCukedoctorProperties(String baseDir) {
    List<String> files = FileUtil.findFiles(baseDir, "cukedoctor.properties", true);
    if (files != null && !files.isEmpty()) {
      String path = files.get(0);
      log.trace("Loading cukedoctor resource bundle from: {}", path);
      File file = new File(path);
      try {
        return new FileInputStream(file);
      } catch (Exception e) {
        log.warn("Could not load resource bundle from target folder", e);
      }
    }
    return null;
  }
}
