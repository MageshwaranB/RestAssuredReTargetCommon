package pojoExamples.jsonToJavaObjects;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ConvertJsonArrayToPojoEg2 
{
	public static void main(String[] args) {
		/*
		 * In the previous example, we have used array to convert the simple json array to pojo
		 * but this is good if only we have simple json array, so it is better to use a list
		 * Since we cannot directly pass the generics in the as method, we need to the anonymous inner class
		 * called TypeRef in there pass the List<Address>
		 */
		List<Address> address = RestAssured.given()
					.when()
						.get("https://run.mocky.io/v3/9e808556-c344-45c8-b1fc-6b09fe5234ff")
						.as(new TypeRef<List<Address>>() {
						});
		System.out.println(address.size());
		System.out.println(address.get(0).getStreetName());
		System.out.println(address.get(1).getStreetName());
		for (Address address2 : address) {
			System.out.println(address.get(0).getApartmentName());
		}
		address.stream().map(x->x.getCity())
						.forEach(x->System.out.println(x));
	}
}
