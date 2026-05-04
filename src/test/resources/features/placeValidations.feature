Feature: Validating place API

  Scenario: Validate if Place is being successfully added using AddPlaceAPI
    Given Add place payload
    When User calls "AddPlaceAPI" with POST http request
    Then The API call is successful with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

