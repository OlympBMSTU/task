package com.performance.test.servcies;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.performance.test.Statistic;
import com.performance.test.entities.AnswerEntity;
import com.performance.test.entities.ExcercieseEntityP;
import org.postgresql.util.PGobject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.StringWriter;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Service
public class ExcercieseP {
    private final JdbcTemplate jdbcTemplate;
    private final Statistic statistic;

    public ExcercieseP(JdbcTemplate jdbcTemplate, Statistic statistic) {
        this.jdbcTemplate = jdbcTemplate;
        this.statistic = statistic;
    }

    @PostConstruct
    public void init() {
        statistic.register(this.getClass());
    }

    private List<AnswerEntity> convertArray(Array array) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<?> arr = Arrays.asList((Object[]) array.getArray());
            return arr.stream().map(data -> {
                        try {
                            return objectMapper.readValue(((PGobject) (data)).getValue(), AnswerEntity.class);
                        } catch (Exception e) {
                            return null;
                        }
                    }
            ).collect(toList());
        } catch (SQLException e) {
            return null;
        }
    }

    private RowMapper<ExcercieseEntityP> excercieseMapper = (rs, row) -> {
        List<AnswerEntity> answers = convertArray(rs.getArray("answers"));
        List<AnswerEntity> rightAnswers = convertArray(rs.getArray("rightAnswers"));
        return new ExcercieseEntityP(rs.getString("question"), answers, rightAnswers,
                rs.getString("image"), rs.getString("type_"), rs.getInt("level_"));
    };


    // todo insert
    // todo get one
    // todo get list

    public void save(ExcercieseEntityP excerciese) {
        Long start = System.currentTimeMillis();
        final String insert = "INSERT into excercieses(question, answers, rightAnswers, image, type_, level_) " +
                "values(?, ?, ?, ?, ?, ?)";
        final ObjectMapper objectMapper = new ObjectMapper();

        String[] answers = excerciese.getAnswers()
                .stream()
                .map(answer -> {
                    try {
                        return objectMapper.writeValueAsString(answer);
                    } catch (Exception e) {
                        return null;
                    }
                })
                .toArray(String[]::new);

//        StringWriter sw = new StringWriter();
//        StringWriter sw2 = new StringWriter();
//        try {
//            objectMapper.writeValue(sw, excerciese.getAnswers());
//            objectMapper.writeValue(sw2, excerciese.getAnswers());
//        } catch (Exception e) {
//            return;
//        }

        String[] rightAnswers = excerciese.getRightAnswers()
                .stream()
                .map(answer -> {
                    try {
                        return objectMapper.writeValueAsString(answer);
                    } catch (Exception e) {
                        return null;
                    }
                })
                .toArray(String[]::new);


        try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
            Array ansersArr = conn.createArrayOf("json", answers);
            Array rightAnswersArr = conn.createArrayOf("json", rightAnswers);
            try (PreparedStatement preparedStatement = conn.prepareStatement(insert)) {
                preparedStatement.setString(1, excerciese.getQuestion());
                preparedStatement.setArray(2, ansersArr);
                preparedStatement.setArray(3, rightAnswersArr);
                preparedStatement.setString(4, excerciese.getImage());
                preparedStatement.setString(5, excerciese.getType());
                preparedStatement.setInt(6, excerciese.getLevel());
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.print(e.getSQLState());
            }
        } catch (SQLException e) {
            System.out.print(e.getSQLState());
        }
        statistic.addVal(this.getClass(), "insert", System.currentTimeMillis() - start);
    }

    public ExcercieseEntityP getOne(String id) {
        Integer iid = Integer.valueOf(id);
        String select = "SELECT * FROM excercieses WHERE id = ?";
        return jdbcTemplate.queryForObject(select, new Object[]{iid}, excercieseMapper);
    }

    public List<ExcercieseEntityP> getList(Integer limit, Integer offset) {
        Long start = System.currentTimeMillis();
        List<ExcercieseEntityP> e = jdbcTemplate.query("SELECT * FROM excercieses LIMIT ? OFFSET ?", new Object[]{limit, offset}, excercieseMapper);
        statistic.addVal(this.getClass(), "select", System.currentTimeMillis() - start);
        return e;
    }

    public List<ExcercieseEntityP> getListByLevel(Integer level, Integer limit, Integer offset) {
        Long start = System.currentTimeMillis();
        List<ExcercieseEntityP> e = jdbcTemplate.query("SELECT * FROM excercieses WHERE level_ = ? LIMIT ? OFFSET ?",
                new Object[]{level, limit, offset}, excercieseMapper);
        statistic.addVal(this.getClass(), "select", System.currentTimeMillis() - start);
        return e;
    }

    public List<ExcercieseEntityP> getListByType(String type, Integer limit, Integer offset) {
        return jdbcTemplate.query("SELECT * FROM excercieses WHERE type_ = ? LIMIT ? OFFSET ?",
                new Object[]{type, limit, offset}, excercieseMapper);
    }

    public List<ExcercieseEntityP> getListByTypeAndLevel(Integer level, String type, Integer limit, Integer offset) {
        return jdbcTemplate.query("SELECT * FROM excercieses WHERE level_ = ? and type_ = ? LIMIT ? OFFSET ?",
                new Object[]{level, type, limit, offset}, excercieseMapper);
    }

}
