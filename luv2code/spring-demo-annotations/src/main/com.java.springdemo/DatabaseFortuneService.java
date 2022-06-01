package com.java.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "You will design a good database today";
    }
}
