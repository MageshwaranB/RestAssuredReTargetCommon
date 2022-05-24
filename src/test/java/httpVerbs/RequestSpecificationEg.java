package httpVerbs;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.*;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationEg 
{
	public static final String REQRES_BASE_URI="https://reqres.in/api/";
	

	/*
	 * In the below two testcases you can see there are a lot of repetition in the code
	 * To avoid such repetition we can go for requestspecification
	 * In request specification advantages are reusablity
	 */
	
	@Test
	public void createAnUser() {
		RestAssured.given()
						.log().all()
						.baseUri(REQRES_BASE_URI)
						.basePath("users")
						.body("{\"name\" : \"morpheus\",\n "
								+ "\"job\" : \"leader\"}")
					.when()
						.post()
					.then()
						.statusCode(201)
		;
	}

	@Test
	public void updateAnUser() {
		RestAssured.given()
						.log().all()
						.baseUri(REQRES_BASE_URI)
						.basePath("users/2")
						.body("{\"name\" : \"morpheus\",\n "
								+ "\"job\" : \"zion resident\"}")
					.when()
						.patch()
					.then()
						.statusCode(200)
		;
	}

	RequestSpecification reqSpec;
	
	@BeforeClass
	public void setup() {
		reqSpec=RestAssured.given();
		reqSpec.log().all()
				.baseUri(REQRES_BASE_URI)
				;
	}
	
	
	@Test
	public void createUserWithReqSpec() {
		RestAssured.given()
					.spec(reqSpec)
					.basePath("users")
					.body("{\"name\" : \"morpheus\",\n "
							+ "\"job\" : \"leader\"}")
				.when()
					.post()
				.then()
					.statusCode(201)
					;
	}
	
	@Test
	public void updateAnUserWithReqSpec() {
		RestAssured.given()
						.spec(reqSpec)
						.basePath("users/2")
						.body("{\"name\" : \"morpheus\",\n "
								+ "\"job\" : \"zion resident\"}")
					.when()
						.patch()
					.then()
						.statusCode(200)
		;
	}
}
