package employee.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmpController {

    // List<Employee> employees = new ArrayList<>();
    EmpService empService = new EmpServiceImpl();

    // Dependency Injection
    // @Autowired
    // EmpService empService;

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        // return employees;
        return empService.readEmployees();
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
        return empService.createEmployee(employee);
        // return "SAved Successfully";
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (empService.dltEmployee(id)) {
            return "Delete Successfully";
        } else {
            return "Not Found";
        }
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@RequestBody Employee employee) {
        return empService.updateEmployee(employee);
    }

}
