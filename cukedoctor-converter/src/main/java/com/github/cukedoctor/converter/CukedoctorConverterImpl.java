package com.github.cukedoctor.converter;

import com.github.cukedoctor.api.*;
import com.github.cukedoctor.api.model.*;
import com.github.cukedoctor.config.CukedoctorConfig;
import com.github.cukedoctor.util.FileUtil;
import com.github.cukedoctor.util.Formatter;

import java.io.File;
import java.util.List;

import static com.github.cukedoctor.util.Assert.*;
import static com.github.cukedoctor.util.Constants.Atributes.*;
import static com.github.cukedoctor.util.Constants.Markup.*;
import static com.github.cukedoctor.util.Constants.newLine;


/**
 * Created by pestano on 02/06/15.
 */
public class CukedoctorConverterImpl implements CukedoctorConverter {


	private List<Feature> features;
	private DocumentAttributes documentAttributes;
	private DocWriter<StringBuilder> writer;
	private String filename;

	public CukedoctorConverterImpl(List<Feature> features, DocumentAttributes attrs, DocWriter<StringBuilder> writer) {
		this.features = features;
		this.documentAttributes = attrs;
		this.writer = writer;
	}


	public DocumentAttributes getDocumentAttributes() {
		return documentAttributes;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public StringBuilder getDocumentation() {
		return writer.getCurrentDoc();
	}

	/**
	 * @return a String representation of generated documentation
	 */
	public String renderDocumentation() {
		writer.clear();
		renderAttributes();
		writer.write(newLine());
		writer.write(H1(bold(getDocumentationTitle())), newLine(), newLine());
		if(documentAttributes.isSearchable()){
			addSearchInput();
		}
		renderSummary();
		writer.write(newLine(), newLine());
		writer.write(H2(bold("Features")), newLine(), newLine());
		renderFeatures(features);
		//generateDocInfo();
		//generatePdfTheme();
		generateScripts();

		return writer.getCurrentDoc().toString();
	}

	private void addSearchInput() {
		writer.write("++++",newLine());
		writer.write("<span style=\"float:right\">\n" +
        "\t<input value=\"Filter...\" onclick=\"this.value=''\" title=\"Filter features by title\" onblur=\"searchFeature(this.value);\"/>\n" +
        "</span>\t",newLine());
		writer.write("++++",newLine());
	}

	public String getDocumentationTitle() {
		if(documentAttributes != null && hasText(documentAttributes.getDocTitle())){
			return documentAttributes.getDocTitle();
		} else {
			return CukedoctorConfig.DOCUMENT_TITLE;
		}

	}

	public CukedoctorConverter renderAttributes() {
		if(documentAttributes != null){
			writer.write(toc(documentAttributes.getToc()), newLine()).
					write(backend(documentAttributes.getBackend()), newLine()).
					write(docTitle(documentAttributes.getDocTitle()), newLine()).
					write(docType(documentAttributes.getDocType()), newLine()).
					write(icons(documentAttributes.getIcons()), newLine()).
					write(numbered(documentAttributes.isNumbered()), newLine()).
					write(linkcss(documentAttributes.isLinkCss()), newLine()).
					write(sectAnchors(documentAttributes.isSectAnchors()), newLine()).
					write(sectLink(documentAttributes.isSectLink()), newLine()).
					write(docInfo(documentAttributes.isDocInfo()), newLine()).
					write(tocLevels(documentAttributes.getTocLevels()), newLine());
		}
		return this;
	}

	public CukedoctorConverter generateDocInfo() {
		if (notNull(documentAttributes) && documentAttributes.isDocInfo()) {
			//name must be filename-docinfo.html
			String docInfoName = filename.substring(0, filename.lastIndexOf(".")) + "-docinfo.html";
			File savedFile = FileUtil.copyFile("docinfo.html", docInfoName);
			//docinfo depends on cukedoctor.js and cukedoctor.css
			//save js and css file in same dir as docinfo
			String basePath = "";
			if (contains(filename, "/")) {
				basePath = filename.substring(0, filename.lastIndexOf("/"));
			}
			FileUtil.copyFile("cukedoctor.js", basePath + "/cukedoctor.js");
			FileUtil.copyFile("cukedoctor.css", basePath + "/cukedoctor.css");

		}

		return this;
	}

	public CukedoctorConverter generatePdfTheme() {
		if (notNull(documentAttributes) && documentAttributes.isPdfTheme()) {
			//name must be filename-theme.yml
			String pdfThemeName = filename.substring(0, filename.lastIndexOf(".")) + "-theme.yml";
			FileUtil.copyFile("theme.yml", pdfThemeName);
		}
		return this;
	}

	public CukedoctorConverterImpl renderSummary() {
		writer.write(H2(bold("Summary"))).write(newLine());
		writer.write("[cols=\"12*^m\", options=\"header,footer\"]" + newLine() +
				"|===" + newLine() +
				"3+|Scenarios 7+|Steps 2+|Features: " + features.size() +
				"" + newLine() + newLine() +
				"|[green]#*Passed*#" + newLine() +
				"|[red]#*Failed*#" + newLine() +
				"|Total" + newLine() +
				"|[green]#*Passed*#" + newLine() +
				"|[red]#*Failed*#" + newLine() +
				"|[purple]#*Skipped*#" + newLine() +
				"|[maroon]#*Pending*#" + newLine() +
				"|[yellow]#*Undefined*#" + newLine() +
				"|[blue]#*Missing*#" + newLine() +
				"|Total" + newLine() +
				"|Duration" + newLine() +
				"|Status" + newLine());

		for (Feature feature : features) {
			writer.write(newLine());
			writer.write("12+^" + tableCol(), "*<<", feature.getName().replaceAll(",", "").replaceAll(" ", "-"), ">>*", newLine());
			StepResults stepResults = feature.getStepResults();
			ScenarioResults scenarioResults = feature.getScenarioResults();

			writer.write(tableCol(), scenarioResults.getNumberOfScenariosPassed(), newLine());
			writer.write(tableCol(), scenarioResults.getNumberOfScenariosFailed(), newLine());
			writer.write(tableCol(), scenarioResults.getNumberOfScenarios(), newLine());
			writer.write(tableCol(), stepResults.getNumberOfPasses(), newLine());
			writer.write(tableCol(), stepResults.getNumberOfFailures(), newLine());
			writer.write(tableCol(), stepResults.getNumberOfSkipped(), newLine());
			writer.write(tableCol(), stepResults.getNumberOfPending(), newLine());
			writer.write(tableCol(), stepResults.getNumberOfUndefined(), newLine());
			writer.write(tableCol(), stepResults.getNumberOfMissing(), newLine());
			writer.write(tableCol(), stepResults.getNumberOfSteps(), newLine());
			writer.write(tableCol(), stepResults.getTotalDurationAsString(), newLine());
			writer.write(tableCol(), Status.getStatusColor(feature.getStatus()), newLine());
		}
		renderTotalsRow();
		writer.write(table());
		return this;
	}

	//should be only called inside renderSummary()
	public CukedoctorConverterImpl renderTotalsRow() {
		int totalPassedScenarios = 0;
		int totalFailedScenarios = 0;
		int totalScenarios = 0;
		int totalPassedSteps = 0;
		int totalFailedSteps = 0;
		int totalSkippedSteps = 0;
		int totalPendingSteps = 0;
		int totalMissingSteps = 0;
		int totalUndefinedSteps = 0;
		int totalSteps = 0;
		long totalDuration = 0;
		for (Feature feature : features) {
			totalPassedScenarios += feature.getScenarioResults().getNumberOfScenariosPassed();
			totalFailedScenarios += feature.getScenarioResults().getNumberOfScenariosFailed();
			totalScenarios += feature.getNumberOfScenarios();
			totalPassedSteps += feature.getStepResults().getNumberOfPasses();
			totalFailedSteps += feature.getStepResults().getNumberOfFailures();
			totalSkippedSteps += feature.getStepResults().getNumberOfSkipped();
			totalPendingSteps += feature.getStepResults().getNumberOfPending();
			totalMissingSteps += feature.getStepResults().getNumberOfMissing();
			totalUndefinedSteps += feature.getStepResults().getNumberOfUndefined();
			totalSteps += feature.getNumberOfSteps();
			totalDuration += feature.getStepResults().getTotalDuration();
		}
		writer.write("12+^|*Totals*", newLine()).
				write(tableCol(), totalPassedScenarios, tableCol(), totalFailedScenarios).
				write(tableCol(), totalScenarios).
				write(tableCol(), totalPassedSteps, tableCol(), totalFailedSteps).
				write(tableCol(), totalSkippedSteps, tableCol(), totalPendingSteps).
				write(tableCol(), totalUndefinedSteps, tableCol(), totalMissingSteps).
				write(tableCol(), totalSteps, " 2+", tableCol(), Formatter.formatTime(totalDuration));
		writer.write(newLine());

		return this;
	}

	public CukedoctorConverter renderFeatures(List<Feature> features) {
		for (Feature feature : features) {
			renderFeature(feature);
		}
		return this;
	}


	public CukedoctorConverterImpl renderFeature(Feature feature) {
		if(feature.hasIgnoreDocsTag()){
			return this;
		}
		writer.write(renderFeatureSectionId(feature), newLine());
		writer.write(H3(bold(feature.getName())), newLine(),newLine());
		if(notNull(documentAttributes) && documentAttributes.isMinimizable()){
			renderMinimizable(feature);
		}

		if (hasText(feature.getDescription())) {
			writer.write("****", newLine()).
					//feature description has \n to delimit new lines
							write(feature.getDescription().trim().replaceAll("\\n", " +" + newLine())).
					write(newLine(), "****", newLine(), newLine());
		}


		renderFeatureScenarios(feature);
		return this;
	}

	private void renderMinimizable(Feature feature) {
		String featureId = feature.getName().replaceAll(",", "").replaceAll(" ", "-");
		writer.write("++++",newLine()).
                write("<span class=\"fa fa-minus-square fa-fw\" style=\"cursor:pointer;float:right;margin-top:-30px\" ").
                write("title=\"minimize\" onclick=\"hideFeatureScenarios('" +
						featureId +
						"');document.getElementById('hidden-" +
						featureId +
						"').style.display = 'inline';this.style.display = 'none'\">  </span>", newLine(), newLine());

		writer.write("<span id=\"hidden-" +
                featureId +
                "\" class=\"fa fa-plus-square fa-fw\" style=\"cursor:pointer;float:right;display:none;margin-top:-30px\" ");
		writer.write("title=\"maximize feature\" onclick=\"showFeatureScenarios('" +
                featureId +
                "'); this.style.display = 'none'\">  </span>",newLine(),"++++",newLine());
	}

	public String renderFeatureSectionId(Feature feature) {
		if (isNull(feature) || not(hasText(feature.getName()))) {
			return "";
		}
		//Anchor must not have blanks neither commas to work
		return "[[" + feature.getName().replaceAll(",", "").replaceAll(" ", "-") +
				", " + feature.getName() + "]]";
	}

	public CukedoctorConverterImpl renderFeatureScenarios(Feature feature) {
		for (Scenario scenario : feature.getScenarios()) {
			if(scenario.hasIgnoreDocsTag()){
				continue;
			}
			writer.write(H4(scenario.getKeyword()), ": ", scenario.getName(), newLine());
			if (feature.hasTags() || scenario.hasTags()) {
				renderScenarioTags(feature, scenario);
				writer.write(newLine(), newLine());
			}

			writer.write(scenario.getDescription(), newLine());

			if (scenario.hasExamples()) {
				renderScenarioExamples(scenario);
				continue;
			}

			if (scenario.hasSteps()) {
				renderScenarioSteps(scenario.getSteps());
			}

			writer.write(newLine());
		}
		return this;
	}

	public CukedoctorConverter renderScenarioTags(Feature feature, Scenario scenario) {
		writer.write("[small]#tags: ");
		StringBuilder tags = new StringBuilder();
		if (feature.hasTags()) {
			for (Tag featureTag : feature.getTags()) {
				tags.append(featureTag.getName()).append(",");
			}
		}
		if (scenario.hasTags()) {
			for (Tag scenarioTag : scenario.getTags()) {
				tags.append(scenarioTag.getName()).append(",");
			}
		}
		if (tags.indexOf(",") != -1) {//delete last comma
			tags.deleteCharAt(tags.lastIndexOf(","));
		}
		writer.write(tags.toString());
		writer.write("#");

		return this;
	}

	public CukedoctorConverterImpl renderScenarioSteps(List<Step> steps) {
		writer.write("****", newLine());
		for (Step step : steps) {
			writer.write(step.getKeyword(), "::", newLine());
			writer.write(step.getName() + " ", Status.getStatusIcon(step.getStatus()));
			writer.write(renderStepTime(step.getResult())).write(newLine());

			renderStepTable(step);

			if(notNull(step.getDocString()) && hasText(step.getDocString().getValue())){
				writer.write(listing(),newLine(),newLine());
				writer.write(step.getDocString().getValue().replaceAll("\\n",newLine()));
				writer.write(newLine(),newLine(),listing(),newLine());
			}

			if (step.getResult() != null && !Status.passed.equals(step.getStatus())) {
				if (step.getResult().getErrorMessage() != null) {
					writer.write(newLine(), "IMPORTANT: ", step.getResult().getErrorMessage(), newLine());
				}
			}
		}
		writer.write("****", newLine());
		return this;
	}

	public CukedoctorConverter renderStepTable(Step step) {
		if (notEmpty(step.getRows())) {
			writer.write(newLine(),newLine(),"[cols=\"" + step.getRows()[0].getCells().length + "*\", options=\"header\"]", newLine());
			writer.write(table(), newLine());
			Row header = step.getRows()[0];
			for (String col : header.getCells()) {
				writer.write(tableCol(), col, newLine());
			}

			for (int i = 1; i < step.getRows().length; i++) {
				for (String cell : step.getRows()[i].getCells()) {
					writer.write(tableCol(), cell, newLine());
				}
			}
			writer.write(table(),newLine(),newLine());
		}

		return this;
	}

	public String renderStepTime(Result result) {
		if (result == null || result.getDuration() == null) {
			return "";
		}
		return " [small right]#(" + Formatter.formatTime(result.getDuration()) + ")#";
	}


	@Override
	public CukedoctorConverter setFilename(String filename) {
		if (filename == null) {
			filename = getDocumentationTitle();
		}
		if (!filename.contains(".")) {
			filename = filename + ".adoc";
		}
		filename = filename.replaceAll(" ", "_");//remove blank spaces with underline

		if (!FileUtil.ADOC_FILE_EXTENSION.matcher(filename).matches()) {
			throw new RuntimeException("Invalid filename extension for file: " + filename + ". Valid formats are: ad, adoc, asciidoc and asc");
		}


		this.filename = filename;
		return this;
	}

	@Override
	public String getFilename() {
		return filename;
	}

	public CukedoctorConverter saveDocumentation() {
		FileUtil.saveFile(filename, renderDocumentation());
		return this;
	}

	@Override
	public CukedoctorConverter renderScenarioExamples(Scenario scenario) {
		if (scenario.hasExamples()) {
			writer.write(newLine());
			for (Example example : scenario.getExamples()) {
				writer.write("." + (example.getName() == null || "".equals(example.getName()) ? "Example" : example.getName()), newLine());
				writer.write("[cols=\"" + example.getRows()[0].getCells().length + "*\", options=\"header\"]", newLine());
				writer.write(table(), newLine());
				Row header = example.getRows()[0];
				for (String col : header.getCells()) {
					writer.write(tableCol(), col, newLine());
				}

				for (int i = 1; i < example.getRows().length; i++) {
					for (String cell : example.getRows()[i].getCells()) {
						writer.write(tableCol(), cell, newLine());
					}
				}
				writer.write(table(), newLine(), newLine());
			}
		}
		return this;
	}

	private void generateScripts() {
		if(documentAttributes != null && documentAttributes.isMinimizable()) {
			writer.write(newLine(), "++++", newLine()).
					write("<script type=\"text/javascript\">" + newLine() +
							"\tfunction showFeatureScenarios(featureId){" + newLine() +
							"\t\tvar element = document.getElementById(featureId).parentNode;" + newLine() +
							"\t\tfor (var i = 0; i < element.childNodes.length; i++) {" + newLine() +
							"    \t\tif (element.childNodes[i].className == \"sect3\" || element.childNodes[i].className == \"fa fa-minus-square fa-fw\") {" + newLine() +
							"      \t\t     element.childNodes[i].style.display = 'inline';" + newLine() +
							"    \t\t\t}" + newLine() +
							"    \t\tif (element.childNodes[i].className == \"sidebarblock\") {" + newLine() +
							"      \t\t     element.childNodes[i].style.display = 'block';" + newLine() +
							"    \t\t\t}\t\t\t        " + newLine() +
							"\t\t}" + newLine() +
							"\t\t " + newLine() +
							" \t\tdocument.getElementById(featureId).childNodes[0].click();" + newLine() +
							"\t}" + newLine() +
							"" + newLine() +
							"\tfunction hideFeatureScenarios(featureId){" + newLine() +
							"\t\tvar element = document.getElementById(featureId).parentNode;" + newLine() +
							"\t\tfor (var i = 0; i < element.childNodes.length; i++) {" + newLine() +
							"    \t\tif (element.childNodes[i].className == \"sect3\" || element.childNodes[i].className == \"sidebarblock\") { " + newLine() +
							"      \t\t     element.childNodes[i].style.display = 'none';\t   \t\t    " + newLine() +
							"                 \t}" + newLine() +
							"\t\t      " + newLine() +
							"\t\t}" + newLine() +
							"\t   document.getElementById(featureId).childNodes[0].click();" + newLine() +
							" \t}" + newLine() +
							"" + newLine() +
							"</script>").
					write(newLine(), "++++");
		}

		if(documentAttributes != null && documentAttributes.isSearchable()) {
			writer.write(newLine(), "++++", newLine()).
					write("<script type = \"text/javascript\" >"+newLine() +
					"var allLevel2ListItens = null;"+newLine() +
							""+newLine() +
							"function searchFeature(criteria) {"+newLine() +
							"    if (criteria != null && criteria.length >= 3) {"+newLine() +
							"        var sect2List = document.getElementsByClassName(\"sect2\");"+newLine() +
							"        var firstMatch = null;"+newLine() +
							"        if (sect2List != null) {"+newLine() +
							"            for (var i = 0; i < sect2List.length; i++) {"+newLine() +
							"                var h3 = null;"+newLine() +
							"                for (var j = 0; j < sect2List[i].childNodes.length; j++) {"+newLine() +
							"                    if (sect2List[i].childNodes[j].tagName && sect2List[i].childNodes[j].tagName.toUpperCase() == \"H3\") {"+newLine() +
							"                        h3 = sect2List[i].childNodes[j];"+newLine() +
							"                        break;"+newLine() +
							"                    }"+newLine() +
							"                }"+newLine() +
							"                if (h3 != null && h3.id != null) {"+newLine() +
							"                    if (!h3.id.toLowerCase().match(criteria.toLowerCase())) {"+newLine() +
							"                        sect2List[i].style.display = 'none';"+newLine() +
							"                    } else {//match"+newLine() +
							"                        sect2List[i].style.display = 'inline';"+newLine() +
							"                        if (firstMatch == null) {"+newLine() +
							"                            //used to scroll to after search"+newLine() +
							"                            firstMatch = h3;"+newLine() +
							"                        }"+newLine() +
							"                        //filter toc"+newLine() +
							"                        filterToc(criteria);"+newLine() +
							"                    }"+newLine() +
							"                }"+newLine() +
							"            }//end for"+newLine() +
							""+newLine() +
							"        }//sect2List != null"+newLine() +
							"        if (firstMatch != null) {"+newLine() +
							"            animate(document.body, \"scrollTop\", \"\", 0, firstMatch.offsetTop, 200, true);"+newLine() +
							"        }"+newLine() +
							""+newLine() +
							""+newLine() +
							"    }//end criteria.length >=3"+newLine() +
							"    else {//clear search"+newLine() +
							"        clearSearch();"+newLine() +
							"    }"+newLine() +
							"}"+newLine() +
							""+newLine() +
							"function clearSearch() {"+newLine() +
							"    var sect2List = document.getElementsByClassName(\"sect2\");"+newLine() +
							"    if (sect2List != null) {"+newLine() +
							"        for (var i = 0; i < sect2List.length; i++) {"+newLine() +
							"            sect2List[i].style.display = 'inline';"+newLine() +
							"        }//end for"+newLine() +
							"    }//end elements != null"+newLine() +
							""+newLine() +
							"    if (allLevel2ListItens == null) {"+newLine() +
							"        collectallLevel2IListItens();"+newLine() +
							"    }"+newLine() +
							"    for (var z = 0; z < allLevel2ListItens.length; z++) {"+newLine() +
							"        allLevel2ListItens[z].style.display = 'inline';"+newLine() +
							"    }"+newLine() +
							"    if (document.getElementById('input-search')) {"+newLine() +
							"        document.getElementById('input-search').value = 'Filter...';"+newLine() +
							"    }"+newLine() +
							"}"+newLine() +
							""+newLine() +
							"function filterToc(criteria) {"+newLine() +
							"    if (allLevel2ListItens == null) {"+newLine() +
							"        collectallLevel2IListItens();"+newLine() +
							"    }"+newLine() +
							"    for (var z = 0; z < allLevel2ListItens.length; z++) {"+newLine() +
							"        if (allLevel2ListItens[z].childNodes[0].tagName && allLevel2ListItens[z].childNodes[0].tagName.toLowerCase() == \"a\") {"+newLine() +
							"            if (allLevel2ListItens[z].childNodes[0].getAttribute(\"href\").toUpperCase().substring(1).match(criteria.toUpperCase())) {"+newLine() +
							"                allLevel2ListItens[z].style.display = 'inline';"+newLine() +
							"            } else {"+newLine() +
							"                allLevel2ListItens[z].style.display = 'none';"+newLine() +
							"            }"+newLine() +
							"        }"+newLine() +
							"    }//end for allListItens"+newLine() +
							"}"+newLine() +
							""+newLine() +
							"function animate(elem, style, unit, from, to, time, prop) {"+newLine() +
							"    if (!elem) return;"+newLine() +
							"    var start = new Date().getTime(),"+newLine() +
							"        timer = setInterval(function () {"+newLine() +
							"            var step = Math.min(1, (new Date().getTime() - start) / time);"+newLine() +
							"            if (prop) {"+newLine() +
							"                elem[style] = (from + step * (to - from)) + unit;"+newLine() +
							"            } else {"+newLine() +
							"                elem.style[style] = (from + step * (to - from)) + unit;"+newLine() +
							"            }"+newLine() +
							"            if (step == 1) clearInterval(timer);"+newLine() +
							"        }, 25);"+newLine() +
							"    elem.style[style] = from + unit;"+newLine() +
							"}"+newLine() +
							""+newLine() +
							"function collectallLevel2IListItens() {"+newLine() +
							"    allLevel2ListItens = new Array();"+newLine() +
							"    var uls = document.getElementsByClassName('sectlevel2');"+newLine() +
							"    for (var i = 0; i < uls.length; i++) {"+newLine() +
							"        for (var j = 0; j < uls[i].childNodes.length; j++) {"+newLine() +
							"            if (uls[i].childNodes[j].tagName) {"+newLine() +
							"                if (uls[i].childNodes[j].tagName.toLowerCase() == 'li') {"+newLine() +
							"                    allLevel2ListItens.push(uls[i].childNodes[j]);"+newLine() +
							"                }"+newLine() +
							""+newLine() +
							"            }"+newLine() +
							""+newLine() +
							""+newLine() +
							"        } //end for uls child"+newLine() +
							"    }//end for uls"+newLine() +
							""+newLine() +
							"}" +
					"", newLine(), "</script>", newLine(), "++++");
		}

	}

}
