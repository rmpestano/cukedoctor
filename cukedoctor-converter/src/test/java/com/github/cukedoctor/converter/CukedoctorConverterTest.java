package com.github.cukedoctor.converter;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.CukedoctorConverter;
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
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;


/**
 * Created by pestano on 02/06/15.
 */
@RunWith(JUnit4.class)
public class CukedoctorConverterTest {

	private static String onePassingOneFailing;
	private static String embedDataDirectly;
	private static String outline;
	private static String invalidFeatureResult;
	private static String featureWithTableInStep;

	@BeforeClass
	public static void loadFeatures() {
		onePassingOneFailing = FileUtil.findJsonFile("target/test-classes/json-output/one_passing_one_failing.json");
		embedDataDirectly = FileUtil.findJsonFile("target/test-classes/json-output/embed_data_directly.json");
		outline = FileUtil.findJsonFile("target/test-classes/json-output/outline.json");
		invalidFeatureResult = FileUtil.findJsonFile("target/test-classes/json-output/invalid_feature_result.json");
		featureWithTableInStep = FileUtil.findJsonFile("target/test-classes/json-output/step-with-table.json");
	}


	@Test//(expected = RuntimeException.class)
	public void shouldFailToCreateDocumentationWithoutFeatures() {
		String msg = null;
		try {
			Cukedoctor.instance(new ArrayList<Feature>());
		} catch (RuntimeException re) {
			msg = re.getMessage();
		}

		assertEquals("No features found", msg);
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
						":docinfo:" + newLine() +
						":toclevels: 3"+newLine();


		attrs.docTitle("Title");
		String document = Cukedoctor.instance(features, attrs).renderAttributes().
				getDocumentation().toString();
		assertEquals(expected,document);
	}


	@Test
	public void shouldRenderAttributesUsingDefaultConfig() {
		List<Feature> features = new ArrayList<>();
		features.add(FeatureBuilder.instance().id("id").name("name").build());


		String expected = ":toc: right" + newLine() +
				":backend: html5" + newLine() +
				":doctitle: Living Documentation" + newLine() +
				":doctype: book" + newLine() +
				":icons: font" + newLine() +
				":!numbered:" + newLine() +
				":!linkcss:" + newLine() +
				":sectanchors:" + newLine() +
				":sectlink:" + newLine() +
				":docinfo:" + newLine() +
				":toclevels: 3"+newLine();


		String document = Cukedoctor.instance(features,new DocumentAttributes()).renderAttributes().
				getDocumentation().toString();
		assertEquals(expected,document);
	}

	@Test
	public void shouldNotRenderAttributesWhenNoDocAttrIsProvided() {
		List<Feature> features = new ArrayList<>();
		features.add(FeatureBuilder.instance().id("id").name("name").build());


		String document = Cukedoctor.instance(features).renderAttributes().
				getDocumentation().toString();
		assertEquals("",document);
	}

	@Test
	public void shouldNotRenderAttributesPassingNullDocAttrs() {
		List<Feature> features = new ArrayList<>();
		features.add(FeatureBuilder.instance().id("id").name("name").build());

		String document = Cukedoctor.instance(features, null).renderAttributes().
				getDocumentation().toString();
		assertEquals("",document);
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
						":docinfo:" + newLine() +
						":toclevels: 3"+newLine();

		attrs.docTitle("Title");
		String document = Cukedoctor.instance(features, attrs).renderAttributes().
				getDocumentation().toString();
		assertEquals(expected,document);
	}

	@Test
	public void shouldRenderAttributesWithTocLevels2() {
		List<Feature> features = new ArrayList<>();
		features.add(FeatureBuilder.instance().id("id").name("name").build());

		DocumentAttributes attrs = new DocumentAttributes();
		attrs.toc("").backend("html5")
				.docType("article").docTitle("Title")
				.icons("font").numbered(false)
				.sectAnchors(true).sectLink(true)
				.tocLevels("2")
				;

		String expected =
				":backend: html5" + newLine() +
						":doctitle: Title" + newLine() +
						":doctype: article" + newLine() +
						":icons: font" + newLine() +
						":!numbered:" + newLine() +
						":!linkcss:" + newLine() +
						":sectanchors:" + newLine() +
						":sectlink:" + newLine() +
						":docinfo:" + newLine() +
						":toclevels: 2"+newLine();


		attrs.docTitle("Title");
		String document = Cukedoctor.instance(features, attrs).renderAttributes().
				getDocumentation().toString();
		assertEquals(expected, document);
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
						":docinfo:" + newLine() +
						":toclevels: 3"+newLine();


		attrs.docTitle("Documentation Title");
		String document = Cukedoctor.instance(features, attrs).renderAttributes().
				getDocumentation().toString();
		assertEquals(document, expected);
	}



