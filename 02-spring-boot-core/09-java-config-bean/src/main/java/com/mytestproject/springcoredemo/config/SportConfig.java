package com.mytestproject.springcoredemo.config;

import com.mytestproject.springcoredemo.common.Coach;
import com.mytestproject.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
