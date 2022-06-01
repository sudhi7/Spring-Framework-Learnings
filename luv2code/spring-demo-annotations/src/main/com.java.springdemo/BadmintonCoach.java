package com.java.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach{
    // Field Injection
    @Autowired
    @Qualifier("databaseFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Practise serving for 30 minutes";
    }
}
