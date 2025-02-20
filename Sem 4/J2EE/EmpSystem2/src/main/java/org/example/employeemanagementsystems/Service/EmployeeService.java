package org.example.employeemanagementsystems.Service;

import org.example.employeemanagementsystems.Model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private int nextId = 1;

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        return employee.orElse(null);
    }

    public void addEmployee(Employee employee) {
        employee.setId(nextId++);
        employees.add(employee);
    }

    public void updateEmployee(Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == updatedEmployee.getId()) {
                employee.setFirstName(updatedEmployee.getFirstName());
                employee.setLastName(updatedEmployee.getLastName());
                employee.setEmail(updatedEmployee.getEmail());
                break;
            }
        }
    }

    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }
}
