package apiTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.ResponsePojo;

public class OuthTest {
	
	@Test
	public void UnlockTest() {
		
		Response response = RestAssured.given()
			.formParam("client_id", "TestAPI13jan")
			.formParam("client_secret", "9a2e98075210358c1b55e63b1c84944c")
			.formParam("grant_type","client_credentials")
			.post("http://coop.apps.symfonycasts.com/token");
		

		System.out.println(response.getStatusCode());
		String token = response.jsonPath().get("access_token");
		
		Response resp = RestAssured.given()
						.auth()
						.oauth2(token)
						.post("http://coop.apps.symfonycasts.com/api/1633/eggs-collect");
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getBody().asPrettyString());
		ResponsePojo responsePojo = resp.getBody().as(ResponsePojo.class);
		Assert.assertEquals(true, responsePojo.getSuccess());
	}
	
	//@Test
	public void UnlockTest1() {
		
		Response response = RestAssured.given()
			.header("Authorization", "Bearer "+"9a2e98075210358c1b55e63b1c84944c")
			.post("http://coop.apps.symfonycasts.com/api");
		

		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
	}
}
