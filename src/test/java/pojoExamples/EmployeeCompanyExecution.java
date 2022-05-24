package pojoExamples;

public class EmployeeCompanyExecution 
{
	public static void main(String[] args) {
		Employee emp=new Employee();
//		emp.id=1;
//		emp.name="Magesh";
//		emp.gender="Male";
//		emp.mobNo="4596612301";
//		emp.address="xyz apartment";
//		emp.departmentId=203;
//		
		Employee emp2=new Employee();
//		emp2.id=2;
//		emp.name="Lola";
//		emp.departmentId=205;
//		emp.gender="Female";
//		
//		System.out.println("First Employee Id: "+emp.id +"\n"+
//							"Second Employee Id: "+emp2.id);
		
		emp.setId(101);
		emp.setName("Magesh");
		emp.setDepartmentId(301);
		emp.setGender("Male");
		
		System.out.println(emp.getId() + "\n"
							+ emp.getName()+"\n"+
							emp.getGender());
	}
}
