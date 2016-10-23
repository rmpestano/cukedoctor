package com.github.cukedoctor.config;

import com.github.cukedoctor.api.DocumentAttributes;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

/**
 * Created by pestano on 20/10/16.
 */
public class GlobalConfig {


    private static GlobalConfig instance;

    private DocumentAttributes documentAttributes;

    private boolean hideFeaturesSection;

    private boolean hideSummarySection;

    private boolean hideStepTime;

    private boolean hideScenarioKeyword;

    private boolean hideTags;


    private GlobalConfig() {

    }

    public static GlobalConfig getInstance() {
        if (instance == null) {
            instance = createInstance();
        }

        return instance;
    }

    private static GlobalConfig createInstance() {
        GlobalConfig globalConfig = null;

        //try to instance user provided cukedoctor.yml
        InputStream customConfiguration = Thread.currentThread().getContextClassLoader().getResourceAsStream("cukedoctor.yml");
        if (customConfiguration != null) {
            globalConfig = new Yaml().loadAs(customConfiguration, GlobalConfig.class);
        }

        if(globalConfig == null) {
            //default config
            globalConfig = new Yaml().loadAs(GlobalConfig.class.getResourceAsStream("/config/cukedoctor.yml"), GlobalConfig.class);
        }
        return globalConfig;
    }


    public boolean isHideSummarySection() {
        return hideSummarySection;
    }

    public void setHideSummarySection(boolean hideSummarySection) {
        this.hideSummarySection = hideSummarySection;
    }

    public boolean isHideFeaturesSection() {
        return hideFeaturesSection;
    }

    public void setHideFeaturesSection(boolean hideFeaturesSection) {
        this.hideFeaturesSection = hideFeaturesSection;
    }

    public DocumentAttributes getDocumentAttributes() {
        return documentAttributes;
    }

    public void setDocumentAttributes(DocumentAttributes documentAttributes) {
        this.documentAttributes = documentAttributes;
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
}
