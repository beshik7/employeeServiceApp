package com.sky.pro.employeeservice.service;

import com.sky.pro.employeeservice.Employee;
import com.sky.pro.employeeservice.EmployeeNotFoundException;
import com.sky.pro.employeeservice.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collection;
public class EmployeeServiceImplTest {

    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl();
    }
    @Test
    void testAddEmployee() {
        Employee employee = new Employee("Petr", "Mstitel", 1, 1000);
        employeeService.addEmployee(employee);
        Collection<Employee> employees = employeeService.getAllEmployees();
        Assertions.assertTrue(employees.contains(employee));
    }

    @Test
    void testRemoveEmployee() {
        Employee employee = new Employee("Ivan", "Grom", 3, 3000);
        employeeService.addEmployee(employee);
        employeeService.removeEmployee(employee.getFirstName(), employee.getLastName());
        Collection<Employee> employees = employeeService.getAllEmployees();
        Assertions.assertFalse(employees.contains(employee));
    }
    @Test
    void testFindEmployee() {
        Employee employee = new Employee("Dima", "Prank", 2, 2000);
        employeeService.addEmployee(employee);

        Employee found = employeeService.findEmployee("Dima", "Prank");
        Assertions.assertEquals(employee, found);
    }
    @Test
    void testGetAllEmployees() {
        Employee employee1 = new Employee("Petr", "Mstitel", 1, 1000);
        Employee employee2 = new Employee("Dima", "Prank", 2, 2000);
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);
        Collection<Employee> employees = employeeService.getAllEmployees();
        Assertions.assertTrue(employees.contains(employee1));
        Assertions.assertTrue(employees.contains(employee2));

    }
    @Test
    void testRemoveEmployeeNotFound() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.removeEmployee("Nonexistent", "Employee");
        });
    }

    @Test
    void testFindEmployeeNotFound() {
       Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.findEmployee("Nonexistent", "Employee");
        });
    }
}
