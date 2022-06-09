package com.jacksonAnnotationPojo;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

//@JsonIncludeProperties(value = {"name", "age"})
public class EmployeeWithJsonIncludeProperties {
/*
 * Let's assume a scenario where we need to have both name and age present in the
 * response irrespective of whether they have values or not, we can make use of
 * JsonIncludeProperties and pass the fields inside brackets
 * If we only need certain properties to show up then why write the other fields?
 * Because, consider this POJO as the base class and we can create one child of this class
 * and their we can use JsonIncludeProperties, which will show the certain fields when we 
 * make use of it
 */
	private String name,address,mobileNo;
	private int age;
	private boolean married;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	
}
