package com.mykhaylenko.jdbcspring.dao.dbpatch;

/**
 * Created by Pavlo.Mykhaylenko on 4/14/2016.
 */
public interface DbPatch {

    void createDb(String sql);

    void createTable(String sql);
}
