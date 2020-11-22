package springbook.learningtest.spring.ioc.bean;

import org.springframework.stereotype.Component;

@Component("myAnnotatedHelloNamed")
public class AnnotatedHelloNamed {
    public String sayHello() {
        return "AnnotatedHelloNamed Class";
    }
}