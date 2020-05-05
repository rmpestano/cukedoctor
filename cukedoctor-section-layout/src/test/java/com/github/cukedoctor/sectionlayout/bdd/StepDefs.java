package com.github.cukedoctor.sectionlayout.bdd;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.CukedoctorDocumentBuilder;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Scenario;
import com.github.cukedoctor.api.model.Step;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.sectionlayout.SectionFeatureRenderer;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StepDefs {

    private final File introDirectory;
    private final File tempDirectory;
    private final LinkedList<Path> featureFilePaths = new LinkedList<>();
    private Path reportFilePath;
    private String renderedDocument;

    public StepDefs() throws IOException {
        introDirectory = Files.createTempDirectory("Intro").toFile();
        introDirectory.deleteOnExit();

        tempDirectory = Files.createTempDirectory("Features").toFile();
        tempDirectory.deleteOnExit();
    }

    @Before
    public void before() throws IOException {
        featureFilePaths.clear();
        reportFilePath = createTempFile("Report", ".json").toPath();
        renderedDocument = null;
    }

    @After
    public void after() throws IOException {
        for (Path path : featureFilePaths) {
            Files.deleteIfExists(path);
        }

        Files.deleteIfExists(reportFilePath);
    }


    @Given("I have the Feature")
    public void i_have_the_feature(String featureText) throws IOException {
        featureFilePaths.add(createFeatureFile(featureText));
    }

    @Given("I am hiding the Features Section")
    public void i_am_hiding_the_features_section() {
        System.setProperty("HIDE_FEATURES_SECTION", "true");
    }

    @Given("I am showing the Features Section")
    public void i_am_showing_the_features_section() {
        System.setProperty("HIDE_FEATURES_SECTION", "false");
    }

    @Given("I am hiding step timings")
    public void i_am_hiding_step_timings() {
        System.setProperty("HIDE_STEP_TIME", "true");
    }

    @Given("all Cukedoctor extensions are disabled")
    public void all_cukedoctor_extensions_are_disabled() {
        System.setProperty("cukedoctor.disable-extensions", "true");
    }

    @When("I convert the Feature")
    public void i_convert_the_feature() {
        runCucumber();
        List<Feature> features = parseFeatures();
        renderFeatures(features);
    }

    @When("I run Cukedoctor")
    public void i_run_cukedoctor() {
        runCucumber();
        List<Feature> features = parseFeatures();
        setAllStepDurationsToZero(features);
        runCukedoctor(features);
    }

    @Then("it will be rendered as a Section")
    public void it_will_be_rendered_as_a_section(String expectedDocument) {
        assetDocumentEquals(expectedDocument);
    }

    @Then("it will be rendered as a Subsection of the Features Section")
    public void it_will_be_rendered_as_a_subsection_of_the_features_section(String expectedDocument) {
        assetDocumentEquals(expectedDocument);
    }

    @Then("they will be rendered as Sections")
    public void they_will_be_rendered_as_sections(String expectedDocument) {
        assetDocumentEquals(expectedDocument);
    }

    @Then("it will be rendered as")
    public void it_will_be_rendered_in_the_section(String expectedDocument) {
        assetDocumentEquals(expectedDocument);
    }

    @Then("they will be rendered as")
    public void they_will_be_rendered_as(String expectedDocument) {
        assetDocumentEquals(expectedDocument);
    }


    private File createTempFile(String prefix, String suffix) throws IOException {
        File tempFile = File.createTempFile(prefix, suffix, tempDirectory);
        tempFile.deleteOnExit();
        return tempFile;
    }

    private Path createFeatureFile(String featureText) throws IOException {
        File featureFile = createTempFile("Scenario", ".feature");
        writeFeatureToFile(featureText, featureFile);
        return featureFile.toPath();
    }

    private static void writeFeatureToFile(String featureText, File featureFile) throws IOException {
        FileWriter fileWriter = new FileWriter(featureFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(featureText);
        bufferedWriter.close();
        fileWriter.close();
    }

    private void runCucumber() {
        io.cucumber.core.cli.Main.run(
                new String[]{
                        "--glue",
                        "com/github/cukedoctor/sectionlayout/bdd/inception",
                        // The below lines are helpful for debugging, but severely confuse general test output
                        //  "--plugin",
                        //  "pretty",
                        "--plugin",
                        "json:" + reportFilePath,
                        tempDirectory.getAbsolutePath(),
                },
                Thread.currentThread().getContextClassLoader());
    }

    public void assetDocumentEquals(String expectedDocument) {
        assertEquals(normaliseLineEndings(expectedDocument), normaliseLineEndings(renderedDocument));
    }

    private static String normaliseLineEndings(String s) {
        return s.replaceAll("\r\n|\r|\n", System.lineSeparator());
    }

    public List<Feature> parseFeatures() {
        return FeatureParser.parse(reportFilePath.toAbsolutePath().toString());
    }

    public void renderFeatures(List<Feature> features) {
        renderedDocument = new SectionFeatureRenderer().renderFeatures(features, CukedoctorDocumentBuilder.Factory.newInstance());
    }

    public void runCukedoctor(List<Feature> features) {
        CukedoctorConfig config = getConfig();
        renderedDocument = Cukedoctor.instance(features, new DocumentAttributes(), config).renderDocumentation();
    }

    private void setAllStepDurationsToZero(List<Feature> features) {
        for (Feature feature : features) {
            for (Scenario scenario : feature.getScenarios()) {
                for (Step step : scenario.getSteps()) {
                    step.getResult().setDuration(0L);
                }
            }
        }
    }

    private CukedoctorConfig getConfig() {
        CukedoctorConfig config = new CukedoctorConfig();
        // Avoid picking up intro docs in source tree
        config.setIntroChapterDir(introDirectory.getAbsolutePath());
        config.setIntroChapterRelativePath(introDirectory.getAbsolutePath());
        return config;
    }
}