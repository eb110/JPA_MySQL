Feature: Registered user operations

  Scenario: Registered user displays all films description
    Given The film list
    When I display all films
    Then The list of films is printed

  Scenario: Registered user add new actor feedback
    Given Given the new actor feedback
    When User add new feedback
    Then The msg "feedback added" is sent back

  Scenario: Registered user add new film feedback
    Given Given the new film feedback
    When User add new film feedback
    Then The msg "feedback added" is sent back

  Scenario: User delete a director by its id
    Given The director id
    When I delete the director
    Then The msg "only admin has the rights to add actors" is sent back