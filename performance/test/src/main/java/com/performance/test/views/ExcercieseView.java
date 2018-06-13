package com.performance.test.views;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ExcercieseView {
    //    private String subject;
    private String type;
    private String question;
//    private List<Answer> answers;
    private List<String> answers;
    private String image;
    private List<String> rightAnswers;
    // crutch
//    private List<Answer> rightAnswers;
    private Subject subject;
    private Integer level;

    public static class Answer {
        String id;
        String value;
        String text;
        Boolean correct;

        @JsonCreator
        Answer(@JsonProperty("value") String value, @JsonProperty("text") String text,
               @JsonProperty("id") String id, @JsonProperty("correct") Boolean correct) {
            this.value = value;
            this.text = text;
            this.id = id;
            this.correct = correct;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public Boolean isCorrect() {
            return correct;
        }

        public void setCorrect(Boolean correct) {
            this.correct = correct;
        }
    }



    public void setType(String type) {
        this.type = type;
    }
//
//    public void setRightAnswers(List<Answer> rightAnswers) {
//        this.rightAnswers = rightAnswers;
//    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @JsonCreator
    public ExcercieseView(@JsonProperty("question") String question,
                          @JsonProperty("answers") List<String> answers,
                          @JsonProperty("image") String image,
                          @JsonProperty("type") String type,
                          @JsonProperty("rightAnswers") List<String> rightAnswers,
                          @JsonProperty("subject") Subject subject,
                          @JsonProperty("level") Integer level) {
        this.answers = answers;
        this.image = image;
        this.subject = subject;
        this.question = question;
        this.type = type;
        this.rightAnswers = rightAnswers;
        this.level = level;
    }

    public Subject getSubject() {
        return subject;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public List<String> getRightAnswers() {
        return rightAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
