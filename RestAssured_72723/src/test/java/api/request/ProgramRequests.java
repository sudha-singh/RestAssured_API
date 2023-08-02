package api.request;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import api.payload.ProgramPayload;
import api.utilities.RestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class ProgramRequests extends RestUtils{


	// Post Request
	public static Response PostRequest(ProgramPayload payload) {		

		try {
			response = given().
					contentType(ContentType.JSON).
					accept(ContentType.JSON).
					body(payload)
					.when().post(routes.getString("Program_Post_URL"));
		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	
	// UpdateRequestwithValidProgramName
	public static Response UpdateByProgramName(ProgramPayload payload) {

		try {

			response = given().contentType(ContentType.JSON).
					accept(ContentType.JSON).body(payload)
					.when().put(routes.getString("Program_PutbyName_URL")+ProgramPayload.getProgramName());

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}

	// Update Request with Valid ProgramID
	public static Response UpdateByProgramID(ProgramPayload payload) {

		try {

			response = given().contentType(ContentType.JSON).
					accept(ContentType.JSON).
					body(payload)
					.when().put(routes.getString("Program_PutbyID_URL")+ProgramPayload.getProgramId());

		}catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	// GetALLRequest - all programs
	public static Response GetAllProgramRequest() {

		try {
			response = given()
					.when().get(routes.getString("Program_GetAll_URL"));

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;

	}



	// GetRequest By ValidProgram ID
	public static Response GetByProgramID() {
		System.out.println("ProgramID is "+ProgramPayload.getProgramId());

		try {

			response = given()
					.when().get(routes.getString("Program_GetbyID_URL")+ProgramPayload.getProgramId());

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}


	//Delete Request with program name
	public static Response DeletebyprogramName() {

		try {

			response = when().
					delete(routes.getString("Program_DeletebyName_URL")+ProgramPayload.getProgramName());

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	// DeleteRequestwithValidProgramID
	public static Response DeleteByProgrambyID()	{

		System.out.println("Program ID is "+ProgramPayload.getProgramId());
		try { 

			response = when().
					delete(routes.getString("Program_DeletebyID_URL")+ProgramPayload.getProgramId());

		}catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}
}
