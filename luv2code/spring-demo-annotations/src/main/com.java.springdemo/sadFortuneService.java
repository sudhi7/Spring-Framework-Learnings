package com.java.springdemo;

public class sadFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "Don't go deep inside water";
    }
}
