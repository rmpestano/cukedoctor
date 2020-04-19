# order: 2
Feature: Enrich features
  ====
  [quote]
  ____
  In order to have awesome _living documentation_
  As a bdd developer
  I want to render asciidoc markup inside my features.
  ____
  ====
  Scenario: DocString enrichment activated by a step comment
Asciidoc markup can be used in feature *DocStrings*. To do so you can enable it by using *[cukedoctor-discrete]* comment on the step containing the DocString.

  Given The following two features:
"""
Feature: Discrete class feature

  Scenario: Render source code

    # cukedoctor-discrete
    Given the following source code in docstrings
\"\"\"
  [source, java]
  -----
  public int sum(int x, int y){
  int result = x + y;
  return result; <1>
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

  When I convert docstring enriched json output activated with a step comment using cukedoctor converter

    # cukedoctor-discrete
  Then DocString asciidoc output must be rendered in my documentation
"""
== *Features*

[[Discrete-class-feature, Discrete class feature]]
=== *Discrete class feature*

==== Scenario: Render source code

==========
Given ::
the following source code in docstrings icon:thumbs-up[role="green",title="Passed"] [small right]#(267ms)#
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

    When I convert docstring enriched json output activated with the content type using cukedoctor converter

    # cukedoctor-discrete
    Then DocString asciidoc output must be rendered in my documentation
"""
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

    When I convert docstring enriched json output activated with a feature tag using cukedoctor converter

    # cukedoctor-discrete
    Then DocString asciidoc output must be rendered in my documentation
"""
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

    When I convert docstring enriched json output activated with a scenario tag using cukedoctor converter

    # cukedoctor-discrete
    Then DocString asciidoc output must be rendered in my documentation
"""
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

  Scenario: Comments enrichment
  Asciidoc markup can be used in feature comments. To do so you need to surround asciidoc markup by *curly brackets*;.

    Given The following feature with asciidoc markup in comments:
"""
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

"""

    When I convert enriched feature json output using cukedoctor

# cukedoctor-discrete
    Then Asciidoc markup on comments must be rendered in my documentation
"""
==*Features*

[[Calculator,Calculator]]
===*Calculator*

====Scenario:Addingnumbers
Youcanuse*asciidocmarkup*in_feature_#description#.

NOTE:Thisisaveryimportantfeature!

==========
Given::
Ihavenumbers1and2icon:thumbs-up[role="green",title="Passed"][smallright]#(114ms)#

IMPORTANT:Asciidocmarkupinside*steps*mustbesurroundedby*curlybrackets*.

When::
Isumthenumbersicon:thumbs-up[role="green",title="Passed"][smallright]#(000ms)#

NOTE:Stepscommentsareplaced*before*eachstepssothiscommentisforthe*WHEN*step.

Then::
Ishouldhave3asresulticon:thumbs-up[role="green",title="Passed"][smallright]#(001ms)#

*thisisalistofitensinsideafeaturestep

*thereisnomultilinecommentingherkin

**secondlevellistitem

==========


"""
