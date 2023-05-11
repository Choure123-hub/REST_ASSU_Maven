package Day4;
import static io.restassured.RestAssured.*;



import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ParsingJsonResponseData {
	@Test(priority=1)
void testJsonResponse()
{
		//approach1

		/*given()

		.contentType(ContentType.JSON)
		
		.when()

         .get("  http://localhost:3000/book")

		.then()

          .statusCode(200)
          .header("Content-Type", "application/json; charset=utf-8")
          .body("[3].title",equalTo("the Lord of Rings"));*/
		
          //Approach 2
		Response res = given()
		.contentType(ContentType.JSON)
		.when()
		.get(" http://localhost:3000/book");
		Assert.assertEquals(res.getStatusCode(),200);//validation 1
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8" );
		String bookname = res.jsonPath().get("[3].title").toString();
		Assert.assertEquals(bookname, "the Lord of Rings");
}
@Test(priority=2)
void testJsonResponseBodyData()
{
         
		Response res = given()
				
		.contentType(ContentType.JSON)
		
		.when()
		
		.get("http://localhost:3000/book");
		
//		Assert.assertEquals(res.getStatusCode(),200);//validation 1
//		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8" );
//	String bookname = res.jsonPath().get("[3].title").toString();
//	Assert.assertEquals(bookname, "the Lord of Rings");
//		
		//JSONObject Class
		JSONObject jo=new JSONObject(res.toString());     //coverting response To Json object Type
		
		
		for(int i=0;i<jo.getJSONArray("3").length();i++)
		{
			
			String booktitle = jo.getJSONArray("3").getJSONObject(i).get("title").toString();
			System.out.println(booktitle);
		}
		
}
}
