package com.olymp.variants.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VariantsController {
    // private final variantService;


    public VariantsController() {//VariantService variantService) {
        // this.variantService = variantService;
    }


    @GetMapping(path = "/api/variants/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getVariant(@RequestParam(value = "variant", required = false) Integer variant) {
        if (variant == null) {
            variant = 1;
        }
        return null;
    }

    @PostMapping(path = "/api/variant/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createVariant() {
        return null;
    }
}
