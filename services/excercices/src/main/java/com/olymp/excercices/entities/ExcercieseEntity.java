package com.olymp.excercices.entities;

import com.olymp.excercices.views.ExcercieseView;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = ExcercieseEntity.COLLECTION)
public class ExcercieseEntity {
    public static final String COLLECTION = "test";
    private String question;
    private List<AnswerEntity> answers;
    private String image;
    private String type;
    private String subject;
    private List<AnswerEntity> rightAnswers;

    public ExcercieseEntity(String question, List<AnswerEntity> answers, List<AnswerEntity> rightAnswers,
                            String image, String type, String subject) {
        this.question = question;
        this.answers = answers;
        this.image = image;
        this.type = type;
        this.subject = subject;
        this.rightAnswers = rightAnswers;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}

