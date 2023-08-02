package api.request;

import static io.restassured.RestAssured.*;

import api.payload.*;
import api.utilities.RestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserRequests extends RestUtils {

	// Post Request
	public static Response PostRequest(UserPayload payload) {

		try {

			response = given().
					contentType(ContentType.JSON).
					body(payload).
					log().all().
					when().post(routes.getString("User_Post_URL"));

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	// @GETRequest_AllUsers -User_Get_AllUsers=/users/users/
	public static Response GetAllUserRequest() {

		try{

			response = given().
					contentType(ContentType.JSON).
					log().all().
					when().get(routes.getString("User_Get_AllUsers"));

		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}


	// @GETRequest_Userby_UserID - User_Get_UserInfoById=/users/users/
	public static Response GetUserByIdRequest() {

		try {

			response = given().contentType(ContentType.JSON).log().all().when()
					.get(routes.getString("User_Get_UserInfoById") + AdminUser);

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	// @GETRequest_Userby_Role -User_Get_AllUsers_With_Role=/users/users/roles
	public static Response GetUserByRoleRequest() {

		try{

			response = given().contentType(ContentType.JSON).log().all().when()
					.get(routes.getString("User_Get_AllUsers_With_Role"));

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	// @GETRequest_GetAllStaff -User_Get_AllStaff=/users/users/getAllStaff
	public static Response GetAllStaffRequest() {

		try {

			response = given().contentType(ContentType.JSON).log().all().when().get(routes.getString("User_Get_AllStaff"));

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	// PUT Request - @PUTRequest_UpdateUserById - User_PUT_UserById=/users/users/
	public static Response PutUserByIdRequest(UserWithoutRole payload) {

		try {

			response = given().contentType(ContentType.JSON).body(payload).log().all().when()
					.put(routes.getString("User_PUT_UserById") + AdminUser);

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	// @07PUTRequest_UpdateUserRoleStatusById
	// --User_PUT_UserRoleStatus=/users/users/roleStatus/
	public static Response PutUserByRoleRequest(UserRoleMap payload) {

		try {

			response = given().contentType(ContentType.JSON).body(payload).log().all().when()
					.put(routes.getString("User_PUT_UserRoleStatus") + AdminUser);

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	// @07PUTRequest_AssignUserToProgBatchById
	// --User_PUT_UserRoleProgBatchStatus=/users/users/roleProgramBatchStatus/
	public static Response PutUserToProgBatchRequest(UserProgBatchIdRoleMap payload) {

		try {

			response = given().contentType(ContentType.JSON).body(payload).log().all().when()
					.put(routes.getString("User_PUT_UserRoleProgBatchStatus") + AdminUser);

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	// Delete Request Admin
	public static Response DeletAdminUserRequest() {

		try {

			response = when().delete(routes.getString("User_Delete_URL") + AdminUser);

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	// Delete Request Staff
	public static Response DeletStaffUserRequest() {

		try {

			response = when().delete(routes.getString("User_Delete_URL") + StaffUser);

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	// Delete Request Student
	public static Response DeletStuUserRequest() {

		try {

			response = when().delete(routes.getString("User_Delete_URL") + StudentUser);

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

}
