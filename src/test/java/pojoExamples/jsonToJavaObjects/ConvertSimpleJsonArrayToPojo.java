package pojoExamples.jsonToJavaObjects;

import io.restassured.RestAssured;

public class ConvertSimpleJsonArrayToPojo
{
	public static void main(String[] args) {
	/*
	 * Since the response we'll be getting back is an array, we cannot write the same way as we did previously
	 * we need to explicitly mention the [] to represent an array
	 */
		Address[] address = RestAssured.get("https://run.mocky.io/v3/9e808556-c344-45c8-b1fc-6b09fe5234ff")
					.as(Address[].class);
		System.out.println("No of addresses: "+address.length);
		
		System.out.println(address[0].getCity());
		System.out.println(address[1].getCity());
	}
}
