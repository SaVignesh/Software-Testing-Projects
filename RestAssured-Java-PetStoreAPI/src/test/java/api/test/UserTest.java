package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import com.github.javafaker.Faker;

import api.endpoints.UserEndpoint;
import api.payload.User;
import io.restassured.response.Response;


public class UserTest {
	Faker faker;
	User userPayload;
	
	public Logger logger;

	@BeforeClass
	public void setup()
	{
		faker = new Faker();
		userPayload = new User();
		
		//Setting random user data to userPayload
		userPayload.setId(Integer.parseInt(faker.number().digits(4)));
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1)
	public void testPostUser()
	{
		logger.info("------------------Creating User-----------------");
		Response response = UserEndpoint.createUser(this.userPayload);
		
		
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("------------------Created User-----------------");
	}
	
	@Test(priority = 2, dependsOnMethods = {"testPostUser"})
	public void testGetUser()
	{
		logger.info("------------------Reading User Info-----------------");
		Response response = UserEndpoint.getUser(this.userPayload.getUsername());
		response.then().statusCode(200).log().body();
		
		logger.info("------------------Completed Reading User Info-----------------");
	}
	
	@Test(priority = 3, dependsOnMethods = {"testPostUser"})
	public void testUpdateUser()
	{
		
		logger.info("------------------Updating User-----------------");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		
		
		Response response = UserEndpoint.updateUser(this.userPayload, this.userPayload.getUsername());
		response.then().statusCode(200).log().body();
		
		Response new_response = UserEndpoint.getUser(this.userPayload.getUsername());

//		
//		JSONObject jo = new JSONObject(new_response.asString());
//		String newFirstName = jo.get("firstName").toString();
//		String newLastName = jo.get("lastName").toString();
//		String newEmail = jo.get("email").toString();
		
		
		Assert.assertEquals(new_response.jsonPath().get("firstName").toString(),
				this.userPayload.getFirstName());
		
		Assert.assertEquals(new_response.jsonPath().get("lastName").toString(), 
				this.userPayload.getLastName());
		
		Assert.assertEquals(new_response.jsonPath().get("email").toString(), 
				this.userPayload.getEmail());
		
		
		new_response.then().log().body();
		logger.info("------------------Updated User-----------------");
	}
	
	@Test(priority = 4, dependsOnMethods = {"testPostUser"})
	public void testDeleteUser()
	{
		logger.info("------------------Deleting User-----------------");
		Response response = UserEndpoint.deleteUser(this.userPayload.getUsername());
		response.then().statusCode(200).log().body();
		logger.info("------------------Deleted User-----------------");
		
		
	}
}
