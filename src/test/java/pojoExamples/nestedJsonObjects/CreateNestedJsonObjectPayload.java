package pojoExamples.nestedJsonObjects;

import io.restassured.RestAssured;

public class CreateNestedJsonObjectPayload 
{
	public static void main(String[] args) {
	/*
	 * First create the object of the parent class Employee
	 */
		Employee emp=new Employee();
		emp.setFirstName("Marky");
		emp.setLastName("Bond");
		
	/*
	 * Before setting the address in the parent class, we first need to 
	 * create an object of address class and then pass it in the setter
	 */
		EmployeeAddress address=new EmployeeAddress();
		address.setHouseNo(320);
		address.setStreetName("Seaside road 3rd street");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		emp.setAddress(address);
		
		emp.setProfession("Cartoonist");
		emp.setMarried(false);
		
		RestAssured.given()
						.log().all()
						.body(emp)
					.when()
						.get()
					.then()
						;
	}
}
