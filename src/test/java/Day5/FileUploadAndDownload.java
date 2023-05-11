package Day5;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadAndDownload 
{
	@Test(priority=1)
void SingleFileUpload() 
{
		File myfile=new File("C:\\API-Practice\\Test1.txt.txt");
	given()
      .multiPart( "file"  ,myfile)
	 .contentType("multipart/form-data")
	.when()
	.post("http://localhost:8080/uploadFile")
	
	.then()
	.statusCode(200)
.body("fileName", equalTo("Test1.txt.txt"))
	.log().all();

}
	@Test(priority=2)
void MultipleFilesUpload() 
{
		File myfile1=new File("C:\\API-Practice\\Test1.txt.txt");
		File myfile2=new File("C:\\API-Practice\\Test2.txt.txt");
		
		//File filearr[]= {myfile1,myfile2 };
	given()
      .multiPart("files", myfile1)
      .multiPart( "files"  ,myfile2)
	 .contentType("multipart/form-data")
	.when()
	.post("http://localhost:8080/uploadMultipleFiles")
	
	.then()
	.statusCode(200)
	.body("[0].fileName",equalTo("Test1.txt.txt"))
	.body("[1].fileName",equalTo("Test2.txt.txt"))
	.log().all();

}
@Test(priority=3)
void FileDownload()
{
	given()
	
	
	.when()
	.get("http://localhost:8080/downloadFile/Test1.txt.txt")
	
	.then()
	.statusCode(200)
	.log().body();
	

}
}
