package com.lombokexamples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

public class ExecutionOfBuilder
{
	public static void main(String[] args) throws JsonProcessingException {
		/*
		 * Instead of writing setters in each line in the programe, we can further optimise
		 * this by using builder annotation
		 * With builder we cannot create a constructor, and at the end we need to
		 * mention build
		 * Also if we don't mention the getter annotation then we will get an exception because
		 * for converting a json object to a pojo object,
		 * we need to have a getter since builder performs the operation similar to setters 
		 * One key thing to note with builder functionality is once we've built it
		 * we cannot edit the value we've set using builder
		 * However, there's work around with this issue, we need to mention toBuilder
		 * in the builder annotation, then with the help of toBuilder() method,
		 * we can edit the values we have set earlier
		 */
		Faker fakeData=new Faker();
		EmployeeBuilder builder=EmployeeBuilder.builder()
												.firstName(fakeData.name().firstName())
												.lastName(fakeData.name().lastName())
												.age(fakeData.number().numberBetween(1, 100))
												.mailId(fakeData.internet().emailAddress())
												.build()
												;
		ObjectMapper map=new ObjectMapper();
		String dataString=map.writerWithDefaultPrettyPrinter().writeValueAsString(builder);
		System.out.println(dataString);
		
		EmployeeBuilder empBuilder=builder.toBuilder().firstName(fakeData.funnyName().name()).build();
		String dataString2=map.writerWithDefaultPrettyPrinter().writeValueAsString(empBuilder);
		System.out.println(dataString2);
	}
}
