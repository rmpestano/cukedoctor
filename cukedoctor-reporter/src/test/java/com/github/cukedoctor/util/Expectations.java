package com.github.cukedoctor.util;

import static com.github.cukedoctor.util.Constants.newLine;

/**
 * Created by pestano on 07/06/15.
 */
public interface Expectations {

	String SUMMARY_FOR_ONE_FEATURE = "= Title" + newLine() + newLine() +
			"== Summary" + newLine() +
			"[cols=\"12*^m\", options=\"header,footer\"]" + newLine() +
			"|===" + newLine() +
			"3+|Scenarios 7+|Steps 2+|Features: 1" + newLine() +
			"" + newLine() +
			"|[green]#*Passed*#" + newLine() +
			"|[red]#*Failed*#" + newLine() +
			"|Total" + newLine() +
			"|[green]#*Passed*#" + newLine() +
			"|[red]#*Failed*#" + newLine() +
			"|[purple]#Skipped#" + newLine() +
			"|[orange]#*Pending*#" + newLine() +
			"|[yellow]#*Undefined*#" + newLine() +
			"|[blue]#Missing#" + newLine() +
			"|Total" + newLine() +
			"|Duration" + newLine() +
			"|Status" + newLine() +
			"" + newLine() +
			"12+^|*<<One passing scenario, one failing scenario>>*" + newLine() +
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

	String SUMMARY_FOR_MULTIPLE_FEATURES = "= Title"+newLine() +
			""+newLine() +
			"== Summary"+newLine() +
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine() +
			"|==="+newLine() +
			"3+|Scenarios 7+|Steps 2+|Features: 3"+newLine() +
			""+newLine() +
			"|[green]#*Passed*#"+newLine() +
			"|[red]#*Failed*#"+newLine() +
			"|Total"+newLine() +
			"|[green]#*Passed*#"+newLine() +
			"|[red]#*Failed*#"+newLine() +
			"|[purple]#Skipped#"+newLine() +
			"|[orange]#*Pending*#"+newLine() +
			"|[yellow]#*Undefined*#"+newLine() +
			"|[blue]#Missing#"+newLine() +
			"|Total"+newLine() +
			"|Duration"+newLine() +
			"|Status"+newLine() +
			""+newLine() +
			"12+^|*<<An embed data directly feature>>*"+newLine() +
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
			"12+^|*<<An outline feature>>*"+newLine() +
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
			"12+^|*<<One passing scenario, one failing scenario>>*"+newLine() +
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
			""+newLine() +
			"= Living Documentation"+newLine() +
			""+newLine() +
			"== Summary"+newLine() +
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine() +
			"|==="+newLine() +
			"3+|Scenarios 7+|Steps 2+|Features: 1"+newLine() +
			""+newLine() +
			"|[green]#*Passed*#"+newLine() +
			"|[red]#*Failed*#"+newLine() +
			"|Total"+newLine() +
			"|[green]#*Passed*#"+newLine() +
			"|[red]#*Failed*#"+newLine() +
			"|[purple]#Skipped#"+newLine() +
			"|[orange]#*Pending*#"+newLine() +
			"|[yellow]#*Undefined*#"+newLine() +
			"|[blue]#Missing#"+newLine() +
			"|Total"+newLine() +
			"|Duration"+newLine() +
			"|Status"+newLine() +
			""+newLine() +
			"12+^|*<<One passing scenario, one failing scenario>>*"+newLine() +
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
			"= Features"+newLine() +
			""+newLine() +
			"== One passing scenario, one failing scenario"+newLine() +
			""+newLine() +
			"=== Scenario: Passing"+newLine() +
			"[small]#tags: @a,@b#"+newLine() +
			""+newLine() +
			"****"+newLine() +
			"Given ::"+newLine() +
			"this step passes icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#"+newLine() +
			"****"+newLine() +
			""+newLine() +
			"=== Scenario: Failing"+newLine() +
			"[small]#tags: @a,@c#"+newLine() +
			""+newLine() +
			"****"+newLine() +
			"Given ::"+newLine() +
			"this step fails icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(008ms)#"+newLine() +
			"****\n"+newLine();

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
			""+newLine() +
			"= Living Documentation"+newLine() +
			""+newLine() +
			"== Summary"+newLine() +
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine() +
			"|==="+newLine() +
			"3+|Scenarios 7+|Steps 2+|Features: 3"+newLine() +
			""+newLine() +
			"|[green]#*Passed*#"+newLine() +
			"|[red]#*Failed*#"+newLine() +
			"|Total"+newLine() +
			"|[green]#*Passed*#"+newLine() +
			"|[red]#*Failed*#"+newLine() +
			"|[purple]#Skipped#"+newLine() +
			"|[orange]#*Pending*#"+newLine() +
			"|[yellow]#*Undefined*#"+newLine() +
			"|[blue]#Missing#"+newLine() +
			"|Total"+newLine() +
			"|Duration"+newLine() +
			"|Status"+newLine() +
			""+newLine() +
			"12+^|*<<An embed data directly feature>>*"+newLine() +
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
			"12+^|*<<An outline feature>>*"+newLine() +
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
			"12+^|*<<One passing scenario, one failing scenario>>*"+newLine() +
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
			"= Features"+newLine() +
			""+newLine() +
			"== An embed data directly feature"+newLine() +
			""+newLine() +
			"=== Scenario: scenario 1"+newLine() +
			"****"+newLine() +
			"Given ::"+newLine() +
			"I embed data directly icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(000ms)#"+newLine() +
			"****"+newLine() +
			""+newLine() +
			"=== Scenario Outline: scenario 2"+newLine() +
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
			"== An outline feature"+newLine() +
			""+newLine() +
			"=== Scenario Outline: outline"+newLine() +
			"****"+newLine() +
			"Given ::"+newLine() +
			"this step <status> icon:thumbs-down[role=\"blue\",title=\"Missing\"]"+newLine() +
			"****"+newLine() +
			""+newLine() +
			"== One passing scenario, one failing scenario"+newLine() +
			""+newLine() +
			"=== Scenario: Passing"+newLine() +
			"[small]#tags: @a,@b#"+newLine() +
			""+newLine() +
			"****"+newLine() +
			"Given ::"+newLine() +
			"this step passes icon:thumbs-up[role=\"green\",title=\"Passed\"] [small right]#(001ms)#"+newLine() +
			"****"+newLine() +
			""+newLine() +
			"=== Scenario: Failing"+newLine() +
			"[small]#tags: @a,@c#"+newLine() +
			""+newLine() +
			"****"+newLine() +
			"Given ::"+newLine() +
			"this step fails icon:thumbs-down[role=\"red\",title=\"Failed\"] [small right]#(008ms)#"+newLine() +
			"****"+newLine()+newLine();
}
