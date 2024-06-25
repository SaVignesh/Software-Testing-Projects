package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoint;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDDT {

	User userPayload;
	
	public Logger logger = LogManager.getLogger(this.getClass());

	

	
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUserDDT(String id, String username, String firstName, String lastName,
			String email, String password, String phone)
	{
		logger.info("------------------Creating User DDT-----------------");
		userPayload = new User();
		
		userPayload.setId(Integer.parseInt(id));
		userPayload.setUsername(username);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		
		
		Response response = UserEndpoint.createUser(this.userPayload);
		
		
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("------------------Created User DDT-----------------");
	}
	
	
	@Test(priority = 2, dependsOnMethods = {"testPostUserDDT"}, 
			dataProvider = "Username", dataProviderClass = DataProviders.class)
	public void testDeleteUserDDT(String username)
	{
		logger.info("------------------Deleting User DDT-----------------");
		Response response = UserEndpoint.deleteUser(username);
		response.then().statusCode(200).log().body();
		logger.info("------------------Deleted User DDT-----------------");
		
	}
}
