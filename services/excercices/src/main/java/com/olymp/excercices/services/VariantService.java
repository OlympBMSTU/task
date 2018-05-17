package com.olymp.excercices.services;

import com.olymp.variants.entirt.QuestionEntity;
import com.olymp.variants.repositories.VariantRepository;
import org.springframework.stereotype.Service;

@Service
public class VariantService {
    VariantRepository variantRepository;

    public VariantService(VariantRepository variantRepository) {
        this.variantRepository = variantRepository;
    }

    public Object getVariant(Integer id) {
        return variantRepository.getVariant(id);
    }

    public void addQuestion(Integer id, QuestionEntity question) {
        variantRepository.addQuestion(id, question);
    }

    public void createVariant(Integer id) {
        variantRepository.createVariant(id);
    }
}
