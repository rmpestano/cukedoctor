package com.github.cukedoctor.config;

/**
 * Created by pestano on 23/10/16.
 *
 * Documentation layout configuration
 */
public class LayoutConfig {

    private boolean hideFeaturesSection;

    private boolean hideSummarySection;

    private boolean hideStepTime;

    private boolean hideScenarioKeyword;

    private boolean hideTags;

    private Integer errorMessageLength; //stacktrace error messages size to show when a step fails


    public boolean isHideFeaturesSection() {
        return hideFeaturesSection;
    }

    public void setHideFeaturesSection(boolean hideFeaturesSection) {
        this.hideFeaturesSection = hideFeaturesSection;
    }

    public boolean isHideSummarySection() {
        return hideSummarySection;
    }

    public void setHideSummarySection(boolean hideSummarySection) {
        this.hideSummarySection = hideSummarySection;
    }

    public boolean isHideStepTime() {
        return hideStepTime;
    }

    public void setHideStepTime(boolean hideStepTime) {
        this.hideStepTime = hideStepTime;
    }

    public boolean isHideScenarioKeyword() {
        return hideScenarioKeyword;
    }

    public void setHideScenarioKeyword(boolean hideScenarioKeyword) {
        this.hideScenarioKeyword = hideScenarioKeyword;
    }

    public boolean isHideTags() {
        return hideTags;
    }

    public void setHideTags(boolean hideTags) {
        this.hideTags = hideTags;
    }

    public Integer getErrorMessageLength() {
        return errorMessageLength;
    }

    public void setErrorMessageLength(Integer errorMessageLength) {
        this.errorMessageLength = errorMessageLength;
    }
}
