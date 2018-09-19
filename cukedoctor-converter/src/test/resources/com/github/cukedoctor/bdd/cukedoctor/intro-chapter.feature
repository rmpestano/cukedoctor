# order: 3
Feature: Documentation introduction chapter
  ====
  [quote]
  ____
  In order to have an introduction chapter in my documentation
  As a bdd developer
  I want to be able to provide an asciidoc based document which introduces my software.
  ____
  ====
  Scenario: Introduction chapter in classpath
  
	Given The following two features:
"""
Feature: Feature1

  Scenario: Scenario feature 1

    Given scenario step

Feature: Feature2

  Scenario: Scenario feature 2

    Given scenario step
"""

#{NOTE: The introduction file must be named *intro-chapter.adoc* and can be in any package of your application,}

#{[TIP]}
#{====}
#{By default Cukedoctor will look into application folders but you can make Cukedoctor look into external folder by setting the following system property:}
#{[source,java]}
#{----}
#{System.setProperty("INTRO_CHAPTER_DIR","/home/some/external/folder");}
#{----}
#{====}

    #cukedoctor-discrete
    And The following asciidoc document is on your application classpath
"""
= *Introduction*

Cukedoctor is a *Living documentation* tool which integrates Cucumber and Asciidoctor in order to convert your _BDD_ tests results into an awesome documentation.

Here are some design principles:

* Living documentation should be readable and highlight your software features;
** Most bdd tools generate reports and not a truly documentation.
* Cukedoctor *do not* introduce a new API that you need to learn, instead it operates on top of http://www.relishapp.com/cucumber/cucumber/docs/formatters/json-output-formatter[cucumber json output^] files;
** In the 'worst case' to <<Enrich-features,enhance>> your documentation you will need to know a bit of http://asciidoctor.org/docs/what-is-asciidoc/[asciidoc markup^].
"""
     
    When Bdd tests results are converted into documentation by Cukedoctor
 

    # cukedoctor-discrete
    Then Resulting documentation should have the provided introduction chapter
"""

= *Documentation*

== *Introduction*

Cukedoctor is a *Living documentation* tool which integrates Cucumber and Asciidoctor in order to convert your _BDD_ tests results into an awesome documentation.

Here are some design principles:

* Living documentation should be readable and highlight your software features;
** Most bdd tools generate reports and not a truly documentation.
* Cukedoctor *do not* introduce a new API that you need to learn, instead it operates on top of http://www.relishapp.com/cucumber/cucumber/docs/formatters/json-output-formatter[cucumber json output^] files;
** In the 'worst case' to <<Enrich-features,enhance>> your documentation you will need to know a bit of http://asciidoctor.org/docs/what-is-asciidoc/[asciidoc markup^].

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
