package Day3;
import static io.restassured.RestAssured.*;


import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
public class PathAndQueryParametrs {
	
	//https:reqres.in/api/users?page=2&id=5 
	//users ------> path parameters
	//page=2&id=5------> query parameters
	
	
     @Test
	void testPathAndQueryParametrs() 
	{
		given()
		.pathParam("mypath", "users")   //path parameters
		.queryParam("page", "2")   //query parameters
		.queryParam("id", "5")   //query parameters
		
		
		
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		
		
		.then()
		
		.statusCode(200)
		.log().all();
		
	}
	
}
