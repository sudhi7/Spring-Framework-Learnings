package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Student student = new Student("Daffy", "Duck","daffy@luv2code.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();


            System.out.println("Generated id : " + student.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Student with id : " + student.getId());
            Student myStudent = session.get(Student.class, student.getId());
            System.out.println(myStudent.toString());
            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }
}
