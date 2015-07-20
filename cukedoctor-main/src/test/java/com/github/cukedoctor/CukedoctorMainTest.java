package com.github.cukedoctor;

import com.beust.jcommander.ParameterException;
import com.github.cukedoctor.CukedoctorMain;
import com.github.cukedoctor.util.FileUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by pestano on 08/06/15.
 */
@RunWith(JUnit4.class)
public class CukedoctorMainTest {

	PrintStream newOut;
	PrintStream defaultOut;
	ByteArrayOutputStream baos;

	@Before
	public void setup() {
		baos = new ByteArrayOutputStream();
		newOut = new PrintStream(baos);
		defaultOut = System.out;
		System.setOut(newOut);
	}

	@After
	public void tearDown() throws IOException {
		System.setOut(defaultOut);
		baos.close();
	}

	@Test
	public void shouldCreateDocumentationForOneFeature() {
		new CukedoctorMain().execute(new String[] {
				"-o", "\"target/test-classes/document-one\"",
				"-p", "\"target/test-classes/json-output/outline.json\"",
				"-t", "Living Documentation"
		});
		assertTrue(FileUtil.loadFile("target/test-classes/document-one.adoc").exists());
	}

	@Test
	public void shouldCreateDocumentationForMultipleFeatures() {
		new CukedoctorMain().execute(new String[]{
				"-o", "\"target/test-classes/document-mult\"",
				"-p", "\"target/test-classes/json-output\"",
				"-t", "Living Documentation"
		});
		System.out.flush();
		String output = baos.toString();
		assertThat(output).contains("Found 4 feature(s)");
		assertTrue(FileUtil.loadFile("target/test-classes/document-mult.adoc").exists());
	}

	@Test
	public void shouldCreateDocumentationUsingDocNameAsTitle() {
		new CukedoctorMain().execute(new String[]{
				"-t", "\"target/test-classes/Living Documentation\"",
				"-p", "\"target/test-classes/json-output\""
		});
		System.out.flush();
		String output = baos.toString();
		assertThat(output).contains("-t: target/test-classes/Living Documentation").
				contains("Found 4 feature(s)");
		assertTrue(FileUtil.loadFile("target/test-classes/Living-Documentation.html").exists());
	}

	@Test
	public void shouldNotFindFeatures() {
		new CukedoctorMain().execute(new String[] {
				"-o", "\"target/test-classes/document\"",
				"-p", "\"target/classes/\"",
				"-t", "Living Documentation"
		});
		System.out.flush();
		String output = baos.toString();
		assertThat(output).containsOnlyOnce("No features found in path:target/classes/");
	}


	@Test
	public void shouldCreateDocumentationUsingDefaults() throws IOException {
		String generatedDoc =	new CukedoctorMain().execute(new String[] {
		});

		System.out.flush();
		String output = baos.toString();
		assertThat(output).contains("Generating living documentation with args:" + newLine() +
				"-f: html5" + newLine() +
				"-p: " + newLine() +
				"-t: Living Documentation" + newLine() +
				"-o: Living-Documentation" + newLine());

		baos.close();
    assertThat(generatedDoc).
				contains(":!numbered:").contains(":toc: right").
				contains(":sectlink:").
				containsOnlyOnce("= *Living Documentation*");
 

		FileUtil.removeFile("Living-Documentation.adoc");
		FileUtil.removeFile("Living-Documentation.html");
	}


	@Test
	public void shouldRenderHtmlForOneFeature(){
		CukedoctorMain main = new CukedoctorMain();
		main.execute(new String[] {
				"-o", "\"target/document-one\"",
				"-p", "\"target/test-classes/json-output/one_passing_one_failing.json\"",
				"-t", "Living Documentation",
				"-f", "html"

		});

		File generatedFile = FileUtil.loadFile("target/document-one.html");
		assertThat(generatedFile).exists();
	}


	@Test
	public void shouldRenderPdfForOneFeature(){
		CukedoctorMain main = new CukedoctorMain();
		main.execute(new String[]{
				"-o", "\"target/document-one\"",
				"-p", "\"target/test-classes/json-output/one_passing_one_failing.json\"",
				"-t", "Living Documentation",
				"-f", "pdf"

		});

		File generatedFile = FileUtil.loadFile("target/document-one.pdf");
		assertThat(generatedFile).exists();

	}

	@Test
	public void shouldRenderPdfAndHtml(){
		CukedoctorMain main = new CukedoctorMain();
		main.execute(new String[]{
				"-o", "\"target/document-one\"",
				"-p", "\"target/test-classes/json-output/one_passing_one_failing.json\"",
				"-t", "Living Documentation",
				"-f", "all"

		});

		File generatedFile = FileUtil.loadFile("target/document-one.pdf");
		assertThat(generatedFile).exists();

		generatedFile = FileUtil.loadFile("target/document-one.html");
		assertThat(generatedFile).exists();

	}


}
