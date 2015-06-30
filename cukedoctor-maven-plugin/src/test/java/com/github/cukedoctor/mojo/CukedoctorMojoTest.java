package com.github.cukedoctor.mojo;

import com.github.cukedoctor.util.FileUtil;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by pestano on 27/06/15.
 */
public class CukedoctorMojoTest extends AbstractMojoTestCase {

	protected void setUp() throws Exception {
		// required for mojo lookups to work
		super.setUp();
	}

	protected void tearDown() throws Exception {
		// required
		super.tearDown();

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

}
