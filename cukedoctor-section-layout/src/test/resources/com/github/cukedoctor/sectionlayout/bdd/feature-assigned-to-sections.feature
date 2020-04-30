Feature: Sections
Features can be assigned to user-defined Sections using the `@section-' tag.
Sections are the top level of the document hierarchy below the document title itself.
Cukedoctor already has many in-built sections, such as the Summary section.

  Scenario: Assigning a Feature to a Section
    Given I have the Feature
"""
@section-Dinosaurs
Feature: Head Adornments

  Scenario: Parasaurolophus

    Given I have an implausible head adornment
"""
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as
"""asciidoc
[[Dinosaurs, Dinosaurs]]
= *Dinosaurs*


[[Head-Adornments, Head Adornments]]
== *Head Adornments*

=== Scenario: Parasaurolophus

==========
Given ::
I have an implausible head adornment icon:thumbs-up[role="green",title="Passed"]
==========


"""

  Scenario: Ordering Sections
  Sections are ordered by the earliest feature within. The built-in Features Section is always rendered after other sections, irrespective of `@order-' tags applied to Features therein.

    Given I have the Feature
"""
@order-1
Feature: Habitat

  Scenario: Tar Pits

    Given I do not mind getting mucky
"""
    And I have the Feature
"""
@section-Anatomy
@order-100
Feature: Head Adornments

  Scenario: Parasaurolophus

    Given I have an implausible head adornment
"""
    And I have the Feature
"""
@section-Behaviour
@order-10
Feature: Hunters

  Scenario: Tyranosaurus Rex

    Given I am the best hunter
"""
    And I am showing the Features Section
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then they will be rendered as
"""asciidoc
[[Behaviour, Behaviour]]
= *Behaviour*


[[Hunters, Hunters]]
== *Hunters*

=== Scenario: Tyranosaurus Rex

==========
Given ::
I am the best hunter icon:thumbs-up[role="green",title="Passed"]
==========

[[Anatomy, Anatomy]]
= *Anatomy*


[[Head-Adornments, Head Adornments]]
== *Head Adornments*

=== Scenario: Parasaurolophus

==========
Given ::
I have an implausible head adornment icon:thumbs-up[role="green",title="Passed"]
==========

[[Features, Features]]
= *Features*


[[Habitat, Habitat]]
== *Habitat*

=== Scenario: Tar Pits

==========
Given ::
I do not mind getting mucky icon:thumbs-up[role="green",title="Passed"]
==========


"""