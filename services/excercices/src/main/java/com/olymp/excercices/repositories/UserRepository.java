package com.olymp.excercices.repositories;

import com.olymp.excercices.entities.UserEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<UserEntity> readUser = (rs, rowNum) -> new UserEntity(rs.getInt("id"),
            rs.getString("nickname"), rs.getString("password"),
            rs.getString("email"), rs.getString("phone"), rs.getString("role"));


    public UserRepository(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean userExist(@NotNull String userName) {
        final String query = "SELECT COUNT(*) FROM USERS WHERE username=?";
        final int count = jdbcTemplate.queryForObject(query, new Object[]{userName}, Integer.class);
        return count != 0;
    }

    public void save(UserEntity userEntity) {
        final String query = "INSERT INTO USERS(nickname, password, email, phone, role) VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, userEntity.getNickname(), userEntity.getPassword(), userEntity.getEmail(),
                userEntity.getPhone(), userEntity.getRole());
    }

    public UserEntity getOne(String nickname) {
        final String query = "SELECT * FROM users WHERE nickname = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{nickname}, readUser);
    }
}
