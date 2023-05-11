package REST_ASSURED;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Example1 
{
	@Test
public void Gaterequest() 
{
	RestAssured.baseURI="https://reqres.in/";
	RestAssured.given().log().all().header("Content-Type", "application/json").
	when().get("/api/users?page=2")
	.then().log().all().assertThat().statusCode(200);
}
}
