package com.practice.school;

import java.util.List;

import lombok.Builder;

@Builder
public class FullSchoolResponse {
	
	private String name;
	private List<Student> students;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public FullSchoolResponse(String name, List<Student> students) {
		super();
		this.name = name;
		this.students = students;
	}

}
