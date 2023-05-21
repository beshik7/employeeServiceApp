package com.sky.pro.employeeservice;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
    public class EmployeeService {
        private final Map<String, Employee> employees = new HashMap<>();

        public Employee addEmployee(String firstName, String lastName) {
            String key = generateKey(firstName, lastName);
            Employee employee = new Employee(firstName, lastName);
            if (employees.containsKey(key)) {
                throw new EmployeeAlreadyAddedException();
            }
            employees.put(key, employee);
            return employee;
        }

        public Employee removeEmployee(String firstName, String lastName) {
            String key = generateKey(firstName, lastName);
             if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }

        return employees.remove(key);
    }
        public Employee findEmployee(String firstName, String lastName) {
            String key = generateKey(firstName, lastName);
            if (!employees.containsKey(key)) {
                throw new EmployeeNotFoundException();
            }

            return employees.get(key);
        }

    public Map<String, Employee> getAllEmployees() {
        return employees;
    }

    private String generateKey(String firstName, String lastName) {
        return firstName.toLowerCase() + " " + lastName.toLowerCase();
    }

    @PostConstruct
    public void init() {
            addEmployee("Ostap", "Bender");
            addEmployee("Ivan", "Ivanov");
            addEmployee("Petr", "Petrov");
            addEmployee("Sidor", "Sidorov");
            addEmployee("Homer", "Simpson");
            addEmployee("Liza", "Petrova");
            addEmployee("Senya", "Golden");
            addEmployee("Jack", "Warner");
            addEmployee("Michael", "Jordan");
            addEmployee("Steve", "Jobs");
        }
    }

