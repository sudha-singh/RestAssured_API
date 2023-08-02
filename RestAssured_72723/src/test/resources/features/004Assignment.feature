Feature: Assignment Scenario

  @GetAllAssignments
  Scenario: Check if user able to retrieve a record with valid LMS API
    Given User creates request for the LMS API endpoint
    When User sends HTTP request
    Then User receives 200 ok with response body

  @CreateProgram
  Scenario: User creates request for the LMS API endpoint
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for Program with mandatory ,additional fields
    Then User receives 201 Created Status with response body for program

  @CreateBatch
  Scenario: Create a new Batch
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for Batch  with mandatory ,additional fields
    Then User receives 201 Created Status with response body for batch

  @createUser
  Scenario: Create a new User
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for User  with mandatory ,additional fields
    Then User receives status code 201 with response body for creating an User for Admin role

  @createAssignmentwithmissingmandatoryfield
  Scenario: Check if user is able to add a record missing mandatory field
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for Assignment  with missing mandatory field ,additional fields
    Then User receives 400 bad request with message and boolean success details

  @createAssignment1
  Scenario: Check if user able to add a record with valid endpoint and request body(non existing values)
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for Assignment  with mandatory ,additional fields
    Then User receives 201 Created Status with response body

  @PutUpdateByAssignmentId
  Scenario: Check if user able to update a record with valid AssignmentID and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTP Request for Put with valid Assignment ID
    Then User receives status code 200 with response body for updating Assignment by ID

  @PutRequestMandatoryMissingfield
  Scenario: Check if user able to update a record with missing field
    Given User creates request for the LMS API endpoint
    When User sends HTTP Request for Put with valid Assignment ID with missing field
    Then User receives 400 bad request with message and boolean success details

  @CreateAssignmentwithExistingValues
  Scenario: Check if user able to add a record with valid endpoint and request body(existing value)
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for Assignment  with existing mandatory ,additional fields
    Then User receives 400 bad request with message and boolean success details

  @GetByAssignmentId
  Scenario: Check if user able to retrieve record with valid assignment ID
    Given User creates request for the LMS API endpoint
    When User sends HTTP Request with Assignment ID
    Then User receives 200 ok with response body

  @GetByBatchId
  Scenario: Check if user able to retrieve record with valid Batch ID
    Given User creates request for the LMS API endpoint
    When User sends HTTP Request with Batch ID
    Then User receives 200 ok with response body

  @DeleteAssignment
  Scenario: Check if user is able to delete arecord with valid assignment ID
    Given User creates request for the LMS API endpoint
    When User sends HTTPS delete Request for assignment
    Then User receives 200 ok with response body

  @DeleteAssignmentByInvalidId
  Scenario: Check if user is able to delete arecord with invalid assignment ID
    Given User creates request for the LMS API endpoint
    When User sends HTTPS delete Request for assignment
    Then User receives 404 not found with message and boolean success details

  @createAssignment2
  Scenario: Check if user able to add a record with valid endpoint and request body(non existing values)
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for Assignment2  with mandatory ,additional fields
    Then User receives 201 Created Status with response body

  @DeleteAssignment
  Scenario: Check if user is able to delete arecord with valid assignment ID
    Given User creates request for the LMS API endpoint
    When User sends HTTPS delete Request for assignment2
    Then User receives 200 ok with response body

  @DeleteUser
  Scenario: Delete User
    Given User creates request for the LMS API endpoint
    When User sends HTTPS delete Request for User
    Then Validate response code 200

  @DeleteBatch
  Scenario: Delete Batch
    Given User creates request for the LMS API endpoint
    When User sends HTTPS delete Request for Batch
    Then Validate response code 200

  @DeleteProgram
  Scenario: User able to delete a program with valid programName and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request to delete Program with valid program ID
    Then User receive 200 Status with response body for delete request

  @GetRequestByInvalidBatchId
  Scenario: Check if user able to retrieve record with invalid Batch ID
    Given User creates request for the LMS API endpoint
    When User sends HTTP Request with Batch ID
    Then User receives 404 not found with message and boolean success details

  @GetByInvalidAssignmentId
  Scenario: Check if user able to retrieve record with invalid assignment ID
    Given User creates request for the LMS API endpoint
    When User sends HTTP Request with Assignment ID
    Then User receives 404 not found with message and boolean success details

  @GetByBatchIdwithNoAssignment
  Scenario: Check if user able to retrieve record with valid Batch ID No Assignment
    Given User creates request for the LMS API endpoint
    When User sends HTTP Request with valid Batch ID no assignment
    Then User receives 404 not found with message and boolean success details

  @PutByInvalidAssignmentId
  Scenario: Check if user able to update a record with invalid AssignmentID and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTP Request for Put with valid Assignment ID
    Then User receives 404 not found with message and boolean success details
