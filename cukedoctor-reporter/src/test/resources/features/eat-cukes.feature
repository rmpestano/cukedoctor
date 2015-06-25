Feature: Eat cukes in lot

  Scenario Outline: Eating many cukes

    Given I have <X> cukes
    When I eat <Y> cukes
    Then Am I hungry? "<hungry>"

    Examples:
      | X     | Y     | hungry    |
      | 10    | 5     | false     |
      | 0     | 0     | true      |
      | 2     | 3     | true      |
      | 20600 | 20599 | false     |