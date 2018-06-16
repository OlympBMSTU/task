package com.performance.test.entities;

import com.performance.test.views.ExcercieseView;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExcercieseEntityP {
    private String question;
    private List<AnswerEntity> answers;
    private String image;
    private String type;
    private List<AnswerEntity> rightAnswers;
    private Integer level;

    public ExcercieseEntityP(String question, List<AnswerEntity> answers, List<AnswerEntity> rightAnswers,
                             String image, String type, Integer level) {
        this.question = question;
        this.answers = answers;
        this.image = image;
        this.type = type;
        this.rightAnswers = rightAnswers;
        this.level = level;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerEntity> getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(List<AnswerEntity> rightAnswers) {
        this.rightAnswers = rightAnswers;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public static ExcercieseEntityP fromView(ExcercieseView view) {
        List<AnswerEntity> answerEntities = view.getAnswers()
                .stream()
                .map(answer -> new AnswerEntity(answer.getId(), answer.getText(), answer.getValue()))
                .collect(Collectors.toList());

        List<AnswerEntity> rightAnswers = view.getAnswers()
                .stream()
                .filter(ExcercieseView.Answer::isCorrect)
                .map(answer -> new AnswerEntity(answer.getId(), answer.getText(), answer.getValue()))
                .collect(Collectors.toList());

        return new ExcercieseEntityP(view.getQuestion(), answerEntities, rightAnswers, view.getImage(),
                view.getType(), view.getLevel());
    }
}
