package httpVerbs;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequestExample
{
	/*
	 * Put request is used to update or create a new resource
	 * It replaces the current representation of the resource with the new request payload,
	 * if resource is found
	 * When comes to PUT request, we need to send the entire body, assume that we've ten fields
	 * but we only want to update one or two fields, in that case, we have to send all the ten fields
	 * including the 2 fields one wants to update
	 * In the server or database, it will search for the resource, if it's not found, PUT is 
	 * capable of creating a new resource. Why is this resource possible only because
	 * we're sending the entire data (all the fields not only the fields to be updated)
	 * Put request is consider as Idempotent meaning if you're gonna hit the same 
	 * put request one or more times, there'll be no impact
	 * Any request that modifies a data is not consider a safe method so put is not a safe method
	 * 
	 */
	
	public static final String BASE_URI="https://restful-booker.herokuapp.com/";
	
	@Test
	public void updatingBookingUsingPUT() {
		RestAssured.given()
						.log().all()
						.contentType(ContentType.JSON)
						.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")

						//Changing the first name and last name
						.body("{\r\n"
								+ "    \"firstname\" : \"Magesh\",\r\n"
								+ "    \"lastname\" : \"Balraj\",\r\n"
								+ "    \"totalprice\" : 111,\r\n"
								+ "    \"depositpaid\" : true,\r\n"
								+ "    \"bookingdates\" : {\r\n"
								+ "        \"checkin\" : \"2018-01-01\",\r\n"
								+ "        \"checkout\" : \"2019-01-01\"\r\n"
								+ "    },")
						
						
					.when()
						.put(BASE_URI+"booking/1")
					.then()
						.statusCode(200)
						.log().all()
						;
	}
	
	public static final String REQRES_BASE_URI="https://reqres.in/api/";
	
	@Test
	public void putEgWithReqres() {
		RestAssured.given()
						
						.body("{\"name\" : \"morpheus\",\n "
								+ "\"job\" : \"zion resident\"}")
					.when()
						.put(REQRES_BASE_URI+"users/2")
					.then()
						.statusCode(200)
		;
	}
	public static final String JSONPH_BASE_URL="https://jsonplaceholder.typicode.com/posts/1";
	
	@Test
	public void putEgWithJSONPlaceHolder() {
		RestAssured.given()
						.log().all()
						.header("Content-Type", "application/json")
						.body("{ \"id\" : \"1\",\n"
								+ "\"title\" : \"james bond\",\n"
								+ "\"body\" : \"bar\",\n"
								+ "\"userId\" : \"1\" "
								+ "}")
					.when()
						.put(JSONPH_BASE_URL)
					.then()
						.statusCode(200)
					;
	}
}
