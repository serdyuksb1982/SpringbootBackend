package ru.serdyuk.SpringbootBackend.service;

import ru.serdyuk.SpringbootBackend.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
}
