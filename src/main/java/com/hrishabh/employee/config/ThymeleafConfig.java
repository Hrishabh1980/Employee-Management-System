package com.hrishabh.employee.config;

import jakarta.servlet.ServletContext;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

public class ThymeleafConfig {

    public static TemplateEngine createTemplateEngine(
            ServletContext servletContext) {

        // Create Thymeleaf web application
        JakartaServletWebApplication application =
                JakartaServletWebApplication.buildApplication(
                        servletContext
                );

        // Create template resolver
        WebApplicationTemplateResolver templateResolver =
                new WebApplicationTemplateResolver(
                        application
                );

        // Where Thymeleaf looks for HTML files
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");

        // HTML template mode
        templateResolver.setTemplateMode(
                TemplateMode.HTML
        );

        // Character encoding
        templateResolver.setCharacterEncoding("UTF-8");

        // Disable cache during development
        templateResolver.setCacheable(false);

        // Create TemplateEngine
        TemplateEngine templateEngine =
                new TemplateEngine();

        templateEngine.setTemplateResolver(
                templateResolver
        );

        return templateEngine;
    }
}