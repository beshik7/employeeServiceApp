package com.sky.pro.employeeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final EmployeeService employeeService;
    @Autowired
    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMaxSalary(Integer departmentId) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(e -> Objects.equals(e.getDepartmentId(), departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new IllegalArgumentException("Missing employee"));
    }

    @Override
    public Employee findMinSalary(Integer departmentId) {
        return employeeService.getAllEmployees()
                    .stream()
                    .filter(e -> Objects.equals(e.getDepartmentId(), departmentId))
                    .min(Comparator.comparingInt(Employee::getSalary))
                    .orElseThrow(() -> new IllegalArgumentException("Missing employee"));


    }

    @Override
    public Collection<Employee> findByDepartment(Integer departmentId) {
        return employeeService.getAllEmployees()
                .stream()
                .filter(e -> Objects.equals(e.getDepartmentId(), departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getGroupedByDepartment() {
        return employeeService.getAllEmployees()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId, Collectors.toList()));
    }
}
