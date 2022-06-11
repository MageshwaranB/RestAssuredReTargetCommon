package com.lombokexamples;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
@Getter
public class EmployeeBuilder {
	private String firstName;
	private String lastName;
	private int age;
	private String mailId;
}