	// renderSummary() tests

	@Test
	public void shouldRenderSummaryForOneFeature() {
		List<Feature> features = FeatureParser.parse(onePassingOneFailing);
		String resultDoc = Cukedoctor.instance(features, new DocumentAttributes().docTitle("Title")).renderSummary().getDocumentation().toString();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce("<<One-passing-scenario-one-failing-scenario>>").
				containsOnlyOnce("|[red]#*failed*#").
				contains("2+|010ms");

		assertThat(resultDoc).isEqualTo(Expectations.SUMMARY_FOR_ONE_FEATURE);
	}


	@Test
	public void shouldRenderSummaryForMultipleFeatures() {
		List<Feature> features = FeatureParser.parse(onePassingOneFailing, embedDataDirectly, outline, invalidFeatureResult);
		String resultDoc = Cukedoctor.instance(features, new DocumentAttributes().docTitle("Title")).renderSummary().getDocumentation().toString();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce("<<One-passing-scenario-one-failing-scenario>>").
				containsOnlyOnce("<<An-embed-data-directly-feature>>").
				containsOnlyOnce("<<An-outline-feature>>").
				doesNotContain("<<invalid feature result>>").
				contains("|[green]#*passed*#").
				contains("|[red]#*failed*#").
				containsOnlyOnce("2+|010ms");
		assertThat(resultDoc).isEqualTo(Expectations.SUMMARY_FOR_MULTIPLE_FEATURES);
	}

	// renderTotalsRow() tests

	@Test
	public void shouldRenderTotalRowForOneFeature() {
		List<Feature> features = FeatureParser.parse(onePassingOneFailing);
		String resultDoc = Cukedoctor.instance(features, new DocumentAttributes().docTitle("Title")).renderTotalsRow().getDocumentation().toString();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce("12+^|*Totals*").
				contains("|1|1|2|1|1|0|0|0|0|2 2+|010ms");
	}

	@Test
	public void shouldRenderTotalRowForMultipleFeature() {
		List<Feature> features = FeatureParser.parse(onePassingOneFailing, embedDataDirectly, outline, invalidFeatureResult);
		String resultDoc = Cukedoctor.instance(features, new DocumentAttributes().docTitle("Title")).renderTotalsRow().getDocumentation().toString();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce("12+^|*Totals*").
				contains("|4|1|5|4|1|0|0|0|0|5 2+|010ms");


	}

	@Test
	public void shouldRenderFeatureDescription(){
		final Feature feature = FeatureBuilder.instance().description("Feature description").name("Feature name").build();

		CukedoctorConverter cukedoctorConverter = Cukedoctor.instance(new ArrayList<Feature>() {{
			add(feature);
		}}, null);
		cukedoctorConverter = spy(cukedoctorConverter);
		doReturn(cukedoctorConverter).when(cukedoctorConverter).renderFeatureScenarios(feature);
		String resultDoc = cukedoctorConverter.renderFeature(feature).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo("[[Feature-name, Feature name]]"+newLine() +
				"=== *Feature name*"+newLine() +
				""+newLine() +
				"minmax::Feature-name[]"+newLine() +
				"****"+newLine() +
				"Feature description"+newLine() +
				"****"+newLine() +
				""+newLine());
	}

	@Test
	public void shouldRenderFeatureScenarios(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		CukedoctorConverter cukedoctorConverter = Cukedoctor.instance(new ArrayList<Feature>() {{
			add(feature);
		}}, null);

		cukedoctorConverter = spy(cukedoctorConverter);
		doReturn(cukedoctorConverter).when(cukedoctorConverter).renderScenarioSteps(anyListOf(Step.class));
		String resultDoc = cukedoctorConverter.renderFeatureScenarios(feature).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo("==== Scenario: scenario 1" + newLine() +
				"description" + newLine() + newLine() +
				"==== Scenario: scenario 2" + newLine() +
				"description 2" + newLine() + newLine());
	}

