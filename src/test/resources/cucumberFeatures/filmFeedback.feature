Feature: Testing the film feedback functionality
  Scenario: film feedback get by id
    Given the film feedback record from the db
    When i check its film feedback
    Then the film feedback length is bigger then zero

  Scenario: film feedback new feedback and get all requests
    Given the sum of film feedbacks
    When i post new film feedback
    Then new total film feedback number has to be higher by one

  Scenario: film feedback delete a record of db
    Given the last id of film feedbacks
    And the total number of film feedbacks
    When i delete the last film feedback record
    Then new total number of film feedbacks has to be lower by one