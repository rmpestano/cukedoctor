package com.github.cukedoctor.converter;

import static com.github.cukedoctor.util.Constants.newLine;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.cukedoctor.Cukedoctor;
import com.github.cukedoctor.api.CukedoctorConverter;
import com.github.cukedoctor.api.DocumentAttributes;
import com.github.cukedoctor.api.model.Feature;
import com.github.cukedoctor.api.model.Tag;
import com.github.cukedoctor.parser.FeatureParser;
import com.github.cukedoctor.renderer.CukedoctorSummaryRenderer;
import com.github.cukedoctor.spi.SummaryRenderer;
import com.github.cukedoctor.util.Expectations;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.builder.FeatureBuilder;


/**
 * Created by pestano on 02/06/15.
 */
@RunWith(JUnit4.class)
public class CukedoctorConverterTest {

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
		SummaryRenderer summaryRenderer = new CukedoctorSummaryRenderer();
		assertThat(summaryRenderer.renderSummary(features)).isNotNull().
				containsOnlyOnce("12+^|*Totals*").
				contains("|1|1|2|1|1|0|0|0|0|2 2+|010ms");
	}

	@Test
	public void shouldRenderTotalRowForMultipleFeature() {
		List<Feature> features = FeatureParser.parse(onePassingOneFailing, embedDataDirectly, outline, invalidFeatureResult);
		SummaryRenderer summaryRenderer = new CukedoctorSummaryRenderer();
		assertThat(summaryRenderer.renderSummary(features)).isNotNull().
				containsOnlyOnce("12+^|*Totals*").
				contains("|4|1|5|4|1|0|0|0|0|5 2+|010ms");
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


	@Test
	public void shouldEnrichFeature(){
		List<Feature> features = FeatureParser.findAndParse("target/test-classes/json-output/enrichment");
		assertThat(features).isNotNull().hasSize(1);
		String output = Cukedoctor.instance(features).renderFeatures(features).getDocumentation();
		assertThat(output.replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "")).isEqualTo(("[[Calculator, Calculator]]" + newLine()+
				"=== *Calculator*" + newLine()+
				newLine()+
				"==== Scenario: Adding numbers" + newLine()+
				"You can use *asciidoc markup* in _feature_ #description#." + newLine()+
				newLine()+
				"NOTE: This is a very important feature!" + newLine()+
				newLine()+
				"****" + newLine()+
				"Given ::" + newLine()+
				"I have numbers 1 and 2 icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(114ms)#" + newLine()+
				newLine()+
				"IMPORTANT: Asciidoc markup inside *steps* must be surrounded by *curly brackets*." + newLine()+
				newLine()+
				"When ::" + newLine()+
				"I sum the numbers icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#" + newLine()+
				" "+newLine() +
				"NOTE: Steps comments are placed *before* each steps so this comment is for the *WHEN* step." + newLine()+
				newLine() +
				"Then ::" +newLine()+
				"I should have 3 as result icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#" + newLine()+
				" "+newLine() +
				"* this is a list of itens inside a feature step" + newLine()+
				" "+newLine() +
				"* there is no multiline comment in gherkin" +newLine() +
				" "+newLine() +
				"** second level list item" + newLine()+
				newLine() +
				"****"+newLine()+newLine()).replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", ""));
	}

}
