package com.sky.pro.employeeservice.service;

import com.sky.pro.employeeservice.DepartmentServiceImpl;
import com.sky.pro.employeeservice.Employee;
import com.sky.pro.employeeservice.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

public class DepartmentServiceTest {

    private EmployeeService employeeService;

    private DepartmentServiceImpl departmentService;

    @BeforeEach
    void setUp() {

        employeeService = Mockito.mock(EmployeeService.class);
        Employee employee = new Employee("Petr", "Mstitel", 1000, 1);
        when(employeeService.getAllEmployees()).thenReturn(List.of(employee));
        departmentService = new DepartmentServiceImpl(employeeService);
    }
    @Test
    void testGetDepartmentSalarySum() {
        Employee employee1 = new Employee("Petr", "Mstitel", 1000, 1);
        Employee employee2 = new Employee("Dima", "Prank", 2000, 1);
        when(employeeService.getAllEmployees()).thenReturn(List.of(employee1, employee2));

        int sum = departmentService.getDepartmentSalarySum(1);
        Assertions.assertEquals(3000, sum);
    }
    @Test
    void testFindByDepartment() {
        Employee employee1 = new Employee("Petr", "Mstitel", 1000, 1);
        Employee employee2 = new Employee("Dima", "Prank", 2000, 2);
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2));

        Collection<Employee> employees = departmentService.findByDepartment(1);
        Assertions.assertTrue(employees.contains(employee1));
        Assertions.assertFalse(employees.contains(employee2));
    }

    @Test
    void testFindMaxSalary() {
        Employee employee = new Employee("Petr", "Mstitel", 1000, 1);
        when(employeeService.getAllEmployees()).thenReturn(List.of(employee));
        Employee result = departmentService.findMaxSalary(1);
        Assertions.assertEquals("Petr", result.getFirstName());
        Assertions.assertEquals("Mstitel", result.getLastName());
        Assertions.assertEquals(1000, result.getSalary());
        Assertions.assertEquals(1, result.getDepartmentId());
    }

    @Test
    void testFindDepartmentForNonExistentDepartment() {
        Employee employee1 = new Employee("Petr", "Mstitel", 1000, 1);
        Employee employee2 = new Employee("Dima", "Prank", 2000, 2);
        when(employeeService.getAllEmployees()).thenReturn(List.of(employee1, employee2));
        Collection<Employee> employees = departmentService.findByDepartment(3);
        Assertions.assertTrue(employees.isEmpty());
    }

    @Test
    void testFindMinSalary() {
        Employee employee1 = new Employee("Petr", "Mstitel", 3000, 1);
        Employee employee2 = new Employee("Dima", "Prank", 2000, 1);
        Employee employee3 = new Employee("Vasya", "Pupkin", 1000, 1);
        when(employeeService.getAllEmployees()).thenReturn(List.of(employee1, employee2, employee3));
        Employee result = departmentService.findMinSalary(1);
        Assertions.assertEquals("Vasya", result.getFirstName());
        Assertions.assertEquals("Pupkin", result.getLastName());
        Assertions.assertEquals(1000, result.getSalary());
        Assertions.assertEquals(1, result.getDepartmentId());

    }

    @Test
    void testGetDepartmentSalarySumForEmptyDepartment() {
        when(employeeService.getAllEmployees()).thenReturn(Collections.emptyList());
        int sum = departmentService.getDepartmentSalarySum(1);
        Assertions.assertEquals(0, sum);
    }

}
