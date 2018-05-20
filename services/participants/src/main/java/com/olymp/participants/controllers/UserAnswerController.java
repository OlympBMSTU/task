package com.olymp.participants.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user_answers")
public class UserAnswerController {
    // todo check that user is the same
    public ResponseEntity<Object> saveTestAnswers() {
        return ResponseEntity.ok("hi");
    }
}
