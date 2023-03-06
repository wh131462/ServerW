package com.wh131462;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/sw")
public class Server
{
    public static void main(String[] args) {
        SpringApplication.run(Server.class, args);
    }
}
