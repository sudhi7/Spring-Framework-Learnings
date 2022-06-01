package com.java.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.java.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    public FortuneService sadFortuneService() {
        return new sadFortuneService();
    }

    @Bean
    public Coach swimCoach() {
        SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());
        return mySwimCoach;
    }

}
