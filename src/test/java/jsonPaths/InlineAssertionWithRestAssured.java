package jsonPaths;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class InlineAssertionWithRestAssured {
	@Test
	public void withoutInlineAssertionEg() {
		String jsonResponse="";
		jsonResponse=RestAssured.given()
						.baseUri("https://restful-booker.herokuapp.com/")
						.basePath("auth")
						.body("{\"username\" : \"admin\",\r\n"
								+ "    \"password\" : \"password123\"}")
						.contentType(ContentType.JSON)
						.log().all()
					.when()
						.post()
					.then()
						.log().all()
						.extract()
						.asString()
						;
		JsonPath jsonPath=new JsonPath(jsonResponse);
		//System.out.printf(jsonPath.get("token"));
		Assert.assertNotNull(jsonPath.get("token"));
	}
	
	@Test
	public void inlineAssertionEg() {
		/*
		 * Inline assertion we make use of matchers for performing assertions
		 */
		RestAssured.given()
						.baseUri("https://restful-booker.herokuapp.com/")
						.basePath("auth")
						.body("{\"username\" : \"admin\",\r\n"
								+ "    \"password\" : \"password123\"}")
						.contentType(ContentType.JSON)
						.log().all()
					.when()
						.post()
					.then()
						.log().all()
						.body("token", Matchers.notNullValue())
						.body("token.length()", Matchers.is(15))//using length we're evaluating the length of the token's response
						.body("token", Matchers.matchesRegex("^[a-z0-9]+$"))//we're checking whether response contains a-z alphabets in lowercase and also 0-9 numbers using regex
						;
	}
	
	@Test
	public void inlineAssertionEg2() {
		/*
		 * Response will return an object array and we're using hasItems to check whether
		 * the mentioned bookingids present in the response or not
		 */
		RestAssured.given()
						.log().all()
					.when()
						.get("https://restful-booker.herokuapp.com/booking")
					.then()
						.body("bookingid", Matchers.hasItems(3,4))
						.log().all()
						;
	}
}
