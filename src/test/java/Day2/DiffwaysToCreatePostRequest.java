package Day2;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


//1) Post request body usining Hashmap

public class DiffwaysToCreatePostRequest {
     
	//@Test(priority=1)
	 void testPostusingHashMap() {
		HashMap data= new HashMap();
		
		data.put("name", "Scott");
		data.put("location", "itely");
		data.put("phone", "123456");
		
	String	courseArr[]= {"C","C++"};
		data.put("courses", courseArr);
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post(" http://localhost:3000/users")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Scott"))
		.body("location",equalTo("itely"))
		.body("phone",equalTo("123456"))
		.body("courses[0]",equalTo("C"))
		.body("courses[1]",equalTo("C++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}
	//@Test(priority=2)
	void testDelete() {
		given()
		
		.when()
		.delete(" http://localhost:3000/users/23")
		.then()
		.statusCode(200);
	}
	
	// 2) Post request body using org.json libray
	
	//@Test(priority=1)
	 void testPostusingOrg_json() {
		
		JSONObject data=new JSONObject();
		data.put("name", "Scott");
		data.put("location", "France");
		data.put("phone", "123456");
		
		String coursesArr[]= {"C","C++"};
		data.put("courses",coursesArr);
		
		given()
		.contentType("application/json")
		.body(data.toString())
		
		.when()
		.post(" http://localhost:3000/users")
		
		.then()
		.statusCode(201)
		.body("name",equalTo("Scott"))
		.body("location",equalTo("France"))
		.body("phone",equalTo("123456"))
		.body("courses[0]",equalTo("C"))
		.body("courses[1]",equalTo("C++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
	}
	//@Test(priority=2)
	void TestDelete() {
		given()
		
		.when()
		.delete(" http://localhost:3000/users/23")
		.then()
		.statusCode(200);
	}
	// 3) Post request body using POJO Class(plain old java object)..........>most important
	
		//@Test(priority=1)
		 void testPostusingPOJO() {
			
			Pojo_PostRequest data=new Pojo_PostRequest();
			data.setName("Scott");
			data.setLocation("France");
			data.setPhone("123456");
			
			String coursesArr[]= {"C","C++"};
			data.setCourses(coursesArr);
			
			given()
			.contentType("application/json")
			.body(data)
			
			.when()
			.post(" http://localhost:3000/users")
			
			.then()
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location",equalTo("France"))
			.body("phone",equalTo("123456"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("C++"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
		}
		//@Test(priority=2)
		void testDelete1() {
			given()
			
			.when()
			.delete(" http://localhost:3000/users/23")
			.then()
			.statusCode(200);
		}
		// 3) Post request body using External JSON file
		
			@Test(priority=1)
			 void testPostusingExternal_JSONfile() throws FileNotFoundException 
			{
				File f=new File(".\\body.json");
				
				FileReader fr=new FileReader(f);
				JSONTokener jt=new JSONTokener(fr);
				JSONObject data=new JSONObject(jt);
				
				
				
				given()
				.contentType("application/json")
				.body(data.toString())
				
				.when()
				.post(" http://localhost:3000/users")
				
				.then()
				.statusCode(201)
				.body("name",equalTo("Scott"))
				.body("location",equalTo("IRAN"))
				.body("phone",equalTo("123456"))
				.body("courses[0]",equalTo("C"))
				.body("courses[1]",equalTo("C++"))
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all();
			}
			
			
			
			@Test(priority=2)
			void testDelete11() {
				given()
				
				.when()
				.delete(" http://localhost:3000/users/23")
				.then()
				.statusCode(200);
			}
}
