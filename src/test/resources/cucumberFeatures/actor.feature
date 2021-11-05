Feature: Testing the actor

  Scenario: Test getById get request
    Given I have a film id 1
    When i want to check the name
    Then I receive a "Zenon"

  Scenario: Test the actor object
    Given a new actor
    And post actor into the db
    And then get the count of all actors from db
    And get the last actor from the db
    When i compare both actors
    And they both are the same

  Scenario: Delete te actor by id
    Given the total number of actors
    When i delete the last actor
    Then the total number has to be less by 1