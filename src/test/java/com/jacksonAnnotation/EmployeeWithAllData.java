package com.jacksonAnnotation;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacksonAnnotationPojo.Employee;

public class EmployeeWithAllData 
{
	public static void main(String[] args) throws JsonProcessingException {
			Employee emp=new Employee();
		/*
		 * In the first scenario we're setting every fields with some value
		 */
			emp.setAge(24);
			emp.setName("Sachin");
			emp.setAddress("Canada");
			emp.setMobileNo("6632123451");
			emp.setMarried(true);
		
			ObjectMapper objMapper=new ObjectMapper();
			String formattedJson = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
			System.out.println(formattedJson);
		/*
		 * Now consider a scenario where one doesn't know what value should be send to
		 * age or mobile no, then in that case instead of not seeing that field, we'll get 0 or null
		 * So, if we don't enter the value for age, we just need to exclude that from JSON
		 */
		/*
		 * Not providing any value for age and mobileNo since we've added
		 * the JsonInclude annotation for the Employee class and set it to a non default
		 * value
		 */
		
			Employee emp2=new Employee();
			//emp.setAge(24);
			emp2.setName("Dhoni");
			emp2.setAddress("Canada");
			//emp.setMobileNo("6632123451");
			emp2.setMarried(true);
			
			String excludedJsonNonDefault = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp2);
			System.out.println(excludedJsonNonDefault);
			
			/*
			 * In some cases, we might run into situation where the default values are totally valid
			 * like in the case married, if we set it to false, it won't be displayed in the response
			 * To avoid that, we can use NonNull in the @JsonInclude
			 */
			Employee emp3=new Employee();
			emp3.setAge(0);
			emp3.setName("Dravid");
			//emp3.setAddress("California");
			emp3.setMarried(false);
			emp3.setMobileNo("5735126642");
			String excludedJsonNonNull = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp3);
			System.out.println(excludedJsonNonNull);
			
		/*
		 * Consider another scenario where we have a empty list or map, then in that case
		 * we'll only see an empty array, to avoid that we need to use Non_Empty in the @JsonInclude
		 */
			Employee emp4=new Employee();
			emp4.setAge(0);
			emp4.setName("Dravid");
			//emp4.setAddress("California");
			emp4.setMarried(false);
			emp4.setMobileNo("5735126642");
			emp4.setSkillSets(new ArrayList<>());
			emp4.setFamilyMembers(new HashMap<>());
			String excludedJsonNonEmpty = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp4);
			System.out.println(excludedJsonNonEmpty);
			
			/*
			 * By following this approach, then there'll be problem where we need to have 
			 * a mixture of all of them, then it is not possible to include everything in the class
			 * level since we can only add one @JsonInclude annotation at the class level
			 * Therefore we need to add them in the properties
			 */
	}
}
