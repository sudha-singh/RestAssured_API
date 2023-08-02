Feature: Batch Module

  @01CreateProgramID200
  Scenario: User creates request for the LMS API endpoint
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for Program with mandatory ,additional fields
    Then User receives 201 Created Status with response body for program

  @02CreateBatchID200
  Scenario: Check if user able to create a Batch with valid endpoint and request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS post request for batch and request body with mandatory and additional fields
    Then User receives 201 created status for batch

  @03CreateBatchwithExistngBatchName400
  Scenario: Check if user able to create a Batch with valid endpoint and request body existing value in Batch Name
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Post Request with existing BatchName
    Then User receives 400 Bad Request Status with message

  @05GetAllBatches200
  Scenario: Check if user able to retrieve all batches  with valid LMS API
    Given User creates request for the LMS API endpoint
    When User creates GET Request for the LMS API endpoint
    Then User receives 200 status code with response body

  @06GetBatchByID200
  Scenario: Check if user able to retrieve a batch with valid BATCH ID
    Given User creates request for the LMS API endpoint
    When User creates GET Request for the LMS API endpoint with valid Batch ID
    Then User receives 200 OK Status with response body for batchID

  @07GetBatchByName200
  Scenario: Check if user able to retrieve a batch with valid BATCH NAME
    Given User creates request for the LMS API endpoint
    When User creates GET Request for the LMS API endpoint with valid Batch Name
    Then User receives 200 OK Status with batch response body

  @08GetBatchByProgramId200
  Scenario: Check if user able to retrieve a batch with valid Program ID
    Given User creates request for the LMS API endpoint
    When User creates Get Request for getting Batch by Valid ProgramID
    Then User receives 200 OK Status with response body for batch by programID

  @09UpdateBYBatchId200
  Scenario: Check if user able to update a Batch with valid batchID and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Update Request and request Body with mandatory & additional  fields
    Then User receives 200 OK Status with updated value in response body for batch

  @04CreateBatchwithmissingfields400
  Scenario: Check if user able to create a Batch missing mandatory fields in request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS post request for batch and request body without mandatory and additional fields
    Then User receives 400 Bad Request status for missing fields in batch module

  @11DeleteBatchID200
  Scenario: Check if user able to delete a batch with valid batch ID
    Given User creates request for the LMS API endpoint
    When User sends HTTPS delete Request for batch
    Then User receives 200 Ok status with message batchID deleted successfully

  @13DeleteProgramID200
  Scenario: User able to delete a program with valid programName and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request to delete Program with valid program ID
    Then User receive 200 Status with response body for delete request

  @14GetBatchByInvalidProgramId404
  Scenario: Check if user able to retrieve a batch with invalid Program Id
    Given User creates request for the LMS API endpoint
    When User creates GET Request for the LMS API endpoint with invalid Program Id
    Then User receives 404 Not Found Status with message and boolean success details for Invalid programID

  @12GetBatchByInvalidBatchID404
  Scenario: Check if user able to retrieve a batch with Invalid BATCH ID
    Given User creates request for the LMS API endpoint
    When User creates GET Request for the LMS API endpoint with Invalid Batch ID
    Then User receives 404 Not Found Status with message and boolean success details for Invalid batchID

  @03GetbyInvalidBatchName404
  Scenario: Check if user able to retrieve a batch with invalid BATCH NAME
    When User creates GET Request for the LMS API endpoint with invalid Batch name
    Then User receives 404 Not Found Status with message and boolean success details for Invalid batchName

  @10UpdateBYInvalidBatchId400
  Scenario: Check if user able to update a Batch with invalid batchID and mandatory request body
    Given User creates request for the LMS API endpoint
    When User creates PUT Request for the LMS API endpoint  and  invalid batch ID
    Then User receives 404 Not Found Status with message and boolean success details for UpdateByINvalidBatchID
