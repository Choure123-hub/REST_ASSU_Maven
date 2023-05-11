package Day3;
import static io.restassured.RestAssured.*;


import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {

	
	//@Test(priority=1)
	void testCookies()
	{
		given()
		
		
		.when()
		.get("https://www.google.com/")
		
		.then()
		.cookie("AEC","AUEFqZd1gwFDu98y505gQOQ_mkaAtqmN7XxQD8W_VdToTAZcRmQ8U50P0iY")
		.log().all();
		
	}
	@Test(priority=2)
	void geCookiesInfo()
	{
	Response res=given()
		
		
		.when()
		.get("https://www.google.com/");
	//get single cookie Info
//		String Cookie_value = res.getCookie("AEC");
//		System.out.println("value of cookie is::::::::::::::::>"+Cookie_value);
//	
	Map<String, String> cookies_value = res.getCookies();
	for(String k:cookies_value.keySet())
	{
		 String cookie_value = res.getCookie(k);
		System.out.println(k+"  "+cookies_value);
	}
	}
}
