package com.github.cukedoctor.renderer;

import com.github.cukedoctor.util.FileUtil;

public class Fixtures {
    public static final String onePassingOneFailing;
    public static final String embedDataDirectly;
    public static final String outline;
    public static final String invalidFeatureResult;

    static {
        onePassingOneFailing = FileUtil.findJsonFile("target/test-classes/json-output/one_passing_one_failing.json");
        embedDataDirectly = FileUtil.findJsonFile("target/test-classes/json-output/embed_data_directly.json");
        outline = FileUtil.findJsonFile("target/test-classes/json-output/outline.json");
        invalidFeatureResult = FileUtil.findJsonFile("target/test-classes/json-output/invalid_feature_result.json");
    }
}
