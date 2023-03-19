package com.wh131462.controller.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/hello")
    public String hello() {
        String hello="<p>Hello, This is my api.</p>";
        return hello;
    }
}
