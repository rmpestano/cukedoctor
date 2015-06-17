package com.github.cukedoctor.reporter;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.CukedoctorReporter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.*;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.util.Expectations;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.builder.FeatureBuilder;
import com.github.cukedoctor.util.builder.ScenarioBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;


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
		onePassingOneFailing = FileUtil.findJsonFile("target/test-classes/json-output/one_passing_one_failing.json");
		embedDataDirectly = FileUtil.findJsonFile("target/test-classes/json-output/embed_data_directly.json");
		outline = FileUtil.findJsonFile("target/test-classes/json-output/outline.json");
		invalidFeatureResult = FileUtil.findJsonFile("target/test-classes/json-output/invalid_feature_result.json");
	}


	@Test//(expected = RuntimeException.class)
	public void shouldFailToCreateDocumentationWithoutFeatures() {
		String msg = null;
		try {
			Cukedoctor.instance(new ArrayList<Feature>(), "A test");
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

			Cukedoctor.instance(features, " ");
		} catch (RuntimeException re) {
			msg = re.getMessage();
		}

		assertEquals("Provide document title", msg);
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
						":!linkcss:" + newLine() +
						":sectanchors:" + newLine() +
						":sectlink:" + newLine() +
						":docinfo:" + newLine();


		String document = Cukedoctor.instance(features, "Documentation Title", attrs).renderAttributes().
				getDocumentation().toString();
		assertEquals(expected,document);
	}

	@Test
	public void shouldRenderAttributesUsingDefaultConfig() {
		List<Feature> features = new ArrayList<>();
		features.add(FeatureBuilder.instance().id("id").name("name").build());


		String expected = ":toc: right" + newLine() +
				":backend: html5" + newLine() +
				":doctitle: Documentation Title" + newLine() +
				":doctype: book" + newLine() +
				":icons: font" + newLine() +
				":!numbered:" + newLine() +
				":!linkcss:" + newLine() +
				":sectanchors:" + newLine() +
				":sectlink:" + newLine() +
				":docinfo:" + newLine();


		String document = Cukedoctor.instance(features, "Documentation Title").renderAttributes().
				getDocumentation().toString();
		assertEquals(expected,document);
	}

	@Test
	public void shouldRenderAttributesUsingDefaultConfigPassingNullAttrs() {
		List<Feature> features = new ArrayList<>();
		features.add(FeatureBuilder.instance().id("id").name("name").build());


		String expected = ":toc: right" + newLine() +
				":backend: html5" + newLine() +
				":doctitle: Documentation Title" + newLine() +
				":doctype: book" + newLine() +
				":icons: font" + newLine() +
				":!numbered:" + newLine() +
				":!linkcss:" + newLine() +
				":sectanchors:" + newLine() +
				":sectlink:" + newLine() +
				":docinfo:" + newLine();


		String document = Cukedoctor.instance(features, "Documentation Title", null).renderAttributes().
				getDocumentation().toString();
		assertEquals(expected,document);
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
						":!linkcss:" + newLine() +
						":sectanchors:" + newLine() +
						":sectlink:" + newLine() +
						":docinfo:" + newLine();


		String document = Cukedoctor.instance(features, "Documentation Title", attrs).renderAttributes().
				getDocumentation().toString();
		assertEquals(expected,document);
	}

	@Test
	public void shouldUseDocumentationTitleAsDocTitleAttribute() {
		List<Feature> features = new ArrayList<>();
		features.add(FeatureBuilder.instance().id("id").name("name").build());

		DocumentAttributes attrs = new DocumentAttributes();
		attrs.toc("right").backend("html5")
				.docType("book")
				.linkCss(true)
				.icons("font").numbered(false)
				.sectAnchors(true).sectLink(true);

		String expected =
				":toc: right" + newLine() +
						":backend: html5" + newLine() +
						":doctitle: Documentation Title" + newLine() +
						":doctype: book" + newLine() +
						":icons: font" + newLine() +
						":!numbered:" + newLine() +
						":linkcss:" + newLine() +
						":sectanchors:" + newLine() +
						":sectlink:" + newLine() +
						":docinfo:" + newLine();


		String document = Cukedoctor.instance(features, "Documentation Title", attrs).renderAttributes().
				getDocumentation().toString();
		assertEquals(document, expected);
	}


	// renderSummary() tests

	@Test
	public void shouldRenderSummaryForOneFeature() {
		List<Feature> features = FeatureParser.parse(onePassingOneFailing);
		String resultDoc = Cukedoctor.instance(features, "Title").renderSummary().getDocumentation().toString();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce("<<One passing scenario, one failing scenario>>").
				containsOnlyOnce("|[red]#*failed*#").
				contains("2+|010ms");

		assertThat(resultDoc).isEqualTo(Expectations.SUMMARY_FOR_ONE_FEATURE);
	}


	@Test
	public void shouldRenderSummaryForMultipleFeatures() {
		List<Feature> features = FeatureParser.parse(onePassingOneFailing, embedDataDirectly, outline, invalidFeatureResult);
		String resultDoc = Cukedoctor.instance(features, "Title").renderSummary().getDocumentation().toString();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce("<<One passing scenario, one failing scenario>>").
				containsOnlyOnce("<<An embed data directly feature>>").
				containsOnlyOnce("<<An outline feature>>").
				doesNotContain("<<invalid feature result>>").
				containsOnlyOnce("|[green]#*passed*#").
				contains("|[red]#*Failed*#").
				containsOnlyOnce("2+|010ms");


		assertThat(resultDoc).isEqualTo(Expectations.SUMMARY_FOR_MULTIPLE_FEATURES);
	}

	// renderTotalsRow() tests

	@Test
	public void shouldRenderTotalRowForOneFeature() {
		List<Feature> features = FeatureParser.parse(onePassingOneFailing);
		String resultDoc = Cukedoctor.instance(features, "Title").renderTotalsRow().getDocumentation().toString();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce("12+^|*Totals*").
				contains("|1|1|2|1|1|0|0|0|0|2 2+|010ms");
	}

	@Test
	public void shouldRenderTotalRowForMultipleFeature() {
		List<Feature> features = FeatureParser.parse(onePassingOneFailing, embedDataDirectly, outline, invalidFeatureResult);
		String resultDoc = Cukedoctor.instance(features, "Title").renderTotalsRow().getDocumentation().toString();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce("12+^|*Totals*").
				contains("|4|2|6|4|1|0|0|0|1|6 2+|010ms");
	}

	@Test
	public void shouldRenderFeatureDescription(){
		final Feature feature = FeatureBuilder.instance().description("Feature description").name("Feature name").build();

		CukedoctorReporter cukedoctorReporter = Cukedoctor.instance(new ArrayList<Feature>() {{
			add(feature);
		}}, "doc.adoc", null);
		cukedoctorReporter = spy(cukedoctorReporter);
		doReturn(cukedoctorReporter).when(cukedoctorReporter).renderFeatureScenarios(feature);
		String resultDoc = cukedoctorReporter.renderFeature(feature).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo("== Feature name"+newLine() +
				""+newLine() +
				"****"+newLine() +
				"Feature description"+newLine() +
				"****"+newLine() +
				""+newLine());
	}

	@Test
	public void shouldRenderFeatureScenarios(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		CukedoctorReporter cukedoctorReporter = Cukedoctor.instance(new ArrayList<Feature>() {{
			add(feature);
		}}, "doc.adoc", null);

		cukedoctorReporter = spy(cukedoctorReporter);
		doReturn(cukedoctorReporter).when(cukedoctorReporter).renderScenarioSteps(anyListOf(Step.class));
		String resultDoc = cukedoctorReporter.renderFeatureScenarios(feature).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo("=== Scenario: scenario 1"+newLine() +
				"description"+newLine() +
				"=== Scenario: scenario 2"+newLine() +
				"description 2"+newLine());
	}

	@Test
	public void shouldRenderFeatureScenariosWithTagsInScenarios(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		for (Element scenario : feature.getScenarios()) {
			ScenarioBuilder.instance(scenario).tag(new Tag("@Tag1")).tag(new Tag("@tag2"));
		}
		CukedoctorReporter cukedoctorReporter = Cukedoctor.instance(new ArrayList<Feature>() {{
			add(feature);
		}}, "doc.adoc", null);

		cukedoctorReporter = spy(cukedoctorReporter);
		doReturn(cukedoctorReporter).when(cukedoctorReporter).renderScenarioSteps(anyListOf(Step.class));
		String resultDoc = cukedoctorReporter.renderFeatureScenarios(feature).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo("=== Scenario: scenario 1"+newLine() +
				"[small]#tags: @Tag1,@tag2#"+newLine() +
				""+newLine() +
				"description"+newLine() +
				"=== Scenario: scenario 2"+newLine() +
				"[small]#tags: @Tag1,@tag2#"+newLine() +
				""+newLine() +
				"description 2"+newLine());
	}

	@Test
	public void shouldRenderFeatureScenariosWithTagsInFeatures(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		feature.getTags().add(new Tag("@FeatureTag"));
		CukedoctorReporter cukedoctorReporter = Cukedoctor.instance(new ArrayList<Feature>() {{
			add(feature);
		}}, "doc.adoc", null);

		cukedoctorReporter = spy(cukedoctorReporter);
		doReturn(cukedoctorReporter).when(cukedoctorReporter).renderScenarioSteps(anyListOf(Step.class));
		String resultDoc = cukedoctorReporter.renderFeatureScenarios(feature).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo("=== Scenario: scenario 1"+newLine() +
				"[small]#tags: @FeatureTag#"+newLine() +
				""+newLine() +
				"description"+newLine() +
				"=== Scenario: scenario 2"+newLine() +
				"[small]#tags: @FeatureTag#"+newLine() +
				""+newLine() +
				"description 2"+newLine());
	}

	@Test
	public void shouldRenderFeatureScenariosWithTagsInFeaturesAndScenarios(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		feature.getTags().add(new Tag("@FeatureTag"));
		for (Element scenario : feature.getScenarios()) {
			ScenarioBuilder.instance(scenario).tag(new Tag("@Tag1")).tag(new Tag("@tag2"));
		}
		CukedoctorReporter cukedoctorReporter = Cukedoctor.instance(new ArrayList<Feature>() {{
			add(feature);
		}}, "doc.adoc", null);

		cukedoctorReporter = spy(cukedoctorReporter);
		doReturn(cukedoctorReporter).when(cukedoctorReporter).renderScenarioSteps(anyListOf(Step.class));
		String resultDoc = cukedoctorReporter.renderFeatureScenarios(feature).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo("=== Scenario: scenario 1"+newLine() +
				"[small]#tags: @FeatureTag,@Tag1,@tag2#"+newLine() +
				""+newLine() +
				"description"+newLine() +
				"=== Scenario: scenario 2"+newLine() +
				"[small]#tags: @FeatureTag,@Tag1,@tag2#"+newLine() +
				""+newLine() +
				"description 2"+newLine());
	}

	@Test
	public void shouldRenderDocinfo(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorReporter reporter = Cukedoctor.instance(features, "Doc Title", new DocumentAttributes());
		reporter.setFilename("/target/document.adoc");
		reporter.generateDocInfo();
		assertThat(FileUtil.loadFile("/target/document-docinfo.html")).exists();
		assertThat(FileUtil.loadFile("/target/cukedoctor.css")).exists();
		assertThat(FileUtil.loadFile("/target/cukedoctor.js")).exists();
	}

	@Test
	public void shouldNotSetInvalidFilename(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorReporter reporter = Cukedoctor.instance(features, "Doc Title", new DocumentAttributes());

		reporter.setFilename("test");
		assertThat(reporter.getFilename()).isEqualTo("test.adoc");
		try{
			reporter.setFilename("test.txt");
		}catch (RuntimeException re){
			assertThat(re.getMessage()).isEqualTo("Invalid filename extension for file: test.txt. Valid formats are: ad, adoc, asciidoc and asc");
		}

		try{
			reporter.setFilename("test.doc");
		}catch (RuntimeException re){
			assertThat(re.getMessage()).isEqualTo("Invalid filename extension for file: test.doc. Valid formats are: ad, adoc, asciidoc and asc");
		}

		reporter.setFilename("test.ad");
		assertThat(reporter.getFilename()).isEqualTo("test.ad");
	}

	@Test
	public void shouldRenderDocinfoUsingDocTitleAsName(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorReporter reporter = Cukedoctor.instance(features, "/target/Doc Title", new DocumentAttributes());
		reporter.generateDocInfo();
		File savedFile = FileUtil.loadFile("/target/Doc_Title-docinfo.html");
		assertThat(savedFile).exists();
		FileUtil.removeFile(savedFile.getAbsolutePath());
	}

	// Integration tests

	@Test
	public void shouldRenderDocumentationForOneFeature() {
		List<Feature> features = FeatureParser.parse(onePassingOneFailing);
		DocumentAttributes attrs = new DocumentAttributes();
		attrs.toc("left").backend("html5")
				.docType("book")
				.icons("font").numbered(false)
				.sectAnchors(true).sectLink(true);

		CukedoctorReporter reporter = Cukedoctor.instance(features, "Living Documentation", attrs);
		reporter.setFilename("/target/living_documentation.adoc");
		String resultDoc =	reporter.renderDocumentation();

		assertThat(resultDoc).isNotNull().
				containsOnlyOnce(":doctype: book" + newLine()).
				containsOnlyOnce(":toc: left" + newLine()).
				containsOnlyOnce("= Living Documentation" + newLine()).
				containsOnlyOnce("<<One passing scenario, one failing scenario>>").
				containsOnlyOnce("|[red]#*failed*#").
				contains("|010ms").
				containsOnlyOnce("|1|1|2|1|1|0|0|0|0|2 2+|010ms");

		FileUtil.saveFile("target/test-docs/doc_one_feature.adoc", resultDoc); //save to target/test-docs folder
		assertThat(resultDoc).isEqualTo(Expectations.DOCUMENTATION_FOR_ONE_FEATURE);
	}

	@Test
	public void shouldRenderDocumentationForMultipleFeatures() {
		List<Feature> features = FeatureParser.parse(onePassingOneFailing, embedDataDirectly, outline, invalidFeatureResult);

		DocumentAttributes attrs = new DocumentAttributes();
		attrs.toc("left").backend("html5")
				.docType("book")
				.icons("font").numbered(false)
				.sectAnchors(true).sectLink(true);

		CukedoctorReporter reporter = Cukedoctor.instance(features, "Living Documentation", attrs);
		reporter.setFilename("/target/living_documentation.adoc");
		String resultDoc =	reporter.renderDocumentation();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce(":doctype: book" + newLine()).
				containsOnlyOnce(":toc: left" + newLine()).
				containsOnlyOnce("= Living Documentation" + newLine()).
				containsOnlyOnce("<<One passing scenario, one failing scenario>>").
				containsOnlyOnce("<<An embed data directly feature>>").
				containsOnlyOnce("<<An outline feature>>").
				doesNotContain("<<invalid feature result>>").
				containsOnlyOnce("|[green]#*passed*#").
				contains("|[red]#*Failed*#").
				contains("|010ms").
				containsOnlyOnce("|4|2|6|4|1|0|0|0|1|6 2+|010ms");

		FileUtil.saveFile("target/test-docs/doc_multiple_feature.adoc", resultDoc); //save to target/test-docs folder
		assertThat(resultDoc).isEqualTo(Expectations.DOCUMENTATION_FOR_MULTIPLE_FEATURES);
	}

	@Test
	public void shouldRenderFeatureDescriptionWithNewLines(){
		List<Feature> features = FeatureParser.parse(FileUtil.findJsonFile("target/test-classes/json-output/sample.json"));
		assertThat(features).hasSize(1);
		CukedoctorReporter reporter = Cukedoctor.instance(features, "Living Documentation", new DocumentAttributes());
		reporter.setFilename("/target/living_documentation.adoc");
		String resultDoc =	reporter.renderDocumentation();
		assertThat(resultDoc).contains("****" + newLine() +
				"As a user  +"+newLine() +
				"I want to do something  +"+newLine() +
				"In order to achieve another thing"+newLine() +
				"****");
		FileUtil.saveFile("/target/sample.adoc",resultDoc);
	}

	@Test
	public void shouldSaveDocumentationIntoDisk(){
		List<Feature> features = FeatureParser.parse(onePassingOneFailing);

		CukedoctorReporter reporter = Cukedoctor.instance(features, "Living Documentation", new DocumentAttributes());
		reporter.setFilename("/target/living_documentation.adoc");

		reporter.saveDocumentation();
		assertThat(FileUtil.loadFile("/target/living_documentation.adoc")).exists();
	}
}
