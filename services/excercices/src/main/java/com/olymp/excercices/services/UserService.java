package com.olymp.excercices.services;

import com.olymp.excercices.entities.UserEntity;
import com.olymp.excercices.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;

@Service
public class UserService {
    @NotNull
    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public enum ResponseCode {
        @SuppressWarnings("EnumeratedConstantNamingConvention") OK,
        LOGIN_IS_TAKEN,
        EMAIL_IS_TAKEN,
        INCORRECT_LOGIN,
        INCORRECT_PASSWORD,
        DATABASE_ERROR
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public ResponseCode authorize(UserEntity userEntity) {
        try {
            final UserEntity existingUser = userRepository.getOne(userEntity.getNickname());
            if (!passwordEncoder().matches(userEntity.getPassword(), existingUser.getPassword())) {
                return ResponseCode.INCORRECT_PASSWORD;
            }
        } catch (EmptyResultDataAccessException eRDAEx) {
            LOGGER.error(eRDAEx.getLocalizedMessage());
            return ResponseCode.INCORRECT_LOGIN;
        } catch (DataAccessException dAEx) {
            LOGGER.error(dAEx.getLocalizedMessage());
            return ResponseCode.DATABASE_ERROR;
        }
        return ResponseCode.OK;
    }

    public ResponseCode save(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder().encode(userEntity.getPassword()));

        try {
            userRepository.save(userEntity);
        } catch (DuplicateKeyException dupEx) {
            if (dupEx.getMessage().contains("username_key")) {
                return ResponseCode.LOGIN_IS_TAKEN;
            } else {
                return ResponseCode.EMAIL_IS_TAKEN;
            }
        } catch (DataAccessException daEx) {
            LOGGER.error("Error DataBase", daEx);
            return ResponseCode.DATABASE_ERROR;
        }

        return ResponseCode.OK;
    }

    // implement
    public ResponseCode update() {
        return null;
    }
}