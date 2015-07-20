package com.github.cukedoctor.util;

import static com.github.cukedoctor.util.Constants.newLine;

/**
 * Created by pestano on 07/06/15.
 */
public interface Expectations {

	String SUMMARY_FOR_ONE_FEATURE =
			"== *Summary*" + newLine() +
			"[cols=\"12*^m\", options=\"header,footer\"]" + newLine() +
			"|===" + newLine() +
			"3+|Scenarios 7+|Steps 2+|Features: 1" + newLine() +
			"" + newLine() +
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
			"|Status" + newLine() +
			"" + newLine() +
			"12+^|*<<One-passing-scenario-one-failing-scenario>>*" + newLine() +
			"|1" + newLine() +
			"|1" + newLine() +
			"|2" + newLine() +
			"|1" + newLine() +
			"|1" + newLine() +
			"|0" + newLine() +
			"|0" + newLine() +
			"|0" + newLine() +
			"|0" + newLine() +
			"|2" + newLine() +
			"|010ms" + newLine() +
			"|[red]#*failed*#" + newLine() +
			"12+^|*Totals*" + newLine() +
			"|1|1|2|1|1|0|0|0|0|2 2+|010ms" + newLine() +
			"|===";

	String SUMMARY_FOR_MULTIPLE_FEATURES =
			"== *Summary*"+newLine() +
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine() +
			"|==="+newLine() +
			"3+|Scenarios 7+|Steps 2+|Features: 3"+newLine() +
			""+newLine() +
			"|[green]#*Passed*#"+newLine() +
			"|[red]#*Failed*#"+newLine() +
			"|Total"+newLine() +
			"|[green]#*Passed*#"+newLine() +
			"|[red]#*Failed*#"+newLine() +
			"|[purple]#*Skipped*#"+newLine() +
			"|[maroon]#*Pending*#"+newLine() +
			"|[yellow]#*Undefined*#"+newLine() +
			"|[blue]#*Missing*#"+newLine() +
			"|Total"+newLine() +
			"|Duration"+newLine() +
			"|Status"+newLine() +
			""+newLine() +
			"12+^|*<<An-embed-data-directly-feature>>*"+newLine() +
			"|3"+newLine() +
			"|0"+newLine() +
			"|3"+newLine() +
			"|3"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|3"+newLine() +
			"|000ms"+newLine() +
			"|[green]#*passed*#"+newLine() +
			""+newLine() +
			"12+^|*<<An-outline-feature>>*"+newLine() +
			"|0"+newLine() +
			"|1"+newLine() +
			"|1"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|1"+newLine() +
			"|1"+newLine() +
			"|000ms"+newLine() +
			"|[red]#*failed*#"+newLine() +
			""+newLine() +
			"12+^|*<<One-passing-scenario-one-failing-scenario>>*"+newLine() +
			"|1"+newLine() +
			"|1"+newLine() +
			"|2"+newLine() +
			"|1"+newLine() +
			"|1"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|2"+newLine() +
			"|010ms"+newLine() +
			"|[red]#*failed*#"+newLine() +
			"12+^|*Totals*"+newLine() +
			"|4|2|6|4|1|0|0|0|1|6 2+|010ms"+newLine() +
			"|===";

