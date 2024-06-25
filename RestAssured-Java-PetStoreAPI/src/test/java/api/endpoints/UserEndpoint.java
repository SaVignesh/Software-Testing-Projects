package api.endpoints;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.ITestContext;
import com.github.javafaker.Faker;


import api.payload.User;
import io.restassured.response.Response;




public class UserEndpoint {
	public static Response createUser(User payload)
	{
		Response response = given()
				.contentType("application/json")
				.accept("application/json")
				.body(payload)
				.when()
			.post(URLs.user_post_url);
		
		return response;
	}
	
	public static Response getUser(String username)
	{
		Response response = given()
		.accept("application/json")
		.pathParam("username", username)
			
		.when()
		.get(URLs.user_get_url);
		
		return response;
	}
	
	public static Response updateUser(User payload, String username)
	{
		Response response = given()
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		.pathParam("username", username)
		.when()
		.put(URLs.user_update_url);
		
		return response;
	}
	
	public static Response deleteUser(String username)
	{
		Response response = given()
		.contentType("application/json")
		.accept("application/json")
		.pathParam("username", username)
		.when()
		.delete(URLs.user_get_url);
		
		return response;
	}
	
}
