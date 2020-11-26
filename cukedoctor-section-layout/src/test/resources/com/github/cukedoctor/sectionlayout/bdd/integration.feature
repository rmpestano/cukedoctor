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


  Scenario: Config

    Given I have the Feature
"""
Feature: Habitat

  Scenario: Tar Pits
"""
    And I am showing the Features Section
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    And I have disabled the scenario keyword
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


[[Features, Features]]
== *Features*

[[Habitat, Habitat]]
=== *Habitat*

==== Tar Pits


"""