Feature: Program Feature

  @01PostRequest_Program_1
  Scenario: User creates request for the LMS API endpoint
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for Program with mandatory ,additional fields
    Then User receives 201 Created Status with response body for program

  @02GetRequest_AllPrograms
  Scenario: User able to retrieve all programs with valid LMS API
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request for Program to get all programs
    Then User receives 200 OK Status with response body

  @03PutRequest_updateProgrambyValidID
  Scenario: User able to update a program with valid programID and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request with mandatory and additional fields for Program with valid program ID
    Then User receives 200 ok Status code with response body for update

  @04GetRequest_ValidProgramID
  Scenario: User able to retrieve a program with valid programID and LMS API
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request for Program with valid program ID
    Then User receives 200 OK Status with response body

  @05DeleteRequest_DeleteProgramwithvalidProgramID
  Scenario: User able to delete a program with valid programId and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request to delete Program with valid program ID
    Then User receive 200 Status with response body for delete request

  @06DeleteRequest_DeleteProgramwithinvalidProgramID
  Scenario: User able to delete a program with invalid programName and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request to delete Program with invalid program ID
    Then User get 404 Status with response body for delete request

  @09PostRequest_missingMandatoryFields
  Scenario: User create program with missing mandatory fields.
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for program with missing mandatory fields.
    Then User receives 400 Bad Request Status with message and boolean success details

  @10PutRequest_updateProgrambyIDwithMissingMandatoryFields
  Scenario: User tries to update a program with missing mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request for Program with missing mandatory fields
    Then User receives 400 Bad Request Status with message and boolean success details

  @11PutRequest_updateProgrambyProgramNamewithMissingMandatoryFields
  Scenario: User tries to update a program with valid Program name and missing mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request for Program with valid Program name and missing mandatory fields
    Then User receives 404 Bad Request Status with message and boolean success details

  @PostRequest_Program2
  Scenario: User creates request for the LMS API endpoint
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for Program with mandatory ,additional fields
    Then User receives 201 Created Status with response body for program

  @07PostRequest_existingValues
  Scenario: User create program with valid endpoint and existing Program name.
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for Program with existing values in program name.
    Then User receives 400 Bad Request Status with message and boolean success details

  @08PutRequest_updateProgrambyValidProgramName
  Scenario: User able to update a program with valid programName and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request with mandatory and additional fields for Program with valid program name
    Then User receives 200 ok Status code with response body for update

  @12DeleteProgramwithvalidProgramName
  Scenario: User able to delete a program with valid programName and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request to delete Program with valid program name
    Then User receive 200 Status with response body for delete request

  @13GetRequest_GetwithinvalidProgramID
  Scenario: User tries to retrieve a program with invalid programID and LMS API
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request for Program with invalid program ID
    Then User receives 404 Status code with response body

  @14PutRequest_updateProgramwithinvalidProgramID
  Scenario: User tries to update a program with invalid programID and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request with mandatory and additional fields for Program with invalid program ID
    Then User receives 404 Status code with response body

  @15PutRequest_updateProgramwithinvalidProgramName
  Scenario: User tries to update a program with invalid programName and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request with mandatory and additional fields for Program with invalid program Name
    Then User receives 404 Status code with response body

  @16DeleteProgramwithinvalidProgramName
  Scenario: User able to delete a program with invalid programName and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request to delete Program with invalid program name
    #Then User receives 404 Status code with response body
