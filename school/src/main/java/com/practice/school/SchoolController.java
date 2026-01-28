package com.practice.school;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/school")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	@PostMapping("/save")
	public ResponseEntity saveSchool(@RequestBody School school) {
		return ResponseEntity.ok(schoolService.saveSchool(school));
	}

	@GetMapping("/findAll")
	public ResponseEntity findSchool() {
		return ResponseEntity.ok(schoolService.findSchool());
	}

	@GetMapping("/findSchoolWithStudents/{schoolId}")
	public ResponseEntity findSchoolWithStudents(@PathVariable Integer schoolId) {
		return ResponseEntity.ok(schoolService.findSchoolWithStudents(schoolId));
	}

}
