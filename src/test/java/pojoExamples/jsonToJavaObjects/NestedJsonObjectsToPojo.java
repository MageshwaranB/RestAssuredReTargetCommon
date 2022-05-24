package pojoExamples.jsonToJavaObjects;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NestedJsonObjectsToPojo
{
	public static void main(String[] args) {
		 EmployeeWithAddress employee = RestAssured.given()
						.log().all()
						
					.when()
						.get("https://run.mocky.io/v3/59a51c9d-4f55-4f68-9fbb-ae95a3f90c97")
						.as(EmployeeWithAddress.class)
						;
		 String firstName = employee.getFirstName();
		 System.out.println(firstName);
		 String apartmentNo = employee.getAddress().getApartmentName();
		 int doorNo = employee.getAddress().getDoorNo();
		 String streetName = employee.getAddress().getStreetName();
		 System.out.println(doorNo+"\n" +apartmentNo +"\n" +streetName +"\n"+employee.getAddress().getCountry());
					
						
	}
}
