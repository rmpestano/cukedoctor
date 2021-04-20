Feature: Generate Multiple Pages
  As a documentation manager
  I want the cukedoctor-multipage-layout plugin to generate multiple adoc pages
  So that I can create a webpage based on them

  Background:
    Given the following feature file
        """
        Feature: Calculator1
          Scenario: Sum two positives
            Given I have 2 and 2
            When I sum the two numbers
            Then I get 4
        """
    And the following feature file
        """
        Feature: Calculator2
          Scenario: Sum two positives
            Given I have 2 and 2
            When I sum the two numbers
            Then I get 4
        """

  Rule: Generate one page per feature

    Example: One page per scenario
      Given the output folder is set to 'target/docs/generated/'
      When I run the cukedoctor-multipage-layout plugin
      Then I have the following files generated
        | Calculator1.adoc | Calculator2.adoc |

  Rule: Page attributes passed to the MultipageConverter are used for each Page

    Example: Setting the :toc: attribute
      Given I set the :toc: "left" attribute
      When I run the cukedoctor-multipage-layout plugin
      Then the generated pages have the ":toc:" meta property set
