package com.olymp.excercices.controllers;

import com.olymp.excercices.services.UserService;
import com.olymp.excercices.views.UserView;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    private final UserService userService;
    public  UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "signup", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> signup(@RequestBody UserView userView) {


        return null;
    }

    @PostMapping(path = "signin", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> signin(@RequestBody UserView userView) {

        return null;
    }



}
