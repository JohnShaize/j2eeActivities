package org.example.employeemanagementsystems.Controller;

import org.example.employeemanagementsystems.Model.Employee;
import org.example.employeemanagementsystems.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Display all employees
    @GetMapping("/employees")
    public String getAllEmployees(Model model) {
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        return "index";  // Renders the index.html template
    }

    // Show the form to add a new employee
    @GetMapping("/showAddEmployeeForm")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    // Add a new employee
    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addEmployee";
        }
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    // Show the form to update an employee
    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "updateEmployee";
    }

    // Update an employee
    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    // Delete an employee
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
