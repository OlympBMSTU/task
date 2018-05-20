package com.olymp.participants.controllers;


import com.olymp.participants.services.UserAnswerService;
import org.apache.catalina.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/user_answers")
public class UserAnswerController {
    private final UserAnswerService userAnswerService;
    public  UserAnswerController(@NotNull UserAnswerService userAnswerService) {
        this.userAnswerService = userAnswerService;
    }
    // todo check that user is the same
    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveTestAnswers(@RequestBody AnswersView answersView ) {
        return ResponseEntity.ok("hi");
    }
}
