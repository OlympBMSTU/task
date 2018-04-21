package com.olymp.variants.entirt;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Map;



@Document(collection = QuestionEntity.COLLECTION_NAME)
public class QuestionEntity implements Serializable {
    static final String COLLECTION_NAME = "test";
    @Field("id")
    Integer id;
    String question;
//    List<Answer> answers;
    Map<Integer, String> answers;
    byte[] image;

    public QuestionEntity(String question, Map<Integer, String> answers, byte[] image) {
        this.answers = answers;
        this.question = question;
        this.image = image;
    }


//    class Answer {
//        Integer id;
//        String type;
//        String answer;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<Integer, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Integer, String> answers) {
        this.answers = answers;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
