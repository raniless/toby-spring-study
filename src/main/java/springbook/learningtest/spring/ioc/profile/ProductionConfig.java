package springbook.learningtest.spring.ioc.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springbook.learningtest.spring.ioc.bean.Hello;
import springbook.learningtest.spring.ioc.bean.Printer;

@Configuration
@Profile("production")
public class ProductionConfig {
    @Autowired
    private Printer printer;

    @Bean
    public Hello hello() {
        Hello hello = new Hello();
        hello.setName("Production Spring");
        hello.setPrinter(printer);
        return hello;
    }
}
