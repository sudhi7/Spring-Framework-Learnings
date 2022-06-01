package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Course tempCourse = new Course("Pacman - How to score one million points");

            System.out.println("Saving the course...");
            session.save(tempCourse);
            System.out.println("Saved the course: " + tempCourse);

            Student s1 = new Student("John","Doe","john@luv2code.com");
            Student s2 = new Student("Mary","Public","mary@luv2code.com");

            tempCourse.addStudent(s1);
            tempCourse.addStudent(s2);

            System.out.println("Saving students...");
            session.save(s1);
            session.save(s2);
            System.out.println(tempCourse.getStudents());

            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
