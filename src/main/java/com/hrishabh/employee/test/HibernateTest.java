package com.hrishabh.employee.test;

import com.hrishabh.employee.util.HibernateUtil;
import org.hibernate.Session;

public class HibernateTest {

    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            System.out.println("=================================");
            System.out.println("Hibernate connection successful!");
            System.out.println("=================================");

        } catch (Exception e) {

            System.out.println("Hibernate connection failed!");

            e.printStackTrace();
        }
    }
}