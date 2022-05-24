package jsonPaths;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonArrayEx 
{
	/*
	 * Json Array is a collection of multiple jsons. To access them we need to make use of index
	 * Array should start with [ and ends with ].
	 * keys present in one json may not be present inside another json
	 */
	
	@Test
	public void jsonarraysimpleEg(){
		/*
		 * Example for json array
		 * [
  			"10",
  			"20",
  			"30"
			]
		 */
		
		String simpleJsonArray="[\r\n"
				+ "  \"10\",\r\n"
				+ "  \"20\",\r\n"
				+ "  \"30\"\r\n"
				+ "]";
		JsonPath path=new JsonPath(simpleJsonArray);
		System.out.println(path.getString("[1]"));
		//to find the length of the json array. To get the whole json context we use $ and this will be provided as a list
		System.out.println(path.getList("$").size());
		
		String nestedJsonArray="[\r\n"
				+ "  [\r\n"
				+ "    \"10\",\r\n"
				+ "    \"20\",\r\n"
				+ "    \"30\"\r\n"
				+ "  ],\r\n"
				+ "  [\r\n"
				+ "    \"30\",\r\n"
				+ "    \"10\",\r\n"
				+ "    \"50\",\r\n"
				+ "    \"26\",\r\n"
				+ "    \"79\"\r\n"
				+ "  ]\r\n"
				+ "]";
		JsonPath nestedPath=new JsonPath(nestedJsonArray);
		//Getting the value 26 present inside the second array
		System.out.println(nestedPath.getString("[1][3]"));
		//to find the length of the json array
		System.out.println(nestedPath.getList("$").size());
		//size of the second array
		System.out.println(nestedPath.getList("[1]").size());
	}
	
	@Test
	public void complexJsonArry() {
		String complexNestedJson="[\r\n"
				+ "  {\r\n"
				+ "    \"firstname\": \"Magesh\",\r\n"
				+ "    \"lastname\": \"Balraj\",\r\n"
				+ "    \"address\": [\r\n"
				+ "      {\r\n"
				+ "        \"DoorNo\": 235,\r\n"
				+ "        \"streetName\": \"Xyz street\",\r\n"
				+ "        \"city\": \"Chennai\",\r\n"
				+ "        \"State\": \"TamilNadu\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"DoorNo\": 126,\r\n"
				+ "        \"streetName\": \"abc street\",\r\n"
				+ "        \"city\": \"Hyderabad\",\r\n"
				+ "        \"State\": \"Telangana\"\r\n"
				+ "      }\r\n"
				+ "    ],\r\n"
				+ "    \"Married\": false\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"firstname\": \"Jackson\",\r\n"
				+ "    \"lastname\": \"Durai\",\r\n"
				+ "    \"address\": [\r\n"
				+ "      {\r\n"
				+ "        \"DoorNo\": 420,\r\n"
				+ "        \"streetName\": \"Fake street\",\r\n"
				+ "        \"city\": \"Madurai\",\r\n"
				+ "        \"State\": \"TamilNadu\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"DoorNo\": 450,\r\n"
				+ "        \"streetName\": \"Gentlemen street\",\r\n"
				+ "        \"city\": \"Coimbatore\",\r\n"
				+ "        \"State\": \"TamilNadu\"\r\n"
				+ "      }\r\n"
				+ "    ],\r\n"
				+ "    \"Married\": true\r\n"
				+ "  }\r\n"
				+ "]";
		JsonPath jsonPath=new JsonPath(complexNestedJson);
		System.out.println(jsonPath.getList("$").size());
		System.out.println(jsonPath.getString("firstname[0]"));
		System.out.println(jsonPath.getInt("address[0].DoorNo[0]"));
		List<Object> firstArrayAddress = jsonPath.getList("address[0]");
		firstArrayAddress.forEach(System.out::println);
		System.out.println(firstArrayAddress.size());
		
		System.out.println(jsonPath.getList("address[1]").get(1));
		System.out.println(jsonPath.getString("[0].address.city"));
		System.out.println(jsonPath.getList("address.DoorNo"));
	}
}
