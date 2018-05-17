package com.olymp.excercices.controllers;

import com.olymp.excercices.services.ExcercieseService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/excercies/")
public class ExcercieseController {
    private final ExcercieseService excercieseService;

    public ExcercieseController(ExcercieseService excercieseService) {
        this.excercieseService = excercieseService;
    }


    @GetMapping(path = "excerciese/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getExcerciese(@PathVariable(name = "id") String id) {
        return null;
    }

    @GetMapping(path = "/exercieses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getExcercices(@RequestParam(name = "limit", required = false) Integer limit,
                                                @RequestParam(name = "offset", required = false) Integer offset) {
        return null;
    }

    @PatchMapping(path = "create", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createExcerciese() {
        return null;
    }

    @PostMapping(path = "mark/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> markExcerciese() {
        return null;
    }


    @PostMapping(path = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateExcerciese() {
        return null;
    }
}
