package com.example.SpringCore.__Field_Dependency_Injection;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkOut() {
        return "Practice fast bowling as well as running for 40 minutes..";
    }
}
