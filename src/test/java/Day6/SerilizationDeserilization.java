package Day6;
import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Day2.Pojo_PostRequest;



public class SerilizationDeserilization
{

	//@Test
	void convertPojo2Json() throws JsonProcessingException
	{
		
		//created java object using pojo class
		Student stupojo=new Student();  //POJO class object
		stupojo.setName("Scott");
		stupojo.setLocation("France");
		stupojo.setPhone("123456");
		
		String coursesArr[]= {"C","C++"};
		stupojo.setCourses(coursesArr);
		
		//convert java----------> object json object(serialization)
		ObjectMapper ObjMapper=new ObjectMapper();
		
		String jsonData = ObjMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
		System.out.println(jsonData);
	}
	
	
	// json----------------->POJO     (D-Serialization)
	@Test
	void converJson2Pojo() throws JsonProcessingException
	{
		String jsondata="{\r\n"
				+ "  \"name\" : \"Scott\",\r\n"
				+ "  \"location\" : \"France\",\r\n"
				+ "  \"phone\" : \"123456\",\r\n"
				+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
				+ "}";
		//convert json object--------->POJO object
		ObjectMapper ObjMapper=new ObjectMapper();
		
		
		Student stupojo = ObjMapper.readValue(jsondata, Student.class);//convert json to pojo
		
		System.out.println("Names"+stupojo.getName());
		System.out.println("location"+stupojo.getLocation());
		System.out.println("phone"+stupojo.getPhone());
		System.out.println("courses"+stupojo.getCourses()[0]);
		System.out.println("courses"+stupojo.getCourses()[1]);
	}
	
	
	
	
	
}
