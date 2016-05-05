package com.mykhaylenko.jdbcspring.dao;

/**
 * Created by Pavlo.Mykhaylenko on 4/14/2016.
 */
public interface Queries {
    String CREATE_DATABASE = "create database if not exists jdbcspring;";

    String CREATE_TABLE_TEMP = "create table if not exists jdbcspring.temp (\n" +
            "    id int not null primary key," +
            "    data varchar(255));";

    String CREATE_TABLE_USERS = "create table if not exists jdbcspring.USERS (\n" +
            "    ID int not null primary key auto_increment,\n" +
            "    USERNAME varchar(255) not null unique key,\n" +
            "    EMAIL varchar(255),\n" +
            "    ROLE varchar(30)\n);";

    String INSERT_USER = "insert into jdbcspring.users (username, email, role) " +
            "values (?, ?, ?)";

    String SELECT_USER = "select * from jdbcspring.users where id = ?";

    String UPDATE_USER = "update jdbcspring.users set username = ?, email = ?, role = ? " +
            "where id = ?";

    String UPDATE_USER_NAMED_PARAMETERS = "update jdbcspring.users set username = :username, email = :email, role = :role " +
            "where id = :id";

    String DELETE_USER = "delete from jdbcspring.users where id = ?";

}