	String DOCUMENTATION_FOR_ONE_FEATURE = ":toc: left"+newLine() +
			":backend: html5"+newLine() +
			":doctitle: Living Documentation"+newLine() +
			":doctype: book"+newLine() +
			":icons: font"+newLine() +
			":!numbered:"+newLine() +
			":!linkcss:"+newLine() +
			":sectanchors:"+newLine() +
			":sectlink:"+newLine() +
			":docinfo:"+newLine() +
			":toclevels: 3"+newLine() +
			""+newLine() +
			"= *Living Documentation*"+newLine() +
			""+newLine() +
			"== *Summary*"+newLine() +
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine() +
			"|==="+newLine() +
			"3+|Scenarios 7+|Steps 2+|Features: 1"+newLine() +
			""+newLine() +
			"|[green]#*Passed*#"+newLine() +
			"|[red]#*Failed*#"+newLine() +
			"|Total"+newLine() +
			"|[green]#*Passed*#"+newLine() +
			"|[red]#*Failed*#"+newLine() +
			"|[purple]#*Skipped*#"+newLine() +
			"|[maroon]#*Pending*#"+newLine() +
			"|[yellow]#*Undefined*#"+newLine() +
			"|[blue]#*Missing*#"+newLine() +
			"|Total"+newLine() +
			"|Duration"+newLine() +
			"|Status"+newLine() +
			""+newLine() +
			"12+^|*<<One-passing-scenario-one-failing-scenario>>*"+newLine() +
			"|1"+newLine() +
			"|1"+newLine() +
			"|2"+newLine() +
			"|1"+newLine() +
			"|1"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|2"+newLine() +
			"|010ms"+newLine() +
			"|[red]#*failed*#"+newLine() +
			"12+^|*Totals*"+newLine() +
			"|1|1|2|1|1|0|0|0|0|2 2+|010ms"+newLine() +
			"|==="+newLine() +
			""+newLine() +
			"== *Features*"+newLine() +
			""+newLine() +
			"[[One-passing-scenario-one-failing-scenario, One passing scenario, one failing scenario]]"+newLine() +
			"=== *One passing scenario, one failing scenario*"+newLine() +
			""+newLine() +
			"++++"+newLine() +
			"<span class=\"fa fa-minus-square fa-fw\" style=\"cursor:pointer;float:right;margin-top:-30px\" title=\"minimize\" onclick=\"hideFeatureScenarios('One-passing-scenario-one-failing-scenario');document.getElementById('hidden-One-passing-scenario-one-failing-scenario').style.display = 'inline';this.style.display = 'none'\">  </span>"+newLine() +
			""+newLine() +
			"<span id=\"hidden-One-passing-scenario-one-failing-scenario\" class=\"fa fa-plus-square fa-fw\" style=\"cursor:pointer;float:right;display:none;margin-top:-30px\" title=\"maximize feature\" onclick=\"showFeatureScenarios('One-passing-scenario-one-failing-scenario'); this.style.display = 'none'\">  </span>"+newLine() +
			"++++"+newLine() +
			"==== Scenario: Passing"+newLine() +
			"[small]#tags: @a,@b#"+newLine() +
			""+newLine() +
			"****"+newLine() +
			"Given ::"+newLine() +
			"this step passes icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#"+newLine() +
			"****"+newLine() +
			""+newLine() +
			"==== Scenario: Failing"+newLine() +
			"[small]#tags: @a,@c#"+newLine() +
			""+newLine() +
			"****"+newLine() +
			"Given ::"+newLine() +
			"this step fails icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(008ms)#"+newLine() +
			""+newLine() +
			"IMPORTANT:  (RuntimeError)"+newLine() +
			"./features/step_definitions/steps.rb:4:in /^this step fails$/'"+newLine() +
			"features/one_passing_one_failing.feature:10:in Given this step fails'"+newLine() +
			"****"+newLine() +
			""+newLine() +
			""+newLine() +
			"++++"+newLine() +
			"<script type=\"text/javascript\">"+newLine() +
			"\tfunction showFeatureScenarios(featureId){"+newLine() +
			"\t\tvar element = document.getElementById(featureId).parentNode;"+newLine() +
			"\t\tfor (var i = 0; i < element.childNodes.length; i++) {"+newLine() +
			"    \t\tif (element.childNodes[i].className == \"sect3\" || element.childNodes[i].className == \"fa fa-minus-square fa-fw\") {"+newLine() +
			"      \t\t     element.childNodes[i].style.display = 'inline';"+newLine() +
			"    \t\t\t}"+newLine() +
			"    \t\tif (element.childNodes[i].className == \"sidebarblock\") {"+newLine() +
			"      \t\t     element.childNodes[i].style.display = 'block';"+newLine() +
			"    \t\t\t}\t\t\t        "+newLine() +
			"\t\t}"+newLine() +
			"\t\t "+newLine() +
			" \t\tdocument.getElementById(featureId).childNodes[0].click();"+newLine() +
			"\t}"+newLine() +
			""+newLine() +
			"\tfunction hideFeatureScenarios(featureId){"+newLine() +
			"\t\tvar element = document.getElementById(featureId).parentNode;"+newLine() +
			"\t\tfor (var i = 0; i < element.childNodes.length; i++) {"+newLine() +
			"    \t\tif (element.childNodes[i].className == \"sect3\" || element.childNodes[i].className == \"sidebarblock\") { "+newLine() +
			"      \t\t     element.childNodes[i].style.display = 'none';\t   \t\t    "+newLine() +
			"                 \t}"+newLine() +
			"\t\t      "+newLine() +
			"\t\t}"+newLine() +
			"\t   document.getElementById(featureId).childNodes[0].click();"+newLine() +
			" \t}"+newLine() +
			""+newLine() +
			"</script>"+newLine() +
			"++++";

