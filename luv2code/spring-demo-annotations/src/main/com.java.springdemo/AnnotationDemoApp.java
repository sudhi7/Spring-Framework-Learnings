package com.java.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("webapp/WEB-INF/applicationContext.xml");

        Coach coach = context.getBean("tennisCoach", Coach.class);

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        Coach coach1 = context.getBean("chessCoach", Coach.class);

        System.out.println(coach1.getDailyWorkout());
        System.out.println(coach1.getDailyFortune());

        Coach coach2 = context.getBean("badmintonCoach", Coach.class);

        System.out.println(coach2.getDailyWorkout());
        System.out.println(coach2.getDailyFortune());

        Coach coach3 = context.getBean("cricketCoach", Coach.class);

        System.out.println(coach3.getDailyWorkout());

        context.close();

    }
}
