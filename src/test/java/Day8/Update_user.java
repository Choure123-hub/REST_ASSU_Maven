package Day8;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Update_user {

	@Test
	void testUpdateUser(ITestContext context)
	{
	Faker faker=new Faker();
	
	JSONObject data=new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken = "75b90c18f4bc76a30203ee8dc054fa554cc3407071532f45040f443aba0b210c";
		//int id =(Integer) context.getAttribute("user_id");
		
		int id =(Integer) context.getSuite().getAttribute("user_id");
		
		           given()
		    		
		.headers("Authorization","Bearer "+bearerToken)
		.contentType("application/json")
		.pathParam("id", id)
		
		
		
		.when()
		.put("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		.statusCode(200)
		.log().all();
		
		     
		    
		
	}
}
