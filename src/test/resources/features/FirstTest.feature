Feature: the message can be retrieved
  Scenario: client makes call to POST /fish
    When the client calls /fish
    Then the client receives status code of 200
    And the client receives server version fish
  Scenario: client makes call to GET /fish
    Given the client calls /fish
    When the client receives status code of 200
    Then the client receives server version fish