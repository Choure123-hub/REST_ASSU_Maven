package Rest_assured_Practice;

import com.github.scribejava.core.model.Response;

import groovyjarjarantlr.collections.List;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class EmpId_15_300 {
public static void main(String[] args) {
	   public static void main(String[] args) {
	        // Base URI of the GoRest API
	        RestAssured.baseURI = "https://gorest.co.in/public/v2";

	        // Send GET request to the users endpoint
	        Response response = RestAssured.given()
	            .header("Authorization", "Bearer YOUR_ACCESS_TOKEN")
	            .get("/users");

	        // Get the response body as a JsonPath object
	        JsonPath jsonPath = response.jsonPath();

	        // Extract employee IDs in the range of 15 to 300
	        List<Integer> employeeIDs = jsonPath.getList("data.findAll { it.id >= 15 && it.id <= 300 }.id");

	        // Print the employee IDs
	        System.out.println("Employee IDs from 15 to 300: " + employeeIDs);
	    }
}
}
