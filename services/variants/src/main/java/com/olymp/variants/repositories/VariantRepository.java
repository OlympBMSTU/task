package com.olymp.variants.repositories;

import com.olymp.variants.entirt.QuestionEntity;
import com.olymp.variants.entirt.VariantEntity;
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

    public VariantEntity getVariant(Integer variant) {
        return mongoOperations.findOne(Query.query(Criteria.where("int_id").is(variant)), VariantEntity.class, "test");
    }

    public void createVariant(Integer id) {
        VariantEntity variantEntity = new VariantEntity();
        variantEntity.setIntId(id);
        mongoOperations.save(variantEntity);
    }

    public void addQuestion(Integer id, QuestionEntity question) {
        VariantEntity variantEntity = mongoOperations.findOne(Query.query(Criteria.where("int_id").is(id)), VariantEntity.class, "test");
        variantEntity.addQuestion(question);
        mongoOperations.save(variantEntity);
    }
}