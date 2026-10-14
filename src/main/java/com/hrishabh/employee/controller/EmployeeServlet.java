package com.hrishabh.employee.controller;

import com.hrishabh.employee.config.ThymeleafConfig;
import com.hrishabh.employee.model.Employee;
import com.hrishabh.employee.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService;
    private TemplateEngine templateEngine;

    @Override
    public void init() {

        employeeService = new EmployeeService();

        templateEngine =
                ThymeleafConfig.createTemplateEngine(
                        getServletContext()
                );
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Get employees from Service layer
        List<Employee> employees =
                employeeService.getAllEmployees();

        // Create Thymeleaf web application
        JakartaServletWebApplication application =
                JakartaServletWebApplication.buildApplication(
                        getServletContext()
                );

        // Create web exchange
        IWebExchange exchange =
                application.buildExchange(
                        request,
                        response
                );

        // Create Thymeleaf context
        WebContext context =
                new WebContext(exchange);

        // Send employee list to Thymeleaf
        context.setVariable(
                "employees",
                employees
        );

        // Render employees.html
        templateEngine.process(
                "employees",
                context,
                response.getWriter()
        );
    }
}