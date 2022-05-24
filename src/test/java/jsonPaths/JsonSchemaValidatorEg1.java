package jsonPaths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidatorEg1 
{
	@Test
	public void jsonSchemaValidationUsingReqres() {
		RestAssured.given()
					.when()
						.get("https://reqres.in/api/users/2")
					.then()
						.statusCode(200)
						.log().all()
						.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("GetUserSchema.json"));
	}
}
