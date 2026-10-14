package com.hrishabh.employee.service;

import com.hrishabh.employee.dao.EmployeeDAO;
import com.hrishabh.employee.model.Employee;

import java.util.List;

public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeService() {
        employeeDAO = new EmployeeDAO();
    }

    // CREATE
    public void addEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    // READ
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    // UPDATE
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    // DELETE
    public void deleteEmployee(Long id) {
        employeeDAO.deleteEmployee(id);
    }
}