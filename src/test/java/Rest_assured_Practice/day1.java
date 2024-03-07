package Rest_assured_Practice;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;
public class day1 {
   int id;
	@Test(priority = 1)
	void getuser() 
	{
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		.then()
		
		.statusCode(200)
		.body("page", equalTo(2))
	    .log().all();
		
	}
	@Test(priority =2)
	void createUser()
	{
		HashMap data=new HashMap();
		data.put("name", "bhagventa");
		data.put("job", "QA");
		
		id=given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		
		
	}
	@Test(priority =3,dependsOnMethods = {"createUser"})
	void updateuser()
	{
		HashMap data=new HashMap();
		data.put("name", "choure");
		data.put("job", "Standard");
		
	    given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.put("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(200)
		.log().all();
	}
	void delete()
	{
		given()
		
		.when()
		.delete("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(204)
		.log().all();
	}
	

}

