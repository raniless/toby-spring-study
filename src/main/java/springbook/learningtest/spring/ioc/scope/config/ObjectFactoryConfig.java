package springbook.learningtest.spring.ioc.scope.config;

import org.springframework.beans.factory.config.ObjectFactoryCreatingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectFactoryConfig {
    @Bean
    public ObjectFactoryCreatingFactoryBean prototypeBeanFactory() {
        ObjectFactoryCreatingFactoryBean factoryBean = new ObjectFactoryCreatingFactoryBean();
        factoryBean.setTargetBeanName("prototypeBean");
        return factoryBean;
    }
}