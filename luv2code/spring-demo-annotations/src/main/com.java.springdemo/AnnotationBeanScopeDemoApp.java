package com.java.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("webapp/WEB-INF/applicationContext.xml");

        Coach coach1 = context.getBean("tennisCoach", Coach.class);

        Coach coach2 = context.getBean("tennisCoach", Coach.class);

        boolean result = (coach1 == coach2);

        System.out.println("Pointing to same object? " + result);

        System.out.println("Memory location of coach1 : " + coach1);

        System.out.println("Memory location of coach2 : " + coach2);

    }
}
