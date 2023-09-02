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
    @GetMapping("/add")
    public void addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer salary, @RequestParam Integer departmentId) {
        employeeService.addEmployee(new Employee(firstName, lastName, salary, departmentId));
    }

    @GetMapping("/remove")
    public void removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
        public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
             employeeService.findEmployee(firstName, lastName);
             return null;
        }

    @GetMapping("/all")
    public Map<String, Employee> getAllEmployees() {
        return (Map<String, Employee>) employeeService.getAllEmployees();
    }
}
