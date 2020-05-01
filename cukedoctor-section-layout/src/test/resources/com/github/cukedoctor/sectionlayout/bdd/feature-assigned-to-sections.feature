@section-Sections
@order-2
Feature: Grouping Features in Sections

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

  Scenario: Title and Preamble
  A Feature tagged with a Section, containing a Scenario named 'Root' will be used as the Root of a Section. The name of this Feature will be used to render the Section's name and the Feature's description will be rendered immediately underneath.
  You can use full AsciiDoc markup in a Feature's description to provide as much of a preamble to the Section as you wish, or none at all. You can also provide other Scenarios in the Feature, which will be rendered as normal.

  If multiple Roots are defined for a Section, the result is undefined.

    Given I have the Feature
"""
@section-Dinosaurs
@order-2
Feature: Head Adornments

  Scenario: Parasaurolophus

    Given I have an implausible head adornment
"""
    And I have the Feature
"""
@section-Dinosaurs
@order-1
Feature: Dinosaurs: Reality or Myth?
As children, we all come to know and love these alleged ancient titans, but _did they ever really exist_?

  Scenario: Root

  Scenario: Their demise
  If they did once exist, how did they cease to?

    Given a big enough meteor
"""
    And I have the Feature
"""
@section-Birds
@order-3
Feature: Birds: Descendents of Titans?

  Scenario: Root
"""
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as
"""asciidoc
[[Dinosaurs:-Reality-or-Myth?, Dinosaurs: Reality or Myth?]]
= *Dinosaurs: Reality or Myth?*


****
As children, we all come to know and love these alleged ancient titans, but _did they ever really exist_?
****

== Scenario: Their demise
If they did once exist, how did they cease to?

==========
Given ::
a big enough meteor icon:thumbs-up[role="green",title="Passed"]
==========

[[Head-Adornments, Head Adornments]]
== *Head Adornments*

=== Scenario: Parasaurolophus

==========
Given ::
I have an implausible head adornment icon:thumbs-up[role="green",title="Passed"]
==========

[[Birds:-Descendents-of-Titans?, Birds: Descendents of Titans?]]
= *Birds: Descendents of Titans?*



"""

  Scenario: Ordering
  Sections are ordered by their Features, which themselves are ordered using the `@order-` tag .
  The built-in Features Section is always rendered after other sections, irrespective of `@order-' tags applied to Features therein.

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

  Scenario: Skipping Sections
  Sections where all assigned Features are marked with the tag `@skipDocs` will themselves be skipped.

    Given I have the Feature
"""
@section-Anatomy
Feature: Head Adornments

  Scenario: Parasaurolophus

    Given I have an implausible head adornment
"""
    And I have the Feature
"""
@skipDocs
@section-Behaviour
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
[[Anatomy, Anatomy]]
= *Anatomy*


[[Head-Adornments, Head Adornments]]
== *Head Adornments*

=== Scenario: Parasaurolophus

==========
Given ::
I have an implausible head adornment icon:thumbs-up[role="green",title="Passed"]
==========


"""