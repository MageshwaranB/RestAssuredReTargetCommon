package com.lombokexamples;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExcecutionOfEmployee {
	public static void main(String[] args) throws JsonProcessingException {
		EmployeeLombok emp=new EmployeeLombok();
		/*
		 * We need to add Lombok plugin in order to use the setters and getters methods
		 */
		
		
		emp.setName("Sachin");
		emp.setMobNo("5587323");
		emp.setAge(12);
		
		AddressMap address=new AddressMap();
		address.setDoornNo(126);
		address.setStreetName("Lakeside view apartments");
		address.setCity("Chennai");
		address.setState("TN");
		
		List<AddressMap> addresses=new LinkedList<>();
		addresses.add(address);
		emp.setAddress(addresses);
		
		ObjectMapper map=new ObjectMapper();
		String dataString=map.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		System.out.println(dataString);
		
	}
}
