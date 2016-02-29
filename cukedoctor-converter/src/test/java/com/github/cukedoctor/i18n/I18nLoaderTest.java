package com.github.cukedoctor.i18n;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;

/**
 * Created by pestano on 19/02/16.
 */
@RunWith(JUnit4.class)
public class I18nLoaderTest {

    private static List<Feature> englishFeatures;
    private static List<Feature> noLanguageFeatures;
    private static List<Feature> portugueseFeatures;
    private static List<Feature> spanishFeatures;



    @BeforeClass
    public static void loadFeatures() {
        String englishFeature = FileUtil.findJsonFile("target/test-classes/json-output/i18n/english.json");
        String portugueseFeature = FileUtil.findJsonFile("target/test-classes/json-output/i18n/portuguese.json");
        String spanishFeature = FileUtil.findJsonFile("target/test-classes/json-output/i18n/spanish.json");
        String noLanguageFeature = FileUtil.findJsonFile("target/test-classes/json-output/outline.json");
        englishFeatures = FeatureParser.parse(englishFeature);
        portugueseFeatures = FeatureParser.parse(portugueseFeature);
        spanishFeatures = FeatureParser.parse(spanishFeature);
        noLanguageFeatures = FeatureParser.parse(noLanguageFeature);
        assertNotNull(englishFeatures);
        assertNotNull(portugueseFeatures);
        assertNotNull(spanishFeatures);
        assertNotNull(noLanguageFeatures);
    }

    @Test
    public void shouldLoadEnglishBundle(){
        I18nLoader i18nLoader = I18nLoader.newInstance(englishFeatures);
        assertThat(i18nLoader.getMessage("title.features")).isEqualTo("Features");
        assertThat(i18nLoader.getMessage("title.summary")).isEqualTo("Summary");
        assertThat(i18nLoader.getMessage("summary.steps")).isEqualTo("Steps");
    }

    @Test
    public void shouldLoadPortugueseBundle(){
        I18nLoader i18nLoader = I18nLoader.newInstance(portugueseFeatures);
        assertThat(i18nLoader.getMessage("title.features")).isEqualTo("Funcionalidades");
        assertThat(i18nLoader.getMessage("title.summary")).isEqualTo("Resumo");
        assertThat(i18nLoader.getMessage("summary.steps")).isEqualTo("Passos");
    }

    @Test
    public void shouldLoadSpanishBundle(){
        I18nLoader i18nLoader = I18nLoader.newInstance(spanishFeatures);
        assertThat(i18nLoader.getMessage("title.features")).isEqualTo("Características");
        assertThat(i18nLoader.getMessage("title.summary")).isEqualTo("Resumen");
        assertThat(i18nLoader.getMessage("summary.steps")).isEqualTo("Pasos");
    }

    @Test
    public void shouldLoadEnglishBundleForFeaturesWithNoLanguage(){
        I18nLoader i18nLoader = I18nLoader.newInstance(noLanguageFeatures);
        assertThat(i18nLoader.getMessage("title.features")).isEqualTo("Features");
        assertThat(i18nLoader.getMessage("title.summary")).isEqualTo("Summary");
        assertThat(i18nLoader.getMessage("summary.steps")).isEqualTo("Steps");
    }
}
