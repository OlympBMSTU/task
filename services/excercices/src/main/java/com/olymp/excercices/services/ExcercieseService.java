package com.olymp.excercices.services;

import com.olymp.excercices.controllers.ExcercieseController;
import com.olymp.excercices.entities.ExcercieseEntity;
import com.olymp.excercices.repositories.InformaticsRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ExcercieseService {
    @NotNull
    private final InformaticsRepository informaticsRepository;

    public ExcercieseService(@NotNull InformaticsRepository informaticsRepository) {
        this.informaticsRepository = informaticsRepository;
    }

    public void save() {

    }

    public ExcercieseEntity getOne(String id) {
        return null;
    }

    public List<ExcercieseEntity> getList(Integer limit, Integer offser) {
        return null;
    }

    public void mark() {

    }

    public void update() {

    }

}
