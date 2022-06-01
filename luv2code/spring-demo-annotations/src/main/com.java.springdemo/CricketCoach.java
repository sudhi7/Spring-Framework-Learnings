package com.java.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Value("${cricket.workout}")
    private String workout;

    @Value("${cricket.fortune}")
    private String fortune;

    @Override
    public String getDailyWorkout() {
        return workout;
    }

    @Override
    public String getDailyFortune() {
        return fortune;
    }
}
