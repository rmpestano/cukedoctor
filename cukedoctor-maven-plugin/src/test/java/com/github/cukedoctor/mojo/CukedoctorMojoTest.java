package com.github.cukedoctor.mojo;

import static com.github.cukedoctor.mojo.FileUtil.loadTestFile;
import static com.github.cukedoctor.mojo.FileUtil.readFileContent;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import com.github.cukedoctor.util.FileUtil;

/**
 * Created by pestano on 27/06/15.
 */
public class CukedoctorMojoTest extends AbstractMojoTestCase {



    protected void setUp() throws Exception {
        super.setUp();
        System.clearProperty("cukedoctor.disable.theme");
        System.clearProperty("cukedoctor.disable.filter");
        System.clearProperty("cukedoctor.disable.minmax");
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        System.clearProperty("cukedoctor.disable.theme");
        System.clearProperty("cukedoctor.disable.filter");
        System.clearProperty("cukedoctor.disable.minmax");

    }

    /**
     * @throws Exception
     */
    public void testHtmlDocs() throws Exception {

        CukedoctorMojo mojo = (CukedoctorMojo) lookupMojo("execute", getTestFile("src/test/resources/html-docs-pom.xml"));

        assertNotNull(mojo);
        mojo.execute();
        File file = FileUtil.loadFile(mojo.getDocumentationDir() + mojo.outputFileName + ".html");
        assertThat(file).exists().hasParent("target/docs");
        assertThat(mojo.getGeneratedFile()).
                contains(":backend: html5").
                contains(":toc: left").
                contains(":numbered:");
        String docHtml = readFileContent(loadTestFile("documentation.html"));
        assertThat(docHtml).isNotEmpty().
                containsOnlyOnce("searchFeature(criteria)").
                containsOnlyOnce("function showFeatureScenarios(featureId)").
                containsOnlyOnce("function themefy()");
    }

    /**
     * @throws Exception
     */
    public void testHtmlDocsWithoutFilterExtension() throws Exception {

        CukedoctorMojo mojo = (CukedoctorMojo) lookupMojo("execute", getTestFile("src/test/resources/html-docs-no-filter-pom.xml"));

        assertNotNull(mojo);
        mojo.execute();
        File file = FileUtil.loadFile(mojo.getDocumentationDir() + mojo.outputFileName + ".html");
        assertThat(file).exists().hasParent("target/docs");
        assertThat(mojo.getGeneratedFile()).
                contains(":backend: html5").
                contains(":toc: left").
                contains(":numbered:");
        String docHtml = readFileContent(loadTestFile("documentation.html"));
        assertThat(docHtml).isNotEmpty().
                doesNotContain("searchFeature(criteria)").
                containsOnlyOnce("function showFeatureScenarios(featureId)").
                containsOnlyOnce("function themefy()");
    }

    /**
     * @throws Exception
     */
    public void testHtmlDocsWithoutThemeExtension() throws Exception {

        CukedoctorMojo mojo = (CukedoctorMojo) lookupMojo("execute", getTestFile("src/test/resources/html-docs-no-theme-pom.xml"));

        assertNotNull(mojo);
        mojo.execute();
        File file = FileUtil.loadFile(mojo.getDocumentationDir() + mojo.outputFileName + ".html");
        assertThat(file).exists().hasParent("target/docs");
        assertThat(mojo.getGeneratedFile()).
                contains(":backend: html5").
                contains(":toc: left").
                contains(":numbered:");
        String docHtml = readFileContent(loadTestFile("documentation.html"));
        assertThat(docHtml).isNotEmpty().
                containsOnlyOnce("searchFeature(criteria)").
                containsOnlyOnce("function showFeatureScenarios(featureId)").
                doesNotContain("function themefy()").
                doesNotContain("<div name=\"themes\" id=\"themes\"");
    }

    /**
     * @throws Exception
     */
    public void testHtmlDocsWithoutExtensions() throws Exception {

        CukedoctorMojo mojo = (CukedoctorMojo) lookupMojo("execute", getTestFile("src/test/resources/html-docs-no-extension-pom.xml"));

        assertNotNull(mojo);
        mojo.execute();
        File file = FileUtil.loadFile(mojo.getDocumentationDir() + mojo.outputFileName + ".html");
        assertThat(file).exists().hasParent("target/docs");
        assertThat(mojo.getGeneratedFile()).
                contains(":backend: html5").
                contains(":toc: left").
                contains(":numbered:");
        String docHtml = readFileContent(loadTestFile("documentation.html"));
        assertThat(docHtml).isNotEmpty().
                doesNotContain("searchFeature(criteria)").
                doesNotContain("function showFeatureScenarios(featureId)").
                doesNotContain("function themefy()");
    }


    /**
     * @throws Exception
     */
    public void testPdfDocs() throws Exception {

        CukedoctorMojo mojo = (CukedoctorMojo) lookupMojo("execute", getTestFile("src/test/resources/pdf-docs-pom.xml"));

        assertNotNull(mojo);
        mojo.execute();
        File file = FileUtil.loadFile(mojo.getDocumentationDir() + mojo.outputFileName + ".pdf");
        assertThat(file).exists().hasParent("target/cukedoctor");
        assertThat(mojo.getGeneratedFile()).
                contains(":toc: right").
                contains(":backend: pdf");
    }

    /**
     * @throws Exception
     */
    public void testAllDocs() throws Exception {

        CukedoctorMojo mojo = (CukedoctorMojo) lookupMojo("execute", getTestFile("src/test/resources/html-pdf-docs-pom.xml"));

        assertNotNull(mojo);
        mojo.execute();
        File pdfFile = FileUtil.loadFile(mojo.getDocumentationDir() + mojo.outputFileName + ".pdf");
        assertThat(pdfFile).exists().hasParent("target/docs");

        File htmlFile = FileUtil.loadFile(mojo.getDocumentationDir() + mojo.outputFileName + ".html");
        assertThat(htmlFile).exists().hasParent("target/docs");
        assertThat(mojo.getGeneratedFile()).
                contains(":toc: left").
                contains(":backend: all").
                contains(":numbered:");
    }

}
