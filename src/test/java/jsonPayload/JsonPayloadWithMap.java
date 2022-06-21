package jsonPayload;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class JsonPayloadWithMap {
	/*
	 * As we have passed the body as string earlier, that's useful and practical
	 * when we have a small amount of resource but when comes to complex details, Map is preferred
	 * Map takes key and value pair
	 */
	
	@Test
	public void simpleJsonPayloadEg() {
	/*
	 * Created a map which takes string as both key and value
	 */
		Map<String, String> jsonPayload=new HashMap<>();
		jsonPayload.put("first_name", "Magesh");
		jsonPayload.put("last_name", "Balraj");
		jsonPayload.put("designation", "QA");
		jsonPayload.put("salary", "20000");
		jsonPayload.put("married", "false");
		
		RestAssured.given()
						.body(jsonPayload)
						.log().all()
					.when()
						//.get()
					.then()
						.body("first_name", Matchers.is("Magesh"))
					;
		/*
		 * Created a map which takes any value as value using object as the generics
		 */
		Map<String, Object> jsonPayloadObject=new HashMap<>();
		jsonPayloadObject.put("first_name", "Magesh");
		jsonPayloadObject.put("last_name", "Balraj");
		jsonPayloadObject.put("salary", 20000);
		jsonPayloadObject.put("married", false);
		
		RestAssured.given()
						.log().all()
						.body(jsonPayloadObject)
						.get();
	}
	
	@Test
	public void nestedJsonPayload() {
		/*
		 * Using LinkedHashMap so that insertion order is persevered
		 */
		Map<String, Object> jsonPayload=new LinkedHashMap<>();
		jsonPayload.put("first_name", "Magesh");
		jsonPayload.put("last_name", "Balraj");
		jsonPayload.put("designation", "QA");
		jsonPayload.put("salary", 20000);
		jsonPayload.put("married", false);
		/*
		 * We need to add a key address which in turn holds multiple keys inside it 
		 * For this we need to create one new map and store the nested values in it and add that nested 
		 * values to the original map
		 */
		
		Map<String, Object> addressMap=new LinkedHashMap<>();
		addressMap.put("apartment_no", 123);
		addressMap.put("street_name", "Lakeshore 1st street");
		addressMap.put("city", "Chennai");
		addressMap.put("Country", "TamilNadu");
		/*
		 * Adding the addressMap to the jsonPayload Map as a value to the key address
		 */
		
		jsonPayload.put("address", addressMap);
		jsonPayload.put("phone_number", 4562212445L);
		
		RestAssured.given()
						.log().all()
						.body(jsonPayload)
					.when()
						.post()
					;
					
	}
	
}
