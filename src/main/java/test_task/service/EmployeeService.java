package test_task.service;

import org.springframework.stereotype.Service;
import test_task.model.Employee;

import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> findAllBySalaryGreaterThatBoss();

    List<Employee> findAllByMaxSalary();

    List<Employee> findAllWithoutBoss();

    Long fireEmployee(String name);

    Long changeSalary(String name);

    Long hireEmployee(Employee employee);
}
