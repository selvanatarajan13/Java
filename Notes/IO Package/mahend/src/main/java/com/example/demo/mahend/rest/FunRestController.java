package com.example.demo.mahend.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FunRestController {

    @Autowired
    @Value("${applicationn.name}")
    private String name;

    @GetMapping("/")
    @ResponseBody
    public String helloWorld() {
        return "Hello World!" + name;
    }
}
