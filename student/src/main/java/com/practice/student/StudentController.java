package com.practice.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/save")
	public ResponseEntity saveStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.saveStudent(student));
	}

	@GetMapping("/findAll")
	public ResponseEntity findStudent() {
		return ResponseEntity.ok(studentService.findStudent());
	}

	@GetMapping("/findSchoolWithStudents/{schoolId}")
	public ResponseEntity findSchoolWithStudents(@PathVariable Integer schoolId) {
		return ResponseEntity.ok(studentService.findSchoolWithStudents(schoolId));
	}

}
