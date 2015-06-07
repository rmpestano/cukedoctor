package com.github.cukedoctor.reporter;

import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;


/**
 * Created by pestano on 02/06/15.
 */
@RunWith(JUnit4.class)
public class CukedoctorReporterTest {

	private static String onePassingOneFailing;

	@BeforeClass
	public static void loadFeatures() {
		onePassingOneFailing = FileUtil.findJsonFile("json-output/one_passing_one_failing.json");
	}


	@Test//(expected = RuntimeException.class)
	public void shouldFailToCreateDocumentationWithoutFeatures() {
		String msg = null;
		try {
			CukedoctorReporter.instance(new ArrayList<Feature>(), "A test");
		} catch (RuntimeException re) {
			msg = re.getMessage();
		}

		assertEquals("No features found", msg);
	}

	@Test//(expected = RuntimeException.class)
	public void shouldFailToCreateDocumentationWithoutTitle() {
		String msg = null;
		List<Feature> features = FeatureParser.parse(onePassingOneFailing);
		try {

			CukedoctorReporter.instance(features, " ");
		} catch (RuntimeException re) {
			msg = re.getMessage();
		}

		assertEquals("Provide document title", msg);
	}


	@Test
	public void shouldGetCurrentInstance() {
		List<Feature> features = FeatureParser.parse(onePassingOneFailing);
		CukedoctorReporter.instance(features, "Title");
		CukedoctorReporter.getCurrentInstance();
	}

	// renderAttributes() tests

	@Test
	public void shouldRenderAttributes() {
		List<Feature> features = new ArrayList<>();
		features.add(FeatureBuilder.instance().id("id").name("name").build());

		DocumentAttributes attrs = new DocumentAttributes();
		attrs.toc("right").backend("html5")
				.docType("article").docTitle("Title")
				.icons("font").numbered(false)
				.sectAnchors(true).sectLink(true);

		String expected =
				":toc:right" + newLine() +
						":backend:html5" + newLine() +
						":doctitle:Title" + newLine() +
						":doctype:article" + newLine() +
						":icons:font" + newLine() +
						":!numbered:" + newLine() +
						":sectanchors:" + newLine() +
						":sectlink:" + newLine();


		String document = CukedoctorReporter.instance(features, "Documentation Title", attrs).renderAttributes().
				getDocumentation().toString();
		assertEquals(document, expected);
	}

	@Test
	public void shouldRenderAttributesUsingDefaultConfig() {
		List<Feature> features = new ArrayList<>();
		features.add(FeatureBuilder.instance().id("id").name("name").build());


		String expected = ":toc:right" + newLine() +
				":backend:html5" + newLine() +
				":doctitle:Documentation Title" + newLine() +
				":doctype:article" + newLine() +
				":icons:font" + newLine() +
				":!numbered:" + newLine() +
				":sectanchors:" + newLine() +
				":sectlink:" + newLine();


		String document = CukedoctorReporter.instance(features, "Documentation Title").renderAttributes().
				getDocumentation().toString();
		assertEquals(document, expected);
	}

	@Test
	public void shouldRenderAttributesWithoutToc() {
		List<Feature> features = new ArrayList<>();
		features.add(FeatureBuilder.instance().id("id").name("name").build());

		DocumentAttributes attrs = new DocumentAttributes();
		attrs.toc("").backend("html5")
				.docType("article").docTitle("Title")
				.icons("font").numbered(false)
				.sectAnchors(true).sectLink(true);

		String expected =
				":backend:html5" + newLine() +
						":doctitle:Title" + newLine() +
						":doctype:article" + newLine() +
						":icons:font" + newLine() +
						":!numbered:" + newLine() +
						":sectanchors:" + newLine() +
						":sectlink:" + newLine();


		String document = CukedoctorReporter.instance(features, "Documentation Title", attrs).renderAttributes().
				getDocumentation().toString();
		assertEquals(document, expected);
	}

	@Test
	public void shouldUseDocumentationTitleAsDocTitleAttribute() {
		List<Feature> features = new ArrayList<>();
		features.add(FeatureBuilder.instance().id("id").name("name").build());

		DocumentAttributes attrs = new DocumentAttributes();
		attrs.toc("left").backend("html5")
				.docType("book")
				.icons("font").numbered(false)
				.sectAnchors(true).sectLink(true);

		String expected =
				":toc:left" + newLine() +
						":backend:html5" + newLine() +
						":doctitle:Documentation Title" + newLine() +
						":doctype:book" + newLine() +
						":icons:font" + newLine() +
						":!numbered:" + newLine() +
						":sectanchors:" + newLine() +
						":sectlink:" + newLine();


		String document = CukedoctorReporter.instance(features, "Documentation Title", attrs).renderAttributes().
				getDocumentation().toString();
		assertEquals(document, expected);
	}


	// renderSummary() tests

	@Test
	public void shouldRenderSummary(){
		List<Feature> features = FeatureParser.parse(onePassingOneFailing);
		String resultDoc = CukedoctorReporter.instance(features,"Title").renderSummary().getDocumentation().toString();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce("<|One passing scenario, one failing scenario").
				containsOnlyOnce("<|failed").
		        containsOnlyOnce("<|010ms");
	}


}
