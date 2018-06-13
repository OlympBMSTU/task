package com.performance.test.entities;

import com.performance.test.views.ExcercieseView;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
public class ExcercieseEntityM {
    private String question;
    private List<String> answers;
    private String image;
    private String type;
    private List<String> rightAnswers;
    private Integer level;


    public ExcercieseEntityM(String question, List<String> answers, List<String> rightAnswers,
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

    public List<String> getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(List<String> rightAnswers) {
        this.rightAnswers = rightAnswers;
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

    public static ExcercieseEntityM fromView(ExcercieseView view) {
        return new ExcercieseEntityM (view.getQuestion(), view.getAnswers(), view.getRightAnswers(), view.getImage(),
                view.getType(), view.getLevel());
    }
}

