package com.hrishabh.employee.test;

import com.hrishabh.employee.dao.EmployeeDAO;
import com.hrishabh.employee.model.Employee;

public class EmployeeDAOTest {

    public static void main(String[] args) {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        Employee employee = new Employee(
                "Hrishabh",
                "Singh",
                "hrishabh@example.com",
                "9876543210",
                "Engineering",
                60000
        );

        employee.setId(1L);

        employeeDAO.updateEmployee(employee);
        employeeDAO.deleteEmployee(2L);
    }
}