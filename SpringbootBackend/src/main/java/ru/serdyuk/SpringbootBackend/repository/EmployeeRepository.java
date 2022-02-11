package ru.serdyuk.SpringbootBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.serdyuk.SpringbootBackend.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
