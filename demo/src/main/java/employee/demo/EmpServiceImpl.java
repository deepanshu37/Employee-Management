package employee.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        // employees.add(employee);
        return "Saved Successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeesList) {
            Employee emp = new Employee();
            emp.setName(employeeEntity.getName());
            // emp.setPhone(employeeEntity.getPhone());
            emp.setEmail(employeeEntity.getEmail());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean dltEmployee(Long id) {
        // Find the employee with the given ID
        // Employee employeeToRemove = null;
        // for (Employee emp : employees) {
        // if (emp.getId().equals(id)) {
        // employeeToRemove = emp;
        // break;
        // }
        // }

        // // If employee found, remove it from the list
        // if (employeeToRemove != null) {
        // employees.remove(employeeToRemove);
        return true;
        // } else {
        // return false; // Employee not found
        // }
    }

}
