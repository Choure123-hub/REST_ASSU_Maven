package Day7;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



import com.github.javafaker.Faker;

public class FakerDataGenrator 
{
	@Test
void testGenrateDummyData()
{
	Faker faker=new Faker();
	String Fullname = faker.name().fullName();
	String Fristname = faker.name().firstName();
	String Lastname = faker.name().lastName();
	
	String Username = faker.name().username();
	String Password = faker.internet().password();
	
	String monumber = faker.phoneNumber().cellPhone();
	String Emailaddress = faker.internet().safeEmailAddress();
	
	System.out.println("Fullname :"+Fullname);
	System.out.println("Fristname :"+Fristname);
	System.out.println("Lastname: "+Lastname);
	System.out.println("Username: "+Username);
	System.out.println("Password: "+Password);
	System.out.println("monumber: "+monumber);
	System.out.println("Emailaddress: "+Emailaddress);
}
}
