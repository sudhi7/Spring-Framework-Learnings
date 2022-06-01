package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 1;
           Query<Instructor> query = session.createQuery("select i from Instructor i "
                   + "JOIN FETCH i.courses "
                           + "where i.id=:theInstructorId",
                   Instructor.class);

           query.setParameter("theInstructorId", id);

           Instructor tempInstructor = query.getSingleResult();

            System.out.println("luv2code: Instructor: " + tempInstructor);
            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
            
            session.getTransaction().commit();
            session.close();
        }
        finally {
            factory.close();
        }

    }
}
