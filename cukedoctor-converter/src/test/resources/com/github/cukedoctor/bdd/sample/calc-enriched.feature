@asciidoc
Feature: Calculator

  Scenario: Adding numbers
   You can *asciidoc markup* in _feature_ #description#.
   
   NOTE: This is a very important feature!
   
    Given I have numbers 1 and 2
    """
    IMPORTANT: Asciidoc markup inside *steps* must be provided via docstrings and is enabled by `@asciidoc` tag or `asciidoc` content-type on docstrings.
    """
   
    When I sum the numbers using the following java code:
"""
[source,java]
----
    public class Calc {

      public long sum(int x, int y){
          return  x + y; //<1>
      }
  }
----
<1> This is an asciidoc call inside a feature.
"""
    

    Then I should have 3 as result
    """
    * this is a list of itens inside a feature step
    * there is no multiline comment in gherkin
    ** second level list item
    """
 