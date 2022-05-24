package pojoExamples.jsonToJavaObjects;

import io.restassured.RestAssured;

public class PartOfNestedObjectsToPojo {
	public static void main(String[] args) {
		Address address = RestAssured.given()
						.log().all()
					.when()
						.get("https://run.mocky.io/v3/59a51c9d-4f55-4f68-9fbb-ae95a3f90c97")
						.jsonPath()
			//With the help of getObject method we have extract the address alone
						.getObject("address", Address.class);
		System.out.println(address.getStreetName());
	}
}
