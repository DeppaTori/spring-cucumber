Feature: User can be retrieved
  Scenario: client makes call to GET /userid
    When the client calls /1
    Then the client receives status code of 200
    And the client receives User Tiara
