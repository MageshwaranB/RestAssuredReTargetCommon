package httpVerbs;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequestWithPathParamsParametrized
{
	public static final String BASE_URI="https://restful-booker.herokuapp.com/";
	
	@Test
	public void pathParamsUsingNamedParameters() {
	/*
	 * Whatever process we've done to send the endpoint through pathparams is called named parameters
	 * because we've given names like basepath and bookingid	
	 */
		RestAssured.given()
						.log().all()
						.baseUri(BASE_URI)
						.basePath("{basePath}/{bookingId}")
						.pathParam("basePath", "booking")
						.pathParam("bookingId", 2)	
					.when()
						.get()
					.then()
						.statusCode(200)
						.log().all()
						;	
	}
	
	@Test
	public void pathParamsUsingInlineParameters() {
		/*
		 * Inline parameter is another way to pass parameters but without actually providing any names
		 * Instead of providing the base path and base uri separately under the given, we can make use of the
		 * overloaded get method, we mention it
		 * How it works is that, we need to provide the values to be dynamic in curly braces and
		 * once we're done writing the url, we need to provide the values based on the indexes
		 * For example: In the below code {basePath} corresponds to first index and value for it is booking which is a string
		 * similarly {bookingId} corresponds to second index and value is 2 which is of type Integer
		 */
			RestAssured.given()
							.log().all()		
						.when()
							.get(BASE_URI+"{basePath}/{bookingId}",
									"booking", 2)
			//				.get(BASE_URI+"{basePath}/{bookingId}", 2,"booking) ->will throw an error because the index is different
						.then()
							.statusCode(200)
							.log().all()
		;	
	}
	
	
	@Test
	public void pathParamsUsingCombiningNamedAndInlineParameters() {
		/*
		 * In this we're combining both inline and named parameters
		 */
		/*
		 * How the below code works is, it'll consider whatever there in the path params as the first one
		 * and then what's left in the get will be taken into consideration
		 * In simple terms, the basePath will be replaced by booking and then bookingId will be 
		 * replaced by 2
		 */
		
			RestAssured.given()
					      .log().all()
					      .pathParam("basePath", "booking")
//.pathParam("basePath2", "booking")->Since there's no basepath2 mentioned in url, it will take 
// the two paramter values from the get request
					    .when()
					    	.get(BASE_URI+"{basePath}/{bookingId}", 2)
//.get(BASE_URI+"{basePath}/{bookingId}","token", 2) -> Basically here, the booking id will be replaced by token not by 2
// because value from path params will be replaced first and then the first value from the get method 
//.get(BASE_URI+"{basePath}/{bookingId}","token", 2,"abcd") -> This will throw an exception, because the expected parameter is 2
// but we are providing more than 2

					    	.then()
					    	.statusCode(200)
					    	.log().all()
		;	
	}
	
	Map<String, Object> pathParameter=Map.of("basePath","booking","bookingId",2);
	
	@Test
	public void pathParamsWithMap() {
		/*
		 * We've created a map, and we'll passing the values in pathParams using a map
		 * It's a good approach when we need to multiple parameters at the same time 
		 */
		
		RestAssured.given()
						.baseUri(BASE_URI)
						.basePath("{basePath}/{bookingId}")
						.pathParams(pathParameter)
						.log().all()
					.when()
						.get()
					.then()
						.statusCode(200)
						.log().all()
						;
	}
	
}
