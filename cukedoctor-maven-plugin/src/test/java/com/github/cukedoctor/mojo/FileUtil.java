package com.github.cukedoctor.mojo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/** Created by pestano on 16/08/15. */
public class FileUtil {

  public static String readFileContent(File target) {
    StringBuilder content = new StringBuilder();
    try (var os = new FileInputStream(target);
        var in = new InputStreamReader(os);
        BufferedReader bufferedReader = new BufferedReader(in)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        content.append(line);
      }
    } catch (Exception ignored) {
    }
    return content.toString();
  }

  public static File loadTestFile(String fileName) {
    return new File(Paths.get("").toAbsolutePath() + "/target/docs/" + fileName);
  }

  public static String removeSpecialChars(String content) {

    return content.replaceAll(" ", "").replaceAll("\n", "").replaceAll("\t", "");
  }
}
