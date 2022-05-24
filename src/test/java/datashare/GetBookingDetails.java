package datashare;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingDetails 
{
	@Test
	public void getBooking(ITestContext context) {
		Response response = RestAssured.given()
				.log().all()
			.when()
		//Using getAttribute and passing the key name, to get the booking id
				.get("https://restful-booker.herokuapp.com/booking/"+context.getAttribute("bookingid"))
			.then()
				.log().all()
				.extract()
				.response();
		
		/*
		 * if we run this test, the booking id won't be received instead we'll be getting a null value
		 * We need to run both create and getbooking test parallelly
		 */
	}
}
