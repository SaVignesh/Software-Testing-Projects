package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndpoint;

import api.payload.Order;

import api.utilities.DataProviders;
import io.restassured.response.Response;

public class OrderTestDDT {
	Order orderPayload;
	
	//logs
	public Logger logger = LogManager.getLogger(this.getClass());
	

	@Test(priority = 1, dataProvider = "Orders", dataProviderClass = DataProviders.class)
	public void testPostOrderDDT(String id, String petId, String quantity)
	{
		
		logger.info("------------------Creating Order DDT-----------------");
		orderPayload = new Order();
		
		orderPayload.setId(Integer.parseInt(id));
		orderPayload.setPetId(Integer.parseInt(petId));
		orderPayload.setQuantity(Integer.parseInt(quantity));
		
		
		
		Response response = StoreEndpoint.createOrder(this.orderPayload);
		
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("------------------Created Order DDT-----------------");
	}
	
	
	@Test(priority = 2, dependsOnMethods = {"testPostOrderDDT"}, 
			dataProvider = "OrderID", dataProviderClass = DataProviders.class)
	public void testDeleteOrderDDT(String orderID)
	{
		logger.info("------------------Deleting Order DDT-----------------");
		Response response = StoreEndpoint.deleteOrder(Integer.parseInt(orderID));
		response.then().statusCode(200).log().body();
		logger.info("------------------Deleted Order DDT-----------------");
		
	}
	
}
