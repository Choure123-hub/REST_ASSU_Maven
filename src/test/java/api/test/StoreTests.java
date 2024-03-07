package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.endpoints.UserEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {
	Faker faker;
	Store storePayload;
	public Logger logger;//for logs
	
    @BeforeClass
	public void SetUp() 
	{
		faker=new Faker();
		storePayload=new Store();
		storePayload.setId(faker.idNumber().hashCode());
		storePayload.setPetId(faker.idNumber().hashCode());
		storePayload.setQuantity(faker.idNumber().hashCode());
		storePayload.setShipDate(faker.date().toString());
		
		//logs
		 logger=LogManager.getLogger(this.getClass());
		 logger.debug("debugging.....");
	}
    @Test(priority=1)
	public void testPostUser()
	{
		logger.info("***********************Creating User**************");
		
		Response response=StoreEndPoints.crateUser(storePayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),500);
		
		logger.info("***********************User is Created**************");
	}
    @Test(priority=2)
	public void testGetStorePetId()
	{
		logger.info("********** Reading User Info ***************");
		
		Response response = StoreEndPoints.readUser(storePayload.getPetId(), storePayload);
		response.then().log().all();
		Assert.assertEquals(response .getStatusCode(), 404);
		
		logger.info("**********User info  is displayed ***************");
		
	}
}
