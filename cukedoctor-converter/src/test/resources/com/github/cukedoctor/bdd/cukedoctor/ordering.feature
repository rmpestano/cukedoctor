# order: 1
Feature: Ordering
  ====
  [quote]
  ____
  In order to have features ordered in living documentation
  As a bdd developer
  I want to control the order of features in my documentation
  ____
  ====

  Scenario: Default ordering

    Given The following two features:
"""
Feature: Feature1

  Scenario: Scenario feature 1

    Given scenario step

Feature: Feature2

  Scenario: Scenario feature 2

    Given scenario step
"""
    When I convert them using default order

    # cukedoctor-discrete
    Then Features should be ordered by name in resulting documentation
"""
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

  Scenario: Custom ordering

    #{NOTE: Ordering is done using feature comment '*#order:*'}
    Given The following two features:
"""
#order: 2
Feature: Feature1

  Scenario: Scenario feature 1

    Given scenario step

#order: 1
Feature: Feature2

  Scenario: Scenario feature 2

    Given scenario step
"""
    When I convert them using comment order

# cukedoctor-discrete
    Then Features should be ordered respecting order comment
"""
== *Features*

[[Feature2, Feature2]]
=== *Feature2*

==== Scenario: Scenario feature 2

====
Given ::
scenario step icon:thumbs-up[role="green",title="Passed"] [small right]#(000ms)#
====

[[Feature1, Feature1]]
=== *Feature1*

==== Scenario: Scenario feature 1

====
Given ::
scenario step icon:thumbs-up[role="green",title="Passed"] [small right]#(313ms)#
====


"""
