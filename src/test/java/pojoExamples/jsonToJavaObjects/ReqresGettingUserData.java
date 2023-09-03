package pojoExamples.jsonToJavaObjects;

import io.restassured.RestAssured;

public class ReqresGettingUserData 
{
	public static void main(String[] args) {
		User userData = RestAssured.given()
						.log().all()
					.when()
						.get("https://reqres.in/api/users")
						.as(User.class)
						;
		
		userData.getData().forEach(a->System.out.println(a.getEmail()));
		System.out.println(userData.getData().get(0).getFirstName());
//		System.out.println(userData.getData().getFirstName());
//		System.out.println(userData.getData().getId());
//		System.out.println(userData.getSupport().getUrl());
		
		User userData2 = RestAssured.given()
				.log().all()
			.when()
				.get("https://reqres.in/api/users/1")
				.as(User.class)
				;
		
		//System.out.println(userData2.getSimpleData());
		
	}
}
