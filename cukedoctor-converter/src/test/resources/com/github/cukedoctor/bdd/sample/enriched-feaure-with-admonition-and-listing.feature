Feature: Enriched feature

  Scenario: Scenario with admonition and  listing
   You can use *asciidoc markup* using feature comments.

#{[TIP]}
#{====}
#{This is a tip with source code inside}
#{[source,java]}
#{----}
#{System.setProperty("INTRO_CHAPTER_DIR","/home/some/external/folder");}
#{----}
#{====}
   Given I have admonition with a listing in feature comments.
   

 