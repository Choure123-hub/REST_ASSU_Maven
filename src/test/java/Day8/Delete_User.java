package Day8;
import static io.restassured.RestAssured.given;


import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Delete_User {
	
    @Test
	void test_DeleteUser(ITestContext context)
	{
		String bearerToken = "75b90c18f4bc76a30203ee8dc054fa554cc3407071532f45040f443aba0b210c";
		
		//int id =(Integer) context.getAttribute("user_id");
		int id =(Integer) context.getSuite().getAttribute("user_id");
		
		given()
		
		.headers("Authorization","Bearer "+bearerToken)
		
		.pathParam("id", id)
		
		.when()
		.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(204)
		.log().all();
	}
}
