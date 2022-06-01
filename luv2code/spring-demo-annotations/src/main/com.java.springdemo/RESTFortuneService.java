package com.java.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "Your requests are going to be failed today";
    }
}
