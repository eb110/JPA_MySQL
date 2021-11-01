Feature: Update film or actor or director by administrator

  Scenario: Update the film description providing an id that exist in db
    Given The film id
    And providing the film description
    When I update the film description
    Then The confirmation is sent back

  Scenario: Update the film description providing an id that doesn't exist in db
    Given The film id
    And providing the film description
    When I update the film description
    Then The msg "id doesn't exist" is sent back

  Scenario: Update the actor name providing the id that do exist in db
    Given The actor id
    And providing the actor name
    When I update the actor name
    Then The msg "actors name updated" is sent back