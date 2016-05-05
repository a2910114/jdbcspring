package com.mykhaylenko.jdbcspring;

import com.mykhaylenko.jdbcspring.config.DbConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Pavlo.Mykhaylenko on 4/27/2016.
 */
public class RmiMain {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(DbConfig.class);
    }
}
