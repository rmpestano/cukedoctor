Feature: Calculator

  Scenario: Adding numbers

    Given I have numbers 1 and 2
    When I sum the numbers
    Then I should have 3 as result

  Scenario: Subtracting numbers
    A feature with a failing step

    Given I have numbers 2 and 1
    When I subtract the numbers
    Then I should have 0 as result
