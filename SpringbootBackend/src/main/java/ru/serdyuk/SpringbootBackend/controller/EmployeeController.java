package ru.serdyuk.SpringbootBackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.serdyuk.SpringbootBackend.model.Employee;
import ru.serdyuk.SpringbootBackend.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    //build get all employees REST API
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    //build get employee by Id REST API
    //http://localhost:8080/api/employees/id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId) {
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }
    //build update employee REST API

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable("id") long id
                                                      ,@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.updateEmployee(employee,id), HttpStatus.OK);
    }
}
