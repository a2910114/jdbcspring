package com.mykhaylenko.jdbcspring.rmiservice;

/**
 * Created by Pavlo.Mykhaylenko on 4/27/2016.
 */
public interface UserService {

    void addUser(String username);

    String getUser(int index);
}
