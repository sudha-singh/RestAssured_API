package api.request;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import api.payload.BatchPayload;
import api.utilities.RestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BatchRequests extends RestUtils{

	//Post Request
	public static Response PostRequest(BatchPayload payload) {

		try {

			response = given().
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
					body(payload).
					when().post(routes.getString("Batch_Post_URL"));

		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}	


	// Get all batch
	public static Response GetRequest () {

		try {

			response = when().
					get(routes.getString("Batch_GetAll_URL"));

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	//Get Batch by ID
	public static Response GetBatchByIDRequest () {

		try {

			response = when().
					get(routes.getString("Batch_GetbyId_URL")+BatchPayload.getBatchId());

		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}


	//Get Batch by Name
	public static Response GetBatchByNameRequest () {

		try {

			response = when().
					get(routes.getString("Batch_GetbyName_URL")+BatchPayload.getBatchName());

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	//Get Batch by ProgId
	public static Response GetBatchByProgIDRequest () {

		try {

			response = when().
					get(routes.getString("Batch_GetBatchByProgramID")+BatchPayload.getProgramId());

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	//Update by ID
	public static Response UpdateBatchByIDRequest (BatchPayload updateBatch) {	

		try {

			response = given().
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
					body(updateBatch).
					when().put(routes.getString("Batch_UpdateByBatchID")+BatchPayload.getBatchId());

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	//Delete Request
	public static Response DeletRequest() {

		try {

			response = when().
					delete(routes.getString("Batch_Delete_URL")+BatchPayload.getBatchId());

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
}
