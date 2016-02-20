package com.github.cukedoctor.i18n;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.util.FileUtil;

import java.io.*;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.github.cukedoctor.util.Assert.hasText;

/**
 * This class is responsible for internationalization.
 * <p>
 * It uses features language to determine in which language the documentation will be generated.
 * </p>
 * Created by pestano on 19/02/16.
 */
public class I18nLoader {

    private static I18nLoader instance;
    private static Logger log = Logger.getLogger(I18nLoader.class.getName());

    private ResourceBundle bundle;


    private I18nLoader() {

    }

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
        if (lang != null) {
            try {
                bundle = ResourceBundle.getBundle("cukedoctor", Locale.forLanguageTag(lang), new UTF8Control());
            } catch (MissingResourceException e) {
                log.warning(String.format("No resource bundle found for language %s. Using 'cukedoctor_en.properties' as default bundle.", lang));
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

    public static class UTF8Control extends ResourceBundle.Control {
        public java.util.ResourceBundle newBundle
                (String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
                throws IllegalAccessException, InstantiationException, IOException {
            // The below code is copied from default Control#newBundle() implementation.
            // Only the PropertyResourceBundle line is changed to read the file as UTF-8.

            String bundleName = toBundleName(baseName, locale);
            String resourceName = toResourceName(bundleName, "properties");
            java.util.ResourceBundle bundle = null;
            //client applications may provide a custom bundle
            InputStream stream = getBundleFromTargetTestFolder();
            if (stream == null) {
                stream = loader.getResourceAsStream(resourceName);
            }
            if (stream != null) {
                try {
                    bundle = new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));
                } finally {
                    stream.close();
                }
            }
            return bundle;
        }

        /**
         * looks for a file named cukedoctor.properties in target/test-classes
         *
         * client applications just need to have src/test/resources/cukedoctor.properties
         *
         * @return
         */
        private InputStream getBundleFromTargetTestFolder() {
            List<String> files = FileUtil.findFiles("/target", new String[]{"**/*cukedoctor.properties"});
            if(files != null && !files.isEmpty()){
                String path = files.get(0);
                log.fine("Loading cukedoctor resource bundle from: " + path);
                File file = new File(path);
                try {
                    return new FileInputStream(file);
                } catch (Exception e) {
                    log.log(Level.WARNING, "Could not load resource bundle from target folder", e);
                }
            }
            return null;
        }

    }
}