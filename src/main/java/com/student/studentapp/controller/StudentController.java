package com.student.studentapp.controller;

import com.student.studentapp.entity.Student;
import com.student.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Root mapping to redirect to /students
    @GetMapping("/")
    public String redirectToStudents() {
        return "redirect:/students";  // Redirect to the student list page
    }

    // Display all students
    @GetMapping("/students")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student-list";  // Return the student-list.html Thymeleaf template
    }

    // Show add student form
    @GetMapping("/addStudent")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());  // Add an empty student object
        return "add-student";  // Return the add-student.html Thymeleaf template
    }

    // Handle student form submission (add new student)
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);  // Add the student to the service
        return "redirect:/students";  // Redirect to the student list page
    }
}
