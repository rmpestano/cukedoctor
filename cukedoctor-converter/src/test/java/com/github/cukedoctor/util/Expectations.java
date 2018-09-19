package com.github.cukedoctor.util;

import static com.github.cukedoctor.util.Constants.home;
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
			"|==="+newLine()+newLine();

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
					"|0"+newLine() +
					"|0"+newLine() +
					"|0"+newLine() +
					"|0"+newLine() +
					"|0"+newLine() +
					"|0"+newLine() +
					"|0"+newLine() +
					"|0"+newLine() +
					"|0"+newLine() +
					"|000ms"+newLine() +
					"|[green]#*passed*#"+newLine() +
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
					"|4|1|5|4|1|0|0|0|0|5 2+|010ms"+newLine() +
					"|==="+newLine()+newLine();

	String DOCUMENTATION_FOR_ONE_FEATURE = ":toc: left"+newLine()+ 
			":backend: html5"+newLine()+ 
			":doctitle: Living Documentation"+newLine()+ 
			":doctype: book"+newLine()+ 
			":icons: font"+newLine()+ 
			":!numbered:"+newLine()+ 
			":!linkcss:"+newLine()+ 
			":sectanchors:"+newLine()+ 
			":sectlink:"+newLine()+ 
			":docinfo:"+newLine()+ 
			":source-highlighter: highlightjs"+newLine()+ 
			":toclevels: 3"+newLine()+ 
			":hardbreaks:"+newLine()+ 
			":chapter-label: Chapter"+newLine()+ 
			":version-label: Version"+newLine()+ 
			""+newLine()+ 
			"= *Living Documentation*"+newLine()+ 
			""+newLine()+ 
			"include::"+home()+"cukedoctor-intro.adoc[leveloffset=+1]"+newLine() +
			""+newLine()+ 
			"== *Summary*"+newLine()+ 
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine()+ 
			"|==="+newLine()+ 
			"3+|Scenarios 7+|Steps 2+|Features: 1"+newLine()+ 
			""+newLine()+ 
			"|[green]#*Passed*#"+newLine()+ 
			"|[red]#*Failed*#"+newLine()+ 
			"|Total"+newLine()+ 
			"|[green]#*Passed*#"+newLine()+ 
			"|[red]#*Failed*#"+newLine()+ 
			"|[purple]#*Skipped*#"+newLine()+ 
			"|[maroon]#*Pending*#"+newLine()+ 
			"|[yellow]#*Undefined*#"+newLine()+ 
			"|[blue]#*Missing*#"+newLine()+ 
			"|Total"+newLine()+ 
			"|Duration"+newLine()+ 
			"|Status"+newLine()+ 
			""+newLine()+ 
			"12+^|*<<One-passing-scenario-one-failing-scenario>>*"+newLine()+ 
			"|1"+newLine()+ 
			"|1"+newLine()+ 
			"|2"+newLine()+ 
			"|1"+newLine()+ 
			"|1"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|2"+newLine()+ 
			"|010ms"+newLine()+ 
			"|[red]#*failed*#"+newLine()+ 
			"12+^|*Totals*"+newLine()+ 
			"|1|1|2|1|1|0|0|0|0|2 2+|010ms"+newLine()+ 
			"|==="+newLine()+ 
			""+newLine()+ 
			"== *Features*"+newLine()+ 
			""+newLine()+ 
			"[[One-passing-scenario-one-failing-scenario, One passing scenario, one failing scenario]]"+newLine()+ 
			"=== *One passing scenario, one failing scenario*"+newLine()+ 
			""+newLine()+ 
			"ifndef::backend-pdf[]"+newLine()+ 
			"minmax::One-passing-scenario-one-failing-scenario[]"+newLine()+ 
			"endif::[]"+newLine()+ 
			"==== Scenario: Passing"+newLine()+ 
			"[small]#tags: @a,@b#"+newLine()+ 
			""+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"this step passes icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"==== Scenario: Failing icon:thumbs-down[role=\"red\",title=\"Failed\"]"+newLine()+ 
			"[small]#tags: @a,@c#"+newLine()+ 
			""+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"this step fails icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(008ms)#"+newLine()+ 
			""+newLine()+ 
			"IMPORTANT:  (RuntimeError)"+newLine()+ 
			"./features/step_definitions/steps.rb:4:in /^this step fails$/'"+newLine()+ 
			"features/one_passing_one_failing.feature:10:in Given this step fails'"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"";

	String DOCUMENTATION_WITHOUT_FEATURES_SECTION = ":toc: left"+newLine()+ 
			":backend: html5"+newLine()+ 
			":doctitle: Living Documentation"+newLine()+ 
			":doctype: book"+newLine()+ 
			":icons: font"+newLine()+ 
			":!numbered:"+newLine()+ 
			":!linkcss:"+newLine()+ 
			":sectanchors:"+newLine()+ 
			":sectlink:"+newLine()+ 
			":docinfo:"+newLine()+ 
			":source-highlighter: highlightjs"+newLine()+ 
			":toclevels: 3"+newLine()+ 
			":hardbreaks:"+newLine()+ 
			":chapter-label: Chapter"+newLine()+ 
			":version-label: Version"+newLine()+ 
			""+newLine()+ 
			"= *Living Documentation*"+newLine()+ 
			""+newLine()+ 
			"include::"+home()+"cukedoctor-intro.adoc[leveloffset=+1]"+newLine() +
			""+newLine()+ 
			"== *Summary*"+newLine()+ 
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine()+ 
			"|==="+newLine()+ 
			"3+|Scenarios 7+|Steps 2+|Features: 1"+newLine()+ 
			""+newLine()+ 
			"|[green]#*Passed*#"+newLine()+ 
			"|[red]#*Failed*#"+newLine()+ 
			"|Total"+newLine()+ 
			"|[green]#*Passed*#"+newLine()+ 
			"|[red]#*Failed*#"+newLine()+ 
			"|[purple]#*Skipped*#"+newLine()+ 
			"|[maroon]#*Pending*#"+newLine()+ 
			"|[yellow]#*Undefined*#"+newLine()+ 
			"|[blue]#*Missing*#"+newLine()+ 
			"|Total"+newLine()+ 
			"|Duration"+newLine()+ 
			"|Status"+newLine()+ 
			""+newLine()+ 
			"12+^|*<<One-passing-scenario-one-failing-scenario>>*"+newLine()+ 
			"|1"+newLine()+ 
			"|1"+newLine()+ 
			"|2"+newLine()+ 
			"|1"+newLine()+ 
			"|1"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|2"+newLine()+ 
			"|010ms"+newLine()+ 
			"|[red]#*failed*#"+newLine()+ 
			"12+^|*Totals*"+newLine()+ 
			"|1|1|2|1|1|0|0|0|0|2 2+|010ms"+newLine()+ 
			"|==="+newLine()+ 
			""+newLine()+ 
			"[[One-passing-scenario-one-failing-scenario, One passing scenario, one failing scenario]]"+newLine()+ 
			"== *One passing scenario, one failing scenario*"+newLine()+ 
			""+newLine()+ 
			"ifndef::backend-pdf[]"+newLine()+ 
			"minmax::One-passing-scenario-one-failing-scenario[]"+newLine()+ 
			"endif::[]"+newLine()+ 
			"=== Scenario: Passing"+newLine()+ 
			"[small]#tags: @a,@b#"+newLine()+ 
			""+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"this step passes icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"=== Scenario: Failing icon:thumbs-down[role=\"red\",title=\"Failed\"]"+newLine()+ 
			"[small]#tags: @a,@c#"+newLine()+ 
			""+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"this step fails icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(008ms)#"+newLine()+ 
			""+newLine()+ 
			"IMPORTANT:  (RuntimeError)"+newLine()+ 
			"./features/step_definitions/steps.rb:4:in /^this step fails$/'"+newLine()+ 
			"features/one_passing_one_failing.feature:10:in Given this step fails'"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"";

	String DOCUMENTATION_WITHOUT_FEATURES_AND_SUMMARY_SECTIONS = ":toc: left"+newLine()+ 
			":backend: html5"+newLine()+ 
			":doctitle: Living Documentation"+newLine()+ 
			":doctype: book"+newLine()+ 
			":icons: font"+newLine()+ 
			":!numbered:"+newLine()+ 
			":!linkcss:"+newLine()+ 
			":sectanchors:"+newLine()+ 
			":sectlink:"+newLine()+ 
			":docinfo:"+newLine()+ 
			":source-highlighter: highlightjs"+newLine()+ 
			":toclevels: 3"+newLine()+ 
			":hardbreaks:"+newLine()+ 
			":chapter-label: Chapter"+newLine()+ 
			":version-label: Version"+newLine()+ 
			""+newLine()+ 
			"= *Living Documentation*"+newLine()+ 
			""+newLine()+ 
			"include::"+home()+"cukedoctor-intro.adoc[leveloffset=+1]"+newLine() + newLine() + newLine() +
			"[[One-passing-scenario-one-failing-scenario, One passing scenario, one failing scenario]]"+newLine()+ 
			"== *One passing scenario, one failing scenario*"+newLine()+ 
			""+newLine()+ 
			"ifndef::backend-pdf[]"+newLine()+ 
			"minmax::One-passing-scenario-one-failing-scenario[]"+newLine()+ 
			"endif::[]"+newLine()+ 
			"=== Scenario: Passing"+newLine()+ 
			"[small]#tags: @a,@b#"+newLine()+ 
			""+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"this step passes icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"=== Scenario: Failing icon:thumbs-down[role=\"red\",title=\"Failed\"]"+newLine()+ 
			"[small]#tags: @a,@c#"+newLine()+ 
			""+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"this step fails icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(008ms)#"+newLine()+ 
			""+newLine()+ 
			"IMPORTANT:  (RuntimeError)"+newLine()+ 
			"./features/step_definitions/steps.rb:4:in /^this step fails$/'"+newLine()+ 
			"features/one_passing_one_failing.feature:10:in Given this step fails'"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"";

	String DOCUMENTATION_WITHOUT_SCENARIO_KEYWORD = ":toc: left"+newLine()+ 
			":backend: html5"+newLine()+ 
			":doctitle: Living Documentation"+newLine()+ 
			":doctype: book"+newLine()+ 
			":icons: font"+newLine()+ 
			":!numbered:"+newLine()+ 
			":!linkcss:"+newLine()+ 
			":sectanchors:"+newLine()+ 
			":sectlink:"+newLine()+ 
			":docinfo:"+newLine()+ 
			":source-highlighter: highlightjs"+newLine()+ 
			":toclevels: 3"+newLine()+ 
			":hardbreaks:"+newLine()+ 
			":chapter-label: Chapter"+newLine()+ 
			":version-label: Version"+newLine()+ 
			""+newLine()+ 
			"= *Living Documentation*"+newLine()+ 
			""+newLine()+ 
			"include::"+home()+"cukedoctor-intro.adoc[leveloffset=+1]"+newLine() +
			""+newLine()+ 
			""+newLine()+ 
			"[[One-passing-scenario-one-failing-scenario, One passing scenario, one failing scenario]]"+newLine()+ 
			"== *One passing scenario, one failing scenario*"+newLine()+ 
			""+newLine()+ 
			"ifndef::backend-pdf[]"+newLine()+ 
			"minmax::One-passing-scenario-one-failing-scenario[]"+newLine()+ 
			"endif::[]"+newLine()+ 
			"=== Passing"+newLine()+ 
			"[small]#tags: @a,@b#"+newLine()+ 
			""+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"this step passes icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"=== Failing icon:thumbs-down[role=\"red\",title=\"Failed\"]"+newLine()+ 
			"[small]#tags: @a,@c#"+newLine()+ 
			""+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"this step fails icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(008ms)#"+newLine()+ 
			""+newLine()+ 
			"IMPORTANT:  (RuntimeError)"+newLine()+ 
			"./features/step_definitions/steps.rb:4:in /^this step fails$/'"+newLine()+ 
			"features/one_passing_one_failing.feature:10:in Given this step fails'"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"";

	String DOCUMENTATION_WITHOUT_STEP_TIME = ":toc: left"+newLine()+ 
			":backend: html5"+newLine()+ 
			":doctitle: Living Documentation"+newLine()+ 
			":doctype: book"+newLine()+ 
			":icons: font"+newLine()+ 
			":!numbered:"+newLine()+ 
			":!linkcss:"+newLine()+ 
			":sectanchors:"+newLine()+ 
			":sectlink:"+newLine()+ 
			":docinfo:"+newLine()+ 
			":source-highlighter: highlightjs"+newLine()+ 
			":toclevels: 3"+newLine()+ 
			":hardbreaks:"+newLine()+ 
			":chapter-label: Chapter"+newLine()+ 
			":version-label: Version"+newLine()+ 
			""+newLine()+ 
			"= *Living Documentation*"+newLine()+ 
			""+newLine()+ 
			"include::"+home()+"cukedoctor-intro.adoc[leveloffset=+1]"+newLine() +			
			""+newLine()+ 
			""+newLine()+ 
			"[[One-passing-scenario-one-failing-scenario, One passing scenario, one failing scenario]]"+newLine()+ 
			"== *One passing scenario, one failing scenario*"+newLine()+ 
			""+newLine()+ 
			"ifndef::backend-pdf[]"+newLine()+ 
			"minmax::One-passing-scenario-one-failing-scenario[]"+newLine()+ 
			"endif::[]"+newLine()+ 
			"=== Scenario: Passing"+newLine()+ 
			"[small]#tags: @a,@b#"+newLine()+ 
			""+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"this step passes icon:thumbs-up[role=\"green\",title=\"Passed\"]"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"=== Scenario: Failing icon:thumbs-down[role=\"red\",title=\"Failed\"]"+newLine()+ 
			"[small]#tags: @a,@c#"+newLine()+ 
			""+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"this step fails icon:thumbs-down[role=\"red\",title=\"Failed\"]"+newLine()+ 
			""+newLine()+ 
			"IMPORTANT:  (RuntimeError)"+newLine()+ 
			"./features/step_definitions/steps.rb:4:in /^this step fails$/'"+newLine()+ 
			"features/one_passing_one_failing.feature:10:in Given this step fails'"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"";

	String DOCUMENTATION_WITHOUT_TAGS = ":toc: left"+newLine()+ 
			":backend: html5"+newLine()+ 
			":doctitle: Living Documentation"+newLine()+ 
			":doctype: book"+newLine()+ 
			":icons: font"+newLine()+ 
			":!numbered:"+newLine()+ 
			":!linkcss:"+newLine()+ 
			":sectanchors:"+newLine()+ 
			":sectlink:"+newLine()+ 
			":docinfo:"+newLine()+ 
			":source-highlighter: highlightjs"+newLine()+ 
			":toclevels: 3"+newLine()+ 
			":hardbreaks:"+newLine()+ 
			":chapter-label: Chapter"+newLine()+ 
			":version-label: Version"+newLine()+ 
			""+newLine()+ 
			"= *Living Documentation*"+newLine()+ 
			""+newLine()+ 
			"include::"+home()+"cukedoctor-intro.adoc[leveloffset=+1]"+newLine() +
			""+newLine()+ 
			""+newLine()+ 
			"[[One-passing-scenario-one-failing-scenario, One passing scenario, one failing scenario]]"+newLine()+ 
			"== *One passing scenario, one failing scenario*"+newLine()+ 
			""+newLine()+ 
			"ifndef::backend-pdf[]"+newLine()+ 
			"minmax::One-passing-scenario-one-failing-scenario[]"+newLine()+ 
			"endif::[]"+newLine()+ 
			"=== Scenario: Passing"+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"this step passes icon:thumbs-up[role=\"green\",title=\"Passed\"]"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"=== Scenario: Failing icon:thumbs-down[role=\"red\",title=\"Failed\"]"+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"this step fails icon:thumbs-down[role=\"red\",title=\"Failed\"]"+newLine()+ 
			""+newLine()+ 
			"IMPORTANT:  (RuntimeError)"+newLine()+ 
			"./features/step_definitions/steps.rb:4:in /^this step fails$/'"+newLine()+ 
			"features/one_passing_one_failing.feature:10:in Given this step fails'"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"";


	String DOCUMENTATION_FOR_MULTIPLE_FEATURES = ":toc: left"+newLine()+ 
			":backend: html5"+newLine()+ 
			":doctitle: Living Documentation"+newLine()+ 
			":doctype: book"+newLine()+ 
			":icons: font"+newLine()+ 
			":!numbered:"+newLine()+ 
			":!linkcss:"+newLine()+ 
			":sectanchors:"+newLine()+ 
			":sectlink:"+newLine()+ 
			":docinfo:"+newLine()+ 
			":source-highlighter: highlightjs"+newLine()+ 
			":toclevels: 3"+newLine()+ 
			":hardbreaks:"+newLine()+ 
			":chapter-label: Chapter"+newLine()+ 
			":version-label: Version"+newLine()+ 
			""+newLine()+ 
			"= *Living Documentation*"+newLine()+ 
			""+newLine()+ 
			"include::"+home()+"cukedoctor-intro.adoc[leveloffset=+1]"+newLine() + newLine() +
			"== *Summary*"+newLine()+ 
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine()+ 
			"|==="+newLine()+ 
			"3+|Scenarios 7+|Steps 2+|Features: 3"+newLine()+ 
			""+newLine()+ 
			"|[green]#*Passed*#"+newLine()+ 
			"|[red]#*Failed*#"+newLine()+ 
			"|Total"+newLine()+ 
			"|[green]#*Passed*#"+newLine()+ 
			"|[red]#*Failed*#"+newLine()+ 
			"|[purple]#*Skipped*#"+newLine()+ 
			"|[maroon]#*Pending*#"+newLine()+ 
			"|[yellow]#*Undefined*#"+newLine()+ 
			"|[blue]#*Missing*#"+newLine()+ 
			"|Total"+newLine()+ 
			"|Duration"+newLine()+ 
			"|Status"+newLine()+ 
			""+newLine()+ 
			"12+^|*<<An-embed-data-directly-feature>>*"+newLine()+ 
			"|3"+newLine()+ 
			"|0"+newLine()+ 
			"|3"+newLine()+ 
			"|3"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|3"+newLine()+ 
			"|000ms"+newLine()+ 
			"|[green]#*passed*#"+newLine()+ 
			""+newLine()+ 
			"12+^|*<<An-outline-feature>>*"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|000ms"+newLine()+ 
			"|[green]#*passed*#"+newLine()+ 
			""+newLine()+ 
			"12+^|*<<One-passing-scenario-one-failing-scenario>>*"+newLine()+ 
			"|1"+newLine()+ 
			"|1"+newLine()+ 
			"|2"+newLine()+ 
			"|1"+newLine()+ 
			"|1"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|2"+newLine()+ 
			"|010ms"+newLine()+ 
			"|[red]#*failed*#"+newLine()+ 
			"12+^|*Totals*"+newLine()+ 
			"|4|1|5|4|1|0|0|0|0|5 2+|010ms"+newLine()+ 
			"|==="+newLine()+ 
			""+newLine()+ 
			"== *Features*"+newLine()+ 
			""+newLine()+ 
			"[[An-embed-data-directly-feature, An embed data directly feature]]"+newLine()+ 
			"=== *An embed data directly feature*"+newLine()+ 
			""+newLine()+ 
			"ifndef::backend-pdf[]"+newLine()+ 
			"minmax::An-embed-data-directly-feature[]"+newLine()+ 
			"endif::[]"+newLine()+ 
			"==== Scenario: scenario 1"+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"I embed data directly icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"==== Scenario Outline: scenario 2"+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"I embed data directly icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"I embed data directly icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"[[An-outline-feature, An outline feature]]"+newLine()+ 
			"=== *An outline feature*"+newLine()+ 
			""+newLine()+ 
			"ifndef::backend-pdf[]"+newLine()+ 
			"minmax::An-outline-feature[]"+newLine()+ 
			"endif::[]"+newLine()+ 
			"==== Scenario Outline: outline icon:thumbs-down[role=\"red\",title=\"Failed\"]"+newLine()+ 
			""+newLine()+ 
			""+newLine()+ 
			".examples1"+newLine()+ 
			"[cols=\"1*\", options=\"header\"]"+newLine()+ 
			"|==="+newLine()+ 
			"|status"+newLine()+ 
			"|passes"+newLine()+ 
			"|fails"+newLine()+ 
			"|==="+newLine()+ 
			""+newLine()+ 
			".examples2"+newLine()+ 
			"[cols=\"1*\", options=\"header\"]"+newLine()+ 
			"|==="+newLine()+ 
			"|status"+newLine()+ 
			"|passes"+newLine()+ 
			"|==="+newLine()+ 
			""+newLine()+ 
			"[[One-passing-scenario-one-failing-scenario, One passing scenario, one failing scenario]]"+newLine()+ 
			"=== *One passing scenario, one failing scenario*"+newLine()+ 
			""+newLine()+ 
			"ifndef::backend-pdf[]"+newLine()+ 
			"minmax::One-passing-scenario-one-failing-scenario[]"+newLine()+ 
			"endif::[]"+newLine()+ 
			"==== Scenario: Passing"+newLine()+ 
			"[small]#tags: @a,@b#"+newLine()+ 
			""+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"this step passes icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"==== Scenario: Failing icon:thumbs-down[role=\"red\",title=\"Failed\"]"+newLine()+ 
			"[small]#tags: @a,@c#"+newLine()+ 
			""+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"this step fails icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(008ms)#"+newLine()+ 
			""+newLine()+ 
			"IMPORTANT:  (RuntimeError)"+newLine()+ 
			"./features/step_definitions/steps.rb:4:in /^this step fails$/'"+newLine()+ 
			"features/one_passing_one_failing.feature:10:in Given this step fails'"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"";

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
			":source-highlighter: highlightjs:toclevels: 3\n:hardbreaks:"+newLine() +
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
			"=== *Search*"+newLine() +
			""+newLine() +
			"minmax::Search[]"+newLine() +
			"==== Cenario: Find messages by content"+newLine() +
			"[small]#tags: @txn#"+newLine() +
			""+newLine() + newLine() +
			"****"+newLine()  +
			"Dado ::"+newLine() +
			Constants.Markup.exampleBlock() + newLine() +
			"a User has posted the following messages: icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(111ms)#"+newLine() +
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
			Constants.Markup.exampleBlock() + newLine() +
			"****"+newLine() +
			""+newLine();

	String FEATURE_WITH_STEP_TABLE_IN_PT_BR = ":toc: right"+newLine() +
			":backend: html5"+newLine() +
			":doctitle: Doc Title"+newLine() +
			":doctype: book"+newLine() +
			":icons: font"+newLine() +
			":!numbered:"+newLine() +
			":!linkcss:"+newLine() +
			":sectanchors:"+newLine() +
			":sectlink:"+newLine() +
			":docinfo:"+newLine() +
			":source-highlighter: highlightjs" + newLine()+
			":toclevels: 3\n:hardbreaks:"+newLine() +
			":chapter-label: Chapter"+newLine() +
			":version-label: Version"+newLine() +
			""+newLine() +
			"= *Doc Title*"+newLine() +
			""+newLine() +
			"include::"+home()+"cukedoctor-intro.adoc[leveloffset=+1]"+newLine() +
			"== *Resumo*"+newLine() +
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine() +
			"|==="+newLine() +
			"3+|Cenários 7+|Passos 2+|Funcionalidades: 1"+newLine() +
			""+newLine() +
			"|[green]#*Sucesso*#"+newLine() +
			"|[red]#*Falha*#"+newLine() +
			"|Total"+newLine() +
			"|[green]#*Sucesso*#"+newLine() +
			"|[red]#*Falha*#"+newLine() +
			"|[purple]#*Ignorado*#"+newLine() +
			"|[maroon]#*Pendente*#"+newLine() +
			"|[yellow]#*Indefinido*#"+newLine() +
			"|[blue]#*Ausente*#"+newLine() +
			"|Total"+newLine() +
			"|Tempo"+newLine() +
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
			"12+^|*Totais*"+newLine() +
			"|1|0|1|1|0|0|0|0|0|1 2+|111ms"+newLine() +
			"|==="+newLine() +
			""+newLine() +
			"== *Funcionalidades*"+newLine() +
			""+newLine() +
			"[[Search, Search]]"+newLine() +
			"=== *Search*"+newLine() +
			""+newLine() +
			"ifndef::backend-pdf[]"+newLine() +
			"minmax::Search[]"+newLine() +
			"endif::[]"+newLine() +
			"==== Cenario: Find messages by content"+newLine() +
			"[small]#tags: @txn#"+newLine() +
			""+newLine() +
			""+newLine() +
			"****"+newLine() +
			"Dado ::"+newLine() +
			Constants.Markup.exampleBlock() + newLine() +
			"a User has posted the following messages: icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(111ms)#"+newLine() +
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
			Constants.Markup.exampleBlock() + newLine() +
			"****"+newLine() +
			""+newLine();
	String DOCUMENTATION_WITH_SCENARIO_WITHOUT_DESCRIPTION =  ""+newLine()+ 
			"= *Documentation*"+newLine()+ 
			""+newLine()+ 
			"include::"+home()+"cukedoctor-intro.adoc[leveloffset=+1]"+newLine() + 			
			""+newLine()+ 
			"== *Summary*"+newLine()+ 
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine()+ 
			"|==="+newLine()+ 
			"3+|Scenarios 7+|Steps 2+|Features: 1"+newLine()+ 
			""+newLine()+ 
			"|[green]#*Passed*#"+newLine()+ 
			"|[red]#*Failed*#"+newLine()+ 
			"|Total"+newLine()+ 
			"|[green]#*Passed*#"+newLine()+ 
			"|[red]#*Failed*#"+newLine()+ 
			"|[purple]#*Skipped*#"+newLine()+ 
			"|[maroon]#*Pending*#"+newLine()+ 
			"|[yellow]#*Undefined*#"+newLine()+ 
			"|[blue]#*Missing*#"+newLine()+ 
			"|Total"+newLine()+ 
			"|Duration"+newLine()+ 
			"|Status"+newLine()+ 
			""+newLine()+ 
			"12+^|*<<Do-something>>*"+newLine()+ 
			"|1"+newLine()+ 
			"|0"+newLine()+ 
			"|1"+newLine()+ 
			"|1"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|0"+newLine()+ 
			"|1"+newLine()+ 
			"|000ms"+newLine()+ 
			"|[green]#*passed*#"+newLine()+ 
			"12+^|*Totals*"+newLine()+ 
			"|1|0|1|1|0|0|0|0|0|1 2+|000ms"+newLine()+ 
			"|==="+newLine()+ 
			""+newLine()+ 
			"== *Features*"+newLine()+ 
			""+newLine()+ 
			"[[Do-something, Do something]]"+newLine()+ 
			"=== *Do something*"+newLine()+ 
			""+newLine()+ 
			"****"+newLine()+ 
			"As a foo..."+newLine()+ 
			"****"+newLine()+ 
			""+newLine()+ 
			"==== Scenario: User browses to the site successfully"+newLine()+ 
			""+newLine()+ 
			"===="+newLine()+ 
			"Given ::"+newLine()+ 
			"User opens a browser icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"+newLine()+ 
			"===="+newLine()+ 
			""+newLine()+ 
			"";
}
