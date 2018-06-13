package com.performance.test.controllers;

import com.performance.test.entities.ExcercieseEntityM;
import com.performance.test.entities.ExcercieseEntityP;
import com.performance.test.servcies.ExcercieseM;
import com.performance.test.servcies.ExcercieseP;
import com.performance.test.views.ExcercieseView;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping(path = "/api/excercieses/")
public class Controller {
    private final ExcercieseP excercieseP;
    private final ExcercieseM excerccieseM;

    public Controller(ExcercieseP excercieseP, ExcercieseM excercieseM) {
        this.excercieseP = excercieseP;
        this.excerccieseM = excercieseM;
    }

    @PostMapping(path = "get/{db}/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getExcerciese(@PathVariable(name = "db") String db,
                                                @PathVariable(name = "id") String id) {
//        ExcercieseEntity excercieseEntity = excercieseService.getOne(getVariantView.getSubject().getName(), id);

        Object data;
        if (db.equals("mongo")) {
            data = excerccieseM.getOne("test", id);
        } else {
            data = excercieseP.getOne(id);
        }

        // todo return it in view
        return ResponseEntity.ok(data);
    }

    @PostMapping(path = "get_list/{db}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getExcercices(@PathVariable(name = "db") String db,
                                                @RequestParam(name = "limit", required = false) Integer limit,
                                                @RequestParam(name = "offset", required = false) Integer offset,
                                                HttpSession httpSession) {
        List<Object> data;
        if (db.equals("mongo")) {
            return ResponseEntity.ok(excerccieseM.getList("test", limit, offset));
        } else {
            return ResponseEntity.ok(excercieseP.getList(limit, offset));
        }
    }

    @PostMapping(path = "create/{db}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createExcerciese(@PathVariable(name = "db") String db,
                                                   @RequestBody ExcercieseView excercieseView, HttpSession httpSession) {
        if (db.equals("mongo")) {
            excerccieseM.save(ExcercieseEntityM.fromView(excercieseView), "test");
        } else {
            excercieseP.save(ExcercieseEntityP.fromView(excercieseView));
        }
        return ResponseEntity.ok("Ok");
    }

    @PostMapping(path = "level/{db}/{level}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> levelExcerciese(@PathVariable(name = "db") String db,
                                                  @PathVariable(name = "level") Integer level,
                                                  @RequestParam(name = "limit", required = false) Integer limit,
                                                  @RequestParam(name = "offset", required = false) Integer offset) {
        if (db.equals("mongo")) {
            return ResponseEntity.ok(excerccieseM.getListByLevel("test", level,limit, offset));
        } else {
            return ResponseEntity.ok(excercieseP.getListByLevel(level, limit, offset));
        }
    }

    @PostMapping(path = "type/{db}/{type}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> typeExcerciese(@PathVariable(name = "db") String db,
                                                  @PathVariable(name = "type") String type,
                                                  @RequestParam(name = "limit", required = false) Integer limit,
                                                  @RequestParam(name = "offset", required = false) Integer offset) {
        if (db.equals("mongo")) {
            return ResponseEntity.ok(excerccieseM.getListByType("test", type,limit, offset));
        } else {
            return ResponseEntity.ok(excercieseP.getListByType(type, limit, offset));
        }
    }


    @PostMapping(path = "level_and_type/{db}/{level}/{type}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> typeAndLevelExcerciese(@PathVariable(name = "db") String db,
                                                  @PathVariable(name = "level") Integer level,
                                                  @PathVariable(name = "type") String type,
                                                  @RequestParam(name = "limit", required = false) Integer limit,
                                                  @RequestParam(name = "offset", required = false) Integer offset) {
        if (db.equals("mongo")) {
            return ResponseEntity.ok(excerccieseM.getListByTypeAndLevel("test", level,type,
                    limit, offset));
        } else {
            return ResponseEntity.ok(excercieseP.getListByTypeAndLevel(level, type, limit, offset));
        }
    }
}