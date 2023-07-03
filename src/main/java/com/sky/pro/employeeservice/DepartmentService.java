package com.sky.pro.employeeservice;


import java.util.Collection;
import java.util.List;
import java.util.Map;
public interface DepartmentService {
    Integer getDepartmentSalarySum(int departmentId);
    Employee findMaxSalary(int departmentId);

    Employee findMinSalary(int departmentId);

    Collection<Employee> findByDepartment(Integer departmentId);
    Map<Integer, List<Employee>> getGroupedByDepartment();
}
