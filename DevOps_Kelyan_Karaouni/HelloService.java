package com.example.DevOps_Kelyan_Karaouni;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloService {

    @GetMapping
    public String hello() {
        return "hello";
    }
}
