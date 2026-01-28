package com.practice.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	public List<Student> findStudent() {
		return studentRepository.findAll();
	}

	public List<Student> findSchoolWithStudents(Integer schoolId) {
		return studentRepository.findAllBySchoolId(schoolId);
	}

}
