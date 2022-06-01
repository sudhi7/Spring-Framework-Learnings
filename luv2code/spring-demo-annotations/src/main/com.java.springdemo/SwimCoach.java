package com.java.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{

    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Override
    public String getDailyWorkout() {
        return "Swim for 30 mins";
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
