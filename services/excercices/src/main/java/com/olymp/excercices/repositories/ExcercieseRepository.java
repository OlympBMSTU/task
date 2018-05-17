package com.olymp.excercices.repositories;

import com.olymp.excercices.entities.ExcercieseEntity;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public class ExcercieseRepository {
    private final MongoOperations mongoOperations;

    public ExcercieseRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public ExcercieseEntity getOne(String id) {
        return mongoOperations.findOne(Query.query(Criteria.where("id").is(id)), ExcercieseEntity.class, "test");
    }

    public List<ExcercieseEntity> getList(Integer limit, Integer offset) {
        return null;
    }

    public void save(ExcercieseEntity excercieseEntity) {
        mongoOperations.save(excercieseEntity);
    }

}
