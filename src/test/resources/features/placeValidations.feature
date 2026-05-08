Feature: Validating place API

  Scenario Outline: Validate if Place is being successfully added using AddPlaceAPI
    Given Add place payload "<name>" "<language>" "<address>"
    When User calls "addPlaceApi" with "POST" http request
    Then The API call is successful with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_Id created maps to "<name>" using "getPlaceApi"

  Examples:
    | name            | language   | address                   |
    | Frontline house | French-IN  | 29, side layout, cohen 09 |
    | GreenRock house | English    | 3456 North Avenue         |



 Scenario: Verify if Delete Place functionality is working
   Given DeletePlace payload
   When User calls "deletePlaceApi" with "POST" http request
   Then The API call got success with status code 200
   And "status" in response body is "OK"