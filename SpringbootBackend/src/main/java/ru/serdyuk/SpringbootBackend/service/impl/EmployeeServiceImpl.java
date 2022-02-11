package ru.serdyuk.SpringbootBackend.service.impl;

import org.springframework.stereotype.Service;
import ru.serdyuk.SpringbootBackend.execpion.ResourceNotFoundException;
import ru.serdyuk.SpringbootBackend.model.Employee;
import ru.serdyuk.SpringbootBackend.repository.EmployeeRepository;
import ru.serdyuk.SpringbootBackend.service.EmployeeService;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Employee getEmployeeById(long id) {
        /*Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }*/
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //we need to check whether employee with given id is exists in

        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        //save exiting employee to DB
        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }
}
