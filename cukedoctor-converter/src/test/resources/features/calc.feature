Feature: Calculator

  Scenario: Adding numbers
   You can *asciidoc markup* in _feature_ #description#.
   
   NOTE: This is a very important feature!
   
    #{IMPORTANT: Asciidoc markup inside *steps* must be surrounded by *curly brackets*.}
    Given I have numbers 1 and 2
   
    # {NOTE: Steps comments are placed *before* each steps so this comment is for the *WHEN* step.}
    
    When I sum the numbers
    
    # {* this is a list of itens inside a feature step}
    # {* there is no multiline comment in gherkin}
    # {** second level list item} 
    Then I should have 3 as result
 