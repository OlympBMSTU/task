package com.olymp.variants.views;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.olymp.variants.entirt.AnswerEntity;
import com.olymp.variants.entirt.QuestionEntity;

import java.util.ArrayList;
import java.util.List;


public class QuestionView {
    private String question;
    private String type;
    private List<Answer> answers;
    private String image;


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
    QuestionView(@JsonProperty("question") String question,
                 @JsonProperty("type") String type,
                 @JsonProperty("answers") List<Answer> answers,
                 @JsonProperty("image") String image) {
        this.answers = answers;
        this.image = image;
        this.type = type;
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public QuestionEntity toEntity() {
        List<AnswerEntity> answersEntity = new ArrayList<>();
        answers.forEach(answer -> answersEntity.add( new AnswerEntity(answer.value, answer.text)));
        return  new QuestionEntity(question, answersEntity, type, image);
    }
}
