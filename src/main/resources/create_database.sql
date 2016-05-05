create database if not exists jdbcspring character set = utf8 collation = utf8_general_ci; -- this charsets is default for mysql server
create database if not exists jdbcspring;

create table jdbcspring.temp (
    id int not null primary key, -- primary key isn't auto generated((( need to use auto_increment
    data varchar(255)
);

create table jdbcspring.USERS (
    ID int not null primary key auto_increment,
    USERNAME varchar(255) not null unique key,
    EMAIL varchar(255),
    ROLE varchar(30)
);