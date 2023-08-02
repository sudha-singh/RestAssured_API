Feature: Assignmdent Submit Scenario

  @Create_Program
  Scenario: User creates request for the LMS API endpoint
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for Program with mandatory ,additional fields
    Then User receives 201 Created Status with response body for program

  @Create_Batch
  Scenario: Cretae Batch
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and  request Body for Batch with mandatory ,additional fields
    Then User receives 201 Created Status with response body for batch

  @Create_Admin_User
  Scenario: Cretae Admin User
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and request Body for Admin User with mandatory ,additional fields
    Then User receives 201 Created Status with response body

  @Create_Student_User
  Scenario: Cretae Student User
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and request Body for Student User with mandatory ,additional fields
    Then User receives 201 Created Status with response body

  @Create_Assignment_By_Admin
  Scenario: Cretae Assignment
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and request Body for Assignment with mandatory ,additional fields
    Then User receives 201 Created Status with response body

  @Missing_Mandatory_Field_Assignment_ID
  Scenario: Check if user able to create a submission missing mandatory field AssignmentID in request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and request Body for Assignment submit with missing Assignment ID
    Then User receives 400 Status code

  @Missing_Mandatory_Field_User_ID
  Scenario: Check if user able to create a submission missing mandatory field UserID in request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and request Body for Assignment submit with missing User ID
    Then User receives 400 Status code

  @Missing_Mandatory_Field_Sub_Date_Time
  Scenario: Check if user able to create a submission missing mandatory field SubDateTime in request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and request Body for Assignment submit with missing sub Date Time
    Then User receives 400 Status code

  @Delete_Test1_Assignment_Submit
  Scenario: Delete Assignment Submit
    Given User creates request for the LMS API endpoint
    When User sends HTTPS delete Request for assignment submit
    Then Validate response code 200

  @Missing_Mandatory_Fields_Submission_description
  Scenario: Check if user able to create a submission missing mandatory field Submissiondescription in request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and request Body for Assignment submit with missing Submission description
    Then User receives 400 Status code

  @Delete_Test2_Assignment_Submit
  Scenario: Delete Assignment Submit
    Given User creates request for the LMS API endpoint
    When User sends HTTPS delete Request for assignment submit
    Then Validate response code 200

  @Create_Assignment_Submit_By_Student
  Scenario: Check if user able to  create a submission  with valid endpoint and request body (non existing values)
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and request Body for Assignment submit with mandatory ,additional fields
    Then User receives 201 Created Status with response body for assignment submit

  @Duplicate_Assignment_Submit
  Scenario: Check if user able to create a submission with valid endpoint and request body (existing value)
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request and request Body for duplicate Assignment submit with mandatory ,additional fields
    Then User receives 400 Status code

  @Get_All_Assignment_Submit
  Scenario: Check if user able to retrieve all submission with valid LMS API endpoint
    Given User creates request for the LMS API endpoint
    When User creates GET Request for Assignment submit
    Then User receives 200 OK Status with response body

  @Get_Assignment_Submission_By_Used_ID
  Scenario: Check if user able to retrieve a submission with valid User ID
    Given User creates request for the LMS API endpoint
    When User sends Get HTTPS Request for Assignment submit by User ID
    Then User receives 200 OK Status with response body for getting assignment submit by user ID

  @Get_Assignment_Submission_By_Batch_ID
  Scenario: Check if user able to retrieve a submission with valid Batch ID
    Given User creates request for the LMS API endpoint
    When User sends Get HTTPS Request for Assignment submit by Batch ID
    Then User receives 200 OK Status with response body

  @Resubmit_Assignment_by_submission_ID_By_Student
  Scenario: Check if user able to update a submission with valid  submission ID and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends Put HTTPS Request and request Body for Assignment Submit with mandatory fields
    Then User receives 200 OK Status with response body

  @Resubmit_Assignment_by_submission_ID_Without_Mandatory_Fields
  Scenario: Check if user able to update a submission with valid  submission ID and missing mandatory fields
    Given User creates request for the LMS API endpoint
    When User sends Put HTTPS Request and request Body for Assignment Submit without mandatory fields
    Then User receives 400 Not Found Status with message

  @Update_Assignment_Due_Date_By_Admin
  Scenario: User update assignment due date
    Given User creates request for the LMS API endpoint
    When User sends put HTTPS Request and request Body for updating date in Assignment
    Then User receives 200 OK Status with response body

  @Update_Grade_Assignment_by_Submission_ID_Without_Mandatory_Fields
  Scenario: Check if user able to  grade assignment with valid submission Id and without mandatory fields
    Given User creates request for the LMS API endpoint
    When User sends Put HTTPS Request and request Body to grade Assignment Submit without mandatory fields
    Then User receives 400 Not Found Status with message

  @Update_Grade_Assignment_by_Submission_ID
  Scenario: Check if user able to  grade assignment with valid submission  Id and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends Put HTTPS Request and request Body to grade Assignment Submit
    Then User receives 200 OK Status with response body

  @Get_Grade_By_Assign_ID
  Scenario: Check if user able to retrieve a grades with valid Assignment ID
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Get Request for Assignment submit with assignment ID
    Then User receives 200 OK Status with response body

  @Get_Grade_By_Student_ID
  Scenario: Check if user able to retrieve a grades with valid Student ID
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Get Request for Assignment submit with Student ID
    Then User receives 200 OK Status with response body

  @Get_Grade_By_Batch_ID
  Scenario: Check if user able to retrieve a grades with valid Assignment ID
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Get Request for Assignment submit with Batch ID
    Then User receives 200 OK Status with response body for getting assignment submit by grade assgn ID

  @Delete_Assignment_Submit
  Scenario: Check if user able to delete a submission with valid submission Id
    Given User creates request for the LMS API endpoint
    When User sends HTTPS delete Request for assignment submit
    Then Validate response code 200

  @Delete_With_Invalid_Submission_ID
  Scenario: Check if user able to delete a submission with invalid submission Id
    Given User creates request for the LMS API endpoint
    When User sends HTTPS delete Request for assignment submit
    Then User receives 404 Not Found Status with message

  @Delete_Assignment
  Scenario: Delete Assignment
    Given User creates request for the LMS API endpoint
    When User sends HTTPS delete Request for assignment
    Then Validate response code 200

  @Delete_Student_User
  Scenario: Delete User
    Given User creates request for the LMS API endpoint
    When User sends HTTPS delete Request for student user
    Then Validate response code 200

  @Delete_Admin_User
  Scenario: Delete User
    Given User creates request for the LMS API endpoint
    When User sends HTTPS delete Request for admin user
    Then Validate response code 200

  @Delete_Batch_By_ID
  Scenario: Delete Batch ById
    Given User creates request for the LMS API endpoint
    When User sends HTTPS delete Request for batch
    Then Validate response code 200

  @Delete_Program_By_ID
  Scenario: User able to delete a program with valid programName and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Request to delete Program with valid program ID
    Then User receive 200 Status with response body for delete request

  @Resubmit_Assignment_by_Invalid_Submission_ID
  Scenario: Check if user able to update a submission with Invalid  submission ID and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends Put HTTPS Request and request Body for Assignment Submit with invalid submission ID
    Then User receives 404 Not Found Status with message

  @Update_Grade_Assignment_by_Invalid_Submission_ID
  Scenario: Check if user able to  grade assignment with Invalid submission Id and mandatory request body
    Given User creates request for the LMS API endpoint
    When User sends Put HTTPS Request and request Body to grade Assignment Submit with invalid submition ID
    Then User receives 404 Not Found Status with message

  @Get_Assignment_By_Invalid_Batch_ID
  Scenario: Check if user able to retrieve a submission with invalid Batch ID
    Given User creates request for the LMS API endpoint
    When User sends Get HTTPS Request for Assignment submit by invalid Batch ID
    Then User receives 404 Not Found Status with message

  @Get_Assignment_By_Invalid_Used_ID
  Scenario: Check if user able to retrieve a submission with invalid User ID
    Given User creates request for the LMS API endpoint
    When User sends Get HTTPS Request for Assignment submit with invalid User ID
    Then User receives 404 Not Found Status with message

  @Get_Grade_By_Invalid_Assign_ID
  Scenario: Check if user able to retrieve a grades with Invalid Assignment ID
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Get Request for Assignment submit with invalid assignment ID
    Then User receives 404 Not Found Status with message

  @Get_Grade_By_Invalid_Student_ID
  Scenario: Check if user able to retrieve a grades with Invalid Assignment ID
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Get Request for Assignment submit with invalid Student ID
    Then User receives 404 Not Found Status with message

  @Get_Grade_By_Invalid_Batch_ID
  Scenario: Check if user able to retrieve a grades with Invalid Assignment ID
    Given User creates request for the LMS API endpoint
    When User sends HTTPS Get Request for Assignment submit with invalid Batch ID
    Then User receives 404 Not Found Status with message
