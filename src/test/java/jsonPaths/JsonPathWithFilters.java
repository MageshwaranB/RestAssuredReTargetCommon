package jsonPaths;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathWithFilters {
	
	@Test
	public void jsonPathFiltersEg() {
		/*
		 * We have stored the people.json in a json file and we need to fetch the data first using File class
		 * user.dir will give us the current working directory
		 */
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\jsonPaths\\People.json";
		File jsonArrayFile=new File(filePath);
		/*
		 * And we can pass the File in JsonPath class
		 */
		JsonPath jsonPath=new JsonPath(jsonArrayFile);
		//To get the firstname value present in the index 0 i.e. id = 1
		System.out.println(jsonPath.getString("[0].first_name"));
		//To fetch all the firstname values, use a list
		List<String> allFirstNames = jsonPath.getList("first_name");
		System.out.println(jsonPath.getString("gender"));
		System.out.println(allFirstNames);
		/*
		 * To find the firstname of all the females present
		 * findAll is an expression and inside that mention it which represents the current element, and go one by one.
		 * 
		 */
		
		List<String> filteredFirstNames = jsonPath.getList("findAll{it.gender=='Female'}.first_name");
		System.out.println(filteredFirstNames);
		//To find the email id of a person who's firstname and lastname are lindsay and ferguson respectively
		//To achieve, we need to use find() method
		String filteredEmailWithFind = jsonPath.getString("find{it.first_name=='Lindsay' & it.last_name=='Ferguson'}.email");
		System.out.println(filteredEmailWithFind);
		//Example with OR operator
		List<Object> allLastNameWithOr = jsonPath.getList("findAll{it.first_name=='George' | it.email=='rachel.howell@reqres.in'}.last_name");
		System.out.println(allLastNameWithOr);
		//Printing the details of people whose id is greater than 3
		List<Object> personDetails = jsonPath.getList("findAll{it.id>=3}");
		System.out.println(personDetails);
		
		//to find the size of the json array use size()
		System.out.println(jsonPath.getInt("size()"));
	}
	
	@Test
	public void jsonFiltersEg2() {
		/*
		 * In the above json example, we have used a nested json array but it doesn't have any other fields
		 */
		
		File jsonArrayFileWithDiffHeaders=new File(System.getProperty("user.dir")+"\\src\\test\\java\\jsonPaths\\PeopleWithDataHeader.json");
		JsonPath jsonPath=new JsonPath(jsonArrayFileWithDiffHeaders);
		System.out.println(jsonPath.getInt("page"));
		/*
		 * To find all the females with findall method, notice all the datas are part of a data header
		 */
		//The below line will throw an error because the path mentioned should begin with data
		//List<Object> filteredMales = jsonPath.getList("findAll{it.gender=='Male'}.firstName");
		List<Object> filteredMales = jsonPath.getList("data.findAll{it.gender=='Male'}.first_name");
		System.out.println(filteredMales);
	}
}
