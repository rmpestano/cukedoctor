@section-Sections
@order-3
Feature: Subsections

  Scenario: Assigning a Feature to a Subsection
Features are assigned to Subsections using the `@subsection-` tag

Given I have the Feature
"""
@section-Dinosaurs
@subsection-Behaviour
Feature: Eating Habits

  Scenario: Hunting
"""
And I have the Feature
"""
@section-Dinosaurs
@subsection-Appearance
Feature: Head Adornments

  Scenario: Frills
"""
And I have the Feature
"""
@subsection-Relatives
Feature: Direct descendents

  Scenario: Birds
"""
And I am showing the Features Section
And I am hiding step timings
And all Cukedoctor extensions are disabled
When I convert the Feature
Then they will be rendered as
"""asciidoc
[[Dinosaurs, Dinosaurs]]
= *Dinosaurs*


[[Behaviour, Behaviour]]
== *Behaviour*

[[Eating-Habits, Eating Habits]]
=== *Eating Habits*

==== Scenario: Hunting

[[Appearance, Appearance]]
== *Appearance*

[[Head-Adornments, Head Adornments]]
=== *Head Adornments*

==== Scenario: Frills

[[Features, Features]]
= *Features*


[[Relatives, Relatives]]
== *Relatives*

[[Direct-descendents, Direct descendents]]
=== *Direct descendents*

==== Scenario: Birds


"""


  Scenario: Title and Preamble
  In the same manner as Sections, a Feature tagged with a Subsection, containing a Scenario named 'Root' will be used as the Root of the Subsection. The name of this Feature will be used to render the Subsection's name and the Feature's description will be rendered immediately underneath.
  You can use full AsciiDoc markup in a Feature's description to provide as much of a preamble to the Subsection as you wish, or none at all. You can also provide other Scenarios in the Feature, which will be rendered as normal.

  If multiple Roots are defined for a Section, the result is undefined.

    Given I have the Feature
"""
@section-Dinosaurs
@subsection-HeadAdornments
Feature: Sonic Phenomenon

  Scenario: Parasaurolophus
"""
    And I have the Feature
"""
@section-Dinosaurs
Feature: Dinosaurs: Reality or Myth?
As children, we all come to know and love these alleged ancient titans, but _did they ever really exist_?

  Scenario: Root
"""
    And I have the Feature
"""
@section-Dinosaurs
@subsection-HeadAdornments
Feature: Head Adornments
Big ones, small ones...

  Scenario: Root
"""
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as
"""asciidoc
[[Dinosaurs:-Reality-or-Myth?, Dinosaurs: Reality or Myth?]]
= *Dinosaurs: Reality or Myth?*


As children, we all come to know and love these alleged ancient titans, but _did they ever really exist_?

[[Head-Adornments, Head Adornments]]
== *Head Adornments*

Big ones, small ones...

[[Sonic-Phenomenon, Sonic Phenomenon]]
=== *Sonic Phenomenon*

==== Scenario: Parasaurolophus


"""

  Scenario: Ordering
  Subsections are ordered by their Features, which themselves are ordered using the `@order-` tag .

    Given I have the Feature
"""
@section-Dinosaurs
@subsection-HeadAdornments
@order-2
Feature: Sonic Phenomenon

  Scenario: Parasaurolophus
"""
    And I have the Feature
"""
@section-Dinosaurs
@subsection-Behaviour
@order-1
Feature: Hunters

  Scenario: Tyranosaurus Rex
"""
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as
"""asciidoc
[[Dinosaurs, Dinosaurs]]
= *Dinosaurs*


[[Behaviour, Behaviour]]
== *Behaviour*

[[Hunters, Hunters]]
=== *Hunters*

==== Scenario: Tyranosaurus Rex

[[HeadAdornments, HeadAdornments]]
== *HeadAdornments*

[[Sonic-Phenomenon, Sonic Phenomenon]]
=== *Sonic Phenomenon*

==== Scenario: Parasaurolophus


"""

  Scenario: Skipping
  Subsections where all assigned Features are marked with the tag `@skipDocs` will themselves be skipped.

    Given I have the Feature
"""
@skipDocs
@section-Dinosaurs
@subsection-Behaviour
@order-2
Feature: Foragers

  Scenario: Diplodocus
"""
    And I have the Feature
"""
@skipDocs
@section-Dinosaurs
@subsection-Behaviour
@order-1
Feature: Hunters

  Scenario: Tyranosaurus Rex
"""
    And I have the Feature
"""
@section-Dinosaurs
@subsection-Flavour
@order-3
Feature: Modern References

  Scenario: Chicken
"""
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as
"""asciidoc
[[Dinosaurs, Dinosaurs]]
= *Dinosaurs*


[[Flavour, Flavour]]
== *Flavour*

[[Modern-References, Modern References]]
=== *Modern References*

==== Scenario: Chicken


"""