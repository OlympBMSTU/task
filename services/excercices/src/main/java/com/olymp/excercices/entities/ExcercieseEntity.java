package com.olymp.excercices.entities;

import com.olymp.excercices.views.ExcercieseView;

import java.util.List;

public class ExcercieseEntity {
    private String question;
    private List<AnswerEntity> answers;
    private String image;
    private String type;
    private String subject;

    public ExcercieseEntity(String question, List<AnswerEntity> answers, String image, String type, String subject) {
        this.question = question;
        this.answers = answers;
        this.image = image;
        this.type = type;
        this.subject = subject;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerEntity> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerEntity> answers) {
        this.answers = answers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

