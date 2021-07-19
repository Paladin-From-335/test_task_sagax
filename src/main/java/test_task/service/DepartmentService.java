package test_task.service;

import org.springframework.stereotype.Service;
import test_task.model.Department;

import java.util.List;

@Service
public interface DepartmentService {

    void save(Department department);

    List<Long> findAllByDepartmentDoesntExceedThreePeople();

    List<Long> findAllByMaxTotalSalary();
}
