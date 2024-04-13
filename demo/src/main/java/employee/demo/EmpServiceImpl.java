package employee.demo;

import java.util.ArrayList;
import java.util.List;

public class EmpServiceImpl implements EmpService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        employees.add(employee);
        return "Saved Successfully";
    }

    @Override
    public List<Employee> readEmployees() {
        return employees;
    }

    @Override
    public boolean dltEmployee(Long id) {
        // Find the employee with the given ID
        Employee employeeToRemove = null;
        for (Employee emp : employees) {
            if (emp.getId().equals(id)) {
                employeeToRemove = emp;
                break;
            }
        }

        // If employee found, remove it from the list
        if (employeeToRemove != null) {
            employees.remove(employeeToRemove);
            return true;
        } else {
            return false; // Employee not found
        }
    }

    @Override
    public String updateEmployee(Employee employee) {
        for (Employee emp : employees) {
            if (emp.getId().equals(employee.getId())) {
                emp.setName(employee.getName());
                emp.setPhone(employee.getPhone());
                emp.setEmail(employee.getEmail());
                return "Updated Successfully";
            }
        }
        return "Employee not found";
    }
}
