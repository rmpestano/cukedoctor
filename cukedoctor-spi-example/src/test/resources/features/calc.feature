Feature: Calculator

  Scenario Outline: Adding numbers

    Given I have number <x> and <y>
    When I sum the number
    Then I should have <result>

  Examples:
  | x  | y  | result  |
  | 1  | 2  |  3      |
  | 2  | 2  |  4      |
  | 0  | 0  |  0      |

