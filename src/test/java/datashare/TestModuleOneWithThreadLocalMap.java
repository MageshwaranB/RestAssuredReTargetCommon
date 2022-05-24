package datashare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestModuleOneWithThreadLocalMap
{	
	@Test(priority = 1)
	public void createBooking() {
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
		ThreadLocalDatastoreAsMap.setValue(Constants.BOOKING_ID, bookingId);
		System.out.println("Thread ID is -------> "+Thread.currentThread().getId() +"\n"
				+"BookingId created is -----> "+ThreadLocalDatastoreAsMap.getValue(Constants.BOOKING_ID));
	}
	
	@Test(priority = 2)
	public void retreiveBookingId() {
		System.out.println("Thread ID is -------> "+Thread.currentThread().getId() +"\n"
				+"BookingId retreived is -----> "+ThreadLocalDatastoreAsMap.getValue(Constants.BOOKING_ID));
		Integer bookingIdReceived = (Integer) ThreadLocalDatastoreAsMap.getValue(Constants.BOOKING_ID);
		
		Response response = RestAssured.given()
						.log().all()
					.when()
						.get("https://restful-booker.herokuapp.com/booking/"+bookingIdReceived)
					.then()
						.log().all()
						.extract()
						.response();
	}
}
