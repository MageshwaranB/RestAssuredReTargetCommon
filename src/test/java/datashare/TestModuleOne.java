package datashare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestModuleOne {
	/*
	 * In the SharingDataThroughCommonClass, we have used a map to store the key for the petId
	 * However if we have multiple classes running at the time and using the map's (declared as private, can't create object) key
	 * is not possible since multiple thread will be running in parallel and overrides the key with a new value
	 * If we run the test classes in parallel, both the GET requests points to booking Id created by the first POST request 
	 * and booking id created by the second POST is getting ignored
	 */
	@Test(priority = 1)
	public void createPetDataSwagger() {
		 
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
		
		//Checking which thread executed the POST request
		System.out.println("Thread ID is -------> "+Thread.currentThread().getId() +"\n"
							+"PetId created is -----> "+DataStoreAsMap.getValue(Constants.PET_ID));
	}
	
	@Test(priority = 2)
	public void retreivePetData() {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Checking which thread executed the GET request
		System.out.println("Thread ID is -------> "+Thread.currentThread().getId() +"\n"
							+"PetId retreived is -----> "+DataStoreAsMap.getValue(Constants.PET_ID));
		
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


