package com.olymp.excercices.services;

import com.olymp.excercices.entities.ExcercieseEntity;
import com.olymp.excercices.repositories.ExcercieseRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ExcercieseService {
    private final ExcercieseRepository excercieseRepository;

    public ExcercieseService(@NotNull ExcercieseRepository excercieseRepository) {
        this.excercieseRepository = excercieseRepository;
    }

    public List<ExcercieseEntity> getListIds(String collectionName, Integer limit, Integer offset) {
        return excercieseRepository.getListIds(collectionName, limit, offset);
    }


    public void save(ExcercieseEntity excercieseEntity, String collectionName) {
        excercieseRepository.save(excercieseEntity, collectionName);
    }

    public ExcercieseEntity getOne(String collectionName, String id) {
        return excercieseRepository.getOne(collectionName, id);
    }

    public List<ExcercieseEntity> getList(String collectionName, Integer limit, Integer offset) {
        return excercieseRepository.getList(collectionName, limit, offset);
    }


    // implement
    public void mark() {

    }

    // implement
    public void update() {

    }

}
