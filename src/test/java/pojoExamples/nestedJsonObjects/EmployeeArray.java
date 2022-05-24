package pojoExamples.nestedJsonObjects;

import java.util.List;

public class EmployeeArray {
	private String firstName;
	private String lastName;
	private String profession;
/*
 * EmployeeAddress class stores another jsonObject which holds streetname, 
 * houseno, city, country, postal code and state
 */
	//In this example, we wants to make address as an array, so gonna use a list
	private List<EmployeeAddress> address;
	private boolean isMarried;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public List<EmployeeAddress> getAddress() {
		return address;
	}
	public void setAddress(List<EmployeeAddress> address) {
		this.address = address;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
}
