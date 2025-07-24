package com.mujahid.employee_crud_api.service;

import com.mujahid.employee_crud_api.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
