package api.StepDefinition;


import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import api.request.BatchRequests;
import api.requestbody.BatchBody;
import api.utilities.RestUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class batchSD extends RestUtils{

	//CreateBatch200
	@When("User sends HTTPS post request for batch and request body with mandatory and additional fields")
	public void user_sends_HTTPS_post_request_for_batch_and_request_body_with_mandatory_and_additional_fields() throws IOException{			
		BatchPayload=BatchBody.PostBody();	
		response = BatchRequests.PostRequest(BatchPayload);			
		BatchPayload.setBatchId(response.path("batchId"));		
		System.out.println(BatchPayload.getBatchId());
		log.info("===========All required details for Batch id creation sent=====================  ");

	}

	@Then("User receives {int} created status for batch")
	public void user_receives_created_status_for_batch(Integer statusCode) {	

		if (statusCode == 201) {

			response.then().assertThat()
			.statusCode(statusCode)
			.body(matchesJsonSchema(postbatchJson))
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
		log.info("=========Batch Id created successfully200============  ");  
	}


	//Create Batch with existing BatchName in  request body400
	@When("User sends HTTPS Post Request with existing BatchName")
	public void user_sends_HTTPS_Post_Request_with_existing_BatchName() throws IOException {

		BatchPayload=BatchBody.ExistingPostBody();	
		response = BatchRequests.PostRequest(BatchPayload);					
		log.info("=========Create Batch with Existng BatchName400============  ");
	}


	@Then("User receives {int} Bad Request Status with message")
	public void user_receives_Bad_Request_Status_with_message(Integer statusCode) {

		if (statusCode == 400) {				

			response.then().assertThat()
			.statusCode(statusCode)
			.log().all();	

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("Request failed");
		}
		log.info("=========Create Batch with Existng BatchName gives 400 Bad Request============  ");
	}


	//Create Batch with Empty Mandatory Fields400 					
	@When("User sends HTTPS post request for batch and request body without mandatory and additional fields")
	public void user_sends_HTTPS_post_request_for_batch_and_request_body_without_mandatory_and_additional_fields() throws IOException{

		BatchPayload=BatchBody.PostBodyEmpty();	
		response = BatchRequests.PostRequest(BatchPayload);			
		//BatchPayload.setBatchId(response.path("batchId"));		
		//System.out.println(BatchPayload.getBatchId());
		log.info("======== Create Batch with Empty Mandatory Fields400 =========== ");  

	}

	@Then("User receives {int} Bad Request status for missing fields in batch module")
	public void user_receives_Bad_Request_status_for_missing_fields_in_batch_module(Integer int1) {			    

		if (int1 == 400) {				

			response.then().assertThat()
			.statusCode(int1)
			.log().all();	

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("==========Create Batch with Empty Mandatory Fields400 failed ========");
		}
		System.out.println("Status code for missing body ======"+response.getStatusCode());
	}


	//Getallbatch200
	@When("User creates GET Request for the LMS API endpoint")
	public void user_creates_GET_Request_for_the_LMS_API_endpoint() {
		response = BatchRequests.GetRequest();
	}

	@Then("User receives {int} status code with response body")
	public void user_receives_status_code_with_response_body(Integer int1) {
		response.then().assertThat().statusCode(200).log().all();
		log.info("============All batches details200=================");
	}


	//GetBatchByID200
	@When("User creates GET Request for the LMS API endpoint with valid Batch ID")
	public void user_creates_GET_Request_for_the_LMS_API_endpoint_with_valid_Batch_ID() {
		response =  BatchRequests.GetBatchByIDRequest();
	}

	@Then("User receives {int} OK Status with response body for batchID")
	public void user_receives_OK_Status_with_response_body_for_batchID(Integer statusCode) {


		if (statusCode == 200) {				

			response.then().assertThat().body(matchesJsonSchema(getbatchIDJson))
			.statusCode(statusCode)
			.log().all();	

			log.info("Deleted successfully with status code " + response.getStatusCode());
			log.info("Deleted successfully message " + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("Not Found: 404");
		}
		log.info("============GetBatchbyID200=================");

	}

	//GetBatchByName200
	@When("User creates GET Request for the LMS API endpoint with valid Batch Name")
	public void user_creates_GET_Request_for_the_LMS_API_endpoint_with_valid_Batch_Name() {

		response = BatchRequests.GetBatchByNameRequest();

	}

	@Then("User receives {int} OK Status with batch response body")
	public void user_receives_OK_Status_with_batch_response_body(Integer statusCode) {		

		//response.then().assertThat().body(matchesJsonSchema(getbatchbynameJson)).statusCode(200).log().all();
		if (statusCode == 200) {				

			response.then().assertThat().body(matchesJsonSchema(getbatchbynameJson))
			.statusCode(statusCode)
			.log().all();	

			log.info("Deleted successfully with status code " + response.getStatusCode());
			log.info("Deleted successfully message " + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("Not Found: 404");
		}
		log.info("============Getbybatchname200=================");

	}


	//GetBatchByProgramID200
	@When("User creates Get Request for getting Batch by Valid ProgramID")
	public void user_creates_Get_Request_for_getting_Batch_by_Valid_ProgramID() {
		response = BatchRequests.GetBatchByProgIDRequest();
	}

	@Then("User receives {int} OK Status with response body for batch by programID")
	public void user_receives_OK_Status_with_response_body_for_batch_by_programID(Integer statusCode) {
		//response.then().assertThat().statusCode(200).log().all();
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
		log.info("============GetBatchByProgramID200=================");
	}

	//UpdatebyBatchID200	
	@When("User sends HTTPS Update Request and request Body with mandatory & additional  fields")
	public void user_sends_HTTPS_Update_Request_and_request_Body_with_mandatory_additional_fields() throws IOException{		
		BatchPayload.setBatchName(BatchPayload.getBatchName()+"-UPDATEDBATCH");
		response= BatchRequests.UpdateBatchByIDRequest(BatchPayload);					
		System.out.println("====UpdatedBatchName=============");

	}

	@Then("User receives {int} OK Status with updated value in response body for batch")
	public void user_receives_OK_Status_with_updated_value_in_response_body_for_batch(Integer statusCode) {

		if (statusCode == 200) {				

			response.then().assertThat()
			.body(matchesJsonSchema(updatebatchIDJson))
			.statusCode(statusCode)
			.log().all();	

			log.info("Deleted successfully with status code " + response.getStatusCode());
			log.info("Deleted successfully message " + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("Not Found: 404");
		}
		log.info("============UpdatebyBatchID200=================");
	}	


	@Then("User receives {int} Ok status with message batchID deleted successfully")
	public void user_receives_Ok_status_with_message_batchID_deleted_successfully(Integer int1) {

		if (int1 == 200) {				

			response.then().assertThat()
			.statusCode(int1)
			.log().all();	

			log.info("Get request with Status code " + response.getStatusCode());
			log.info("Values " + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("Not Found: 404");
		}

		log.info("=======Batch Deleted 200========= ");

	}

	@Then("User receives {int} Ok status for program with message programID deleted successfully")
	public void user_receives_Ok_status_for_program_with_message_programID_deleted_successfully(Integer int1) {

		if (int1 == 200) {				

			response.then().assertThat()
			.statusCode(int1)
			.log().all();	

			log.info("Get request with Status code " + response.getStatusCode());
			log.info("Values " + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("400 bad Request");
		}
		log.info("=======Program Deleted 200========= ");
	}


	//GetBatchByInvalidProgramId404
	@When("User creates GET Request for the LMS API endpoint with invalid Program Id")
	public void user_creates_GET_Request_for_the_LMS_API_endpoint_with_invalid_Program_Id() throws IOException {
		BatchPayload = BatchBody.GetBatchbyInvalidProgID();
		response = BatchRequests.GetBatchByProgIDRequest();
	}

	@Then("User receives {int} Not Found Status with message and boolean success details for Invalid programID")
	public void user_receives_Not_Found_Status_with_message_and_boolean_success_details_for_Invalid_programID(Integer statusCode) {
		if (statusCode == 404) {				

			response.then().assertThat()
			.statusCode(statusCode)
			.log().all();	

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("==============GetBatchByInvalidProgramId404===================");
		}  
	}


	//GetBatchbyInvalidBatchId404
	@When("User creates GET Request for the LMS API endpoint with Invalid Batch ID")
	public void user_creates_GET_Request_for_the_LMS_API_endpoint_with_Invalid_Batch_ID() throws IOException {
		BatchPayload=BatchBody.PutBodyInvalidID();	 
		response =  BatchRequests.GetBatchByIDRequest();

	}


	@Then("User receives {int} Not Found Status with message and boolean success details for Invalid batchID")
	public void user_receives_Not_Found_Status_with_message_and_boolean_success_details_for_Invalid_batchID(Integer statusCode) {
		if (statusCode == 404) {				

			response.then().assertThat()
			.statusCode(statusCode)
			.log().all();	

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("============GetBatchbyInvalidBatchId-Failed=================");
		}  
	}


	//GetbyInvalidBatchName404
	@When("User creates GET Request for the LMS API endpoint with invalid Batch name")
	public void user_creates_GET_Request_for_the_LMS_API_endpoint_with_invalid_Batch_name() throws IOException {
		BatchPayload = BatchBody.GetBatchbyInvalidBatchName();
		response = BatchRequests.GetBatchByNameRequest();
	}

	@Then("User receives {int} Not Found Status with message and boolean success details for Invalid batchName")
	public void user_receives_Not_Found_Status_with_message_and_boolean_success_details_for_Invalid_batchName(Integer statusCode) {
		if (statusCode == 404) {				

			response.then().assertThat()
			.statusCode(statusCode)
			.log().all();	

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("=================GetbyInvalidBatchName404-Failed=================");
		}   
	}

	//UpdateBYInvalidBatchId400
	@When("User creates PUT Request for the LMS API endpoint  and  invalid batch ID")
	public void user_creates_PUT_Request_for_the_LMS_API_endpoint_and_invalid_batch_ID() throws IOException {
		BatchPayload = BatchBody.PutBodyInvalidID();
		response = BatchRequests.UpdateBatchByIDRequest(BatchPayload);
	}

	@Then("User receives {int} Not Found Status with message and boolean success details for UpdateByINvalidBatchID")
	public void user_receives_Not_Found_Status_with_message_and_boolean_success_details_for_UpdateByINvalidBatchID(Integer statusCode) {
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

}
