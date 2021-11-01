Feature: Delete a film description as an administrator

  Scenario: The film id do exist in db
    Given The film id
    When I delete the film
    Then The msg "film deleted" is sent back

  Scenario: The film id doesn't exist in db
    Given The film id
    When I delete the film
    Then The msg "film id doesn't exist" is sent back

  Scenario: The film title is provided
    Given The film title
    When I delete the film
    Then The msg "film deleted" is sent back

  Scenario: The film title doesn't exist in db
    Given The film title
    When I delete the film
    Then The msg "film title doesn't exist" is sent back

  Scenario: The film title or id is not provided
    Given Empty string
    When I delete the film
    Then The msg "provide the film title or id" is sent back