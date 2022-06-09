package com.jacksonAnnotationPojo;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

@JsonIncludeProperties(value = {"name", "age", "skills"})
public class EmployeeSkills extends EmployeeWithJsonIncludeProperties
{
	private String skills;

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}
}
