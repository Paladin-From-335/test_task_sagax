package test_task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test_task.dao.EmployeeDao;
import test_task.model.Employee;
import test_task.service.EmployeeService;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAllBySalaryGreaterThatBoss() {
        return employeeDao.findAllWhereSalaryGreaterThatBoss();
    }

    @Override
    public List<Employee> findAllByMaxSalary() {
        return employeeDao.findAllByMaxSalary();
    }

    @Override
    public List<Employee> findAllWithoutBoss() {
        return employeeDao.findAllWithoutBoss();
    }

    @Override
    public Long fireEmployee(String name) {
        Iterable<Employee> employees = employeeDao.findAll();

        //TODO Implement method using Collection
        // ---write your code here

        AtomicLong empId = new AtomicLong();
        employees.forEach((i) -> {
            if (i.getName().equals(name)) {
                empId.set(i.getId());
                employeeDao.delete(i);
            }
        });
        return empId.get();
    }

    @Override
    public Long changeSalary(String name) {
        Iterable<Employee> employees = employeeDao.findAll();

        //TODO Implement method using Collection
        // ---write your code here

        AtomicLong empId = new AtomicLong();
        employees.forEach((i) -> {
            if (i.getName().equals(name)) {
                i.setSalary(new BigDecimal(999999999));
                employeeDao.save(i);
                empId.set(i.getId());
            }
        });
        return empId.get();
    }

    @Override
    public Long hireEmployee(Employee employee) {
        //TODO Implement method using Collection and DAO
        // ---write your code here
        return employeeDao.save(employee).getId();
    }
}
