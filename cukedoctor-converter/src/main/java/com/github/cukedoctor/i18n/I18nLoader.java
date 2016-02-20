package com.github.cukedoctor.i18n;

import com.github.cukedoctor.api.model.Feature;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import static com.github.cukedoctor.util.Assert.hasText;

/**
 * This class is responsible for internationalization.
 *
 * It uses features language to determine in which language the documentation will be generated.
 *
 * Created by pestano on 19/02/16.
 *
 */
public class I18nLoader {

    private static I18nLoader instance;

    private ResourceBundle bundle;

    private I18nLoader(){

    }

    public static synchronized I18nLoader instance(List<Feature> features){
        if (instance == null){
            instance = new I18nLoader();
            instance.init(features);
        }
        return instance;
    }

    public static synchronized I18nLoader newInstance(List<Feature> features){
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
        if(!hasText(lang)){
            lang = "en";
        }
        if(lang != null){
            try{
                bundle = ResourceBundle.getBundle("cukedoctor", Locale.forLanguageTag(lang));
            }catch (MissingResourceException e){
                Logger.getLogger(I18nLoader.class.getName()).warning(String.format("No resource bundle found for language %s. Using 'cukedoctor_en.properties' as default bundle.",lang));
            }
        }
    }

    private String resolveFeatureLanguage(List<Feature> features) {
        if (features != null){
            for (Feature feature : features) {
                if(hasText(feature.getLanguage())){
                    return feature.getLanguage();
                }
            }
        }
        return null;
    }


}
