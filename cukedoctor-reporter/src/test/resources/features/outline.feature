Feature: An outline feature

  Scenario Outline: outline
    Given this step <status>

    Examples: examples1
      | status |
      | passes |
      | fails  |

    Examples: examples2
      | status |
      | passes |