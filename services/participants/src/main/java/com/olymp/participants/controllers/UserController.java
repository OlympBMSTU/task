package com.olymp.participants.controllers;


// signin, signunp, signout,

import com.olymp.participants.entities.UserEntity;
import com.olymp.participants.services.UserService;
import com.olymp.participants.views.UserView;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static com.olymp.participants.controllers.Config.SESSION_KEY;


// todo private info send to another server, get its id and store
@RestController
@RequestMapping(path = "/api/user/")
public class UserController {
    private final UserService userService;
    public  UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "signup", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> signup(@RequestBody UserView userView, HttpSession httpSession) {
        UserEntity userEntity = userView.toEntity();
        if (userService.save(userEntity) != UserService.ResponseCode.OK) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("error");
        }

        httpSession.setAttribute(SESSION_KEY, userView.getNickname());
        return ResponseEntity.status(HttpStatus.CREATED).body("ok");
    }

    @PostMapping(path = "signin", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> signin(@RequestBody UserView userView, HttpSession httpSession) {
        if (userService.authorize(userView.toEntity()) != UserService.ResponseCode.OK) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("invalid data");
        }

        httpSession.setAttribute(SESSION_KEY, userView.getNickname());
        return ResponseEntity.ok("hi");
    }
}
