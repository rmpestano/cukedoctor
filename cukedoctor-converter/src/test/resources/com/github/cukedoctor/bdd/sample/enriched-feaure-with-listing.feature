Feature: Enriched feature

  Scenario: Scenario with listing
   You can use *asciidoc markup* in docstrings using `asciidoc` content-type on docstrings

   Given I have listing in step docstring.
    """asciidoc
    [source,java]
----
System.setProperty("INTRO_CHAPTER_DIR","/home/some/external/folder");
----
    """
   

 