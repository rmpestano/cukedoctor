@asciidoc
Feature: Calculator
  *Asciidoc* in feature description!

  WARNING: To enable it you need to use *@asciidoc* tag on `feature`, or `Scenario`.

  [source,java]
  ----
  public static void main(String args[]) {

  }
  ----

  Scenario: Adding numbers
   You can use *asciidoc markup* in _feature_ #description#.

   NOTE: This is a very important feature!


    Given I have numbers 1 and 2
    """
    IMPORTANT: To enable Asciidoc markup in cucumber steps *docstrings* you need to use `@asciidoc` tag on your feature or scenario.
    """

    When I sum the numbers
    """
    * this is a list of itens inside a feature step
    * there is no multiline comment in gherkin
    ** second level list item
    """

    Then I should have 3 as result


  Scenario: Subtracting numbers
    A feature with a failing step

    Given I have numbers 2 and 1
    """

    """
    When I subtract the numbers

    Then I should have 1 as result
