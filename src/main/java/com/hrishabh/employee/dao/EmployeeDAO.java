package com.hrishabh.employee.dao;

import com.hrishabh.employee.model.Employee;
import com.hrishabh.employee.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // CREATE
    public void saveEmployee(Employee employee) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(employee);

            transaction.commit();

            System.out.println("Employee saved successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }


    // READ - Get all employees
    public List<Employee> getAllEmployees() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session
                    .createQuery("from Employee", Employee.class)
                    .getResultList();

        } catch (Exception e) {

            e.printStackTrace();

            return new ArrayList<>();
        }
    }


    // UPDATE
    public void updateEmployee(Employee employee) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.merge(employee);

            transaction.commit();

            System.out.println("Employee updated successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
    // DELETE
    public void deleteEmployee(Long id) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Employee employee = session.get(Employee.class, id);

            if (employee != null) {

                session.remove(employee);

                System.out.println("Employee deleted successfully!");

            } else {

                System.out.println("Employee not found!");

            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }
}