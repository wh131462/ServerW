package com.wh131462.controller.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/hello")
    public String hello() {
        return "<p>Hello, This is my api.</p>";
    }
}
