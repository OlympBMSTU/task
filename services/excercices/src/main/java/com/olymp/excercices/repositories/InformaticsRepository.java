package com.olymp.excercices.repositories;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public class InformaticsRepository {
    @NotNull
    private final MongoOperations mongoOperations;

    public InformaticsRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }


}
