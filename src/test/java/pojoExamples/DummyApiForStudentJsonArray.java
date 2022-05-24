package pojoExamples;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class DummyApiForStudentJsonArray 
{	
	public static void main(String[] args) {
//To make use of Student class, we first need to create an object then pass it as a payload
/*
 * For creating json array with a consideration that api has the same property, then we don't need to create
 * a separate class, instead create another object for the class and add them to a list
 */
		
		Student student=new Student();
		
		student.setFirstName("Magesh");
		student.setLastName("Balraj");
		student.setAccountNo(134752);
		student.setSalary(23750.76);
		student.setEmail("zombieland@nodeadyet.com");
		student.setMarried(false);
		
		Student student2=new Student();
		student2.setFirstName("Mickey");
		student2.setLastName("Mouse");
		student2.setAccountNo(405122);
		student2.setEmail("wepaynotax@mickey.com");
		student2.setMarried(true);
		student2.setSalary(500000.00);
		
		List<Student> studentList=new ArrayList<>();
		studentList.add(student);
		studentList.add(student2);
		
		RestAssured.given()
				      .log().all()
				      .body(studentList)
				   .when()
				   		.get()
				   .then()
				   		.log().all()
						;
	}
}
