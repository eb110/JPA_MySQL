Feature: Testing the actor

  Scenario: Check the name
    Given "Zenek" is a name
    When I receive the actors name
    Then The confirmation should be positive

  #Scenario: Test getById get request
 #   Given I have a film id 1
 #   When i want to check the name
 #   Then I receive a "Zenek"