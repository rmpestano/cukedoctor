@order-3
Feature: Documentation introduction chapter
  ====
  [quote]
  ____
  In order to have an introduction chapter in my documentation
  As a bdd developer
  I want to be able to provide an asciidoc based document which introduces my software.
  ____
  ====
  Scenario: Introduction chapter in classpath
  NOTE: The introduction file must be named *intro-chapter.adoc* and can be in any package of your application,

  [TIP]
  ====
  By default Cukedoctor will look into application folders but you can make Cukedoctor look into external folder by setting the following system property:
  [source,java]
  ----
  System.setProperty("INTRO_CHAPTER_DIR","/home/some/external/folder");
  ----
  ====

	Given The following two features:
"""
Feature: Feature1

  Scenario: Scenario feature 1

    Given scenario step

Feature: Feature2

  Scenario: Scenario feature 2

    Given scenario step
"""


    And The following asciidoc document is on your application classpath
"""https://"""

    When Bdd tests results are converted into documentation by Cukedoctor



    Then Resulting documentation should have the provided introduction chapter
"""https://"""