	@Test
	public void shouldRenderFeatureScenariosWithTagsInScenarios(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		for (Scenario scenario : feature.getScenarios()) {
			ScenarioBuilder.instance(scenario).tag(new Tag("@Tag1")).tag(new Tag("@tag2"));
		}
		CukedoctorConverter cukedoctorConverter = Cukedoctor.instance(new ArrayList<Feature>() {{
			add(feature);
		}}, null);

		cukedoctorConverter = spy(cukedoctorConverter);
		doReturn(cukedoctorConverter).when(cukedoctorConverter).renderScenarioSteps(anyListOf(Step.class));
		String resultDoc = cukedoctorConverter.renderFeatureScenarios(feature).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo("==== Scenario: scenario 1"+newLine() +
				"[small]#tags: @Tag1,@tag2#"+newLine() +
				""+newLine() +
				"description"+newLine() + newLine() +
				"==== Scenario: scenario 2"+newLine() +
				"[small]#tags: @Tag1,@tag2#"+newLine() +
				""+newLine() +
				"description 2"+newLine() + newLine());
	}

	@Test
	public void shouldRenderFeatureScenariosWithTagsInFeatures(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		feature.getTags().add(new Tag("@FeatureTag"));
		CukedoctorConverter cukedoctorConverter = Cukedoctor.instance(new ArrayList<Feature>() {{
			add(feature);
		}}, null);

		cukedoctorConverter = spy(cukedoctorConverter);
		doReturn(cukedoctorConverter).when(cukedoctorConverter).renderScenarioSteps(anyListOf(Step.class));
		String resultDoc = cukedoctorConverter.renderFeatureScenarios(feature).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo("==== Scenario: scenario 1" + newLine() +
				"[small]#tags: @FeatureTag#" + newLine() +
				"" + newLine() +
				"description" + newLine() + newLine() +
				"==== Scenario: scenario 2" + newLine() +
				"[small]#tags: @FeatureTag#" + newLine() +
				"" + newLine() +
				"description 2" + newLine() + newLine());
	}

	@Test
	public void shouldRenderFeatureScenariosWithTagsInFeaturesAndScenarios(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		feature.getTags().add(new Tag("@FeatureTag"));
		for (Scenario scenario : feature.getScenarios()) {
			ScenarioBuilder.instance(scenario).tag(new Tag("@Tag1")).tag(new Tag("@tag2"));
		}
		CukedoctorConverter cukedoctorConverter = Cukedoctor.instance(new ArrayList<Feature>() {{
			add(feature);
		}}, null);

		cukedoctorConverter = spy(cukedoctorConverter);
		doReturn(cukedoctorConverter).when(cukedoctorConverter).renderScenarioSteps(anyListOf(Step.class));
		String resultDoc = cukedoctorConverter.renderFeatureScenarios(feature).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo("==== Scenario: scenario 1" + newLine() +
				"[small]#tags: @FeatureTag,@Tag1,@tag2#" + newLine() +
				"" + newLine() +
				"description" + newLine() + newLine() +
				"==== Scenario: scenario 2" + newLine() +
				"[small]#tags: @FeatureTag,@Tag1,@tag2#" + newLine() +
				"" + newLine() +
				"description 2" + newLine() + newLine());
	}

