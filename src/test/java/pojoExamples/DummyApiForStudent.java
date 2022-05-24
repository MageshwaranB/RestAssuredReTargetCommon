package pojoExamples;

import io.restassured.RestAssured;

public class DummyApiForStudent 
{	
	public static void main(String[] args) {
//To make use of Student class, we first need to create an object then pass it as a payload
		Student student=new Student();
		
		student.setFirstName("Magesh");
		student.setLastName("Balraj");
		student.setAccountNo(134752);
		student.setSalary(23750.76);
		student.setEmail("zombieland@nodeadyet.com");
		student.setMarried(false);
		
		RestAssured.given()
				      .log().all()
				      .body(student)
				   .when()
				   		.get()
				   .then()
				   		.log().all()
						;
	}
}
