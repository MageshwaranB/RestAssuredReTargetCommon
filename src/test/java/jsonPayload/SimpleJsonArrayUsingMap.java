package jsonPayload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SimpleJsonArrayUsingMap 
{
	@Test
	public void simpleJsonArrayMap() {
		Map<String, Object> jsonMap=new LinkedHashMap<>();
		jsonMap.put("id", 1);
		jsonMap.put("first_name", "Ainslie");
		jsonMap.put("last_name", "Kollatsch");
		jsonMap.put("email", "akollatsch0@webnode.com");
		jsonMap.put("gender", "Female");
		
		Map<String, Object> jsonMap2=new LinkedHashMap<>();
		jsonMap2.put("id", 2);
		jsonMap2.put("first_name", "James");
		jsonMap2.put("last_name", "Brown");
		jsonMap2.put("email", "jamesbrown@nojob.com");
		jsonMap2.put("gender", "Male");
		
		/*
		 * To convert the map to an array, first convert the map to a list
		 * We need a list of type Map, so pass the map as generic to the list
		 */
		
		List<Map<String, Object>> allEmp=new ArrayList<>();
		allEmp.add(jsonMap);
		allEmp.add(jsonMap2);
		/*
		 * By passing the list in the body method which in turn takes it as an object. 
		 */
		RestAssured.given()
					  .log().all()
					  .body(allEmp)
					  .get();
		
	}
}
