package springbook.learningtest.spring.ioc.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springbook.learningtest.spring.ioc.bean.Hello;

@Configuration
@PropertySource("database.properties")
public class ConfigProperty {
    @Value("${db.username}")
    private String name;

    @Bean
    public Hello hello() {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    @Bean
    public Hello hello2(@Value("${db.username}") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
}