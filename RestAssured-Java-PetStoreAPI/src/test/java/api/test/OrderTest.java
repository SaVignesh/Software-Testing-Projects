package api.test;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;
import com.github.javafaker.Faker;

import api.endpoints.StoreEndpoint;
import api.payload.Order;
import io.restassured.response.Response;



public class OrderTest {
	Faker faker;
	Order orderPayload;
	
	public Logger logger;

	@BeforeClass
	public void setup()
	{
		faker = new Faker();
		orderPayload = new Order();
		
		//Setting random user data to userPayload
		orderPayload.setId(faker.number().numberBetween(0, 10));
		orderPayload.setPetId(faker.number().numberBetween(0, 10));
		orderPayload.setQuantity(faker.number().numberBetween(0, 3));
		orderPayload.setShipDate(LocalDateTime.now().toString());
		
		
		//logs
		logger = LogManager.getLogger(this.getClass());
	}
	
	@Test(priority = 1)
	public void testPostOrder()
	{
		logger.info("------------------Creating Order-----------------");
		Response response = StoreEndpoint.createOrder(this.orderPayload);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("------------------Created Order-----------------");
	}
	
	@Test(priority = 2, dependsOnMethods = {"testPostOrder"})
	public void testGetOrder()
	{
		logger.info("------------------Reading Order Info-----------------");
		Response response = StoreEndpoint.getOrder(this.orderPayload.getId());
		response.then().statusCode(200).log().body();
		
		logger.info("------------------Completed Reading Order Info-----------------");
	}
	
	@Test(priority = 3, dependsOnMethods = {"testPostOrder"})
	public void testDeleteUser()
	{
		logger.info("------------------Deleting Order-----------------");
		Response response = StoreEndpoint.deleteOrder(this.orderPayload.getId());
		response.then().statusCode(200).log().body();
		logger.info("------------------Deleted Order-----------------");
		
		
	}
}
