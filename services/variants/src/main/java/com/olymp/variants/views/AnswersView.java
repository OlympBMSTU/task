package com.olymp.variants.views;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AnswersView {
    private List<TestAnswerView> testAnswerViews;

    @JsonCreator
    public AnswersView(@JsonProperty("testAnswers") List<TestAnswerView> testAnswerViews) {
        this.testAnswerViews = testAnswerViews;
    }

    public List<TestAnswerView> getTestAnswerViews() {
        return testAnswerViews;
    }

    public void setTestAnswerViews(List<TestAnswerView> testAnswerViews) {
        this.testAnswerViews = testAnswerViews;
    }
}
