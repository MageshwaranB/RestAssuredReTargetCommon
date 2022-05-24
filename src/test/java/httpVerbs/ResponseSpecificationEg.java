package httpVerbs;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationEg
{
	/*
	 * Similar to RequestSpecification, if we want to remove duplicate lines of code in the response
	 * we can go for ResponseSpecification.
	 */
	
	public static final String REQRES_BASE_URI="https://reqres.in/api/";
	
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
						.log().all()
						.contentType(ContentType.JSON)
						.time(Matchers.lessThan(6000L))
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
					.log().all()
					.contentType(ContentType.JSON)
					.time(Matchers.lessThan(6000L))
		;
	}
	
	ResponseSpecification resSpec;
	/*
	 * Unlike RequestSpecification, where we RestAssured.given() returns the RequestSpecification object
	 * For ResponseSpecification, we need to use RestAssured.expect(). expect() method returns the 
	 * responseSpecification object
	 */
	@BeforeClass
	public void setup() {
		resSpec=RestAssured.expect();
		resSpec.contentType(ContentType.JSON)
				.log().all()
				.time(Matchers.lessThan(5000L))
				.statusCode(Matchers.anyOf(Matchers.equalTo(200),Matchers.equalTo(201)))
				;
	}

	@Test
	public void createAnUserWithResponseSpecification() {
		RestAssured.given()
						.log().all()
						.baseUri(REQRES_BASE_URI)
						.basePath("users")
						.body("{\"name\" : \"morpheus\",\n "
								+ "\"job\" : \"leader\"}")
					.when()
						.post()
					.then()
						.spec(resSpec)
		;
	}

	@Test
	public void updateAnUserWithResponseSpecification() {
		RestAssured.given()
						.log().all()
						.baseUri(REQRES_BASE_URI)
						.basePath("users/2")
						.body("{\"name\" : \"morpheus\",\n "
								+ "\"job\" : \"zion resident\"}")
					.when()
						.patch()
					.then()
						.spec(resSpec)
		;
	}

	
}
