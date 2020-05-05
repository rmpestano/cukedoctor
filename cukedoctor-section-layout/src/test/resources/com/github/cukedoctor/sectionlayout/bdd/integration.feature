@skipDocs
Feature: Integration Tests

  Scenario: Integration

    Given I have the Feature
"""
Feature: Habitat

  Scenario: Tar Pits

    Given I do not mind getting mucky
"""
    And I have the Feature
"""
@section-Anatomy
@appendix
@subsection-Cranium
Feature: Head Adornments

  Scenario: Parasaurolophus

    Given I have an implausible head adornment
"""
    And I have the Feature
"""
@section-Behaviour
Feature: Hunters

  Scenario: Tyranosaurus Rex

    Given I am the best hunter
"""
    And I am showing the Features Section
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I run Cukedoctor
    Then they will be rendered as
"""asciidoc
:toc: right
:backend: html5
:doctitle: Living Documentation
:doctype: book
:icons: font
:!numbered:
:!linkcss:
:sectanchors:
:sectlink:
:docinfo:
:source-highlighter: highlightjs
:toclevels: 3
:hardbreaks:
:chapter-label: Chapter
:version-label: Version

= *Living Documentation*

== *Summary*
[cols="12*^m", options="header,footer"]
|===
3+|Scenarios 7+|Steps 2+|Features: 3

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

12+^|*<<Hunters>>*
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

12+^|*<<Habitat>>*
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

12+^|*<<Head-Adornments>>*
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
|3|0|3|3|0|0|0|0|0|3 2+|000ms
|===

[[Behaviour, Behaviour]]
== *Behaviour*

[[Hunters, Hunters]]
=== *Hunters*

==== Scenario: Tyranosaurus Rex

==========
Given ::
I am the best hunter icon:thumbs-up[role="green",title="Passed"]
==========

[[Features, Features]]
== *Features*

[[Habitat, Habitat]]
=== *Habitat*

==== Scenario: Tar Pits

==========
Given ::
I do not mind getting mucky icon:thumbs-up[role="green",title="Passed"]
==========

[appendix]
[[Anatomy, Anatomy]]
== *Anatomy*

[[Cranium, Cranium]]
=== *Cranium*

[[Head-Adornments, Head Adornments]]
==== *Head Adornments*

===== Scenario: Parasaurolophus

==========
Given ::
I have an implausible head adornment icon:thumbs-up[role="green",title="Passed"]
==========


"""