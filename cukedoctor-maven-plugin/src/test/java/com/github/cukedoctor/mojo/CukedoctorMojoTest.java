package com.github.cukedoctor.mojo;

import com.github.cukedoctor.util.FileUtil;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;

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
		assertTrue(FileUtil.loadFile(mojo.resolveTargetDir() + mojo.outputFile + ".html").exists());
	}

	/**
	 * @throws Exception
	 */
	public void testPdfDocs() throws Exception {

		CukedoctorMojo mojo = (CukedoctorMojo) lookupMojo("execute", getTestFile("src/test/resources/pdf-docs-pom.xml"));

		assertNotNull(mojo);
		mojo.execute();
		assertTrue(FileUtil.loadFile(mojo.resolveTargetDir()+mojo.outputFile+".pdf").exists());
	}

	/*private MavenProject getMavenProject(String pomPath) throws Exception {
		File pom = new File(pomPath);
		MavenExecutionRequest request = new DefaultMavenExecutionRequest();
		request.setPom(pom);
		ProjectBuildingRequest configuration = request.getProjectBuildingRequest();
		return lookup(ProjectBuilder.class).build( pom, configuration ).getProject();
	}*/
}
