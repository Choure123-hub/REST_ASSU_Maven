package Day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class demo1 {
	
	
	@Test
		 void testPostusingHashMap() {
	
			HashMap data= new HashMap();
			
			data.put("name", "Scott");
			data.put("job", "QA");
			data.put("id", "802");
			
		
			given()
			.contentType("application/json")
			.body(data)
			
			.when()
			.post(" https://reqres.in/api/users")
			
			.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("job",equalTo("QA"))
			.body("id",equalTo("802"))
			
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
}
}