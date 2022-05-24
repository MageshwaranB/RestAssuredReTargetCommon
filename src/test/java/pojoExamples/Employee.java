package pojoExamples;

public class Employee 
{
	/*
	 * since the properties/variables are private, we can't use directly use them by creating an object
	 * We can either create a public constructor or by creating setters and getters
	 * This process is basically called encapsulation or data hiding because we restrict 
	 * access of the variables	
	 */
	
	private int id, departmentId;
	private String name, mobNo, gender,address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
		
}
