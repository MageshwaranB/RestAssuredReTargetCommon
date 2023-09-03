package com.authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class OAuth2SimpleExample {
	@Test
	public void simpleAuthentication() {
		/*
		 * Pass the access token in the oauth2 method
		 */
		 Response response=RestAssured.given()
						.auth()
						.oauth2("538382a8c9f394ed0f374e8b4fc5dde04ac49219")
					.when()
						.post("http://coop.apps.symfonycasts.com/api/3482/barn-unlock")
						;
		 System.out.println("Status code: "+response.getStatusCode());
		 System.out.println("Body: "+response.getBody().asPrettyString());
	}
	
	String accessToken=null;
	@Test(priority = 1)
	public void generateAccessToken() {
		/*
		 * If we want the token to be generated everytime dynamically instead of
		 * hardcoding. This Api which we're using needs certain client credentials
		 * Whenever we want to pass parameters, we can make use of formParam method
		 */
			Response response=RestAssured.given()
						.formParam("client_id", "OAuth2.0 Example")
						.formParam("client_secret", "d54b94eb79372154edcb0381e50efec8")
						.formParam("grant_type", "client_credentials")
						.when()
							.post("http://coop.apps.symfonycasts.com/token")
						;
			System.out.println(response.getBody().asPrettyString());
			
			//To get the token, just pass the access_token key
			 accessToken=response.jsonPath().get("access_token");
			System.out.println(accessToken);
	}
	
	@Test(priority = 2)
	public void passGenerateToken() {
		/*
		 * If we try to access any endpoints which the access token doesn't have access, it
		 * will not work and end up throwing exception
		 */
		Response response=RestAssured.given()
				.auth()
				.oauth2(accessToken)
			.when()
				.post("http://coop.apps.symfonycasts.com/api/3482/toiletseat-down")//Part of the access token
				//.post("http://coop.apps.symfonycasts.com/api/3482/eggs-collect")//Not part of the access token
				
				;
		System.out.println(response.getBody().asPrettyString());
				Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
}
