package com.olymp.participants.controllers;

import com.olymp.participants.services.UserAnswerService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.validation.constraints.NotNull;


// todo here check that request from assigned service
@RestController
@RequestMapping("/api/user_test")
public class CheckTestController {

    private final UserAnswerService userAnswerService;
    public  CheckTestController(@NotNull UserAnswerService userAnswerService) {
        this.userAnswerService = userAnswerService;
    }

    @GetMapping(path = "get_tests", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTestsForCheck(@RequestParam(name = "limit", required = false) Integer limit,
                                           @RequestParam(name = "offset", required = false) Integer offset) {

        return ResponseEntity.ok("hi");
    }

    @GetMapping(path = "get/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getTestForCheck(@PathVariable String id) {
        return ResponseEntity.ok("hi");
    }

    @PostMapping(path = "set_result/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> setTestResult() {
        return ResponseEntity.ok("hi");
    }
}
