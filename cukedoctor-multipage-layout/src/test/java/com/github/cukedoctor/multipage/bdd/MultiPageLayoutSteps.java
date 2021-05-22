package com.github.cukedoctor.multipage.bdd;

import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.config.GlobalConfig;
import com.github.cukedoctor.multipage.api.MultipageConverter;
import com.github.cukedoctor.multipage.bdd.inception.InceptionMultipageSteps;
import com.github.cukedoctor.multipage.model.Page;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.MetaCuke;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class MultiPageLayoutSteps {
    private String outputFolderLocation = "target/generated-sources/bdd";
    private final MetaCuke metaCuke = new MetaCuke();
    private DocumentAttributes attrs = GlobalConfig.getInstance().getDocumentAttributes();
    private MultipageConverter multipageConverter;

    public MultiPageLayoutSteps() throws IOException {
    }

    @Before
    public void before() throws IOException {
        metaCuke.setUp();
    }

    @After
    public void after() throws IOException {
        metaCuke.tearDown();
    }

    @Given("the following feature file")
    public void theFollowingFeatureFile(String feature) throws IOException {
        metaCuke.addFeature(feature);
    }

    @And("the output folder is set to {string}")
    public void theOutputFolderIsSetToDocsGenerated(String outputFolderLocation) {
        this.outputFolderLocation = outputFolderLocation;
    }

    @When("I run the cukedoctor-multipage-layout plugin")
    public void iRunTheCukedoctorMultipageLayoutPlugin() {
        metaCuke.runCucumber(InceptionMultipageSteps.class);
        File reportFile = metaCuke.getReport();
        FileUtil.copyFile(reportFile.getAbsolutePath(), "target/test-classes/json-output/result.json");

        this.multipageConverter = MultipageConverter.builder()
                .attrs(attrs)
                .jsonFileLocation("target/test-classes/json-output/")
                .outputFolderLocation(outputFolderLocation)
                .build();

        this.multipageConverter.saveDocumentation();
    }

    @Then("I have the following files generated")
    public void iHaveTheFollowingFilesGenerated(DataTable dataTable) {
        for (String fileName : dataTable.asList()) {
            assertTrue(new File(outputFolderLocation + "/" + fileName).exists());
        }
    }

    @Given("I set the :toc: {string} attribute")
    public void iSetTheAttribute(String position) {
        attrs.toc(position);
    }

    @Then("the generated pages have the {string} meta property set")
    public void theGeneratedPagesHaveTheMetaPropertySet(String attribute) {
        for (Page page : multipageConverter.getPages()) {
            File target = new File(multipageConverter.getOutputFolderLocation() + File.separator + page.getPageTitle() + ".adoc");
            String fileContent = com.github.cukedoctor.extension.util.FileUtil.readFileContent(target);
            assertTrue(fileContent.contains(":toc:"));
        }
    }
}
