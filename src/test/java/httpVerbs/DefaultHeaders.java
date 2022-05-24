package httpVerbs;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;

public class DefaultHeaders 
{
	@Test
	public void defaultHeaderBehaviour() {
		RestAssured.given()
	/*
	 * What'll happen if we provide the same header name twice
	 * Once you run this below test, you can see instead sending either
	 * one of the header's value, it merges the values i.e send both the values
	 */
					.header("header1","value1")
					.header("header1","value2")
					.log().all()
				.when()
					.get();	
		
	}
	
	@Test
	public void overwriteHeaderBehaviour() {
	/*
	 * We saw in the above test that, if we provide the same header name, it will simply merge the 
	 * two values. But if we don't that then we need to mention it in config method
	 * mention the headername in the overwriteheaderwithname method	
	 * Upon running this test, you can see that the value1 for header1 is been replaced with value2
	 */
		RestAssured.given()
					.config(RestAssuredConfig.config()
							.headerConfig(HeaderConfig.headerConfig()
											.overwriteHeadersWithName("header1","header2")))
					/*
					 * Result of overwriteheaderwithname method
					 *  header1=value2
						header2=value2
						header3=value3
						header3=value4
					 */
		/*
		 * In the below line of config, we're merging the header's value, Also one thing needs to
		 * be considered is that the latest config method only be considered, so we won't overwrite the header
		 * instead we'll just merge the header's value
		 */
					.config(RestAssuredConfig.config().
							headerConfig(HeaderConfig.
									headerConfig().mergeHeadersWithName("header1")))
					.header("header1","value1")
					.header("header1","value2")
					.header("header2","value2")
					.header("header3","value3")
					.header("header3","value4")
					.log().all()
					.when()
					.get()
					;
	}
	
}
