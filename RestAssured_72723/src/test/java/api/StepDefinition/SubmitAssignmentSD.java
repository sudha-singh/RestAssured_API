package api.StepDefinition;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import api.request.AssignmentRequest;
import api.request.AssignmentSubmitRequest;
import api.request.BatchRequests;
import api.request.ProgramRequests;
import api.request.UserRequests;
import api.requestbody.AssignmentBody;
import api.requestbody.AssignmentSubmitBody;
import api.requestbody.BatchBody;
import api.requestbody.UserBody;
import api.utilities.RestUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SubmitAssignmentSD extends RestUtils{


	//CreateNewBatch
	@When("User sends HTTPS Request and  request Body for Batch with mandatory ,additional fields")
	public void user_sends_HTTPS_Request_and_request_Body_for_Batch_with_mandatory_additional_fields() throws IOException {

		BatchPayload = BatchBody.PostBody();
		response = BatchRequests.PostRequest(BatchPayload);		
		BatchPayload.setBatchId(response.path("batchId"));
		log.info("******Create Batch******" );
	}


	//CreateNewAdminUser
	@When("User sends HTTPS Request and request Body for Admin User with mandatory ,additional fields")
	public void user_sends_HTTPS_Request_and_request_Body_for_Admin_User_with_mandatory_additional_fields() throws IOException {

		UserPayload = UserBody.PostAdminBody();
		response = UserRequests.PostRequest(UserPayload);
		AdminUser=response.path("userId");
		log.info("******Created Admin User******");
	}


	//CreateNewStudentUser
	@When("User sends HTTPS Request and request Body for Student User with mandatory ,additional fields")
	public void user_sends_HTTPS_Request_and_request_Body_for_Student_User_with_mandatory_additional_fields() throws IOException {

		UserPayload = UserBody.PostStudentBody();
		response = UserRequests.PostRequest(UserPayload);
		StudentUser=response.path("userId");
		log.info("******Created Student User******");
	}


	//Create New Assignment
	@When("User sends HTTPS Request and request Body for Assignment with mandatory ,additional fields")
	public void user_sends_HTTPS_Request_and_request_Body_for_Assignment_with_mandatory_additional_fields() throws IOException {

		AssignmentPayload = AssignmentBody.PostBody();
		response = AssignmentRequest.PostRequest(AssignmentPayload);
		AssignmentPayload.setAssignmentId(response.path("assignmentId"));
		System.out.println("my data ====================>" +AssignmentPayload.getAssignmentId());
		System.out.println("url====================> "+baseURI+routes.getString("Assignment_Post_URL"));
		log.info("******Created Assignment******");
	}


	//Create New Assignment Submit
	@When("User sends HTTPS Request and request Body for Assignment submit with mandatory ,additional fields")
	public void user_sends_HTTPS_Request_and_request_Body_for_Assignment_submit_with_mandatory_additional_fields() throws IOException {

		AssignmentSubmitPayload = AssignmentSubmitBody.PostBody();
		response = AssignmentSubmitRequest.PostRequest(AssignmentSubmitPayload);
		AssignmentSubmitPayload.setSubmissionId(response.path("submissionId"));

		log.info("******Student Submits assignment******");
	}


	//Duplicate Assignment Submit
	@When("User sends HTTPS Request and request Body for duplicate Assignment submit with mandatory ,additional fields")
	public void user_sends_HTTPS_Request_and_request_Body_for_duplicate_Assignment_submit_with_mandatory_additional_fields() throws IOException {

		AssignmentSubmitPayload = AssignmentSubmitBody.PostBody();
		response = AssignmentSubmitRequest.PostRequest(AssignmentSubmitPayload);

		log.info("******Duplcate assignment submit with same values******");
	}


	//Missing Mandatory fields assignment ID
	@When("User sends HTTPS Request and request Body for Assignment submit with missing Assignment ID")
	public void user_sends_HTTPS_Request_and_request_Body_for_Assignment_submit_with_missing_Assignment_ID() throws IOException {

		AssignmentSubmitPayload = AssignmentSubmitBody.PostBodyForMissingAssignmentID();
		response = AssignmentSubmitRequest.PostRequest(AssignmentSubmitPayload);

		log.info("*****Missing Mandatory field Assignmnet ID for Assignment submit*****");
	}


	//Missing Mandatory fields User ID
	@When("User sends HTTPS Request and request Body for Assignment submit with missing User ID")
	public void user_sends_HTTPS_Request_and_request_Body_for_Assignment_submit_with_missing_User_ID() throws IOException {

		AssignmentSubmitPayload = AssignmentSubmitBody.PostBodyForMissingUserID();
		response = AssignmentSubmitRequest.PostRequest(AssignmentSubmitPayload);

		log.info("*****Missing Mandatory field User ID for Assignment submit*****");
	}


	//Missing Mandatory fields sub Date Time
	@When("User sends HTTPS Request and request Body for Assignment submit with missing sub Date Time")
	public void user_sends_HTTPS_Request_and_request_Body_for_Assignment_submit_with_missing_sub_Date_Time() throws IOException {

		AssignmentSubmitPayload = AssignmentSubmitBody.PostBodyForMissingsubDateTime();
		response = AssignmentSubmitRequest.PostRequest(AssignmentSubmitPayload);
		AssignmentSubmitPayload.setSubmissionId(response.path("submissionId"));

		log.info("*****Missing Mandatory field sub Date Time for Assignment submit*****");
	}


	//Missing Mandatory fields Submission description
	@When("User sends HTTPS Request and request Body for Assignment submit with missing Submission description")
	public void user_sends_HTTPS_Request_and_request_Body_for_Assignment_submit_with_missing_Submission_description() throws IOException {

		AssignmentSubmitPayload = AssignmentSubmitBody.PostBodyForMissingSubDesc();
		response = AssignmentSubmitRequest.PostRequest(AssignmentSubmitPayload);
		AssignmentSubmitPayload.setSubmissionId(response.path("submissionId"));

		log.info("*****Missing Mandatory field Submission description for Assignment submit*****");
	}


	//Resubmit Assignment by submission ID By Student
	@When("User sends Put HTTPS Request and request Body for Assignment Submit with mandatory fields")
	public void User_sends_Put_HTTPS_Request_and_request_Body_for_Assignment_Submit_with_mandatory_fields() throws IOException {

		AssignmentSubmitPayload = AssignmentSubmitBody.ResubmitPutBody();
		response = AssignmentSubmitRequest.ResubmitAssignPutRequest(AssignmentSubmitPayload);

		log.info("******Resubmit Assignment by submission ID By Student******");
	}



	//Resubmit Assignment by invalid submission ID
	@When("User sends Put HTTPS Request and request Body for Assignment Submit with invalid submission ID")
	public void User_sends_Put_HTTPS_Request_and_request_Body_for_Assignment_Submit_with_invalid_submission_ID() throws IOException {

		AssignmentSubmitPayload = AssignmentSubmitBody.ResubmitPutBody();
		response = AssignmentSubmitRequest.ResubmitAssignPutRequest(AssignmentSubmitPayload);

		log.info("******Resubmit Assignment by Invalid submission ID By Student******");
	}


	//Resubmit Assignment by submission ID without mandatory fields
	@When("User sends Put HTTPS Request and request Body for Assignment Submit without mandatory fields")
	public void User_sends_Put_HTTPS_Request_and_request_Body_for_Assignment_Submit_without_mandatory_fields() throws IOException {

		AssignmentSubmitPayload = AssignmentSubmitBody.ResubmitWithoutManFieldsPutBody();
		response = AssignmentSubmitRequest.ResubmitAssignPutRequest(AssignmentSubmitPayload);

		log.info("******Resubmit Assignment by submission ID without mandatory fields******");
	}



	//Update Assignment Due Date By Admin
	@When("User sends put HTTPS Request and request Body for updating date in Assignment")
	public void User_sends_put_HTTPS_Request_and_request_Body_for_updating_date_in_Assignment() throws IOException {

		AssignmentPayload = AssignmentBody.PutBodyPostDueDate();
		response = AssignmentRequest.PutRequest(AssignmentPayload);
		log.info("******Update Assignment Due Date By Admin******");
	}



	//Update Grade Assignment by SubmissionID
	@When("User sends Put HTTPS Request and request Body to grade Assignment Submit")
	public void User_sends_Put_HTTPS_Request_and_request_Body_to_grade_Assignment_Submit() throws IOException {

		AssignmentSubmitPayload = AssignmentSubmitBody.GradePutBody();
		response = AssignmentSubmitRequest.GradePutRequest(AssignmentSubmitPayload);		

		log.info("******Update Grade Assignment by Submission ID******");
	}



	//Update Grade Assignment by Invalid SubmissionID
	@When("User sends Put HTTPS Request and request Body to grade Assignment Submit with invalid submition ID")
	public void User_sends_Put_HTTPS_Request_and_request_Body_to_grade_Assignment_Submit_with_invalid_submition_ID() throws IOException {

		AssignmentSubmitPayload = AssignmentSubmitBody.GradePutBody();
		response = AssignmentSubmitRequest.GradePutRequest(AssignmentSubmitPayload);		

		log.info("******Update Grade Assignment by Invalid Submission ID******");
	}


	//Update Grade Assignment by SubmissionID without mandatory fields
	@When("User sends Put HTTPS Request and request Body to grade Assignment Submit without mandatory fields")
	public void User_sends_Put_HTTPS_Request_and_request_Body_to_grade_Assignment_Submit_without_mandatory_fields() throws IOException {

		AssignmentSubmitPayload = AssignmentSubmitBody.GradePutBodyWithoutMandFields();
		response = AssignmentSubmitRequest.GradePutRequest(AssignmentSubmitPayload);		

		log.info("******Update Grade Assignment by SubmissionID without mandatory fields******" );
	}

	//Get ALL Assignment Submit
	@When("User creates GET Request for Assignment submit")
	public void User_creates_GET_Request_for_Assignment_submit() {

		AssignmentSubmitRequest.GetAllRequest();
		log.info("******Get ALL Assignment Submit******");
	}


	//Get Assignment Submit by userID
	@When("User sends Get HTTPS Request for Assignment submit by User ID")
	public void User_sends_Get_HTTPS_Request_for_Assignment_submit_by_User_ID() {

		AssignmentSubmitRequest.GetAssignmentByUserIDRequest();
		log.info("******Get Assignment Submit by User ID******");
	}


	//Get Assignment Submit by BatchID
	@When("User sends Get HTTPS Request for Assignment submit by Batch ID")
	public void User_sends_Get_HTTPS_Request_for_Assignment_submit_by_Batch_ID() {

		AssignmentSubmitRequest.GetAssignmentByBatchIDRequest();
		log.info("******Get Assignment Submit by Batch ID******");
	}

	//Get Assignment Submit by Invalid userID
	@When("User sends Get HTTPS Request for Assignment submit with invalid User ID")
	public void User_sends_Get_HTTPS_Request_for_Assignment_submit_with_invalid_User_ID() {

		AssignmentSubmitRequest.GetAssignmentByUserIDRequest();
		log.info("******Get Assignment Submit by Invalid User ID******");
	}

	//Get Assignment Submit by Invalid BatchID
	@When("User sends Get HTTPS Request for Assignment submit by invalid Batch ID")
	public void User_sends_Get_HTTPS_Request_for_Assignment_submit_by_invalid_Batch_ID() {

		AssignmentSubmitRequest.GetAssignmentByBatchIDRequest();
		log.info("******Get Assignment Submit by Invalid Batch ID******");
	}


	//Get grade by Assignment ID
	@When("User sends HTTPS Get Request for Assignment submit with assignment ID")
	public void User_sends_HTTPS_Get_Request_for_Assignment_submit_with_assignment_ID() {

		AssignmentSubmitRequest.GetGradeByAssignIDRequest();
		log.info("******Get grade by Assignment ID******");
	}


	//Get grade by Invalid Assignment ID
	@When("User sends HTTPS Get Request for Assignment submit with invalid assignment ID")
	public void User_sends_HTTPS_Get_Request_for_Assignment_submit_with_invalid_assignment_ID() {

		AssignmentSubmitRequest.GetGradeByAssignIDRequest();
		log.info("******Get grade by Invalid Assignment ID******");
	}


	//Get grade by Student ID
	@When("User sends HTTPS Get Request for Assignment submit with Student ID")
	public void User_sends_HTTPS_Get_Request_for_Assignment_submit_with_Student_ID() {

		AssignmentSubmitRequest.GetGradeByStudentIDRequest();
		log.info("******Get grade by Student ID******");
	}


	//Get grade by Invalid Student ID
	@When("User sends HTTPS Get Request for Assignment submit with invalid Student ID")
	public void User_sends_HTTPS_Get_Request_for_Assignment_submit_with_invalid_Student_ID() {

		AssignmentSubmitRequest.GetGradeByStudentIDRequest();
		log.info("******Get grade by Invalid Student ID******");
	}


	//Get grade by Batch ID
	@When("User sends HTTPS Get Request for Assignment submit with Batch ID")
	public void User_sends_HTTPS_Get_Request_for_Assignment_submit_with_batch_ID() {

		AssignmentSubmitRequest.GetGradeByBatchIDRequest();
		log.info("******Get grade by Batch ID******");
	}


	//Get grade by Invalid Batch ID
	@When("User sends HTTPS Get Request for Assignment submit with invalid Batch ID")
	public void User_sends_HTTPS_Get_Request_for_Assignment_submit_with_invalid_batch_ID() {

		AssignmentSubmitRequest.GetGradeByBatchIDRequest();
		log.info("******Get grade by Invalid Batch ID******");
	}


	//Delete Assignment Submit
	@When("User sends HTTPS delete Request for assignment submit")
	public void User_sends_HTTPS_delete_Request_for_assignment_submit() {

		AssignmentSubmitRequest.DeletRequest();
		log.info("******DELETE Request for Assignment Submit******");
	}


	//Delete Assignment
	@When("User sends HTTPS delete Request for assignment")
	public void User_sends_HTTPS_delete_Request_for_assignment() {

		AssignmentRequest.DeletRequest();
		log.info("******DELETE Request for Assignment******");
	}


	//Delete Student User
	@When("User sends HTTPS delete Request for student user")
	public void User_sends_HTTPS_delete_Request_for_student_user() {

		UserRequests.DeletStuUserRequest();
		log.info("******DELETE Request for Student User******");
	}

	//Delete Admin User
	@When("User sends HTTPS delete Request for admin user")
	public void User_sends_HTTPS_delete_Request_for_admin_user() {

		UserRequests.DeletAdminUserRequest();
		log.info("******DELETE Request for Admin User******");
	}

	//Delete Batch
	@When("User sends HTTPS delete Request for batch")
	public void User_sends_HTTPS_delete_Request_for_batch() {

		BatchRequests.DeletRequest();
		log.info("****DELETE Request for Batch****");
	}

	//Delete Program
	@When("User sends HTTPS delete Request for program")
	public void User_sends_HTTPS_delete_Request_for_program() {

		ProgramRequests.DeletebyprogramName();
		log.info("****DELETE Request for Program****");
	}


	//Validate delete message and Status Code 200
	@Then("Validate response code {int}")
	public void validate_response_code(Integer statusCode){		

		if (statusCode == 200) {				

			response.then().assertThat()
			.statusCode(statusCode)
			.log().all();	

			log.info("Deleted successfully with status code " + response.getStatusCode());
			log.info("Deleted successfully message " + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("Not Found: 404");
		}
	}


	//Validate Status Code 400  
	@Then("User receives {int} Status code")
	public void User_receives_Status_code(Integer statusCode){		

		if (statusCode == 400) {				

			response.then().assertThat()
			.statusCode(statusCode)
			.log().all();	

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("Request failed");
		}
	}


	//Validate Program created 201
	@Then("User receives {int} Created Status with response body for program")
	public void user_receives_Created_Status_with_response_body_for_program(Integer statusCode) {


		if (statusCode == 201) {

			response.then().assertThat()
			.statusCode(statusCode)
			.body(matchesJsonSchema(programPostjson))
			.log().all();

			assertEquals(ProgramPayload.getProgramName(), response.jsonPath().getString("programName"));
			assertEquals(ProgramPayload.getProgramStatus(), response.jsonPath().getString("programStatus"));
			assertEquals(ProgramPayload.getProgramDescription(), response.jsonPath().getString("programDescription"));

			log.info("Program created successfully with status code " + response.getStatusCode()) ;
			log.info("Program Respose body" +response.getBody().asString());


		} else {
			log.info("Request failed");
			log.error("400 bad Request");
		}
	}

	//Validate Assignment Submitted 201
	@Then("User receives {int} Created Status with response body for assignment submit")
	public void user_receives_Created_Status_with_response_body_for_assignment_submit(Integer statusCode) {


		if (statusCode == 201) {

			response.then().assertThat()
			.statusCode(statusCode)
			.body(matchesJsonSchema(AssignSubmitPostjson))
			.log().all();

			assertEquals(AssignmentSubmitPayload.getSubDesc(), response.jsonPath().getString("subDesc"));
			assertEquals(AssignmentSubmitPayload.getSubComments(), response.jsonPath().getString("subComments"));
			assertEquals(AssignmentSubmitPayload.getSubPathAttach1(), response.jsonPath().getString("subPathAttach1"));
			assertEquals(AssignmentSubmitPayload.getSubPathAttach2(), response.jsonPath().getString("subPathAttach2"));
			assertEquals(AssignmentSubmitPayload.getSubPathAttach3(), response.jsonPath().getString("subPathAttach3"));
			assertEquals(AssignmentSubmitPayload.getSubPathAttach4(), response.jsonPath().getString("subPathAttach4"));
			assertEquals(AssignmentSubmitPayload.getSubPathAttach5(), response.jsonPath().getString("subPathAttach5"));

			log.info("Program created successfully with status code " + response.getStatusCode()) ;
			log.info("Program Respose body" +response.getBody().asString());


		} else {
			log.info("Request failed");
			log.error("400 bad Request");
		}
	}

	//validate batch created 201
	@Then("User receives {int} Created Status with response body for batch")
	public void user_receives_Created_Status_with_response_body_for_batch(Integer statusCode) {


		if (statusCode == 201) {

			response.then().assertThat()
			.statusCode(statusCode)
			//.body(matchesJsonSchema(batchjson))
			.log().all();

			assertEquals(BatchPayload.getBatchDescription(), response.jsonPath().getString("batchDescription"));
			assertEquals(BatchPayload.getBatchName(), response.jsonPath().getString("batchName"));
			assertEquals(BatchPayload.getBatchNoOfClasses(), response.jsonPath().getString("batchNoOfClasses"));
			assertEquals(BatchPayload.getBatchStatus(), response.jsonPath().getString("batchStatus"));
			assertEquals(ProgramPayload.getProgramName(), response.jsonPath().getString("programName"));

			log.info("Batch created successfully with status code " + response.getStatusCode()) ;
			log.info("Batch Respose body" +response.getBody().asString());		

		} else {
			log.info("Request failed");
			log.error("400 bad Request");
		}
	}


	//validate status code 404
	@Then("User receives {int} Not Found Status with message")
	public void User_receives_Not_Found_Status_with_message(Integer statusCode) {

		if (statusCode == 404) {				

			response.then().assertThat()
			.statusCode(statusCode)
			.log().all();	

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("Request failed");
		}
	}


	//Validate status code 200 for get 
	@Then("User receives {int} OK Status with response body")
	public void User_receives_OK_Status_with_response_body(Integer statusCode) {

		if (statusCode == 200) {				

			response.then().assertThat()
			.statusCode(statusCode)
			.log().all();	

			log.info("Get request with Status code " + response.getStatusCode());
			log.info("Values " + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("Not Found: 404");
		}
	}

	//Validate status code 200 for getting assignment submit by grade assgn ID
	@Then("User receives {int} OK Status with response body for getting assignment submit by grade assgn ID")
	public void User_receives_OK_Status_with_response_body_for_getting_assignment_submit_by_grade_assgn_ID(Integer statusCode) {

		if (statusCode == 200) {				

			response.then().assertThat()
			.statusCode(statusCode)
			.body(matchesJsonSchema(AssignSubmitgradeIDjson))
			.log().all();	

			log.info("Get request with Status code " + response.getStatusCode());
			log.info("Values " + response.getBody().asString());

		} else {

			log.info("Request failed with status code"+ response.getStatusCode());
		}
	}


	//Validate status code 200 for getting assignment submit by user ID 
	@Then("User receives {int} OK Status with response body for getting assignment submit by user ID")
	public void User_receives_OK_Status_with_response_body_for_getting_assignment_submit_by_user_ID(Integer statusCode) {

		if (statusCode == 200) {				

			response.then().assertThat()
			.statusCode(statusCode)
			.body(matchesJsonSchema(AssignSubmitUserIDjson))
			.log().all();	

			log.info("Get request with Status code " + response.getStatusCode());
			log.info("Values " + response.getBody().asString());

		} else {
			log.info("Request failed with status code"+ response.getStatusCode());
		}
	}


	//validate created 201
	@Then("User receives {int} Created Status with response body")
	public void user_receives_Created_Status_with_response_body(Integer statusCode) {

		if (statusCode == 201) {

			response.then().assertThat()
			.statusCode(statusCode)
			.log().all();

			log.info("Assignment created successfully with status code " + response.getStatusCode()) ;
			log.info("Respose body" +response.getBody().asString());


		} else {
			log.info("Request failed");
			log.error("400 bad Request");
		}
	}

}
