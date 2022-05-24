package pojoExamples.nestedJsonObjects;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class CreateNestedJsonObjectPayloadWithJsonArray 
{
	public static void main(String[] args) {
	/*
	 * First create the object of the parent class EmployeeArray since we have
	 * modified it to hold the list of address
	 */
		EmployeeArray emp=new EmployeeArray();
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
		
		EmployeeAddress address2=new EmployeeAddress();
		address2.setHouseNo(420);
		address2.setStreetName("Kamaraj road 3rd street");
		address2.setCity("NCR");
		address2.setState("Delhi");
		address2.setCountry("India");
	
	List<EmployeeAddress> addresses=new ArrayList<>();
	addresses.add(address);
	addresses.add(address2);
	
		emp.setAddress(addresses);
		
		emp.setProfession("Cartoonist");
		emp.setMarried(false);
	
		RestAssured.given()
						.log().all()
						.body(emp)
					.when()
						.get()
					.then()
						;
		/*
		 * If we remove the json schema validator dependencies, it will throw an exception 
		 * named MarshallException
		 * 
		 *  REST Assured will serialize the object to JSON since the request content-type is set to "application/json". 
		 *  It will first try to use Jackson if found in classpath and if not Gson will be used. 
		 *  If you change the content-type to "application/xml" REST Assured will serialize to XML using JAXB. 
		 *  If no content-type is defined REST Assured will try to serialize in the following order:

				JSON using Jackson 2 (Faster Jackson (databind))
				JSON using Jackson (databind)
				JSON using Gson
				JSON using Johnzon
				JSON-B using Eclipse Yasson
				XML using Jakarta EE
				XML using JAXB
		
		We didn't get the exception because the Json Schema Validator dependency has a 
		transitive dependencies for Jackson {check the maven dependencies folder}
		If we want to know what are all the transitive dependencies which were added to the 
		project, open the cmd and type mvn dependency:tree
		
		And if we explicitly add a jackson databind or any other serialization dependencies into our dependencies, automatically
		it will get added.
		 */
	}
}
