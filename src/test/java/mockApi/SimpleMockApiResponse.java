package mockApi;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SimpleMockApiResponse 
{
	/*
	 * We usually mock something when the actual live service is yet to be in working state
	 * Mocking a response helps us in cases where services might be down for some period of time 
	 */
	@Test
	public void mockApiUsingDesignerMock() {
	/*
	 * The below URL is made up of mock api. 
	 * Basically it holds a simple json response and returns 200 as the status code
	 */
		RestAssured.given()
					.when()
						.get("https://run.mocky.io/v3/00a0e01d-9ebb-4429-8d19-3a7ca7f7b7a8")
					.then()
						.log().all()
						.statusCode(200)
						.body("id", Matchers.notNullValue());
		
	}
}
