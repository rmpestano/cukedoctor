package com.github.cukedoctor.config;

import com.github.cukedoctor.api.DocumentAttributes;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

/**
 * Created by pestano on 20/10/16.
 *
 * Cukedoctor default configuration loaded from a global cukedoctor.yaml file.
 *
 * It holds (global) static configuration which is used in {@link CukedoctorConfig}
 */
public class GlobalConfig {


    private static GlobalConfig instance;

    private DocumentAttributes documentAttributes;

    private LayoutConfig layoutConfig;

    private GlobalConfig() {
    }

    public static GlobalConfig getInstance() {
        if (instance == null) {
            instance = createInstance();
        }

        return instance;
    }

    public static GlobalConfig newInstance() {

        return createInstance();
    }

    private static GlobalConfig createInstance() {
        GlobalConfig globalConfig = null;

        //try to instance user provided cukedoctor.yml
        InputStream customConfiguration = Thread.currentThread().getContextClassLoader().getResourceAsStream("cukedoctor.yml");
        if (customConfiguration != null) {
            globalConfig = new Yaml().loadAs(customConfiguration, GlobalConfig.class);
        }

        if (globalConfig == null) {
            //default config
            globalConfig = new Yaml().loadAs(GlobalConfig.class.getResourceAsStream("/config/cukedoctor.yml"), GlobalConfig.class);
        }
        return globalConfig;
    }

    public DocumentAttributes getDocumentAttributes() {
        return documentAttributes;
    }

    public void setDocumentAttributes(DocumentAttributes documentAttributes) {
        this.documentAttributes = documentAttributes;
    }

    public LayoutConfig getLayoutConfig() {
        return layoutConfig;
    }

    public void setLayoutConfig(LayoutConfig layoutConfig) {
        this.layoutConfig = layoutConfig;
    }

}