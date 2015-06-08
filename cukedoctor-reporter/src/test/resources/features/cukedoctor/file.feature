Feature: Save file
  As a user of Cukedoctor
  I want to save files in the file system
  So that I can generate living documentation

  Scenario: A simple save
    Given A file with name "test.adoc"
    When I save the file in "/output" folder
    Then The file should be persisted in the filesystem

