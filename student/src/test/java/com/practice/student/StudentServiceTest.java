package com.practice.student;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveStudent() {
        Student student = new Student(1, "Alice", "alice@example.com", 101);
        when(studentRepository.save(student)).thenReturn(student);

        Student saved = studentService.saveStudent(student);

        assertEquals("Alice", saved.getName());
        assertEquals("alice@example.com", saved.getEmail());
        assertEquals(101, saved.getSchoolId());
        verify(studentRepository, times(1)).save(student);
    }

    @Test
    void testFindStudent() {
        List<Student> students = Arrays.asList(
                new Student(1, "Alice", "alice@example.com", 101),
                new Student(2, "Bob", "bob@example.com", 102)
        );
        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.findStudent();

        assertEquals(2, result.size());
        assertEquals("Bob", result.get(1).getName());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testFindSchoolWithStudents() {
        List<Student> students = Arrays.asList(
                new Student(1, "Alice", "alice@example.com", 101),
                new Student(2, "Bob", "bob@example.com", 101)
        );
        when(studentRepository.findAllBySchoolId(101)).thenReturn(students);

        List<Student> result = studentService.findSchoolWithStudents(101);

        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
        assertEquals("bob@example.com", result.get(1).getEmail());
        verify(studentRepository, times(1)).findAllBySchoolId(101);
    }
}