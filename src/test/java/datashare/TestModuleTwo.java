package datashare;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestModuleTwo {
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
