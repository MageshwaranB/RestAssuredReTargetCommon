package com.miscellaneous;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UploadAFileThroughRestAssured
{
	/*
	 * If we want to upload a file, we can make use of method named multipart
	 * multipart method takes three paramter
	 * 1. name of the file (key)
	 * 2. location in which the file is located (value). We need to create a File class
	 * and fetch it from there
	 * 3. Content type of the request
	 * 
	 */
	public static RequestSpecification reqspecEx() {
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri("https://the-internet.herokuapp.com/");
		builder.setBasePath("upload");
		RequestSpecification reqSpec=builder.build();
		return reqSpec;
	}
	
	@Test
	public void uploadFile(){
		File file=new File(System.getProperty("user.dir")+"\\src\\resources\\dummyimage.jpg");
		Response response=RestAssured.given()
						.spec(reqspecEx())
						.multiPart("file",file,"multipart/form-data")
						.log().all()
					.when()
						.post()
					.thenReturn()
					;
		System.out.println(response.getStatusCode());
	}
	
	/*
	 * To download a file, we first need to get the response using ByteArray
	 * and with the help of File class, we can store in the desired location
	 */
	
	@Test
	public void downloadingFile() throws IOException {
		Response resultenData=RestAssured.given()
						.log().all()
					.when()
						.get("https://reqres.in/api/users")
					.andReturn();
		byte[] bytes=resultenData.getBody().asByteArray();
		File file=new File("./src/resources/usersinfo.json");
		Files.write(bytes, file);
	}
}