	String DOCUMENTATION_FOR_MULTIPLE_FEATURES = ":toc: left"+newLine() +
			":backend: html5"+newLine() +
			":doctitle: Living Documentation"+newLine() +
			":doctype: book"+newLine() +
			":icons: font"+newLine() +
			":!numbered:"+newLine() +
			":!linkcss:"+newLine() +
			":sectanchors:"+newLine() +
			":sectlink:"+newLine() +
			":docinfo:"+newLine() +
			":toclevels: 3"+newLine() +
			""+newLine() +
			"= *Living Documentation*"+newLine() +
			""+newLine() +
			"== *Summary*"+newLine() +
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine() +
			"|==="+newLine() +
			"3+|Scenarios 7+|Steps 2+|Features: 3"+newLine() +
			""+newLine() +
			"|[green]#*Passed*#"+newLine() +
			"|[red]#*Failed*#"+newLine() +
			"|Total"+newLine() +
			"|[green]#*Passed*#"+newLine() +
			"|[red]#*Failed*#"+newLine() +
			"|[purple]#*Skipped*#"+newLine() +
			"|[maroon]#*Pending*#"+newLine() +
			"|[yellow]#*Undefined*#"+newLine() +
			"|[blue]#*Missing*#"+newLine() +
			"|Total"+newLine() +
			"|Duration"+newLine() +
			"|Status"+newLine() +
			""+newLine() +
			"12+^|*<<An-embed-data-directly-feature>>*"+newLine() +
			"|3"+newLine() +
			"|0"+newLine() +
			"|3"+newLine() +
			"|3"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|3"+newLine() +
			"|000ms"+newLine() +
			"|[green]#*passed*#"+newLine() +
			""+newLine() +
			"12+^|*<<An-outline-feature>>*"+newLine() +
			"|0"+newLine() +
			"|1"+newLine() +
			"|1"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|1"+newLine() +
			"|1"+newLine() +
			"|000ms"+newLine() +
			"|[red]#*failed*#"+newLine() +
			""+newLine() +
			"12+^|*<<One-passing-scenario-one-failing-scenario>>*"+newLine() +
			"|1"+newLine() +
			"|1"+newLine() +
			"|2"+newLine() +
			"|1"+newLine() +
			"|1"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|2"+newLine() +
			"|010ms"+newLine() +
			"|[red]#*failed*#"+newLine() +
			"12+^|*Totals*"+newLine() +
			"|4|2|6|4|1|0|0|0|1|6 2+|010ms"+newLine() +
			"|==="+newLine() +
			""+newLine() +
			"== *Features*"+newLine() +
			""+newLine() +
			"[[An-embed-data-directly-feature, An embed data directly feature]]"+newLine() +
			"=== *An embed data directly feature*"+newLine() +
			""+newLine() +
			"++++"+newLine() +
			"<span class=\"fa fa-minus-square fa-fw\" style=\"cursor:pointer;float:right;margin-top:-30px\" title=\"minimize\" onclick=\"hideFeatureScenarios('An-embed-data-directly-feature');document.getElementById('hidden-An-embed-data-directly-feature').style.display = 'inline';this.style.display = 'none'\">  </span>"+newLine() +
			""+newLine() +
			"<span id=\"hidden-An-embed-data-directly-feature\" class=\"fa fa-plus-square fa-fw\" style=\"cursor:pointer;float:right;display:none;margin-top:-30px\" title=\"maximize feature\" onclick=\"showFeatureScenarios('An-embed-data-directly-feature'); this.style.display = 'none'\">  </span>"+newLine() +
			"++++"+newLine() +
			"==== Scenario: scenario 1"+newLine() +
			"****"+newLine() +
			"Given ::"+newLine() +
			"I embed data directly icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"+newLine() +
			"****"+newLine() +
			""+newLine() +
			"==== Scenario Outline: scenario 2"+newLine() +
			"****"+newLine() +
			"Given ::"+newLine() +
			"I embed data directly icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"+newLine() +
			"****"+newLine() +
			""+newLine() +
			"****"+newLine() +
			"Given ::"+newLine() +
			"I embed data directly icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"+newLine() +
			"****"+newLine() +
			""+newLine() +
			"[[An-outline-feature, An outline feature]]"+newLine() +
			"=== *An outline feature*"+newLine() +
			""+newLine() +
			"++++"+newLine() +
			"<span class=\"fa fa-minus-square fa-fw\" style=\"cursor:pointer;float:right;margin-top:-30px\" title=\"minimize\" onclick=\"hideFeatureScenarios('An-outline-feature');document.getElementById('hidden-An-outline-feature').style.display = 'inline';this.style.display = 'none'\">  </span>"+newLine() +
			""+newLine() +
			"<span id=\"hidden-An-outline-feature\" class=\"fa fa-plus-square fa-fw\" style=\"cursor:pointer;float:right;display:none;margin-top:-30px\" title=\"maximize feature\" onclick=\"showFeatureScenarios('An-outline-feature'); this.style.display = 'none'\">  </span>"+newLine() +
			"++++"+newLine() +
			"==== Scenario Outline: outline"+newLine() +
			""+newLine() +
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
			""+newLine() +
			"[[One-passing-scenario-one-failing-scenario, One passing scenario, one failing scenario]]"+newLine() +
			"=== *One passing scenario, one failing scenario*"+newLine() +
			""+newLine() +
			"++++"+newLine() +
			"<span class=\"fa fa-minus-square fa-fw\" style=\"cursor:pointer;float:right;margin-top:-30px\" title=\"minimize\" onclick=\"hideFeatureScenarios('One-passing-scenario-one-failing-scenario');document.getElementById('hidden-One-passing-scenario-one-failing-scenario').style.display = 'inline';this.style.display = 'none'\">  </span>"+newLine() +
			""+newLine() +
			"<span id=\"hidden-One-passing-scenario-one-failing-scenario\" class=\"fa fa-plus-square fa-fw\" style=\"cursor:pointer;float:right;display:none;margin-top:-30px\" title=\"maximize feature\" onclick=\"showFeatureScenarios('One-passing-scenario-one-failing-scenario'); this.style.display = 'none'\">  </span>"+newLine() +
			"++++"+newLine() +
			"==== Scenario: Passing"+newLine() +
			"[small]#tags: @a,@b#"+newLine() +
			""+newLine() +
			"****"+newLine() +
			"Given ::"+newLine() +
			"this step passes icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#"+newLine() +
			"****"+newLine() +
			""+newLine() +
			"==== Scenario: Failing"+newLine() +
			"[small]#tags: @a,@c#"+newLine() +
			""+newLine() +
			"****"+newLine() +
			"Given ::"+newLine() +
			"this step fails icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(008ms)#"+newLine() +
			""+newLine() +
			"IMPORTANT:  (RuntimeError)"+newLine() +
			"./features/step_definitions/steps.rb:4:in /^this step fails$/'"+newLine() +
			"features/one_passing_one_failing.feature:10:in Given this step fails'"+newLine() +
			"****"+newLine() +
			""+newLine() +
			""+newLine() +
			"++++"+newLine() +
			"<script type=\"text/javascript\">"+newLine() +
			"\tfunction showFeatureScenarios(featureId){"+newLine() +
			"\t\tvar element = document.getElementById(featureId).parentNode;"+newLine() +
			"\t\tfor (var i = 0; i < element.childNodes.length; i++) {"+newLine() +
			"    \t\tif (element.childNodes[i].className == \"sect3\" || element.childNodes[i].className == \"fa fa-minus-square fa-fw\") {"+newLine() +
			"      \t\t     element.childNodes[i].style.display = 'inline';"+newLine() +
			"    \t\t\t}"+newLine() +
			"    \t\tif (element.childNodes[i].className == \"sidebarblock\") {"+newLine() +
			"      \t\t     element.childNodes[i].style.display = 'block';"+newLine() +
			"    \t\t\t}\t\t\t        "+newLine() +
			"\t\t}"+newLine() +
			"\t\t "+newLine() +
			" \t\tdocument.getElementById(featureId).childNodes[0].click();"+newLine() +
			"\t}"+newLine() +
			""+newLine() +
			"\tfunction hideFeatureScenarios(featureId){"+newLine() +
			"\t\tvar element = document.getElementById(featureId).parentNode;"+newLine() +
			"\t\tfor (var i = 0; i < element.childNodes.length; i++) {"+newLine() +
			"    \t\tif (element.childNodes[i].className == \"sect3\" || element.childNodes[i].className == \"sidebarblock\") { "+newLine() +
			"      \t\t     element.childNodes[i].style.display = 'none';\t   \t\t    "+newLine() +
			"                 \t}"+newLine() +
			"\t\t      "+newLine() +
			"\t\t}"+newLine() +
			"\t   document.getElementById(featureId).childNodes[0].click();"+newLine() +
			" \t}"+newLine() +
			""+newLine() +
			"</script>"+newLine() +
			"++++";

