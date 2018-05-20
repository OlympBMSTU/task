package com.olymp.variants.views;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.olymp.variants.entities.AnswerEntity;
import com.olymp.variants.entities.QuestionEntity;
import jdk.security.jarsigner.JarSigner;

import java.util.ArrayList;
import java.util.List;


public class QuestionView {
    private String question;
    private String type;
    private List<Answer> answers;
    private String image;

    // delete this
    private List<Answer> rightAnswer;


    public static class Answer {
        String value;
        String text;

        @JsonCreator
        Answer(@JsonProperty("value") String value, @JsonProperty("text") String text) {
            this.value = value;
            this.text = text;
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

    @JsonCreator
    QuestionView(@JsonProperty("question") String question,
                 @JsonProperty("type") String type,
                 @JsonProperty("answers") List<Answer> answers,
                 @JsonProperty("image") String image,
                 @JsonProperty("rightAnswers") List<Answer> rightAnswers) {
        this.answers = answers;
        this.image = image;
        this.type = type;
        this.question = question;

        ///
        this.rightAnswer = rightAnswers;
    }


    public List<Answer> getRightAnswer() {
        return rightAnswer;
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
        List<AnswerEntity> rightAE = new ArrayList<>();
        if (rightAnswer != null) {
            rightAnswer.forEach(answer -> rightAE.add(new AnswerEntity(answer.value, answer.text)));
        }
        if (answers != null) {
            answers.forEach(answer -> answersEntity.add( new AnswerEntity(answer.value, answer.text)));
        }
        QuestionEntity questionEntity = new QuestionEntity(question, answersEntity, type, image);
        questionEntity.setRightAnswer(rightAE);
        return questionEntity;
    }
}
