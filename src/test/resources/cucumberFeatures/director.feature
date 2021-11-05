Feature: Testing the director

  Scenario: Check getById director request
    Given Director id 1
    When i pick its name
    Then Director name is  "Franc"