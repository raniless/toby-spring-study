package springbook.learningtest.spring.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbook.learningtest.spring.ioc.bean.AnnotatedHello;

@Configuration
public class AnnotatedHelloConfig {
    @Bean
    public AnnotatedHello annotatedHello() {
        return new AnnotatedHello();
    }
}
