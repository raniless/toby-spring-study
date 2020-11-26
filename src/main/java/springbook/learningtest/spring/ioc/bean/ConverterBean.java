package springbook.learningtest.spring.ioc.bean;

import org.springframework.beans.factory.annotation.Value;

public class ConverterBean {
    @Value("Hyoks")
    private Hello hello;

    public Hello getHello() {
        return hello;
    }
}