Feature: Testing the filmActors functionality
  Scenario: filmActors get by id
    Given the filmActors record from the db
    When i check its film id
    Then the film id is bigger then zero

  Scenario: filmActors new feedback and get all requests
    Given the sum of filmActors
    When i post new filmActors
    Then new total filmActors number has to be higher by one

  Scenario: filmActors delete a record of db
    Given the last id of filmActors
    And the total number of filmActors
    When i delete the last filmActors record
    Then new total number of filmActors has to be lower by one