package employee.demo;

import java.util.List;

public interface EmpService {
    String createEmployee(EmployeeEntity employee);

    List<EmployeeEntity> readEmployees();

    boolean dltEmployee(Long id);

    String updtEmployee(Long id, EmployeeEntity employee);

    String readEmployee(Long Id);
}
