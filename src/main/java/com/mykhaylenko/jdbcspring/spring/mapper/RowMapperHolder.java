package com.mykhaylenko.jdbcspring.spring.mapper;

import com.mykhaylenko.jdbcspring.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Pavlo.Mykhaylenko on 4/20/2016.
 */
public class RowMapperHolder {

    public static class UserRowMapper implements org.springframework.jdbc.core.RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("role"));
        }
    }
}
