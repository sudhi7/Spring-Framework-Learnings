package com.java.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ChessCoach implements Coach{

    private FortuneService fortuneService;

    public ChessCoach() {
        System.out.println("ChessCoach: inside default constructor");
    }

    // Setter Injection
    @Autowired
    @Qualifier("randomFortuneService")
    public void doSomeCrazyStuff(FortuneService fortuneService) {
        System.out.println("ChessCoach: inside doSomeCrazyStuff() method");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practise chess notations";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
