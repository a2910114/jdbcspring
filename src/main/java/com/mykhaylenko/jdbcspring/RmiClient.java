package com.mykhaylenko.jdbcspring;

import com.mykhaylenko.jdbcspring.config.RmiClientConfig;
import com.mykhaylenko.jdbcspring.rmiservice.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Pavlo.Mykhaylenko on 4/27/2016.
 */
public class RmiClient {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RmiClientConfig.class);
        UserService userService = (UserService) applicationContext.getBean(UserService.class);
        System.out.println(userService.getUser(0));
        userService.addUser("user2");
        System.out.println(userService.getUser(1));
    }
}
