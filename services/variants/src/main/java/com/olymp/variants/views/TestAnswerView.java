package com.olymp.variants.views;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TestAnswerView {
    private String id;
    private List<QuestionView.Answer> answers;

    @JsonCreator
    public TestAnswerView(@JsonProperty("id") String  id, @JsonProperty("answers") List<QuestionView.Answer> answers) {
        this.id = id;
        this.answers = answers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<QuestionView.Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<QuestionView.Answer> answers) {
        this.answers = answers;
    }
}

