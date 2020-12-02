package springbook.learningtest.spring.ioc.scope.config;

import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbook.learningtest.spring.ioc.scope.PrototypeBeanFactory;

@Configuration
public class ServiceLocatorConfig {
    @Bean
    public ServiceLocatorFactoryBean prototypeBeanFactory() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        factoryBean.setServiceLocatorInterface(PrototypeBeanFactory.class);
        return factoryBean;
    }
}