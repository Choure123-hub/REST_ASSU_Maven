package Day3;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LogingDemo {
@Test
	void testLog()
	{
		given()
		
		
		
		
		.when()
		.get("https://reqres.in/api/users?page=2")
		
		
		.then()
		//.log().all();
		//.log().body();
		//.log().cookies();
		.log().headers();
	}
}
