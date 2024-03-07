package Day7;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentication {

	//@Test(priority=1)
	void testBasicAuthentication()
	{
		given()
		.auth().basic("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}
	//@Test(priority=2)
	void testDigestAuthentication()
	{
		given()
		.auth().digest("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}
	//@Test(priority=3)
	void testPreemptiveAuthentication()
	{
		given()
		.auth().preemptive().basic("postman","password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}
	@Test(priority=1)
	void testBeareTokenAuthontication()
	{
		
		String bearerTokrn="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";
		
		given()
		.headers("Authorization","Bearer "+bearerTokrn)
		
		.when()
		
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority=2)
	void testOAuth1Authentication()
	
	{
		given()
		.auth().oauth("consumerKey","consumerSecrat","accessToken","TokenSecrat")
		
		.when()
		.get("url")
		
		.then()
		.statusCode(200)
		.log().all();
		
		
		
	}

	//@Test(priority=1)
	void testOAuth2Authentication()
	{
		
		given()
		.auth().oauth2("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")
		
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();
	}
	//@Test
	void testAPIKeyAuthentication()
	{
		//Method1................
		
		
		/*given()
		.queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c" )//App id is API key
		
		.when()
		.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
		
		.then()
		.statusCode(200)
		.log().all();
		*/
		
		//Method2..........
		given()
		.queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c")
		
		.pathParam("mypath","data/2.5/forecast/daily")
		
		.queryParam("q","Delhi")
		
		.queryParam("units","metric")
		
		.queryParam("cnt","7")
		
		.when()
		.get("https://api.openweathermap.org/{mypath}")
		
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
