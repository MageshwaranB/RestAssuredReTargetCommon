package datashare;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import groovy.transform.ASTTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateBookingTest {
	/*
	 * There's another way to share data among the test methods using ITestContext.
	 * ItestContext is an interface which can help us to store the data
	 * ITestContext will help us to share the data among the test method if and only if
	 * those classes mentioned under the same test tag in the .xml file
	 */
	
	@Test
	public void createBooking(ITestContext context) {
		int bookingId=RestAssured.given()
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+ "    \"firstname\" : \"Jim\",\r\n"
						+ "    \"lastname\" : \"Brown\",\r\n"
						+ "    \"totalprice\" : 111,\r\n"
						+ "    \"depositpaid\" : true,\r\n"
						+ "    \"bookingdates\" : {\r\n"
						+ "        \"checkin\" : \"2018-01-01\",\r\n"
						+ "        \"checkout\" : \"2019-01-01\"\r\n"
						+ "    },\r\n"
						+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
						+ "}")
				.log().all()
			.when()
				.post("https://restful-booker.herokuapp.com/booking")
			.then()
				.log().all()
				.extract()
				.jsonPath()
				.getInt("bookingid")
				;
		//below code is similar to what we did with map
		context.setAttribute("bookingid", bookingId);
	}
}