	String FEATURE_WITH_STEP_TABLE = ":toc: right"+newLine() +
			":backend: html5"+newLine() +
			":doctitle: Doc Title"+newLine() +
			":doctype: book"+newLine() +
			":icons: font"+newLine() +
			":!numbered:"+newLine() +
			":!linkcss:"+newLine() +
			":sectanchors:"+newLine() +
			":sectlink:"+newLine() +
			":docinfo:"+newLine() +
			":toclevels: 3"+newLine() +
			""+newLine() +
			"= *Doc Title*"+newLine() +
			""+newLine() +
			"== *Summary*"+newLine() +
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine() +
			"|==="+newLine() +
			"3+|Scenarios 7+|Steps 2+|Features: 1"+newLine() +
			""+newLine() +
			"|[green]#*Passed*#"+newLine() +
			"|[red]#*Failed*#"+newLine() +
			"|Total"+newLine() +
			"|[green]#*Passed*#"+newLine() +
			"|[red]#*Failed*#"+newLine() +
			"|[purple]#*Skipped*#"+newLine() +
			"|[maroon]#*Pending*#"+newLine() +
			"|[yellow]#*Undefined*#"+newLine() +
			"|[blue]#*Missing*#"+newLine() +
			"|Total"+newLine() +
			"|Duration"+newLine() +
			"|Status"+newLine() +
			""+newLine() +
			"12+^|*<<Search>>*"+newLine() +
			"|1"+newLine() +
			"|0"+newLine() +
			"|1"+newLine() +
			"|1"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|0"+newLine() +
			"|1"+newLine() +
			"|111ms"+newLine() +
			"|[green]#*passed*#"+newLine() +
			"12+^|*Totals*"+newLine() +
			"|1|0|1|1|0|0|0|0|0|1 2+|111ms"+newLine() +
			"|==="+newLine() +
			""+newLine() +
			"== *Features*"+newLine() +
			""+newLine() +
			"[[Search, Search]]"+newLine() +
			"=== *Search*"+newLine() + newLine() +
			"++++"+newLine() +
			"<span class=\"fa fa-minus-square fa-fw\" style=\"cursor:pointer;float:right;margin-top:-30px\" title=\"minimize\" onclick=\"hideFeatureScenarios('Search');document.getElementById('hidden-Search').style.display = 'inline';this.style.display = 'none'\">  </span>"+newLine() +
			""+newLine() +
			"<span id=\"hidden-Search\" class=\"fa fa-plus-square fa-fw\" style=\"cursor:pointer;float:right;display:none;margin-top:-30px\" title=\"maximize feature\" onclick=\"showFeatureScenarios('Search'); this.style.display = 'none'\">  </span>"+newLine() +
			"++++"+newLine() +
			"==== Cenario: Find messages by content"+newLine() +
			"[small]#tags: @txn#"+newLine() +
			""+newLine() +
			"****"+newLine() +
			"Dado ::"+newLine() +
			"a User has posted the following messages: icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(111ms)#"+newLine() +
			""+newLine() +
			""+newLine() +
			"[cols=\"1*\", options=\"header\"]"+newLine() +
			"|==="+newLine() +
			"|content"+newLine() +
			"|I am making dinner"+newLine() +
			"|I just woke up"+newLine() +
			"|I am going to work"+newLine() +
			"|==="+newLine() +
			""+newLine() +
			"----"+newLine() +
			""+newLine() +
			"--"+newLine() +
			"A paragraph in an open block."+newLine() +
			"--"+newLine() +
			""+newLine() +
			"----"+newLine() +
			"****"+newLine() +
			""+newLine() +
			""+newLine() +
			"++++"+newLine() +
			"<script type=\"text/javascript\">"+newLine() +
			"\tfunction showFeatureScenarios(featureId){"+newLine() +
			"\t\tvar element = document.getElementById(featureId).parentNode;"+newLine() +
			"\t\tfor (var i = 0; i < element.childNodes.length; i++) {"+newLine() +
			"    \t\tif (element.childNodes[i].className == \"sect3\" || element.childNodes[i].className == \"fa fa-minus-square fa-fw\") {"+newLine() +
			"      \t\t     element.childNodes[i].style.display = 'inline';"+newLine() +
			"    \t\t\t}"+newLine() +
			"    \t\tif (element.childNodes[i].className == \"sidebarblock\") {"+newLine() +
			"      \t\t     element.childNodes[i].style.display = 'block';"+newLine() +
			"    \t\t\t}\t\t\t        "+newLine() +
			"\t\t}"+newLine() +
			"\t\t "+newLine() +
			" \t\tdocument.getElementById(featureId).childNodes[0].click();"+newLine() +
			"\t}"+newLine() +
			""+newLine() +
			"\tfunction hideFeatureScenarios(featureId){"+newLine() +
			"\t\tvar element = document.getElementById(featureId).parentNode;"+newLine() +
			"\t\tfor (var i = 0; i < element.childNodes.length; i++) {"+newLine() +
			"    \t\tif (element.childNodes[i].className == \"sect3\" || element.childNodes[i].className == \"sidebarblock\") { "+newLine() +
			"      \t\t     element.childNodes[i].style.display = 'none';\t   \t\t    "+newLine() +
			"                 \t}"+newLine() +
			"\t\t      "+newLine() +
			"\t\t}"+newLine() +
			"\t   document.getElementById(featureId).childNodes[0].click();"+newLine() +
			" \t}"+newLine() +
			""+newLine() +
			"</script>"+newLine() +
			"++++";
	 
}
