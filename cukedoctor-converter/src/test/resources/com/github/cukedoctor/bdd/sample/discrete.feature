@asciidoc
Feature: Discrete class feature
  `asciidoc` docstring content type is used to enable asciidoc in cucumber docstrings

  Scenario: Render source code

    Given the following source code
    """asciidoc
[source, java]
-----
public int sum(int x, int y){
        int result = x + y;
        return result; <1>
    }
-----
<1> We can have callouts in living documentation
    """

  Scenario: Render table

    Given the following table
    """asciidoc
|===

| Cell in column 1, row 1 | Cell in column 2, row 1
| Cell in column 1, row 2 | Cell in column 2, row 2
| Cell in column 1, row 3 | Cell in column 2, row 3

|===
    """