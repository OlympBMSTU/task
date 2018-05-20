package com.olymp.participants.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.OncePerRequestFilter;


// todo here check that request from assigned service
@RestController
@RequestMapping("/api/user_test")
public class UserTestController {


    public ResponseEntity<Object> getTestForCheck() {
        return ResponseEntity.ok("hi");
    }

    public ResponseEntity<Object> setTestResult() {
        return ResponseEntity.ok("hi");
    }
}
