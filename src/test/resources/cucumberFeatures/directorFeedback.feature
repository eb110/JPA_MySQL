Feature: Testing the director feedback functionality
  Scenario: director feedback get by id
    Given the director feedback record from the db
    When i check its director feedback
    Then the director feedback length is bigger then zero

  Scenario: director feedback new feedback and get all requests
    Given the sum of director feedbacks
    When i post new director feedback
    Then new total director feedback number has to be higher by one

  Scenario: director feedback delete a record of db
    Given the last id of director feedbacks
    And the total number of director feedbacks
    When i delete the last director feedback record
    Then new total number of director feedbacks has to be lower by one