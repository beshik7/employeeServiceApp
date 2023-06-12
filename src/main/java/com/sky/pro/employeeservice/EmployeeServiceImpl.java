package com.sky.pro.employeeservice;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private Map<String, Employee> storage = new HashMap<>();
    @Override
    public void addEmployee(Employee employee) {
        String firstName = StringUtils.capitalize(employee.getFirstName());
        String lastName = StringUtils.capitalize(employee.getLastName());
        String key = firstName + lastName;
        if (storage.containsKey(key)) {
            throw new EmployeeAlreadyAddedException(" Сотрудник уже добавлен ");
        }
        if (!StringUtils.isAlpha(employee.getFirstName()) || !StringUtils.isAlpha(employee.getLastName())) {
            throw new UnexpectedCharacterException("Names should contain only alphabetic characters");
        }
        storage.put(key, employee);
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        String key = firstName + lastName;

        if (!storage.containsKey(key)) {
            throw new EmployeeNotFoundException(" Сотрудник не найден ");
        }
        storage.remove(firstName + lastName);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = firstName +lastName;

        if (!storage.containsKey(key)) {
            throw new EmployeeNotFoundException(" Сотрудник не найден ");
        }
        return storage.get(firstName + lastName);

    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return storage.values();
    }

    private void validate(String... values) {
        for (String value : values) {
            if (!StringUtils.isAlpha(value)) {
                throw new UnexpectedCharacterException("Bad request in" + value);
            }
        }
    }
}
