package test_task.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test_task.model.Employee;

import java.util.List;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {

    //TODO Get a list of employees receiving a salary greater than that of the boss
    @Query(
            value = "SELECT e.id as id, e.name as name, e.salary as salary, e.boss_id as boss_id, e.department_id as department_id FROM employees e JOIN employees b ON b.id = e.boss_id AND e.salary > b.salary",
            nativeQuery = true)
    List<Employee> findAllWhereSalaryGreaterThatBoss();

    //TODO Get a list of employees receiving the maximum salary in their department
    @Query(
            value = "SELECT e.id as id, e.name as name, e.salary as salary, e.boss_id as boss_id, e.department_id as department_id FROM employees e WHERE salary IN(SELECT max(e1.salary) FROM employees e1 WHERE e1.department_id = e.department_id)",
            nativeQuery = true)
    List<Employee> findAllByMaxSalary();

    //TODO Get a list of employees who do not have boss in the same department
    @Query(
            value = "SELECT e.id as id, e.name as name, e.salary as salary, e.boss_id as boss_id, e.department_id as department_id FROM employees e WHERE  e.department_id != (SELECT department_id FROM employees WHERE id = e.boss_id)",
            nativeQuery = true)
    List<Employee> findAllWithoutBoss();
}
