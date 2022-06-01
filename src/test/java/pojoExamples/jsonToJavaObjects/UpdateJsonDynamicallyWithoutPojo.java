package pojoExamples.jsonToJavaObjects;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UpdateJsonDynamicallyWithoutPojo {
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
		/*
		 * To convert a json file to Java object, we have a method called readValue
		 * If we don't want to use POJO for any updation, there's a overloaded readValue method
		 * which takes TypeReference as an argument, use that.
		 */
		 Map<String, Object> address = objMapper.readValue(new File(System.getProperty("user.dir") + "/src/resources/address.json"), new TypeReference<Map<String,Object>>() {
		});
		System.out.println(address.get("city"));
		
		//To update the the value use put method
		address.put("city", "Mumbai");
		/*
		 * Adding a new field using put method is possible in Map without the need of creating 
		 * a setter and getter in the pojo class 
		 */
		address.put("pin", 12345);
		 String updatedMap = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
		System.out.println(updatedMap);
	
	}
}
