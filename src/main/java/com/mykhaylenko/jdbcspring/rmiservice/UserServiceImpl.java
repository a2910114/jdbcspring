package com.mykhaylenko.jdbcspring.rmiservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Pavlo.Mykhaylenko on 4/27/2016.
 */
public class UserServiceImpl implements UserService{

    private List<String> users;

    public UserServiceImpl() {
        users = new ArrayList<>();
        users.add("user1");
    }

    @Override
    public void addUser(String username) {
        users.add(username);
    }

    @Override
    public String getUser(int index) {
        return users.get(index);
    }
}
