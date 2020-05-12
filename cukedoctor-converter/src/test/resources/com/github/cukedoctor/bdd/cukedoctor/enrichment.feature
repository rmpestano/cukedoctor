@order-2
Feature: Enrich features
  ====
  [quote]
  ____
  In order to have awesome _living documentation_
  As a bdd developer
  I want to render asciidoc markup inside my features.
  ____
  ====

  https://asciidoctor.org/docs/what-is-asciidoc/[Asciidoc^] markup can be used in feature *DocStrings*. To do so you can enable it by using *@asciidoc* tag at `feature` or `scenario` level.

  [IMPORTANT]
  =====
  Adding @asciidoc tag at *feature level* will make cukedoctor interpret `all features docstrings` as Asciidoc markup.

  Adding @asciidoc at *scenario level* will make cukedoctor interpret `all steps docstrings` as asciidoc markup.

  TIP: To enable asciidoc markup in a *single step* you can use `asciidoc` as https://relishapp.com/cucumber/cucumber/docs/gherkin/doc-strings#docstring-with-interesting-content-type[docstring content type^].
  =====

  NOTE: Feature and scenario descriptions are automatically interpreted as Asciidoc markup without the need for adding the feature tag.


  Scenario: DocString enrichment activated by the content type
  Asciidoc markup can be used in feature *DocStrings*. To do so you can enable it by using the content type *[asciidoc]* in the DocString.

    Given The following two features:
"""
Feature: Discrete class feature

  Scenario: Render source code

    Given the following source code in docstrings
\"\"\"asciidoc
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

    Given the following table
 \"\"\"asciidoc
  |===

  | Cell in column 1, row 1 | Cell in column 2, row 1
  | Cell in column 1, row 2 | Cell in column 2, row 2
  | Cell in column 1, row 3 | Cell in column 2, row 3

  |===
\"\"\"
"""

    When I convert enriched docstring with asciidoc content type using cukedoctor converter

    Then DocString asciidoc output must be rendered in my documentation
"""asciidoc
== *Features*

[[Discrete-class-feature, Discrete class feature]]
=== *Discrete class feature*

==== Scenario: Render source code

==========
Given ::
the following source code in docstrings icon:thumbs-up[role="green",title="Passed"] [small right]#(002ms)#
******

[discrete]
[source, java]
-----
public int sum(int x, int y){
    int result = x + y;
    return result; (1)
}
-----
[discrete]
<1> We can have callouts in living documentation


******
==========

==== Scenario: Render table

==========
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
==========


"""

  Scenario: DocString enrichment activated by a feature tag
  Asciidoc markup can be used in feature *DocStrings*. You can enable this by applying the tag [@asciidoc] to the feature. Note this enables the enrichment for all DocStrings within the feature.

    Given The following two features:
"""
@asciidoc
Feature: Discrete class feature

  Scenario: Render source code

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

    Given the following table
 \"\"\"
  |===

  | Cell in column 1, row 1 | Cell in column 2, row 1
  | Cell in column 1, row 2 | Cell in column 2, row 2
  | Cell in column 1, row 3 | Cell in column 2, row 3

  |===
\"\"\"
"""

    When I convert enriched docstring with asciidoc feature tag using cukedoctor converter

    Then DocString asciidoc output must be rendered in my documentation
"""asciidoc
== *Features*

[[Discrete-class-feature, Discrete class feature]]
=== *Discrete class feature*

==== Scenario: Render source code

==========
Given ::
the following source code in docstrings icon:thumbs-up[role="green",title="Passed"] [small right]#(011ms)#
******

[discrete]
[source, java]
-----
public int sum(int x, int y){
    int result = x + y;
    return result; (1)
}
-----
[discrete]
<1> We can have callouts in living documentation


******
==========

==== Scenario: Render table

==========
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
==========


"""

  Scenario: DocString enrichment activated by a scenario tag
  Asciidoc markup can be used in feature *DocStrings*. You can enable this by applying the tag [@asciidoc] to the scenario. Note this enables the enrichment for all DocStrings within the scenario.

    Given The following two features:
"""
Feature: Discrete class feature

  @asciidoc
  Scenario: Render source code

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

  @asciidoc
  Scenario: Render table

    Given the following table
 \"\"\"
  |===

  | Cell in column 1, row 1 | Cell in column 2, row 1
  | Cell in column 1, row 2 | Cell in column 2, row 2
  | Cell in column 1, row 3 | Cell in column 2, row 3

  |===
\"\"\"
"""

    When I convert enriched docstring with asciidoc scenario tag using cukedoctor converter


    Then DocString asciidoc output must be rendered in my documentation
"""asciidoc
== *Features*

[[Discrete-class-feature, Discrete class feature]]
=== *Discrete class feature*

==== Scenario: Render source code

==========
Given ::
the following source code in docstrings icon:thumbs-up[role="green",title="Passed"] [small right]#(002ms)#
******

[discrete]
[source, java]
-----
public int sum(int x, int y){
    int result = x + y;
    return result; (1)
}
-----
[discrete]
<1> We can have callouts in living documentation


******
==========

==== Scenario: Render table

==========
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
==========


"""


    Scenario: Whitespace in descriptions
      Features and Scenarios can have multi-line descriptions. In a feature file, these may be indented.
      Cukedoctor uses the indentation of the first line non-blank line of the description to determine the difference
      between the indentation _of_ the description in a feature file and your desired indentation _within_ the the
      description itself.

    Given the feature:
"""
  Feature: Feature One


    This is the description for Feature One. The first non-blank line of this description in the feature file began with four whitespace characters.
      Therefore, cukedoctor will ignore up to the first four
whitespace characters
  in all other lines in the same description,
    if any are present.


This includes
  further lines
    in a different
      paragraph
        in the same description.



    Scenario: Scenario One

    This is the description for Scenario One. The first non-blank line of this description in the feature file began with four whitespace characters.
      Therefore, cukedoctor will ignore up to the first four
whitespace characters
  in all other lines in the same description,
    if any are present.


This includes
  further lines
    in a different
      paragraph
        in the same description.



    Scenario: Scenario Two
This scenario has no indentation. You don't have to use it, after all.
      Indentation in subsequent lines is therefore fully preserved.

"""
  When I convert it
  Then it should be rendered in AsciiDoc as
"""asciidoc
== *Features*

[[Feature-One, Feature One]]
=== *Feature One*

****
This is the description for Feature One. The first non-blank line of this description in the feature file began with four whitespace characters.
  Therefore, cukedoctor will ignore up to the first four
whitespace characters
in all other lines in the same description,
if any are present.


This includes
further lines
in a different
  paragraph
    in the same description.
****

==== Scenario: Scenario One
This is the description for Scenario One. The first non-blank line of this description in the feature file began with four whitespace characters.
  Therefore, cukedoctor will ignore up to the first four
whitespace characters
in all other lines in the same description,
if any are present.


This includes
further lines
in a different
  paragraph
    in the same description.

==== Scenario: Scenario Two
This scenario has no indentation. You don't have to use it, after all.
      Indentation in subsequent lines is therefore fully preserved.

"""