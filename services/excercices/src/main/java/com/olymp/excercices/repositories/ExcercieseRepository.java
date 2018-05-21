package com.olymp.excercices.repositories;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.olymp.excercices.entities.ExcercieseEntity;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class ExcercieseRepository {
    private final MongoOperations mongoOperations;

    public ExcercieseRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public ExcercieseEntity getOne(String collectionName, String id) {
        return mongoOperations.findOne(Query.query(Criteria.where("_id").is(id)), ExcercieseEntity.class, collectionName);
    }

    public List<ExcercieseEntity> getListIds(String collectionName, Integer limit, Integer offset) {
        Query query = new Query();
        query.limit(limit);
        query.skip(offset);
        query.fields().include("_id");

        return mongoOperations.find(query, ExcercieseEntity.class, collectionName);
    }

    public List<ExcercieseEntity> getList(String collectionName, Integer limit, Integer offset) {
        Query query = new Query();
        query.limit(limit);
        query.skip(offset);

        return mongoOperations.find(query, ExcercieseEntity.class, collectionName);
    }

    public void save(ExcercieseEntity excercieseEntity, String collectionName) {
        mongoOperations.save(excercieseEntity, collectionName);
    }

}
