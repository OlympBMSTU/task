package com.performance.test.entities;

public class AnswerEntity {
    private String id;
    private String value;
    private String text;
    private Boolean correct;

    public AnswerEntity(String id, String value, String text, Boolean correct) {
        this.id = id;
        this.value = value;
        this.text = text;
        this.correct = correct;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}