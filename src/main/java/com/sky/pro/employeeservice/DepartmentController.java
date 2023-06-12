package com.sky.pro.employeeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping ("/max-salary")
    public Employee getEmployeeWithMaxSalary(@RequestParam Integer departmentId) {
        return departmentService.findMaxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(@RequestParam Integer departmentId) {
        return departmentService.findMinSalary(departmentId);
    }
    @GetMapping(value = "/all", params = "departmentId")
    public Collection<Employee> getAllEmployeesInDepartment(@RequestParam Integer departmentId) {

        return departmentService.findByDepartment(departmentId);
    }
@GetMapping("/all")
    public Map<Integer, List<Employee>> getGroupedByDepartment() {
        return departmentService.getGroupedByDepartment();
    }
}
