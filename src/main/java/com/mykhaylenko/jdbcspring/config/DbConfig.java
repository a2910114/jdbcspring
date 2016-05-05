package com.mykhaylenko.jdbcspring.config;

import com.mykhaylenko.jdbcspring.dao.AbstractDao;
import com.mykhaylenko.jdbcspring.dao.UserDao;
import com.mykhaylenko.jdbcspring.dao.dbpatch.DbPatch;
import com.mykhaylenko.jdbcspring.dao.dbpatch.DbPatchImpl;
import com.mykhaylenko.jdbcspring.rmiservice.UserService;
import com.mykhaylenko.jdbcspring.rmiservice.UserServiceImpl;
import com.mykhaylenko.jdbcspring.spring.repository.UserRepository;
import com.mykhaylenko.jdbcspring.spring.repository.impl.UserRepositoryImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.remoting.rmi.RmiServiceExporter;

import javax.sql.DataSource;

/**
 * Created by Pavlo.Mykhaylenko on 3/23/2016.
 */

@Configuration
@PropertySource(value = "classpath:database.properties")
public class DbConfig {

    @Value("${db.driver}")
    private String driver;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Value("${db.initial.pool.size}")
    private Integer initialPoolSize;

    @Value("${db.max.pool.size}")
    private Integer maxPoolSize;

    /**
     * Configuration of pooled connection dao source c3p0
     * @return
     */
    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialPoolSize);
        dataSource.setMaxTotal(maxPoolSize);
        return dataSource;
    }

    @Bean
    public AbstractDao abstractDao() {
        AbstractDao abstractDao = new UserDao();
        return abstractDao;
    }

    @Bean
    public DbPatch dbPatch() {
        return new DbPatchImpl();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


//    RMI configs

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public RmiServiceExporter rmiServiceExporter(UserService userService) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setService(userService);
        rmiServiceExporter.setServiceName("UserService");
        rmiServiceExporter.setServiceInterface(UserService.class);

        return rmiServiceExporter;
    }
}
