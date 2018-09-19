# order: 0
Feature: Cukedoctor Converter
  ====
  [quote]
  ____
  In order to have awesome _living documentation_
  As a bdd developer
  I want to use *Cukedoctor* to convert my cucumber test results into `readable` living documentation.
  ____
  ====
  Scenario: Convert features test output into documentation

    Given The following two features:
"""
Feature: Feature1

  Scenario: Scenario feature 1

    Given scenario step

Feature: Feature2

  Scenario: Scenario feature 2

    Given scenario step
"""
    # cukedoctor-discrete
    When I convert their json test output using cukedoctor converter
"""
[IMPORTANT]
======
To generate cucumber .json output files just execute your _BDD_ tests with *json* formatter, example:

[source,java]
----
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/cucumber.json"} )
----
NOTE: *plugin* option replaced *format* option which was deprecated in newer cucumber versions.

======
"""

    # cukedoctor-discrete
    Then I should have awesome living documentation
"""

= *Documentation*



== *Summary*
[cols="12*^m", options="header,footer"]
|===
3+|Scenarios 7+|Steps 2+|Features: 2

|[green]#*Passed*#
|[red]#*Failed*#
|Total
|[green]#*Passed*#
|[red]#*Failed*#
|[purple]#*Skipped*#
|[maroon]#*Pending*#
|[yellow]#*Undefined*#
|[blue]#*Missing*#
|Total
|Duration
|Status

12+^|*<<Feature1>>*
|1
|0
|1
|1
|0
|0
|0
|0
|0
|1
|647ms
|[green]#*passed*#

12+^|*<<Feature2>>*
|1
|0
|1
|1
|0
|0
|0
|0
|0
|1
|000ms
|[green]#*passed*#
12+^|*Totals*
|2|0|2|2|0|0|0|0|0|2 2+|647ms
|===

== *Features*

[[Feature1, Feature1]]
=== *Feature1*

==== Scenario: Scenario feature 1

====
Given ::
scenario step icon:thumbs-up[role="green",title="Passed"] [small right]#(647ms)#
====

[[Feature2, Feature2]]
=== *Feature2*

==== Scenario: Scenario feature 2

====
Given ::
scenario step icon:thumbs-up[role="green",title="Passed"] [small right]#(000ms)#
====


"""
