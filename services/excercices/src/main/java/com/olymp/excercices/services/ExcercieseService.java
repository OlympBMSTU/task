package com.olymp.excercices.services;

import com.olymp.excercices.entities.ExcercieseEntity;
import com.olymp.excercices.repositories.ExcercieseRepository;
import com.olymp.excercices.repositories.InformaticsRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ExcercieseService {
    @NotNull
    private final InformaticsRepository informaticsRepository;

    private final ExcercieseRepository excercieseRepository;

    public ExcercieseService(@NotNull InformaticsRepository informaticsRepository,
                             @NotNull ExcercieseRepository excercieseRepository) {
        this.informaticsRepository = informaticsRepository;
        this.excercieseRepository = excercieseRepository;
    }

    public void save(ExcercieseEntity excercieseEntity) {
        excercieseRepository.save(excercieseEntity);
    }

    public ExcercieseEntity getOne(String id) {
        return excercieseRepository.getOne(id);
    }

    public List<ExcercieseEntity> getList(Integer limit, Integer offset) {
        return excercieseRepository.getList(limit, offset);
    }


    // implement
    public void mark() {

    }

    // implement
    public void update() {

    }

}
