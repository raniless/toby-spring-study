package springbook.learningtest.spring.ioc.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springbook.learningtest.spring.ioc.bean.Hello;
import springbook.learningtest.spring.ioc.bean.Printer;

@Configuration
@Profile("local")
public class LocalConfig {
    @Autowired
    private Printer printer;

    @Bean
    public Hello hello() {
        Hello hello = new Hello();
        hello.setName("Local Spring");
        hello.setPrinter(printer);
        return hello;
    }
}
