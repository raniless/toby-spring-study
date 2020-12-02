package springbook.learningtest.spring.ioc.scope;

import org.springframework.beans.factory.annotation.Autowired;

public class SingletonClientBean {
    @Autowired
    SingletonBean bean1;
    @Autowired
    SingletonBean bean2;
}
