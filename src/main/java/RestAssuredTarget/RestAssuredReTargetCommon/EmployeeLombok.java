package RestAssuredTarget.RestAssuredReTargetCommon;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter(value = AccessLevel.PUBLIC)
@Setter
public class EmployeeLombok {
	/*
	 * Usually, we'll generate getters and setters for the private property, and they can 
	 * occupy a lot of spaces, so even if we want to add or remove a field, we again need to
	 * generate or remove the setters and getters respectively. This is what we call as a 
	 * boilerplate code
	 * To overcome the usage of boilerplate codes, we make use of a third party library
	 * known as Project Lombok
	 * If we want to have only getters for the fields, use @Getter at class level
	 */
	private String name;
	private String mobNo;
	private int age;
	
	
}
