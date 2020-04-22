@asciidoc
Feature: Enriched feature

  Scenario: Scenario with admonition and  listing
   You can use *asciidoc markup* in docstrings by using `@asciidoc` tag at feature or scenario.

   Given I have admonition with a listing in step docstring.
    """
   [TIP]
    ====
    This is a tip with source code inside
    [source,java]
    ----
    System.setProperty("INTRO_CHAPTER_DIR","/home/some/external/folder");
    ----
    ====
    """
   

 