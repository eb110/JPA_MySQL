Feature: Testing the actor

  Scenario: Test getById get request
    Given I have a film id 1
    When i want to check film title
    Then film title is "KyleTitle"

  Scenario: Test the film object
    Given a new film
    And post film into the db
    And then get the count of all films from db
    And get the last film from the db
    When i compare both films
    Then films are the same

  Scenario: Delete the film by id
    Given the total number of films
    When i delete the last film
    Then total number of films has to be less by one