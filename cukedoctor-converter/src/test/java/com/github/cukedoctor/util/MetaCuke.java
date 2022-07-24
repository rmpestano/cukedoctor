package com.github.cukedoctor.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;

public class MetaCuke {
  private final LinkedList<File> featureFiles = new LinkedList<>();
  private File featureDirectory;
  private File reportFile;

  public MetaCuke() throws IOException {
    featureDirectory = Files.createTempDirectory("Features").toFile();
    featureDirectory.deleteOnExit();
  }

  public void setUp() throws IOException {
    featureFiles.clear();
    reportFile = createTempFile("Report", ".json");
  }

  public void addFeature(String featureText) throws IOException {
    File featureFile = createTempFile("Scenario", ".feature");
    writeFeatureToFile(featureText, featureFile);
    featureFiles.add(featureFile);
  }

  public <T> void runCucumber(Class<T> stepDefs) {
    runCucumber(stepDefs.getPackage().getName());
  }

  public void runCucumber(String stepDefinitionPath) {
    io.cucumber.core.cli.Main.run(
        new String[] {
          "--glue",
          stepDefinitionPath,
          // The below lines are helpful for debugging, but severely confuse general test output
          //  "--plugin",
          //  "pretty",
          "--plugin",
          "json:" + reportFile.getAbsolutePath(),
          featureDirectory.getAbsolutePath(),
        },
        Thread.currentThread().getContextClassLoader());
  }

  public File getReport() {
    return reportFile;
  }

  public void tearDown() throws IOException {
    for (File feature : featureFiles) {
      Files.deleteIfExists(feature.toPath());
    }

    Files.deleteIfExists(reportFile.toPath());
  }

  private File createTempFile(String prefix, String suffix) throws IOException {
    File tempFile = File.createTempFile(prefix, suffix, featureDirectory);
    tempFile.deleteOnExit();
    return tempFile;
  }

  private static void writeFeatureToFile(String featureText, File featureFile) throws IOException {
    FileWriter fileWriter = new FileWriter(featureFile);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    bufferedWriter.write(featureText);
    bufferedWriter.close();
    fileWriter.close();
  }
}
