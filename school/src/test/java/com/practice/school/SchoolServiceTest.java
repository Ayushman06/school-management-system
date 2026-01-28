package com.practice.school;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.practice.school.client.StudentClient;

class SchoolServiceTest {

    @Mock
    private SchoolRepository schoolRepository;

    @Mock
    private StudentClient studentClient;

    @InjectMocks
    private SchoolService schoolService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveSchool() {
        School school = new School(1, "Test School");
        when(schoolRepository.save(school)).thenReturn(school);

        School saved = schoolService.saveSchool(school);

        assertEquals("Test School", saved.getName());
        verify(schoolRepository, times(1)).save(school);
    }

    @Test
    void testFindSchool() {
        List<School> schools = Arrays.asList(new School(1, "School A"), new School(2, "School B"));
        when(schoolRepository.findAll()).thenReturn(schools);

        List<School> result = schoolService.findSchool();

        assertEquals(2, result.size());
        verify(schoolRepository, times(1)).findAll();
    }

    @Test
    void testFindSchoolWithStudents_Found() {
        School school = new School(1, "School A");
        List<Student> students = Arrays.asList(new Student(101, "Alice", "Alice@gmail.com"), new Student(102, "Bob", "Bob@gmail.com"));

        when(schoolRepository.findById(1)).thenReturn(Optional.of(school));
        when(studentClient.findSchoolWithStudents(1)).thenReturn(students);

        FullSchoolResponse response = schoolService.findSchoolWithStudents(1);

        assertEquals("School A", response.getName());
        assertEquals(2, response.getStudents().size());
        verify(schoolRepository).findById(1);
        verify(studentClient).findSchoolWithStudents(1);
    }

    @Test
    void testFindSchoolWithStudents_NotFound() {
        when(schoolRepository.findById(99)).thenReturn(Optional.empty());
        when(studentClient.findSchoolWithStudents(99)).thenReturn(List.of());

        FullSchoolResponse response = schoolService.findSchoolWithStudents(99);

        assertEquals("NOT_FOUND", response.getName());
        assertTrue(response.getStudents().isEmpty());
        verify(schoolRepository).findById(99);
        verify(studentClient).findSchoolWithStudents(99);
    }
}