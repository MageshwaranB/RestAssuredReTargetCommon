package com.jacksonAnnotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacksonAnnotationPojo.EmployeeSkills;
import com.jacksonAnnotationPojo.EmployeeWithFieldLevelAnnotation;
import com.jacksonAnnotationPojo.EmployeeWithJsonIncludeProperties;

public class EmployeeWithJsonIncludePropertiesEg 
{
	public static void main(String[] args) throws JsonProcessingException {
		EmployeeWithJsonIncludeProperties emplo=new EmployeeWithJsonIncludeProperties();
		emplo.setAge(30);
		emplo.setName("Mageshwaran");
		emplo.setMarried(false);
		emplo.setAddress("CH");
		emplo.setMobileNo("567733413");
		/*
		 * If we have included the JsonIncludeProperties in the pojo class and set up some fields in the
		 * class, and if we execute the class, we'll only see the fields which are mentioned
		 * in the JsonIncludeProperties
		 */
		ObjectMapper objMapper=new ObjectMapper();
		String jsonOutput = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emplo);
		System.out.println(jsonOutput);
		
		EmployeeSkills skills=new EmployeeSkills();
		skills.setAge(64);
		skills.setSkills("Java");
		skills.setAddress("DL");
		skills.setMobileNo("568234534");
		skills.setName("Rey Mysterio");
		/*
		 * It will print the skills, age, and name in the output because we explicitly mention it
		 * in JsonIncludeProperties
		 */
		
		 jsonOutput = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(skills);
		System.out.println(jsonOutput);
		
	}
}
