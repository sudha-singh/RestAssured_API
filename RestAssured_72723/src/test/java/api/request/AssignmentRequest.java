package api.request;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import api.payload.AssignmentPayload;
import api.utilities.RestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AssignmentRequest extends RestUtils{


	//Post Request
	public static Response PostRequest(AssignmentPayload payload) {

		try {

			response = given().
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
					body(payload).
					when().post(routes.getString("Assignment_Post_URL"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}



	//Put Request
	public static Response PutRequest(AssignmentPayload payload) {

		try {

			response = given().
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
					body(payload).
					when().put(routes.getString("Assignment_Put_URL")+AssignmentPayload.getAssignmentId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}


	//Delete Request
	public static Response DeletRequest() {

		try {

			response = when().
					delete(routes.getString("Assignment_Delete_URL")+AssignmentPayload.getAssignmentId());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	// Get by AssignmentId
	public static Response GetRequest() {

		try {

			response = when().
					get( routes.getString("Assignment_GetAllAssignments_URL")+AssignmentPayload.getAssignmentId());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}	


	//Get assignment for Batch
	public static Response GetRequestBatch() {

		try {

			response = when().
					get( routes.getString("Assignment_GetAssignmentforBatch_URL")+BatchPayload.getBatchId());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	// Get By BatchId with no assignment
	public static Response GetRequestBatch1() {

		try {

			response = when().
					get( routes.getString("Assignment_GetAssignmentforBatch_URL")+6580);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}


}
