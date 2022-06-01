package com.java.spingdemo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanScopeDemoApp {
    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("webapp/WEB-INF/beanScope-applicationContext.xml");

        //retrive bean from spring container
        Coach coach1 = context.getBean("trackCoach", Coach.class);
        Coach coach2 = context.getBean("trackCoach", Coach.class);

        // Check if they are the same
        boolean result = (coach1 == coach2);

        System.out.println("Pointing to same object? " + result);
        System.out.println("Memory location for coach1 : " + coach1);
        System.out.println("Memory location for coach2 : " + coach2);

    }
}
