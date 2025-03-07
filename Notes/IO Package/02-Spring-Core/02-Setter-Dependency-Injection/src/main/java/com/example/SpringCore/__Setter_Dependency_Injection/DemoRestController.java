package com.example.SpringCore.__Setter_Dependency_Injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    private Coach coach;

    @Autowired
    public void setCoach(Coach theCoach) {
        coach = theCoach;
    }

    @GetMapping("/getDailyWorkOut")
    public String getDailyWorkOut() {
        return "Practice fast bowling for 30 minutes.Now";
    }
}
