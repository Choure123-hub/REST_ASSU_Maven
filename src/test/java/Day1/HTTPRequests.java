package Day1;

import  org.testng.annotations.Test;



import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequests 
{
	int id;
	@Test(priority=1)
void getUsers()
{
	given()
	
	.when()
	.get("https://reqres.in/api/users?page=2")
	.then()
	.statusCode(200)
	.body("page",equalTo(2))
	.log().all();
}
	@Test(priority=2)
	void createUser()
	{
		HashMap data=new HashMap();
		data.put("name", "bhagvanta");
		data.put("job", "Engineer");
		id=given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
//		.then()
//		.statusCode(201)
//		.log().all();
	}
	@Test(priority=3,dependsOnMethods = {"createUser"})
	void updateUser()
	{
		HashMap data=new HashMap();
		data.put("name", "sandhya");
		data.put("job", "teacher");
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		
		.then()
		.statusCode(200)
		.log().all();
	}
	@Test(priority=4)
	void deleteUser() {
		given()
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log().all();
	}
}
