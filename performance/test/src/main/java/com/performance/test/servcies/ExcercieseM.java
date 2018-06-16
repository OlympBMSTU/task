package com.performance.test.servcies;

import com.performance.test.Statistic;
import com.performance.test.entities.ExcercieseEntityM;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ExcercieseM {
    private final MongoOperations mongoOperations;
    private final Statistic statistic;

    public ExcercieseM(MongoOperations mongoOperations, Statistic statistic) {

        this.mongoOperations = mongoOperations;
        this.statistic = statistic;
    }

    public ExcercieseEntityM getOne(String collectionName, String id) {
        return mongoOperations.findOne(Query.query(Criteria.where("_id").is(id)), ExcercieseEntityM.class, collectionName);
    }

    @PostConstruct
    public void init() {
        statistic.register(this.getClass());
    }

    public List<ExcercieseEntityM> getListIds(String collectionName, Integer limit, Integer offset) {
        long start = System.currentTimeMillis();
        Query query = new Query();
        query.limit(limit);
        query.skip(offset);
        query.fields().include("_id");

        List<ExcercieseEntityM> e = mongoOperations.find(query, ExcercieseEntityM.class, collectionName);
        statistic.addVal(this.getClass(), "get", System.currentTimeMillis() - start);
        return e;
    }

    public List<ExcercieseEntityM> getList(String collectionName, Integer limit, Integer offset) {
        long start = System.currentTimeMillis();

        Query query = new Query();
        query.limit(limit);
        query.skip(offset);

        List<ExcercieseEntityM> e = mongoOperations.find(query, ExcercieseEntityM.class, collectionName);
        statistic.addVal(this.getClass(), "select", System.currentTimeMillis() - start);
        return e;

    }

    public void save(ExcercieseEntityM excercieseEntity, String collectionName) {
        long start = System.currentTimeMillis();
        mongoOperations.save(excercieseEntity, collectionName);
        statistic.addVal(this.getClass(), "insert", System.currentTimeMillis() - start);

    }

    public List<ExcercieseEntityM> getListByLevel(String collectionName, Integer level, Integer limit, Integer offset) {
        long start = System.currentTimeMillis();

        Query query = new Query(Criteria.where("level").is(level));
        query.limit(limit);
        query.skip(offset);

        List<ExcercieseEntityM> e = mongoOperations.find(query, ExcercieseEntityM.class, collectionName);
        statistic.addVal(this.getClass(), "select", System.currentTimeMillis() - start);

        return e;
    }


    public List<ExcercieseEntityM> getListByType(String collectionName, String type, Integer limit, Integer offset) {
        Query query = new Query(Criteria.where("type").is(type));
        query.limit(limit);
        query.skip(offset);

        return mongoOperations.find(query, ExcercieseEntityM.class, collectionName);
    }

    public List<ExcercieseEntityM> getListByTypeAndLevel(String collectionName, Integer level, String type,
                                                         Integer limit, Integer offset) {
        Query query = new Query(Criteria.where("level").is(level).and("type").is(type));
        query.limit(limit);
        query.skip(offset);

        return mongoOperations.find(query, ExcercieseEntityM.class, collectionName);
    }




}
