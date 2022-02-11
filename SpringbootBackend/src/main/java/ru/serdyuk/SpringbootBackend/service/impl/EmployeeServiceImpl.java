package ru.serdyuk.SpringbootBackend.service.impl;

import org.springframework.stereotype.Service;
import ru.serdyuk.SpringbootBackend.model.Employee;
import ru.serdyuk.SpringbootBackend.repository.EmployeeRepository;
import ru.serdyuk.SpringbootBackend.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
