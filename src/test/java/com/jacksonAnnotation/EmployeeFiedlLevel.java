package com.jacksonAnnotation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacksonAnnotationPojo.EmployeeWithFieldLevelAnnotation;

public class EmployeeFiedlLevel 
{
	public static void main(String[] args) throws JsonProcessingException {
		EmployeeWithFieldLevelAnnotation emplo=new EmployeeWithFieldLevelAnnotation();
		/*
		 * Let's take one scenario where we're not providing any address, and to make sure
		 * it doesn't show as null in the output we use NonNull constant in the pojo class
		 * However, if there's a scenario where you don't want any values to be shown also
		 * it is not possible to add more than one annotation in the class level, so
		 * we need to add them to the ones which requires in this case NonNull for address
		 * and NonDefault for isMarried
		 */
		emplo.setAge(30);
		emplo.setFirstName("Mageshwaran");
		//emp.setMarried(false);
		//emp.setAddress("");
		ObjectMapper objMapper=new ObjectMapper();
		String jsonOutput = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emplo);
		System.out.println(jsonOutput);
	}
}
