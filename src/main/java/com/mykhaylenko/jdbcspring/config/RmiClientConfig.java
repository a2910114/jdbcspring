package com.mykhaylenko.jdbcspring.config;

import com.mykhaylenko.jdbcspring.rmiservice.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * Created by Pavlo.Mykhaylenko on 4/27/2016.
 */
public class RmiClientConfig {

    @Bean
    public RmiProxyFactoryBean rmiProxyFactoryBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://10.105.30.61:1099/UserService");
        rmiProxyFactoryBean.setServiceInterface(UserService.class);
        return rmiProxyFactoryBean;
    }
}
