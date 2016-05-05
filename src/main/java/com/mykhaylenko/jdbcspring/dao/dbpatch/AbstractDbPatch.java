package com.mykhaylenko.jdbcspring.dao.dbpatch;

import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Pavlo.Mykhaylenko on 4/14/2016.
 */
public abstract class AbstractDbPatch implements DbPatch {

    @Autowired
    private DataSource dataSource;


    protected void excecuteUpdateQuery(String sql) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection =  dataSource.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }

    protected void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
