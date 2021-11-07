Feature: Testing the user

  Scenario: Test getById get request
    Given I have a user id 1
    When i want to check user name
    Then user name is "Kyle"

  Scenario: Test the user object
    Given a new user
    And post user into the db
    And then get the count of all users from db
    And get the last user from the db
    When i compare both users
    Then users are the same

  Scenario: Delete the user by id
    Given the total number of users
    When i delete the last user
    Then total number of users has to be less by one