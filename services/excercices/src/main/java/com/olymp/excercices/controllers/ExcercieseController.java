package com.olymp.excercices.controllers;

import com.olymp.excercices.entities.ExcercieseEntity;
import com.olymp.excercices.services.ExcercieseService;
import com.olymp.excercices.views.ExcercieseView;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/excercies/")
public class ExcercieseController {
    private final ExcercieseService excercieseService;

    public ExcercieseController(ExcercieseService excercieseService) {
        this.excercieseService = excercieseService;
    }

    @GetMapping(path = "excerciese/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getExcerciese(@PathVariable(name = "id") String id) {

        return ResponseEntity.ok("d");
    }

    @GetMapping(path = "/exercieses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getExcercices(@RequestParam(name = "limit", required = false) Integer limit,
                                                @RequestParam(name = "offset", required = false) Integer offset) {
        final List<ExcercieseEntity> excercieses = excercieseService.getList(limit, offset);

        return ResponseEntity.ok(excercieses);
    }

    @PatchMapping(path = "create", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createExcerciese(@RequestBody ExcercieseView excercieseView) {


        return ResponseEntity.ok("Ok");
    }

    @GetMapping(path = "excercices_marked", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getMarkedExcercices(@RequestParam(name = "limit", required = false) Integer limit,
                                                      @RequestParam(name = "offset", required = false) Integer offset) {
        return null;
    }

    @PostMapping(path = "mark/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> markExcerciese() {
        excercieseService.mark();
        return null;
    }


    @PostMapping(path = "update/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateExcerciese(@RequestBody ExcercieseView excercieseView) {
        excercieseService.update();
        return null;
    }
}
