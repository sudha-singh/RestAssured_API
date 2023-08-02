package api.StepDefinition;

import static io.restassured.RestAssured.when;

import java.io.IOException;

import api.request.AssignmentRequest;
import api.request.BatchRequests;
import api.request.ProgramRequests;
import api.request.UserRequests;
import api.requestbody.AssignmentBody;
import api.requestbody.BatchBody;
import api.requestbody.UserBody;
import api.utilities.RestUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AssignmentStepDef extends RestUtils {
	static String programName;
	static Integer programID;
	static Integer batchID;
	static String batchNm;
	static String batchDescrtn;
	static Integer batchNoClass;
	static String userId;
	static int assignmentId1;
	static int assignmentId;
	static String assignmentNm;	


	//Get All Assignments
	@When("User sends HTTP request")
	public void user_sends_http_request() {
		String URI = routes.getString("Assignment_GetAllAssignments_URL");
		//String path =  baseURI+URI;
		response = when().
				get(URI);

		log.info("Get All Assignments");

	}

	@Then("User receives {int} ok with response body")
	public void User_receives_OK_with_response_body(Integer statusCode) {

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


	@Then("Validate response code {int} OK")
	public void validate_response_code_ok(Integer statuscode) {
		response.then().assertThat().statusCode(statuscode).log().all();
		log.info("User get response:  " + statuscode);

	}

	// Create Batch
	@When("User sends HTTPS Request and  request Body for Batch  with mandatory ,additional fields")
	public void user_sends_https_request_and_request_body_for_batch_with_mandatory_additional_fields() throws IOException {

		BatchPayload = BatchBody.PostBody();
		response = BatchRequests.PostRequest(BatchPayload);		
		BatchPayload.setBatchId(response.path("batchId"));
		log.info("All required details send for batch  " );
	}
	//Create User
	@When("User sends HTTPS Request and  request Body for User  with mandatory ,additional fields")
	public void user_sends_https_request_and_request_body_for_user_with_mandatory_additional_fields() throws IOException {

		UserPayload = UserBody.PostAdminBody();
		response = UserRequests.PostRequest(UserPayload);
		AdminUser=response.path("userId");
		log.info("All required details send  ");
	}

	//Create Assignment1
	@When("User sends HTTPS Request and  request Body for Assignment  with mandatory ,additional fields")
	public void user_sends_https_request_and_request_body_for_assignment_with_mandatory_additional_fields() throws Exception {


		AssignmentPayload = AssignmentBody.PostBody();
		response = AssignmentRequest.PostRequest(AssignmentPayload);
		AssignmentPayload.setAssignmentId(response.path("assignmentId"));


		log.info("***************Created Assignment**********  ");

	}
	//create assignment2
	@When("User sends HTTPS Request and  request Body for Assignment2  with mandatory ,additional fields")
	public void user_sends_https_request_and_request_body_for_assignment2_with_mandatory_additional_fields() throws Exception {


		AssignmentPayload = AssignmentBody.PostBodyAss2();

		response = AssignmentRequest.PostRequest(AssignmentPayload);
		AssignmentPayload.setAssignmentId(response.path("assignmentId"));
		System.out.println("Assignment id"+AssignmentPayload.getAssignmentId());


		log.info("***************Created Assignment**********  ");

	}


	//Create Assignment for existing value
	@When("User sends HTTPS Request and  request Body for Assignment  with existing mandatory ,additional fields")
	public void user_sends_https_request_and_request_body_for_assignment_with_existing_mandatory_additional_fields() throws IOException{

		AssignmentPayload = AssignmentBody.PostBodyExistingValues();
		response = AssignmentRequest.PostRequest(AssignmentPayload);
		System.out.println("AssignmentId"+AssignmentPayload.getAssignmentId());

		log.info("All required details send  ");

	}

	//Create Assignment with missing mandatory Field
	@When("User sends HTTPS Request and  request Body for Assignment  with missing mandatory field ,additional fields")
	public void user_sends_https_request_and_request_body_for_assignment_with_missing_mandatory_field_additional_fields() throws IOException{

		AssignmentPayload = AssignmentBody.missingFieldPostBody();
		response = AssignmentRequest.PostRequest(AssignmentPayload);
		log.info("Missing mandatory field");
	}

	@Then("User receives {int} bad request with message and boolean success details")
	public void user_receives_bad_request_with_message_and_boolean_success_details(Integer statusCode) {
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

	//Get By  Assignment Id
	@When("User sends HTTP Request with Assignment ID")
	public void user_sends_http_request_with_assignment_id() {
		//System.out.println(AssignmentPayload.getAssignmentId());

		AssignmentRequest.GetRequest();
		log.info("Get By AssignmentId");

	}
	// Get Assignment for Batch
	@When("User sends HTTP Request with Batch ID")
	public void user_sends_http_request_with_batch_id() {

		AssignmentRequest.GetRequestBatch();
		log.info("Get Assignment By BatchId");

	}
	//Put -Update Assignment
	@When("User sends HTTP Request for Put with valid Assignment ID")
	public void user_sends_http_request_for_put_with_valid_assignment_id() throws IOException {



		AssignmentPayload= AssignmentBody.PutBody();
		response = AssignmentRequest.PutRequest(AssignmentPayload);
		log.info("UPDATE  successful: 200");
	}

	@Then("User receives status code {int} with response body for updating Assignment by ID")
	public void user_receives_status_code_with_response_body_for_updating_Assignment_by_id(Integer int1) {

		response.then().log().all();
		System.out.println("Assignment updateRequest : " + response);
		log.info(" Assignment information is updated");
	}


	//Put -Update Assignment with missing field
	@When("User sends HTTP Request for Put with valid Assignment ID with missing field")
	public void user_sends_http_request_for_put_with_valid_assignment_id_with_missing_field() throws IOException {



		AssignmentPayload= AssignmentBody.PutBodyMissingField();
		response = AssignmentRequest.PutRequest(AssignmentPayload);
		log.info("UPDATE  successful: 200");
	}


	//Delete Assignment2
	@When("User sends HTTPS delete Request for assignment2")
	public void user_sends_https_delete_request_for_assignment2() {

		AssignmentRequest.DeletRequest();
		log.info("DELETE Request successful: 200");

	}

	//Delete User
	@When("User sends HTTPS delete Request for User")
	public void user_sends_https_delete_request_for_user() {
		UserRequests.DeletAdminUserRequest();
		log.info("DELETE Request successful: 200");
	}
	//Delete Batch
	@When("User sends HTTPS delete Request for Batch")
	public void user_sends_https_delete_request_for_batch() {
		BatchRequests.DeletRequest();
		log.info("DELETE Request successful: 200");
	}
	//Delete Program
	@When("User sends HTTPS delete Request for Program")
	public void user_sends_https_delete_request_for_program() {
		ProgramRequests.DeleteByProgrambyID();
		log.info("DELETE Request successful: 200");

	}
	@Then("User receives {int} not found with message and boolean success details")
	public void user_receives_not_found_with_message_and_boolean_success_details(Integer statusCode) {
		response.then().assertThat().statusCode(statusCode).log().all();
		log.info("User get response" + statusCode);
	}

	//Get By BatchID No Assignment
	@When("User sends HTTP Request with valid Batch ID no assignment")
	public void user_sends_http_request_with_valid_batch_id_no_assignment() {

		AssignmentRequest.GetRequestBatch1();

		log.info("Get By BatchId with No Assignment");
	}


}
