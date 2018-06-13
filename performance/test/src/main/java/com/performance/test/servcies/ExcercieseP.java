package com.performance.test.servcies;

import com.performance.test.entities.AnswerEntity;
import com.performance.test.entities.ExcercieseEntityP;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;


@Service
public class ExcercieseP {
    private final JdbcTemplate jdbcTemplate;

    public ExcercieseP(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private List<String> convertArray(Array array) {
        try {
//            List<Object> rAList = Arrays.asList(array.getArray());
            String[] stringArr = (String[]) array.getArray();
            return Arrays.asList(stringArr);
//            return rALi*/st.stream()
//                    .filter(String.class::isInstance)
//                    .map(String.class::cast)
//                    .collect(toList());
        } catch (SQLException e) {
            return null;
        }
    }

    private RowMapper<ExcercieseEntityP> excercieseMapper = (rs, row) -> {
        final List<String> answers = convertArray(rs.getArray("answers"));
        final List<String> rightAnswer = convertArray(rs.getArray("rightAnswers"));
        return new ExcercieseEntityP(rs.getString("question"), answers, rightAnswer,
                rs.getString("image"), rs.getString("type_"), rs.getInt("level_"));
    };


    // todo insert
    // todo get one
    // todo get list

    public void save(ExcercieseEntityP excerciese) {
        final String insert = "INSERT into excercieses(question, answers, rightAnswers, image, type_, level_) " +
                "values(?, ?, ?, ?, ?, ?)";
        String[] answers = excerciese.getAnswers().toArray(new String[0]);
        String[] rightAnswers = excerciese.getRightAnswers().toArray(new String[0]);
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {
            Array ansersArr = conn.createArrayOf("TEXT", answers);
            Array rightAnswersArr = conn.createArrayOf("TEXT", rightAnswers);
            try (PreparedStatement preparedStatement = conn.prepareStatement(insert)) {
                preparedStatement.setString(1, excerciese.getQuestion());
                preparedStatement.setArray(2, ansersArr);
                preparedStatement.setArray(3, rightAnswersArr);
                preparedStatement.setString(4, excerciese.getImage());
                preparedStatement.setString(5, excerciese.getType());
                preparedStatement.setInt(6, excerciese.getLevel());
                preparedStatement.execute();
            } catch (SQLException e) {

            }
        } catch (SQLException e) {

        }
    }

    public ExcercieseEntityP getOne(String id) {
        Integer iid = Integer.valueOf(id);
        String select = "SELECT * FROM excercieses WHERE id = ?";
        return jdbcTemplate.queryForObject(select, new Object[]{iid}, excercieseMapper);
    }

    public List<ExcercieseEntityP> getList(Integer limit, Integer offset) {
        return jdbcTemplate.query("SELECT * FROM excercieses LIMIT ? OFFSET ?", new Object[]{limit, offset}, excercieseMapper);
    }

    public List<ExcercieseEntityP> getListByLevel(Integer level, Integer limit, Integer offset) {
        return jdbcTemplate.query("SELECT * FROM excercieses WHERE level_ = ? LIMIT ? OFFSET ?",
                new Object[]{level, limit, offset}, excercieseMapper);
    }

    public List<ExcercieseEntityP> getListByType(String type, Integer limit, Integer offset) {
        return jdbcTemplate.query("SELECT * FROM excercieses WHERE type_ = ? LIMIT ? OFFSET ?",
                new Object[]{type, limit, offset}, excercieseMapper);
    }
    public List<ExcercieseEntityP> getListByTypeAndLevel(Integer level,  String type, Integer limit, Integer offset) {
        return jdbcTemplate.query("SELECT * FROM excercieses WHERE level_ = ? and type_ = ? LIMIT ? OFFSET ?",
                new Object[]{level, type, limit, offset}, excercieseMapper);
    }

}
