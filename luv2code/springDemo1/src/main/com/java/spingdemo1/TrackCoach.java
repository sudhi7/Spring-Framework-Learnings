package com.java.spingdemo1;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    // add an init method
    public void startUp() {
        System.out.println("TrackXoach: inside method startUp()");
    }

    // add a destroy method
    public void cleanUp() {
        System.out.println("TrackCoach: inside method cleanUp()");
    }

}
