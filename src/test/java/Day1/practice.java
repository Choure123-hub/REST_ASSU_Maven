package Day1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;



public class practice {
	int id;
@Test(priority = 1)
void createUser()

{
	
	HashMap data=new HashMap();
	
	data.put("name", "ramesh");
	data.put("lastname", "choure");
	data.put("job", "tester");
	
id=given()
.contentType("application/json")
.body(data)

.when()
.post("https://reqres.in/api/users")
.jsonPath().getInt("id");





}
@Test(priority = 2, dependsOnMethods = {"createUser"})
void updateUser()

{
	
	HashMap data=new HashMap();
	
	data.put("name", "ram");
	data.put("lastname", "choure");
	
	
given()
.contentType("application/json")
.body(data)

.when()
.put("https://reqres.in/api/users/"+id)

.then()
.statusCode(200)
.log().all();




}
@Test(priority = 3)
void deleteUser()
{
	given()
	
	.when()
	.delete("https://reqres.in/api/users/"+id)
	.then()
	.statusCode(204)
	.log().all();
	
}

}
