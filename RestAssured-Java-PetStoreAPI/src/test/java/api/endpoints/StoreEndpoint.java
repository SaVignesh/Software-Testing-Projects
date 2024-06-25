package api.endpoints;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;

import api.payload.Order;
import io.restassured.response.Response;

public class StoreEndpoint {
	
	public static Response createOrder(Order payload)
	{
		Response response = given()
				.contentType("application/json")
				.accept("application/json")
				.body(payload)
				.when()
			.post(URLs.store_post_url);
		
		return response;
	}
	
	public static Response getOrder(int orderID)
	{
		Response response = given()
		.accept("application/json")
		.pathParam("orderID", orderID)
			
		.when()
		.get(URLs.store_get_url);
		
		return response;
	}
	
	public static Response deleteOrder(int orderID)
	{
		Response response = given()
		.contentType("application/json")
		.accept("application/json")
		.pathParam("orderID", orderID)
		.when()
		.delete(URLs.store_delete_url);
		
		return response;
	}

}
