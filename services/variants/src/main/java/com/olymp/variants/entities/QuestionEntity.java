package com.olymp.variants.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;


@Document(collection = QuestionEntity.COLLECTION_NAME)
public class QuestionEntity implements Serializable {
    static final String COLLECTION_NAME = "test";
    // todo delete this
    @Id
    private Integer id;
//    private Integer intId;
    private String question;
    private List<AnswerEntity> answers;
    private String image;
    private String type;

    // DELETE THIS
    private List<AnswerEntity> rightAnswer;

    public QuestionEntity(String question, List<AnswerEntity> answers, String type, String image) {
        this.answers = answers;
        this.question = question;
        this.image = image;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRightAnswer(List<AnswerEntity> rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public List<AnswerEntity> getRightAnswer() {
        return rightAnswer;
    }

    //

//    public Integer getIntId() {
//        return this.intId;
//    }
//
//    public void setIntId(Integer id) {
//        this.intId = id;
//    }

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

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
