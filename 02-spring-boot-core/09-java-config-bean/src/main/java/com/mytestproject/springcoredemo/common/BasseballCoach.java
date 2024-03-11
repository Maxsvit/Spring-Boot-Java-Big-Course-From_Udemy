package com.mytestproject.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BasseballCoach implements Coach{

    public BasseballCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes to batting practice";
    }
}
