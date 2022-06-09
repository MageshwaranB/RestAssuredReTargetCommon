package com.jacksonAnnotationPojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeWithFieldLevelAnnotation {
	private String firstName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String address;
	
	public boolean isMarriedStatus() {
		return marriedStatus;
	}
	public void setMarriedStatus(boolean marriedStatus) {
		this.marriedStatus = marriedStatus;
	}
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private boolean marriedStatus;
	
	private int age;
	private int mobileNumber;
	
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
