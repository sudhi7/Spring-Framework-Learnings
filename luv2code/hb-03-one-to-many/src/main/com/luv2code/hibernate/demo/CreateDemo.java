package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

//            Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
//            InstructorDetail detail = new InstructorDetail("http://www.luv2code.com/youtube", "coding");

//            instructor.setInstructorDetail(detail);\

            Instructor instructor1 = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
            InstructorDetail detail1 = new InstructorDetail("http://www.youtube.com/youtube", "guitar");
            instructor1.setInstructorDetail(detail1);

            session.beginTransaction();

//            session.save(instructor);
            session.save(instructor1);

            session.getTransaction().commit();
        }
        finally {
            factory.close();
        }

    }
}
