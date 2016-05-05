package com.mykhaylenko.jdbcspring.dao.dbpatch;

import com.mykhaylenko.jdbcspring.dao.Queries;
import com.mykhaylenko.jdbcspring.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by Pavlo.Mykhaylenko on 4/14/2016.
 */
public class DbPatchImpl extends AbstractDbPatch {

    @Override
    public void createDb(String sql) {
        excecuteUpdateQuery(sql);
    }

    @Override
    public void createTable(String sql) {
        excecuteUpdateQuery(sql);
    }
}
