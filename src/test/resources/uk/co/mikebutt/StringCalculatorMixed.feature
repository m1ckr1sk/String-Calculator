Feature: Mixed Operands

  Scenario: a + b * c - d
    Given I have a calculation "3 + 4 * 5 - 6"
    When I calculate the result
    Then the result must be 17
