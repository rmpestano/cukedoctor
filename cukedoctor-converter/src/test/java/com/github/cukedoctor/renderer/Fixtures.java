package com.github.cukedoctor.renderer;

import com.github.cukedoctor.util.FileUtil;

public class Fixtures {
  public static final String onePassingOneFailing;
  public static final String embedDataDirectly;
  public static final String outline;
  public static final String invalidFeatureResult;
  public static final String featureWithTableInStep;
  public static final String featureWithSourceDocStringInStep;
  public static final String featureWithAsterisk;

  static {
    onePassingOneFailing =
        FileUtil.findJsonFile("target/test-classes/json-output/one_passing_one_failing.json");
    embedDataDirectly =
        FileUtil.findJsonFile("target/test-classes/json-output/embed_data_directly.json");
    outline = FileUtil.findJsonFile("target/test-classes/json-output/outline.json");
    invalidFeatureResult =
        FileUtil.findJsonFile("target/test-classes/json-output/invalid_feature_result.json");
    featureWithTableInStep =
        FileUtil.findJsonFile("target/test-classes/json-output/step-with-table.json");
    featureWithSourceDocStringInStep =
        FileUtil.findJsonFile("target/test-classes/json-output/step-with-source-doc-string.json");
    featureWithAsterisk =
        FileUtil.findJsonFile("target/test-classes/json-output/feature_with_asterisk.json");
  }
}
