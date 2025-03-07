package com.example.SpringCore.__Field_Dependency_Injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    // define a field inject the dependency
    @Autowired
    public Coach theCoach;

    @GetMapping("/getDailyWorkOut")
    public String getDailyWorkOut() {
        return theCoach.getDailyWorkOut();
    }
}
