package com.practice.school;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.school.client.StudentClient;

@Service
public class SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;

	@Autowired
	private StudentClient studentClient;

	public School saveSchool(School school) {
		return schoolRepository.save(school);
	}

	public List<School> findSchool() {
		return schoolRepository.findAll();
	}

	public FullSchoolResponse findSchoolWithStudents(Integer schoolId) {

		var school = schoolRepository.findById(schoolId)
				.orElse(new School(null, "NOT_FOUND"));
		var students = studentClient.findSchoolWithStudents(schoolId);

		return FullSchoolResponse.builder().name(school.getName()).students(students).build();
	}

}
