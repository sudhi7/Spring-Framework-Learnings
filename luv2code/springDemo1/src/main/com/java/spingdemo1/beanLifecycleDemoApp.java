package com.java.spingdemo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanLifecycleDemoApp {
    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("webapp/WEB-INF/beanLifeCycle-applicationContext.xml");

        //retrive bean from spring container
        Coach coach1 = context.getBean("trackCoach", Coach.class);

        System.out.println(coach1.getDailyWorkout());

        // close the context
        context.close();

    }
}
