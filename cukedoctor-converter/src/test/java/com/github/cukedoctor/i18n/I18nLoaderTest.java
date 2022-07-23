package com.github.cukedoctor.i18n;

import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * Created by pestano on 19/02/16.
 */
@RunWith(JUnit4.class)
public class I18nLoaderTest {

    private static List<Feature> noLanguageFeatures;
    private static List<Feature> englishFeatures;
    private static List<Feature> portugueseFeatures;
    private static List<Feature> spanishFeatures;
    private static List<Feature> frenchFeatures;
    private static List<Feature> portugueseTagFeatures;
    private static List<Feature> spanishTagFeatures;
    private static List<Feature> frenchTagFeatures;

    @BeforeClass
    public static void loadFeatures() {
        String englishFeature = FileUtil.findJsonFile("target/test-classes/json-output/i18n/english.json");
        String noLanguageFeature = FileUtil.findJsonFile("target/test-classes/json-output/outline.json");
        String portugueseFeature = FileUtil.findJsonFile("target/test-classes/json-output/i18n/portuguese.json");
        String spanishFeature = FileUtil.findJsonFile("target/test-classes/json-output/i18n/spanish.json");
        String frenchFeature = FileUtil.findJsonFile("target/test-classes/json-output/i18n/french.json");
        String portugueseTagFeature = FileUtil.findJsonFile(
                "target/test-classes/json-output/i18n/portuguese_with_tag.json");
        String spanishTagFeature = FileUtil.findJsonFile("target/test-classes/json-output/i18n/spanish_with_tag.json");
        String frenchTagFeature = FileUtil.findJsonFile("target/test-classes/json-output/i18n/french_with_tag.json");
        englishFeatures = FeatureParser.parse(englishFeature);
        portugueseFeatures = FeatureParser.parse(portugueseFeature);
        spanishFeatures = FeatureParser.parse(spanishFeature);
        frenchFeatures = FeatureParser.parse(frenchFeature);
        portugueseTagFeatures = FeatureParser.parse(portugueseTagFeature);
        spanishTagFeatures = FeatureParser.parse(spanishTagFeature);
        frenchTagFeatures = FeatureParser.parse(frenchTagFeature);
        noLanguageFeatures = FeatureParser.parse(noLanguageFeature);
        assertNotNull(englishFeatures);
        assertNotNull(portugueseFeatures);
        assertNotNull(spanishFeatures);
        assertNotNull(frenchFeatures);
        assertNotNull(portugueseTagFeatures);
        assertNotNull(spanishTagFeatures);
        assertNotNull(frenchTagFeatures);
        assertNotNull(noLanguageFeatures);
    }

    @AfterClass
    public static void resetBackToDefaultLanguage() {
        I18nLoader.newInstance(null);
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
    public void shouldLoadPortugueseBundleFromTag(){
        I18nLoader i18nLoader = I18nLoader.newInstance(portugueseTagFeatures);
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
    public void shouldLoadSpanishBundleFromTag(){
        I18nLoader i18nLoader = I18nLoader.newInstance(spanishTagFeatures);
        assertThat(i18nLoader.getMessage("title.features")).isEqualTo("Características");
        assertThat(i18nLoader.getMessage("title.summary")).isEqualTo("Resumen");
        assertThat(i18nLoader.getMessage("summary.steps")).isEqualTo("Pasos");
    }

    @Test
    public void shouldLoadFrenchBundle(){
        I18nLoader i18nLoader = I18nLoader.newInstance(frenchFeatures);
        assertThat(i18nLoader.getMessage("title.features")).isEqualTo("Fonctionnalités");
        assertThat(i18nLoader.getMessage("title.summary")).isEqualTo("Sommaire");
        assertThat(i18nLoader.getMessage("summary.steps")).isEqualTo("Étapes");
    }

    @Test
    public void shouldLoadFrenchBundleFromTag(){
        I18nLoader i18nLoader = I18nLoader.newInstance(frenchTagFeatures);
        assertThat(i18nLoader.getMessage("title.features")).isEqualTo("Fonctionnalités");
        assertThat(i18nLoader.getMessage("title.summary")).isEqualTo("Sommaire");
        assertThat(i18nLoader.getMessage("summary.steps")).isEqualTo("Étapes");
    }

    @Test
    public void shouldLoadEnglishBundleForFeaturesWithNoLanguage(){
        I18nLoader i18nLoader = I18nLoader.newInstance(noLanguageFeatures);
        assertThat(i18nLoader.getMessage("title.features")).isEqualTo("Features");
        assertThat(i18nLoader.getMessage("title.summary")).isEqualTo("Summary");
        assertThat(i18nLoader.getMessage("summary.steps")).isEqualTo("Steps");
    }
}
