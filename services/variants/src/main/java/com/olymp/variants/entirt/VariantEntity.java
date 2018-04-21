package com.olymp.variants.entirt;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

public class VariantEntity {
    @Field("id")
    private Integer id;
    private Integer couuntQuestions;
    private List<QuestionEntity> questions = new ArrayList<>();

    public List<QuestionEntity> getQuestions() {
        return questions;
    }
}
