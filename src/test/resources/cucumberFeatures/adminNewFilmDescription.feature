Feature: Add film description as an administrator

  Scenario: The film title doesn't exist in the db
    Given The film description
    And providing the film title
    When I add the film to the db
    Then The confirmation is sent back

  Scenario: The film title do exist in the db
    Given The film description
    And providing the film title
    When I add the film to the db
    Then The msg "film already exist" is sent back

  Scenario: The film title is not provided
    Given The film description
    When I add the film to the db
    Then The msg "provide the film title" is sent back