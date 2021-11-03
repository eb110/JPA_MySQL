Feature: Testing the actor

  Scenario: Check the name
    Given "Zenek" is a name
    When I receive the actors name
    Then The confirmation should be positive