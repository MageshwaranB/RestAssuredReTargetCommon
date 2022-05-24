package jsonPaths;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathIntro {
	/*
	 * JSONPath is a query language for JSON, similar to XPath for XML. It allows
	 * you to select and extract data from a JSON document. You use a JSONPath
	 * expression to traverse the path to an element in the JSON structure
	 * Rest Assured uses Grovy's GPath notation.
	 * 
	 * Basic Rules
	 * Root node is represented by a $
	 * Child node is represented by a .
	 * We can't use a square bracket [] to represent a child node
	 */
	
	@Test
	public void jsonpathDemo() {
		String json="{\"firstname\" : \"magesh\",\n"
				+ "\"lastname\" : \"balraj\",\n"
				+ "\"age\": 23    }";
		
		//Get the instance of the given json document
		JsonPath path=new JsonPath(json);
		System.out.println(path.getString("firstname"));
		Object age = path.get("age");
		System.out.println(age);
		int ageInt=path.getInt("age");
		System.out.println(ageInt);
		
		//$ Represents the root. This will give us the entire root values
		System.out.println((Object)path.get("$"));
		System.out.println(path.getString("$"));
		
	}
}
