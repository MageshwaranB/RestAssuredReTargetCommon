package jsonPaths;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathForNestedObjects
{
	@Test
	public void jsonNestedPath() {
		String nestedJsonPath ="{\r\n"
				+ "  \"firstname\": \"Magesh\",\r\n"
				+ "  \"lastname\": \"Balraj\",\r\n"
				+ "  \"address\": {\r\n"
				+ "    \"DoorNo\": 345,\r\n"
				+ "    \"streetname\": \"xyzz\",\r\n"
				+ "    \"City\": \"Chennai\",\r\n"
				+ "    \"State\": \"TamilNadu\"\r\n"
				+ "  },\r\n"
				+ "  \"married\": false\r\n"
				+ "}";
		
		JsonPath path=new JsonPath(nestedJsonPath);
		String flatNo=path.get("address.streetname");
		System.out.println(flatNo);
		int doorNo=path.getInt("address.DoorNo");
		System.out.println(doorNo);
	}
}
