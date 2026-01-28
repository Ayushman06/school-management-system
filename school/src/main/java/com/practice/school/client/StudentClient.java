package com.practice.school.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.practice.school.Student;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {

	@GetMapping("/findSchoolWithStudents/{schoolId}")
	List<Student> findSchoolWithStudents(@RequestParam Integer schoolId);

}
