package com.student.studentapp.service;

import com.student.studentapp.entity.Student; // Updated import to match your project structure

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void addStudent(Student student);
}
