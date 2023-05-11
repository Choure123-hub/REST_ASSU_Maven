package Day8;
import static io.restassured.RestAssured.*;


import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Get_User {

	@Test
	void test_GetUser(ITestContext context)
	{
	
		String bearerToken="75b90c18f4bc76a30203ee8dc054fa554cc3407071532f45040f443aba0b210c";
		//int id =(Integer) context.getAttribute("user_id");
		int id =(Integer) context.getSuite().getAttribute("user_id");
		given()
		.headers("Authorization","Bearer "+bearerToken)
         .pathParam("id", id)
		
		.when()
		
		.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
	}
}
