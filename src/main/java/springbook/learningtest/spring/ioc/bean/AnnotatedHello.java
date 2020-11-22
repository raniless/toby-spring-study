package springbook.learningtest.spring.ioc.bean;

import org.springframework.stereotype.Component;

@Component
public class AnnotatedHello {
    public String sayHello() {
        return "AnnotatedHello Class";
    }
}