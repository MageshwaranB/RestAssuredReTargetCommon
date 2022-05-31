package datashare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SharingData 
{
	
	
	@Test(priority = 1)
	public void createPetDataSwagger() {
		/*
		 *  In order to share the data between apis, first extract the data from one api
		 *  Using priority, we are making sure the id is generated before using it to 
		 *  retrieve the data
		 */
		//DataStore.PET_ID is coming from datastore class where we have created integer which is used as global variable
		DataStore.PET_ID = RestAssured.given()
						.log().all()
						.contentType(ContentType.JSON)
						.body("{\r\n"
								+ "  \"id\": 246,\r\n"
								+ "  \"category\": {\r\n"
								+ "    \"id\": 2,\r\n"
								+ "    \"name\": \"Shiba Inu\"\r\n"
								+ "  },\r\n"
								+ "  \"name\": \"Puppy\",\r\n"
								+ "  \"photoUrls\": [\r\n"
								+ "    \"http://www.vetstreet.com/dogs/shiba-inu\"\r\n"
								+ "  ],\r\n"
								+ "  \"tags\": [\r\n"
								+ "    {\r\n"
								+ "      \"id\": 4,\r\n"
								+ "      \"name\": \"cutie\"\r\n"
								+ "    }\r\n"
								+ "  ],\r\n"
								+ "  \"status\": \"available\"\r\n"
								+ "}")
					.when()
						.post("https://petstore.swagger.io/v2/pet")
					.then()
						.log().all()
						.statusCode(200)
						.extract()
						.jsonPath()
						.getInt("id");
		System.out.println(DataStore.PET_ID);
		
		
	}
	
	@Test(priority = 2)
	public void retreivePetData() {
		Response petResponse = RestAssured.given()
				.log().all()
				.contentType(ContentType.JSON)
			.when()
				.get("https://petstore.swagger.io/v2/pet/"+DataStore.PET_ID)
			.then()
				.statusCode(200)
				.extract()
				.response();
		System.out.println(petResponse.asPrettyString());
	}
}
