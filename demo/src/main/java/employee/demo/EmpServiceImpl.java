package employee.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(EmployeeEntity employee) {
        try {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            BeanUtils.copyProperties(employee, employeeEntity);
            employeeRepository.save(employeeEntity);
            return "Saved Successfully";
        } catch (DataAccessException e) {
            return "Failed to save employee: " + e.getMessage();
        }
    }

    @Override
    public List<EmployeeEntity> readEmployees() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<EmployeeEntity> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeesList) {
            EmployeeEntity emp = new EmployeeEntity();
            emp.setName(employeeEntity.getName());
            emp.setPhone(employeeEntity.getPhone());
            emp.setId(employeeEntity.getId());
            emp.setEmail(employeeEntity.getEmail());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean dltEmployee(Long id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String updtEmployee(Long id, EmployeeEntity employee) {
        try {
            EmployeeEntity existingEmployee = employeeRepository.findById(id).orElse(null);
            if (existingEmployee != null) {
                existingEmployee.setEmail(employee.getEmail());
                existingEmployee.setName(employee.getName());
                existingEmployee.setPhone(employee.getPhone());
                employeeRepository.save(existingEmployee);
                return "Updated Successfully";
            } else {
                return "Employee with ID " + id + " not found";
            }
        } catch (Exception e) {
            return "Failed to update employee: " + e.getMessage();
        }
    }

    @Override
    public String readEmployee(Long id) {
        try {
            EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
            if (employeeEntity != null) {
                EmployeeEntity employee = new EmployeeEntity();
                BeanUtils.copyProperties(employeeEntity, employee);
                return "\nID: " + employee.getId() + "\nName: " + employee.getName() + "\nPhone: " + employee.getPhone()
                        + "\nEmail: " + employee.getEmail();
            } else {
                return "The employee does not exist.";
            }
        } catch (Exception e) {
            return "You did not get connected to database";
        }
    }

}
