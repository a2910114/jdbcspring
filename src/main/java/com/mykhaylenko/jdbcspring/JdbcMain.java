package com.mykhaylenko.jdbcspring;

import com.mykhaylenko.jdbcspring.config.DbConfig;
import com.mykhaylenko.jdbcspring.dao.Queries;
import com.mykhaylenko.jdbcspring.dao.UserDao;
import com.mykhaylenko.jdbcspring.dao.dbpatch.DbPatch;
import com.mykhaylenko.jdbcspring.model.User;
import com.mykhaylenko.jdbcspring.spring.repository.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Pavlo.Mykhaylenko on 4/14/2016.
 */
public class JdbcMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DbConfig.class);
        //TODO: clear jdbc example
//        DbPatch dbPatch = applicationContext.getBean(DbPatch.class);
//        dbPatch.createTable(Queries.CREATE_TABLE_USERS);

//        UserDao userDao = applicationContext.getBean(UserDao.class);
//        User userToInsert = new User();
//        userToInsert.setUsername("first");
//        userToInsert.setEmail("first@mail.com");
//        userToInsert.setRole("USER_ROLE");
//
//        long id = userDao.create(userToInsert);
//        System.out.printf("created user id: %d", id);

//        User user = userDao.read((long) id);
//        user.setRole("ADMIN_ROLE");
//        userDao.update(user);
//        user = userDao.read(1L);
//        printUser(user);
//        userDao.delete(user);
//        TODO: spring jdbc Example
//        User user = new User();
//        user.setUsername("SpringUser");
//        user.setEmail("SpringUser@mail.com");
//        user.setRole("USER_ROLE");

//        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
//        userRepository.create(user);
//        User user1 = userRepository.read(9);
//        printUser(user1);
//        user1.setUsername("SpringUpdated");
//        userRepository.update(user1);
//        userRepository.delete(user1);

        System.out.printf("Domain[%s]", null);
    }

    private static void printUser(User user) {
        if (user != null) {
            System.out.printf("User id=%d, username=%s, email=%s, role=%s\n",
                    user.getId(), user.getUsername(), user.getEmail(), user.getRole());
        }
    }
}
