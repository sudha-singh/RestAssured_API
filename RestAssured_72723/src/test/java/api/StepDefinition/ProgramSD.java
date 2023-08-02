package api.StepDefinition;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;

import api.request.ProgramRequests;
import api.requestbody.ProgramBody;
import api.utilities.RestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.junit.Assert.assertEquals;

public class ProgramSD extends RestUtils{

	//baseURL
	@Given("User creates request for the LMS API endpoint")
	public void user_creates_request_for_the_LMS_API_endpoint() throws IOException {

		String BaseURI = routes.getString("BaseUrl");
		baseURI = BaseURI;

		log.info("***User sends request with BaseURL***");	
	}

	//User create a program with non-existing values saw
	@When("User sends HTTPS Request and  request Body for Program with mandatory ,additional fields")
	public void user_sends_HTTPS_Request_and_request_Body_for_Program_with_mandatory_additional_fields() throws IOException {


		ProgramPayload = ProgramBody.PostBody();
		response = ProgramRequests.PostRequest(ProgramPayload);
		ProgramPayload.setProgramId(response.path("programId"));

		log.info("****New program is created with non-existing fields****");

	}

	//User does Get request to retrieve all programs
	@When("User sends HTTPS Request for Program to get all programs")
	public void user_sends_HTTPS_Request_for_Program_to_get_all_programs() {

		response = ProgramRequests.GetAllProgramRequest();
		log.info("****Get all programs****");
	}

	//User update program with valid programID
	@When("User sends HTTPS Request with mandatory and additional fields for Program with valid program ID")
	public void user_sends_HTTPS_Request_with_mandatory_and_additional_fields_for_Program_with_valid_program_ID() throws IOException {


		ProgramPayload = ProgramBody.UpdateBodywithValidID();
		response = ProgramRequests.UpdateByProgramID(ProgramPayload);
		log.info("****Update program with Valid ProgramID****");
	}

	@Then("User receives {int} ok Status code with response body for update")
	public void user_receives_ok_Status_code_with_response_body_for_update(Integer statuscode) {

		if (statuscode == 200) {

			response.then().assertThat()
			.statusCode(statuscode)
			.body(matchesJsonSchema(programPutjson))
			.log().all();

			assertEquals(ProgramPayload.getProgramName(), response.jsonPath().getString("programName"));
			assertEquals(ProgramPayload.getProgramStatus(), response.jsonPath().getString("programStatus"));
			assertEquals(ProgramPayload.getProgramDescription(), response.jsonPath().getString("programDescription"));

			log.info("Program updated successfully with status code " + response.getStatusCode()) ;
			log.info("Program Respose body" +response.getBody().asString());


		} else {
			log.info("Request failed");
			log.error("400 bad Request");
		}
	}

	//User does Get request to retrieve program by program ID
	@When("User sends HTTPS Request for Program with valid program ID")
	public void user_sends_HTTPS_Request_for_Program_with_valid_program_ID() {


		response = ProgramRequests.GetByProgramID();
		log.info("****Get program with valid Program ID****");


	}


	//DeleteProgramwithvalidProgramID
	@When("User sends HTTPS Request to delete Program with valid program ID")
	public void user_sends_HTTPS_Request_to_delete_Program_with_valid_program_ID() {

		System.out.println("Program ID is "+ProgramPayload.getProgramId()); 

		response = ProgramRequests.DeletebyprogramName();
		log.info("****Delete program with valid Program ID****");

	}

