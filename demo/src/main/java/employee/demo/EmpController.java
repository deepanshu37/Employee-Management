package employee.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class EmpController {

    // Dependency Injection
    @Autowired
    EmpService empService;

    @GetMapping("employees")
    public List<EmployeeEntity> getAllEmployees() {
        return empService.readEmployees();
    }

    @GetMapping("employees/{id}")
    public String getEmployeesById(@PathVariable Long id) {
        return empService.readEmployee(id);
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody EmployeeEntity employee) {
        return empService.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (empService.dltEmployee(id)) {
            return "Deleted Successfully";
        } else {
            return "Not Found";
        }
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity employee) {
        return empService.updtEmployee(id, employee);
    }

}
