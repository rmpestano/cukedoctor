package com.github.cukedoctor.config;

import com.github.cukedoctor.converter.CukedoctorConverterImpl;
import com.github.cukedoctor.util.Constants;

import java.io.Serializable;
import java.util.List;

import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.DISABLE_ALL_EXT_KEY;
import static com.github.cukedoctor.extension.CukedoctorExtensionRegistry.MINMAX_DISABLE_EXT_KEY;
import static com.github.cukedoctor.util.Assert.hasText;
import static com.github.cukedoctor.util.Constants.getBooleanProperty;
import static com.github.cukedoctor.util.Constants.getProp;
import static java.lang.System.getProperty;

/**
 * Created by pestano on 22/06/15.
 *
 * Cukedoctor configuration, each Cukedoctor Converter ({@link com.github.cukedoctor.Cukedoctor#instance(List)}) instance holds a config instance.
 *
 * For Documentation based attributes see {@link com.github.cukedoctor.api.DocumentAttributes}
 *
 */
public class CukedoctorConfig implements Serializable {


    private Integer errorMessageSize; //stacktrace error messages size to show when a step fails
    private String introChapterDir; //base dir to search for intro chapter cukedoctor-intro.adoc file
    private String customizationDir; //base dir to search for cukedoctor.css and pdf theme files
    private String introChapterRelativePath;
    private Boolean hideFeaturesSection;
    private Boolean hideStepTime;
    private Boolean hideSummarySection;
    private Boolean hideScenarioKeyword;
    private Boolean hideTags;
    private Boolean disableMinMaxExtension;

    public CukedoctorConfig() {
        errorMessageSize = getProp("ERROR_MESSAGE_SIZE", Integer.class);
        if(errorMessageSize == null) {
            errorMessageSize = GlobalConfig.getInstance().getLayoutConfig().getErrorMessageLength();
        }

        introChapterDir = getProperty("INTRO_CHAPTER_DIR");
        if(!hasText(introChapterDir)){
            introChapterDir = Constants.BASE_DIR;
        }

        customizationDir = getProperty("CUKEDOCTOR_CUSTOMIZATION_DIR");
        if(!hasText(customizationDir)) {
            customizationDir = Constants.BASE_DIR;
        }

        hideSummarySection = getBooleanProperty("HIDE_SUMMARY_SECTION");
        if(hideSummarySection == null) {
            hideSummarySection = GlobalConfig.getInstance().getLayoutConfig().isHideSummarySection();
        }

        hideFeaturesSection = getBooleanProperty("HIDE_FEATURES_SECTION");
        if(hideFeaturesSection == null) {
            hideFeaturesSection = GlobalConfig.getInstance().getLayoutConfig().isHideFeaturesSection();
        }

        hideStepTime = getBooleanProperty("HIDE_STEP_TIME");
        if(hideStepTime == null) {
            hideStepTime = GlobalConfig.getInstance().getLayoutConfig().isHideStepTime();
        }

        hideScenarioKeyword = getBooleanProperty("HIDE_SCENARIO_KEYWORD");
        if(hideScenarioKeyword == null) {
            hideScenarioKeyword = GlobalConfig.getInstance().getLayoutConfig().isHideScenarioKeyword();
        }

        hideTags = getBooleanProperty("HIDE_TAGS");
        if(hideTags == null) {
            hideTags = GlobalConfig.getInstance().getLayoutConfig().isHideTags();
        }

        introChapterRelativePath = getProperty("INTRO_CHAPTER_RELATIVE_PATH");

        disableMinMaxExtension = (getProperty(MINMAX_DISABLE_EXT_KEY) != null || getProperty(DISABLE_ALL_EXT_KEY) != null);

    }


    public Integer getErrorMessageSize() {
        return errorMessageSize;
    }

    public String getIntroChapterDir() {
        return introChapterDir;
    }

    public String getCustomizationDir() {
        return customizationDir;
    }

    public Boolean isHideFeaturesSection() {
        return hideFeaturesSection;
    }

    public Boolean isHideStepTime() {
        return hideStepTime;
    }

    public Boolean isHideSummarySection() {
        return hideSummarySection;
    }

    public Boolean isHideScenarioKeyword() {
        return hideScenarioKeyword;
    }

    public Boolean isHideTags() {
        return hideTags;
    }

    public Boolean isDisableMinMaxExtension() {
        return disableMinMaxExtension;
    }

    /**
     * Path to be used as relative when looking for introChapterAdoc see {@link CukedoctorConverterImpl#renderIntro()}.
     *
     * used by com.github.cukedoctor.util.{@link com.github.cukedoctor.util.FileUtil#findFiles(String, String, boolean, String)}
     *
     */
    public String getIntroChapterRelativePath() {
        return introChapterRelativePath;
    }


    public CukedoctorConfig setCustomizationDir(String customizationDir) {
        this.customizationDir = customizationDir;
        return this;
    }

    public CukedoctorConfig setDisableMinMaxExtension(Boolean disableMinMaxExtension) {
        this.disableMinMaxExtension = disableMinMaxExtension;
        return this;
    }

    public CukedoctorConfig setHideScenarioKeyword(Boolean hideScenarioKeyword) {
        this.hideScenarioKeyword = hideScenarioKeyword;
        return this;
    }

    public CukedoctorConfig setErrorMessageSize(Integer errorMessageSize) {
        this.errorMessageSize = errorMessageSize;
        return this;
    }

    public CukedoctorConfig setIntroChapterDir(String introChapterDir) {
        this.introChapterDir = introChapterDir;
        return this;
    }

    public CukedoctorConfig setIntroChapterRelativePath(String introChapterRelativePath) {
        this.introChapterRelativePath = introChapterRelativePath;
        return this;
    }

    public CukedoctorConfig setHideFeaturesSection(Boolean hideFeaturesSection) {
        this.hideFeaturesSection = hideFeaturesSection;
        return this;
    }

    public CukedoctorConfig setHideStepTime(Boolean hideStepTime) {
        this.hideStepTime = hideStepTime;
        return this;
    }

    public CukedoctorConfig setHideSummarySection(Boolean hideSummarySection) {
        this.hideSummarySection = hideSummarySection;
        return this;
    }

    public CukedoctorConfig setHideTags(Boolean hideTags) {
        this.hideTags = hideTags;
        return this;
    }

}
