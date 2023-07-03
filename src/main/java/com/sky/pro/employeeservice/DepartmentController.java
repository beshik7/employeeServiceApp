package com.sky.pro.employeeservice;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{departmentId}/salary/sum")
    public Integer getDepartmentSalarySum(@PathVariable Integer departmentId) {
        return departmentService.getDepartmentSalarySum(departmentId);
    }
    @GetMapping("/{departmentId}/salary/max")
    public Employee getEmployeeWithMaxSalary(@PathVariable int departmentId) {
        return departmentService.findMaxSalary(departmentId);
    }
    @GetMapping("/{departmentId}/salary/min")
    public Employee getEmployeeWithMinSalary(@PathVariable int departmentId) {
        return departmentService.findMinSalary(departmentId);
    }
    @GetMapping("/{departmentId}/employees")
    public Collection<Employee> getAllEmployeesInDepartment(@PathVariable Integer departmentId) {
        return departmentService.findByDepartment(departmentId);
    }
@GetMapping("/employees")
    public Map<Integer, List<Employee>> getGroupedByDepartment() {
        return departmentService.getGroupedByDepartment();
    }
}
