package com.mujahid.employee_crud_api.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mujahid.employee_crud_api.entity.Employee;
import com.mujahid.employee_crud_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {
    //create the employeeService and objectMapper fields
    private EmployeeService employeeService;

    private ObjectMapper objectMapper;

    //inject the EmployeeService and objectMapper to EmployeeRESTController
    @Autowired
    public EmployeeRESTController(EmployeeService employeeService, ObjectMapper objectMapper){
        this.employeeService = employeeService;

        this.objectMapper = objectMapper;
    }

    //implement get all employees endpoint "employees"
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // add an endpoint for retrieving an employee by id
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        Employee employee = employeeService.findById(id);

        if (employee == null){
            throw new RuntimeException("Employee not found with this id : " + id);
        }

        return employee;
    }

    // add mapping for post endpoint to add an employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        employee.setId(0);

        return employeeService.save(employee);
    }

    // add mapping for put /employees endpoint to update an employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        return employeeService.save(employee);
    }

    // add mapping for patch /employees/{id} endpoint for doing partial updates in employee entities
    @PatchMapping("/employees/{id}")
    public Employee partialUpdateEmployee(@PathVariable int id, @RequestBody Map<String, Object> patchPayload){

        if (patchPayload.containsKey("id")){
            throw new RuntimeException("Employee id can not be contained in the request body" + patchPayload.get("id"));
        }

        Employee employee = employeeService.findById(id);

        if (employee == null){
            throw new RuntimeException("No Employed with this id : " + id);
        }

        Employee updatedEmployee = applyPatch(employee, patchPayload);

        return employeeService.save(updatedEmployee);
    }

    // add mapping for deleting an employee by id
    @DeleteMapping("employees/{id}")
    public Employee deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        
        if(employee == null){
            throw new RuntimeException("no employee with this id : " + id);
        }

        employeeService.deleteById(id);

        return employee;
    }

    // helper class for applying the partial updates on an employee entity
    private Employee applyPatch(Employee employee, Map<String, Object> patchPayload) {

        ObjectNode theEmployee = objectMapper.convertValue(employee, ObjectNode.class);

        ObjectNode thePatch = objectMapper.convertValue(patchPayload, ObjectNode.class);

        theEmployee.setAll(thePatch);

        return objectMapper.convertValue(theEmployee, Employee.class);

    }


}
