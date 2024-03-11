package com.mytestproject.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BasseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes to batting practice";
    }
}
