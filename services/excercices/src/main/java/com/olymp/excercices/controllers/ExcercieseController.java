package com.olymp.excercices.controllers;

import com.olymp.excercices.entities.ExcercieseEntity;
import com.olymp.excercices.services.ExcercieseService;
import com.olymp.excercices.views.ExcercieseView;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.olymp.excercices.controllers.Config.SESSION_KEY;

@RestController
@RequestMapping(path = "/api/excercieses/")
public class ExcercieseController {
    private final ExcercieseService excercieseService;

    public ExcercieseController(ExcercieseService excercieseService) {
        this.excercieseService = excercieseService;
    }

    @GetMapping(path = "get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getExcerciese(@PathVariable(name = "id") String id, HttpSession httpSession) {
        String nickname = (String) httpSession.getAttribute(SESSION_KEY);
        if (nickname == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("please authorzize");
        }
        ExcercieseEntity excercieseEntity = excercieseService.getOne(id);

        // todo return it in view
        return ResponseEntity.ok(excercieseEntity);
    }

    @GetMapping(path = "get_list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getExcercices(@RequestParam(name = "limit", required = false) Integer limit,
                                                @RequestParam(name = "offset", required = false) Integer offset,
                                                HttpSession httpSession) {
        String nickname = (String) httpSession.getAttribute(SESSION_KEY);
        if (nickname == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("please authorzize");
        }

        final List<ExcercieseEntity> excercieses = excercieseService.getList(limit, offset);

        // todo return it in view
        return ResponseEntity.ok(excercieses);
    }

    @PatchMapping(path = "create", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createExcerciese(@RequestBody ExcercieseView excercieseView, HttpSession httpSession) {
        String nickname = (String) httpSession.getAttribute(SESSION_KEY);
        if (nickname == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("please authorzize");
        }

        excercieseService.save(excercieseView.toEntity());
        return ResponseEntity.ok("Ok");
    }

    @GetMapping(path = "get_marked", produces = MediaType.APPLICATION_JSON_VALUE)
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
