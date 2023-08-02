package api.StepDefinition;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import api.request.BatchRequests;
import api.request.ProgramRequests;
import api.request.UserRequests;
import api.requestbody.BatchBody;
import api.requestbody.UserBody;
import api.utilities.RestUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserSD extends RestUtils {


	@When("User sends HTTPS Request GetAllUser")
	public void user_sends_https_request_get_all_user() {

		response = UserRequests.GetAllUserRequest();
		System.out.println("View All User : " + response);
		log.info(" View all Users");

	}

	@Then("User receives status code {int} with response body for viewing all Users")
	public void user_receives_status_code_with_response_body_for_viewing_all_users(Integer statusCode) {

		response.then().log().all();
		System.out.println("View all Users  : " + response);
		log.info(" User Info for all user  will be displayed ");

		if (statusCode == 200) {

			response.then().assertThat().statusCode(statusCode).log().all();

			log.info("Get request with Status code " + response.getStatusCode());
			log.info("Values " + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("Not Found: 404");
		}
	}

	@When("User sends HTTPS GET Request to view user by Roles")
	public void user_sends_https_get_request_to_view_user_by_roles() {

		response = UserRequests.GetUserByRoleRequest();
		System.out.println("View User by Roles : " + response);
		// UserPayload.setUserId(response.path("userId"));
		log.info(" View User by Roles");

	}

	@Then("User receives status code {int} with response body for viewing an User by Role")
	public void user_receives_status_code_with_response_body_for_viewing_an_user_by_role(Integer statusCode) {

		response.then().log().all();
		System.out.println("View all Users by Roles : " + response);
		log.info(" User Info with user roles will be displayed ");

		response.then().log().all();
		System.out.println("View all Users  : " + response);
		log.info(" User Info for all user  will be displayed ");

		if (statusCode == 200) {

			response.then().assertThat().statusCode(statusCode).log().all();

			log.info("Get request with Status code " + response.getStatusCode());
			log.info("Values " + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("Not Found: 404");
		}
	}

	@When("User sends HTTPS GET Request to view all Staff")
	public void user_sends_https_get_request_to_view_all_staff() {

		response = UserRequests.GetAllStaffRequest();
		System.out.println("View All Staff : " + response);
		// UserPayload.setUserId(response.path("userId"));
		log.info(" View all Staff");

	}

	@Then("User receives status code {int} with response body to view all Staff")
	public void user_receives_status_code_with_response_body_to_view_all_staff(Integer statusCode) {

		response.then().log().all();
		System.out.println("View all Staff  : " + response);
		log.info(" User Info for all Staff will be displayed ");

		if (statusCode == 200) {

			response.then().assertThat().statusCode(statusCode).log().all();

			log.info("Get request with Status code " + response.getStatusCode());
			log.info("Values " + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("Not Found: 404");
		}
	}

	@When("User sends HTTPS POST Request for new User with Missing Mandatory Fields")
	public void user_sends_HTTPS_POST_Request_for_new_User_with_Missing_Mandatory_Fields() throws IOException {

		UserPayload = UserBody.PostMissingFieldsBody();
		response = UserRequests.PostRequest(UserPayload);
		// UserPayload.setUserId(response.path("userId"));
		// AdminUser=response.path("userId");
		System.out.println("UserID : " + response.path("userId"));
		// System.out.println("AdminUserID : " + AdminUser);

	}

	@Then("User receives status code {int} with response body for User with Missing Mandatory Fields")
	public void user_receives_status_code_with_response_body_for_User_with_Missing_Mandatory_Fields(
			Integer statusCode) {

		response.then().log().all();
		System.out.println("UserPostRequestMissingField : " + response);
		log.info(" new User is not created ");

		if (statusCode == 400) {

			response.then().assertThat().statusCode(statusCode).log().all();

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("Request failed");
		}

	}

	@When("User sends HTTPS POST Request for new User for Admin role")
	public void user_sends_https_post_request_for_new_user_for_admin_role() throws IOException {

		UserPayload = UserBody.PostAdminBody();
		response = UserRequests.PostRequest(UserPayload);

		UserPayload.setUserPhoneNumber(response.path("userPhoneNumber").toString());
		UserPayload.setUserFirstName(response.path("userFirstName"));
		AdminUser = response.path("userId");
		System.out.println("Phonenumber : " + response.path("userPhoneNumber"));
		System.out.println("AdminUserID : " + AdminUser);

	}

	@Then("User receives status code {int} with response body for creating an User for Admin role")
	public void user_receives_status_code_with_response_body_for_creating_an_user_for_admin_role(Integer statusCode) {

		response.then().log().all();
		System.out.println("UserPostRequest : " + response);
		log.info(" new User with admin role is created will be displayed");

		if (statusCode == 201) {

			response.then().assertThat().statusCode(statusCode).body(matchesJsonSchema(postUserjson)).log().all();

			assertEquals(UserPayload.getUserComments(), response.jsonPath().getString("userComments"));
			assertEquals(UserPayload.getUserEduPg(), response.jsonPath().getString("userEduPg"));
			assertEquals(UserPayload.getUserEduUg(), response.jsonPath().getString("userEduUg"));
			assertEquals(UserPayload.getUserFirstName(), response.jsonPath().getString("userFirstName"));
			assertEquals(UserPayload.getUserLastName(), response.jsonPath().getString("userLastName"));
			assertEquals(UserPayload.getUserLocation(), response.jsonPath().getString("userLocation"));
			assertEquals(UserPayload.getUserMiddleName(), response.jsonPath().getString("userMiddleName"));
			assertEquals(UserPayload.getUserPhoneNumber(), response.jsonPath().getString("userPhoneNumber"));
			assertEquals(UserPayload.getUserTimeZone(), response.jsonPath().getString("userTimeZone"));
			assertEquals(UserPayload.getUserVisaStatus(), response.jsonPath().getString("userVisaStatus"));
			// assertEquals(UserProgBatchIdRoleMap.getUserId(),
			// response.jsonPath().getString("userId"));
			assertEquals(UserPayload.getUserLinkedinUrl(), response.jsonPath().getString("userLinkedinUrl"));

			log.info("User created successfully with status code " + response.getStatusCode());
			log.info("User Respose body" + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("400 bad request");
		}

	}

	@When("User sends HTTPS POST Request for new User for Staff role")
	public void user_sends_HTTPS_POST_Request_for_new_User_for_Staff_role() throws IOException {

		UserPayload = UserBody.PostStaffBody();
		response = UserRequests.PostRequest(UserPayload);
		UserPayload.setUserPhoneNumber(response.path("userPhoneNumber").toString());
		UserPayload.setUserFirstName(response.path("userFirstName"));
		StaffUser = response.path("userId");
		System.out.println("UserID : " + response.path("userId"));
		System.out.println("StaffUserID : " + StaffUser);

	}

	@Then("User receives status code {int} with response body for creating an User for Staff role")
	public void user_receives_status_code_with_response_body_for_creating_an_User_for_Staff_role(Integer statusCode) {

		response.then().log().all();
		System.out.println("UserPostRequest : " + response);
		log.info(" new User with Staff role is created will be displayed");

		if (statusCode == 201) {

			response.then().assertThat().statusCode(statusCode).body(matchesJsonSchema(postUserjson)).log().all();

			assertEquals(UserPayload.getUserComments(), response.jsonPath().getString("userComments"));
			assertEquals(UserPayload.getUserEduPg(), response.jsonPath().getString("userEduPg"));
			assertEquals(UserPayload.getUserEduUg(), response.jsonPath().getString("userEduUg"));
			assertEquals(UserPayload.getUserFirstName(), response.jsonPath().getString("userFirstName"));
			assertEquals(UserPayload.getUserLastName(), response.jsonPath().getString("userLastName"));
			assertEquals(UserPayload.getUserLocation(), response.jsonPath().getString("userLocation"));
			assertEquals(UserPayload.getUserMiddleName(), response.jsonPath().getString("userMiddleName"));
			assertEquals(UserPayload.getUserPhoneNumber(), response.jsonPath().getString("userPhoneNumber"));
			assertEquals(UserPayload.getUserTimeZone(), response.jsonPath().getString("userTimeZone"));
			assertEquals(UserPayload.getUserVisaStatus(), response.jsonPath().getString("userVisaStatus"));

			assertEquals(UserPayload.getUserLinkedinUrl(), response.jsonPath().getString("userLinkedinUrl"));

			log.info("User created successfully with status code " + response.getStatusCode());
			log.info("User Respose body" + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("400 bad request");
		}

	}

	@When("User sends HTTPS POST Request for new User for Student role")
	public void user_sends_HTTPS_POST_Request_for_new_User_for_Student_role() throws IOException {

		UserPayload = UserBody.PostStudentBody();
		response = UserRequests.PostRequest(UserPayload);
		UserPayload.setUserPhoneNumber(response.path("userPhoneNumber").toString());
		UserPayload.setUserFirstName(response.path("userFirstName"));
		StudentUser = response.path("userId");
		System.out.println("UserID : " + response.path("userId"));
		System.out.println("StudentUserID : " + StudentUser);

	}

	@Then("User receives status code {int} with response body for creating an User for Student role")
	public void user_receives_status_code_with_response_body_for_creating_an_User_for_Student_role(Integer statusCode) {

		response.then().log().all();
		System.out.println("UserPostRequest : " + response);
		log.info(" new User with Student role is created will be displayed");

		if (statusCode == 201) {

			response.then().assertThat().statusCode(statusCode).body(matchesJsonSchema(postUserjson)).log().all();

			assertEquals(UserPayload.getUserComments(), response.jsonPath().getString("userComments"));
			assertEquals(UserPayload.getUserEduPg(), response.jsonPath().getString("userEduPg"));
			assertEquals(UserPayload.getUserEduUg(), response.jsonPath().getString("userEduUg"));
			assertEquals(UserPayload.getUserFirstName(), response.jsonPath().getString("userFirstName"));
			assertEquals(UserPayload.getUserLastName(), response.jsonPath().getString("userLastName"));
			assertEquals(UserPayload.getUserLocation(), response.jsonPath().getString("userLocation"));
			assertEquals(UserPayload.getUserMiddleName(), response.jsonPath().getString("userMiddleName"));
			assertEquals(UserPayload.getUserPhoneNumber(), response.jsonPath().getString("userPhoneNumber"));
			assertEquals(UserPayload.getUserTimeZone(), response.jsonPath().getString("userTimeZone"));
			assertEquals(UserPayload.getUserVisaStatus(), response.jsonPath().getString("userVisaStatus"));

			assertEquals(UserPayload.getUserLinkedinUrl(), response.jsonPath().getString("userLinkedinUrl"));

			log.info("User created successfully with status code " + response.getStatusCode());
			log.info("User Respose body" + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("400 bad request");
		}

	}

	@When("User sends HTTPS GET Request to view user by userID")
	public void user_sends_https_get_request_to_view_user_by_user_id() throws IOException {

		response = UserRequests.GetUserByIdRequest();
		System.out.println("View User by userId : " + response);
		log.info(" View User by userId");
	}

	@Then("User receives status code {int} with response body for viewing an User by ID")
	public void user_receives_status_code_with_response_body_for_viewing_an_user_by_id(Integer statusCode) {

		if (statusCode == 200) {

			response.then().assertThat().statusCode(statusCode).body(matchesJsonSchema(getUserByIDjson)).log().all();

			assertEquals(UserPayload.getUserComments(), response.jsonPath().getString("userComments"));
			assertEquals(UserPayload.getUserEduPg(), response.jsonPath().getString("userEduPg"));
			assertEquals(UserPayload.getUserEduUg(), response.jsonPath().getString("userEduUg"));
			assertEquals(UserPayload.getUserFirstName(), response.jsonPath().getString("userFirstName"));
			assertEquals(UserPayload.getUserLastName(), response.jsonPath().getString("userLastName"));
			assertEquals(UserPayload.getUserLocation(), response.jsonPath().getString("userLocation"));
			assertEquals(UserPayload.getUserMiddleName(), response.jsonPath().getString("userMiddleName"));
			assertEquals(UserPayload.getUserPhoneNumber(), response.jsonPath().getString("userPhoneNumber"));
			assertEquals(UserPayload.getUserTimeZone(), response.jsonPath().getString("userTimeZone"));
			assertEquals(UserPayload.getUserVisaStatus(), response.jsonPath().getString("userVisaStatus"));

			assertEquals(UserPayload.getUserLinkedinUrl(), response.jsonPath().getString("userLinkedinUrl"));

			log.info("User created successfully with status code " + response.getStatusCode());
			log.info("User Respose body" + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("400 bad request");
		}

	}

	@When("User sends HTTPS PUT Request to update User by UserId with missingFields")
	public void user_sends_HTTPS_PUT_Request_to_update_User_by_UserId_with_missingFields() throws IOException {

		UserWithoutRole = UserBody.PutUserMissingFieldsBody();
		response = UserRequests.PutUserByIdRequest(UserWithoutRole);

	}

	@Then("User receives status code {int} with response body for updating User with missingFields")
	public void user_receives_status_code_with_response_body_for_updating_User_with_missingFields(Integer int1) {

		response.then().log().all();
	}

	@When("User sends HTTPS PUT Request to update User by UserId")
	public void user_sends_https_put_request_to_update_user_by_user_id() throws IOException {

		System.out.println(AdminUser);
		UserWithoutRole = UserBody.PutUserBody();
		response = UserRequests.PutUserByIdRequest(UserWithoutRole);

		System.out.println("TimeZone : " + response.path("userTimeZone"));

	}

	@Then("User receives status code {int} with response body for updating User by ID")
	public void user_receives_status_code_with_response_body_for_updating_user_by_id(Integer statusCode) {

		if (statusCode == 200) {

			response.then().assertThat().statusCode(statusCode).body(matchesJsonSchema(putUserByIdjson)).log().all();

			assertEquals(UserPayload.getUserComments(), response.jsonPath().getString("userComments"));
			assertEquals(UserPayload.getUserEduPg(), response.jsonPath().getString("userEduPg"));
			assertEquals(UserPayload.getUserEduUg(), response.jsonPath().getString("userEduUg"));
			assertEquals(UserPayload.getUserFirstName(), response.jsonPath().getString("userFirstName"));
			assertEquals(UserPayload.getUserLastName(), response.jsonPath().getString("userLastName"));
			assertEquals(UserPayload.getUserLocation(), response.jsonPath().getString("userLocation"));
			assertEquals(UserPayload.getUserMiddleName(), response.jsonPath().getString("userMiddleName"));
			assertEquals(UserPayload.getUserPhoneNumber(), response.jsonPath().getString("userPhoneNumber"));
			assertEquals(UserPayload.getUserTimeZone(), response.jsonPath().getString("userTimeZone"));
			assertEquals(UserPayload.getUserVisaStatus(), response.jsonPath().getString("userVisaStatus"));
			assertEquals(UserPayload.getUserLinkedinUrl(), response.jsonPath().getString("userLinkedinUrl"));

			log.info("User updated successfully with status code " + response.getStatusCode());
			log.info("User Respose body" + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("400 bad request");
		}
	}

	@When("User sends HTTPS PUT Request to update User role status by User ID")
	public void user_sends_https_put_request_to_update_user_role_status_by_user_id() throws IOException {

		UserRoleMap = UserBody.PutUserRoleStatusBody();
		response = UserRequests.PutUserByRoleRequest(UserRoleMap);

		System.out.println("Update User Role Status: " + response.body());

	}

	@Then("User receives status code {int} with response body for updating UserRoleStaus")
	public void user_receives_status_code_with_response_body_for_updating_user_role_staus(Integer statusCode) {

		if (statusCode == 200) {

			response.then().assertThat().statusCode(statusCode).body(matchesJsonSchema(putUserStatusRolejson)).log()
			.all();

			assertEquals(UserPayload.getUserComments(), response.jsonPath().getString("userComments"));
			assertEquals(UserPayload.getUserEduPg(), response.jsonPath().getString("userEduPg"));
			assertEquals(UserPayload.getUserEduUg(), response.jsonPath().getString("userEduUg"));
			assertEquals(UserPayload.getUserFirstName(), response.jsonPath().getString("userFirstName"));
			assertEquals(UserPayload.getUserLastName(), response.jsonPath().getString("userLastName"));
			assertEquals(UserPayload.getUserLocation(), response.jsonPath().getString("userLocation"));
			assertEquals(UserPayload.getUserMiddleName(), response.jsonPath().getString("userMiddleName"));
			assertEquals(UserPayload.getUserPhoneNumber(), response.jsonPath().getString("userPhoneNumber"));
			assertEquals(UserPayload.getUserTimeZone(), response.jsonPath().getString("userTimeZone"));
			assertEquals(UserPayload.getUserVisaStatus(), response.jsonPath().getString("userVisaStatus"));
			assertEquals(UserPayload.getUserLinkedinUrl(), response.jsonPath().getString("userLinkedinUrl"));

			log.info("User updated successfully with status code " + response.getStatusCode());
			log.info("User Respose body" + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("400 bad request");
		}
	}

	@When("User sends HTTPS POST Request for new User with Existing PhoneNumber")
	public void user_sends_HTTPS_POST_Request_for_new_User_with_Existing_PhoneNumber() throws IOException {

		UserPayload = UserBody.PostExtgPhnNumBody();
		response = UserRequests.PostRequest(UserPayload);
		System.out.println("UserID : " + response.path("userId"));

	}

	@Then("User receives status code {int} with response body for User with ExistingPhoneNumber")
	public void user_receives_status_code_with_response_body_for_User_with_ExistingPhoneNumber(Integer int1) {

		response.then().log().all();
		System.out.println("UserPostRequestExisting Phone num : " + response);
		log.info(" new User is not created Existing Phone number");

	}

	@When("User sends HTTPS DELETE Request to delete a user")
	public void user_sends_https_delete_request_to_delete_a_user() {

		response = UserRequests.DeletAdminUserRequest();
		System.out.println("Delete User by userId : " + response);
		log.info("Deleted User with userId ");

	}

	@When("User sends HTTPS DELETE Request to delete a Staff user")
	public void user_sends_HTTPS_DELETE_Request_to_delete_a_Staff_user() {
		response = UserRequests.DeletStaffUserRequest();
		System.out.println("Delete User by userId : " + response);
		log.info("Deleted User with userId ");

	}

	@When("User sends HTTPS DELETE Request to delete a Student user")
	public void user_sends_HTTPS_DELETE_Request_to_delete_a_Student_user() {
		response = UserRequests.DeletStuUserRequest();
		System.out.println("Delete User by userId : " + response);
		log.info("Deleted User with userId ");
	}

	@Then("User receives status code {int} with response body to delete User by ID")
	public void user_receives_status_code_with_response_body_to_delete_user_by_id(Integer statusCode) {
		response.then().log().all().statusCode(200);

		if (statusCode == 200) {

			response.then().assertThat().statusCode(statusCode).log().all();

			log.info("Deleted successfully with status code " + response.getStatusCode());
			log.info("Deleted successfully message " + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("Internal server error :500");
		}
	}

	@When("User sends HTTPS DELETE Request to delete a Batch")
	public void user_sends_https_delete_request_to_delete_a_batch() {

		response = BatchRequests.DeletRequest();
		System.out.println("Delete Batch by batchId : " + response);
		log.info("Deleted Batch with batchId ");

	}

	@Then("User receives status code {int} with response body to delete Batch by ID")
	public void user_receives_status_code_with_response_body_to_delete_batch_by_id(Integer statusCode) {
		response.then().log().all().statusCode(200);

		if (statusCode == 200) {

			response.then().assertThat().statusCode(statusCode).log().all();

			log.info("Deleted successfully with status code " + response.getStatusCode());
			log.info("Deleted successfully message " + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("Internal server error :500");
		}
	}

	@When("User sends HTTPS DELETE Request to delete a Program")
	public void user_sends_https_delete_request_to_delete_a_program() {
		response = ProgramRequests.DeleteByProgrambyID();

		System.out.println("Delete Batch by batchId : " + response);
		log.info("Deleted Program with programId ");
	}

	@Then("User receives status code {int} with response body to delete Program by ID")
	public void user_receives_status_code_with_response_body_to_delete_program_by_id(Integer statusCode) {
		response.then().log().all().statusCode(200);

		if (statusCode == 200) {

			response.then().assertThat().statusCode(statusCode).log().all();

			log.info("Deleted successfully with status code " + response.getStatusCode());
			log.info("Deleted successfully message " + response.getBody().asString());

		} else {
			log.info("Request failed");
			log.error("Internal server error :500");
		}
	}

	@When("User sends HTTPS GET Request to view user by invalid userID")
	public void user_sends_HTTPS_GET_Request_to_view_user_by_invalid_userID() {

		response = UserRequests.GetUserByIdRequest();
		System.out.println("View User by invalid userId : " + response);
		log.info(" View User by Invalid userId");

	}

	@Then("User receives status code {int} Bad Request with response body with Invalid UserID")
	public void user_receives_status_code_Bad_Request_with_response_body_with_Invalid_UserID(Integer statusCode) {

		response.then().log().all();
		if (statusCode == 404) {

			response.then().assertThat().statusCode(statusCode).log().all();

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("Request failed");
		}

	}

	@When("User sends HTTPS PUT Request to update User by Invalid userId")
	public void user_sends_HTTPS_PUT_Request_to_update_User_by_Invalid_userId() throws IOException {

		UserWithoutRole = UserBody.PutUserBody();
		response = UserRequests.PutUserByIdRequest(UserWithoutRole);
		System.out.println("update User by Invalid userId: " + response.path("userTimeZone"));

	}

	@Then("User receives status code {int} with response body for updating User by InvalidID")
	public void user_receives_status_code_with_response_body_for_updating_User_by_InvalidID(Integer statusCode) {

		response.then().log().all();
		if (statusCode == 404) {

			response.then().assertThat().statusCode(statusCode).log().all();

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("Request failed");
		}

	}

	@When("User sends HTTPS PUT Request to assign User to given program and Batch for invalid UserId")
	public void user_sends_HTTPS_PUT_Request_to_assign_User_to_given_program_and_Batch_for_invalid_UserId()
			throws IOException {

		System.out.println("UserupdateRequest : " + ProgramPayload.getProgramId());
		System.out.println("UserupdateRequest : " + BatchPayload.getBatchId());
		System.out.println("UserupdateRequest : " + UserRoleMap.getRoleId());

		UserProgBatchIdRoleMap = UserBody.AssignUserToProgBatchMsngFieldBody();
		response = UserRequests.PutUserToProgBatchRequest(UserProgBatchIdRoleMap);

	}

	@Then("User receives status code {int} with response body for assigning Program and Batch with invalid User")
	public void user_receives_status_code_with_response_body_for_assigning_Program_and_Batch_with_invalid_User(
			Integer statusCode) {

		response.then().log().all();
		if (statusCode == 404) {

			response.then().assertThat().statusCode(statusCode).log().all();

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("Request failed");
		}

	}

	@When("User sends HTTPS DELETE Request to delete a user with Invalid User Id")
	public void user_sends_HTTPS_DELETE_Request_to_delete_a_user_with_Invalid_User_Id() {

		response = UserRequests.DeletAdminUserRequest();
		System.out.println("Delete User by userId : " + response);

		log.info("Deleted User with userId ");

	}

	@Then("User receives status code {int} with response body to delete User by Invalid User Id")
	public void user_receives_status_code_with_response_body_to_delete_User_by_Invalid_User_Id(Integer statusCode) {

		response.then().log().all();
		if (statusCode == 404) {

			response.then().assertThat().statusCode(statusCode).log().all();

			log.info("Status code " + response.getStatusCode());
			log.info("Validation message " + response.getBody().asString());

		} else {
			log.info("Request failed");
		}
	}

	@When("User sends HTTPS POST Request to create new Batch")
	public void user_sends_https_post_request_to_create_new_batch() throws IOException {

		BatchPayload = BatchBody.PostBody();
		response = BatchRequests.PostRequest(BatchPayload);
		BatchPayload.setBatchId(response.path("batchId"));
		UserPayload.setUserPhoneNumber(response.path("userPhoneNumber").toString());

		log.info("All required details are send in the POST request and new Batch is created ");
		System.out.println("BatchID : " + response.path("batchId"));

	}

	@Then("User receives status code {int} with response body for creating a Batch")
	public void user_receives_status_code_with_response_body_for_creating_a_batch(Integer statusCode) {

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

	@When("User sends HTTPS PUT Request to assign User to given program and Batch")
	public void user_sends_https_put_request_to_assign_user_to_given_program_and_batch() throws IOException {

		System.out.println("UserupdateRequest : " + ProgramPayload.getProgramId());
		System.out.println("UserupdateRequest : " + BatchPayload.getBatchId());
		System.out.println("UserupdateRequest : " + UserRoleMap.getRoleId());

		UserProgBatchIdRoleMap = UserBody.AssignUserToProgBatchBody();
		response = UserRequests.PutUserToProgBatchRequest(UserProgBatchIdRoleMap);

	}

	@Then("User receives status code {int} with response body for assigning Program and Batch to User")
	public void user_receives_status_code_with_response_body_for_assigning_program_and_batch_to_user(Integer int1) {

		response.then().log().all();
		System.out.println("Assign Update User Role Program Batch Status : " + response);
		log.info(" User {userID}  has been successfully assigned to Program/Batch(es)");

	}

	@When("User sends HTTPS PUT Request to update User role status by User ID for missing fields")
	public void user_sends_HTTPS_PUT_Request_to_update_User_role_status_by_User_ID_for_missing_fields()
			throws IOException {

		UserRoleMap = UserBody.PutUserRoleStatusMissingStatsBody();
		response = UserRequests.PutUserByRoleRequest(UserRoleMap);

		System.out.println("Update User Role Status: " + response.body());

	}

	@When("User sends HTTPS PUT Request to update User role status by different Role ID")
	public void user_sends_HTTPS_PUT_Request_to_update_User_role_status_by_different_Role_ID() throws IOException {

		UserRoleMap = UserBody.PutUserRoleStatusDifferentRoleIdBody();
		response = UserRequests.PutUserByRoleRequest(UserRoleMap);

		System.out.println("Update User Role Status: " + response.body());

	}

	@When("User sends HTTPS PUT Request to assign User to given program and Batch by InvalidID")
	public void user_sends_HTTPS_PUT_Request_to_assign_User_to_given_program_and_Batch_by_InvalidID()
			throws IOException {

		UserProgBatchIdRoleMap = UserBody.AssignUserToProgBatchInvalidBody();
		response = UserRequests.PutUserToProgBatchRequest(UserProgBatchIdRoleMap);

	}

}