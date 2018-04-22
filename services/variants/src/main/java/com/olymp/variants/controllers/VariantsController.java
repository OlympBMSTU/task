package com.olymp.variants.controllers;

import com.olymp.variants.services.VariantService;
import com.olymp.variants.views.QuestionView;
import jdk.jfr.Threshold;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping(path = "/create_variant", //consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createVariant(@RequestParam(value = "id", required = true) Integer id) {
        variantService.createVariant(id);
        return ResponseEntity.ok("Ok");
    }
}
