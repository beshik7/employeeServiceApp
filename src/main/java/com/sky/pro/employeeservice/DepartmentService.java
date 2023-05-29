package com.sky.pro.employeeservice;


import java.util.Collection;
import java.util.List;
import java.util.Map;
public interface DepartmentService {
    Employee findMaxSalary(Integer departmentId);

    Employee findMinSalary(Integer departmentId);

    Collection<Employee> findByDepartment(Integer departmentId);
    Map<Integer, List<Employee>> getGroupedByDepartment();
}
