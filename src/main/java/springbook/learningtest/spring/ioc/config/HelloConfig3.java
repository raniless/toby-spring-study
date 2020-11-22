package springbook.learningtest.spring.ioc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import springbook.learningtest.spring.ioc.bean.Hello;
import springbook.learningtest.spring.ioc.bean.Printer;
import springbook.learningtest.spring.ioc.bean.StringPrinter;

public class HelloConfig3 {
    @Autowired
    private Printer printer;

    @Bean
    public Hello hello() {
        Hello hello = new Hello();
        hello.setName("Spring");
        hello.setPrinter(printer);
        return hello;
    }

    @Bean
    public Hello hello2() {
        Hello hello = new Hello();
        hello.setName("Spring2");
        hello.setPrinter(printer);
        return hello;
    }

    @Bean
    public Printer printer() {
        return new StringPrinter();
    }
}
