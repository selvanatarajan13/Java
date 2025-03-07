package com.example.SpringCore.__Constructore_Dependency_Injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    // define a private field for the dependency
    private Coach coach;

    // define constructor for dependency injection
    @Autowired
    public DemoRestController(Coach theCoach) {
        coach = theCoach;
    }

    @GetMapping("/getDailyWorkOut")
    public String getDailyWorkout() {
        return coach.getDailyWorkouts();
    }
}
