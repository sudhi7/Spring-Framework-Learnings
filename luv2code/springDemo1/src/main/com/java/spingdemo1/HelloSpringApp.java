package com.java.spingdemo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("webapp/WEB-INF/applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("trackCoach", Coach.class);
        Coach coach1 = context.getBean("baseballCoach",Coach.class);
        CricketCoach coach2 = context.getBean("cricketCoach",CricketCoach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println(coach1.getDailyWorkout());
        System.out.println(coach2.getDailyFortune());
        System.out.println(coach2.getEmailAddress());
        System.out.println(coach2.getTeam());

        // close the context
        context.close();
    }
}
