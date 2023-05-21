package com.sky.pro.employeeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @DeleteMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/all")
    public Map<String, Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
