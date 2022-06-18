package mockApi;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertJsonObjectToJavaMap 
{
	/*
	 * The concept of converting json object to java map is called deserialization
	 */
	@Test
	public void simpleDeserializationEg() {
		@SuppressWarnings("unchecked")
		Map<String, Object> jsonResponseAsMap = RestAssured.given()
						.get("https://run.mocky.io/v3/00a0e01d-9ebb-4429-8d19-3a7ca7f7b7a8")
			/*
			 * To convert the given response to a map, we need to use the as() method
			 * Why can we convert this to a map because if we want to create a json object, we need to make use of a map
			 * Similarly the opposite is also true
			 */
						.as(Map.class)
						;
		Object firstName = jsonResponseAsMap.get("first_name");
		System.out.println(firstName);
		//to get all the keys from the response
		jsonResponseAsMap.keySet().forEach(x->System.out.println(x));
		//to get all the values from the response
		jsonResponseAsMap.values().forEach(System.out::println);
	}
	
	@Test
	public void nestedDeserializationEg() {
		@SuppressWarnings("unchecked")
		Map<String, Object> jsonResponseAsMap=RestAssured.given()
				   .when()
					.get("https://run.mocky.io/v3/baa0ad95-beee-4608-ac2b-2764d7141c32")
					.as(Map.class)
				   ;
		Object firstName = jsonResponseAsMap.get("first_name");
		System.out.println(firstName);
	/*
	 * To handle a nested json object, create another map for the nested json object
	 * Since the skills holds another json object, we need to cast that to another map
	 */
	Map<String, Object>	skillSet=(Map<String, Object>) jsonResponseAsMap.get("skills");
	Object skillName = skillSet.get("name");
	System.out.println(skillName);
	System.out.println(skillSet.get("certification_done?"));
	skillSet.keySet().forEach(System.out::println);
	}
	
	@Test
	public void deserializationWithoutSupressWarning() {
		/*
		 * To avoid getting the suppresswarning annontation, we need to mention the generics in as method
		 * We cannot directly mention them, we need to make use of the anonymous inner class known as typeref
		 * If you take a look at that, TypeRef class implementation, it doesn't contain any abstract methods
		 * the only purpose is serve us to pass the generics without the need to suppress the warning messages using annotation 
		 */
		
		Map<String, Object> jsonResponse=RestAssured.given()
					.when()
						.get("https://run.mocky.io/v3/baa0ad95-beee-4608-ac2b-2764d7141c32")
						.as(new TypeRef<Map<String, Object>>() {
						});
			Object firstName = jsonResponse.get("first_name");
			System.out.println(firstName);
						;
	}
}
