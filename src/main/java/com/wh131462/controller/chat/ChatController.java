package com.wh131462.controller.chat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody String message){

        return ResponseEntity.ok("success");
    }
}
