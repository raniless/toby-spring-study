package springbook.learningtest.spring.ioc.converter;

import org.springframework.core.convert.converter.Converter;
import springbook.learningtest.spring.ioc.bean.Hello;

public class MyTypeConverter implements Converter<String, Hello> {

    @Override
    public Hello convert(String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
}