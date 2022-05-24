package pojoExamples.jsonToJavaObjects;

import io.restassured.RestAssured;

public class ReqresGettingUserData 
{
	public static void main(String[] args) {
		User userData = RestAssured.given()
						.log().all()
					.when()
						.get("https://reqres.in/api/users/2")
						.as(User.class)
						;
		
		System.out.println(userData.getData().getFirstName());
		System.out.println(userData.getData().getId());
		System.out.println(userData.getSupport().getUrl());
		
	}
}
