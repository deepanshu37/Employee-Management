package employee.demo;

import java.util.List;

public interface EmpService {
    String createEmployee(Employee employee);

    List<Employee> readEmployees();

    boolean dltEmployee(Long id);
}
