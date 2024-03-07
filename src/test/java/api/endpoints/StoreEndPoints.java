package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	public static Response crateUser(Store payload)
	{
		 Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		
		.when()
		.post(Routes.Post_url);
		return response;
	}
	
	public static Response readUser(int orderId,Store payload)
	{
		 Response response = given()
		
		.pathParam("PetId", orderId)
		.when()
		.get(Routes.Get_url);
		return response;
	}
	public static Response updateUser(String userName ,Store payload)
	{
		 Response response = given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		
		.when()
		.put(Routes.Updatae_url);
		return response;
	}
	
	
	public static Response deleteUser(String userName)
	{
		 Response response = given()
		
		.pathParam("username", userName)
		
		.when()
		
		.delete(Routes.Delete_url);
		return response;
	}
	
}
