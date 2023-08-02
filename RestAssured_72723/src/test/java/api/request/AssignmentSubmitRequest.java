package api.request;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import api.payload.AssignmentSubmitPayload;
import api.utilities.RestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AssignmentSubmitRequest extends RestUtils{	


	//Post Request
	public static Response PostRequest(AssignmentSubmitPayload payload) {

		try {

			response = given().
					contentType(ContentType.JSON).
					body(payload).
					when().post(routes.getString("AssignmentSubmit_Post_URL"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	//Get All Request
	public static Response GetAllRequest() {

		try {

			response = given().
					when().
					get(routes.getString("AssignmentSubmit_GetAll_URL"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	//Get Assignment Submitted by user ID Request
	public static Response GetAssignmentByUserIDRequest() {

		try {

			response = given().
					when().
					get(routes.getString("AssignmentSubmit_GetByUserID_URL")+AssignmentSubmitPayload.getUserId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}


	//Get Assignment Submitted by batch ID Request
	public static Response GetAssignmentByBatchIDRequest() {

		try {

			response = given().
					when().
					get(routes.getString("AssignmentSubmit_GetByBatchID_URL")+BatchPayload.getBatchId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}


	//Get Grade by Student ID Request
	public static Response GetGradeByStudentIDRequest() {

		try {

			response = given().
					when().
					get(routes.getString("AssignmentSubmit_GetGradeStudentID_URL")+StudentUser);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	//Get Grade By Assignment ID Request
	public static Response GetGradeByAssignIDRequest() {

		try {

			response = given().
					when().
					get(routes.getString("AssignmentSubmit_GetGradeAssignID_URL")+AssignmentSubmitPayload.getAssignmentId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}


	//Get Grade By Batch ID Request
	public static Response GetGradeByBatchIDRequest() {

		try {

			response = given().
					when().
					get(routes.getString("AssignmentSubmit_GetGradeBatchID_URL")+BatchPayload.getBatchId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}


	//Put Resubmit Assignment by submission ID Request
	public static Response ResubmitAssignPutRequest(AssignmentSubmitPayload payload) {


		try {

			response = given().
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
					body(payload).
					when().put(routes.getString("AssignmentSubmit_PutResubmit_URL")+AssignmentSubmitPayload.getSubmissionId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}


	//Put Grade by submission ID Request
	public static Response GradePutRequest(AssignmentSubmitPayload payload) {

		try {

			response = given().
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
					body(payload).
					when().put(routes.getString("AssignmentSubmit_PutByGrade_URL")+AssignmentSubmitPayload.getSubmissionId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}


	//Delete Request
	public static Response DeletRequest() {

		try {

			response = when().
					delete(routes.getString("AssignmentSubmit_Delete_URL")+AssignmentSubmitPayload.getSubmissionId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
