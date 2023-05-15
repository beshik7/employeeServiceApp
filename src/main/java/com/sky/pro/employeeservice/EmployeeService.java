package com.sky.pro.employeeservice;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
    @Service
    public class EmployeeService {
        private static final int MAX_EMPLOYEES = 10;
        private List<Employee> employees;



        public Employee addEmployee(String firstName, String lastName) {
            if (employees.size() >= MAX_EMPLOYEES) {
                throw new EmployeeStorageIsFullException();
            }

            Employee employee = new Employee(firstName, lastName);
            if (employees.contains(employee)) {
                throw new EmployeeAlreadyAddedException();
            }

            employees.add(employee);
            return employee;
        }
        public Employee removeEmployee(String firstName, String lastName) {
            Employee employee = new Employee(firstName, lastName);
            if (!employees.contains(employee)) {
                throw new EmployeeNotFoundException();
            }

            employees.remove(employee);
            return employee;
        }

        public Employee findEmployee(String firstName, String lastName) {
            Employee employee = new Employee(firstName, lastName);
            if (!employees.contains(employee)) {
                throw new EmployeeNotFoundException();
            }

            return employee;
        }
        public Set<Employee> getAllEmployees() {
            return new HashSet<>(employees);
        }
        @PostConstruct
        public void init() {
            employees = new ArrayList<>();
            employees.add(new Employee("Ostap", "Bender"));
            employees.add(new Employee("Ivan", "Ivanov"));
            employees.add(new Employee("Petr", "Petrov"));
            employees.add(new Employee("Sidor", "Sidorov"));
            employees.add(new Employee("Homer", "Simpson"));
            employees.add(new Employee("Liza", "Petrova"));
            employees.add(new Employee("Senya", "Golden"));
            employees.add(new Employee("Jack", "Warner"));
            employees.add(new Employee("Michael", "Jordan"));
            employees.add(new Employee("Steve", "Jobs"));
        }
}
