package com.github.cukedoctor.reporter;

import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.Expectations;
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
	private static String embedDataDirectly;
	private static String outline;
	private static String invalidFeatureResult;

	@BeforeClass
	public static void loadFeatures() {
		onePassingOneFailing = FileUtil.findJsonFile("json-output/one_passing_one_failing.json");
		embedDataDirectly = FileUtil.findJsonFile("json-output/embed_data_directly.json");
		outline = FileUtil.findJsonFile("json-output/outline.json");
		invalidFeatureResult = FileUtil.findJsonFile("json-output/invalid_feature_result.json");
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
				":toc: right" + newLine() +
						":backend: html5" + newLine() +
						":doctitle: Title" + newLine() +
						":doctype: article" + newLine() +
						":icons: font" + newLine() +
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


		String expected = ":toc: right" + newLine() +
				":backend: html5" + newLine() +
				":doctitle: Documentation Title" + newLine() +
				":doctype: article" + newLine() +
				":icons: font" + newLine() +
				":!numbered:" + newLine() +
				":sectanchors:" + newLine() +
				":sectlink:" + newLine();


		String document = CukedoctorReporter.instance(features, "Documentation Title").renderAttributes().
				getDocumentation().toString();
		assertEquals(document, expected);
	}

	@Test
	public void shouldRenderAttributesUsingDefaultConfigPassingNullAttrs() {
		List<Feature> features = new ArrayList<>();
		features.add(FeatureBuilder.instance().id("id").name("name").build());


		String expected = ":toc: right" + newLine() +
				":backend: html5" + newLine() +
				":doctitle: Documentation Title" + newLine() +
				":doctype: article" + newLine() +
				":icons: font" + newLine() +
				":!numbered:" + newLine() +
				":sectanchors:" + newLine() +
				":sectlink:" + newLine();


		String document = CukedoctorReporter.instance(features, "Documentation Title",null).renderAttributes().
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
				":backend: html5" + newLine() +
						":doctitle: Title" + newLine() +
						":doctype: article" + newLine() +
						":icons: font" + newLine() +
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
				":toc: left" + newLine() +
						":backend: html5" + newLine() +
						":doctitle: Documentation Title" + newLine() +
						":doctype: book" + newLine() +
						":icons: font" + newLine() +
						":!numbered:" + newLine() +
						":sectanchors:" + newLine() +
						":sectlink:" + newLine();


		String document = CukedoctorReporter.instance(features, "Documentation Title", attrs).renderAttributes().
				getDocumentation().toString();
		assertEquals(document, expected);
	}


	// renderSummary() tests

	@Test
	public void shouldRenderSummaryForOneFeature(){
		List<Feature> features = FeatureParser.parse(onePassingOneFailing);
		String resultDoc = CukedoctorReporter.instance(features,"Title").renderSummary().getDocumentation().toString();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce("<<One passing scenario, one failing scenario>>").
				containsOnlyOnce("|failed").
		        contains("|010ms");

		assertThat(resultDoc).isEqualTo(Expectations.SUMMARY_FOR_ONE_FEATURE);
	}


	@Test
	public void shouldRenderSummaryForMultipleFeatures(){
		List<Feature> features = FeatureParser.parse(onePassingOneFailing,embedDataDirectly,outline,invalidFeatureResult);
		String resultDoc = CukedoctorReporter.instance(features,"Title").renderSummary().getDocumentation().toString();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce("<<One passing scenario, one failing scenario>>").
				containsOnlyOnce("<<An embed data directly feature>>").
				containsOnlyOnce("<<An outline feature>>").
				doesNotContain("<<invalid feature result>>").
		        containsOnlyOnce("|passed").
				contains("|failed").
				contains("|010ms");


		assertThat(resultDoc).isEqualTo(Expectations.SUMMARY_FOR_MULTIPLE_FEATURES);
	}

	// renderTotalsRow() tests

	@Test
	public void shouldRenderTotalRowForOneFeature(){
		List<Feature> features = FeatureParser.parse(onePassingOneFailing);
		String resultDoc = CukedoctorReporter.instance(features,"Title").renderTotalsRow().getDocumentation().toString();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce("12+^|*Totals*").
				contains("|1|1|2|1|1|0|0|0|0|2|010ms");
	}

	@Test
	public void shouldRenderTotalRowForMultipleFeature(){
		List<Feature> features = FeatureParser.parse(onePassingOneFailing,embedDataDirectly,outline,invalidFeatureResult);
		String resultDoc = CukedoctorReporter.instance(features,"Title").renderTotalsRow().getDocumentation().toString();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce("12+^|*Totals*").
				contains("|4|2|6|4|1|0|0|0|1|6|010ms");
	}

	@Test
	public void shouldRenderDocumentationForOneFeature(){
		List<Feature> features = FeatureParser.parse(onePassingOneFailing);
		DocumentAttributes attrs = new DocumentAttributes();
		attrs.toc("left").backend("html5")
				.docType("book")
				.icons("font").numbered(false)
				.sectAnchors(true).sectLink(true);

		String resultDoc = CukedoctorReporter.instance(features,"Living Documentation", attrs).
				createDocumentation();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce(":doctype: book" + newLine()).
				containsOnlyOnce(":toc: left" + newLine()).
				containsOnlyOnce("= Living Documentation" + newLine()).
				containsOnlyOnce("<<One passing scenario, one failing scenario>>").
				containsOnlyOnce("|failed").
				contains("|010ms").
				containsOnlyOnce("|1|1|2|1|1|0|0|0|0|2|010ms");


		assertThat(resultDoc).isEqualTo(Expectations.DOCUMENTATION_FOR_ONE_FEATURE);
	}

	@Test
	public void shouldRenderDocumentationForMultipleFeatures(){
		List<Feature> features =  FeatureParser.parse(onePassingOneFailing, embedDataDirectly, outline, invalidFeatureResult);

		DocumentAttributes attrs = new DocumentAttributes();
		attrs.toc("left").backend("html5")
				.docType("book")
				.icons("font").numbered(false)
				.sectAnchors(true).sectLink(true);

		String resultDoc = CukedoctorReporter.instance(features,"Living Documentation", attrs).
				createDocumentation();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce(":doctype: book" + newLine()).
				containsOnlyOnce(":toc: left" + newLine()).
				containsOnlyOnce("= Living Documentation" + newLine()).
				containsOnlyOnce("<<One passing scenario, one failing scenario>>").
				containsOnlyOnce("<<An embed data directly feature>>").
				containsOnlyOnce("<<An outline feature>>").
				doesNotContain("<<invalid feature result>>").
				containsOnlyOnce("|passed").
				contains("|failed").
				contains("|010ms").
				containsOnlyOnce("|4|2|6|4|1|0|0|0|1|6|010ms");

		assertThat(resultDoc).isEqualTo(Expectations.DOCUMENTATION_FOR_MULTIPLE_FEATURES);
	}


}
