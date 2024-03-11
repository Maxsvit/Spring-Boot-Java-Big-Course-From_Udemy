package com.example.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping ("/")
    public String sayHello(){
        return "Hello World";
    }

    @Value("${coach.name}")
    private String coachName;

}
