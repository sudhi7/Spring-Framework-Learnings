package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student1 = new Student("John", "Doe","john@luv2code.com");
            Student student2 = new Student("Mary", "Public","mary@luv2code.com");
            Student student3 = new Student("Bonita", "Alex","bonita@luv2code.com");
            session.beginTransaction();
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }

    }
}
