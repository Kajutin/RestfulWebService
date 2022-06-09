Feature: the version can be retrieved
  Scenario: client makes call to GET /fish
    When the client calls /fish
    Then the client receives status code of 200
    And the client receives server version 1.0