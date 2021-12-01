Feature: Testing the director

  Scenario: Test getById get request
    Given I have a director id 1
    When i want to check director name
    Then director name is "Francis"

  Scenario: Test the director object
    Given a new director
    And post director into the db
    And then get the count of all directors from db
    And get the last director from the db
    When i compare both directors
    Then directors are the same

  Scenario: Delete the director by id
    Given the total number of directors
    When i delete the last director
    Then total number of directors has to be less by one