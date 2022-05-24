package pojoExamples.jsonToJavaObjects;

import io.restassured.RestAssured;

public class SimpleJsonResponseToPojo
{
	/*
	 * In the earlier examples where we set values for each fields, now it's just an inverse
	 * where we need to retrieve the response. This process is called deserialization
	 * Using as method, we can perform deserialization. In the as method, mention the type of
	 * class to which deserialization has to be performed
	 */
	public static void main(String[] args) {
		Employee employee = RestAssured.given()
						.log().all()
					.when()
						.get("https://run.mocky.io/v3/d9d8289c-2f31-4893-b589-dd95c7b56b14")
						.as(Employee.class);
	//Using getter method, we can extract the response
		System.out.println(employee.getAge());
		System.out.println(employee.getSalary());
	}
}
