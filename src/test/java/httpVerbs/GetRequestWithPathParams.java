package httpVerbs;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequestWithPathParams 
{
	@Test
	public void getRequestRestfulBooker() {
		RestAssured.given()
						.baseUri("https://restful-booker.herokuapp.com/")
						.basePath("booking/{id}")
		/*
		 * For the url "https://restful-booker.herokuapp.com/booking/:id", where the :id represents 
		 * the path parameter which we want. We can achieve it by using pathparams method provided by
		 * rest assured, so we can pass it dynamically rather than hardcoding it
		 */
						.pathParam("id", 1)
						.log().all()
					.when()
						.get()
						
					.then()
						.statusCode(200)
						.log()
						.all()
						;
	}
}
