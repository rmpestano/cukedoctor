Feature: Features not assigned to Sections
  Features not assigned to Sections are rendered exactly as in the classic (default) Cukedoctor layout, with all its capabilities supported.

  Scenario: When the Features Section is hidden, each Feature not assigned to a Section will be rendered as a Section of its own
    Given I have the Feature
"""
Feature: Head Adornments

  Scenario: Parasaurolophus

    Given I have an implausible head adornment
"""
    And I am hiding the Features Section
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as a Section
"""asciidoc
[[Head-Adornments, Head Adornments]]
= *Head Adornments*


== Scenario: Parasaurolophus

==========
Given ::
I have an implausible head adornment icon:thumbs-up[role="green",title="Passed"]
==========


"""

  Scenario: When the Features Section is shown, Features will be rendered by default in the Features Section unless otherwise assigned
    Given I have the Feature
"""
Feature: Head Adornments

  Scenario: Parasaurolophus

    Given I have an implausible head adornment
"""
    And I am showing the Features Section
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then it will be rendered as a Subsection of the Features Section
"""asciidoc
[[Features, Features]]
= *Features*


[[Head-Adornments, Head Adornments]]
== *Head Adornments*

=== Scenario: Parasaurolophus

==========
Given ::
I have an implausible head adornment icon:thumbs-up[role="green",title="Passed"]
==========


"""

  Scenario: Features not assigned to Sections are ordered by their `@order-` tag
    [NOTE] If Features do not have an `@order-` tag, their order is not guaranteed.

    Given I have the Feature
"""
@order-2
Feature: Head Adornments

  Scenario: Parasaurolophus

    Given I have an implausible head adornment
"""
    And I have the Feature
"""
@order-1
Feature: Hunters

  Scenario: Tyranosaurus Rex

    Given I am the best hunter
"""
    And I am hiding the Features Section
    And I am hiding step timings
    And all Cukedoctor extensions are disabled
    When I convert the Feature
    Then they will be rendered as
"""asciidoc
[[Hunters, Hunters]]
= *Hunters*


== Scenario: Tyranosaurus Rex

==========
Given ::
I am the best hunter icon:thumbs-up[role="green",title="Passed"]
==========

[[Head-Adornments, Head Adornments]]
= *Head Adornments*


== Scenario: Parasaurolophus

==========
Given ::
I have an implausible head adornment icon:thumbs-up[role="green",title="Passed"]
==========


"""