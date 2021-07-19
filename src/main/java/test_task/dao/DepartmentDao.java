package test_task.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import test_task.model.Department;

import java.util.List;

@Repository
public interface DepartmentDao extends CrudRepository<Department, Long> {

    //TODO Get a list of department IDS where the number of employees doesn't exceed 3 people
    @Query(
            value = "SELECT d.id FROM employees inner join department d on d.id = department_id GROUP BY d.id HAVING COUNT(*) < 4",
            nativeQuery = true)
    List<Long> findAllWhereDepartmentDoesntExceedThreePeople();

    //TODO Get a list of departments IDs with the maximum total salary of employees
    @Query(
            value = "SELECT department_id, sum(salary) as sumsalary FROM employees GROUP BY department_id HAVING sum(salary) >= ALL (SELECT sum(salary) FROM employees GROUP BY department_id)",
            nativeQuery = true)
    List<Long> findAllByMaxTotalSalary();
}
