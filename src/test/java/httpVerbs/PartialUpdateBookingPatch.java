package httpVerbs;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PartialUpdateBookingPatch
{
	/*
	 * Update only the resource that's need to be updated
	 * Patch is a destructive operation since we're making changes to the existing data in some way,
	 * so it is consider not a safe method
	 */
	public static final String BASE_URI="https://restful-booker.herokuapp.com/";
	
	@Test
	public void putEgWithRestfullBOOKER() {
		RestAssured.given()
						.baseUri(BASE_URI)
						.basePath("booking/{bookingId}")
						.pathParam("bookingId", 1)
						.contentType(ContentType.JSON)
						.body("{\"firstname\" : \"James\",\n"
								+ "\"lastname\" : \"Brown\"}")
						.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
						.log().all()
					.when()
						.patch()
					.then()
						.statusCode(200)
						;
	}
}
