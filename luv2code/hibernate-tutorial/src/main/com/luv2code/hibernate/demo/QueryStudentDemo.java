package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Student> studentList = session.createQuery("from Student").getResultList();

            displayStudents(studentList);

            studentList = session.createQuery("from Student s where s.lastName='Doe'").getResultList();

            System.out.println("\n\nStudents with last name of Doe");

            displayStudents(studentList);

            studentList = session.createQuery("from Student s where" + " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();

            System.out.println("\n\nStudents with last name of Doe or first name Daffy");

            displayStudents(studentList);

            studentList = session.createQuery("from Student s where s.email LIKE '%luv2code.com'").getResultList();

            System.out.println("\n\nSudents with email ending with luv2code.com");

            displayStudents(studentList);

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }

    }

    private static void displayStudents(List<Student> studentList) {
        for(Student temp : studentList) {
            System.out.println(temp);
        }
    }
}
