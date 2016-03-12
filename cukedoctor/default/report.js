$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/github/cukedoctor/bdd/cukedoctor/converter.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# order: 0"
    }
  ],
  "line": 2,
  "name": "Cukedoctor Converter",
  "description": "\nIn order to have awesome _living documentation_\nAs a bdd developer\nI want to use *Cukedoctor* to handle my cucumber reports",
  "id": "cukedoctor-converter",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 8,
  "name": "Default ordering",
  "description": "",
  "id": "cukedoctor-converter;default-ordering",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "The following two features:",
  "keyword": "Given ",
  "doc_string": {
    "content_type": "",
    "line": 11,
    "value": "Feature: Feature1\n\n  Scenario: Scenario feature 1\n\n    Given scenario step\n\nFeature: Feature2\n\n  Scenario: Scenario feature 2\n\n    Given scenario step"
  }
});
formatter.step({
  "line": 25,
  "name": "I convert their json output report using cukedoctor converter",
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 27,
      "value": "# cukedoctor-discrete"
    }
  ],
  "line": 28,
  "name": "I should have awesome living documentation",
  "keyword": "Then ",
  "doc_string": {
    "content_type": "",
    "line": 29,
    "value": "\n\u003d *Documentation*\n\ninclude::/home/pestano/projects/cukedoctor/cukedoctor-converter/target/test-classes/cukedoctor-intro.adoc[leveloffset\u003d+1]\n\n\u003d\u003d *Summary*\n[cols\u003d\"12*^m\", options\u003d\"header,footer\"]\n|\u003d\u003d\u003d\n3+|Scenarios 7+|Steps 2+|Features: 2\n\n|[green]#*Passed*#\n|[red]#*Failed*#\n|Total\n|[green]#*Passed*#\n|[red]#*Failed*#\n|[purple]#*Skipped*#\n|[maroon]#*Pending*#\n|[yellow]#*Undefined*#\n|[blue]#*Missing*#\n|Total\n|Duration\n|Status\n\n12+^|*\u003c\u003cFeature1\u003e\u003e*\n|1\n|0\n|1\n|1\n|0\n|0\n|0\n|0\n|0\n|1\n|647ms\n|[green]#*passed*#\n\n12+^|*\u003c\u003cFeature2\u003e\u003e*\n|1\n|0\n|1\n|1\n|0\n|0\n|0\n|0\n|0\n|1\n|000ms\n|[green]#*passed*#\n12+^|*Totals*\n|2|0|2|2|0|0|0|0|0|2 2+|647ms\n|\u003d\u003d\u003d\n\n\u003d\u003d *Features*\n\n[[Feature1, Feature1]]\n\u003d\u003d\u003d *Feature1*\n\n\u003d\u003d\u003d\u003d Scenario: Scenario feature 1\n\n****\nGiven ::\nscenario step icon:thumbs-up[role\u003d\"green\",title\u003d\"Passed\"] [small right]#(647ms)#\n****\n\n[[Feature2, Feature2]]\n\u003d\u003d\u003d *Feature2*\n\n\u003d\u003d\u003d\u003d Scenario: Scenario feature 2\n\n****\nGiven ::\nscenario step icon:thumbs-up[role\u003d\"green\",title\u003d\"Passed\"] [small right]#(000ms)#\n****\n\n"
  }
});
formatter.match({
  "location": "OrderingSteps.the_following_two_features(String)"
});
formatter.result({
  "duration": 233525626,
  "status": "passed"
});
formatter.match({
  "location": "ConverterSteps.I_convert_their_json_output_report_using_cukedoctor_converter()"
});
formatter.result({
  "duration": 614219669,
  "status": "passed"
});
formatter.match({
  "location": "ConverterSteps.I_should_have_awesome_living_documentation(String)"
});
formatter.result({
  "duration": 1908428,
  "status": "passed"
});
formatter.uri("com/github/cukedoctor/bdd/cukedoctor/enrichment.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# order: 2"
    }
  ],
  "line": 2,
  "name": "Enrich features",
  "description": "\nIn order to have awesome _living documentation_\nAs a bdd developer\nI want to render asciidoc markup inside my features",
  "id": "enrich-features",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 8,
  "name": "DocSting enrichment",
  "description": "Asciidoc markup can be used in feature *DocStrings*. To do so you need to enable it by using *cukector-dicrete* comment on the feature.",
  "id": "enrich-features;docsting-enrichment",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "The following two features:",
  "keyword": "Given ",
  "doc_string": {
    "content_type": "",
    "line": 12,
    "value": "Feature: Enrich feature\n\n  Scenario: Render source code\n\n    # cukedoctor-discrete\n    Given the following source code in docstrings\n\"\"\"\n  [source, java]\n  -----\n  public int sum(int x, int y){\n  int result \u003d x + y;\n  return result; (1)\n  }\n  -----\n  \u003c1\u003e We can have callouts in living documentation\n\"\"\"\n\n  Scenario: Render table\n\n    # cukedoctor-discrete\n    Given the following table\n \"\"\"\n  |\u003d\u003d\u003d\n\n  | Cell in column 1, row 1 | Cell in column 2, row 1\n  | Cell in column 1, row 2 | Cell in column 2, row 2\n  | Cell in column 1, row 3 | Cell in column 2, row 3\n\n  |\u003d\u003d\u003d\n  \"\"\""
  }
});
formatter.step({
  "line": 45,
  "name": "I convert docstring enriched json output using cukedoctor converter",
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 47,
      "value": "# cukedoctor-discrete"
    }
  ],
  "line": 48,
  "name": "DocString asciidoc output must be rendered in my documentation",
  "keyword": "Then ",
  "doc_string": {
    "content_type": "",
    "line": 49,
    "value": "[[Discrete-class-feature, Discrete class feature]]\n\u003d\u003d\u003d *Discrete class feature*\n\n\u003d\u003d\u003d\u003d Scenario: Render source code\n\n****\nGiven ::\nthe following source code icon:thumbs-up[role\u003d\"green\",title\u003d\"Passed\"] [small right]#(267ms)#\n******\n\n[discrete]\n[source, java]\n-----\npublic int sum(int x, int y){\n    int result \u003d x + y;\n    return result; \u003c1\u003e\n}\n-----\n\u003c1\u003e We can have callouts in living documentation\u003e\n\n\n******\n\n****\n\n\u003d\u003d\u003d\u003d Scenario: Render table\n\n****\nGiven ::\nthe following table icon:thumbs-up[role\u003d\"green\",title\u003d\"Passed\"] [small right]#(000ms)#\n******\n\n[discrete]\n|\u003d\u003d\u003d\n| Cell in column 1, row 1 | Cell in column 2, row 1\n| Cell in column 1, row 2 | Cell in column 2, row 2\n| Cell in column 1, row 3 | Cell in column 2, row 3\n|\u003d\u003d\u003d\n\n\n******\n\n****\n\n"
  }
});
formatter.match({
  "location": "OrderingSteps.the_following_two_features(String)"
});
formatter.result({
  "duration": 230307,
  "status": "passed"
});
formatter.match({
  "location": "EnrichmentSteps.I_convert_docstring_enriched_json_output_using_cukedoctor_converter()"
});
formatter.result({
  "duration": 48497353,
  "status": "passed"
});
formatter.match({
  "location": "EnrichmentSteps.DocString_asciidoc_output_must_be_rendered_in_my_documentation(String)"
});
formatter.result({
  "duration": 241700,
  "status": "passed"
});
formatter.scenario({
  "line": 97,
  "name": "Comments enrichment",
  "description": "Asciidoc markup can be used in feature comments. To do so you need to surround asciidoc markup by *curly brackets*;.",
  "id": "enrich-features;comments-enrichment",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 100,
  "name": "The following feature with asciidoc markup in comments:",
  "keyword": "Given ",
  "doc_string": {
    "content_type": "",
    "line": 101,
    "value": "Feature: Calculator\n\n  Scenario: Adding numbers\n   You can *asciidoc markup* in _feature_ #description#.\n\n    NOTE: This is a very important feature!\n\n    #{IMPORTANT: Asciidoc markup inside *steps* must be surrounded by *curly brackets*.}\n    Given I have numbers 1 and 2\n\n    # {NOTE: Steps comments are placed *before* each steps so this comment is for the *WHEN* step.}\n\n    When I sum the numbers\n    # {* this is a list of itens inside a feature step}\n    # {* there is no multiline comment in gherkin}\n    # {** second level list item}\n    Then I should have 3 as result\n"
  }
});
formatter.step({
  "line": 122,
  "name": "I convert enriched feature json output using cukedoctor",
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 124,
      "value": "# cukedoctor-discrete"
    }
  ],
  "line": 125,
  "name": "Asciidoc markup on comments must be rendered in my documentation",
  "keyword": "Then ",
  "doc_string": {
    "content_type": "",
    "line": 126,
    "value": "[[Calculator, Calculator]]\n\u003d\u003d\u003d *Calculator*\n\n\u003d\u003d\u003d\u003d Scenario: Adding numbers\nYou can use *asciidoc markup* in _feature_ #description#.\n\nNOTE: This is a very important feature!\n\n****\nGiven ::\nI have numbers 1 and 2 icon:thumbs-up[role\u003d\"green\",title\u003d\"Passed\"] [small right]#(114ms)#\n\nIMPORTANT: Asciidoc markup inside *steps* must be surrounded by *curly brackets*.\n\nWhen ::\nI sum the numbers icon:thumbs-up[role\u003d\"green\",title\u003d\"Passed\"] [small right]#(000ms)#\n\nNOTE: Steps comments are placed *before* each steps so this comment is for the *WHEN* step.\n\nThen ::\nI should have 3 as result icon:thumbs-up[role\u003d\"green\",title\u003d\"Passed\"] [small right]#(001ms)#\n\n* this is a list of itens inside a feature step\n\n* there is no multiline comment in gherkin\n\n** second level list item\n\n****\n\n"
  }
});
formatter.match({
  "location": "EnrichmentSteps.The_following_feature_with_asciidoc_markup_in_comments(String)"
});
formatter.result({
  "duration": 467198,
  "status": "passed"
});
formatter.match({
  "location": "EnrichmentSteps.I_convert_enriched_feature_json_output_using_cukedoctor()"
});
formatter.result({
  "duration": 38895326,
  "status": "passed"
});
formatter.match({
  "location": "EnrichmentSteps.Asciidoc_output_must_be_rendered_in_my_documentation(String)"
});
formatter.result({
  "duration": 530470,
  "status": "passed"
});
formatter.uri("com/github/cukedoctor/bdd/cukedoctor/ordering.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# order: 1"
    }
  ],
  "line": 2,
  "name": "Ordering",
  "description": "\nIn order to have features ordered in living documentation\nAs a bdd developer\nI want to control the order of features in my documentation",
  "id": "ordering",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 9,
  "name": "Default ordering",
  "description": "",
  "id": "ordering;default-ordering",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "The following two features:",
  "keyword": "Given ",
  "doc_string": {
    "content_type": "",
    "line": 12,
    "value": "Feature: Feature1\n\n  Scenario: Scenario feature 1\n\n    Given scenario step\n\nFeature: Feature2\n\n  Scenario: Scenario feature 2\n\n    Given scenario step"
  }
});
formatter.step({
  "line": 25,
  "name": "I convert them using default order",
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 27,
      "value": "# cukedoctor-discrete"
    }
  ],
  "line": 28,
  "name": "Features should be ordered by name in resulting documentation",
  "keyword": "Then ",
  "doc_string": {
    "content_type": "",
    "line": 29,
    "value": "[[Feature1, Feature1]]\n\u003d\u003d\u003d *Feature1*\n\n\u003d\u003d\u003d\u003d Scenario: Scenario feature 1\n\n****\nGiven ::\nscenario step icon:thumbs-up[role\u003d\"green\",title\u003d\"Passed\"] [small right]#(647ms)#\n****\n\n[[Feature2, Feature2]]\n\u003d\u003d\u003d *Feature2*\n\n\u003d\u003d\u003d\u003d Scenario: Scenario feature 2\n\n****\nGiven ::\nscenario step icon:thumbs-up[role\u003d\"green\",title\u003d\"Passed\"] [small right]#(000ms)#\n****\n\n"
  }
});
formatter.match({
  "location": "OrderingSteps.the_following_two_features(String)"
});
formatter.result({
  "duration": 92678,
  "status": "passed"
});
formatter.match({
  "location": "OrderingSteps.I_convert_the_using_default_order()"
});
formatter.result({
  "duration": 32647922,
  "status": "passed"
});
formatter.match({
  "location": "OrderingSteps.Features_should_be_ordered_by_name_in_resulting_documentation(String)"
});
formatter.result({
  "duration": 185795,
  "status": "passed"
});
formatter.scenario({
  "line": 53,
  "name": "Custom ordering",
  "description": "",
  "id": "ordering;custom-ordering",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "comments": [
    {
      "line": 55,
      "value": "#{NOTE: Ordering is done using feature comment \u0027*#order:*\u0027}"
    }
  ],
  "line": 56,
  "name": "The following two features:",
  "keyword": "Given ",
  "doc_string": {
    "content_type": "",
    "line": 57,
    "value": "#order: 2\nFeature: Feature1\n\n  Scenario: Scenario feature 1\n\n    Given scenario step\n\n#order: 1\nFeature: Feature2\n\n  Scenario: Scenario feature 2\n\n    Given scenario step"
  }
});
formatter.step({
  "line": 72,
  "name": "I convert them using comment order",
  "keyword": "When "
});
formatter.step({
  "comments": [
    {
      "line": 74,
      "value": "# cukedoctor-discrete"
    }
  ],
  "line": 75,
  "name": "Features should be ordered respecting order comment",
  "keyword": "Then ",
  "doc_string": {
    "content_type": "",
    "line": 76,
    "value": "[[Feature2, Feature2]]\n\u003d\u003d\u003d *Feature2*\n\n\u003d\u003d\u003d\u003d Scenario: Scenario feature 2\n\n****\nGiven ::\nscenario step icon:thumbs-up[role\u003d\"green\",title\u003d\"Passed\"] [small right]#(000ms)#\n****\n\n[[Feature1, Feature1]]\n\u003d\u003d\u003d *Feature1*\n\n\u003d\u003d\u003d\u003d Scenario: Scenario feature 1\n\n****\nGiven ::\nscenario step icon:thumbs-up[role\u003d\"green\",title\u003d\"Passed\"] [small right]#(313ms)#\n****\n\n"
  }
});
formatter.match({
  "location": "OrderingSteps.the_following_two_features(String)"
});
formatter.result({
  "duration": 116951,
  "status": "passed"
});
formatter.match({
  "location": "OrderingSteps.I_convert_them__using_comment_order()"
});
formatter.result({
  "duration": 29332868,
  "status": "passed"
});
formatter.match({
  "location": "OrderingSteps.Features_should_be_ordered_respecting_order_comment(String)"
});
formatter.result({
  "duration": 97131,
  "status": "passed"
});
});