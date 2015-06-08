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
			"|Passed" + newLine() +
			"|Failed" + newLine() +
			"|Total" + newLine() +
			"|Passed" + newLine() +
			"|Failed" + newLine() +
			"|Skipped" + newLine() +
			"|Pending" + newLine() +
			"|Undefined" + newLine() +
			"|Missing" + newLine() +
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
			"|failed" + newLine() +
			"12+^|*Totals*" + newLine() +
			"|1|1|2|1|1|0|0|0|0|2|010ms|{empty}" + newLine() +
			"|===" + newLine();


	String SUMMARY_FOR_MULTIPLE_FEATURES = "= Title"+newLine() +
			""+newLine() +
			"== Summary"+newLine() +
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine() +
			"|==="+newLine() +
			"3+|Scenarios 7+|Steps 2+|Features: 3"+newLine() +
			""+newLine() +
			"|Passed"+newLine() +
			"|Failed"+newLine() +
			"|Total"+newLine() +
			"|Passed"+newLine() +
			"|Failed"+newLine() +
			"|Skipped"+newLine() +
			"|Pending"+newLine() +
			"|Undefined"+newLine() +
			"|Missing"+newLine() +
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
			"|failed"+newLine() +
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
			"|passed"+newLine() +
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
			"|failed"+newLine() +
			"12+^|*Totals*" + newLine() +
			"|4|2|6|4|1|0|0|0|1|6|010ms|{empty}" + newLine() +
			"|==="+newLine();
	
	String DOCUMENTATION_FOR_ONE_FEATURE = ":toc: left"+newLine() +
			":backend: html5"+newLine() +
			":doctitle: Living Documentation"+newLine() +
			":doctype: book"+newLine() +
			":icons: font"+newLine() +
			":!numbered:"+newLine() +
			":sectanchors:"+newLine() +
			":sectlink:"+newLine() +
			""+newLine() +
			"= Living Documentation"+newLine() +
			""+newLine() +
			"== Summary"+newLine() +
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine() +
			"|==="+newLine() +
			"3+|Scenarios 7+|Steps 2+|Features: 1"+newLine() +
			""+newLine() +
			"|Passed"+newLine() +
			"|Failed"+newLine() +
			"|Total"+newLine() +
			"|Passed"+newLine() +
			"|Failed"+newLine() +
			"|Skipped"+newLine() +
			"|Pending"+newLine() +
			"|Undefined"+newLine() +
			"|Missing"+newLine() +
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
			"|failed"+newLine() +
			"12+^|*Totals*" + newLine() +
			"|1|1|2|1|1|0|0|0|0|2|010ms|{empty}" + newLine() +
			"|==="+newLine() + newLine() +
			"== One passing scenario, one failing scenario"+newLine() + newLine() +
			"=== Scenario: Passing"+newLine() +
			"[small]#tags: @b#"+newLine() + newLine() + newLine() +
			"=== Scenario: Failing" + newLine() +
			"[small]#tags: @c#"+newLine() +newLine()+newLine();
	
	String DOCUMENTATION_FOR_MULTIPLE_FEATURES = ":toc: left"+newLine() +
			":backend: html5"+newLine() +
			":doctitle: Living Documentation"+newLine() +
			":doctype: book"+newLine() +
			":icons: font"+newLine() +
			":!numbered:"+newLine() +
			":sectanchors:"+newLine() +
			":sectlink:"+newLine() +
			""+newLine() +
			"= Living Documentation"+newLine() +
			""+newLine() +
			"== Summary"+newLine() +
			"[cols=\"12*^m\", options=\"header,footer\"]"+newLine() +
			"|==="+newLine() +
			"3+|Scenarios 7+|Steps 2+|Features: 3"+newLine() +
			""+newLine() +
			"|Passed"+newLine() +
			"|Failed"+newLine() +
			"|Total"+newLine() +
			"|Passed"+newLine() +
			"|Failed"+newLine() +
			"|Skipped"+newLine() +
			"|Pending"+newLine() +
			"|Undefined"+newLine() +
			"|Missing"+newLine() +
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
			"|failed"+newLine() +
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
			"|passed"+newLine() +
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
			"|failed"+newLine() +
			"12+^|*Totals*" + newLine() +
			"|4|2|6|4|1|0|0|0|1|6|010ms|{empty}" + newLine() +
			"|==="+newLine() + newLine() +
			"== One passing scenario, one failing scenario"+newLine() + newLine() +
			"=== Scenario: Passing"+newLine() +
			"[small]#tags: @b#"+newLine() + newLine() + newLine() +
			"=== Scenario: Failing" + newLine() +
			"[small]#tags: @c#"+newLine() +newLine() + newLine() +
			"== An embed data directly feature"+newLine() +
			""+newLine() +
			"=== Scenario: scenario 1"+newLine() +
			""+newLine() +
			"=== Scenario Outline: scenario 2"+newLine() +
			""+newLine() +
			""+newLine() +
			"== An outline feature"+newLine() +
			""+newLine() +
			"=== Scenario Outline: outline\n"+newLine();
}
