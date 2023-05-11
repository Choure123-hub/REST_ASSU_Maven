package REST_ASSURED;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Request
{
RequestSpecification  reqBuilder;
	
	@BeforeTest
	public void setUp() {		
		 this.reqBuilder = new RequestSpecBuilder()
		.setBaseUri("https://reqres.in/")
		.setBasePath("/api/users").addQueryParam("page", 2).build();
	}

	@Test
	public void getRequest1() {	
		
		RestAssured
		  .given().log().all()
		  .spec(reqBuilder)
		   .when().get()
		   .then().log().all()
		   .statusLine("HTTP/1.1 200 OK");		
						
	}



}
