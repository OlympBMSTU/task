package com.olymp.variants.entirt;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = VariantEntity.COLLECTION)
public class VariantEntity {
    public static final String COLLECTION = "test";

    @Id
    private String id;
    @Field("int_id")
    private Integer intId;
    private Integer countQuestions;
    private List<QuestionEntity> questions = new ArrayList<>();

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIntId() {
        return this.intId;
    }

    public void setIntId(Integer id) {
        this.intId = id;
    }

    public Integer getCountQuestions() {
        return countQuestions;
    }

    public List<QuestionEntity> geQuestionEntities() {
        return this.questions;
    }

    public void setCountQuestions(Integer countQuestions) {
        this.countQuestions = countQuestions;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    public void addQuestion(QuestionEntity questionEntity) {
        this.questions.add(questionEntity);
    }
}
