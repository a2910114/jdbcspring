package com.mykhaylenko.jdbcspring.dao;

import java.io.Serializable;

/**
 * Created by Pavlo.Mykhaylenko on 4/14/2016.
 */
public interface AbstractDao<T extends Serializable, PK extends Serializable> {

    PK create (T obj);

    T read(PK id);

    void update(T obj);

    void delete(T obj);
}
