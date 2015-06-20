Feature: Cukedoctor Main
  As a user of CukedoctorMain
  I want to generate asciidoc files based on my cucumber test output
  So that I can generate wonderful living documentation

  Scenario: Generate documentation of a single file
    Given A Cucumber json execution file is are already generated
    When I execute CukedoctorMain with args "-o /target/test-classes/outputFile.adoc" "-p /target/test-classes/json-output/one_passing_one_failing.json" and "-t Documentation"
    Then A file named outputFile.adoc should be generated with the following content:
    """
    :toc: right
:backend: html5
:doctitle: Documentation
:doctype: article
:icons: font
:!numbered:
:!linkcss:
:sectanchors:
:sectlink:
:docinfo:

= Documentation

== Summary
[cols="12*^m", options="header,footer"]
|===
3+|Scenarios 7+|Steps 2+|Features: 1

|[green]#*Passed*#
|[red]#*Failed*#
|Total
|[green]#*Passed*#
|[red]#*Failed*#
|[purple]#Skipped#
|[orange]#*Pending*#
|[yellow]#*Undefined*#
|[blue]#Missing#
|Total
|Duration
|Status

12+^|*<<One passing scenario, one failing scenario>>*
|1
|1
|2
|1
|1
|0
|0
|0
|0
|2
|010ms
|[red]#*failed*#
12+^|*Totals*
|1|1|2|1|1|0|0|0|0|2 2+|010ms
|===

= Features

== One passing scenario, one failing scenario

=== Scenario: Passing
[small]#tags: @a,@b#


=== Scenario: Failing
[small]#tags: @a,@c#



    """




  Scenario: Generate documentation using multiple files
    Given Cucumber multiple json execution files are already generate
    When I execute CukedoctorMain with args "-o /target/test-classes/outputFile.adoc" "-p /target/test-classes/json-output/" and "-t Documentation"
    Then A file named outputFile.adoc should be generated with the following content:
      """
      :toc: right
:backend: html5
:doctitle: Documentation
:doctype: article
:icons: font
:!numbered:
:!linkcss:
:sectanchors:
:sectlink:
:docinfo:

= Documentation

== Summary
[cols="12*^m", options="header,footer"]
|===
3+|Scenarios 7+|Steps 2+|Features: 4

|[green]#*Passed*#
|[red]#*Failed*#
|Total
|[green]#*Passed*#
|[red]#*Failed*#
|[purple]#Skipped#
|[orange]#*Pending*#
|[yellow]#*Undefined*#
|[blue]#Missing#
|Total
|Duration
|Status

12+^|*<<An embed data directly feature>>*
|3
|0
|3
|3
|0
|0
|0
|0
|0
|3
|000ms
|[green]#*passed*#

12+^|*<<An outline feature>>*
|0
|1
|1
|0
|0
|0
|0
|0
|1
|1
|000ms
|[red]#*failed*#

12+^|*<<One passing scenario, one failing scenario>>*
|1
|1
|2
|1
|1
|0
|0
|0
|0
|2
|010ms
|[red]#*failed*#

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
|[red]#*failed*#
12+^|*Totals*
|5|4|9|7|2|0|0|0|3|12 2+|10s 114ms
|===

= Features

== An embed data directly feature

=== Scenario: scenario 1

=== Scenario Outline: scenario 2


== An outline feature

=== Scenario Outline: outline

== One passing scenario, one failing scenario

=== Scenario: Passing
[small]#tags: @a,@b#


=== Scenario: Failing
[small]#tags: @a,@c#


== Sample test

****
As a user  +
I want to do something  +
In order to achieve another thing
****

=== Scenario Outline: Parsing scenarios with multiple examples

=== Scenario: Basic

=== Scenario: Basic failure


      """