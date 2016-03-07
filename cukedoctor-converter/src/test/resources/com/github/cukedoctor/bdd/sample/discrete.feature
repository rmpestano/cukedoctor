Feature: Discrete class feature

  Scenario: Render source code

    # cukedoctor-discrete
    Given the following source code
    """
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

    # cukedoctor-discrete
    Given the following table
    """
|===

| Cell in column 1, row 1 | Cell in column 2, row 1
| Cell in column 1, row 2 | Cell in column 2, row 2
| Cell in column 1, row 3 | Cell in column 2, row 3

|===
    """