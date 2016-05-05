package com.mykhaylenko.jdbcspring.spring.repository;

import com.mykhaylenko.jdbcspring.model.User;

/**
 * Created by Pavlo.Mykhaylenko on 4/20/2016.
 */
public interface UserRepository {

    long create (User obj);

    User read(long id);

    void update(User obj);

    void delete(User obj);
}
