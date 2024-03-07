package Rest_assured_Practice;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;

public class Post_request {
  //int id;
	@Test
	void testjsonresponse()
	{
		pojo_request data=new pojo_request();
		
		data.setId(9);
		data.setJob("developer");
		data.setName("maratha");
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("maratha"))
		.log().all();
	}
}
