package com.student.studentapp.service;

import com.student.studentapp.entity.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<Integer, Student> studentMap = new HashMap<>();
    private int nextId = 4; // Starts from 4, assuming 3 default students

    public StudentServiceImpl() {
        // Pre-populating with default students
        studentMap.put(1, new Student(1, "David Thompson", 19, "Male", "david.thompson@example.com", "Toronto", LocalDate.of(2005, 2, 18)));
        studentMap.put(2, new Student(2, "Emma Williams", 21, "Female", "emma.williams@example.com", "Vancouver", LocalDate.of(2003, 7, 25)));
        studentMap.put(3, new Student(3, "Sophia Martinez", 20, "Female", "sophia.martinez@example.com", "Miami", LocalDate.of(2004, 11, 9)));
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public void addStudent(Student student) {
        student.setId(nextId++); // Assign unique ID and increment
        studentMap.put(student.getId(), student); // Add to map
    }
}
