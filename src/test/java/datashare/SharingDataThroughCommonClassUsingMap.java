package datashare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SharingDataThroughCommonClassUsingMap 
{
	
	
	@Test(priority = 1)
	public void createPetDataSwagger() {
		/*
		 *  In order to share the data between apis, first extract the data from one api
		 *  Using priority, we are making sure the id is generated before using it to 
		 *  retreive the data
		 *  We have a created a map in DataStoreAsMap class which sets and gets value we pass
		 *  Using this approach we don't need to create multiple global variables
		 *  Datatype used for the key will not be known for the co workers so that might become a 
		 *  problem, we can also use constants instead of Map approach
		 */
		 
		int petIdValue = RestAssured.given()
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
		//First Approach with unknown datatype of key
		//DataStoreAsMap.setValue("petId", petIdValue);
		
		//Second Approach with constants
		DataStoreAsMap.setValue(Constants.PET_ID, petIdValue);
		
	}
	
	@Test(priority = 2)
	public void retreivePetData() {
		//Object petIdReceived = DataStoreAsMap.getValue("petId");
		Object petIdReceived = DataStoreAsMap.getValue(Constants.PET_ID);
		Response petResponse = RestAssured.given()
				.log().all()
				.contentType(ContentType.JSON)
			.when()
				.get("https://petstore.swagger.io/v2/pet/"+petIdReceived)
			.then()
				.statusCode(200)
				.extract()
				.response();
		System.out.println(petResponse.asPrettyString());
	}
}
