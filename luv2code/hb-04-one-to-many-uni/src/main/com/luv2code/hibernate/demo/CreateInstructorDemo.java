package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            Instructor instructor1 = new Instructor("Susan", "Public", "susan.public@luv2code.com");
            InstructorDetail detail1 = new InstructorDetail("http://www.youtube.com/youtube", "gaming");
            instructor1.setInstructorDetail(detail1);

            session.beginTransaction();

            session.save(instructor1);

            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }

    }
}
