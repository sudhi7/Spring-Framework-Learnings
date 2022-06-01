package com.java.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{
    String[] fortunes = {
            "Luck is all your way",
            "The journey is the reward",
            "Beware of the wolf in sheep's clothing"
    };

    public String getFortune() {
        Random myRandom = new Random();
        int index = myRandom.nextInt(fortunes.length);

        String theFortune = fortunes[index];

        return theFortune;
    }
}
