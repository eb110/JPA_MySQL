Feature: Testing the director

  Scenario: Check getById director request
    Given Director id 1
    When i pick its name
    Then Director name is  "Franc"

  Scenario: Check the getAll director request
    Given the list of directors
    When i get all directors
    Then Directors total number is 5