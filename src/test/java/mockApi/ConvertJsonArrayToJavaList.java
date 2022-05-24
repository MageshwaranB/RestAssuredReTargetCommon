package mockApi;

import java.util.List;import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertJsonArrayToJavaList 
{
	@Test
	public void deserializationForList() {
		/*
		 * We can convert a json array to list
		 */
		List<Object> allEmp=RestAssured.given()
					.when()
					.get("https://run.mocky.io/v3/b869f5a0-ce87-47a3-959e-43005765d02d")
					.as(List.class);
		System.out.println(allEmp.size());
		Map<String, Object> firstEmp=(Map<String, Object>) allEmp.get(0);
		System.out.println(firstEmp.get("email"));
	}
	
	@Test
	public void deserializationForListWithoutSuppressWarnings() {
		List<Map<String, Object>> allEmp=RestAssured.given()
					.when()
						.get("https://run.mocky.io/v3/b869f5a0-ce87-47a3-959e-43005765d02d")
						.as(new TypeRef<List<Map<String, Object>>>() {
						});
		
		allEmp.forEach(System.out::println);
	}
}
