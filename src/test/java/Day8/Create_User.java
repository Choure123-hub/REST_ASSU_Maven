package Day8;


import static io.restassured.RestAssured.given
;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Create_User {
@Test
	void test_createUser(ITestContext context)
	{
	
	Faker faker=new Faker();
	
JSONObject data=new JSONObject();
	
	data.put("name", faker.name().fullName());
	data.put("gender", "Male");
	data.put("email", faker.internet().emailAddress());
	data.put("status", "active");
	
	String bearerToken = "75b90c18f4bc76a30203ee8dc054fa554cc3407071532f45040f443aba0b210c";
	
	            int id = given()
	    		
	.headers("Authorization","Bearer "+bearerToken)
	.contentType("application/json")
	.body(data.toString())
	
	
	.when()
	.post("https://gorest.co.in/public/v2/users")
	
	 .jsonPath().getInt("id");
	
	     
	     System.out.println("Genrated id is:"+id);
	
	//context.setAttribute("user_id", id);
	     context.getSuite().setAttribute("user_id", id);
	}
}
