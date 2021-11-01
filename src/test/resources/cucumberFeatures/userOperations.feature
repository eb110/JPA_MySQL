Feature: User operations

  Scenario: User displays all films description
    Given The film list
    When I display all films
    Then The list of films is printed

  Scenario: User add new actor to the db
    Given Given the new actor
    When User add new actor
    Then The msg "only admin has the rights to add actors" is sent back

  Scenario: User delete a director by its id
    Given The director id
    When I delete the director
    Then The msg "only admin has the rights to add actors" is sent back