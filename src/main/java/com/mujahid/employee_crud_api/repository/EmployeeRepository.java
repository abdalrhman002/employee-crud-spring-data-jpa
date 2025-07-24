package com.mujahid.employee_crud_api.repository;

import com.mujahid.employee_crud_api.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


}
