package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	public static Response crateUser(User payload)
	{
		 Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.postp_url);
		return response;
	}
	public static Response readUser(String userName)
	{
		 Response response = given()
		
		.pathParam("username", userName)
		.when()
		.get(Routes.getp_url);
		return response;
	}
	public static Response updateUser(String userName ,User payload)
	{
		 Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		
		.when()
		.put(Routes.updatep_url);
		return response;
	}
	
	
	public static Response deleteUser(String userName)
	{
		 Response response = given()
		
		.pathParam("username", userName)
		
		.when()
		
		.delete(Routes.deletep_url);
		return response;
	}
	
}
