Feature: User Module

  @GETRequest_AllUsers
  Scenario: Check if user able to retrieve all user with valid LMS API
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request GetAllUser
    Then User receives status code 200 with response body for viewing all Users

  @GETRequest_Userby_Role
  Scenario: Check if user able to retrieve all user by role with valid LMS API
    Given User creates request for the LMS API endpoint
    When User sends HTTPS GET Request to view user by Roles
    Then User receives status code 200 with response body for viewing an User by Role

  @GETRequest_GetAllStaff
  Scenario: Check if user able to retrieve a all Staff with valid LMS API
    Given User creates request for the LMS API endpoint
    When User sends HTTPS GET Request to view all Staff
    Then User receives status code 200 with response body to view all Staff

  @POSTRequest_UserWith_MissingMandatoryFields
  Scenario: Check if user able to create a User with valid endpoint and MissingMandatoryFields (non existing values)
    Given User creates request for the LMS API endpoint
    When User sends HTTPS POST Request for new User with Missing Mandatory Fields
    Then User receives status code 400 with response body for User with Missing Mandatory Fields

  @POSTRequest_UserWith_AdminRole
  Scenario: Check if user able to create a Admin User with valid endpoint and request body (non existing values)
    Given User creates request for the LMS API endpoint
    When User sends HTTPS POST Request for new User for Admin role
    Then User receives status code 201 with response body for creating an User for Admin role

  @POSTRequest_UserWith_StaffRole
  Scenario: Check if user able to create a Staff User with valid endpoint and request body (non existing values)
    Given User creates request for the LMS API endpoint
    When User sends HTTPS POST Request for new User for Staff role
    Then User receives status code 201 with response body for creating an User for Staff role

  @POSTRequest_UserWith_StudentRole
  Scenario: Check if user able to create a Student User with valid endpoint and request body (non existing values)
    Given User creates request for the LMS API endpoint
    When User sends HTTPS POST Request for new User for Student role
    Then User receives status code 201 with response body for creating an User for Student role

  @GETRequest_Userby_UserID
  Scenario: Check if user able to retrieve a user with valid User ID
    Given User creates request for the LMS API endpoint
    When User sends HTTPS GET Request to view user by userID
    Then User receives status code 200 with response body for viewing an User by ID

  @PUTRequest_UpdateUserByMissingFields
  Scenario: Check if user able to update a user with missingFields and valid User ID
    Given User creates request for the LMS API endpoint
    When User sends HTTPS PUT Request to update User by UserId with missingFields
    Then User receives status code 400 with response body for updating User with missingFields

  @PUTRequest_UpdateUserById
  Scenario: Check if user able to update a user with valid User ID and request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS PUT Request to update User by UserId
    Then User receives status code 200 with response body for updating User by ID

  @PUTRequest_UpdateUserRoleStatusById_MissingFields
  Scenario: Check if user able to update a user role status with valid User Id and request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS PUT Request to update User role status by User ID for missing fields
    Then User receives status code 400 with response body for updating UserRoleStaus

  @PUTRequest_UpdateUserRoleStatusById
  Scenario: Check if user able to update a user role status with valid User Id and request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS PUT Request to update User role status by User ID
    Then User receives status code 200 with response body for updating UserRoleStaus

  @POSTRequest_UserWith_ExistingPhoneNumber
  Scenario: Check if user able to create a User with valid endpoint and ExistingPhoneNumber(non existing values)
    Given User creates request for the LMS API endpoint
    When User sends HTTPS POST Request for new User with Existing PhoneNumber
    Then User receives status code 400 with response body for User with ExistingPhoneNumber

  @DeleteRequest_DeleteStudentUser_ByID
  Scenario: Check if user able to delete a Student user with valid User Id
    Given User creates request for the LMS API endpoint
    When User sends HTTPS DELETE Request to delete a Student user
    Then User receives status code 200 with response body to delete User by ID

  @DeleteRequest_DeleteStaffUser_ByID
  Scenario: Check if user able to delete a Staff user with valid User Id
    Given User creates request for the LMS API endpoint
    When User sends HTTPS DELETE Request to delete a Staff user
    Then User receives status code 200 with response body to delete User by ID

  @DeleteRequest_DeleteAdminUser_ByID
  Scenario: Check if user able to delete a Admin user with valid User Id
    Given User creates request for the LMS API endpoint
    When User sends HTTPS DELETE Request to delete a user
    Then User receives status code 200 with response body to delete User by ID

  @GETRequest_Userby_InvalidUserID
  Scenario: Check if user is not able to retrieve user info with Invalid User ID
    Given User creates request for the LMS API endpoint
    When User sends HTTPS GET Request to view user by invalid userID
    Then User receives status code 404 Bad Request with response body with Invalid UserID

  @PUTRequest_UpdateUserByInvalidId
  Scenario: Check if user able to update a user with Invalid User ID and request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS PUT Request to update User by Invalid userId
    Then User receives status code 404 with response body for updating User by InvalidID

  @PUTRequest_UpdateUserRoleStatusById_invalidid
  Scenario: Check if user able to update a user role status with valid User Id and request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS PUT Request to update User role status by User ID for missing fields
    Then User receives status code 400 with response body for updating UserRoleStaus

  @DeleteRequest_DeleteUser_ByInvalidID
  Scenario: Check if user able to delete a user with Invalid User Id
    Given User creates request for the LMS API endpoint
    When User sends HTTPS DELETE Request to delete a user with Invalid User Id
    Then User receives status code 404 with response body to delete User by Invalid User Id

  @PostProgram
  Scenario: User creates request for the LMS API endpoint
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for Program with mandatory ,additional fields
    Then User receives 201 Created Status with response body for program

  @PostBatch
  Scenario: Check if user able to create a Batch with valid endpoint and request body (non existing values)
    Given User creates request for the LMS API endpoint
    When User sends HTTPS POST Request to create new Batch
    Then User receives status code 201 with response body for creating a Batch

  @POSTRequest_UserWith_AdminRole
  Scenario: Check if user able to create a Admin User with valid endpoint and request body (non existing values)
    Given User creates request for the LMS API endpoint
    When User sends HTTPS POST Request for new User for Admin role
    Then User receives status code 201 with response body for creating an User for Admin role

  @PUTRequest_UpdateUserRoleStatusByDiffRoleID
  Scenario: Check if user able to update a user role status with diff role ID and with valid User Id and request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS PUT Request to update User role status by different Role ID
    Then User receives status code 400 with response body for updating UserRoleStaus

  @PUTRequest_AssignUserToProgBatchByMissingfield
  Scenario: Check if user able to assign a user with program and batch with invalid UserId
    Given User creates request for the LMS API endpoint
    When User sends HTTPS PUT Request to assign User to given program and Batch for invalid UserId
    Then User receives status code 400 with response body for assigning Program and Batch with invalid User

  @PUTRequest_AssignUserToProgBatchById
  Scenario: Check if user able to update a user with program and batch and  valid User Id and request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS PUT Request to assign User to given program and Batch
    Then User receives status code 200 with response body for assigning Program and Batch to User

  @PUTRequest_AssignUserToProgBatchByInvalidID
  Scenario: Check if user able to update a user with with program and batch invalid User Id and request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS PUT Request to assign User to given program and Batch by InvalidID
    Then User receives status code 200 with response body for assigning Program and Batch to User

  @DeleteRequest_DeleteAdminUser_ByID
  Scenario: Check if user able to delete a admin user with valid User Id
    Given User creates request for the LMS API endpoint
    When User sends HTTPS DELETE Request to delete a user
    Then User receives status code 200 with response body to delete User by ID

  @DeleteRequest_DeleteBatch_ByID
  Scenario: Check if user able to delete a batch with valid Batch Id
    Given User creates request for the LMS API endpoint
    When User sends HTTPS DELETE Request to delete a Batch
    Then User receives status code 200 with response body to delete Batch by ID

  @DeleteRequest_DeleteProgram_ByID
  Scenario: Check if user able to delete a program with valid Program Id

  Scenario: User able to delete a program with valid programName and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request to delete Program with valid program ID
    Then User receive 200 Status with response body for delete request
