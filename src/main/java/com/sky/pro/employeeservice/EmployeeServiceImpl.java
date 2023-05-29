package com.sky.pro.employeeservice;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private Map<String, Employee> storage = new HashMap<>();
    @Override
    public void addEmployee(Employee employee) {
        String key = employee.getFirstName() + employee.getLastName();
        if (storage.containsKey(key)) {
            throw new EmployeeAlreadyAddedException(" Сотрудник уже добавлен ");
        }
        storage.put(key, employee);
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        if (storage.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException(" Сотрудник не найден ");
        }
        storage.remove(firstName + lastName);
    }

    @Override
    public void findEmployee(String firstName, String lastName) {
        if (storage.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException(" Сотрудник не найден ");
        }
        storage.get(firstName + lastName);

    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return storage.values();
    }
}
