Feature: Cukedoctor Main
  As a user of CukedoctorMain
  I want to generate asciidoc files based on my cucumber test output
  So that I can generate wonderful living documentation

  Scenario: Generate documentation of a single file
    Given Cucumber json output file located at "/target/test-classes/json-output/sample.json"
    When I execute CukedoctorMain with args "-n outputFile.adoc" "-p /target/test-classes/json-output/sample.json" and "-t Documentation"
    Then A file named outputFile.adoc should be generated with the following content:
    """
:toc: right
:backend: html5
:doctitle: Documentation
:doctype: article
:icons: font
:!numbered:
:sectanchors:
:sectlink:

= Documentation

== Summary
[cols="12*^m", options="header,footer"]
|===
3+|Scenarios 7+|Steps 2+|Features: 1

|Passed
|Failed
|Total
|Passed
|Failed
|Skipped
|Pending
|Undefined
|Missing
|Total
|Duration
|Status

12+^|*<<Sample test>>*
|1
|2
|3
|3
|1
|0
|0
|0
|2
|6
|10s 104ms
|failed
12+^|*Totals*
|1|2|3|3|1|0|0|0|2|6 2+|10s 104ms
|===

== Sample test

****
As a user +
I want to do something +
In order to achieve another thing
****

=== Scenario Outline: Parsing scenarios with multiple examples

=== Scenario: Basic

=== Scenario: Basic failure


    """

