Feature: Testing the actor feedback functionality
  Scenario: actor feedback get by id
    Given the actor feedback record from the db
    When i check its feedback
    Then the feedback length is bigger then zero

  Scenario: actor feedback new feedback and get all requests
    Given the total number of feedbacks
    When i post new feedback
    Then new total number has to be higher by one

  Scenario: actor feedback delete a record of db
    Given the last id of actor feedbacks
    And the total number of actor feedbacks
    When i delete the last record
    Then new total number of actor feedbacks has to be lower by one