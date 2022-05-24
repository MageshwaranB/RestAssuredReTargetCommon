package mockApi;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HandlingDynamicJsonResponse {
	@Test
	public void dynamicResponseHandling() {
		/*
		 * If we try to retrieve any response whose response type which is dynamic and
		 * we were not sure either it can be an json array or a flat json, then in that
		 * case, if we deserialized to a type incompatible, we will get
		 * MismatchInputException
		 */
		Response response = RestAssured.get("https://run.mocky.io/v3/1bc865e3-1e7d-4796-8b0d-3443d3906daa");
		/*
		 * By running the below lines of code, we'll get the MisMatchedInputException
		 * because Cannot deserialize value of type `java.util.LinkedHashMap
		 * 
		 * Map responseAsMap = response.as(Map.class);
		 * System.out.println(responseAsMap.keySet());
		 */

		/*
		 * Similarily, if we try to deserialize a map into List, it will again throw the
		 * same exception with the message Cannot deserialize value of type
		 * `java.util.ArrayList
		 */
		response = RestAssured.get("https://run.mocky.io/v3/bd67a9ae-ae16-4f15-a197-a638385c6b8e");
		/*
		 * List responseAsList=response.as(List.class);
		 * System.out.println(responseAsList);
		 * 
		 */

	}

	@Test
	public void handlingDynamicResponseUsingInstanceOf() {
		Response response = RestAssured.get("https://run.mocky.io/v3/bd67a9ae-ae16-4f15-a197-a638385c6b8e");
		/*
		 * Since the api is dynamic, we shouldn't convert into a map or list, so convert
		 * it into an object We'll be writing a simple if statement to perform the
		 * deserialization
		 */
		List responseAsList = null;
		Map responseAsMap = null;
		Object responseAsObject = response.as(Object.class);
		if (responseAsObject instanceof List) {
			responseAsList = (List) responseAsObject;
			System.out.println(responseAsList.size());
		} else if (responseAsObject instanceof Map) {
			responseAsMap = (Map) responseAsObject;
			System.out.println(responseAsMap.size());
			System.out.println(responseAsMap.keySet());
		}

		response = RestAssured.get("https://run.mocky.io/v3/1bc865e3-1e7d-4796-8b0d-3443d3906daa");
		responseAsObject = response.as(Object.class);
		if (responseAsObject instanceof List) {
			responseAsList = (List) responseAsObject;
			System.out.println(responseAsList.size());
		} else if (responseAsObject instanceof Map) {
			responseAsMap = (Map) responseAsObject;
			System.out.println(responseAsMap.size());
			System.out.println(responseAsMap.keySet());
		}
	}
}