	@Then("User receive {int} Status with response body for delete request")
	public void user_receive_Status_with_response_body_for_delete_request(Integer statuscode) {
		if (statuscode == 200) {				

			response.then().assertThat()
			.statusCode(statuscode)
			.log().all();	

			log.info("Deleted successfully with status code " + response.getStatusCode());
			log.info("Deleted successfully message " + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("Not Found: 404");
		}
	}


	//DeleteProgramwithinvalidProgramID
	@When("User sends HTTPS Request to delete Program with invalid program ID")
	public void user_sends_HTTPS_Request_to_delete_Program_with_invalid_program_ID() {

		System.out.println("ProgramID is "+ProgramPayload.getProgramId());
		response = ProgramRequests.DeleteByProgrambyID();
		log.info("****Delete program with Invalid Program ID****");

	}

	@Then("User get {int} Status with response body for delete request")
	public void user_get_Status_with_response_body_for_delete_request(Integer statuscode) {
		if (statuscode == 404) {				

			response.then().assertThat()
			.statusCode(statuscode)
			.log().all();	

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("Request failed");
		}
	}


	//User update program with valid programName
	@When("User sends HTTPS Request with mandatory and additional fields for Program with valid program name")
	public void user_sends_HTTPS_Request_with_mandatory_and_additional_fields_for_Program_with_valid_program_name() throws IOException {

		ProgramPayload = ProgramBody.UpdateBodywithValidProgramName();
		response = ProgramRequests.UpdateByProgramName(ProgramPayload);
		log.info("****Update program with valid Program Name****");
	}


	//User tries to create with existing values in Program name
	@When("User sends HTTPS Request and  request Body for Program with existing values in program name.")
	public void user_sends_HTTPS_Request_and_request_Body_for_Program_with_existing_values_in_program_name() throws IOException {

		ProgramPayload = ProgramBody.PostBodywithExistingFields();
		response = ProgramRequests.PostRequest(ProgramPayload);
		log.info("****Create program with existing values****");
	}

	@Then("User receives {int} Bad Request Status with message and boolean success details")
	public void user_receives_Bad_Request_Status_with_message_and_boolean_success_details(Integer statuscode) {

		if (statuscode == 400) {				

			response.then().assertThat()
			.statusCode(statuscode)
			.log().all();	

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("Request failed");
		}

	}

	//User create program with missing mandatory fields
	@When("User sends HTTPS Request and  request Body for program with missing mandatory fields.")
	public void user_sends_HTTPS_Request_and_request_Body_for_program_with_missing_mandatory_fields() throws IOException {

		ProgramPayload = ProgramBody.PostBodywithMissingFields();
		response = ProgramRequests.PostRequest(ProgramPayload);
		//ProgramPayload.setProgramId(response.path("programId"));
		log.info("****Create program with Missing Mandatory Fields****");

	}


	//User tries to update program by Valid ID with missing mandatory field
	@When("User sends HTTPS Request for Program with missing mandatory fields")
	public void user_sends_HTTPS_Request_for_Program_with_missing_mandatory_fields() throws IOException {

		ProgramPayload = ProgramBody.UpdateBodywithValidIDandMissingField();
		response = ProgramRequests.UpdateByProgramID(ProgramPayload);
		log.info("****Update program by Valid ID with Missing Mandatory Fields****");


	}

	//User tries to update program by program name with missing mandatory field
	@When("User sends HTTPS Request for Program with valid Program name and missing mandatory fields")
	public void user_sends_HTTPS_Request_for_Program_with_valid_Program_name_and_missing_mandatory_fields() throws IOException {

		ProgramPayload = ProgramBody.UpdateBodywithProgramNameandMissingField();
		response = ProgramRequests.UpdateByProgramName(ProgramPayload);
		log.info("****Update program by Valid ProgramName with Missing Mandatory Fields****");
	}


	//User tries to get program with invalid program ID
	@When("User sends HTTPS Request for Program with invalid program ID")
	public void user_sends_HTTPS_Request_for_Program_with_invalid_program_ID() {

		System.out.println("Program ID is "+ProgramPayload.getProgramId());
		response = ProgramRequests.GetByProgramID();
		log.info("****Get program with InValid Program ID****");

	}

	@Then("User receives {int} Status code with response body")
	public void user_receives_Status_code_with_response_body(Integer statuscode) {
		if (statuscode == 404) {				

			response.then().assertThat()
			.statusCode(statuscode)
			.log().all();	

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("Request failed");
		}
	}


	//Update program with invalid programID
	@When("User sends HTTPS Request with mandatory and additional fields for Program with invalid program ID")
	public void user_sends_HTTPS_Request_with_mandatory_and_additional_fields_for_Program_with_invalid_program_ID() throws IOException {

		System.out.println("Program ID is "+ProgramPayload.getProgramId());

		ProgramPayload = ProgramBody.UpdateBodywithInvalidID();
		response = ProgramRequests.UpdateByProgramID(ProgramPayload);
		log.info("****Update program with InValid ID****");
	}


	//Update program with invalid programName
	@When("User sends HTTPS Request with mandatory and additional fields for Program with invalid program Name")
	public void user_sends_HTTPS_Request_with_mandatory_and_additional_fields_for_Program_with_invalid_program_Name() throws IOException {
		System.out.println("Program ID is "+ProgramPayload.getProgramName()); 

		ProgramPayload = ProgramBody.UpdateBodywithInvalidProgramName();
		response = ProgramRequests.UpdateByProgramName(ProgramPayload);
		log.info("****Update program with InValid Program Name****");
	}

	//Delete Program with valid ProgramName
	@When("User sends HTTPS Request to delete Program with valid program name")
	public void user_sends_HTTPS_Request_to_delete_Program_with_valid_program_name() {

		ProgramRequests.DeletebyprogramName();
		log.info("****Delete program with Valid Program Name****");
	}


	//Delete Program with invalid ProgramName
	@When("User sends HTTPS Request to delete Program with invalid program name")
	public void user_sends_HTTPS_Request_to_delete_Program_with_invalid_program_name() {

		response = ProgramRequests.DeletebyprogramName();
		log.info("****Delete program with InValid Program Name****");
	}

}

