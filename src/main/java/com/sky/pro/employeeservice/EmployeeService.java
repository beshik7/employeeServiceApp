package com.sky.pro.employeeservice;

import java.util.Collection;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void removeEmployee(String firstName, String lastName);
    void findEmployee(String firstName, String lastName);


    Collection<Employee> getAllEmployees();

}
