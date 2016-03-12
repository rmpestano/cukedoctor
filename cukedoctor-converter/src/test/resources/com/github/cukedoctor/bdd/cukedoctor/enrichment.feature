# order: 2
Feature: Enrich features

  In order to have awesome _living documentation_
  As a bdd developer
  I want to render asciidoc markup inside my features

  Scenario: DocSting enrichment
    Asciidoc markup can be used in feature *DocStrings*. To do so you need to enable it by using *cukector-dicrete* comment on the feature.

    Given The following two features:
"""
Feature: Enrich feature

  Scenario: Render source code

    # cukedoctor-discrete
    Given the following source code in docstrings
\"\"\"
  [source, java]
  -----
  public int sum(int x, int y){
  int result = x + y;
  return result; (1)
  }
  -----
  <1> We can have callouts in living documentation
\"\"\"

  Scenario: Render table

    # cukedoctor-discrete
    Given the following table
 \"\"\"
  |===

  | Cell in column 1, row 1 | Cell in column 2, row 1
  | Cell in column 1, row 2 | Cell in column 2, row 2
  | Cell in column 1, row 3 | Cell in column 2, row 3

  |===
  \"\"\"
"""

    When I convert docstring enriched json output using cukedoctor converter

    # cukedoctor-discrete
    Then DocString asciidoc output must be rendered in my documentation
"""
[[Discrete-class-feature, Discrete class feature]]
=== *Discrete class feature*

==== Scenario: Render source code

****
Given ::
the following source code icon:thumbs-up[role="green",title="Passed"] [small right]#(267ms)#
******

[discrete]
[source, java]
-----
public int sum(int x, int y){
    int result = x + y;
    return result; <1>
}
-----
<1> We can have callouts in living documentation>


******

****

==== Scenario: Render table

****
Given ::
the following table icon:thumbs-up[role="green",title="Passed"] [small right]#(000ms)#
******

[discrete]
|===
| Cell in column 1, row 1 | Cell in column 2, row 1
| Cell in column 1, row 2 | Cell in column 2, row 2
| Cell in column 1, row 3 | Cell in column 2, row 3
|===


******

****


"""
