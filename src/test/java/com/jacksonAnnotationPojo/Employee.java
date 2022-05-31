package com.jacksonAnnotationPojo;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

/*
 * With JsonInclude we can mention what are all the fields which needs to be included
 * While serialization the json objects to string, if any fields have default values, we're
 * making sure it is not included in the json response
 */

//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Employee 
{
	private String name,address,mobileNo;
	private int age;
	private boolean married;
//Adding two more extra fields for NonEmpty Example
	private List<String> skillSets;
	private Map<String, String> familyMembers;

	public String getName() {
		return name;
	}
	public List<String> getSkillSets() {
		return skillSets;
	}
	public void setSkillSets(List<String> skillSets) {
		this.skillSets = skillSets;
	}
	public Map<String, String> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(Map<String, String> familyMembers) {
		this.familyMembers = familyMembers;
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
