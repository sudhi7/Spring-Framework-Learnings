package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            int studentId = 3005;
            session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Student with id : " + studentId);
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Deleting student with id 3000");
            session.delete(myStudent);

            System.out.println("Deleting student with id = 3002");
            session.createQuery("delete from Student where id=3002").executeUpdate();

            session.getTransaction().commit();

        }
        finally {
            factory.close();
        }

    }
}
