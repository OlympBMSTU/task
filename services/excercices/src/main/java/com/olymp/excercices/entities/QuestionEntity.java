package com.olymp.excercices.entities;

import com.olymp.variants.views.QuestionView;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;


@Document(collection = QuestionEntity.COLLECTION_NAME)
public class QuestionEntity implements Serializable {
    static final String COLLECTION_NAME = "test";
    //@Id
    //String id;
    //@Field("int_id")
    Integer intId;

    String question;
    List<AnswerEntity> answers;
    String image;
    String type;

    public QuestionEntity(String question, List<AnswerEntity> answers, String type, String image) {
        this.answers = answers;
        this.question = question;
        this.image = image;
        this.type = type;
    }

    //public String getId() {
      //  return id;
    //}

    public Integer getIntId() {
        return this.intId;
    }

    public void setIntId(Integer id) {
        this.intId = id;
    }

//    public void setId(String id) {
//        this.id = id;
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
