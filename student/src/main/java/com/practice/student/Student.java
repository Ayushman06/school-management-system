package com.practice.student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Student")
@Builder
@NoArgsConstructor
public class Student {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String email;
	private Integer schoolId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Student(Integer id, String name, String email, Integer schoolId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.schoolId = schoolId;
	}

}
