package springbook.learningtest.spring.ioc.scope;

import org.springframework.beans.factory.annotation.Autowired;

public class PrototypeClientBean {
    @Autowired
    PrototypeBean bean1;
    @Autowired
    PrototypeBean bean2;
}
