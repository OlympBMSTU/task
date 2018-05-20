package com.olymp.variants.controllers;

import com.olymp.variants.entities.AnswerEntity;
import com.olymp.variants.entities.QuestionEntity;
import com.olymp.variants.entities.VariantEntity;
import com.olymp.variants.services.VariantService;
import com.olymp.variants.views.AnswersView;
import com.olymp.variants.views.QuestionView;
import jdk.jfr.Threshold;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// todo create userview, userre - admins and others
// todo check right and session when create
// todo service authorization

@RestController
@RequestMapping(path = "/api/variants/")
public class VariantsController {
    private final VariantService variantService;

    public VariantsController(VariantService variantService) {
        this.variantService = variantService;
    }


    @GetMapping(path = "get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getVariant(@RequestParam(value = "variant", required = false) Integer variant) {
        if (variant == null) {
            variant = 1;
        }
        Object variantData = variantService.getVariant(variant);
        return ResponseEntity.ok(variantData);
    }

    @PostMapping(path = "add_question/{variant_id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addQuestion(@PathVariable("variant_id") Integer variantId,
                                              @RequestBody QuestionView question) {
        variantService.addQuestion(variantId, question.toEntity());
        return ResponseEntity.ok("Ok");
    }

    private boolean check(List<AnswerEntity>  rightAnswers, List<QuestionView.Answer> givenAnswers) {
        if (rightAnswers.size() != givenAnswers.size()) {
            return false;
        }
        for (AnswerEntity answer: rightAnswers) {
            for (QuestionView.Answer answersView: givenAnswers) {
                if (!(answer.getText().equals(answersView.getText()) &&
                        answer.getValue().equals(answersView.getValue()))) {
                    return false;
                }
            }
        }
        return true;
    }

    @PostMapping(path = "create",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createVariant(@RequestParam(value = "id", required = true) Integer id) {
        variantService.createVariant(id);
        return ResponseEntity.ok("Ok");
    }

//    @PostMapping(path = "check/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Object> checkVariant(@PathVariable(name = "id") Integer id,
//                                               @RequestBody AnswersView answersView) {
//        VariantEntity variantEntity = (VariantEntity) variantService.getVariant(id);
//        for (QuestionEntity questionEntity: variantEntity.getQuestions()) {
//            for ()
//            if (check(questionEntity.getAnswers(), ))
//        }
//        );
//
//        return null;
//    }
}
