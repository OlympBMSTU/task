package com.olymp.variants.repositories;

import com.olymp.variants.entirt.QuestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class VariantRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoOperations mongoOperations;

    public QuestionEntity getVariant(Integer variant) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(variant)), QuestionEntity.class, "test");
    }

    public void addQuestion(Integer id, QuestionEntity question) {

    }
}