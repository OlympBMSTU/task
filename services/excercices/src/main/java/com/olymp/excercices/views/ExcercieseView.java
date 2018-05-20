package com.olymp.excercices.views;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.olymp.excercices.entities.AnswerEntity;
import com.olymp.excercices.entities.ExcercieseEntity;

import java.util.ArrayList;
import java.util.List;


public class ExcercieseView {
    private String subject;
    private String type;
    private String question;
    private List<Answer> answers;
    private String image;
    private List<Answer> rightAnswers;


    public static class Answer {
        String value;
        String text;

        @JsonCreator
        Answer(@JsonProperty("value") String value, @JsonProperty("text") String text) {
            this.value = value;
            this.text = text;
        }
    }

    @JsonCreator
    public ExcercieseView(@JsonProperty("question") String question,
                          @JsonProperty("subject") String subject,
                          @JsonProperty("answers") List<Answer> answers,
                          @JsonProperty("image") String image,
                          @JsonProperty("type") String type,
                          @JsonProperty("rightAnswers") List<Answer> rightAnswers) {
        this.answers = answers;
        this.image = image;
        this.subject = subject;
        this.question = question;
        this.type = type;
        this.rightAnswers = rightAnswers;
    }

    public String getType() {
        return type;
    }

    public List<Answer> getRightAnswers() {
        return rightAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ExcercieseEntity toEntity() {
        List<AnswerEntity> answersEntity = new ArrayList<>();
        List<AnswerEntity> rightAE = new ArrayList<>();
        answers.forEach(answer -> answersEntity.add(new AnswerEntity(answer.value, answer.text)));
        rightAnswers.forEach(answer -> rightAE.add(new AnswerEntity(answer.value, answer.text)));
        return new ExcercieseEntity(question, answersEntity, rightAE, type, image, subject);
    }
}