	@Test
	public void shouldRenderDocinfo(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes().docTitle("DocTitle"));
		converter.setFilename("target/docinfo/document.adoc");
		converter.generateDocInfo();
		File docInfo = FileUtil.loadFile("target/docinfo/document-docinfo.html");
		assertThat(docInfo).exists();
		docInfo.delete();
		File css = FileUtil.loadFile("target/docinfo/cukedoctor.css");
		assertThat(css).exists();
		css.delete();
		File js = FileUtil.loadFile("target/docinfo/cukedoctor.js");
		assertThat(js).exists();
		js.delete();
	}

	@Test
	public void shouldNotRenderDocinfo(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes().
				docTitle("Doc Title").docInfo(false));
		converter.setFilename("/target/docinfo/document.adoc");
		converter.generateDocInfo();
		File docInfo = FileUtil.loadFile("/target/docinfo/document-docinfo.html");
		assertThat(docInfo).doesNotExist();
		File css = FileUtil.loadFile("/target/docinfo/cukedoctor.css");
		assertThat(css).doesNotExist();
		File js = FileUtil.loadFile("/target/docinfo/cukedoctor.js");
		assertThat(js).doesNotExist();
	}

	@Test
	public void shouldGeneratePdfTheme(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());
		converter.setFilename("target/pdf/living documentation.adoc");
		converter.generatePdfTheme();
		File file = FileUtil.loadFile("target/pdf/living_documentation-theme.yml");
		assertThat(file).exists();
		assertTrue(file.delete());
	}

	@Test
	public void shouldNotGeneratePdfTheme(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		DocumentAttributes docAttrs = new DocumentAttributes().pdfTheme(false);
		CukedoctorConverter converter = Cukedoctor.instance(features, docAttrs);
		converter.setFilename("/target/pdf//living documentation.adoc");
		converter.generatePdfTheme();
		assertThat(FileUtil.loadFile("target/pdf/living_documentation-theme.yml")).doesNotExist();
	}


	@Test
	public void shouldNotSetInvalidFilename(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes().docTitle("Doc Title"));

		converter.setFilename("test");
		assertThat(converter.getFilename()).isEqualTo("test.adoc");
		try{
			converter.setFilename("test.txt");
		}catch (RuntimeException re){
			assertThat(re.getMessage()).isEqualTo("Invalid filename extension for file: test.txt. Valid formats are: ad, adoc, asciidoc and asc");
		}

		try{
			converter.setFilename("test.doc");
		}catch (RuntimeException re){
			assertThat(re.getMessage()).isEqualTo("Invalid filename extension for file: test.doc. Valid formats are: ad, adoc, asciidoc and asc");
		}

		converter.setFilename("test.ad");
		assertThat(converter.getFilename()).isEqualTo("test.ad");
	}

	@Test
	public void shouldRenderDocinfoUsingDocTitleAsName(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features,  new DocumentAttributes().docTitle("Doc Title"));
		converter.setFilename("target/Doc_Title");
		converter.generateDocInfo();
		File savedFile = FileUtil.loadFile("target/Doc_Title-docinfo.html");
		assertThat(savedFile).exists();
		savedFile.delete();
	}


	@Test
	public void shouldRenderFeatureStepsWithOnePassingStep(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());
		List<Step> steps = feature.getScenarios().get(0).getSteps();
		String resultDoc = converter.renderScenarioSteps(steps).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo("****" + newLine() +
				"Given::" + newLine() +
				"passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +
				"****" + newLine());
	}

	@Test
	public void shouldRenderFeatureStepsWithOnePassingAndOneFailingStep(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingAndOneFailingStep();
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());
		List<Step> steps = feature.getScenarios().get(0).getSteps();
		String resultDoc = converter.renderScenarioSteps(steps).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo("****" + newLine() +
				"Given::" + newLine() +
				"passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +
				"When::" + newLine() +
				"failing step icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(000ms)#" + newLine() +
				"****" + newLine());
	}

	@Test
	public void shouldNotRenderFeatureWithSkipDocsTag(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		final Feature featureToSkip = FeatureBuilder.instance().aFeatureWithTwoScenarios();
		featureToSkip.getTags().add(new Tag("@skipDocs"));
		featureToSkip.setName("feature to skip");
		featureToSkip.setId("skippedFeature");
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		features.add(featureToSkip);
		String resultDoc = Cukedoctor.instance(features, new DocumentAttributes()).
				renderFeatures(features).getDocumentation().toString();

		assertThat(resultDoc).
				doesNotContain("feature to skip").
				isEqualTo("[[Feature-name, Feature name]]"+newLine() +
						"=== *Feature name*"+newLine() +
						""+newLine() +
						"minmax::Feature-name[]"+newLine() +
						"****"+newLine() +
						"Feature description"+newLine() +
						"****"+newLine() +
						""+newLine() +
						"==== Scenario: scenario 1"+newLine() +
						"description"+newLine() +
						""+newLine() +
						"==== Scenario: scenario 2"+newLine() +
						"description 2"+newLine() +
						""+newLine());
	}

	@Test
	public void shouldNotRenderScenarioWithSkipDocsTag(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
		Scenario scenarioToSkip = ScenarioBuilder.instance().name("scenario to skip").tag(new Tag("@skipDocs")).
				type(Type.scenario).build();;
		feature.getScenarios().add(scenarioToSkip);
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());

		String resultDoc  = converter.renderFeatureScenarios(feature).getDocumentation().toString();

		assertThat(resultDoc).
				doesNotContain("scenario to skip").
				isEqualTo("==== Scenario: scenario"+newLine() +
				"description"+newLine() +
				"****"+newLine() +
				"Given::"+newLine() +
				"passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"+newLine() +
				"****"+newLine() +
				""+newLine());
	}


	@Test
	public void shouldRenderFeatureStepsWithOneScenarioWithMultipleStep(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithMultipleSteps();
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());
		List<Step> steps = feature.getScenarios().get(0).getSteps();
		String resultDoc = converter.renderScenarioSteps(steps).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo("****" + newLine() +
				"Given::" + newLine() +
				"passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine() +
				"When::" + newLine() +
				"failing step icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(000ms)#" + newLine() +
				"When::" + newLine() +
				"pending step icon:thumbs-down[role=\"maroon\",title=\"Pending\"] [small right]#(000ms)#" + newLine() +
				"When::" + newLine() +
				"missing step icon:thumbs-down[role=\"blue\",title=\"Missing\"] [small right]#(000ms)#" + newLine() +
				"When::" + newLine() +
				"undefined step icon:thumbs-down[role=\"yellow\",title=\"Undefined\"] [small right]#(000ms)#" + newLine() +
				"Then::" + newLine() +
				"skipped step icon:thumbs-down[role=\"purple\",title=\"Skipped\"] [small right]#(000ms)#" + newLine() +
				"****" + newLine());
	}

	@Test
	public void shouldRenderFeatureScenariosWithMultipleSteps(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithMultipleScenariosAndSteps();
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());

		String resultDoc = converter.renderFeatureScenarios(feature).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo("==== Scenario: scenario"+newLine() +
				"description" + newLine() +
				"****"+newLine() +
				"Given::"+newLine() +
				"passing step icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"+newLine() +
				"When::"+newLine() +
				"failing step icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(000ms)#"+newLine() +
				"****"+newLine() +
				""+newLine() +
				"==== Scenario: scenario"+newLine() +
				"description" +newLine() +
				"****" + newLine() +
				"Then::"+newLine() +
				"skipped step icon:thumbs-down[role=\"purple\",title=\"Skipped\"] [small right]#(000ms)#"+newLine() +
				"****"+newLine() +
				""+newLine() +
				"==== Scenario: scenario"+newLine() +
				"description" + newLine()+
				"****"+newLine() +
				"Given::"+newLine() +
				"undefined step icon:thumbs-down[role=\"yellow\",title=\"Undefined\"] [small right]#(000ms)#"+newLine() +
				"****"+newLine() +
				""+newLine());
	}

	@Test
	public void shouldRenderFeatureWithTableInSteps(){
		List<Feature> features = FeatureParser.parse(featureWithTableInStep);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes().docTitle("Doc Title"));

		String resultDoc = converter.renderStepTable(features.get(0).getScenarios().get(0).getSteps().get(0)).renderDocumentation();
		assertThat(resultDoc).isEqualTo(Expectations.FEATURE_WITH_STEP_TABLE);
	}


	@Test
	public void shouldNotGenerateSectionIdForFeatureBlankName(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
		feature.setName("    ");
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());
		assertThat(converter.renderFeatureSectionId(feature)).isEqualTo("");

	}

	@Test
	public void shouldNotRenderSectionIdForFeatureWithNullName(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
		feature.setName(null);
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());
		assertThat(converter.renderFeatureSectionId(feature)).isEqualTo("");

	}

	@Test
		 public void shouldRenderSectionIdForFeatureWithNameWithSpaces(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
		feature.setName("Feature name");
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());
		assertThat(converter.renderFeatureSectionId(feature)).isEqualTo("[[Feature-name, Feature name]]");

	}

	@Test
	public void shouldRenderSectionIdForFeatureWithNameWithSpacesAndComma(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
		feature.setName("Feature name, subname");
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());
		assertThat(converter.renderFeatureSectionId(feature)).isEqualTo("[[Feature-name-subname, Feature name, subname]]");

	}

	@Test
	public void shouldRenderFeatureSectionId(){
		final Feature feature = FeatureBuilder.instance().aFeatureWithOneScenarioWithOnePassingStep();
		feature.setName("Name");
		List<Feature> features = new ArrayList<>();
		features.add(feature);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());
		assertThat(converter.renderFeatureSectionId(feature)).isEqualTo("[[Name, Name]]");

	}

	// Integration tests

	@Test
	public void shouldRenderScenarioExamples(){
		List<Feature> features = FeatureParser.parse(outline);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());
		assertThat(features).hasSize(1);
		String resultDoc = converter.renderScenarioExamples(features.get(0).getElements().get(0)).getDocumentation().toString();
		assertThat(resultDoc).isEqualTo(""+newLine() +
				".examples1"+newLine() +
				"[cols=\"1*\", options=\"header\"]"+newLine() +
				"|==="+newLine() +
				"|status"+newLine() +
				"|passes"+newLine() +
				"|fails"+newLine() +
				"|==="+newLine() +
				""+newLine() +
				".examples2"+newLine() +
				"[cols=\"1*\", options=\"header\"]"+newLine() +
				"|==="+newLine() +
				"|status"+newLine() +
				"|passes"+newLine() +
				"|==="+newLine() +
				""+newLine());
	}

	@Test
	public void shouldRenderDocumentationForOneFeature() {
		List<Feature> features = FeatureParser.parse(onePassingOneFailing);
		DocumentAttributes attrs = new DocumentAttributes();
		attrs.toc("left").backend("html5")
				.docType("book").docTitle("Living Documentation")
				.icons("font").numbered(false)
				.sectAnchors(true).sectLink(true);

		CukedoctorConverter converter = Cukedoctor.instance(features, attrs);
		converter.setFilename("/target/living_documentation.adoc");
		String resultDoc =	converter.renderDocumentation();

		assertThat(resultDoc).isNotNull().
				containsOnlyOnce(":doctype: book" + newLine()).
				containsOnlyOnce(":toc: left" + newLine()).
				containsOnlyOnce("= *Living Documentation*" + newLine()).
				containsOnlyOnce("<<One-passing-scenario-one-failing-scenario>>").
				containsOnlyOnce("|[red]#*failed*#").
				contains("|010ms").
				containsOnlyOnce("|1|1|2|1|1|0|0|0|0|2 2+|010ms");

		FileUtil.saveFile("target/test-docs/doc_one_feature.adoc", resultDoc); //save to target/test-docs folder
		assertThat(resultDoc.replaceAll("\r","")).isEqualTo(Expectations.DOCUMENTATION_FOR_ONE_FEATURE.replaceAll("\r",""));
	}

	@Test
	public void shouldRenderDocumentationForMultipleFeatures() {
		List<Feature> features = FeatureParser.parse(onePassingOneFailing, embedDataDirectly, outline, invalidFeatureResult);

		DocumentAttributes attrs = new DocumentAttributes();
		attrs.toc("left").backend("html5")
				.docType("book").docTitle("Living Documentation")
				.icons("font").numbered(false)
				.sectAnchors(true).sectLink(true);

		CukedoctorConverter converter = Cukedoctor.instance(features, attrs);
		converter.setFilename("target/living_documentation.adoc");
		String resultDoc =	converter.renderDocumentation();
		assertThat(resultDoc).isNotNull().
				containsOnlyOnce(":doctype: book" + newLine()).
				containsOnlyOnce(":toc: left" + newLine()).
				contains("= *Living Documentation*" + newLine()).
				containsOnlyOnce("<<One-passing-scenario-one-failing-scenario>>").
				containsOnlyOnce("<<An-embed-data-directly-feature>>").
				containsOnlyOnce("<<An-outline-feature>>").
				doesNotContain("<<invalid-feature-result*>>").
				contains("|[green]#*passed*#").
				containsOnlyOnce("|[red]#*failed*#").
				contains("|010ms").
				containsOnlyOnce("|4|1|5|4|1|0|0|0|0|5 2+|010ms");

		FileUtil.saveFile("target/test-docs/doc_multiple_feature.adoc", resultDoc); //save to target/test-docs folder
		assertThat(resultDoc.replaceAll("\r","")).isEqualTo(Expectations.DOCUMENTATION_FOR_MULTIPLE_FEATURES.replaceAll("\r",""));
	}

	@Test
	public void shouldRenderFeatureDescriptionWithNewLines(){
		List<Feature> features = FeatureParser.parse(FileUtil.findJsonFile("target/test-classes/json-output/sample.json"));
		assertThat(features).hasSize(1);
		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());
		converter.setFilename("target/living_documentation.adoc");
		String resultDoc =	converter.renderDocumentation();
		assertThat(resultDoc).contains("****" + newLine() +
				"As a user  +" + newLine() +
				"I want to do something  +" + newLine() +
				"In order to achieve an important goal" + newLine() +
				"****");
		FileUtil.saveFile("target/sample.adoc", resultDoc);
	}

	@Test
	public void shouldSaveDocumentationIntoDisk(){
		List<Feature> features = FeatureParser.parse(onePassingOneFailing);

		CukedoctorConverter converter = Cukedoctor.instance(features, new DocumentAttributes());
		converter.setFilename("target/generated-test-sources/living documentation.adoc");

		converter.saveDocumentation();
		assertThat(FileUtil.loadFile("target/generated-test-sources/living_documentation.adoc")).exists();
	}

}
