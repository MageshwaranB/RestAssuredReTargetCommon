package pojoExamples.jsonToJavaObjects;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToPojoDynamicEg {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		/*
		 * Creating a lengthy payload every single time for an api is not a very good 
		 * practice instead we can have a sample payload and update them whenever
		 * we requires them
		 * So the better way is to store the payload in a json file and use that 
		 * whenever we required
		 * 
		 * Object Mapper is a class which can convert JSON to Pojo and vice versa
		 */
		
		ObjectMapper objMapper=new ObjectMapper();
		//To convert a json file to Java object, we have a method called readValue
		Address address = objMapper.readValue(new File(System.getProperty("user.dir") + "/src/resources/address.json"), Address.class);
		System.out.println(address.getCity());
		
	//We can't really change the original JSON file with setters until we manually change it, but it is possible to update the response
		address.setCity("Perth");
	//Object Mapper provides a method named writeValueAsString which provides updated the json
		String updatedJson = objMapper.writeValueAsString(address);
		System.out.println(updatedJson);
	
	//Both the below and above line of code basically produces the same output however the below one produces more formatted json output
		updatedJson=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
		System.out.println(updatedJson);
	}
}
