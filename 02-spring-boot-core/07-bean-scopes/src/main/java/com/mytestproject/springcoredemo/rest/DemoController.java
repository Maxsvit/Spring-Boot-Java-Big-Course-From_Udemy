package com.mytestproject.springcoredemo.rest;

import com.mytestproject.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController ( @Qualifier("cricketCoach")Coach coach,
                            @Qualifier("cricketCoach") Coach coach2){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = coach;
        anotherCoach = coach2;
    }



    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping ("/check")
    public String check(){
        return "Comparing beans: mycoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
