package com.olymp.variants.views;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.olymp.variants.entirt.QuestionEntity;

import java.util.Map;

public class QuestionView {
    Integer id;
    String question;
    //    List<Answer> answers;
    Map<Integer, String> answers;
    byte[] image;

    @JsonCreator
    QuestionView(@JsonProperty("question") String question,
                 @JsonProperty("answers") Map<Integer, String> answers,
                 @JsonProperty("image") byte[] image) {
        this.answers = answers;
        this.image = image;
        this.question = question;
    }

    public QuestionEntity toEntity() {
        return  new QuestionEntity(question, answers, image);
    }
}
