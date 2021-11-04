Feature: Testing the director

  Scenario: Check the name
    Given "Zenek" is a director name
    When I receive the director name
    Then The confirmation for director should be positive