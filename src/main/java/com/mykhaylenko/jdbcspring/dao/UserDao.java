package com.mykhaylenko.jdbcspring.dao;

import com.mykhaylenko.jdbcspring.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by Pavlo.Mykhaylenko on 4/14/2016.
 */
//@Component
public class UserDao implements AbstractDao<User, Long> {

    @Autowired
    private DataSource dataSource;

    @Override
    public Long create(User obj) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection =  dataSource.getConnection();
            preparedStatement = connection.prepareStatement(Queries.INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, obj.getUsername());
            preparedStatement.setString(2, obj.getEmail());
            preparedStatement.setString(3, obj.getRole());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            while (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return 0L;
    }

    @Override
    public User read(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection =  dataSource.getConnection();
            preparedStatement = connection.prepareStatement(Queries.SELECT_USER);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long objId = resultSet.getLong("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String role = resultSet.getString("role");
                return new User(objId, username, email, role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }
        return null;
    }

    @Override
    public void update(User obj) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection =  dataSource.getConnection();
            preparedStatement = connection.prepareStatement(Queries.UPDATE_USER);
            preparedStatement.setString(1, obj.getUsername());
            preparedStatement.setString(2, obj.getEmail());
            preparedStatement.setString(3, obj.getRole());
            preparedStatement.setLong(4, obj.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }
    }

    @Override
    public void delete(User obj) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection =  dataSource.getConnection();
            preparedStatement = connection.prepareStatement(Queries.DELETE_USER);
            preparedStatement.setLong(1, obj.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }
    }

    private void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
