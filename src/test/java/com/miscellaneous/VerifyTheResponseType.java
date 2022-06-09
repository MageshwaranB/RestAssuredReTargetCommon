package com.miscellaneous;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class VerifyTheResponseType
{
	/*
	 * If we want to know what type of response is being received, we can make use of instance of method
	 */
	public static void main(String[] args) {
		/*
		 * "" on the body means everything from response, we can also use $ to represent the same thing 
		 * If the response coming from the api is a map, but we have mentioned list as the 
		 * expected result it will throw an error
		 */
		System.out.println("To verify the response is Json object i.e. Map");
		RestAssured.given()
					.get("https://run.mocky.io/v3/007c79fa-f849-44fd-8c07-21985b9f262f")
					.then()
					.body("", Matchers.instanceOf(Map.class));
		
		System.out.println("To verify the response is Json Array i.e. List");
		RestAssured.given()
					.get("https://run.mocky.io/v3/73214d4b-381c-49bd-bb3e-f271257b4593")
					.then()
					.body("", Matchers.instanceOf(List.class));
		
		System.out.println("Verifying the response is Json Array inside a json object");
		RestAssured.given()
		.get("https://run.mocky.io/v3/007c79fa-f849-44fd-8c07-21985b9f262f")
		.then()
		.body("side_kicks", Matchers.instanceOf(List.class));
	}
}
