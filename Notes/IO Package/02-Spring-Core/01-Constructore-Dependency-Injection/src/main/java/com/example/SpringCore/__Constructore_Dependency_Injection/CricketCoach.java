package com.example.SpringCore.__Constructore_Dependency_Injection;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkouts() {
        return "Pratice fast bowling for 15 minutes..";
    }
}
