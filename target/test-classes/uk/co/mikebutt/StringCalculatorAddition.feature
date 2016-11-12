Feature: Addition

  Scenario: One plus One
    Given I have a calculation "1 + 1"
    When I calculate the result
    Then the result must be 2
    
  Scenario: One plus Two
    Given I have a calculation "1 + 2"
    When I calculate the result
    Then the result must be 3
    
  Scenario: Ten plus Two
    Given I have a calculation "10 + 2"
    When I calculate the result
    Then the result must be 12
    
  Scenario: Minus Ten plus Two
    Given I have a calculation "-10 + 2"
    When I calculate the result
    Then the result must be -8
    
  Scenario: Two plus Two plus Two
    Given I have a calculation "2 + 2 + 2"
    When I calculate the result
    Then the result must be 6

