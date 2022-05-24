package pojoExamples.nestedJsonObjects;

public class Employee {
	private String firstName;
	private String lastName;
	private String profession;
/*
 * EmployeeAddress class stores another jsonObject which holds streetname, 
 * houseno, city, country, postal code and state
 */
	
	private EmployeeAddress address;
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
	public EmployeeAddress getAddress() {
		return address;
	}
	public void setAddress(EmployeeAddress address) {
		this.address = address;
	}
	public boolean isMarried() {
		return isMarried;
	}
	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}
}
