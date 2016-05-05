package com.mykhaylenko.jdbcspring.spring.repository.impl;

import com.mykhaylenko.jdbcspring.dao.Queries;
import com.mykhaylenko.jdbcspring.model.User;
import com.mykhaylenko.jdbcspring.spring.mapper.RowMapperHolder;
import com.mykhaylenko.jdbcspring.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pavlo.Mykhaylenko on 4/20/2016.
 */
//@Repository
public class UserRepositoryImpl implements UserRepository{

    @Autowired
    private JdbcOperations jdbcOperations;

    @Autowired
    private NamedParameterJdbcOperations parameterJdbcOperations;

    @Override
    public long create(User obj) {
        jdbcOperations.update(Queries.INSERT_USER, obj.getUsername(), obj.getEmail(), obj.getRole());
        return 0;
    }

    @Override
    public User read(long id) {
        return jdbcOperations.queryForObject(Queries.SELECT_USER, new RowMapperHolder.UserRowMapper(), id);
    }

    @Override
    public void update(User obj) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", obj.getId());
        parameters.put("username", obj.getUsername());
        parameters.put("email", obj.getEmail());
        parameters.put("role", obj.getRole());

        parameterJdbcOperations.update(Queries.UPDATE_USER_NAMED_PARAMETERS, parameters);
    }

    @Override
    public void delete(User obj) {
        jdbcOperations.update(Queries.DELETE_USER, obj.getId());
    }
}
